package com.icf.tsmp.common.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class JsonConversDemo {

    public static void main(String[] args) {
        JsonDemoModel jsonDemoModel = new JsonDemoModel();
        JSONObject object =(JSONObject) JSON.toJSON(jsonDemoModel);
        getAllKey(object);
    }

    /**
     *  遍历jsonobject
     * @param jsonObject
     */
    public static void getAllKey(JSONObject jsonObject) {
        if (jsonObject!=null) {
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (entry.getValue() instanceof JSONObject) {
                    getAllKey((JSONObject)entry.getValue());
                }else if (entry.getValue() instanceof JSONArray){
                    JSONArray json = (JSONArray)entry.getValue();
                    if (json!=null && json.size()>0) {
                        for (int i=0; i<json.size(); i++) {
                            JSONObject job = json.getJSONObject(i);
                            getAllKey(job);
                        }
                    }
                }else {
                    // 调用校验方法
                    DbParameterCalibration(entry.getKey(),entry.getValue());
                }
            }
        }
    }

    /**
     * 获取数据库中的规则进行校验
     */
    public static void DbParameterCalibration(Object key, Object value) {
        System.out.println("key:" + key + "，value：" + value);
    }
}
