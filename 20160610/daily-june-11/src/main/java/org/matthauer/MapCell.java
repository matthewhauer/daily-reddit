package org.matthauer;

/**
 * Created by sta7ic on 7/16/2016.
 */
public class MapCell {
    public enum CellType {
        OPEN,
        ROCK
    }
    private int horizCt, vertCt;
    private CellType cellType;

    public MapCell(CellType cellType) {
        this.cellType = cellType;
    }

    public int getHorizCt() {
        return horizCt;
    }

    public void setHorizCt(int horizCt) {
        this.horizCt = horizCt;
    }

    public int getVertCt() {
        return vertCt;
    }

    public void setVertCt(int vertCt) {
        this.vertCt = vertCt;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }


}
