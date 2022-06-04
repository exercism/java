package parsinglogfiles

import (
	"regexp"
    "fmt"
)

func IsValidLine(text string) bool {
	match, err := regexp.MatchString(`^\[(TRC|DBG|INF|WRN|ERR|FTL)\]`, text)
	if !match || err != nil {
		return false
	}
	return true
}

func SplitLogLine(text string) []string {
	r := regexp.MustCompile(`<[*~=-]*>`)
	return r.Split(text, -1)
}

func CountQuotedPasswords(lines []string) int {
	count := 0
	r := regexp.MustCompile(`(?i)".*password.*"`)
	for _, line := range lines {
		if r.MatchString(line) {
			count++
		}
	}
	return count
}

func RemoveEndOfLineText(text string) string {
	r := regexp.MustCompile(`end-of-line\d+`)
	return r.ReplaceAllString(text, "")
}

func TagWithUserName(lines []string) []string {
	var result []string
	r := regexp.MustCompile(`\s+User\s+(\S+)`)
	for _, line := range lines {
		match := r.FindStringSubmatch(line)
		if len(match) > 1 {
			line = fmt.Sprintf("[USR] %s %s", match[1], line)
		}
		result = append(result, line)
	}
	return result
}
