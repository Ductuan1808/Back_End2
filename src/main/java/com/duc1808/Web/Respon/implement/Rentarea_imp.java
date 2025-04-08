package com.duc1808.Web.Respon.implement;

import com.duc1808.Web.Respon.Entity.Rentarea_Entity;
import com.duc1808.Web.Respon.Interface.Rentarea_Interface;
import com.duc1808.Web.Tien_Ich.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Rentarea_imp implements Rentarea_Interface {
    @Override
    public ArrayList<Rentarea_Entity> getrentareatheoid(Long idbuilding) {
        Connection c = Connector.connect();
        ArrayList<Rentarea_Entity> list = new ArrayList<>();
        String sql =" Select value from rentarea where rentarea.buildingid = "+idbuilding+" ";
        try{
            Statement st= c.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                Rentarea_Entity rentarea_entity = new Rentarea_Entity();
                rentarea_entity.setValue(rs.getString("value"));
                list.add(rentarea_entity);
            }
        }catch(Exception e){
            System.out.println("Đéo được");

        }
        return list;
    }
}
