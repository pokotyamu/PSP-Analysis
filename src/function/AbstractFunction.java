/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import data.*;

/**
 *
 * @author pokotyamu
 */
public abstract class AbstractFunction {

    public Table function(Table tb,String dataname1,String dataname2){
        DataSet ds = new DataSet(this.getFunctionName(dataname1, dataname2));
        DataSet ds1 = tb.getDataSet(dataname1);
        DataSet ds2 = tb.getDataSet(dataname2);
        for (int index = 0; index < tb.getProjectID().size(); index++) {
            ds.addCell(this.function(ds1.getCell(index),ds2.getCell(index)));
        }
        tb.addCol(ds);
        return tb;
    }
    
    protected abstract String getFunctionName(String data1,String data2);
    public abstract Cell function(Cell c1, Cell c2);
    
}
