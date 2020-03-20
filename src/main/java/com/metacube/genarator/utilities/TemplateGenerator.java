package com.metacube.genarator.utilities;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class TemplateGenerator {
//  public  static  String getTemplate(Long id) throws IOException {
//    MustacheFactory mf = new DefaultMustacheFactory();
//    Mustache m = mf.compile("university.mustache");
//    Map<String, Object> map = new HashMap<>();
//    map.put("startWith","IISU");
//    map.put("year", Year.now());
//    map.put("type","prospect");
//    map.put("counter",id);
//    StringWriter writer = new StringWriter();
//    m.execute(writer, map).flush();
//    String prospectId = writer.toString();
//    return prospectId;
//  }
  
  public static String getTemplate(Long id) throws IOException{
    String template = "{{startWith}}/{{year}}/{{type}}/{{counter}}";
    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache m = mf.compile(new StringReader(template),"template");
    Map<String, Object> map = new HashMap<>();
    map.put("startWith","IISU");
    map.put("year", Year.now());
    map.put("type","prospect");
    map.put("counter",id);
    StringWriter writer = new StringWriter();
    m.execute(writer, map).flush();
    String prospectId = writer.toString();
    return prospectId;
  }
  
  public static String generateTemplate(String template, Map<String, Object> map)throws IOException{
    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache m = mf.compile(new StringReader(template),"template");
    StringWriter writer = new StringWriter();
    m.execute(writer, map).flush();
    String templateString = writer.toString();
    return templateString;
  }
}
