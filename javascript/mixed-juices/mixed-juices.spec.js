import { timeToMixJuice, limesToCut, remainingOrders } from './mixed-juices';

describe('timeToMixJuice', () => {
  test("returns the correct time for 'Pure Strawberry Joy'", () => {
    expect(timeToMixJuice('Pure Strawberry Joy')).toBe(0.5);
  });

  test('returns the correct times for all other standard menu items', () => {
    expect(timeToMixJuice('Energizer')).toBe(1.5);
    expect(timeToMixJuice('Green Garden')).toBe(1.5);
    expect(timeToMixJuice('Tropical Island')).toBe(3);
    expect(timeToMixJuice('All or Nothing')).toBe(5);
  });

  test('returns the same time for all other juices', () => {
    const defaultTime = 2.5;
    expect(timeToMixJuice('Limetime')).toBe(defaultTime);
    expect(timeToMixJuice('Manic Organic')).toBe(defaultTime);
    expect(timeToMixJuice('Papaya & Peach')).toBe(defaultTime);
  });
});

describe('limesToCut', () => {
  test('calculates the number of limes needed to reach the target supply', () => {
    const limes = [
      'small',
      'large',
      'large',
      'medium',
      'small',
      'large',
      'large',
      'medium',
    ];
    expect(limesToCut(42, limes)).toBe(6);

    expect(limesToCut(4, ['medium', 'small'])).toBe(1);
  });

  test('uses up all limes if there are not enough to reach the target', () => {
    const limes = [
      'small',
      'large',
      'large',
      'medium',
      'small',
      'large',
      'large',
    ];

    expect(limesToCut(80, limes)).toBe(7);
  });

  test('if no new wedges are needed, no limes are cut', () => {
    expect(limesToCut(0, ['small', 'large', 'medium'])).toBe(0);
  });

  test('works if no limes are available', () => {
    expect(limesToCut(10, [])).toBe(0);
  });
});

describe('remainingOrders', () => {
  test('correctly determines the remaining orders', () => {
    const orders = [
      'Tropical Island',
      'Energizer',
      'Limetime',
      'All or Nothing',
      'Pure Strawberry Joy',
    ];
    const expected = ['All or Nothing', 'Pure Strawberry Joy'];

    expect(remainingOrders(7, orders)).toEqual(expected);
  });

  test('correctly handles orders that were started because there was time left', () => {
    const orders = [
      'Pure Strawberry Joy',
      'Pure Strawberry Joy',
      'Vitality',
      'Tropical Island',
      'All or Nothing',
      'All or Nothing',
      'All or Nothing',
      'Green Garden',
      'Limetime',
    ];
    const expected = ['All or Nothing', 'Green Garden', 'Limetime'];

    expect(remainingOrders(13, orders)).toEqual(expected);
  });

  test('counts all orders as fulfilled if there is enough time', () => {
    const orders = [
      'Energizer',
      'Green Garden',
      'Ruby Glow',
      'Pure Strawberry Joy',
      'Tropical Island',
      'Limetime',
    ];

    expect(remainingOrders(12, orders)).toEqual([]);
  });

  test('works if there is only very little time left', () => {
    const orders = ['Bananas Gone Wild', 'Pure Strawberry Joy'];
    const expected = ['Pure Strawberry Joy'];

    expect(remainingOrders(0.2, orders)).toEqual(expected);
  });
});
