/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import parser.Parser;

/**
 *
 * @author pokotyamu
 */
public class TableFactory {
    
    public static Table createTable(Parser p){
        Table tb = new Table();
        tb.setProjectID(p.createProjectIDDS());
        tb.addCols(p.createColList());
        return tb;
    }
}
