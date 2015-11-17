/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import data.DataSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class CsvParser implements Parser{
    
    @Override
    public DataSet createProjectIDDS() {
        return new DataSet("ProjectIDcsv");
    }

    @Override
    public List<DataSet> createColList() {
        List<DataSet> cols =  new ArrayList<>();
        return cols;
    }
}
