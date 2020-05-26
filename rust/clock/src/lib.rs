use chrono::{Duration, NaiveTime, Timelike};
use std::fmt;

#[derive(Debug)]
pub struct Clock {
    time: NaiveTime,
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{:02}:{:02}", self.time.hour(), self.time.minute())
    }
}

impl PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.time == other.time
    }
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let nt = Clock {
            time: NaiveTime::from_hms(0, 0, 0),
        };

        return nt.add_minutes(hours * 60 + minutes);
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let (nt, _) = self
            .time
            .overflowing_add_signed(Duration::minutes(minutes.into()));
        Clock { time: nt }
    }
}
