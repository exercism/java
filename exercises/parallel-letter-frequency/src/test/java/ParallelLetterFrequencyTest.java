import org.junit.*;

import static org.junit.Assert.*;

import java.util.concurrent.*;
import java.util.stream.*;
import java.util.*;

public class ParallelLetterFrequencyTest {

    // American national anthem
    private String StarSpangledBanner =
            "O say can you see by the dawn's early light,\n" +
                    "What so proudly we hailed at the twilight's last gleaming,\n" +
                    "Whose broad stripes and bright stars through the perilous fight,\n" +
                    "O'er the ramparts we watched, were so gallantly streaming?\n" +
                    "And the rockets' red glare, the bombs bursting in air,\n" +
                    "Gave proof through the night that our flag was still there;\n" +
                    "O say does that star-spangled banner yet wave,\n" +
                    "O'er the land of the free and the home of the brave?\n";


    @Test
    public void noTextsMeansNoLetters() {
        String input = "";
        Map<Integer, Integer> expectedOutput = new HashMap<Integer, Integer>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertEquals(expectedOutput, p.letterCounts());
    }

    @Ignore("Remove to run test")
    @Test
    public void oneLetterIsCorrectlyCounted() {
        String input = "a";
        Map<Integer, Integer> expectedOutput = new HashMap<Integer, Integer>() {
            {
                put((int) 'a', 1);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertEquals(expectedOutput, p.letterCounts());
    }

    @Ignore("Remove to run test")
    @Test
    public void resultsAreCaseInsensitive() {
        String input = "Aa";
        Map<Integer, Integer> expectedOutput = new HashMap<Integer, Integer>() {
            {
                put((int) 'a', 2);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertEquals(expectedOutput, p.letterCounts());
    }


    @Ignore("Remove to run test")
    @Test
    public void biggerEmptyTextsStillReturnNoResults() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            b.append(" ");
        }

        Map<Integer, Integer> expectedOutput = new HashMap<Integer, Integer>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(b.toString());

        assertEquals(expectedOutput, p.letterCounts());
    }

    @Ignore("Remove to run test")
    @Test
    public void manyRepetitionsOfTheSameTextGiveAPredictableResult() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            b.append("abc");
        }

        Map<Integer, Integer> expectedOutput = new HashMap<Integer, Integer>() {
            {
                put((int) 'a', 10000);
                put((int) 'b', 10000);
                put((int) 'c', 10000);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(b.toString());

        assertEquals(expectedOutput, p.letterCounts());
    }


    @Ignore("Remove to run test")
    @Test
    public void punctuationDoesntCount() {
        ParallelLetterFrequency p = new ParallelLetterFrequency(StarSpangledBanner);

        assertFalse(p.letterCounts().containsKey((int) ','));
    }

    @Ignore("Remove to run test")
    @Test
    public void numbersDontCount() {
        ParallelLetterFrequency p = new ParallelLetterFrequency("Testing, 1, 2, 3");

        assertFalse(p.letterCounts().containsKey((int) '1'));
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleThreadsGetUsed()
            throws InterruptedException, ExecutionException {


        class MyForkJoinWorkerThread extends ForkJoinWorkerThread {

            boolean wasStarted = false;

            public MyForkJoinWorkerThread(ForkJoinPool pool) {
                super(pool);
            }

            @Override
            public void start() {
                super.start();
                this.wasStarted = true;
            }
        }

        List<MyForkJoinWorkerThread> allThreads = new ArrayList<>();

        class MyForkJoinThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {
            public MyForkJoinThreadFactory() {
                super();
            }

            public MyForkJoinWorkerThread newThread(ForkJoinPool pool) {
                final MyForkJoinWorkerThread worker = new MyForkJoinWorkerThread(pool);
                worker.setName("Thread number: " + worker.getPoolIndex());
                allThreads.add(worker);
                return worker;
            }
        }

        MyForkJoinThreadFactory factory = new MyForkJoinThreadFactory();
        ForkJoinPool multiThreadPool = new ForkJoinPool(4, (ForkJoinPool.ForkJoinWorkerThreadFactory) factory, null, false);

        String input = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder b = new StringBuilder();
        for (int i = 1; i < 10000000; i++) {
            b.append(input);
        }

        Map<Integer, Integer> expectedOutput = new HashMap<Integer, Integer>() {
            {
                put((int) 'a', 10000000);
                put((int) 'b', 10000000);
                put((int) 'c', 10000000);
                put((int) 'd', 10000000);
                put((int) 'e', 10000000);
                put((int) 'f', 10000000);
                put((int) 'g', 10000000);
                put((int) 'h', 10000000);
                put((int) 'i', 10000000);
                put((int) 'j', 10000000);
                put((int) 'k', 10000000);
                put((int) 'l', 10000000);
                put((int) 'm', 10000000);
                put((int) 'n', 10000000);
                put((int) 'o', 10000000);
                put((int) 'p', 10000000);
                put((int) 'q', 10000000);
                put((int) 'r', 10000000);
                put((int) 's', 10000000);
                put((int) 't', 10000000);
                put((int) 'u', 10000000);
                put((int) 'v', 10000000);
                put((int) 'w', 10000000);
                put((int) 'x', 10000000);
                put((int) 'y', 10000000);
                put((int) 'z', 10000000);
            }
        };

        Map<Integer, Integer> multiCounts = multiThreadPool.submit(
                () -> (new ParallelLetterFrequency(b.toString()).letterCounts())
        ).get();

        boolean startedThreadCountEqualsPoolSize = allThreads.stream()
                .filter(thread -> thread.wasStarted)
                .count() == allThreads.size();

        assertTrue(startedThreadCountEqualsPoolSize);
    }
}
