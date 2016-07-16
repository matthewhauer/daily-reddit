package org.matthauer;

import com.sun.istack.internal.NotNull;

import java.io.*;

/**
 * Created by sta7ic on 6/11/2016.
 */
public class MapData {
    private String[] rawMapData;
    private final int mapSize;
    private MapCell[][] mapData;

    public MapData(int size) {
        this.mapSize = size;
    }

    public static MapData create(@NotNull String filename) throws FileNotFoundException, IOException {
        File inFile = new File(filename);

        MapData res = null;
        try {
            res = create(new FileInputStream(inFile));
        } catch (FileNotFoundException e) {
            throw(e);
        }
        catch(IOException ioe){
            throw(ioe);
        }
        return res;
    }

    public static MapData create(@NotNull InputStream ios) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(ios));

        // first line is the NxN map size
        String first = br.readLine();
        // parse it
        int size = Integer.parseInt(first, 10);
        // assert that it is positive
        if(size < 1)
            throw new IOException("invalid map size");

        MapData mapData = new MapData(size);
        for(int i = 0; i < size && br.ready(); ++i){
            mapData.rawMapData[i] = br.readLine();
        }
        for(String dataLine : mapData.rawMapData) {

        }
        return null;
    }

    public static MapCell[] processRow(String rowData, int size) throws IOException {
        char data[] = rowData.trim().toCharArray();
        if(size > data.length){
            throw new IOException("row length shorter than specified size");
        }
        MapCell[] cells = new MapCell[size];
        for (int i = 0; i < size; ++i) {
            cells[i] = new MapCell(data[i]);
        }
        return cells;
    }
}
