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
    private DataSet projectID;
    public Table() {
        cols = new ArrayList<>();
        projectID = new DataSet("ProjectID");
    }
    
    //DataSetの順番については正しく並べ替えられているものとする
    public void addCol(DataSet ds){
        cols.add(ds);
    }
    
    public void setProjectID(DataSet ds){
        this.projectID = ds;
    }
    
    public DataSet getProjectID(){
        return projectID;
    }
    
    public DataSet getDataSet(String name) {
        DataSet ds = new DataSet();
        for (DataSet col : cols) {
            if(col.isName(name)){
                return col;
            }
        }
        return ds;
    }

    //テーブル列内のソート関数
    //keyが1の時：降順
    //keyが−1の時：昇順
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
            for(int i = 0; i < ds.size()-1;i++){
                for(int j = i+1; j < ds.size();j++){
                    if(ds.getIntCell(i) < ds.getIntCell(j)){
                        switchCell(i, j);
                    }
                }
            }
        }
    }
    
    //その他の全ての列に対しても並べ替えを行う
    private void switchCell(int a,int b){
        for (DataSet col : cols) {
            col.switchCell(a, b);
        }
        this.projectID.switchCell(a,b);
    }
}
