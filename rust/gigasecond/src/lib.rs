use chrono::{DateTime, Duration, Utc};
use core::ops::Add;

// Returns a Utc DateTime one billion seconds after start.
pub fn after(start: DateTime<Utc>) -> DateTime<Utc> {
    let duration = Duration::seconds(1_000_000_000);
    return start.add(duration);
}
