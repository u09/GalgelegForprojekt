/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ahmad
 */
public class functions {
        
    
        public ArrayList<String> getAllUsers() throws SQLException{
        connector c = new connector("galgeleg.dk", "root", "ts2017", "galgeleg");
        ArrayList<String> users = new ArrayList<String>();
        ResultSet result =  c.select("SELECT sid FROM USERS");
        System.out.print(result.getString(1));
        while (result.next()) {
            users.add(result.getString(1));
        }
        return users;
    }
}
