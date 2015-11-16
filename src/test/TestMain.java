/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Cell;
import data.DataSet;
import data.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class TestMain {
    public static void main(String[] args) {
        Table tb = new Table();
        DataSet ds = new DataSet("test");
        DataSet ds2 = new DataSet("piyo");
        DataSet rowDS = new DataSet("ProjectID");

        tb.addCol(ds);
        tb.addCol(rowDS);
        
        Cell c1 = new Cell(120);
        Cell c2 = new Cell(10);
        Cell c3 = new Cell(400);
        Cell c4 = new Cell(401);
        
        ds.addCell(c1);
        ds.addCell(c2);
        ds.addCell(new Cell(15));
        rowDS.addCell(c3);
        rowDS.addCell(c4);
        rowDS.addCell(new Cell(402));
        
        //tb.sort(1,"test");
        
        System.out.println(ds);
        System.out.println(rowDS);
    }
}
