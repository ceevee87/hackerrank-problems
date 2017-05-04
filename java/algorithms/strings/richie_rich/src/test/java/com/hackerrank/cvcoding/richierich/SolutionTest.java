/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.cvcoding.richierich;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.hackerrank.cvcoding.richierich.Solution.getMaxPalindromeKchanges;

/**
 *
 * @author johnr
 */
public class SolutionTest {
    
    public SolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    private boolean isPalindrome(String str) {
        if (str.length() < 2) return true;
        
        int ii = 0;
        int jj = str.length() - 1;
        
        while (ii < jj) {
          if (str.charAt(ii) != str.charAt(jj))
              return false;
          ii++;
          jj--;
        }
        return true;
    }
    
    /**
     * Test of countCharOccurence method, of class Solution.
     */
    @Test
    public void testCountCharOccurence_0() {
        System.out.println("-T-countCharOccurence-count existing, "
                + "multiple-instance character");
        String s = "132345637893";
        char c = '3';
        int expResult = 4;
        int result = Solution.countCharOccurence(s, c);
        assertEquals(expResult, result);
    }
    @Test
    public void testCountCharOccurence_1() {
        System.out.println("-T-countCharOccurence-count missing character");
        String s = "132345637893";
        char c = '0';
        int expResult = 0;
        int result = Solution.countCharOccurence(s, c);
        assertEquals(expResult, result);
    }
    @Test
    public void testCountCharOccurence_2() {
        System.out.println("-T-countCharOccurence-count character when char "
                + "is in first position.");
        String s = "73335556660011";
        char c = '7';
        int expResult = 1;
        int result = Solution.countCharOccurence(s, c);
        assertEquals(expResult, result);
    }
    @Test
    public void testCountCharOccurence_3() {
        System.out.println("-T-countCharOccurence-count character when char "
                + "is in last position.");
        String s = "733355566600118";
        char c = '8';
        int expResult = 1;
        int result = Solution.countCharOccurence(s, c);
        assertEquals(expResult, result);
    }
    @Test
    public void testCountCharOccurence_4() {
        System.out.println("-T-countCharOccurence-count character when string "
                + "is entirely made up of that char.");
        String s = "4444444444";
        char c = '4';
        int expResult = 10;
        int result = Solution.countCharOccurence(s, c);
        assertEquals(expResult, result);
    }
    @Test
    public void testCountCharOccurence_5() {
        System.out.println("-T-countCharOccurence-count single char in a "
                + "single length string.");
        String s = "6";
        char c = '6';
        int expResult = 1;
        int result = Solution.countCharOccurence(s, c);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxPalindromeKchanges method, of class Solution.
     */
    @Test
    public void testGetMaxStringNumWithKdigitChanges_A() {
        System.out.println("-T-getMaxPalindromeKchanges-base case A");
        String number = "3943";
        int k = 1;
        String expResult = "3993";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_B() {
        System.out.println("-T-getMaxPalindromeKchanges-base case B");
        String number = "092282";
        int k = 3;
        String expResult = "992299";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_0() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 0.");
        String number = "0011";
        int k = 1;
        String expResult = "-1";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_1() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 1.");
        String number = "777";
        int k = 0;
        String expResult = "777";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_2() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 2.");
        String number = "11331";
        int k = 4;
        String expResult = "99399";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_3() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 3.");
        String number = "932239";
        int k = 2;
        String expResult = "992299";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_4() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 4.");
        String number = "3943";
        int k = 4;
        String expResult = "9999";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_5() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 5.");
        String number = "11331";
        int k = 4;
        String expResult = "99399";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_6() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 6.");
        String number = "12321";
        int k = 1;
        String expResult = "12921";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_7() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 7.");
        String number = "12345";
        int k = 1;
        String expResult = "-1";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_8() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 8.");

        Scanner in;
        try {
            in = new Scanner(new File("src/test/resources/input/input08.txt"));
            int n = in.nextInt();
            int k = in.nextInt();
            String number = in.next();
        
            String res = getMaxPalindromeKchanges(number, k);
            String result = Solution.getMaxPalindromeKchanges(number, k);
            
            // this is easier than reading the golden output file, which
            // is all 9s.
            String expResult = String.join("", Collections.nCopies(n, "9"));

            assertEquals(expResult, result);
        } catch (FileNotFoundException ex) {
            assertEquals(false, true);
        }

    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_9() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 9.");

        Scanner in;
        try {
            in = new Scanner(new File("src/test/resources/input/input09.txt"));
            int n = in.nextInt();
            int k = in.nextInt();
            String number = in.next();
        
            String res = getMaxPalindromeKchanges(number, k);
            String result = Solution.getMaxPalindromeKchanges(number, k);
            
            // this is easier than reading the golden output file, which
            // is all 9s.
            String expResult = String.join("", Collections.nCopies(n, "9"));

            assertEquals(expResult, result);
        } catch (FileNotFoundException ex) {
            assertEquals(false, true);
        }
        
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_15() {
        System.out.println("-T-getMaxPalindromeKchanges-hackerrank test case 15.");
        Scanner in;
        try {
            in = new Scanner(new File("src/test/resources/input/input15.txt"));
            int n = in.nextInt();
            int k = in.nextInt();
            String number = in.next();
        
            String res = getMaxPalindromeKchanges(number, k);
            String result = Solution.getMaxPalindromeKchanges(number, k);
            
            // this is easier than reading the golden output file, which
            // is all 9s.
            String expResult = String.join("", Collections.nCopies(n, "9"));

            assertEquals(expResult, result);
        } catch (FileNotFoundException ex) {
            assertEquals(false, true);
        }
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_custom01() {
        System.out.println("-T-getMaxPalindromeKchanges custom test 01...");
        String number = "12345281211289681233214096872132134803219143209328";
        int k = 22;
        String expResult = "99395284291289883233227899872233238898219248259399";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
        assertEquals(true, isPalindrome(result));
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_custom02() {
        System.out.println("-T-getMaxPalindromeKchanges custom test 02...");
        int k = 0;
        String number =    "2912898832332278998722332388982192";
        String expResult = "2912898832332278998722332388982192";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
        assertEquals(true, isPalindrome(result));
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_custom03() {
        System.out.println("-T-getMaxPalindromeKchanges custom test 03...");
        int k = 0;
        String number =    "3";
        String expResult = "3";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
        assertEquals(true, isPalindrome(result));
    }
    @Test
    public void testGetMaxStringNumWithKdigitChanges_custom04() {
        System.out.println("-T-getMaxPalindromeKchanges custom test 04...");
        int k = 1;
        String number =    "4";
        String expResult = "9";
        String result = Solution.getMaxPalindromeKchanges(number, k);
        assertEquals(expResult, result);
        assertEquals(true, isPalindrome(result));
    }
    
}
