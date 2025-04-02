package com.duc1808.Web.Respon.implement;

import com.duc1808.Web.Respon.Entity.Building_Entity;
import com.duc1808.Web.Respon.Interface.Building_Interface;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;



@Repository
public class Building_imp implements Building_Interface {
    String url="jdbc:mysql://localhost:3306/estatebasic";
    String user="root";
    String pass="";
    Connection c;

    @Override
    public ArrayList<Building_Entity> getBuilding(String name ,Integer id) {
        ArrayList<Building_Entity>list=new ArrayList<>();
            try {
                c = DriverManager.getConnection(url,user,pass);
                StringBuilder sql = new StringBuilder("Select * From building as b where 1=1");
                if(name !=null&& !name.equals("")){
                    sql.append(" and b.name like '%"+name+"%'");
                }if(id!=null){
                    sql.append(" and b.districtid = "+id+" ");
                }
                Statement st=c.createStatement();
                ResultSet rs =st.executeQuery(sql.toString());
                while(rs.next()){
                   Building_Entity building = new Building_Entity();
                   building.setName(rs.getString("name"));
                   building.setNumberOfBasement(rs.getString("numberofbasement"));
                   building.setWard(rs.getString("ward"));
                   building.setStreet(rs.getString("street"));
                   list.add(building);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return list;
    }
}
