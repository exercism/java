import { twoSum, luckyNumber, errorMessage } from './lucky-numbers';

describe('twoSum', () => {
  test('sums the numbers correctly for short arrays', () => {
    const leftInput = [2, 4];
    const rightInput = [1, 5, 7];
    expect(twoSum(leftInput, rightInput)).toBe(181);
  });

  test('sums the numbers correctly for long arrays', () => {
    const leftInput = [1, 2, 4, 0, 3, 5, 2, 9];
    const rightInput = [3, 2, 4, 8, 1, 5, 4, 1, 8];
    expect(twoSum(leftInput, rightInput)).toBe(337218947);
  });
});

describe('luckyNumber', () => {
  test('identifies palindromic numbers', () => {
    expect(luckyNumber(15651)).toBe(true);
    expect(luckyNumber(48911984)).toBe(true);
  });

  test('identifies non-palindromic numbers', () => {
    expect(luckyNumber(156512)).toBe(false);
    expect(luckyNumber(48921984)).toBe(false);
  });

  test('works for small numbers', () => {
    expect(luckyNumber(0)).toBe(true);
    expect(luckyNumber(33)).toBe(true);
    expect(luckyNumber(12)).toBe(false);
  });
});

describe('errorMessage', () => {
  test('identifies if there is no input value', () => {
    expect(errorMessage('')).toBe('Required field');
    expect(errorMessage(null)).toBe('Required field');
    expect(errorMessage(undefined)).toBe('Required field');
  });

  test('identifies invalid inputs', () => {
    expect(errorMessage('some text')).toBe('Must be a number besides 0');
    expect(errorMessage('86f1')).toBe('Must be a number besides 0');
    expect(errorMessage('4 2')).toBe('Must be a number besides 0');
    expect(errorMessage('0')).toBe('Must be a number besides 0');
  });

  test('returns an empty string for valid inputs', () => {
    expect(errorMessage('1.234')).toBe('');
    expect(errorMessage('  784   ')).toBe('');
    expect(errorMessage('5e3')).toBe('');
  });
});
