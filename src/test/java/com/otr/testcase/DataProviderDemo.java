package com.otr.testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class DataProviderDemo extends BaseTest {

    @Test(dataProvider = "getMeta")
    public void Test(Map<String, String> map){
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
    }
@DataProvider
    public Object[][] getMetaData(){
        return new Object[][]{
                {"abcd","123"},
                {"efgh","456"}
        };
}

@DataProvider
    public Object[] getMeta(){
        Map<String, String> map = new HashMap<>();
        map.put("username","abcd");
    map.put("password","1234");
    map.put("address","efgh");
    Map<String, String> map1 = new HashMap<>();
    map1.put("username","ab");
    map1.put("password","12");
    map1.put("address","efgh");
    List<Map<String, String>> list = new ArrayList<>();
    list.add(map);
    list.add(map1);
    return  list.toArray();

}

}
