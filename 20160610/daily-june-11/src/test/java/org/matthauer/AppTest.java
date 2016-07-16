package org.matthauer;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

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
    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void testFive(){
        int result = 0;
        assertEquals("five grid result incorrect", result, 9);
    }

    @Test
    public void testEight(){
        int result = 0;
        assertEquals("eight grid result incorrect", result, 16);
    }
}
