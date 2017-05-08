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
    
    public static void setMainGridRowCnt(int mainGridRowCnt) {
        Solution._mainGridRowCnt = mainGridRowCnt;
    }

    public static void setMainGridColCnt(int mainGridColCnt) {
        Solution._mainGridColCnt = mainGridColCnt;
    }

    private static final List<String> _SubGrid = new ArrayList<>();
    private static int _subGridRowCnt = 0;
    private static int _subGridColCnt = 0;

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
        
        // need to handle case where sub grid is larger than
        // the main grid (in row count and/or column count)
        
        // need to handle case where the sub grid column count
        // is exactly the size of the main grid column count
        
        // need to handle when the sub grid row count is exactly
        // the size of the main grid row count.
        
        // is it possible for the sub-grid to be empty?
        // what about the main grid?
        
        String inLinePattern = createSingleLinePattern();
        
        // if the pattern length is 0 then we can't match it.
        if (inLinePattern.length() == 0) return false;
            
        char firstCharInPattern = inLinePattern.charAt(0);
        for (int row = 0; row < _mainGridRowCnt-_subGridRowCnt+1; row++) {
            String curRow = _MainGrid.get(row);
            for (int col = 0; col < _mainGridColCnt-_subGridColCnt+1; col++) {
                if (curRow.charAt(col) == firstCharInPattern) {
                    String x = getSubPatternAt(row, col);
                    if (x.equals(inLinePattern)) return true;
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
        StringBuilder res = new StringBuilder();
        for (int r = 0; r < _subGridRowCnt; r++) {
            res.append(_MainGrid.get(r+row).substring(col, col+_subGridColCnt));
        }
        return res.toString();
        
    }
}
