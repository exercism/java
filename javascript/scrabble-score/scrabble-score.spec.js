import { score } from './scrabble-score';

describe('Scrabble', () => {
  test('lowercase letter', () => {
    expect(score('a')).toEqual(1);
  });

  test('uppercase letter', () => {
    expect(score('A')).toEqual(1);
  });

  test('valuable letter', () => {
    expect(score('f')).toEqual(4);
  });

  test('short word', () => {
    expect(score('at')).toEqual(2);
  });

  test('short, valuable word', () => {
    expect(score('zoo')).toEqual(12);
  });

  test('medium word', () => {
    expect(score('street')).toEqual(6);
  });

  test('medium, valuable word', () => {
    expect(score('quirky')).toEqual(22);
  });

  test('long, mixed-case word', () => {
    expect(score('OxyphenButazone')).toEqual(41);
  });

  test('english-like word', () => {
    expect(score('pinata')).toEqual(8);
  });

  test('empty input', () => {
    expect(score('')).toEqual(0);
  });

  test('entire alphabet available', () => {
    expect(score('abcdefghijklmnopqrstuvwxyz')).toEqual(87);
  });
});
