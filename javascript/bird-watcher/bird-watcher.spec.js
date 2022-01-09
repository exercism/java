import { totalBirdCount, birdsInWeek, fixBirdCountLog } from './bird-watcher';

describe('bird watcher', () => {
  describe('totalBirdCount', () => {
    test('calculates the correct total number of birds', () => {
      const birdsPerDay = [9, 0, 8, 4, 5, 1, 3];
      expect(totalBirdCount(birdsPerDay)).toBe(30);
    });

    test('works for a short bird count list', () => {
      const birdsPerDay = [2];
      expect(totalBirdCount(birdsPerDay)).toBe(2);
    });

    test('works for a long bird count list', () => {
      // prettier-ignore
      const birdsPerDay = [2, 8, 4, 1, 3, 5, 0, 4, 1, 6, 0, 3, 0, 1, 5, 4, 1, 1, 2, 6];
      expect(totalBirdCount(birdsPerDay)).toBe(57);
    });
  });

  describe('birdsInWeek', () => {
    test('calculates the number of birds in the first week', () => {
      const birdsPerDay = [3, 0, 5, 1, 0, 4, 1, 0, 3, 4, 3, 0, 8, 0];
      expect(birdsInWeek(birdsPerDay, 1)).toBe(14);
    });

    test('calculates the number of birds for a week in the middle of the log', () => {
      // prettier-ignore
      const birdsPerDay = [4, 7, 3, 2, 1, 1, 2, 0, 2, 3, 2, 7, 1, 3, 0, 6, 5, 3, 7, 2, 3];
      expect(birdsInWeek(birdsPerDay, 2)).toBe(18);
    });

    test('works when there is only one week', () => {
      const birdsPerDay = [3, 0, 3, 3, 2, 1, 0];
      expect(birdsInWeek(birdsPerDay, 1)).toBe(12);
    });

    test('works for a long bird count list', () => {
      const week21 = [2, 0, 1, 4, 1, 3, 0];
      const birdsPerDay = randomArray(20 * 7)
        .concat(week21)
        .concat(randomArray(10 * 7));

      expect(birdsInWeek(birdsPerDay, 21)).toBe(11);
    });
  });

  describe('fixBirdCountLog', () => {
    test('returns a bird count list with the corrected values', () => {
      const birdsPerDay = [3, 0, 5, 1, 0, 4, 1, 0, 3, 4, 3, 0];
      const expected = [4, 0, 6, 1, 1, 4, 2, 0, 4, 4, 4, 0];
      expect(fixBirdCountLog(birdsPerDay)).toEqual(expected);
    });

    test('does not create a new array', () => {
      const birdsPerDay = [2, 0, 1, 4, 1, 3, 0];

      // This checks that the same object that was passed in is returned.
      // https://jestjs.io/docs/expect#tobevalue
      expect(Object.is(fixBirdCountLog(birdsPerDay), birdsPerDay)).toBe(true);
    });

    test('works for a short bird count list', () => {
      expect(fixBirdCountLog([4, 2])).toEqual([5, 2]);
    });

    test('works for a long bird count list', () => {
      // prettier-ignore
      const birdsPerDay = [2, 8, 4, 1, 3, 5, 0, 4, 1, 6, 0, 3, 0, 1, 5, 4, 1, 1, 2, 6];
      // prettier-ignore
      const expected = [3, 8, 5, 1, 4, 5, 1, 4, 2, 6, 1, 3, 1, 1, 6, 4, 2, 1, 3, 6];
      expect(fixBirdCountLog(birdsPerDay)).toEqual(expected);
    });
  });
});

function randomArray(length) {
  return Array.from({ length: length }, () => Math.floor(Math.random() * 8));
}
