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


import com.heroku.sdk.jdbc.DatabaseUrl;
import data.Table;
import data.TableFactory;
import function.AbstractFunction;
import function.AddFunction;
import function.DivFunction;
import function.MulFunction;
import function.SubFunction;
import net.arnx.jsonic.JSON;
import parser.Parser;
import parser.TestParser;



//import com.fasterxml.jackson.databind.ObjectMapper;





public class Main {

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
    
    
    
    
    
    post("/test/:name","application/json",(request,respons) -> {
        System.out.println("===start===");
        String json = "{\n" +
"    \"graph1\" : {\n" +
"        \"title\" : \"Title sample\",\n" +
"        \"type\" : \"line\",\n" +
"        \"xAxis\" : {\n" +
"            \"title\" : {\n" +
"                \"text\" : \"xTitle\",\n" +
"                \"margin\" : 20\n" +
"            },\n" +
"            \"categories\" : [400,401,402,403,404,405,406,407,408]\n" +
"        },\n" +
"        \"yAxis\" : {\n" +
"            \"title\" : {\n" +
"                \"text\" : \"yTitle\",\n" +
"                \"margin\" : 20\n" +
"            }\n" +
"        },\n" +
"        \"series\" : {\n" +
"            \"name\" : \"ActMinTotal\",\n" +
"            \"data\" : [500,600,550,630,800,920,1100,300]\n" +
"        }\n" +
"    },\n" +
"    \"grap\" : {\n" +
"        \"title\" : \"Title sample\",\n" +
"        \"type\" : \"column\",\n" +
"        \"xAxis\" : {\n" +
"            \"title\" : {\n" +
"                \"text\" : \"xTitle\",\n" +
"                \"margin\" : 20\n" +
"            },\n" +
"            \"categories\" : [400,401,402,403,404,405,406,407,408]\n" +
"        },\n" +
"        \"yAxis\" : {\n" +
"            \"title\" : {\n" +
"                \"text\" : \"yTitle\",\n" +
"                \"margin\" : 20\n" +
"            }\n" +
"        },\n" +
"        \"series\" : {\n" +
"            \"name\" : \"ActMinTotal\",\n" +
"            \"data\" : [500,600,550,630,800,920,1100,3000]\n" +
"        }\n" +
"    }\n" +
"}";
                
        Object obj = JSON.decode(json);
        System.out.println(obj);
        request.session(true);
        request.session().attribute("json",obj.toString());
        
        System.out.println(request.session().attributes());
        respons.redirect("https://psp-analysis.herokuapp.com/charts/create",307);
        return obj;
    });
  }
}
