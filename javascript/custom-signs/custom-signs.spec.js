//@ts-check

import {
  buildSign,
  buildBirthdaySign,
  graduationFor,
  costOf,
} from './custom-signs';

describe('buildSign', () => {
  test('occasion is Birthday', () => {
    expect(buildSign('Birthday', 'Jack')).toBe('Happy Birthday Jack!');
  });

  test('occasion is Anniversary', () => {
    expect(buildSign('Anniversary', 'Jill')).toBe('Happy Anniversary Jill!');
  });
});

describe('buildBirthdaySign', () => {
  test('age is less than 50', () => {
    expect(buildBirthdaySign(49)).toBe(
      'Happy Birthday! What a young fellow you are.'
    );
  });

  test('age is 50 or older', () => {
    expect(buildBirthdaySign(51)).toBe(
      'Happy Birthday! What a mature fellow you are.'
    );
  });

  test('age is 50', () => {
    expect(buildBirthdaySign(50)).toBe(
      'Happy Birthday! What a mature fellow you are.'
    );
  });
});

describe('graduationFor', () => {
  test('Robs graduation, 2021', () => {
    const expected = 'Congratulations Rob!\nClass of 2021';
    expect(graduationFor('Rob', 2021)).toBe(expected);
  });

  test('Jills graduation, 1999', () => {
    const expected = 'Congratulations Jill!\nClass of 1999';
    expect(graduationFor('Jill', 1999)).toBe(expected);
  });
});

describe('costOf', () => {
  test('sign is total of characters followed by the currency', () => {
    const sign = 'Happy Birthday!';
    const expected = 'Your sign costs 50.00 dollars.';
    expect(costOf(sign, 'dollars')).toBe(expected);
  });

  test('includes line breaks in the calculation', () => {
    const sign = 'Congratulations Rob\nClass of 2021';
    const expected = 'Your sign costs 86.00 dollars.';
    expect(costOf(sign, 'dollars')).toBe(expected);
  });

  test('handles different currency arguments', () => {
    const sign = 'Happy Easter, little sister!';
    const expected = 'Your sign costs 76.00 euros.';
    expect(costOf(sign, 'euros')).toBe(expected);
  });
});
