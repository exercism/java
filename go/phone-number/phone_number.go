package phonenumber

import "errors"

func Number(phoneNumber string) (string, error) {

	var clean string
	for _, c := range phoneNumber {
		if c >= '0' && c <= '9' {
			clean += string(c)
		}
	}

	if len(clean) > 10 && clean[0] == '1' {
		clean = clean[1:]
	}

	if len(clean) != 10 {
		return "", errors.New("invalid length for number")
	}

	if clean[0] == '0' || clean[0] == '1' || clean[3] == '0' || clean[3] == '1' {
		return "", errors.New("invalid N digit")
	}

	return clean, nil
}

func AreaCode(phoneNumber string) (string, error) {
	n, err := Number(phoneNumber)
	if err != nil {
		return "", err
	}
	return n[:3], nil
}

func Format(phoneNumber string) (string, error) {
	n, err := Number(phoneNumber)
	if err != nil {
		return "", err
	}
	return "(" + n[:3] + ") " + n[3:6] + "-" + n[6:], nil
}
