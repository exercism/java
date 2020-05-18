pub fn nth(n: u32) -> u32 {
    let mut found: u32 = 0;
    let mut prime_candidate = 2;
    let mut last_prime = 0;

    while found <= n {
        if is_prime(prime_candidate) {
            last_prime = prime_candidate;
            found += 1;
        }
        prime_candidate += 1;
    }
    return last_prime;
}

pub fn is_prime(n: u32) -> bool {
    return (2..n).take_while(|d| d * d <= n).all(|d| n % d != 0);
}
