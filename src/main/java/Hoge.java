package main.java;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pokotyamu
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Hoge {
    
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Hoge [id=" + id + ", name=" + name + "]";
    }
}
