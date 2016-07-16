package org.matthauer;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by sta7ic on 7/16/2016.
 */
public class MapDataTest {
    public MapDataTest(){
        ;
    }

    @Test
    public void testCells(){
        MapCell rock = new MapCell('X'),
            space = new MapCell('-'),
            goof = new MapCell('z');
        assertEquals("Rock cell type failure", MapCell.CellType.ROCK, rock.getCellType());
        assertEquals("Open cell type failure", MapCell.CellType.OPEN, space.getCellType());
        assertEquals("Goofed cell type failure", MapCell.CellType.NONE, goof.getCellType());
    }

    @Test
    public void testParseRow(){
        String rowData = "-----X--\n";
        MapCell.CellType[] expected = {
                MapCell.CellType.OPEN,
                MapCell.CellType.OPEN,
                MapCell.CellType.OPEN,
                MapCell.CellType.OPEN,
                MapCell.CellType.OPEN,
                MapCell.CellType.ROCK,
                MapCell.CellType.OPEN,
                MapCell.CellType.OPEN
        };
        MapCell[] data = null;
        try{
            data = MapData.processRow(rowData, 8);
        } catch (IOException ioe){
            fail("Error processing row data");
        }
        assertEquals("row length incorrect", 8, data.length);
        for(int i = 0; i < 8; ++i){
            assertEquals("cell data incorrect: idx " + i, expected[i], data[i].getCellType());
        }
    }
}