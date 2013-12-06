/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my_first_xml_2;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author U03AH13D-U
 */
public class My_first_xml_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                try{
            
            String file_xml="sample.xml";
            //String file_xml="connect_to_sion.xml";            
            //String file_xml="hello.xml";            
            
            //
            // first. by using DOM
            //
            System.out.println("start. by using DOM");
            //DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            //DocumentBuilder builder = dbfactory.newDocumentBuilder();
            //Document doc = builder.parse(new File(file_xml));
            //Element root = doc.getDocumentElement();       
            //1
            //System.out.println(root.getFirstChild().getNodeName());
            //System.out.println(root.getFirstChild().getNodeValue());
            //2
            //System.out.println(root.getLastChild().getNodeName());
            //System.out.println(root.getLastChild().getNodeValue());
            //OMParser dom_parser=new DOMParser();
            DocumentBuilderFactory document_builder_factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder document_builder=document_builder_factory.newDocumentBuilder();
            Document document=document_builder.parse(new File(file_xml));
            
            System.out.println(document.getNodeName());
            //System.out.println(document.getNodeValue());
            //System.out.println(document.getNodeType());
            
            print_nodes(document);            

            System.out.println("end. by using DOM");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static void print_nodes(Document document){
        if(document.hasChildNodes()){
            Node node=document.getFirstChild();
            System.out.println(node.getNodeName());
            print_nodes(node);
                
        }else{
            System.out.println("this document has no element");
        }        
    }
    static void print_nodes(Node nd){
        if(nd.hasChildNodes()){
            Node nd_child=nd.getFirstChild();
            System.out.println(nd_child.getNodeName());
            //System.out.println(nd_child.getNodeType());
            //System.out.println(nd_child.getNodeValue());
            print_nodes(nd_child);
        }
    }
}
