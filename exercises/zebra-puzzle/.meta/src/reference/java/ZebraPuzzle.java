import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class ZebraPuzzle {
    private String waterDrinker = "";
    private String zebraOwner = "";

    ZebraPuzzle() {
        this.solve();
    }

    private static boolean isJustRightOf(int a, int b) {
        return a - 1 == b;
    }

    private static boolean nextTo(int a, int b) {
        return isJustRightOf(a, b) || isJustRightOf(b, a);
    }

    private void solve() {
        int[] houses = new int[]{1,2,3,4,5};
        int first = 1;
        int middle = 3;

        perms(houses).forEach(colors -> {
            int red = colors[0], green = colors[1], ivory = colors[2], yellow = colors[3], blue = colors[4];

            if (!isJustRightOf(green, ivory)) return;

            perms(houses).forEach(nationalities -> {
                int english = nationalities[0], spaniard = nationalities[1], ukrainian = nationalities[2], japanese = nationalities[3], norwegian = nationalities[4];

                if (red != english) return;
                if (norwegian != first) return;
                if (!nextTo(norwegian, blue)) return;

                perms(houses).forEach(beverages -> {
                    int coffee = beverages[0], tea = beverages[1], milk = beverages[2], orangejuice = beverages[3], water = beverages[4];

                    if (coffee != green) return;
                    if (ukrainian != tea) return;
                    if (milk != middle) return;

                    perms(houses).forEach(cigars -> {
                        int oldgold = cigars[0], kools = cigars[1], chesterfields = cigars[2], luckystrike = cigars[3], parliaments = cigars[4];

                        if (kools != yellow) return;
                        if (luckystrike != orangejuice) return;
                        if (japanese != parliaments) return;

                        perms(houses).forEach(pets -> {
                            int dog = pets[0], snails = pets[1], fox = pets[2], horse = pets[3], zebra = pets[4];

                            if (spaniard != dog) return;
                            if (oldgold != snails) return;
                            if (!nextTo(chesterfields, fox)) return;
                            if (!nextTo(kools, horse)) return;

                            Map<Integer, String> resultMap = new HashMap<>();
                            resultMap.put(english, "Englishman");
                            resultMap.put(spaniard, "Spaniard");
                            resultMap.put(ukrainian, "Ukrainian");
                            resultMap.put(japanese, "Japanese");
                            resultMap.put(norwegian, "Norwegian");

                            this.waterDrinker = resultMap.get(water);
                            this.zebraOwner = resultMap.get(zebra);
                        });
                    });
                });
            });
        });
    }

    String getWaterDrinker() {
        return this.waterDrinker;
    }

    String getZebraOwner() {
        return this.zebraOwner;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static Stream.Builder<int[]> perms(int[] a, Stream.Builder<int[]> builder, int l) {
        if (l == a.length - 1) {
            builder.accept(Arrays.copyOf(a, a.length));
        } else {
            for (int i=l; i < a.length; i++) {
                swap(a, l, i);
                perms(a, builder, l+1);
                swap(a, l, i);
            }
        }
        return builder;
    }

    static Stream<int[]> perms(int[] a) {
        return perms(a, Stream.builder(), 0).build();
    }

}
