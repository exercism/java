"""
    count_nucleotides(strand)

The count of each nucleotide within `strand` as a dictionary.

Invalid strands raise a `DomainError`.

"""
function count_nucleotides(strand)

    strand_dict = Dict('A'=> 0, 'C'=> 0, 'G'=> 0, 'T'=> 0)
    for nucleotide in strand
        if !haskey(strand_dict, nucleotide)
            throw(DomainError(nucleotide, "invalid nucleotide"))            
        end
        strand_dict[nucleotide] += 1
    end

    return strand_dict
end
