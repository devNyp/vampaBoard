package com.vam.controller;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class TestDB {

    static { 
        try { 
            Class.forName("oracle.jdbc.OracleDriver"); 
        } catch(Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    
    @Test 
    public void testConnection() { 
        try(Connection con = DriverManager.getConnection( 
                "jdbc:oracle:thin:@db202202040945_high?TNS_ADMIN=C://Users//Public//Wallet_DB202202040945", 
                "NAS", 
                "NtourAguideS1")){ 
            System.out.println(con); 
        } catch (Exception e) { 
            fail(e.getMessage()); 
        } 
    
    }    
}
