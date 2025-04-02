package com.duc1808.Web.Service;

import com.duc1808.Web.Controler.Model.Building_Model;

import java.util.ArrayList;

public interface Building_Service_Interface {
    public ArrayList<Building_Model> getBuilding(String name,Integer id);
}
