/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author pokotyamu
 */
public class Cell {
    
    private String key;
    private String row;
    private Object value;

    public Cell createCell(String key,String row,Object value){
        return new Cell(key, row, value);
    }
        
    public Cell(String key,String row){
        this.key = key;
        this.row = row;
    }

    public Cell(String key, String row, Object value) {
        this.key = key;
        this.row = row;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getRow() {
        return row;
    }

    public Object getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
