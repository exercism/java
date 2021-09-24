// Translate RNA sequences into proteins.
package protein

import "errors"

var (
	ErrStop        error = errors.New("stop")
	ErrInvalidBase error = errors.New("invalid codon")
)

// FromCodon converts performs the conversion of a codon into a protein
func FromCodon(codon string) (string, error) {
	switch codon {
	case "AUG":
		return "Methionine", nil
	case "UUU", "UUC":
		return "Phenylalanine", nil
	case "UUA", "UUG":
		return "Leucine", nil
	case "UCU", "UCC", "UCA", "UCG":
		return "Serine", nil
	case "UAU", "UAC":
		return "Tyrosine", nil
	case "UGU", "UGC":
		return "Cysteine", nil
	case "UGG":
		return "Tryptophan", nil
	case "UAA", "UAG", "UGA":
		return "", ErrStop
	default:
		return "", ErrInvalidBase
	}
}

// FromRNA decodes the proteins in a RNA strand
func FromRNA(strand string) ([]string, error) {

	var proteins []string

	for i := 0; i < len(strand); i += 3 {

		protein, err := FromCodon(strand[i : i+3])

		if err == ErrStop {
			break
		}

		if err != nil {
			return proteins, err
		}

		proteins = append(proteins, protein)
	}

	return proteins, nil
}
