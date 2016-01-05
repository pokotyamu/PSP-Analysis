package main.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import main.java.Hoge;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heroku.sdk.jdbc.DatabaseUrl;
import data.Table;
import data.TableFactory;
import function.AbstractFunction;
import function.AddFunction;
import function.DivFunction;
import function.MulFunction;
import function.SubFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.data.GraphData;
import net.arnx.jsonic.JSON;
import parser.Parser;
import parser.TestParser;



//import com.fasterxml.jackson.databind.ObjectMapper;





public class Main {
    static Object obj = "";
    static String output = "";
  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

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
    
    
    

    
    post("/test/:name","application/json",(request, respons) -> {

        String json = "{" +
"    \"graph1\" : {" +
"        \"title\" : \"Title sample\"," +
"        \"type\" : \"line\"," +
"        \"xAxis\" : {" +
"            \"title\" : {" +
"                \"text\" : \"xTitle\"," +
"                \"margin\" : 20" +
"            }," +
"            \"categories\" : [400,401,402,403,404,405,406,407,408]" +
"        }," +
"        \"yAxis\" : {" +
"            \"title\" : {" +
"                \"text\" : \"yTitle\"," +
"                \"margin\" : 20" +
"            }" +
"        }," +
"        \"series\" : {" +
"            \"name\" : \"ActMinTotal\"," +
"            \"data\" : [500,600,550,630,800,920,1100,300]" +
"        }" +
"    }," +
"    \"grap\" : {" +
"        \"title\" : \"Title sample\"," +
"        \"type\" : \"column\"," +
"        \"xAxis\" : {" +
"            \"title\" : {" +
"                \"text\" : \"xTitle\"," +
"                \"margin\" : 20" +
"            }," +
"            \"categories\" : [400,401,402,403,404,405,406,407,408]" +
"        }," +
"        \"yAxis\" : {" +
"            \"title\" : {" +
"                \"text\" : \"yTitle\"," +
"                \"margin\" : 20" +
"            }" +
"        }," +
"        \"series\" : {" +
"            \"name\" : \"ActMinTotal\"," +
"            \"data\" : [500,600,550,630,800,920,1100,3000]" +
"        }" +
"    }" +
"}";
                
       obj = JSON.decode(json);
       ObjectMapper mapper = new ObjectMapper();
       GraphData gd = GraphData.initData();
        try {
            output = mapper.writeValueAsString(gd);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
//        request.session(true);
//        request.session().attribute("json",obj.toString());
//        respons.cookie("json",obj.toString());
        respons.redirect("https://psp-analysis.herokuapp.com/charts/create/",307);
        return obj;
    });
    
    get("/json","application/json",(request,response) -> output);
  }
}
