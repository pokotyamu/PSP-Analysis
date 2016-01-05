/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.data;

/**
 *
 * @author pokotyamu
 */
public class GraphData {

    private String title;
    
    public static GraphData initData() {
        GraphData gd = new GraphData();
        gd.title = "sample title";
        return gd;
    }
    
}
