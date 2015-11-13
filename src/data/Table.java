/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pokotyamu
 */
public class Table {
    
    private List<Cell> cells;
    
    private List<PSPLabel> keys;
    private List<PSPLabel> cols;

    public Table() {
        cells = new ArrayList<>();
        keys = new ArrayList<>();
        cols = new ArrayList<>();
    }
    
    public void addData(List<PSPLabel> keys,List<PSPLabel> cols,Cell[] cells){
        this.addLabels(keys, cols);
        addAllCell(cells);
    }
    
    private void addLabels(List<PSPLabel> keys, List<PSPLabel> cols) {
        addLabel(this.keys,keys);
        addLabel(this.cols, cols);
    }
    
    private void addLabel(List<PSPLabel> addedLabels,List<PSPLabel> labels) {
        for (PSPLabel label : labels) {
            if(!this.isExistPSPLabel(addedLabels,label)){
                addedLabels.add(label);
            }
        }
    }
    
    private boolean isExistPSPLabel(List<PSPLabel> labels, PSPLabel label) {
        boolean flag = true;
        for (PSPLabel lb : labels) {
            flag = flag && label.equals(lb);
        }
        return flag;
    }

    private void addAllCell(Cell[] cells) {
        for (Cell cell : cells) {
            this.addCell(cell);
        }
    }

    private void addCell(Cell cell) {
        this.cells.add(cell);
    }
}
