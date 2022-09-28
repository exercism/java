import {
  needsLicense,
  chooseVehicle,
  calculateResellPrice,
} from './vehicle-purchase';

describe('needsLicense', () => {
  test('requires a license for a car', () => {
    expect(needsLicense('car')).toBe(true);
  });

  test('requires a license for a truck', () => {
    expect(needsLicense('truck')).toBe(true);
  });

  test('does not require a license for a bike', () => {
    expect(needsLicense('bike')).toBe(false);
  });

  test('does not require a license for a stroller', () => {
    expect(needsLicense('stroller')).toBe(false);
  });

  test('does not require a license for an e-scooter', () => {
    expect(needsLicense('e-scooter')).toBe(false);
  });
});

describe('chooseVehicle', () => {
  const rest = ' is clearly the better choice.';

  test('correctly recommends the first option', () => {
    expect(chooseVehicle('Bugatti Veyron', 'Ford Pinto')).toBe(
      'Bugatti Veyron' + rest
    );
    expect(chooseVehicle('Chery EQ', 'Kia Niro Elektro')).toBe(
      'Chery EQ' + rest
    );
  });

  test('correctly recommends the second option', () => {
    expect(chooseVehicle('Ford Pinto', 'Bugatti Veyron')).toBe(
      'Bugatti Veyron' + rest
    );
    expect(chooseVehicle('2020 Gazelle Medeo', '2018 Bergamont City')).toBe(
      '2018 Bergamont City' + rest
    );
  });
});

describe('calculateResellPrice', () => {
  test('price is reduced to 80% for age below 3', () => {
    expect(calculateResellPrice(40000, 2)).toBe(32000);
    expect(calculateResellPrice(40000, 2.5)).toBe(32000);
  });

  test('price is reduced to 50% for age above 10', () => {
    expect(calculateResellPrice(40000, 12)).toBe(20000);
  });

  test('price is reduced to 70% for between 3 and 10', () => {
    expect(calculateResellPrice(25000, 7)).toBe(17500);
  });

  test('works correctly for threshold age 3', () => {
    expect(calculateResellPrice(40000, 3)).toBe(28000);
  });

  test('works correctly for threshold age 10', () => {
    expect(calculateResellPrice(25000, 10)).toBe(17500);
  });
});
