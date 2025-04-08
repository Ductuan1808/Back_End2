package com.duc1808.Web.Service.Imple;

import com.duc1808.Web.Controler.Model.Building_Model;
import com.duc1808.Web.Respon.Entity.Building_Entity;
import com.duc1808.Web.Respon.Entity.District_Entity;
import com.duc1808.Web.Respon.Entity.Rentarea_Entity;
import com.duc1808.Web.Respon.implement.Building_imp;
import com.duc1808.Web.Respon.implement.District_imp;
import com.duc1808.Web.Respon.implement.Rentarea_imp;
import com.duc1808.Web.Service.Building_Service_Interface;
import com.duc1808.Web.Tien_Ich.Convert_Building_Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class Building_Service_implement implements Building_Service_Interface {


    @Override
    public ArrayList<Building_Model> getBuilding(Map<String,Object> listmap, ArrayList<String> listtypecode) {
        ArrayList<Building_Model> listbuildingmodel = new ArrayList<>();
        Building_imp building_imp = new Building_imp();
        ArrayList<Building_Entity> list = building_imp.getBuilding(listmap,listtypecode);

        for(Building_Entity x : list){

            Building_Model building_model =Convert_Building_Model.chuyendoi(x);
            listbuildingmodel.add(building_model);

        }

        return listbuildingmodel;
    }
}
