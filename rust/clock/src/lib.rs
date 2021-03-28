use std::fmt;

const MINUTES_DAY: i64 = 60*24;

#[derive(Debug, PartialEq)]
pub struct Clock {
    minutes: i64,
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        let (h,m) = self.hour_minute();
        write!(f, "{:02}:{:02}", h, m)
    }
}

impl Clock {

    fn hour_minute(&self) -> (i64, i64) {
        (self.minutes / 60, self.minutes % 60)
    }

    pub fn new(hours: i64, minutes: i64) -> Self {
        Clock { minutes: (hours*60 + minutes).rem_euclid(MINUTES_DAY)}
    }

    pub fn add_minutes(&self, minutes: i64) -> Self {
        Clock::new(0, self.minutes + minutes)
    }
}
