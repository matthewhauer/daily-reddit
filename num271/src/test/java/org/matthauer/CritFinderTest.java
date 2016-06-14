package org.matthauer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple CritFinder.
 */
public class CritFinderTest
    extends TestCase
{
    CritFinder cf;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CritFinderTest(String testName )
    {
        super( testName );
        cf = new CritFinder();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CritFinderTest.class );
    }

    private double runCheck(int a, int b){
        double rv = 0.0;
        try {
            rv = cf.findOneShotChance(a, b);
        } catch(Exception e){

        }
        return rv;
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );

        assertEquals("1 on 4 failed", 1.0, runCheck(4, 1), 0.0001);
        assertEquals("4 on 4 failed", 0.25, runCheck(4, 4), 0.0001);
        assertEquals("5 on 4 failed", 0.25, runCheck(4, 5), 0.0001);
        assertEquals("6 on 4 failed", 0.1875, runCheck(4, 6), 0.0001);
        assertEquals("10 on 1 failed", 1.0, runCheck(1, 10), 0.0001);
        assertEquals("200 on 100 failed", 0.0001, runCheck(100, 200), 0.0001);
        assertEquals("20 on 8 failed", 0.009765625, runCheck(8, 20), 0.0001);

    }
}
