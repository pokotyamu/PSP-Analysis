/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import data.Cell;
import data.DataSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class TestParser implements Parser{

    @Override
    public DataSet createProjectIDDS() {
        DataSet ds = new DataSet("ProjectID");
        for(int i = 400;i < 408; i++){
            ds.addCell(new Cell(i));
        }
        return ds;
    }

    @Override
    public List<DataSet> createColList() {
        List<DataSet> list = new ArrayList<>();
        DataSet ds = new DataSet("Programsize");
        DataSet ds1 = new DataSet("PlanA");
        DataSet ds2 = new DataSet("PlanT");
        
        for(int i = 400;i < 408; i++){
            ds.addCell(new Cell(i - 200));
            ds1.addCell(new Cell(i - 360));
            ds2.addCell(new Cell(i - 100));
        }
        list.add(ds);
        list.add(ds1);
        list.add(ds2);
        return list;
    }
    
}
