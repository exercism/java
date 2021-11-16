package tree

// Record is a struct containing int fields ID and Parent
type Record struct {
	ID     int
	Parent int
}

// Node is a struct containing int field ID and []*Node field Children.
type Node struct {
	ID       int
	Children []*Node
}

func Build(records []Record) (*Node, error) {
	var root *Node
	for _, v := range records {
		if v.ID == v.Parent {
			root = &Node{ID: v.ID}
			break
		}
	}
	if root == nil {
		return root, nil
	}
	for _, v := range records {
		var n *Node
		if v.ID == root.ID {
			n = root
		} else {
			n = &Node{ID: v.ID}
		}
		for _, v1 := range records {
			if v == v1 {
				continue
			}
			child := &Node{ID: v1.ID}
			if v1.Parent == v.ID {
				n.Children = append(n.Children, child)
			}
		}
	}
	return root, nil
}
