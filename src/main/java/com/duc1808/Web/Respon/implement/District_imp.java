package com.duc1808.Web.Respon.implement;

import com.duc1808.Web.Respon.Entity.District_Entity;
import com.duc1808.Web.Respon.Interface.District_Interface;
import com.duc1808.Web.Tien_Ich.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class District_imp implements District_Interface {
    @Override
    public District_Entity getName(Long id) {
        Connection c =Connector.connect();
        District_Entity district_entity = new District_Entity();

        String sql =" Select name from district where district.id = "+id+" ";
        try{
            Statement st = c.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()){
                district_entity.setName(rs.getString("name"));
            }
        }catch (Exception e){
            System.out.println("Đéo được ");
        }
        return district_entity;
    }
}
