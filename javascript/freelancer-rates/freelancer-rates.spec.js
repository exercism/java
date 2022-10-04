// @ts-check

import {
  dayRate,
  daysInBudget,
  priceWithMonthlyDiscount,
} from './freelancer-rates';

const DIFFERENCE_PRECISION_IN_DIGITS = 6;

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

describe('days in budget', () => {
  describe('with a budget of 1280', () => {
    test('at 16/hour', () => {
      const actual = daysInBudget(1280, 16);
      const expected = 10;

      expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
    });

    test('at 25/hour', () => {
      const actual = daysInBudget(1280, 25);
      const expected = 6;

      expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
    });

    describe('with a budget of 835', () => {
      test('at 12/hour', () => {
        const actual = daysInBudget(835, 12);
        const expected = 8;

        expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
      });
    });
  });
});

describe('cost with monthly discount', () => {
  describe('at 16/hour', () => {
    test('for 70 days', () => {
      const actual = priceWithMonthlyDiscount(16, 70, 0);
      const expected = 8960;
      expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
    });

    test('for 130 days with 15% discount', () => {
      const actual = priceWithMonthlyDiscount(16, 130, 0.15);
      const expected = 14528;
      expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
    });
  });
  describe('at 29.654321/hour', () => {
    test('for 220 days with 11.2%', () => {
      const actual = priceWithMonthlyDiscount(29.654321, 220, 0.112);
      const expected = 46347;
      expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
    });

    test('for 155 days with 25.47% discount', () => {
      const actual = priceWithMonthlyDiscount(29.654321, 155, 0.2547);
      const expected = 27467;
      expect(actual).toBeCloseTo(expected, DIFFERENCE_PRECISION_IN_DIGITS);
    });
  });
});
