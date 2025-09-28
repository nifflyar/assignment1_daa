package assignment1;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {


    public static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x; this.y = y;
        }
    }


    public static double closestPair(Point[] points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("Need at least 2 points");
        }


        Point[] pts = points.clone();
        Arrays.sort(pts, Comparator.comparingDouble(p -> p.x));


        Point[] aux = pts.clone();

        return closest(pts, aux, 0, pts.length - 1);
    }


    private static double closest(Point[] pts, Point[] aux, int lo, int hi) {
        if (hi - lo <= 3) {
            return bruteForce(pts, lo, hi);
        }

        int mid = (lo + hi) / 2;
        double midX = pts[mid].x;

        double d1 = closest(pts, aux, lo, mid);
        double d2 = closest(pts, aux, mid + 1, hi);
        double d = Math.min(d1, d2);


        int m = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pts[i].x - midX) < d) {
                aux[m++] = pts[i];
            }
        }


        Arrays.sort(aux, 0, m, Comparator.comparingDouble(p -> p.y));


        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m && (aux[j].y - aux[i].y) < d; j++) {
                d = Math.min(d, dist(aux[i], aux[j]));
            }
        }
        return d;
    }


    private static double bruteForce(Point[] pts, int lo, int hi) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                min = Math.min(min, dist(pts[i], pts[j]));
            }
        }
        return min;
    }


    private static double dist(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
