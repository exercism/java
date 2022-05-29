package tree

import (
	"errors"
	"sort"
)

type Record struct {
	ID     int
	Parent int
}

type Node struct {
	ID       int
	Children []*Node
}

func ValidateRecords(records []Record) error {
	sort.Slice(records, func(i, j int) bool {
		return records[i].ID < records[j].ID
	})

	if records[0].ID != 0 {
		return errors.New("no root node")
	}

	prev := -1
	for _, rec := range records {

		if rec.ID-1 != prev {
			return errors.New("non consecutive IDS")
		}

		if rec.ID < rec.Parent {
			return errors.New("rec.ID < rec.Parent")
		}

		if rec.ID == rec.Parent && rec.ID != 0 {
			return errors.New("direct cycle")
		}

		prev = rec.ID
	}

	return nil
}

func Build(records []Record) (*Node, error) {
	if len(records) == 0 {
		return nil, nil
	}

	if err := ValidateRecords(records); err != nil {
		return nil, err
	}

	nodes := make(map[int]*Node)
	for _, rec := range records {
		nodes[rec.ID] = &Node{ID: rec.ID}

		if rec.ID == rec.Parent {
			continue
		}

		pnode := nodes[rec.Parent]
		pnode.Children = append(pnode.Children, nodes[rec.ID])
	}

	return nodes[0], nil
}
