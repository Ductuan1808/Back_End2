package com.duc1808.Web.Respon.implement;

import com.duc1808.Web.Respon.Entity.Building_Entity;
import com.duc1808.Web.Respon.Interface.Building_Interface;
import com.duc1808.Web.Tien_Ich.Connector;
import com.duc1808.Web.Tien_Ich.Number_Convert;
import com.duc1808.Web.Tien_Ich.String_Check;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;


@Repository
public class Building_imp implements Building_Interface {
    @Override
    public ArrayList<Building_Entity> getBuilding(Map<String,Object> listmap,ArrayList<String> listtypecode ) {
        ArrayList<Building_Entity>list=new ArrayList<>();
        StringBuilder sql;
             try{
                Connection c = Connector.connect();
                sql = new StringBuilder("Select * From building as b ");
                JoinQery(listmap,listtypecode,sql);
                StringBuilder where = new StringBuilder("Where 1=1 ");
                QeryNormal(listmap,listtypecode,where);
                querySpecial(listmap,listtypecode,where);
                where.append(" group by b.id ");
                sql.append(where);
                 System.out.println(sql);
                Statement st=c.createStatement();
                ResultSet rs =st.executeQuery(sql.toString());
                while(rs.next()){
                    Building_Entity building_entity = new Building_Entity();
                    building_entity.setId(rs.getLong("id"));
                    building_entity.setName(rs.getString("name"));
                    building_entity.setStreet(rs.getString("street"));
                    building_entity.setWard(rs.getString("ward"));
                    building_entity.setDistrictId(rs.getLong("districtid"));
                    building_entity.setNumberOfBasement(rs.getInt("numberOfBasement"));
                    building_entity.setFloorArea(rs.getInt("floorarea"));
                    building_entity.setManagerName(rs.getString("managerName"));
                    building_entity.setManagerPhoneNumber(rs.getString("managerPhoneNumber"));
                    list.add(building_entity);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return list;
    }

    public static void JoinQery(Map<String,Object> listmap,ArrayList<String> listtypecode,StringBuilder sql) {
        String staffid = (String) listmap.get("staffid");
        if (String_Check.CheckString(staffid)) {
            sql.append("Inner join assignmentbuilding on b.id = assignmentbuilding.buildingid ");
        }
        if (listtypecode != null && listtypecode.size() != 0) {
            sql.append("Inner join buildingrenttype on b.id =buildingrenttype.buildingid ");
            sql.append("Inner join renttype on buildingrenttype.renttypeid = renttype.id ");
        }
        String rentareato = (String) listmap.get("rentareato");
        String rentareafrom = (String) listmap.get("rentareafrom");
        if ((String_Check.CheckString(rentareafrom)) || (String_Check.CheckString(rentareato))) {
            sql.append("Inner join rentarea on b.id = rentarea.buildingid ");
        }
    }
    public static void QeryNormal(Map<String,Object> listmap,ArrayList<String> listtypecode,StringBuilder where) {
        for (Map.Entry<String, Object> it : listmap.entrySet()) {
            if (!it.getKey().equals("staffid") && !it.getKey().equals("typecode") && !it.getKey().startsWith("rentarea") && !it.getKey().startsWith("rentPrice")) {
                String value = it.getValue().toString();
                if (String_Check.CheckString(value)) {
                    if (Number_Convert.Convert_Number(value) == true){
                        where.append(" And b." + it.getKey() + " = " + value);
                    } else {
                        where.append(" And b." + it.getKey() + " Like '%" + value + "%' ");
                    }
                }
                System.out.println("Street: " + value);

            }
        }
    }

    public static void querySpecial(Map<String, Object> listmap, ArrayList<String> listtypecode, StringBuilder where) {
        String staffId = (String) listmap.get("staffId");
        if (String_Check.CheckString(staffId)) {
            where.append(" AND assignmentbuilding.staffid = " + staffId);
        }

        String rentAreaTo = (String) listmap.get("rentareato");
        String rentAreaFrom = (String) listmap.get("rentareafrom");
        if (String_Check.CheckString(rentAreaFrom) == true || String_Check.CheckString(rentAreaTo) == true) {
            if (String_Check.CheckString(rentAreaFrom)) {
                where.append(" AND rentarea.value >=" + rentAreaFrom);
            }
            if (String_Check.CheckString(rentAreaTo)) {
                where.append(" AND rentarea.value <=" + rentAreaTo);
            }
        }
        String rentPriceTo = (String)listmap.get("rentPriceTo");
        String rentPriceFrom = (String)listmap.get("rentPriceFrom");
        if(String_Check.CheckString(rentPriceTo)== true || String_Check.CheckString(rentPriceFrom)== true) {
            if(String_Check.CheckString(rentPriceFrom)) {
                where.append(" AND b.rentprice >=" + rentPriceFrom);
            }
            if(String_Check.CheckString(rentPriceTo)) {
                where.append(" AND b.rentprice <=" + rentPriceTo);
            }
        }
        if(listtypecode != null && listtypecode.size() != 0) {
            where.append(" AND renttype.code IN('" + String.join("','", listtypecode) + "')");
        }
    }


}

