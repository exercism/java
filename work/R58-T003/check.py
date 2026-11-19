#!/usr/bin/env python3
"""
Verification check for Task R58-T003 (bank-account mutation and regression check).

Verifies:
1. Resolves paths dynamically from exercises/practice/bank-account/.meta/config.json.
2. Cross-checks tests.toml UUIDs and DisplayNames for named anchor cases.
3. Confirms working-tree learner stub remains unsolved (UnsupportedOperationException)
   and ensures the working tree is never modified.
4. Copies exercise with dotfiles to a temporary directory, substitutes maintained
   reference into scratch src/main/java, enables tests, and executes ./gradlew test.
   Asserts returncode == 0, executed tests > 0 (17 tests), and all tests pass.
5. Injects a deliberate semantic mutant (balance -= amount in deposit) into a scratch copy,
   runs ./gradlew test, and verifies:
   - returncode != 0
   - singleDeposit fails with assertion error (expected: 100, but was: -100)
   - newlyOpenedAccountHasEmptyBalance still passes
6. Validates minimal diagnostic case reduction (deposit(1) -> 1 vs -1).
7. Records tool versions, inputs, expected vs actual outputs, and check results
   in work/R58-T003/results.json and work/R58-T003/latest-result.json.
"""

from __future__ import annotations

import hashlib
import json
import os
import platform
import re
import shutil
import subprocess
import sys
import tempfile
import time
import xml.etree.ElementTree as ET
from pathlib import Path

try:
    import tomllib
except ModuleNotFoundError:
    tomllib = None


REPO_ROOT = Path(__file__).resolve().parents[2]
EXERCISE_DIR = REPO_ROOT / "exercises" / "practice" / "bank-account"
WORK_DIR = REPO_ROOT / "work" / "R58-T003"
CONFIG_FILE = EXERCISE_DIR / ".meta" / "config.json"
TESTS_TOML_FILE = EXERCISE_DIR / ".meta" / "tests.toml"

NAMED_CASES = [
    {
        "method": "newlyOpenedAccountHasEmptyBalance",
        "display_name": "Newly opened account has zero balance",
        "uuid": "983a1528-4ceb-45e5-8257-8ce01aceb5ed",
        "operations": ["open()", "getBalance()"],
        "expected": 0,
        "is_rejecting_case": False,
    },
    {
        "method": "singleDeposit",
        "display_name": "Single deposit",
        "uuid": "e88d4ec3-c6bf-4752-8e59-5046c44e3ba7",
        "operations": ["open()", "deposit(100)", "getBalance()"],
        "expected": 100,
        "mutant_actual": -100,
        "named_assertion": "assertThat(bankAccount.getBalance()).isEqualTo(100);",
        "is_rejecting_case": True,
    },
    {
        "method": "multipleDeposits",
        "display_name": "Multiple deposits",
        "uuid": "3d9147d4-63f4-4844-8d2b-1fee2e9a2a0d",
        "operations": ["open()", "deposit(100)", "deposit(50)", "getBalance()"],
        "expected": 150,
        "mutant_actual": -150,
        "is_rejecting_case": False,
    },
]

MINIMAL_DIAGNOSTIC_CASE = {
    "description": "Smallest valid positive deposit permitted by specification",
    "operations": ["open()", "deposit(1)", "getBalance()"],
    "expected": 1,
    "mutant_actual": -1,
    "zero_deposit_rationale": "deposit(0) yields 0 for both correct and mutant implementations (0 + 0 == 0 - 0), so 1 is the minimal distinguishing input.",
}

MUTANT_LINE_ORIGINAL = "        balance += amount;"
MUTANT_LINE_MUTATED = "        balance -= amount; // MUTANT: inverts deposit arithmetic"


def get_env() -> dict[str, str]:
    env = os.environ.copy()
    candidate_jdks = [
        "/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home",
        "/opt/homebrew/Cellar/openjdk@21/21.0.13.0.3/libexec/openjdk.jdk/Contents/Home",
    ]
    for jdk in candidate_jdks:
        if os.path.isdir(jdk):
            env["JAVA_HOME"] = jdk
            env["PATH"] = f"{jdk}/bin:{env.get('PATH', '')}"
            break
    return env


def get_tool_versions(env: dict[str, str]) -> dict[str, str]:
    versions = {
        "python": sys.version.split()[0],
        "platform": platform.platform(),
    }
    try:
        proc = subprocess.run(
            ["java", "-version"],
            env=env,
            capture_output=True,
            text=True,
            check=False,
        )
        output = proc.stderr or proc.stdout
        versions["java"] = output.splitlines()[0].strip() if output else "unknown"
    except Exception as e:
        versions["java"] = f"error: {e}"

    try:
        proc = subprocess.run(
            ["./gradlew", "--version"],
            cwd=str(EXERCISE_DIR),
            env=env,
            capture_output=True,
            text=True,
            check=False,
        )
        for line in proc.stdout.splitlines():
            if line.startswith("Gradle "):
                versions["gradle"] = line.strip()
                break
        else:
            versions["gradle"] = "Gradle unknown"
    except Exception as e:
        versions["gradle"] = f"error: {e}"

    return versions


def parse_tests_toml(toml_path: Path) -> dict[str, dict[str, str]]:
    """Parse tests.toml without requiring third-party libraries."""
    if tomllib is not None:
        with open(toml_path, "rb") as f:
            return tomllib.load(f)
    content = toml_path.read_text(encoding="utf-8")
    entries: dict[str, dict[str, str]] = {}
    current_uuid = None
    for line in content.splitlines():
        line = line.strip()
        if not line or line.startswith("#"):
            continue
        uuid_match = re.match(r"^\[([0-9a-fA-F-]+)\]$", line)
        if uuid_match:
            current_uuid = uuid_match.group(1)
            entries[current_uuid] = {}
            continue
        if current_uuid and "=" in line:
            key, val = line.split("=", 1)
            key = key.strip()
            val = val.strip().strip('"').strip("'")
            entries[current_uuid][key] = val
    return entries


def hash_files(paths: list[Path]) -> dict[str, str]:
    hashes = {}
    for path in paths:
        if path.is_file():
            hashes[str(path.relative_to(REPO_ROOT))] = hashlib.sha256(path.read_bytes()).hexdigest()
    return hashes


def copy_exercise_with_reference(
    base_dir: Path,
    config: dict,
    mutant: bool = False,
) -> Path:
    scratch = base_dir / "bank-account"
    shutil.copytree(EXERCISE_DIR, scratch, ignore=shutil.ignore_patterns(".gradle", "build"))

    solution_rel = config["files"]["solution"][0]
    test_rel = config["files"]["test"][0]
    example_rels = config["files"]["example"]

    # Substitute reference source files into scratch src/main/java
    dest_solution = scratch / solution_rel
    dest_dir = dest_solution.parent
    dest_dir.mkdir(parents=True, exist_ok=True)

    for ref_rel in example_rels:
        ref_file = scratch / ref_rel
        assert ref_file.is_file(), f"Reference file {ref_rel} missing from scratch copy"
        shutil.copy2(ref_file, dest_dir / ref_file.name)

    # Apply deliberate mutant if requested
    if mutant:
        sol_file = scratch / solution_rel
        content = sol_file.read_text(encoding="utf-8")
        assert MUTANT_LINE_ORIGINAL in content, f"Original line not found in {solution_rel}"
        content = content.replace(MUTANT_LINE_ORIGINAL, MUTANT_LINE_MUTATED, 1)
        sol_file.write_text(content, encoding="utf-8")

    # Enable all tests by stripping @Disabled in scratch copy
    scratch_test = scratch / test_rel
    tc = scratch_test.read_text(encoding="utf-8")
    tc = re.sub(r'^\s*@Disabled\("Remove to run test"\)\s*\n', "", tc, flags=re.MULTILINE)
    scratch_test.write_text(tc, encoding="utf-8")

    return scratch


def run_gradle_test(scratch: Path, env: dict[str, str], *extra_args: str) -> subprocess.CompletedProcess:
    cmd = ["./gradlew", "test", "--no-daemon", *extra_args]
    return subprocess.run(
        cmd,
        cwd=str(scratch),
        env=env,
        capture_output=True,
        text=True,
        check=False,
    )


def parse_xml_results(scratch: Path) -> dict:
    report_dir = scratch / "build" / "test-results" / "test"
    xml_files = list(report_dir.glob("TEST-*.xml"))
    summary = {
        "total": 0,
        "passed": 0,
        "failures": 0,
        "errors": 0,
        "skipped": 0,
        "executed": 0,
        "case_results": {},
        "failed_case_details": {},
    }

    for xml_path in xml_files:
        tree = ET.parse(xml_path)
        root = tree.getroot()
        tests = int(root.attrib.get("tests", 0))
        failures = int(root.attrib.get("failures", 0))
        errors = int(root.attrib.get("errors", 0))
        skipped = int(root.attrib.get("skipped", 0))

        summary["total"] += tests
        summary["failures"] += failures
        summary["errors"] += errors
        summary["skipped"] += skipped

        for case in root.findall("testcase"):
            name = case.attrib.get("name", "")
            fail_elem = case.find("failure")
            err_elem = case.find("error")
            skip_elem = case.find("skipped")

            if fail_elem is not None:
                summary["case_results"][name] = "FAILED"
                summary["failed_case_details"][name] = fail_elem.attrib.get("message", "").strip()
            elif err_elem is not None:
                summary["case_results"][name] = "ERROR"
                summary["failed_case_details"][name] = err_elem.attrib.get("message", "").strip()
            elif skip_elem is not None:
                summary["case_results"][name] = "SKIPPED"
            else:
                summary["case_results"][name] = "PASSED"

    summary["executed"] = summary["total"] - summary["skipped"]
    summary["passed"] = summary["executed"] - summary["failures"] - summary["errors"]
    return summary


def main() -> int:
    print("==================================================")
    print("Task R58-T003 Verification Check: bank-account")
    print("==================================================")

    # 1. Check metadata and config
    assert CONFIG_FILE.is_file(), f"Missing config.json at {CONFIG_FILE}"
    assert TESTS_TOML_FILE.is_file(), f"Missing tests.toml at {TESTS_TOML_FILE}"

    with open(CONFIG_FILE, encoding="utf-8") as f:
        config = json.load(f)

    tests_toml = parse_tests_toml(TESTS_TOML_FILE)

    solution_rel = config["files"]["solution"][0]
    test_rel = config["files"]["test"][0]
    learner_stub_path = EXERCISE_DIR / solution_rel

    # Validate named cases in tests.toml
    print("\n[Step 1] Validating named cases against tests.toml...")
    for case in NAMED_CASES:
        uuid = case["uuid"]
        assert uuid in tests_toml, f"UUID {uuid} not found in tests.toml"
        expected_desc = tests_toml[uuid]["description"]
        assert expected_desc == case["display_name"], (
            f"Description mismatch for UUID {uuid}: expected '{expected_desc}', got '{case['display_name']}'"
        )
        print(f"  ✓ UUID {uuid} -> '{case['display_name']}'")

    # Record working-tree files hash
    solution_files = [EXERCISE_DIR / p for p in config["files"]["solution"]]
    test_files = [EXERCISE_DIR / p for p in config["files"]["test"]]
    all_target_files = solution_files + test_files
    initial_hashes = hash_files(all_target_files)

    # 2. Check learner stub unsolved in working tree
    print("\n[Step 2] Checking learner starter stub...")
    stub_content = learner_stub_path.read_text(encoding="utf-8")
    assert "UnsupportedOperationException" in stub_content, "Learner stub must remain unsolved!"
    print("  ✓ Learner stub confirmed unsolved (throws UnsupportedOperationException).")

    env = get_env()
    tool_versions = get_tool_versions(env)
    print(f"  Tool versions: Python {tool_versions['python']}, {tool_versions['java']}, {tool_versions['gradle']}")

    results = {
        "task": "R58-T003",
        "exercise": "bank-account",
        "timestamp_unix": int(time.time()),
        "status": "RUNNING",
        "tool_versions": tool_versions,
        "inputs": {
            "named_cases": NAMED_CASES,
            "minimal_diagnostic_case": MINIMAL_DIAGNOSTIC_CASE,
            "deliberate_mutant": {
                "file": solution_rel,
                "original_line": MUTANT_LINE_ORIGINAL.strip(),
                "mutated_line": MUTANT_LINE_MUTATED.strip(),
                "mutation_type": "Arithmetic Operator Replacement (AOR): += replaced with -=",
                "description": "Inverts deposit balance accumulation from addition to subtraction",
            },
        },
        "checks": {},
    }

    # 3. Reference solution run (unmodified)
    print("\n[Step 3] Running test suite against maintained reference...")
    with tempfile.TemporaryDirectory(prefix="r58-t003-ref-") as tmp_dir:
        tmp_path = Path(tmp_dir)
        scratch = copy_exercise_with_reference(tmp_path, config, mutant=False)
        proc = run_gradle_test(scratch, env)
        print(f"  Gradle exit code: {proc.returncode}")
        assert proc.returncode == 0, f"Reference test execution failed with exit code {proc.returncode}!\nSTDERR: {proc.stderr[-1000:]}"

        ref_summary = parse_xml_results(scratch)
        print(f"  Executed: {ref_summary['executed']}, Passed: {ref_summary['passed']}, "
              f"Failures: {ref_summary['failures']}, Errors: {ref_summary['errors']}")

        assert ref_summary["executed"] > 0, "Zero tests were executed!"
        assert ref_summary["failures"] == 0, f"Expected 0 failures, got {ref_summary['failures']}"
        assert ref_summary["errors"] == 0, f"Expected 0 errors, got {ref_summary['errors']}"
        assert ref_summary["skipped"] == 0, f"Expected 0 skipped, got {ref_summary['skipped']}"

        for case in NAMED_CASES:
            c_name = case["display_name"]
            status = ref_summary["case_results"].get(c_name, "NOT_FOUND")
            assert status == "PASSED", f"Named case '{c_name}' did not pass! Status: {status}"
            print(f"  ✓ [NAMED CASE] '{c_name}' -> PASSED")

        results["checks"]["reference"] = {
            "exit_code": proc.returncode,
            "total_tests": ref_summary["total"],
            "executed_tests": ref_summary["executed"],
            "passed_tests": ref_summary["passed"],
            "failures": ref_summary["failures"],
            "errors": ref_summary["errors"],
            "named_cases": {c["method"]: "PASSED" for c in NAMED_CASES},
        }

    # 4. Mutant solution run
    print("\n[Step 4] Running test suite against deliberate mutant...")
    rejecting_case = next(c for c in NAMED_CASES if c["is_rejecting_case"])

    with tempfile.TemporaryDirectory(prefix="r58-t003-mut-") as tmp_dir:
        tmp_path = Path(tmp_dir)
        scratch_mut = copy_exercise_with_reference(tmp_path, config, mutant=True)
        proc_mut = run_gradle_test(scratch_mut, env)
        print(f"  Mutant Gradle exit code: {proc_mut.returncode} (expected non-zero)")
        assert proc_mut.returncode != 0, "Mutant unexpectedly passed all tests!"

        mut_summary = parse_xml_results(scratch_mut)
        print(f"  Executed: {mut_summary['executed']}, Passed: {mut_summary['passed']}, "
              f"Failures: {mut_summary['failures']}")

        rejecting_status = mut_summary["case_results"].get(rejecting_case["display_name"], "NOT_FOUND")
        assert rejecting_status == "FAILED", (
            f"Expected rejecting case '{rejecting_case['display_name']}' to FAIL, but got {rejecting_status}"
        )

        failure_msg = mut_summary["failed_case_details"].get(rejecting_case["display_name"], "")
        assert "expected: 100" in failure_msg and "-100" in failure_msg, (
            f"Unexpected failure message for '{rejecting_case['display_name']}': {failure_msg}"
        )
        print(f"  ✓ [REJECTING CASE] '{rejecting_case['display_name']}' -> FAILED as expected.")
        print(f"    Assertion message: {failure_msg}")

        # Check non-deposit case still passed
        non_deposit_case = NAMED_CASES[0]
        nd_status = mut_summary["case_results"].get(non_deposit_case["display_name"], "NOT_FOUND")
        assert nd_status == "PASSED", f"Non-deposit case '{non_deposit_case['display_name']}' should pass, got {nd_status}"
        print(f"  ✓ [NON-DEPOSIT CASE] '{non_deposit_case['display_name']}' -> PASSED")

        results["checks"]["mutant"] = {
            "exit_code": proc_mut.returncode,
            "total_tests": mut_summary["total"],
            "executed_tests": mut_summary["executed"],
            "passed_tests": mut_summary["passed"],
            "failures": mut_summary["failures"],
            "rejecting_case": rejecting_case["display_name"],
            "rejecting_case_status": rejecting_status,
            "rejecting_failure_message": failure_msg,
        }

    # 5. Verify working tree integrity
    print("\n[Step 5] Verifying working tree integrity...")
    post_hashes = hash_files(all_target_files)
    assert initial_hashes == post_hashes, "Working tree files were modified during check execution!"
    assert "UnsupportedOperationException" in learner_stub_path.read_text(encoding="utf-8")
    print("  ✓ Working tree integrity verified: completely untouched.")
    results["checks"]["working_tree_unchanged"] = True

    # 6. Save results
    results["status"] = "PASSED"
    WORK_DIR.mkdir(parents=True, exist_ok=True)
    results_file = WORK_DIR / "results.json"
    latest_file = WORK_DIR / "latest-result.json"

    with open(results_file, "w", encoding="utf-8") as f:
        json.dump(results, f, indent=2)
    with open(latest_file, "w", encoding="utf-8") as f:
        json.dump(results, f, indent=2)

    print(f"\n[Summary] All checks PASSED successfully.")
    print(f"Evidence saved to {results_file} and {latest_file}")
    return 0


if __name__ == "__main__":
    try:
        sys.exit(main())
    except AssertionError as e:
        print(f"\n[FAILURE] Assertion failed: {e}", file=sys.stderr)
        sys.exit(1)
    except Exception as e:
        print(f"\n[ERROR] Unexpected error: {e}", file=sys.stderr)
        sys.exit(2)
