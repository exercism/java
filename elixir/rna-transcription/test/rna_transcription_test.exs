defmodule RnaTranscriptionTest do
  use ExUnit.Case

  # @tag :pending
  test "transcribes guanine to cytosine" do
    assert RnaTranscription.to_rna('G') == 'C'
  end

  test "transcribes cytosine to guanine" do
    assert RnaTranscription.to_rna('C') == 'G'
  end

  test "transcribes thymidine to adenine" do
    assert RnaTranscription.to_rna('T') == 'A'
  end

  test "transcribes adenine to uracil" do
    assert RnaTranscription.to_rna('A') == 'U'
  end

  test "it transcribes all dna nucleotides to rna equivalents" do
    assert RnaTranscription.to_rna('ACGTGGTCTTAA') == 'UGCACCAGAAUU'
  end
end
