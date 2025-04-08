package com.duc1808.Web.Tien_Ich;

public class Number_Convert {

    public static boolean Convert_Number(String data){
        try{
            Integer num =Integer.parseInt(data);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
