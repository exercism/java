pub fn is_prime(n: u64) -> bool {
    if n <= 3 {
        return n > 1;
    } else if n % 2 == 0 || n % 3 == 0 {
        return false;
    }

    let mut i = 5;

    while i * i <= n {
        if n % i == 0 || n % (i + 2) == 0 {
            return false;
        }
        i += 6;
    }

    return true;
}

pub fn factors(n: u64) -> Vec<u64> {
    let mut fs: Vec<u64> = Vec::new();
    let mut r = n;
    let cf = (1..=n).filter(|i| is_prime(*i)).collect::<Vec<u64>>();

    while r > 1 {
        for f in cf.iter() {
            if r % *f == 0 {
                fs.push(*f);
                r = r / *f;
                break;
            }
        }
    }
    return fs;
}
