use std::collections::HashSet;

pub fn check(candidate: &str) -> bool {

    let mut used:HashSet<char> = HashSet::new();

    for c in candidate.to_lowercase().chars() {
        if c.is_alphabetic() && used.contains(&c) {
            return false;
        }
        used.insert(c);
    }

    true
}
