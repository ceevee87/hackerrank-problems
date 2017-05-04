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
    
    private static boolean isPalindrome(String str) {
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
        
        // what if we are allowed to make more changes than there are digits
        // in the number? In that case, the answer will always be "99999...".
        // let's do that here.
        if (k >= numLen) {
            return String.join("", Collections.nCopies(numLen, "9"));
        }
        
        // unless we are not allowed to change any digits then the largest
        // single digit palindrome is 9.
        if (numLen == 1 && k > 0)
            return "9";
        
        // this is the scenario where we are not allowed to change anything!
        // boo!!!
        if (k == 0) {
            if (isPalindrome(number)) return number;
            return "-1";
        }
        
        // it matters if the number has an even or odd number of digits.
        int ii, jj;
        if ((numLen % 2) > 0) {
            jj = (numLen/2) + 1;
            ii = (numLen/2) - 1;            
        } else {
            jj = numLen/2;
            ii = jj-1;
        }
        
        // we are going to make a palindrome out of the input number.
        // this is a base requirement of the problem before we attempt to 
        // make it as large as possible.
        // now, we keep a special count of the 9 digit because it is special
        // later in the algorithm as we attempt to make the palindrome as large
        // as possible we'll be specifically adding in 9s. So, we'll account
        // for how many 9s we run into first while scanning the number-string.
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

        // we were barely able to convert the number to a palindrome in k moves.
        // we're done here. we can't make any more changes.
        if (k == 0) {
            return number;
        }
        
        // we were unable to convert the number to a palindrome in k moves.
        // we're done here. we can't make any more changes. return failure code.
        if (k < 0)
          return "-1";

        // k > 0
        // we were able to convert the number to palindrome as we still have
        // some extra moves (that amount is k) to make!!! 
        // let's use the remaining moves to fill in as many 9s as possible 
        // starting at the edges and working inwards.
        if (k > 1) {
            ii = 0;
            // we don't need a left pointer counting up and a right pointer
            // counting down. this is a palindrome. we'll just track the
            // left pointer (array index). from that we can calculate the
            // right point (array index).
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
