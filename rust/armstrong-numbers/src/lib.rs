pub fn is_armstrong_number(num: u32) -> bool {
    let digits: Vec<u32> = num
        .to_string()
        .chars()
        .map(|d| d.to_digit(10).unwrap())
        .collect();
    let exponent = digits.len();

    digits.iter().map(|d| d.pow(exponent as u32)).sum::<u32>() == num
}
