/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.cvcoding.richierich;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author johnr
 */
public class Solution {
    
    public static int countCharOccurence(String s, char c) {
        long count = s.toLowerCase().chars().filter(e -> e == c).count();
        return (int) count;
    }

    private static String replaceCharAt(String s, int i, char c) {
        StringBuffer buf;
        buf = new StringBuffer(s);
        buf.setCharAt(i, c);
        return buf.toString();
    }
    
    public static void main(String[] args) {
        // the original specification of the problrem requires that we take
        // input from stdin.
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();

        String res = getMaxPalindromeKchanges(number, k);
        System.out.println(res);
    }    

    public static String getMaxPalindromeKchanges(String number, int k) {
        int numLen = number.length();
        if (k >= numLen) {
            return String.join("", Collections.nCopies(numLen, "9"));
        }
        if (numLen == 1)
            return "9";
        
        // it matters if the number has an even or odd number of digits.
        int ii, jj;
        if ((numLen % 2) > 0) {
            jj = (numLen/2) + 1;
            ii = (numLen/2) - 1;            
        } else {
            jj = numLen/2;
            ii = jj-1;
        }
        
        int da_nines = countCharOccurence(number, '9');
        while (jj < numLen) {
            if (k >= (2*(ii+1)-da_nines))
                break;

            if (number.charAt(ii) == '9')
              da_nines -= 1;
            
            if (number.charAt(jj) == '9')
              da_nines -= 1;

            if (number.charAt(ii) == number.charAt(jj)) {
              ii -= 1;
              jj += 1;
              continue;
            }
            
            if (number.charAt(ii) > number.charAt(jj))
                number = replaceCharAt(number, jj, number.charAt(ii));
            else
                number = replaceCharAt(number, ii, number.charAt(jj));
            
            k--;
            ii--;
            jj++;
        }
        
        if (k == 0) {
            return number;
        }
        
        if (k < 0)
          return "-1";
        else {
            // k > 0
            // we have enough k-s to make this number a palindrome.
            // we just need to fill in as many 9s as possible starting
            // at the edges and working inwards.
            if (k > 1) {
                ii = 0;
                while (ii < numLen/2 && k > 0) {
                    if (number.charAt(ii) != '9') {
                        number = replaceCharAt(number, ii, '9');
                        k--;
                    }
                    if (number.charAt(numLen-ii-1) != '9') {
                        number = replaceCharAt(number, numLen-ii-1, '9');
                        k--;
                    }
                    ii++;
                }
            }                        
            // if there is a left-over k then let's deal with it
            // the case below is only for odd-length numbers
            // and k should equal 1 at this point
            if ((numLen % 2) > 0 && (k % 2) > 0) {
                if (number.charAt((numLen-1)/2) != '9') {
                    number = replaceCharAt(number, (numLen-1)/2, '9');
                    k--;
                }
            }
            return number;
        }
    }
}
