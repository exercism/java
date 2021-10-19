// @ts-check

import { dayRate, monthRate, daysInBudget } from './freelancer-rates';

const DIFFERENCE_PRECISION_IN_DIGITS = 6;

describe('freelancer rates', () => {
  describe('day rate', () => {
    test('at 16/hour', () => {
      const actual = dayRate(16);
      expect(actual).toBe(128);
    });

    test('at 25/hour', () => {
      const actual = dayRate(25);
      expect(actual).toBe(200);
    });

    test('at 31.40/hour', () => {
      const actual = dayRate(31.4);
      expect(actual).toBeCloseTo(251.2, DIFFERENCE_PRECISION_IN_DIGITS);
    });

    test('at 89.89/hour', () => {
      const actual = dayRate(89.89);
      expect(actual).toBeCloseTo(719.12, DIFFERENCE_PRECISION_IN_DIGITS);
    });

    test('at 97.654321/hour', () => {
      const actual = dayRate(97.654321);
      expect(actual).toBeCloseTo(781.234568, DIFFERENCE_PRECISION_IN_DIGITS);
    });
  });

  describe('month rate', () => {
    test('at 16/hour', () => {
      const actual = monthRate(16, 0);
      expect(actual).toBe(2816);
    });

    test('at 25/hour', () => {
      const actual = monthRate(25, 0);
      expect(actual).toBe(4400);
    });

    test('at 25/hour with a 50% discount', () => {
      const actual = monthRate(25, 0.5);
      expect(actual).toBe(2200);
    });

    test('at 25/hour with a 1.23% discount', () => {
      const actual = monthRate(25, 0.0123);
      expect(actual).toBe(4346);
    });

    test('at 31.40/hour with a 5% discount', () => {
      const actual = monthRate(31.4, 0.05);
      expect(actual).toBe(5251);
    });

    test('at 89.89/hour with a 5% discount', () => {
      const actual = monthRate(89.89, 0.05);
      expect(actual).toBe(15030);
    });

    test('at 89.89/hour with a 5% discount', () => {
      const actual = monthRate(89.89, 0.05);
      expect(actual).toBe(15030);
    });

    test('at 97.654321/hour with a 5% discount', () => {
      const actual = monthRate(97.654321, 0.05);
      expect(actual).toBe(16328);
    });
  });

  describe('days in budget', () => {
    describe('with a budget of 1280', () => {
      test('at 16/hour', () => {
        const actual = daysInBudget(1280, 16, 0);
        const expected = 10;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });

      test('at 25/hour', () => {
        const actual = daysInBudget(1280, 25, 0);
        const expected = 6;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });

      test('at 25/hour with 30% discount', () => {
        const actual = daysInBudget(1280, 25, 0.3);
        const expected = 9;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });
    });

    describe('with a budget of 10.000', () => {
      test('at 25/hour with 5% discount', () => {
        const actual = daysInBudget(10000, 25, 0.05);
        const expected = 52;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });

      test('at 31.40/hour with 5% discount', () => {
        const actual = daysInBudget(10000, 31.4, 0.05);
        const expected = 41;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });

      test('at 89.89/hour with 5% discount', () => {
        const actual = daysInBudget(10000, 89.89, 0.05);
        const expected = 14;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });

      test('at 97.654321/hour with 5% discount', () => {
        const actual = daysInBudget(10000, 97.654321, 0.05);
        const expected = 13;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });
    });
  });
});
