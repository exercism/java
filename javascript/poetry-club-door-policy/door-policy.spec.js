// @ts-check

import {
  frontDoorResponse,
  backDoorResponse,
  frontDoorPassword,
  backDoorPassword,
} from './door-policy';

const recite = (poem, responseFn) => {
  return poem.map((line) => responseFn(line));
};

describe('front door response', () => {
  test('should take the first characters from SUMMER', () => {
    // Summer, by John Albert Caballero
    const SUMMER = [
      'Sunshine warming my toes,',
      'Underwater fun with my friends.',
      'Making homemade ice cream on the porch,',
      'Many long nights catching fireflies.',
      'Early morning walks to the creek,',
      'Reveling in the freedom of lazy days.',
    ];

    const expectedLetters = ['S', 'U', 'M', 'M', 'E', 'R'];
    expect(recite(SUMMER, frontDoorResponse)).toStrictEqual(expectedLetters);
  });

  test('should take the first characters from SOPHIA', () => {
    // Sophia, by John Albert Caballero
    const SOPHIA = [
      'Serene, calming quality',
      'Organized, you always have it together',
      'Picturesque, strikingly beautiful',
      'Honest, so genuine',
      'Imaginative, a creative mind',
      'Alluring, so attractive',
    ];

    const expectedLetters = ['S', 'O', 'P', 'H', 'I', 'A'];
    expect(recite(SOPHIA, frontDoorResponse)).toStrictEqual(expectedLetters);
  });

  test('should take the first characters from CODE', () => {
    // Code Work, by Derk-Jan Karrenbeld
    const CODE_WORK = [
      'Compilers intensily bestow',
      'On commencing without ego',
      'Different processes ajar',
      'Exit with zero quick',
    ];

    const expectedLetters = ['C', 'O', 'D', 'E'];
    expect(recite(CODE_WORK, frontDoorResponse)).toStrictEqual(expectedLetters);
  });
});

describe('front door password', () => {
  test('should capitalize SUMMER', () => {
    expect(frontDoorPassword('SUMMER')).toBe('Summer');
  });

  test('should capitalize SOPHIA', () => {
    expect(frontDoorPassword('SOPHIA')).toBe('Sophia');
  });

  test('should capitalize CODE', () => {
    expect(frontDoorPassword('CODE')).toBe('Code');
  });
});

describe('back door response', () => {
  test('should take the last letter character of each line of CODE_WORK', () => {
    // Code Work, by Derk-Jan Karrenbeld
    const CODE_WORK = [
      'Compilers intensily bestow',
      'On commencing without ego',
      'Different processes ajar',
      'Exit with zero quick',
    ];

    const actualLetters = recite(CODE_WORK, backDoorResponse);
    const expectedLetters = ['w', 'o', 'r', 'k'];
    expect(actualLetters).toStrictEqual(expectedLetters);
  });

  test('should ignore whitespace when taking the last letter character of each line of SHIRE_HORSE_WITH_SPACES', () => {
    // Shire Horse, by Michael Lockwood
    // with trailing whitespace
    const SHIRE_HORSE_WITH_SPACES = [
      'Stands so high   ',
      '\tHuge hooves too\t',
      'Impatiently waits for \t \t',
      '    Reins and harness    ',
      'Eager to leave\n\n',
    ];

    const actualLetters = recite(SHIRE_HORSE_WITH_SPACES, backDoorResponse);
    const expectedLetters = ['h', 'o', 'r', 's', 'e'];
    expect(actualLetters).toStrictEqual(expectedLetters);
  });
});

describe('back door password', () => {
  test("should generate the correct pass phrase from 'work'", () => {
    expect(backDoorPassword('work')).toBe('Work, please');
  });

  test("should generate the correct pass phrase from 'horse'", () => {
    expect(backDoorPassword('horse')).toBe('Horse, please');
  });
});
