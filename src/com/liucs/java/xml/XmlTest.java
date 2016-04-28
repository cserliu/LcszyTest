package com.liucs.java.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XmlTest {

	public static void main(String[] args) {
		//==============SAX=======================
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

}
