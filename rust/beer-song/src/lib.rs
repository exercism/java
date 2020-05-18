/// Returns a string representing the amount of bottles passed as argument.
///
/// # Arguments
///
/// * `amount` - The amount of bottles to represent.
/// * `capitalize` - If the start of the string should be capitalized. Matters only if amount == 0.
///
/// # Example
///
/// ```
/// bottle_amount_text(0, true) // "No more bottles"
/// bottle_amount_text(0, false) // "no more bottles"
/// bottle_amount_text(1, false) // "1 more bottle"
/// bottle_amount_text(2, false) // "2 more bottles"
/// ```
pub fn bottle_amount_text(amount: u32, capitalize: bool) -> String {
    let amount_text: String = if amount == 0 {
        String::from(if capitalize { "No more" } else { "no more" })
    } else {
        String::from(amount.to_string())
    };

    let noun_text: String = if amount == 1 {
        String::from("bottle")
    } else {
        String::from("bottles")
    };

    return format!("{} {}", amount_text, noun_text);
}

/// Returns a verse of the song.
///
/// # Arguments
///
/// * `n` - Amount of bottles for this verse.
///
pub fn verse(n: u32) -> String {
    let current_bottles_text = format!(
        "{} of beer on the wall, {} of beer.",
        bottle_amount_text(n, true),
        bottle_amount_text(n, false)
    );

    let bottles_left_text = if n == 0 {
        String::from("Go to the store and buy some more, 99 bottles of beer on the wall.")
    } else {
        format!(
            "Take {} down and pass it around, {} of beer on the wall.",
            if n > 1 { "one" } else { "it" },
            bottle_amount_text(n - 1, false)
        )
    };

    return format!("{}\n{}\n", current_bottles_text, bottles_left_text);
}

/// Returns a song, given the number of bottles
///
/// # Arguments
///
/// * `start` - Number of bottles to start the song
/// * `end` - Number of bottles to end the song
///
pub fn sing(start: u32, end: u32) -> String {
    let mut v: Vec<String> = Vec::new();

    for i in (end..start + 1).rev() {
        v.push(verse(i));
    }
    return v.join("\n").to_string();
}
