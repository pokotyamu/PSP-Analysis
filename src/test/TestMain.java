/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Table;
import data.TableFactory;
import parser.Parser;
import parser.TestParser;

/**
 *
 * @author pokotyamu
 */
public class TestMain {

    public static void main(String[] args) {
        Parser p = new TestParser();
        Table tb = TableFactory.createTable(p);
        System.out.println(tb);
    }

}
