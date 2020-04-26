/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    public List<LineSegment> lsegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException();
        }

        lsegments = new ArrayList<LineSegment>();
        int n = points.length;
        Arrays.sort(points);


        for (int i = 0; i < n; i++) {
            Point p = points[i];
            for (int j = i + 1; j < n; j++) {
                Point q = points[j];
                for (int k = j + 1; k < n; k++) {
                    Point r = points[k];
                    if (p.slopeTo(q) == q.slopeTo(r)) {
                        for (int m = k + 1; m < n; m++) {
                            Point s = points[m];
                            if (p.slopeTo(r) == r.slopeTo(s)) {

                                LineSegment line = new LineSegment(p, s);
                                lsegments.add(line);


                            }
                        }
                    }
                }

            }
        }

    }

    public int numberOfSegments() {

        return lsegments.size();

    }


    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        BruteCollinearPoints brute = new BruteCollinearPoints(points);


        System.out.println(brute.numberOfSegments());


    }
}
