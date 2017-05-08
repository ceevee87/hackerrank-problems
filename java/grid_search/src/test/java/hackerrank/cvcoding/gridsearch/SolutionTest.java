/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank.cvcoding.gridsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johnr
 */
public class SolutionTest {
    
    public SolutionTest() {
    }
    
    @Test
    public void testSubGridExistsInMainGrid_custom1() {
        // match one row exactly.
        System.out.println("-T-main solution-sample test case custom1.");
        Solution.clearGrids();
        Solution.addMainGridRow("7283455864");
        Solution.addMainGridRow("6731158619");
        Solution.addMainGridRow("8988242643");
        Solution.addMainGridRow("3830589324");
        Solution.addMainGridRow("2229505813");
        Solution.addMainGridRow("5633845374");
        Solution.addMainGridRow("6473530293");
        Solution.addMainGridRow("7053106601");
        Solution.addMainGridRow("0834282956");
        Solution.addMainGridRow("4607924137");
        
        Solution.addSubGridRow("2229505813");

        Solution.setMainGridRowCnt(10);
        Solution.setMainGridColCnt(10);
        Solution.setSubGridRowCnt(1);
        Solution.setSubGridColCnt(10);
        
        assertEquals(true, Solution.subGridExistsInMainGrid());
    }
    @Test
    public void testSubGridExistsInMainGrid_custom2() {
        // match one column exactly.
        System.out.println("-T-main solution-sample test case custom2.");
        Solution.clearGrids();
        Solution.addMainGridRow("7283455864");
        Solution.addMainGridRow("6731158619");
        Solution.addMainGridRow("8988242643");
        Solution.addMainGridRow("3830589324");
        Solution.addMainGridRow("2229505813");
        
        Solution.addSubGridRow("7");
        Solution.addSubGridRow("6");
        Solution.addSubGridRow("8");
        Solution.addSubGridRow("3");
        Solution.addSubGridRow("2");

        Solution.setMainGridRowCnt(5);
        Solution.setMainGridColCnt(10);
        Solution.setSubGridRowCnt(5);
        Solution.setSubGridColCnt(1);
        
        assertEquals(true, Solution.subGridExistsInMainGrid());
    }
    @Test
    public void testSubGridExistsInMainGrid_custom3() {
        // match the entire grid exactly.
        System.out.println("-T-main solution-sample test case custom3.");
        Solution.clearGrids();
        Solution.addMainGridRow("7283455864");
        Solution.addMainGridRow("6731158619");
        Solution.addMainGridRow("8988242643");
        Solution.addMainGridRow("3830589324");
        Solution.addMainGridRow("2229505813");
        
        Solution.addSubGridRow("7283455864");
        Solution.addSubGridRow("6731158619");
        Solution.addSubGridRow("8988242643");
        Solution.addSubGridRow("3830589324");
        Solution.addSubGridRow("2229505813");

        Solution.setMainGridRowCnt(5);
        Solution.setMainGridColCnt(10);
        Solution.setSubGridRowCnt(5);
        Solution.setSubGridColCnt(10);
        
        assertEquals(true, Solution.subGridExistsInMainGrid());
    }

    @Test
    public void testSubGridExistsInMainGrid_A1() {
        System.out.println("-T-main solution-sample test case A1.");
        Solution.clearGrids();
        Solution.addMainGridRow("7283455864");
        Solution.addMainGridRow("6731158619");
        Solution.addMainGridRow("8988242643");
        Solution.addMainGridRow("3830589324");
        Solution.addMainGridRow("2229505813");
        Solution.addMainGridRow("5633845374");
        Solution.addMainGridRow("6473530293");
        Solution.addMainGridRow("7053106601");
        Solution.addMainGridRow("0834282956");
        Solution.addMainGridRow("4607924137");
        
        Solution.addSubGridRow("9505");
        Solution.addSubGridRow("3845");
        Solution.addSubGridRow("3530");

        Solution.setMainGridRowCnt(10);
        Solution.setMainGridColCnt(10);
        Solution.setSubGridRowCnt(3);
        Solution.setSubGridColCnt(4);
        
        assertEquals(true, Solution.subGridExistsInMainGrid());
    }
    @Test
    public void testSubGridExistsInMainGrid_A2() {
        System.out.println("-T-main solution-sample test case A2.");
        Solution.clearGrids();
        Solution.addMainGridRow("400453592126560");
        Solution.addMainGridRow("114213133098692");
        Solution.addMainGridRow("474386082879648");
        Solution.addMainGridRow("522356951189169");
        Solution.addMainGridRow("887109450487496");
        Solution.addMainGridRow("252802633388782");
        Solution.addMainGridRow("502771484966748");
        Solution.addMainGridRow("075975207693780");
        Solution.addMainGridRow("511799789562806");
        Solution.addMainGridRow("404007454272504");
        Solution.addMainGridRow("549043809916080");
        Solution.addMainGridRow("962410809534811");
        Solution.addMainGridRow("445893523733475");
        Solution.addMainGridRow("768705303214174");
        Solution.addMainGridRow("650629270887160");
        
        
        Solution.addSubGridRow("99");
        Solution.addSubGridRow("99");

        Solution.setMainGridRowCnt(15);
        Solution.setMainGridColCnt(15);
        Solution.setSubGridRowCnt(2);
        Solution.setSubGridColCnt(2);
        
        assertEquals(false, Solution.subGridExistsInMainGrid());
    }
    @Test
    public void testSubGridExistsInMainGrid_B1() {
        System.out.println("-T-main solution-sample test case B1.");
        Solution.clearGrids();
        Solution.addMainGridRow("34889246430321978567");
        Solution.addMainGridRow("58957542800420926643");
        Solution.addMainGridRow("35502505614464308821");
        Solution.addMainGridRow("14858224623252492823");
        Solution.addMainGridRow("72509980920257761017");
        Solution.addMainGridRow("22842014894387119401");
        Solution.addMainGridRow("01112950562348692493");
        Solution.addMainGridRow("16417403478999610594");
        Solution.addMainGridRow("79426411112116726706");
        Solution.addMainGridRow("65175742483779283052");
        Solution.addMainGridRow("89078730337964397201");
        Solution.addMainGridRow("13765228547239925167");
        Solution.addMainGridRow("26113704444636815161");
        Solution.addMainGridRow("25993216162800952044");
        Solution.addMainGridRow("88796416233981756034");
        Solution.addMainGridRow("14416627212117283516");
        Solution.addMainGridRow("15248825304941012863");
        Solution.addMainGridRow("88460496662793369385");
        Solution.addMainGridRow("59727291023618867708");
        Solution.addMainGridRow("19755940017808628326");
        Solution.addSubGridRow("1641");
        Solution.addSubGridRow("7942");
        Solution.addSubGridRow("6517");
        Solution.addSubGridRow("8907");
        Solution.addSubGridRow("1376");
        Solution.addSubGridRow("2691");
        Solution.addSubGridRow("2599");

        Solution.setMainGridRowCnt(20);
        Solution.setMainGridColCnt(20);
        Solution.setSubGridRowCnt(7);
        Solution.setSubGridColCnt(4);
        
        assertEquals(false, Solution.subGridExistsInMainGrid());
    }
    @Test
    public void testSubGridExistsInMainGrid_B2() {
        System.out.println("-T-main solution-sample test case B2.");
        Solution.clearGrids();
        Solution.addMainGridRow("7652157548860692421022503");
        Solution.addMainGridRow("9283597467877865303553675");
        Solution.addMainGridRow("4160389485250089289309493");
        Solution.addMainGridRow("2583470721457150497569300");
        Solution.addMainGridRow("3220130778636571709490905");
        Solution.addMainGridRow("3588873017660047694725749");
        Solution.addMainGridRow("9288991387848870159567061");
        Solution.addMainGridRow("4840101673383478700737237");
        Solution.addMainGridRow("8430916536880190158229898");
        Solution.addMainGridRow("8986106490042260460547150");
        Solution.addMainGridRow("2591460395957631878779378");
        Solution.addMainGridRow("1816190871689680423501920");
        Solution.addMainGridRow("0704047294563387014281341");
        Solution.addMainGridRow("8544774664056811258209321");
        Solution.addMainGridRow("9609294756392563447060526");
        Solution.addMainGridRow("0170173859593369054590795");
        Solution.addMainGridRow("6088985673796975810221577");
        Solution.addMainGridRow("7738800757919472437622349");
        Solution.addMainGridRow("5474120045253009653348388");
        Solution.addMainGridRow("3930491401877849249410013");
        Solution.addMainGridRow("1486477041403746396925337");
        Solution.addMainGridRow("2955579022827592919878713");
        Solution.addMainGridRow("2625547961868100985291514");
        Solution.addMainGridRow("3673299809851325174555652");
        Solution.addMainGridRow("4533398973801647859680907");
        Solution.addSubGridRow("5250");
        Solution.addSubGridRow("1457");
        Solution.addSubGridRow("8636");
        Solution.addSubGridRow("7660");
        Solution.addSubGridRow("7848");

        Solution.setMainGridRowCnt(25);
        Solution.setMainGridColCnt(25);
        Solution.setSubGridRowCnt(5);
        Solution.setSubGridColCnt(4);
        
        assertEquals(true, Solution.subGridExistsInMainGrid());
    }
    @Test(timeout=800)
    public void testSubGridExistsInMainGrid_05() {
        // this guy is the performance test. it contains 1000 x 1000 grid.
        // it comes straight from the hackerrank web site.
        System.out.println("-T-main solution-hackerrank test case 05.");
        List<Boolean> res = new ArrayList<>();
        boolean[] expResult = {true, true, false, true, false};
        boolean[] result = new boolean[5];
        
        try {
            Scanner in = new Scanner(new File("src/test/resources/input/input05.txt"));
            int numTests = in.nextInt();
            for (int tt = 0; tt < numTests; tt++) {
                Solution.clearGrids();
                int R = in.nextInt();
                int C = in.nextInt();
                Solution.setMainGridRowCnt(R);
                Solution.setMainGridColCnt(C);
                for(int G_i=0; G_i < R; G_i++)
                    Solution.addMainGridRow(in.next());
                    
                int r = in.nextInt();
                int c = in.nextInt();
                Solution.setSubGridRowCnt(r);
                Solution.setSubGridColCnt(c);
                for(int P_i=0; P_i < r; P_i++)
                    Solution.addSubGridRow(in.next());
                result[tt] = Solution.subGridExistsInMainGrid();
            }
        } catch (FileNotFoundException ex) {
            assertEquals("File Found", "File NOT found");
        }
        Assert.assertArrayEquals(expResult, result);
    }

}
