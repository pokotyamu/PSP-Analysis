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
    
    private List<DataSet> keys;
    private List<DataSet> cols;
    
    public Table() {
        keys = new ArrayList<>();
        cols = new ArrayList<>();
    }
    
    public void addKey(DataSet ds){
        keys.add(ds);
    }
    
    public void addCol(DataSet ds){
        cols.add(ds);
    }
    
    public DataSet getKeyDataSet(int index){
        return keys.get(index);
    }
    
    public DataSet getKeyDataSet(String keyName){
        return this.getDataSet(keyName, keys);
    }
    
    public DataSet getKeyDataSet(String keyName, List<String> typeList) {
        return this.getDataSet(keyName, this.getKeyDataSets(typeList));
    }
    
    public List<DataSet> getKeyDataSets(List<String> types){
        return this.getDataSet(types, keys);
    }
    
    public DataSet getColDataSet(String colName){
        return this.getDataSet(colName,cols);
    }
    
    public DataSet getColDataSet(String colName, List<String> typeList){
        return this.getDataSet(colName, this.getColDataSets(typeList));
    }

    public List<DataSet> getColDataSets(List<String> types){
        return this.getDataSet(types, cols);
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

    private List<DataSet> getDataSet(List<String> types, List<DataSet> targets) {
        List<DataSet> ds = new ArrayList<>();
        for (DataSet tg  : targets) {
            if (tg.isExistType(types)) {
                ds.add(tg);
            }
        }
        return ds;
    }
}
