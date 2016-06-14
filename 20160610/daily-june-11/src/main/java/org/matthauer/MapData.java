package org.matthauer;

import com.sun.istack.internal.NotNull;

import java.io.*;

/**
 * Created by sta7ic on 6/11/2016.
 */
public class MapData {
    private String[][] mapArray;
    private final int mapSize;

    public static MapData create(@NotNull String filename) throws FileNotFoundException {
        File inFile = new File(filename);

        MapData res = null;
        try {
            res = create(new FileInputStream(inFile));
        } catch (FileNotFoundException e) {
            throw(e);
        }
        return res;
    }

    public static MapData create(@NotNull InputStream ios) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(ios));
        String first = br.readLine();

        return null;
    }
    private MapData(int mapSize) {
        this.mapSize = mapSize;
    }
}
