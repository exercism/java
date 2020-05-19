pub fn reply(message: &str) -> &str {
    let original = String::from(message.trim());
    if original == "" {
        return "Fine. Be that way!";
    }

    let upper = String::from(message.trim()).to_uppercase();
    let lower = String::from(message.trim()).to_lowercase();

    if original.ends_with("?") {
        if upper == original && upper != lower {
            return "Calm down, I know what I'm doing!";
        } else {
            return "Sure.";
        }
    }
    if upper == original && upper != lower {
        return "Whoa, chill out!";
    }

    return "Whatever.";
}
