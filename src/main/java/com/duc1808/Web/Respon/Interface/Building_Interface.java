package com.duc1808.Web.Respon.Interface;

import com.duc1808.Web.Respon.Entity.Building_Entity;

import java.util.ArrayList;

public interface Building_Interface {
    public ArrayList<Building_Entity> getBuilding(String name,Integer id);
}
