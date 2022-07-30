package chessboard

// Rank stores if a square is occupied by a piece
type Rank []bool

// Chessboard contains eight Ranks, accessed with values from 'A' to 'H'
type Chessboard map[string]Rank

// CountInRank returns how many squares are occupied in the chessboard,
// within the given rank
func CountInRank(cb Chessboard, rank string) (ret int) {

	for _, occupied := range cb[rank] {
		if occupied {
			ret++
		}
	}

	return ret
}

// CountInFile returns how many squares are occupied in the chessboard,
// within the given file
func CountInFile(cb Chessboard, file int) (ret int) {
    if file <= 0 {
		return 0
    }
	for _, rank := range cb {
		if file <= len(rank) && rank[file-1] {
			ret++
		}
	}
	return ret
}

// CountAll should count how many squares are present in the chessboard
func CountAll(cb Chessboard) (ret int) {
	for _, rank := range cb {
		ret += len(rank)
	}
	return ret
}

// CountOccupied returns how many squares are occupied in the chessboard
func CountOccupied(cb Chessboard) (ret int) {
	for _, rank := range cb {
		for _, square := range rank {
			if square {
				ret++
			}
		}
	}
	return ret
}
