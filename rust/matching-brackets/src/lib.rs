pub fn brackets_are_balanced(string: &str) -> bool {
    let mut stack: Vec<char> = Vec::new();

    for c in string.chars() {
        match c {
            '[' => stack.push(c),
            ']' => match stack.pop() {
                Some('[') => continue,
                _ => return false,
            },
            '{' => stack.push(c),
            '}' => match stack.pop() {
                Some('{') => continue,
                _ => return false,
            },
            '(' => stack.push(c),
            ')' => match stack.pop() {
                Some('(') => continue,
                _ => return false,
            },
            _ => continue,
        };
    }

    return stack.is_empty();
}
