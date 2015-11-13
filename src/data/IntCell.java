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
public class IntCell extends Cell{
    
    private int intValue;

    public IntCell(String key,String row){
        super(key, row);
    }
    
    public IntCell(String key, String row,int value) {
        super(key, row);
        this.intValue = value;
    }
}
