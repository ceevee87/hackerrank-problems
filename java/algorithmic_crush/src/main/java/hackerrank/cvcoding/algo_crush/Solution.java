/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.cvcoding.algo_crush;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author johnr
 */
public class Solution {
    static final ArrayList<CrushPoint> _crushPoints = new ArrayList<>();
    
    // we'll need this guy when we sort the individual points by whether
    // the points are starting points or not. 
    static class CrushPointCompareStart implements Comparator<CrushPoint> {

        @Override
        public int compare(CrushPoint o1, CrushPoint o2) {
            if ((o1.isStart && o2.isStart) || 
                    (!o1.isStart && !o2.isStart)) {
                return 0;
            } else if (o1.isStart && !o2.isStart) {
                return -1;
            } else {
                return 1;
            }        
        }

    }
    // the key to this problem is decomposing the segment ((a, b), k) into two 
    // separate points *and* tracking whether each point (a or b) is the 
    // starting point of the segment. 
    // so, for segment ((a, b), k) we would store two crush points as follows
    //
    //  point a:  (a, k, true)
    //  point b:  (b, k, false)
    // 
    static class CrushPoint implements Comparable<CrushPoint> {
        int xloc;
        int val;
        boolean isStart;

        CrushPoint(int x, int v, boolean isStart) {
            this.xloc = x;
            this.val = v;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(CrushPoint other) {
            if (xloc != other.xloc)
                return xloc > other.xloc ? 1 : -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            String out = "xloc=" + xloc + "; val=" + val + "; " + isStart;
            return out;
        }
    }    
    
    public static long getMaxOverlappingSegmentsSum() {
        // sort all of the points such that all starting points are first
        // followed by all ending points ('a' points first then 'b' points).
        Collections.sort(_crushPoints, new CrushPointCompareStart());

        // do another round of sorting based on the points x-value (if you
        // think of each point, a or b, as a location along the x-axis.
        Collections.sort(_crushPoints);

        long maxSum = 0;
        long runningSum = 0;
        // the algorithm is straight forward now. we traverse all the points
        // keeping a running sum along the way. if a segment ends at the
        // same point another segment starts we first add the value of 
        // the new segment before subtracting the value of the ending 
        // segment. this is important in tracking the max sum.
        for (CrushPoint cp : _crushPoints) {
            if (cp.isStart) {
                runningSum += cp.val;
            }
            if (runningSum > maxSum) {
                maxSum = runningSum;
            }
            if (!cp.isStart) {
                runningSum -= cp.val;
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        if (args.length < 1) 
            // so, we decompose all the segments made up of end points (a, b) 
            // into individual entities a and b. these are the crushpoints and
            // we store them individually. 
            // to reiterate, if we have 10 segments, we'll be storing 20 points.
            getCrushPointsInput();

            System.out.println(getMaxOverlappingSegmentsSum());
    }
    
    static void getCrushPointsInput() {
        int rangeSize;
        int numOps;
        
        Scanner in = new Scanner(System.in);
        rangeSize = in.nextInt();
        numOps = in.nextInt();
        for (int ii = 0; ii < numOps; ii++) {
            int pt1 = in.nextInt();
            int pt2 = in.nextInt();
            int kval = in.nextInt();
            // pt1 and pt2 define a segment of sorts but we won't store
            // the data as a segment. we'll keep them as separate points but
            // record whether each points is a starting or ending point
            // of said segment.
            _crushPoints.add(new CrushPoint(pt1, kval, true));
            _crushPoints.add(new CrushPoint(pt2, kval, false));
        }
    }
    
    // this is valuable for running JUnit tests. otherwise, we don't 
    // need these guys for the native hackerrank solution.
    public static void addCrushPoints(int a, int b, int k) {
        _crushPoints.add(new CrushPoint(a, k, true));
        _crushPoints.add(new CrushPoint(b, k, false));
    }

    public static void clearCrushPoints() {
        _crushPoints.clear();
    }

}
