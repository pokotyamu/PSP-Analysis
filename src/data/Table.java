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
    private DataSet projectIDds;
    
    public Table() {
        cols = new ArrayList<>();
        projectIDds = new DataSet("ProjectID");
    }
    
    //DataSetの順番については正しく並べ替えられているものとする
    public void addCol(DataSet ds){
        cols.add(ds);
    }
    
    //まとめて追加
    public void addCols(List<DataSet> cols) {
        for (DataSet col : cols) {
            this.cols.add(col);
        }
    }
    
    public void setProjectID(DataSet ds){
        this.projectIDds = ds;
    }
    
    public DataSet getProjectID(){
        return projectIDds;
    }
    
    public int getProjectIDIndex(Cell c){
        return projectIDds.getCellIndex(c);
    }
    
    public int getProjectIDIndex(Object ob){
        return projectIDds.getCellIndex(new Cell(ob));
    }
    
    public int getProjectIDIndex(int id){
        return projectIDds.getCellIndex(new Cell(id));
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
    
    public Cell getCell(String colName, int i){
        return this.getDataSet(colName).getCell(i);
    }

    //テーブル列内のソート関数
    //keyが1の時：降順
    //keyが−1の時：昇順
    public void sort(int key,String dataName){
        DataSet ds = this.getDataSet(dataName);
        if(key > 0){//昇順
            for(int i = 0; i < ds.size()-1;i++){
                for(int j = i+1; j < ds.size();j++){
                    if(ds.getNumCell(i) > ds.getNumCell(j)){
                        switchCell(i, j);
                    }
                }
            }
        }else{//降順
            for(int i = 0; i < ds.size()-1;i++){
                for(int j = i+1; j < ds.size();j++){
                    if(ds.getNumCell(i) < ds.getNumCell(j)){
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
        this.projectIDds.switchCell(a,b);
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("=Key=\n");
        strb.append(projectIDds);
        strb.append("\n=Cols=\n");
        for (DataSet col : cols) {
            strb.append(col);
            strb.append("\n");
        }
        return strb.toString();
    }
}