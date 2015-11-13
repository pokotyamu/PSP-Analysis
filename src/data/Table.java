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
    

    private List<PSPLabel> rows;
    private List<PSPLabel> cols;

    public Table() {
        rows = new ArrayList<>();
        cols = new ArrayList<>();
    }

    public Table(List<PSPLabel> rows, List<PSPLabel> cols) {
        this.rows = rows;
        this.cols = cols;
    }
    
    public void addData(){
        
    }
    
    public void changeCell(String row,String col,Cell c){
    
    }
    
}
