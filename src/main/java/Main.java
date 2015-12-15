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
import parser.Parser;
import parser.TestParser;




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
    
    get("/test/*/sample/*",(request,respons) -> {
        String[] splat = request.splat();
        /*
        String text = "splat().length = " + splat.length + "<br>"
                + "splat()[0] = " + splat[0] + "<br>"
                + "splat()[1] = " + splat[1];
        */
        String text = "goehghoeghoehg";
        return text;
  });
  }
}
