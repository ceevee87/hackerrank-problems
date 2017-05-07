/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.cvcoding.algo_crush;

import static hackerrank.cvcoding.algo_crush.Solution._crushPoints;
import static hackerrank.cvcoding.algo_crush.Solution.addCrushPoints;
import static hackerrank.cvcoding.algo_crush.Solution.clearCrushPoints;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johnr
 */
public class SolutionTest {
    
    public SolutionTest() {
    }

    /**
     * Test of getMaxOverlappingSegmentsSum method, of class Solution.
     */
    @Test
    public void testGetMaxOverlappingSegmentsSum_A() {
        System.out.println("-T-algorithmic_crush_sampleA");
        clearCrushPoints();
        addCrushPoints(1, 2, 100);
        addCrushPoints(2, 5, 100);
        addCrushPoints(3, 4, 100);
        long expResult = 200L;
        long result = Solution.getMaxOverlappingSegmentsSum();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxOverlappingSegmentsSum_1() {
        System.out.println("-T-algorithmic_crush_hackerrank_test_1");
        clearCrushPoints();
        addCrushPoints(2, 3, 603);
        addCrushPoints(1, 1, 286);
        addCrushPoints(4, 4, 882);
        long expResult = 882L;
        long result = Solution.getMaxOverlappingSegmentsSum();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxOverlappingSegmentsSum_2() {
        System.out.println("-T-algorithmic_crush_hackerrank_test_2");
        clearCrushPoints();
        addCrushPoints(29, 40, 787);
        addCrushPoints(9, 26, 219);
        addCrushPoints(21, 31, 214);
        addCrushPoints(8, 22, 719);
        addCrushPoints(15, 23, 102);
        addCrushPoints(11, 24, 83);
        addCrushPoints(14, 22, 321);
        addCrushPoints(5, 22, 300);
        addCrushPoints(11, 30, 832);
        addCrushPoints(5, 25, 29);
        addCrushPoints(16, 24, 577);
        addCrushPoints(3, 10, 905);
        addCrushPoints(15, 22, 335);
        addCrushPoints(29, 35, 254);
        addCrushPoints(9, 20, 20);
        addCrushPoints(33, 34, 351);
        addCrushPoints(30, 38, 564);
        addCrushPoints(11, 31, 969);
        addCrushPoints(3, 32, 11);
        addCrushPoints(29, 35, 267);
        addCrushPoints(4, 24, 531);
        addCrushPoints(1, 38, 892);
        addCrushPoints(12, 18, 825);
        addCrushPoints(25, 32, 99);
        addCrushPoints(3, 39, 107);
        addCrushPoints(12, 37, 131);
        addCrushPoints(3, 26, 640);
        addCrushPoints(8, 39, 483);
        addCrushPoints(8, 11, 194);
        addCrushPoints(12, 37, 502);

        long expResult = 8628L;
        long result = Solution.getMaxOverlappingSegmentsSum();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxOverlappingSegmentsSum_5() {
        System.out.println("-T-algorithmic_crush_hackerrank_test_5");

        // by default the results are not equal. the test below should set
        // them equal if calculation run properly.
        long result = -1;
        long expResult = 0;
        
        clearCrushPoints();
        try {
            Scanner in = new Scanner(new File("src/test/resources/input/input05.txt"));
            int rangeSize = in.nextInt();
            int numOps = in.nextInt();
            for (int ii = 0; ii < numOps; ii++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int k = in.nextInt();
                addCrushPoints(a, b, k);
            }
            result = Solution.getMaxOverlappingSegmentsSum();
        } catch (FileNotFoundException ex) {
            assertEquals("File Found", "File NOT found");
        }

        try {
            Scanner ref = new Scanner(new File("src/test/resources/output/output05.txt"));
            expResult = ref.nextLong();
        } catch (FileNotFoundException ex) {
            assertEquals("File Found", "File NOT found");
        }
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxOverlappingSegmentsSum_6() {
        System.out.println("-T-algorithmic_crush_hackerrank_test_6");

        // by default the results are not equal. the test below should set
        // them equal if calculation run properly.
        long result = -1;
        long expResult = 0;
        
        clearCrushPoints();
        try {
            Scanner in = new Scanner(new File("src/test/resources/input/input06.txt"));
            int rangeSize = in.nextInt();
            int numOps = in.nextInt();
            for (int ii = 0; ii < numOps; ii++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int k = in.nextInt();
                addCrushPoints(a, b, k);
            }
            result = Solution.getMaxOverlappingSegmentsSum();
        } catch (FileNotFoundException ex) {
            assertEquals("File Found", "File NOT found");
        }

        try {
            Scanner ref = new Scanner(new File("src/test/resources/output/output06.txt"));
            expResult = ref.nextLong();
        } catch (FileNotFoundException ex) {
            assertEquals("File Found", "File NOT found");
        }
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxOverlappingSegmentsSum_12() {
        System.out.println("-T-algorithmic_crush_hackerrank_test_12");

        // by default the results are not equal. the test below should set
        // them equal if calculation run properly.
        long result = -1;
        long expResult = 0;
        
        clearCrushPoints();
        try {
            Scanner in = new Scanner(new File("src/test/resources/input/input12.txt"));
            int rangeSize = in.nextInt();
            int numOps = in.nextInt();
            for (int ii = 0; ii < numOps; ii++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int k = in.nextInt();
                addCrushPoints(a, b, k);
            }
            result = Solution.getMaxOverlappingSegmentsSum();
        } catch (FileNotFoundException ex) {
            assertEquals("File Found", "File NOT found");
        }

        try {
            Scanner ref = new Scanner(new File("src/test/resources/output/output12.txt"));
            expResult = ref.nextLong();
        } catch (FileNotFoundException ex) {
            assertEquals("File Found", "File NOT found");
        }
        assertEquals(expResult, result);
    }
    
}
