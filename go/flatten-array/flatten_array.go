package flatten

func Flatten(l interface{}) []interface{} {
	res := make([]interface{},0)

	switch l.(type) {
	case int:
		res = append(res, l)
	case []interface{}:
		t := l.([]interface{})
		for _, e := range t {
			rec := Flatten(e)
			res = append(res, rec...)
		}
	}

	return res
}