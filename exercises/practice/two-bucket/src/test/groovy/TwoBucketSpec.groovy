import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class TwoBucketSpec extends Specification {

    def 'measure an exact number of liters when goal is reachable'() {
        given:
        def twoBucket = new TwoBucket(capOne, capTwo, goal, startBucket)

        expect:
        with(twoBucket) {
            totalMoves == expectMoves
            finalBucket == expectFinal
            otherBucket == expectOther
        }

        where:
        capOne | capTwo | goal | startBucket || expectMoves | expectFinal | expectOther
        3      | 5      | 1    | 'one'       || 4           | 'one'       | 5
// Uncomment to run test
//        3      | 5      | 1    | 'two'       || 8           | 'two'       | 3
//        7      | 11     | 2    | 'one'       || 14          | 'one'       | 11
//        7      | 11     | 2    | 'two'       || 18          | 'two'       | 7
//        1      | 3      | 3    | 'two'       || 1           | 'two'       | 0
//        2      | 3      | 3    | 'one'       || 2           | 'two'       | 2
//        6      | 15     | 9    | 'one'       || 10          | 'two'       | 0
    }

    @Ignore("Remove to run test")
    @Unroll('#comment')
    def 'attempt to measure when the goal is unreachable'() {
        when:
        new TwoBucket(capOne, capTwo, goal, startBucket)

        then:
        thrown(IllegalArgumentException)

        where:
        capOne | capTwo | goal | startBucket || comment
        6      | 15     | 5    | 'one'       || 'not possible to reach the goal'
        5      | 7      | 8    | 'one'       || 'goal larger than both buckets is impossible'
    }
}
