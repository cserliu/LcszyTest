package com.liucs.java.xml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXService {
	public static List<Map<String,String>> ReadXML(String uri){
        try {
            //创建一个解析XML的工厂对象
            SAXParserFactory parserFactory=SAXParserFactory.newInstance();
            //创建一个解析XML的对象
            SAXParser parser=parserFactory.newSAXParser();
            //创建一个解析助手类
            Myhandler myhandler=new Myhandler("stu");
            InputStream in = SAXService.class.getResourceAsStream(uri);
            parser.parse(in, myhandler);
            return myhandler.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            
        }
        return null;
        
    }
}
