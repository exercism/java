#[derive(Debug)]
pub struct HighScores {
    scores: Vec<u32>,
}

impl HighScores {
    pub fn new(scores: &[u32]) -> Self {
        let mut s: Vec<u32> = Vec::new();
        for score in scores {
            s.push(*score)
        }
        HighScores { scores: s }
    }

    pub fn scores(&self) -> &[u32] {
        &self.scores
    }

    pub fn latest(&self) -> Option<u32> {
        let size = self.scores.len();
        if size == 0 {
            return None;
        }
        return Some(self.scores[size - 1]);
    }

    pub fn personal_best(&self) -> Option<u32> {
        let size = self.scores.len();
        if size == 0 {
            return None;
        }

        let mut greatest = self.scores[0];
        for score in &self.scores {
            if *score > greatest {
                greatest = *score;
            }
        }
        return Some(greatest);
    }

    pub fn personal_top_three(&self) -> Vec<u32> {
        let mut new_vec = self.scores.clone();
        let size = new_vec.len();
        let mut take = 3;
        if size < 3 {
            take = size
        }
        new_vec.sort_by(|a, b| b.cmp(a));
        return new_vec.split_at(take).0.into();
    }
}
