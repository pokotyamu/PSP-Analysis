/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import data.Cell;

/**
 *
 * @author pokotyamu
 */
public class AddFunction extends AbstractFunction{


    @Override
    protected String getFunctionName(String data1, String data2) {
        return "ADD_"+data1+"_"+data2;
    }

    @Override
    public Cell function(Cell c1, Cell c2) {
        return new Cell(c1.getNumValue() + c2.getNumValue());
    }
    
}
