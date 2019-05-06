package com.oushuai.animal.test;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class Test {
    public static void main(String[] args) throws IOException {
        String JsonContext = new Unit().ReadFile("D:\\czjl.json");
        //   JSONArray jsonArray = JSONArray.fromObject(JsonContext);
        JSONObject jsonObject = JSONObject.fromObject(JsonContext);
        System.out.println(jsonObject);
        JSONObject jsonObject1 = jsonObject.getJSONObject("body").getJSONArray("listMap").getJSONObject(0);
        int size = jsonObject1.size();

        System.out.println(jsonObject1.get("DCC_CHARGE_SOURCE_ID"));
        System.out.println(jsonObject1.get("DCC_PAID_TIME"));
            System.out.println(jsonObject1.get("T_BALANCE_TYPE_ID"));
        System.out.println(jsonObject1.get("DCC_PAYMENT_AMOUNT"));
    }
}
