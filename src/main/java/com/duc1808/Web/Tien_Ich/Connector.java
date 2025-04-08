package com.duc1808.Web.Tien_Ich;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class Connector {
        public static Connection connect(){
            String url="jdbc:mysql://localhost:3306/estatebasic?useUnicode=true&characterEncoding=UTF-8";
            String user="root";
            String pass="";
            Connection d=null;
            try {
                d=DriverManager.getConnection(url,user,pass);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return d;
        }

}
