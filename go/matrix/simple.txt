package matrix

import (
	"errors"
	"strconv"
	"strings"
)

type Matrix [][]int

func New(input string) (Matrix, error) {
	var res Matrix

	var cols int

	for i, line := range strings.Split(input, "\n") {
		var row []int
		line = strings.TrimSpace(line)
		for _, strNum := range strings.Split(line, " ") {
			num, err := strconv.Atoi(strNum)
			if err != nil {
				return nil, errors.New("error converting number")
			}
			row = append(row, num)
		}
		if i != 0 && len(row) != cols {
			return nil, errors.New("rows with different number of columns")
		}
		cols = len(row)
		res = append(res, row)
	}

	return res, nil
}

func (m Matrix) Rows() [][]int {
	nRows := len(m)

	if nRows == 0 {
		return [][]int{}
	}

	res := make([][]int, nRows)

	for i, row := range m {
		for _, val := range row {
			res[i] = append(res[i], val)
		}
	}

	return res
}

func (m Matrix) Set(r, c, val int) bool {

	nRows := len(m)

	if r >= nRows || r < 0 {
		return false
	}

	nCols := len(m[0])

	if c >= nCols || c < 0 {
		return false
	}

	m[r][c] = val
	return true
}

func (m Matrix) Cols() [][]int {

	nRows := len(m)

	if nRows == 0 {
		return [][]int{}
	}

	nCols := len(m[0])
	res := make([][]int, nCols)

	for _, row := range m {
		for j, val := range row {
			res[j] = append(res[j], val)
		}
	}

	return res
}
