import { score } from './scrabble-score';

describe('Scrabble', () => {
  test('lowercase letter', () => {
    expect(score('a')).toEqual(1);
  });

  xtest('uppercase letter', () => {
    expect(score('A')).toEqual(1);
  });

  xtest('valuable letter', () => {
    expect(score('f')).toEqual(4);
  });

  xtest('short word', () => {
    expect(score('at')).toEqual(2);
  });

  xtest('short, valuable word', () => {
    expect(score('zoo')).toEqual(12);
  });

  xtest('medium word', () => {
    expect(score('street')).toEqual(6);
  });

  xtest('medium, valuable word', () => {
    expect(score('quirky')).toEqual(22);
  });

  xtest('long, mixed-case word', () => {
    expect(score('OxyphenButazone')).toEqual(41);
  });

  xtest('english-like word', () => {
    expect(score('pinata')).toEqual(8);
  });

  xtest('empty input', () => {
    expect(score('')).toEqual(0);
  });

  xtest('entire alphabet available', () => {
    expect(score('abcdefghijklmnopqrstuvwxyz')).toEqual(87);
  });
});
