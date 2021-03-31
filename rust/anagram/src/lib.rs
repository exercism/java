use std::collections::HashMap;
use std::collections::HashSet;
use unicode_segmentation::UnicodeSegmentation;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let mut anagrams: HashSet<&'a str> = HashSet::new();
    let word = word.to_lowercase();
    let word_anagram = make_anagram_map(&word);

    for &possible_anagram in possible_anagrams {
        let candidate_lowercase = possible_anagram.to_lowercase();
        if word.len() == candidate_lowercase.len()
            && word != candidate_lowercase
            && word_anagram == make_anagram_map(&candidate_lowercase)
        {
            anagrams.insert(possible_anagram);
        }
    }

    anagrams
}

pub fn make_anagram_map(word: &str) -> HashMap<&str, i32> {
    let mut res = HashMap::new();

    for c in word.graphemes(true) {
        match res.get_mut(&c) {
            None => { res.insert(c, 1); }
            Some(v) => *v += 1,
        }
    }

    res
}