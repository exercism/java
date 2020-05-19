pub fn build_proverb(list: &[&str]) -> String {
    let n_elements = list.len();
    if n_elements == 0 {
        return String::from("");
    }

    let mut phrases: Vec<String> = Vec::new();
    for i in 0..n_elements - 1 {
        phrases.push(format!(
            "For want of a {} the {} was lost.",
            list[i],
            list[i + 1]
        ));
    }
    phrases.push(format!("And all for the want of a {}.", list[0]));

    phrases.join("\n")
}
