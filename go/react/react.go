package react

type canceler struct {
	cell *computeCell
	id   int
}

func (c *canceler) Cancel() {
	c.cell.RemoveCallback(c.id)
}

type inputCell struct {
	id    int
	value int
	*reactor
}

func (c *inputCell) Value() int {
	return c.value
}

func (c *inputCell) SetValue(v int) {
	if c.value == v {
		return
	}
	c.value = v
	for _, fn := range c.deps[c.id] {
		fn()
	}
}

type computeCell struct {
	id        int
	callbacks []func(int)
	eval      func() int
}

func (c *computeCell) Value() int {
	return c.eval()
}

func (c *computeCell) AddCallback(fn func(int)) Canceler {
	id := len(c.callbacks)
	c.callbacks = append(c.callbacks, fn)
	return &canceler{c, id}
}

func (c *computeCell) RemoveCallback(id int) {
	c.callbacks[id] = nil
}

type reactor struct {
	id   int
	deps map[int][]func()
}

func New() Reactor {
	return &reactor{deps: make(map[int][]func())}
}

func (r *reactor) CreateInput(initial int) InputCell {
	r.id++
	r.deps[r.id] = make([]func(), 0)
	return &inputCell{
		id:      r.id,
		value:   initial,
		reactor: r,
	}
}

func (r *reactor) CreateCompute1(dep Cell, compute func(int) int) ComputeCell {
	r.id++

	newCell := &computeCell{
		id:        r.id,
		callbacks: make([]func(int), 0),
	}

	newCell.eval = func() int {
		return compute(dep.Value())
	}

	idDep := CellId(dep)

	oldVal := compute(dep.Value())
	updateFunc := func() {
		newVal := compute(dep.Value())
		if oldVal != newVal {
			for _, fn := range newCell.callbacks {
				if fn != nil {
					fn(newVal)
				}
			}
			for _, fn := range r.deps[newCell.id] {
				fn()
			}
			oldVal = newVal
		}
	}
	r.deps[idDep] = append(r.deps[idDep], updateFunc)

	return newCell
}

func CellId(c Cell) int {
	switch c := c.(type) {
	case *inputCell:
		return c.id
	case *computeCell:
		return c.id
	default:
		return 0
	}
}

func (r *reactor) CreateCompute2(dep1, dep2 Cell, compute func(int, int) int) ComputeCell {
	r.id++
	oldVal := compute(dep1.Value(), dep2.Value())
	newCell := &computeCell{
		id:        r.id,
		callbacks: make([]func(int), 0),
	}

	newCell.eval = func() int {
		return compute(dep1.Value(), dep2.Value())
	}

	id1, id2 := CellId(dep1), CellId(dep2)
	updateFunc := func() {
		newVal := compute(dep1.Value(), dep2.Value())
		if oldVal != newVal {
			for _, fn := range newCell.callbacks {
				if fn != nil {
					fn(newVal)
				}
			}
			for _, fn := range r.deps[newCell.id] {
				fn()
			}
			oldVal = newVal
		}
	}
	r.deps[id1] = append(r.deps[id1], updateFunc)
	r.deps[id2] = append(r.deps[id2], updateFunc)

	return newCell
}
