package com.duc1808.Web.Tien_Ich;

public class String_Check {
    public static boolean CheckString(String data){
        if(data!=null&&!data.equals("")){
            return true;
        }else{
            return false;
        }
    }
}
