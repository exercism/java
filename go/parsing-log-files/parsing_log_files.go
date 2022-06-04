package parsinglogfiles

import "regexp"

func IsValidLine(text string) bool {
	re := regexp.MustCompile(`^\[(TRC|DBG|INF|WRN|ERR|FTL)\]`)
	return re.MatchString(text)
}

func SplitLogLine(text string) []string {
	re := regexp.MustCompile(`<[*~=-]*>`)
	return re.Split(text, -1)
}

func CountQuotedPasswords(lines []string) int {
	re := regexp.MustCompile(`(?i)\".*?password.*?\"`)

	count := 0
	for _, line := range lines {
		ms := re.FindAllString(line, -1)
		count += len(ms)
	}
	return count
}

func RemoveEndOfLineText(text string) string {
	re := regexp.MustCompile(`end-of-line\d+`)
	return re.ReplaceAllString(text, "")
}

func TagWithUserName(lines []string) []string {
	re := regexp.MustCompile(`(?i)\s+User\s+([a-z\d]*)`)

	var res []string
	for _, line := range lines {
		ms := re.FindStringSubmatch(line)
		if len(ms) > 1 {
			line = "[USR] " + ms[1] + " " + line
		}
		res = append(res, line)

	}

	return res
}
