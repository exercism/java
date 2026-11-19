#!/usr/bin/env python3
"""
Course verification entry point for Task R58-T003 (bank-account).
Delegates to work/R58-T003/check.py.

Usage: python3 tools/course_checks/r58-t003.py
"""

import os
import sys
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parents[2]
CHECK_SCRIPT = REPO_ROOT / "work" / "R58-T003" / "check.py"

if __name__ == "__main__":
    if not CHECK_SCRIPT.is_file():
        print(f"Error: check script not found at {CHECK_SCRIPT}", file=sys.stderr)
        sys.exit(2)
    os.execv(sys.executable, [sys.executable, str(CHECK_SCRIPT)] + sys.argv[1:])
