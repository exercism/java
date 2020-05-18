use unicode_segmentation::UnicodeSegmentation;

pub fn reverse(input: &str) -> String {
    return input.graphemes(true).rev().collect();
}
