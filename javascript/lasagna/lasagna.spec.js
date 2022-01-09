import {
  // eslint-disable-next-line import/named
  EXPECTED_MINUTES_IN_OVEN,
  remainingMinutesInOven,
  preparationTimeInMinutes,
  totalTimeInMinutes,
} from './lasagna';

describe('EXPECTED_MINUTES_IN_OVEN', () => {
  test('constant is defined correctly', () => {
    expect(EXPECTED_MINUTES_IN_OVEN).toBe(40);
  });
});

describe('remainingMinutesInOven', () => {
  test('calculates the remaining time', () => {
    expect(remainingMinutesInOven(25)).toBe(15);
    expect(remainingMinutesInOven(5)).toBe(35);
    expect(remainingMinutesInOven(39)).toBe(1);
  });

  test('works correctly for the edge cases', () => {
    expect(remainingMinutesInOven(40)).toBe(0);
    expect(remainingMinutesInOven(0)).toBe(40);
  });
});

describe('preparationTimeInMinutes', () => {
  test('calculates the preparation time', () => {
    expect(preparationTimeInMinutes(1)).toBe(2);
    expect(preparationTimeInMinutes(2)).toBe(4);
    expect(preparationTimeInMinutes(8)).toBe(16);
  });
});

describe('totalTimeInMinutes', () => {
  test('calculates the total cooking time', () => {
    expect(totalTimeInMinutes(1, 5)).toBe(7);
    expect(totalTimeInMinutes(4, 15)).toBe(23);
    expect(totalTimeInMinutes(1, 35)).toBe(37);
  });
});
