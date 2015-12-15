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
public class DivFunction extends AbstractFunction{

    @Override
    protected String getFunctionName(String data1, String data2) {
        return "DIV_"+data1+"_"+data2;
    }

    @Override
    public Cell function(Cell c1, Cell c2) {
        Cell c = new Cell(0);
        try {
            return new Cell(c1.getNumValue()/c2.getNumValue());
        } catch (ArithmeticException e) {
            return c;
        }
    }
}
