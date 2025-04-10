package com.duc1808.Web.Controler;


import com.duc1808.Web.Controler.Model.Building_Model;
import com.duc1808.Web.Respon.Entity.Building_Entity;
import com.duc1808.Web.Respon.implement.Building_imp;
import com.duc1808.Web.Service.Imple.Building_Service_implement;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class Nhan_Controler {
     @GetMapping("/api/building")
    public ArrayList<Building_Model> getBuilding(@RequestParam Map<String,Object> listmap,
                                                 @RequestParam(value = "typecode",required = false) ArrayList<String> listtypecode){
         Building_Service_implement building_service_implement = new Building_Service_implement();
         ArrayList<Building_Model> list = building_service_implement.getBuilding(listmap,listtypecode);




         return list;
    }

}
