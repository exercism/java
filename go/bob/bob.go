// Package bob implements functionality of a robot that gives answers when prompted
package bob

import (
	"strings"
)

// Hey makes bob say hey on different ways based on a remark
func Hey(remark string) string {
	remark = strings.TrimSpace(remark)

	if remark == "" {
		return "Fine. Be that way!"
	}

	upper := strings.ToUpper(remark)
	lower := strings.ToLower(remark)

	if strings.HasSuffix(remark, "?") {
		if upper == remark && upper != lower {
			return "Calm down, I know what I'm doing!"
		}
		return "Sure."
	}
	if upper == remark && upper != lower {
		return "Whoa, chill out!"
	}

	return "Whatever."
}
