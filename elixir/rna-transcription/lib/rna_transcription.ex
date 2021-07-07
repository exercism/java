defmodule RnaTranscription do

  @spec transform_nucleotide(char) :: char
  def transform_nucleotide(nucleotide) do
    case nucleotide do
    ?G -> ?C
    ?C -> ?G
    ?T -> ?A
    ?A -> ?U
    end
  end

  @doc """
  Transcribes a character list representing DNA nucleotides to RNA

  ## Examples

  iex> RnaTranscription.to_rna('ACTG')
  'UGAC'
  """
  @spec to_rna([char]) :: [char]
  def to_rna(dna) do
    Enum.map(dna, &transform_nucleotide/1)
  end


end
