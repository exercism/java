package erratum

import "errors"

func Use(o ResourceOpener, input string) (err error) {
	res, err := o()
	for err != nil {
		if _, ok := err.(TransientError); !ok {
			return err
		}
		res, err = o()
	}

	defer res.Close()

	defer func() {
		if r := recover(); r != nil {
			if v, ok := r.(FrobError); ok {
				res.Defrob(v.defrobTag)
				err = v
			} else {
				err = errors.New("meh")
			}
		}
	}()
	
	res.Frob(input)

	return err
}
