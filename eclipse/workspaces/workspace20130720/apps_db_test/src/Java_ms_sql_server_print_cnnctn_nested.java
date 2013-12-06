/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package java_ms_sql_server;
//import java.sql.*;

/**
 *
 * @author noriyuki
 * This is a experimental program for excersise to use ms SQL Server on java
 */
public class Java_ms_sql_server_print_cnnctn_nested {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
    	java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
    	pj.setPrintable(new Java_Print_FromDB_cnnctn_nested());
    	try{
    	pj.print();
    	}catch(java.awt.print.PrinterException e){
    		System.out.println(e.toString());
    	}
        }
    }