package org.matthauer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Create the test case
     *
     */
    public AppTest()
    {

    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    private class ChemTestData {
        final public String testName, testSymbol;
        final public boolean result;
        public ChemTestData(String n, String s, boolean r){
            this.testName = n;
            this.testSymbol = s;
            this.result = r;
        }
    }
    @Test
    public void testElementsOne(){
        SplurthianChemistry sc = new SplurthianChemistry();
        ChemTestData[] td = new ChemTestData[]{
                new ChemTestData("Spenglerium", "Ee", true),
                new ChemTestData("Zeddemorium", "Zr", true),
                new ChemTestData("Venkmine", "Kn", true),
                new ChemTestData("Stantzon", "Zt", false),
                new ChemTestData("Melintzum", "Nn", false),
                new ChemTestData("Tullium", "Ty", false)
        };
        for (ChemTestData d : td){
           assertEquals("Error in testing element "+d.testName, sc.checkSymbol(d.testName, d.testSymbol), d.result);
        }
    }
}
