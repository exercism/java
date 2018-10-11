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
        int[] houses = new int[]{1, 2, 3, 4, 5};
        int first = 1;
        int middle = 3;

        perms(houses).forEach(colors -> {
            int red = colors[0];
            int green = colors[1];
            int ivory = colors[2];
            int yellow = colors[3];
            int blue = colors[4];

            if (!isJustRightOf(green, ivory)) {
                return;
            }

            perms(houses).forEach(nationalities -> {
                int english = nationalities[0];
                int spaniard = nationalities[1];
                int ukrainian = nationalities[2];
                int japanese = nationalities[3];
                int norwegian = nationalities[4];

                if (red != english) {
                    return;
                }
                if (norwegian != first) {
                    return;
                }
                if (!nextTo(norwegian, blue)) {
                    return;
                }

                perms(houses).forEach(beverages -> {
                    int coffee = beverages[0];
                    int tea = beverages[1];
                    int milk = beverages[2];
                    int orangejuice = beverages[3];
                    int water = beverages[4];

                    if (coffee != green) {
                        return;
                    }
                    if (ukrainian != tea) {
                        return;
                    }
                    if (milk != middle) {
                        return;
                    }

                    perms(houses).forEach(cigars -> {
                        int oldgold = cigars[0];
                        int kools = cigars[1];
                        int chesterfields = cigars[2];
                        int luckystrike = cigars[3];
                        int parliaments = cigars[4];

                        if (kools != yellow) {
                            return;
                        }
                        if (luckystrike != orangejuice) {
                            return;
                        }
                        if (japanese != parliaments) {
                            return;
                        }

                        perms(houses).forEach(pets -> {
                            int dog = pets[0];
                            int snails = pets[1];
                            int fox = pets[2];
                            int horse = pets[3];
                            int zebra = pets[4];

                            if (spaniard != dog) {
                                return;
                            }
                            if (oldgold != snails) {
                                return;
                            }
                            if (!nextTo(chesterfields, fox)) {
                                return;
                            }
                            if (!nextTo(kools, horse)) {
                                return;
                            }

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
            for (int i = l; i < a.length; i++) {
                swap(a, l, i);
                perms(a, builder, l + 1);
                swap(a, l, i);
            }
        }
        return builder;
    }

    static Stream<int[]> perms(int[] a) {
        return perms(a, Stream.builder(), 0).build();
    }

}
