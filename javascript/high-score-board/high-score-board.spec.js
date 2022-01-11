import {
  createScoreBoard,
  addPlayer,
  removePlayer,
  updateScore,
  applyMondayBonus,
  normalizeScore,
} from './high-score-board';

describe('createScoreBoard', () => {
  test('creates a new board with a test entry', () => {
    const expected = { 'The Best Ever': 1000000 };
    expect(createScoreBoard()).toEqual(expected);
  });
});

describe('addPlayer', () => {
  test('adds a player and score to the board', () => {
    const scoreBoard = {
      'Amil Pastorius': 99373,
      'Min-seo Shin': 0,
    };

    const expected = {
      'Amil Pastorius': 99373,
      'Min-seo Shin': 0,
      'Jesse Johnson': 1337,
    };

    const actual = addPlayer(scoreBoard, 'Jesse Johnson', 1337);
    expect(actual).toEqual(expected);
  });

  test('returns the existing score board', () => {
    const scoreBoard = {};
    const actual = addPlayer(scoreBoard, 'Jesse Johnson', 1337);

    // This checks that the same object that was passed in is returned.
    // https://jestjs.io/docs/expect#tobevalue
    expect(Object.is(actual, scoreBoard)).toBe(true);
  });
});

describe('removePlayer', () => {
  test('removes a player from the score board', () => {
    const scoreBoard = {
      'Amil Pastorius': 99373,
      'Min-seo Shin': 0,
      'Jesse Johnson': 1337,
    };

    const expected = {
      'Amil Pastorius': 99373,
      'Min-seo Shin': 0,
    };

    const actual = removePlayer(scoreBoard, 'Jesse Johnson');
    expect(actual).toEqual(expected);

    // This checks that the same object that was passed in is returned.
    expect(Object.is(actual, scoreBoard)).toBe(true);
  });

  test('does nothing if the player is not on the board', () => {
    const scoreBoard = {
      'Amil Pastorius': 99373,
      'Min-seo Shin': 0,
      'Jesse Johnson': 1337,
    };

    const actual = removePlayer(scoreBoard, 'Bruno Santangelo');
    expect(actual).toEqual(scoreBoard);

    // This checks that the same object that was passed in is returned.
    expect(Object.is(actual, scoreBoard)).toBe(true);
  });
});

describe('updateScore', () => {
  test("increases a player's score", () => {
    const scoreBoard = {
      'Amil Pastorius': 99373,
      'Min-seo Shin': 0,
      'Jesse Johnson': 1337,
    };

    const expected = {
      'Amil Pastorius': 99373,
      'Min-seo Shin': 1999,
      'Jesse Johnson': 2674,
    };

    updateScore(scoreBoard, 'Min-seo Shin', 1999);
    const actual = updateScore(scoreBoard, 'Jesse Johnson', 1337);
    expect(actual).toEqual(expected);

    // This checks that the same object that was passed in is returned.
    expect(Object.is(actual, scoreBoard)).toBe(true);
  });
});

describe('applyMondayBonus', () => {
  test('adds 100 points for all players', () => {
    const scoreBoard = {
      'Amil Pastorius': 345,
      'Min-seo Shin': 19,
      'Jesse Johnson': 122,
    };

    const expected = {
      'Amil Pastorius': 445,
      'Min-seo Shin': 119,
      'Jesse Johnson': 222,
    };

    const actual = applyMondayBonus(scoreBoard);
    expect(actual).toEqual(expected);

    // This checks that the same object that was passed in is returned.
    expect(Object.is(actual, scoreBoard)).toBe(true);
  });

  test('does nothing if the score board is empty', () => {
    const scoreBoard = {};
    const actual = applyMondayBonus(scoreBoard);
    expect(actual).toEqual({});

    // This checks that the same object that was passed in is returned.
    expect(Object.is(actual, scoreBoard)).toBe(true);
  });
});

describe('normalizeScore', () => {
  test('applies the normalization function', () => {
    const params = {
      score: 45,
      normalizeFunction: function (score) {
        return score * 3 - 10;
      },
    };

    expect(normalizeScore(params)).toEqual(125);
  });

  test('works for different params', () => {
    const params = {
      score: 2100,
      normalizeFunction: function (score) {
        return score / 2 + 100;
      },
    };

    expect(normalizeScore(params)).toEqual(1150);
  });
});
