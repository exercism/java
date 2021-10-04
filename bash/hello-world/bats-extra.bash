# This is the source code for bats-support and bats-assert, concatenated
# * https://github.com/bats-core/bats-support
# * https://github.com/bats-core/bats-assert
#
# Comments have been removed to save space. See the git repos for full source code.

############################################################
#
# bats-support - Supporting library for Bats test helpers
#
# Written in 2016 by Zoltan Tombol <zoltan dot tombol at gmail dot com>
#
# To the extent possible under law, the author(s) have dedicated all
# copyright and related and neighboring rights to this software to the
# public domain worldwide. This software is distributed without any
# warranty.
#
# You should have received a copy of the CC0 Public Domain Dedication
# along with this software. If not, see
# <http://creativecommons.org/publicdomain/zero/1.0/>.
#

fail() {
  (( $# == 0 )) && batslib_err || batslib_err "$@"
  return 1
}

batslib_is_caller() {
  local -i is_mode_direct=1

  # Handle options.
  while (( $# > 0 )); do
    case "$1" in
      -i|--indirect) is_mode_direct=0; shift ;;
      --) shift; break ;;
      *) break ;;
    esac
  done

  # Arguments.
  local -r func="$1"

  # Check call stack.
  if (( is_mode_direct )); then
    [[ $func == "${FUNCNAME[2]}" ]] && return 0
  else
    local -i depth
    for (( depth=2; depth<${#FUNCNAME[@]}; ++depth )); do
      [[ $func == "${FUNCNAME[$depth]}" ]] && return 0
    done
  fi

  return 1
}

batslib_err() {
  { if (( $# > 0 )); then
      echo "$@"
    else
      cat -
    fi
  } >&2
}

batslib_count_lines() {
  local -i n_lines=0
  local line
  while IFS='' read -r line || [[ -n $line ]]; do
    (( ++n_lines ))
  done < <(printf '%s' "$1")
  echo "$n_lines"
}

batslib_is_single_line() {
  for string in "$@"; do
    (( $(batslib_count_lines "$string") > 1 )) && return 1
  done
  return 0
}

batslib_get_max_single_line_key_width() {
  local -i max_len=-1
  while (( $# != 0 )); do
    local -i key_len="${#1}"
    batslib_is_single_line "$2" && (( key_len > max_len )) && max_len="$key_len"
    shift 2
  done
  echo "$max_len"
}

batslib_print_kv_single() {
  local -ir col_width="$1"; shift
  while (( $# != 0 )); do
    printf '%-*s : %s\n' "$col_width" "$1" "$2"
    shift 2
  done
}

batslib_print_kv_multi() {
  while (( $# != 0 )); do
    printf '%s (%d lines):\n' "$1" "$( batslib_count_lines "$2" )"
    printf '%s\n' "$2"
    shift 2
  done
}

batslib_print_kv_single_or_multi() {
  local -ir width="$1"; shift
  local -a pairs=( "$@" )

  local -a values=()
  local -i i
  for (( i=1; i < ${#pairs[@]}; i+=2 )); do
    values+=( "${pairs[$i]}" )
  done

  if batslib_is_single_line "${values[@]}"; then
    batslib_print_kv_single "$width" "${pairs[@]}"
  else
    local -i i
    for (( i=1; i < ${#pairs[@]}; i+=2 )); do
      pairs[$i]="$( batslib_prefix < <(printf '%s' "${pairs[$i]}") )"
    done
    batslib_print_kv_multi "${pairs[@]}"
  fi
}

batslib_prefix() {
  local -r prefix="${1:-  }"
  local line
  while IFS='' read -r line || [[ -n $line ]]; do
    printf '%s%s\n' "$prefix" "$line"
  done
}

batslib_mark() {
  local -r symbol="$1"; shift
  # Sort line numbers.
  set -- $( sort -nu <<< "$( printf '%d\n' "$@" )" )

  local line
  local -i idx=0
  while IFS='' read -r line || [[ -n $line ]]; do
    if (( ${1:--1} == idx )); then
      printf '%s\n' "${symbol}${line:${#symbol}}"
      shift
    else
      printf '%s\n' "$line"
    fi
    (( ++idx ))
  done
}

batslib_decorate() {
  echo
  echo "-- $1 --"
  cat -
  echo '--'
  echo
}

############################################################

assert() {
  if ! "$@"; then
    batslib_print_kv_single 10 'expression' "$*" \
    | batslib_decorate 'assertion failed' \
    | fail
  fi
}

assert_equal() {
  if [[ $1 != "$2" ]]; then
    batslib_print_kv_single_or_multi 8 \
    'expected' "$2" \
    'actual'   "$1" \
    | batslib_decorate 'values do not equal' \
    | fail
  fi
}

assert_failure() {
  : "${output?}"
  : "${status?}"

  (( $# > 0 )) && local -r expected="$1"
  if (( status == 0 )); then
    batslib_print_kv_single_or_multi 6 'output' "$output" \
    | batslib_decorate 'command succeeded, but it was expected to fail' \
    | fail
  elif (( $# > 0 )) && (( status != expected )); then
    { local -ir width=8
      batslib_print_kv_single "$width" \
      'expected' "$expected" \
      'actual'   "$status"
      batslib_print_kv_single_or_multi "$width" \
      'output' "$output"
    } \
    | batslib_decorate 'command failed as expected, but status differs' \
    | fail
  fi
}

assert_line() {
  local -i is_match_line=0
  local -i is_mode_partial=0
  local -i is_mode_regexp=0
  : "${lines?}"

  # Handle options.
  while (( $# > 0 )); do
    case "$1" in
    -n|--index)
      if (( $# < 2 )) || ! [[ $2 =~ ^([0-9]|[1-9][0-9]+)$ ]]; then
        echo "\`--index' requires an integer argument: \`$2'" \
        | batslib_decorate 'ERROR: assert_line' \
        | fail
        return $?
      fi
      is_match_line=1
      local -ri idx="$2"
      shift 2
      ;;
    -p|--partial) is_mode_partial=1; shift ;;
    -e|--regexp) is_mode_regexp=1; shift ;;
    --) shift; break ;;
    *) break ;;
    esac
  done

  if (( is_mode_partial )) && (( is_mode_regexp )); then
    echo "\`--partial' and \`--regexp' are mutually exclusive" \
    | batslib_decorate 'ERROR: assert_line' \
    | fail
    return $?
  fi

  # Arguments.
  local -r expected="$1"

  if (( is_mode_regexp == 1 )) && [[ '' =~ $expected ]] || (( $? == 2 )); then
    echo "Invalid extended regular expression: \`$expected'" \
    | batslib_decorate 'ERROR: assert_line' \
    | fail
    return $?
  fi

  # Matching.
  if (( is_match_line )); then
    # Specific line.
    if (( is_mode_regexp )); then
      if ! [[ ${lines[$idx]} =~ $expected ]]; then
        batslib_print_kv_single 6 \
        'index' "$idx" \
        'regexp' "$expected" \
        'line'  "${lines[$idx]}" \
        | batslib_decorate 'regular expression does not match line' \
        | fail
      fi
    elif (( is_mode_partial )); then
      if [[ ${lines[$idx]} != *"$expected"* ]]; then
        batslib_print_kv_single 9 \
        'index'     "$idx" \
        'substring' "$expected" \
        'line'      "${lines[$idx]}" \
        | batslib_decorate 'line does not contain substring' \
        | fail
      fi
    else
      if [[ ${lines[$idx]} != "$expected" ]]; then
        batslib_print_kv_single 8 \
        'index'    "$idx" \
        'expected' "$expected" \
        'actual'   "${lines[$idx]}" \
        | batslib_decorate 'line differs' \
        | fail
      fi
    fi
  else
    # Contained in output.
    if (( is_mode_regexp )); then
      local -i idx
      for (( idx = 0; idx < ${#lines[@]}; ++idx )); do
        [[ ${lines[$idx]} =~ $expected ]] && return 0
      done
      { local -ar single=( 'regexp' "$expected" )
        local -ar may_be_multi=( 'output' "$output" )
        local -ir width="$( batslib_get_max_single_line_key_width "${single[@]}" "${may_be_multi[@]}" )"
        batslib_print_kv_single "$width" "${single[@]}"
        batslib_print_kv_single_or_multi "$width" "${may_be_multi[@]}"
      } \
      | batslib_decorate 'no output line matches regular expression' \
      | fail
    elif (( is_mode_partial )); then
      local -i idx
      for (( idx = 0; idx < ${#lines[@]}; ++idx )); do
        [[ ${lines[$idx]} == *"$expected"* ]] && return 0
      done
      { local -ar single=( 'substring' "$expected" )
        local -ar may_be_multi=( 'output' "$output" )
        local -ir width="$( batslib_get_max_single_line_key_width "${single[@]}" "${may_be_multi[@]}" )"
        batslib_print_kv_single "$width" "${single[@]}"
        batslib_print_kv_single_or_multi "$width" "${may_be_multi[@]}"
      } \
      | batslib_decorate 'no output line contains substring' \
      | fail
    else
      local -i idx
      for (( idx = 0; idx < ${#lines[@]}; ++idx )); do
        [[ ${lines[$idx]} == "$expected" ]] && return 0
      done
      { local -ar single=( 'line' "$expected" )
        local -ar may_be_multi=( 'output' "$output" )
        local -ir width="$( batslib_get_max_single_line_key_width "${single[@]}" "${may_be_multi[@]}" )"
        batslib_print_kv_single "$width" "${single[@]}"
        batslib_print_kv_single_or_multi "$width" "${may_be_multi[@]}"
      } \
      | batslib_decorate 'output does not contain line' \
      | fail
    fi
  fi
}

assert_output() {
  local -i is_mode_partial=0
  local -i is_mode_regexp=0
  local -i is_mode_nonempty=0
  local -i use_stdin=0
  : "${output?}"

  # Handle options.
  if (( $# == 0 )); then
    is_mode_nonempty=1
  fi

  while (( $# > 0 )); do
    case "$1" in
    -p|--partial) is_mode_partial=1; shift ;;
    -e|--regexp) is_mode_regexp=1; shift ;;
    -|--stdin) use_stdin=1; shift ;;
    --) shift; break ;;
    *) break ;;
    esac
  done

  if (( is_mode_partial )) && (( is_mode_regexp )); then
    echo "\`--partial' and \`--regexp' are mutually exclusive" \
    | batslib_decorate 'ERROR: assert_output' \
    | fail
    return $?
  fi

  # Arguments.
  local expected
  if (( use_stdin )); then
    expected="$(cat -)"
  else
    expected="${1-}"
  fi

  # Matching.
  if (( is_mode_nonempty )); then
    if [ -z "$output" ]; then
      echo 'expected non-empty output, but output was empty' \
      | batslib_decorate 'no output' \
      | fail
    fi
  elif (( is_mode_regexp )); then
    if [[ '' =~ $expected ]] || (( $? == 2 )); then
      echo "Invalid extended regular expression: \`$expected'" \
      | batslib_decorate 'ERROR: assert_output' \
      | fail
    elif ! [[ $output =~ $expected ]]; then
      batslib_print_kv_single_or_multi 6 \
      'regexp'  "$expected" \
      'output' "$output" \
      | batslib_decorate 'regular expression does not match output' \
      | fail
    fi
  elif (( is_mode_partial )); then
    if [[ $output != *"$expected"* ]]; then
      batslib_print_kv_single_or_multi 9 \
      'substring' "$expected" \
      'output'    "$output" \
      | batslib_decorate 'output does not contain substring' \
      | fail
    fi
  else
    if [[ $output != "$expected" ]]; then
      batslib_print_kv_single_or_multi 8 \
      'expected' "$expected" \
      'actual'   "$output" \
      | batslib_decorate 'output differs' \
      | fail
    fi
  fi
}

assert_success() {
  : "${output?}"
  : "${status?}"

  if (( status != 0 )); then
    { local -ir width=6
      batslib_print_kv_single "$width" 'status' "$status"
      batslib_print_kv_single_or_multi "$width" 'output' "$output"
    } \
    | batslib_decorate 'command failed' \
    | fail
  fi
}

refute() {
  if "$@"; then
    batslib_print_kv_single 10 'expression' "$*" \
    | batslib_decorate 'assertion succeeded, but it was expected to fail' \
    | fail
  fi
}

refute_line() {
  local -i is_match_line=0
  local -i is_mode_partial=0
  local -i is_mode_regexp=0
  : "${lines?}"

  # Handle options.
  while (( $# > 0 )); do
    case "$1" in
    -n|--index)
      if (( $# < 2 )) || ! [[ $2 =~ ^([0-9]|[1-9][0-9]+)$ ]]; then
        echo "\`--index' requires an integer argument: \`$2'" \
        | batslib_decorate 'ERROR: refute_line' \
        | fail
        return $?
      fi
      is_match_line=1
      local -ri idx="$2"
      shift 2
      ;;
    -p|--partial) is_mode_partial=1; shift ;;
    -e|--regexp) is_mode_regexp=1; shift ;;
    --) shift; break ;;
    *) break ;;
    esac
  done

  if (( is_mode_partial )) && (( is_mode_regexp )); then
    echo "\`--partial' and \`--regexp' are mutually exclusive" \
    | batslib_decorate 'ERROR: refute_line' \
    | fail
    return $?
  fi

  # Arguments.
  local -r unexpected="$1"

  if (( is_mode_regexp == 1 )) && [[ '' =~ $unexpected ]] || (( $? == 2 )); then
    echo "Invalid extended regular expression: \`$unexpected'" \
    | batslib_decorate 'ERROR: refute_line' \
    | fail
    return $?
  fi

  # Matching.
  if (( is_match_line )); then
    # Specific line.
    if (( is_mode_regexp )); then
      if [[ ${lines[$idx]} =~ $unexpected ]]; then
        batslib_print_kv_single 6 \
        'index' "$idx" \
        'regexp' "$unexpected" \
        'line'  "${lines[$idx]}" \
        | batslib_decorate 'regular expression should not match line' \
        | fail
      fi
    elif (( is_mode_partial )); then
      if [[ ${lines[$idx]} == *"$unexpected"* ]]; then
        batslib_print_kv_single 9 \
        'index'     "$idx" \
        'substring' "$unexpected" \
        'line'      "${lines[$idx]}" \
        | batslib_decorate 'line should not contain substring' \
        | fail
      fi
    else
      if [[ ${lines[$idx]} == "$unexpected" ]]; then
        batslib_print_kv_single 5 \
        'index' "$idx" \
        'line'  "${lines[$idx]}" \
        | batslib_decorate 'line should differ' \
        | fail
      fi
    fi
  else
    # Line contained in output.
    if (( is_mode_regexp )); then
      local -i idx
      for (( idx = 0; idx < ${#lines[@]}; ++idx )); do
        if [[ ${lines[$idx]} =~ $unexpected ]]; then
          { local -ar single=( 'regexp' "$unexpected" 'index' "$idx" )
            local -a may_be_multi=( 'output' "$output" )
            local -ir width="$( batslib_get_max_single_line_key_width "${single[@]}" "${may_be_multi[@]}" )"
            batslib_print_kv_single "$width" "${single[@]}"
            if batslib_is_single_line "${may_be_multi[1]}"; then
              batslib_print_kv_single "$width" "${may_be_multi[@]}"
            else
              may_be_multi[1]="$( printf '%s' "${may_be_multi[1]}" | batslib_prefix | batslib_mark '>' "$idx" )"
              batslib_print_kv_multi "${may_be_multi[@]}"
            fi
          } \
          | batslib_decorate 'no line should match the regular expression' \
          | fail
          return $?
        fi
      done
    elif (( is_mode_partial )); then
      local -i idx
      for (( idx = 0; idx < ${#lines[@]}; ++idx )); do
        if [[ ${lines[$idx]} == *"$unexpected"* ]]; then
          { local -ar single=( 'substring' "$unexpected" 'index' "$idx" )
            local -a may_be_multi=( 'output' "$output" )
            local -ir width="$( batslib_get_max_single_line_key_width "${single[@]}" "${may_be_multi[@]}" )"
            batslib_print_kv_single "$width" "${single[@]}"
            if batslib_is_single_line "${may_be_multi[1]}"; then
              batslib_print_kv_single "$width" "${may_be_multi[@]}"
            else
              may_be_multi[1]="$( printf '%s' "${may_be_multi[1]}" | batslib_prefix | batslib_mark '>' "$idx" )"
              batslib_print_kv_multi "${may_be_multi[@]}"
            fi
          } \
          | batslib_decorate 'no line should contain substring' \
          | fail
          return $?
        fi
      done
    else
      local -i idx
      for (( idx = 0; idx < ${#lines[@]}; ++idx )); do
        if [[ ${lines[$idx]} == "$unexpected" ]]; then
          { local -ar single=( 'line' "$unexpected" 'index' "$idx" )
            local -a may_be_multi=( 'output' "$output" )
            local -ir width="$( batslib_get_max_single_line_key_width "${single[@]}" "${may_be_multi[@]}" )"
            batslib_print_kv_single "$width" "${single[@]}"
            if batslib_is_single_line "${may_be_multi[1]}"; then
              batslib_print_kv_single "$width" "${may_be_multi[@]}"
            else
              may_be_multi[1]="$( printf '%s' "${may_be_multi[1]}" | batslib_prefix | batslib_mark '>' "$idx" )"
              batslib_print_kv_multi "${may_be_multi[@]}"
            fi
          } \
          | batslib_decorate 'line should not be in output' \
          | fail
          return $?
        fi
      done
    fi
  fi
}

refute_output() {
  local -i is_mode_partial=0
  local -i is_mode_regexp=0
  local -i is_mode_empty=0
  local -i use_stdin=0
  : "${output?}"

  # Handle options.
  if (( $# == 0 )); then
    is_mode_empty=1
  fi

  while (( $# > 0 )); do
    case "$1" in
    -p|--partial) is_mode_partial=1; shift ;;
    -e|--regexp) is_mode_regexp=1; shift ;;
    -|--stdin) use_stdin=1; shift ;;
    --) shift; break ;;
    *) break ;;
    esac
  done

  if (( is_mode_partial )) && (( is_mode_regexp )); then
    echo "\`--partial' and \`--regexp' are mutually exclusive" \
    | batslib_decorate 'ERROR: refute_output' \
    | fail
    return $?
  fi

  # Arguments.
  local unexpected
  if (( use_stdin )); then
    unexpected="$(cat -)"
  else
    unexpected="${1-}"
  fi

  if (( is_mode_regexp == 1 )) && [[ '' =~ $unexpected ]] || (( $? == 2 )); then
    echo "Invalid extended regular expression: \`$unexpected'" \
    | batslib_decorate 'ERROR: refute_output' \
    | fail
    return $?
  fi

  # Matching.
  if (( is_mode_empty )); then
    if [ -n "$output" ]; then
      batslib_print_kv_single_or_multi 6 \
      'output' "$output" \
      | batslib_decorate 'output non-empty, but expected no output' \
      | fail
    fi
  elif (( is_mode_regexp )); then
    if [[ $output =~ $unexpected ]]; then
      batslib_print_kv_single_or_multi 6 \
      'regexp'  "$unexpected" \
      'output' "$output" \
      | batslib_decorate 'regular expression should not match output' \
      | fail
    fi
  elif (( is_mode_partial )); then
    if [[ $output == *"$unexpected"* ]]; then
      batslib_print_kv_single_or_multi 9 \
      'substring' "$unexpected" \
      'output'    "$output" \
      | batslib_decorate 'output should not contain substring' \
      | fail
    fi
  else
    if [[ $output == "$unexpected" ]]; then
      batslib_print_kv_single_or_multi 6 \
      'output' "$output" \
      | batslib_decorate 'output equals, but it was expected to differ' \
      | fail
    fi
  fi
}
