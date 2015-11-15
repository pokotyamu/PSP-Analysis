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
public class DataSet {
    private String dataName;
    private List<String> dataTypes;
    
    private List<Cell> cells;

    //init
    public DataSet(){
        this.dataName = "";
        this.dataTypes = new ArrayList<>();
        this.cells = new ArrayList<>();
    }
    
    public DataSet(String dataName) {
        this.dataName = dataName;
        this.dataTypes = new ArrayList<>();
        this.cells = new ArrayList<>();
    }
    
    public DataSet(String dataName, List<String> dataTypes) {
        this.dataName = dataName;
        this.dataTypes = dataTypes;
        this.cells = new ArrayList<>();
    }

    public String getDataName() {
        return dataName;
    }

    public List<String> getDataTypes() {
        return dataTypes;
    }
    
    public void addCell(Cell c){
        cells.add(c);
    }
    
    public void setCell(int index,Cell c){
        cells.set(index, c);
    }
    
    public boolean isName(String dataName) {
        return this.dataName.equals(dataName);
    }

    public boolean isExistType(List<String> dataTypes) {
        return this.dataTypes.contains(dataTypes);
    }

    @Override
    public String toString() {
    
        StringBuilder strb = new StringBuilder();
        
        strb.append("dataName : ");
        strb.append(dataName);
        strb.append("\ndataTypes : ");
        strb.append(dataTypes.toString());
        strb.append("\nCell : ");
        strb.append(cells);
        return strb.toString();
    }

    public void addDataType(String dataType){
        this.dataTypes.add(dataType);
    }
    
    
}
