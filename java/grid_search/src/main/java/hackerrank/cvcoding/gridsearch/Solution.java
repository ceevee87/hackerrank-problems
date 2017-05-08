/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.cvcoding.gridsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author johnr
 */
public class Solution {
    
    private static final List<String> _MainGrid = new ArrayList<>();
    private static int _mainGridRowCnt = 0;
    private static int _mainGridColCnt = 0;
    
    private static final List<String> _SubGrid = new ArrayList<>();
    private static int _subGridRowCnt = 0;
    private static int _subGridColCnt = 0;

    // the setter methods are useful when doing JUnit tests.
    public static void setMainGridRowCnt(int mainGridRowCnt) {
        Solution._mainGridRowCnt = mainGridRowCnt;
    }

    public static void setMainGridColCnt(int mainGridColCnt) {
        Solution._mainGridColCnt = mainGridColCnt;
    }

    public static void setSubGridRowCnt(int subGridRowCnt) {
        Solution._subGridRowCnt = subGridRowCnt;
    }

    public static void setSubGridColCnt(int subGridColCnt) {
        Solution._subGridColCnt = subGridColCnt;
    }
    
    // these addRow methods are going to be immensely useful when we write the
    // unit tests.
    public static void addMainGridRow(String row) {
        _MainGrid.add(row);
    }
    
    public static void addSubGridRow(String row) {
        _SubGrid.add(row);
    }
    
    // debugging purposes only.
    private static void printGrid() {
        for (String row : _MainGrid) {
            System.out.println(row);
        }
    }
    
    // I could have created separate functions for each grid but in this case
    // I really didn't need to. this just shortens things a bit.
    public static void clearGrids() {
        _MainGrid.clear();
        _SubGrid.clear();
        setMainGridColCnt(0);
        setMainGridRowCnt(0);
        setSubGridColCnt(0);
        setSubGridRowCnt(0);
    }
    
    private static void getInputData(Scanner scanIn) {
        _mainGridRowCnt = scanIn.nextInt();
        _mainGridColCnt = scanIn.nextInt();
        for(int G_i=0; G_i < _mainGridRowCnt; G_i++){
            addMainGridRow(scanIn.next());
        }
        _subGridRowCnt = scanIn.nextInt();
        _subGridColCnt = scanIn.nextInt();
        for(int P_i=0; P_i < _subGridRowCnt; P_i++){
            addSubGridRow(scanIn.next());
        }
    }
    
    public static void main(String args[]) {
        // this is the code that HackerRank is going to run.
        Scanner in;
        in = new Scanner(System.in);
        int numTests = in.nextInt();
        for(int a0 = 0; a0 < numTests; a0++){
            getInputData(in);
            if (subGridExistsInMainGrid())
                System.out.println("YES");
            else
                System.out.println("NO");
                
            clearGrids();
        }        
    }

    public static boolean subGridExistsInMainGrid() {
        // Junit test cases prove that the code below handles cases
        // when the row or column count of the sub-grid match the 
        // main grid exactly.
        
        // need to handle case where sub grid is larger than
        // the main grid (in row count and/or column count)
        if (_subGridRowCnt > _mainGridRowCnt) return false;
        if (_subGridColCnt > _mainGridColCnt) return false;
        
        // is it possible for the sub-grid to be empty?
        // if the pattern length is 0 then we can't match it.
        String inLinePattern = createSingleLinePattern();
        if (inLinePattern.length() == 0) return false;

        // we record first digit (char) in the sub-pattern. we'll iterate through
        // the main grid left to right, row by row. when we find a 
        // hit on that first character against the current character in the
        // loops below then we'll check for existence of the sub-pattern.
        char firstCharInPattern = inLinePattern.charAt(0);
        for (int row = 0; row < _mainGridRowCnt-_subGridRowCnt+1; row++) {
            String curRow = _MainGrid.get(row);
            for (int col = 0; col < _mainGridColCnt-_subGridColCnt+1; col++) {
                if (curRow.charAt(col) == firstCharInPattern) {
                    if (chkSubPatternAt(row, col, inLinePattern)) return true;
                    // old solution -- should fail the JUnit test #05 test.
//                     if (getSubPatternAt(row, col).equals(inLinePattern)) return true;
                }
            }
        }
        return false;
    }

    private static String createSingleLinePattern() {
        // we are taking a nxm sub-grid and creating a single line
        // sequence of characters that represents the sub-grid "stretched out"
        // this is going to make pattern matching easy.
        
        if (_SubGrid == null || _SubGrid.isEmpty()) return "";

        StringBuilder res = new StringBuilder();
        for (String row : _SubGrid)
            res.append(row);
        return res.toString();
    }

    private static String getSubPatternAt(int row, int col) {
        // this was the previous solution. it works but it just takes a long
        // time on big test cases because it doesn't bail out early if there
        // is a mismatch early on in the sub-pattern.
        StringBuilder res = new StringBuilder();
        for (int r = 0; r < _subGridRowCnt; r++) {
            res.append(_MainGrid.get(r+row).substring(col, col+_subGridColCnt));
        }
        return res.toString();
        
    }

    private static boolean chkSubPatternAt(int row, int col, String pat) {
        // pat : this is the sub-pattern that has been "enlogated" into a single
        // string.
        // in this routine we're going to skip ahead in the main grid to check
        // if each sub-string of a row is a match against the sub-pattern.
        //
        // example:
        // 
        //  1 9 3 5 0 5 6
        //  1 2 3 4 5 6 6
        //  5 9 7 5 2 2 1
        //  7 8 9 0 1 2 3
        //
        // sub-pattern:
        //
        //   3 4
        //   7 5
        //   9 0
        //
        // pat == 3 4 7 5 9 0
        //
        // the routine below is first called with row == 0. in the first loop
        // we compare x (3 5) against (3 4). that fails. we return false.
        //
        // in the second call to the routine the inner loop is called as such
        // loop 0:
        //    x (3 5) == (3 5) (pat.substring(0, 2)
        // loop 1: 
        //    x (7 5) == (7 5) (pat.substring(2, 4)
        // loop 2: 
        //    x (9 0) == (9 0) (pat.substring(4, 6)
        for (int r = 0; r < _subGridRowCnt; r++) {
            String x = _MainGrid.get(r+row).substring(col, col+_subGridColCnt);
            String y = pat.substring(r*_subGridColCnt, r*_subGridColCnt+_subGridColCnt);
            if (!x.equals(y)) return false;
        }
        return true;
    }
}
