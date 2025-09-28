package assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ClosestPairTest {

    @Test
    public void testSimple() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4),
                new ClosestPair.Point(1, 1)
        };
        double result = ClosestPair.closestPair(pts);
        assertEquals(Math.sqrt(2), result, 1e-6);
    }

    @Test
    public void testTwoPoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(5, 0)
        };
        assertEquals(5.0, ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    public void testLine() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 0),
                new ClosestPair.Point(2, 0),
                new ClosestPair.Point(3, 0)
        };
        assertEquals(1.0, ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    public void testRandom() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };
        double result = ClosestPair.closestPair(pts);
        assertEquals(Math.sqrt(2), result, 1e-6);
    }
}
