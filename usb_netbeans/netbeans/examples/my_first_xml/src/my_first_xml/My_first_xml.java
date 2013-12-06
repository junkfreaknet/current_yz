/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my_first_xml;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author U03AH13D-U
 */
public class My_first_xml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            
            String file_xml="connect_to_sion.xml";
            //String file_xml="hello.xml";            
            
            //
            // first. by using DOM
            //
            System.out.println("start. by using DOM");
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbfactory.newDocumentBuilder();
            Document doc = builder.parse(new File(file_xml));
            Element root = doc.getDocumentElement();       
            //1
            System.out.println(root.getFirstChild().getNodeName());
            System.out.println(root.getFirstChild().getNodeValue());
            //2
            //System.out.println(root.getLastChild().getNodeName());
            //System.out.println(root.getLastChild().getNodeValue());
            
            System.out.println("end. by using DOM");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        //
        //by using DOM
        //
        
    }
}
