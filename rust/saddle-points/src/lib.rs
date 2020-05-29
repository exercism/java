use std::collections::HashMap;

pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    let mut res: Vec<(usize, usize)> = Vec::new();
    let n_rows = input.len();

    // Determine matrix dimensions and return immediately
    // if one of the dimensions is zero
    if n_rows == 0 {
        return res;
    }
    let n_cols = input[0].len();
    if n_cols == 0 {
        return res;
    }

    // Compute maximum for all rows
    let mut row_maxs: HashMap<usize, u64> = HashMap::new();
    for (i, row) in input.iter().enumerate() {
        if let Some(max) = row.iter().max() {
            row_maxs.insert(i, *max);
        }
    }

    // Compute minimum for all columns
    let mut col_mins: HashMap<usize, u64> = HashMap::new();
    for c in 0..n_cols {
        let mut min = input[0][c];
        for row in input {
            if row[c] < min {
                min = row[c];
            }
        }
        col_mins.insert(c, min);
    }

    // Compute saddle points
    for (i, row) in input.iter().enumerate() {
        for (j, elem) in row.iter().enumerate() {
            let max_row = row_maxs.get(&i).expect("Got None value from max_row");
            let min_col = col_mins.get(&j).expect("Got None value from min_col");

            if *elem >= *max_row && *elem <= *min_col {
                res.push((i, j));
            }
        }
    }

    return res;
}
