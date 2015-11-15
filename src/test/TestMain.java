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
        DataSet rowDS = new DataSet("400");
        DataSet rowDS2 = new DataSet("401");

        tb.addCol(ds);
        tb.addCol(ds2);
        tb.addKey(rowDS);
        
        ds.addDataType("PLAN");
        ds.addDataType("REVIEW");

        ds2.addDataType("PLAN");
        ds2.addDataType("REVIEW");
        
        rowDS.addDataType("ProjectID");
        rowDS.addDataType("Interim");

        Cell c1 = new Cell(100);
        Cell c2 = new Cell(120);
        ds.addCell(c1);
        ds2.addCell(c2);
        rowDS.addCell(c1);
        rowDS.addCell(c2);

        List<String> list = new ArrayList<>();
        list.add("PLAN");list.add("REVIEW");

        List<String> list1 = new ArrayList<>();
        list1.add("ProjectID");

        System.out.println(tb.getColDataSets(list));
        DataSet dss = tb.getKeyDataSet("400",list1);
        System.out.println(dss);
        c2.setValue(200000);
        System.out.println("--------");
        System.out.println(tb.getColDataSets(list));
        System.out.println(dss);
    }
}
