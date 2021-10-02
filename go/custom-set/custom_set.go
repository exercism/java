package stringset

import "strings"

type Set map[string]bool

func New() Set {
	return make(Set)
}

func NewFromSlice(list []string) Set {
	s := New()

	for _, elem := range list {
		s[elem] = true
	}

	return s
}

func (s Set) elemList() []string {
	res := make([]string, 0, len(s))

	for k, v := range s {
		if v {
			res = append(res, "\""+k+"\"")
		}
	}

	return res
}

func (s Set) String() string {
	return "{" + strings.Join(s.elemList(), ", ") + "}"
}

func (s Set) IsEmpty() bool {
	return len(s) == 0
}

func (s Set) Has(elem string) bool {
	_, ok := s[elem]
	return ok
}

func (s Set) Add(elem string) {
	s[elem] = true
}

func Subset(s1, s2 Set) bool {

	if len(s1) > len(s2) {
		return false
	}

	for elem := range s1 {
		if !s2.Has(elem) {
			return false
		}
	}

	return true
}

func Equal(s1, s2 Set) bool {
	if len(s1) != len(s2) {
		return false
	}

	for elem := range s1 {
		if !s2.Has(elem) {
			return false
		}
	}

	return true
}

func Intersection(s1, s2 Set) Set {
	s := New()

	for elem := range s1 {
		if s2.Has(elem) {
			s.Add(elem)
		}
	}

	return s
}

func Disjoint(s1, s2 Set) bool {
	return len(Intersection(s1, s2)) == 0
}

func Union(s1, s2 Set) Set {
	s := New()

	for elem := range s1 {
		s.Add(elem)
	}

	for elem := range s2 {
		s.Add(elem)
	}

	return s
}

func Difference(s1, s2 Set) Set {
	s := New()

	for elem := range s1 {
		if !s2.Has(elem) {
			s.Add(elem)
		}
	}

	return s
}
