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
    
    private List<DataSet> cols;
    
    public Table() {
        cols = new ArrayList<>();
    }
    
    
    public void addCol(DataSet ds){
        cols.add(ds);
    }
    
    
    public DataSet getDataSet(String colName){
        return this.getDataSet(colName,cols);
    }

    private DataSet getDataSet(String name, List<DataSet> targets) {
        DataSet ds = new DataSet();
        for (DataSet tg : targets) {
            if(tg.isName(name)){
                ds = tg;
            }
        }
        return ds;
    }
    
    public void sort(int key,String dataName){
        DataSet ds = this.getDataSet(dataName);
        if(key > 0){//昇順
            for(int i = 0; i < ds.size()-1;i++){
                for(int j = i+1; j < ds.size();j++){
                    if(ds.getIntCell(i) > ds.getIntCell(j)){
                        switchCell(i, j);
                    }
                }
            }
        }else{//降順
            
        }
    
    }
    
    private void switchCell(int a,int b){
        for (DataSet col : cols) {
            col.switchCell(a, b);
        }
    }
}
