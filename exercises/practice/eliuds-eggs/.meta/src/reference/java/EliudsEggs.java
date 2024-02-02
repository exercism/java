public class EliudsEggs {
    public int eggCount(int number) {
        var count = 0;
        var remaining = number;

        while (remaining > 0) {
            if ((remaining & 1) > 0) {
                count++;
            }
            remaining = remaining >> 1;
        }

        return count;
    }
}
