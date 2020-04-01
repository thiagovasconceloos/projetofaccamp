/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author vasco
 */
public class ConnectFactory {
    
    public Connection getConnection(){
        try {
            
             return  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdcontrole","root","");
             
       
            
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
            
        }
        
        
    }
    
    
    
}
