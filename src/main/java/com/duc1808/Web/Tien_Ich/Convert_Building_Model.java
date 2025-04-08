package com.duc1808.Web.Tien_Ich;

import com.duc1808.Web.Controler.Model.Building_Model;
import com.duc1808.Web.Respon.Entity.Building_Entity;
import com.duc1808.Web.Respon.Entity.District_Entity;
import com.duc1808.Web.Respon.Entity.Rentarea_Entity;
import com.duc1808.Web.Respon.implement.District_imp;
import com.duc1808.Web.Respon.implement.Rentarea_imp;

import java.util.ArrayList;

public class Convert_Building_Model {
    public static Building_Model chuyendoi(Building_Entity b){
        Building_Model building_model = new Building_Model();
        District_imp district_imp = new District_imp();
        District_Entity district_entity = district_imp.getName(b.getDistrictId());
        building_model.setName(b.getName());
        building_model.setAddress(b.getStreet()+","+b.getWard()+","+district_entity.getName());
        Rentarea_imp rentarea_imp = new Rentarea_imp();
        ArrayList<Rentarea_Entity> r = rentarea_imp.getrentareatheoid(b.getId());
        String rentarea=" ";
        for(Rentarea_Entity y : r){
            rentarea +=y.getValue();
            rentarea+=",";
        }
        building_model.setRentArea(rentarea);
        return building_model;
    }
}
