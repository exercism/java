import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class ZebraPuzzle {
    private static final int FIRST = 1;
    private static final int MIDDLE = 3;

    private int red;
    private int green;
    private int ivory;
    private int yellow;
    private int blue;

    private int english;
    private int spaniard;
    private int ukrainian;
    private int japanese;
    private int norwegian;

    private int coffee;
    private int tea;
    private int milk;
    private int orangejuice;
    private int water;

    private int oldgold;
    private int kools;
    private int chesterfields;
    private int luckystrike;
    private int parliaments;

    private int dog;
    private int snails;
    private int fox;
    private int horse;
    private int zebra;

    private Map<Integer, String> nationalityNames = new HashMap<>();

    private String waterDrinker = "";
    private String zebraOwner = "";

    ZebraPuzzle() {
        this.solve();
    }

    private static boolean isJustRightOf(int neighbourA, int neighbourB) {
        return neighbourA - 1 == neighbourB;
    }

    private static boolean nextTo(int neighbourA, int neighbourB) {
        return isJustRightOf(neighbourA, neighbourB) || isJustRightOf(neighbourB, neighbourA);
    }

    private void solve() {
        allHouseAssignmentPermutations().forEach(this::solveHouseColors);
    }

    private void solveHouseColors(int[] colors) {
        red = colors[0];
        green = colors[1];
        ivory = colors[2];
        yellow = colors[3];
        blue = colors[4];

        if (isJustRightOf(green, ivory)) {
            allHouseAssignmentPermutations().forEach(this::solveNationalities);
        }
    }

    private void solveNationalities(int[] nationalities) {
        english = nationalities[0];
        spaniard = nationalities[1];
        ukrainian = nationalities[2];
        japanese = nationalities[3];
        norwegian = nationalities[4];

        if (red == english
                && norwegian == FIRST
                && nextTo(norwegian, blue)) {

            // record names for later use
            nationalityNames.put(english, "Englishman");
            nationalityNames.put(spaniard, "Spaniard");
            nationalityNames.put(ukrainian, "Ukrainian");
            nationalityNames.put(japanese, "Japanese");
            nationalityNames.put(norwegian, "Norwegian");

            allHouseAssignmentPermutations().forEach(this::solveBeverages);
        }
    }

    private void solveBeverages(int[] beverages) {
        coffee = beverages[0];
        tea = beverages[1];
        milk = beverages[2];
        orangejuice = beverages[3];
        water = beverages[4];

        if (coffee == green
                && ukrainian == tea
                && milk == MIDDLE) {
            allHouseAssignmentPermutations().forEach(this::solveCigars);
        }

    }

    private void solveCigars(int[] cigars) {
        oldgold = cigars[0];
        kools = cigars[1];
        chesterfields = cigars[2];
        luckystrike = cigars[3];
        parliaments = cigars[4];

        if (kools == yellow
                && luckystrike == orangejuice
                && japanese == parliaments) {
            allHouseAssignmentPermutations().forEach(this::solvePets);
        }
    }

    private void solvePets(int[] pets) {
        dog = pets[0];
        snails = pets[1];
        fox = pets[2];
        horse = pets[3];
        zebra = pets[4];

        if (spaniard == dog
                && oldgold == snails
                && nextTo(chesterfields, fox)
                && nextTo(kools, horse)) {
            this.waterDrinker = nationalityNames.get(water);
            this.zebraOwner = nationalityNames.get(zebra);
        }

    }

    String getWaterDrinker() {
        return this.waterDrinker;
    }

    String getZebraOwner() {
        return this.zebraOwner;
    }

    private static void swap(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static Stream.Builder<int[]> perms(
            int[] source, Stream.Builder<int[]> builder, int offsetLeft) {
        if (offsetLeft == source.length - 1) {
            builder.accept(Arrays.copyOf(source, source.length));
        } else {
            for (int i = offsetLeft; i < source.length; i++) {
                swap(source, offsetLeft, i);
                perms(source, builder, offsetLeft + 1);
                swap(source, offsetLeft, i);
            }
        }
        return builder;
    }

    private static Stream<int[]> perms(int[] source) {
        return perms(source, Stream.builder(), 0).build();
    }

    private static Stream<int[]> allHouseAssignmentPermutations() {
        return perms(new int[]{1, 2, 3, 4, 5});
    }

}
