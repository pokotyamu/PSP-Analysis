/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Table;
import data.TableFactory;
import function.AbstractFunction;
import function.AddFunction;
import function.DivFunction;
import function.MulFunction;
import function.SubFunction;
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
        AbstractFunction add = new AddFunction();
        tb = add.function(tb, "PlanA", "PlanT");
        AbstractFunction sub = new SubFunction();
        tb = sub.function(tb, "PlanT", "PlanA");
        AbstractFunction mul = new MulFunction();
        tb = mul.function(tb, "PlanA", "PlanT");
        AbstractFunction div = new DivFunction();
        tb = div.function(tb, "PlanA", "PlanT");
        System.out.println(tb);
    }

}
