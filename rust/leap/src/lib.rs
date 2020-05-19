pub fn is_leap_year_canonical(year: u64) -> bool {
    if year % 4 != 0 {
        return false;
    } else if year % 100 != 0 {
        return true;
    } else if year % 400 != 0 {
        return false;
    }

    return true;
}

pub fn is_leap_year_short(year: u64) -> bool {
    year % 4 == 0 && year % 100 != 0 || year % 400 == 0
}

pub fn is_leap_year(year: u64) -> bool {
    is_leap_year_short(year)
}
