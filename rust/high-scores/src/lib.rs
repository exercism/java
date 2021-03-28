use std::cmp;

#[derive(Debug)]
pub struct HighScores {
    scores: Vec<u32>,
}

impl HighScores {
    pub fn new(scores: &[u32]) -> Self {
        HighScores { scores: scores.to_vec() }
    }

    pub fn scores(&self) -> &[u32] {
        &self.scores
    }

    pub fn latest(&self) -> Option<u32> {
        match self.scores.len(){
            0 => None,
            _ => Some(self.scores[self.scores.len() - 1])
        }
    }

    pub fn personal_best(&self) -> Option<u32> {
        match self.scores.len() {
            0 => None,
            _ => Some(*self.scores.iter().max().unwrap_or(&0))
        }
    }

    pub fn personal_top_three(&self) -> Vec<u32> {
        let take = cmp::min(self.scores.len(), 3);
        let mut new_vec = self.scores.clone();
        new_vec.sort();
        new_vec.reverse();
        new_vec.split_at(take).0.into()
    }
}
