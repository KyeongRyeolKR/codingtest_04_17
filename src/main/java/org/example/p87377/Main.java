package org.example.p87377;

import java.util.*;

public class Main {
}

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        return answer;
    }

    public Point intersection(int[] line1, int[] line2) {
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];

        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double divisor = A * D - B * C;

        // 분모가 0일 경우, 평행이여서 교점이 없다.
        if(divisor == 0) {
            return null;
        }

        double x = (B * F - E * D) / divisor;
        double y = (E * C - A * F) / divisor;

        // 정수인지 아닌지 판별
        if(x != (long) x) return null;
        if(y != (long) y) return null;

        return Point.of(x, y);
    }

    public Set<Point> intersections(int[][] line) {
        Set<Point> points = new HashSet<>();

        for(int i=0; i<line.length; i++) {
            for(int j=i+1; j<line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                Point point = intersection(line1, line2);

                if(point != null) points.add(point);
            }
        }

        return points;
    }

    public Point getMinPoint(Set<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for(Point point : points) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }

        return Point.of(x, y);
    }

    public Point getMaxPoint(Set<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point point : points) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }

        return Point.of(x, y);
    }
}

class Point {
    public final long x;
    public final long y;

    private Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    public static Point of(double x, double y) {
        return of((long) x, (long) y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}