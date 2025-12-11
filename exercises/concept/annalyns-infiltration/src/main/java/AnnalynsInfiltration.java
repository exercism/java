class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake){
        // throw new UnsupportedOperationException("Please implement the (static) AnnalynsInfiltration.canFastAttack() method");
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        //   throw new UnsupportedOperationException("Please implement the (static) AnnalynsInfiltration.canSpy() method");
        return ((knightIsAwake || archerIsAwake) || prisonerIsAwake);
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        //   throw new UnsupportedOperationException("Please implement the (static) AnnalynsInfiltration.canSignalPrisoner() method");
        return !archerIsAwake && prisonerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        //     throw new UnsupportedOperationException("Please implement the (static) AnnalynsInfiltration.canFreePrisoner() method");
        return (prisonerIsAwake && !archerIsAwake && !knightIsAwake) || (!archerIsAwake && petDogIsPresent);
    }
}