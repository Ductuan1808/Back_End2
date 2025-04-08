package com.duc1808.Web.Respon.Interface;

import com.duc1808.Web.Respon.Entity.Building_Entity;

import java.util.ArrayList;
import java.util.Map;

public interface Building_Interface {
    public ArrayList<Building_Entity> getBuilding(Map<String,Object> listmap, ArrayList<String> listtypecode);
}
