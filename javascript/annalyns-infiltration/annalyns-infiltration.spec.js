import {
  canExecuteFastAttack,
  canSpy,
  canSignalPrisoner,
  canFreePrisoner,
} from './annalyns-infiltration';

describe("Annalyn's infiltration", () => {
  describe('can execute fast attack', () => {
    test('when the knight is awake', () => {
      const knightIsAwake = true;
      const expected = false;

      expect(canExecuteFastAttack(knightIsAwake)).toBe(expected);
    });

    test('when the knight is asleep', () => {
      const knightIsAwake = false;
      const expected = true;

      expect(canExecuteFastAttack(knightIsAwake)).toBe(expected);
    });
  });

  describe('can spy', () => {
    test('when everyone is asleep', () => {
      const knightIsAwake = false;
      const archerIsAwake = false;
      const prisonerIsAwake = false;
      const expected = false;

      expect(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).toBe(
        expected
      );
    });

    test('when only the prisoner is awake', () => {
      const knightIsAwake = false;
      const archerIsAwake = false;
      const prisonerIsAwake = true;
      const expected = true;

      expect(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).toBe(
        expected
      );
    });

    test('when only the archer is awake', () => {
      const knightIsAwake = false;
      const archerIsAwake = true;
      const prisonerIsAwake = false;
      const expected = true;

      expect(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).toBe(
        expected
      );
    });

    test('when only the knight is asleep', () => {
      const knightIsAwake = false;
      const archerIsAwake = true;
      const prisonerIsAwake = true;
      const expected = true;

      expect(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).toBe(
        expected
      );
    });

    test('when only the knight is awake', () => {
      const knightIsAwake = true;
      const archerIsAwake = false;
      const prisonerIsAwake = false;
      const expected = true;

      expect(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).toBe(
        expected
      );
    });

    test('when only the archer is asleep', () => {
      const knightIsAwake = true;
      const archerIsAwake = false;
      const prisonerIsAwake = true;
      const expected = true;

      expect(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).toBe(
        expected
      );
    });

    test('when everyone is awake', () => {
      const knightIsAwake = true;
      const archerIsAwake = true;
      const prisonerIsAwake = true;
      const expected = true;

      expect(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).toBe(
        expected
      );
    });
  });

  describe('can signal prisoner', () => {
    test('when everyone is asleep', () => {
      const archerIsAwake = false;
      const prisonerIsAwake = false;
      const expected = false;

      expect(canSignalPrisoner(archerIsAwake, prisonerIsAwake)).toBe(expected);
    });

    test('when only the prisoner is awake', () => {
      const archerIsAwake = false;
      const prisonerIsAwake = true;
      const expected = true;

      expect(canSignalPrisoner(archerIsAwake, prisonerIsAwake)).toBe(expected);
    });

    test('when only the archer is awake', () => {
      const archerIsAwake = true;
      const prisonerIsAwake = false;
      const expected = false;

      expect(canSignalPrisoner(archerIsAwake, prisonerIsAwake)).toBe(expected);
    });

    test('when everyone is awake', () => {
      const archerIsAwake = true;
      const prisonerIsAwake = true;
      const expected = false;

      expect(canSignalPrisoner(archerIsAwake, prisonerIsAwake)).toBe(expected);
    });
  });

  describe('can free prisoner', () => {
    test('when everyone is asleep and pet dog is not present', () => {
      const knightIsAwake = false;
      const archerIsAwake = false;
      const prisonerIsAwake = false;
      const petDogIsPresent = false;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when everyone is asleep and pet dog is present', () => {
      const knightIsAwake = false;
      const archerIsAwake = false;
      const prisonerIsAwake = false;
      const petDogIsPresent = true;
      const expected = true;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the prisoner is awake and pet dog is not present', () => {
      const knightIsAwake = false;
      const archerIsAwake = false;
      const prisonerIsAwake = true;
      const petDogIsPresent = false;
      const expected = true;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the prisoner is awake and pet dog is present', () => {
      const knightIsAwake = false;
      const archerIsAwake = false;
      const prisonerIsAwake = true;
      const petDogIsPresent = true;
      const expected = true;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the archer is awake and pet dog is not present', () => {
      const knightIsAwake = false;
      const archerIsAwake = true;
      const prisonerIsAwake = false;
      const petDogIsPresent = false;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the archer is awake and pet dog is present', () => {
      const knightIsAwake = false;
      const archerIsAwake = true;
      const prisonerIsAwake = false;
      const petDogIsPresent = true;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the knight is asleep and pet dog is not present', () => {
      const knightIsAwake = false;
      const archerIsAwake = true;
      const prisonerIsAwake = true;
      const petDogIsPresent = false;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the knight is asleep and pet dog is present', () => {
      const knightIsAwake = false;
      const archerIsAwake = true;
      const prisonerIsAwake = true;
      const petDogIsPresent = true;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the knight is awake and pet dog is not present', () => {
      const knightIsAwake = true;
      const archerIsAwake = false;
      const prisonerIsAwake = false;
      const petDogIsPresent = false;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the knight is awake and pet dog is present', () => {
      const knightIsAwake = true;
      const archerIsAwake = false;
      const prisonerIsAwake = false;
      const petDogIsPresent = true;
      const expected = true;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the archer is asleep and pet dog is not present', () => {
      const knightIsAwake = true;
      const archerIsAwake = false;
      const prisonerIsAwake = true;
      const petDogIsPresent = false;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the archer is asleep and pet dog is present', () => {
      const knightIsAwake = true;
      const archerIsAwake = false;
      const prisonerIsAwake = true;
      const petDogIsPresent = true;
      const expected = true;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the prisoner is asleep and pet dog is not present', () => {
      const knightIsAwake = true;
      const archerIsAwake = true;
      const prisonerIsAwake = false;
      const petDogIsPresent = false;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when only the prisoner is asleep and pet dog is present', () => {
      const knightIsAwake = true;
      const archerIsAwake = true;
      const prisonerIsAwake = false;
      const petDogIsPresent = true;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when everyone is awake and pet dog is not present', () => {
      const knightIsAwake = true;
      const archerIsAwake = true;
      const prisonerIsAwake = true;
      const petDogIsPresent = false;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });

    test('when everyone is awake and pet dog is present', () => {
      const knightIsAwake = true;
      const archerIsAwake = true;
      const prisonerIsAwake = true;
      const petDogIsPresent = true;
      const expected = false;

      expect(
        canFreePrisoner(
          knightIsAwake,
          archerIsAwake,
          prisonerIsAwake,
          petDogIsPresent
        )
      ).toBe(expected);
    });
  });
});
