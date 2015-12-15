/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import data.DataSet;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public interface Parser {
    public DataSet createProjectIDDS();
    public List<DataSet> createColList();
}
