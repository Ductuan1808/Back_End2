package com.duc1808.Web.Service.Imple;

import com.duc1808.Web.Controler.Model.Building_Model;
import com.duc1808.Web.Respon.Entity.Building_Entity;
import com.duc1808.Web.Respon.implement.Building_imp;
import com.duc1808.Web.Service.Building_Service_Interface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Building_Service_implement implements Building_Service_Interface {


    @Override
    public ArrayList<Building_Model> getBuilding(String name,Integer id) {
        ArrayList<Building_Model> listbuildingmodel = new ArrayList<>();
        Building_imp building_imp = new Building_imp();
        ArrayList<Building_Entity> list = building_imp.getBuilding(name,id);
        for(Building_Entity x : list){
            Building_Model building_model= new Building_Model();
            building_model.setName(x.getName());
            building_model.setNumberOfBasement(x.getNumberOfBasement());
            building_model.setAddress(x.getStreet()+","+x.getWard());
            listbuildingmodel.add(building_model);
        }

        return listbuildingmodel;
    }
}
