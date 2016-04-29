package com.liucs.java.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlTest {

	public static void main(String[] args) {
		//==============SAX=======================
//		XmlTest.SAX("myxml.xml");
		//==============DOM=======================
//		XmlTest.DOM("myxml.xml");
		//==============DOM4J=======================
		XmlTest.DOM4J("myxml.xml");
        
        
	}
	public static void SAX(String xmlName){
		ArrayList<Map<String, String>> list=(ArrayList<Map<String, String>>) SAXService.ReadXML("myxml.xml");
        for(int i=0;i<list.size();i++){
            HashMap<String, String> temp=(HashMap<String, String>) list.get(i);
                Iterator<String> iterator=temp.keySet().iterator();
                while(iterator.hasNext()){
                    String key=iterator.next().toString();
                    String value=temp.get(key);
                    System.out.print(key+" "+value+"--");
                }
        }
        System.out.println(list.toString());
	}
	public static void DOM(String xmlName){
		 try {  
	            InputStream in = XmlTest.class.getResourceAsStream(xmlName); 
	            DocumentBuilderFactory factory = DocumentBuilderFactory  
	                    .newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();  
	            Document doc = builder.parse(in); //注意这里的Document是org.w3c.dom包下的
	            NodeList nl = doc.getElementsByTagName("stu");  
	            System.out.println(nl.getLength());
	            for (int i = 0; i < nl.getLength(); i++) {  
	            	Element ele = (Element) nl.item(i);
	            	String content = ele.getElementsByTagName("name").item(0)
	                        .getFirstChild().getNodeValue();
	            	System.out.println(content);
	                System.out.println("-------------------------------------------------");            
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}
	public static void DOM4J(String xmlName){
		long lasting = System.currentTimeMillis();  
        try {  
        	InputStream in = XmlTest.class.getResourceAsStream(xmlName); 
            SAXReader reader = new SAXReader();
            org.dom4j.Document doc = reader.read(in);  //注意这里的Document是org.dom4j包下的
            org.dom4j.Element root = doc.getRootElement();  
            org.dom4j.Element foo;  
            for (Iterator i = root.elementIterator("stu"); i.hasNext();) {  
                foo = (org.dom4j.Element) i.next();  
                System.out.println("|| Name:  |" + foo.elementText("name"));  
                System.out.println("||sex:  |" + foo.elementText("sex"));  
                System.out.println("-------------------------------------------------");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("DOM4J 耗时："  
                + (System.currentTimeMillis() - lasting) + " MS");  
	}

}
