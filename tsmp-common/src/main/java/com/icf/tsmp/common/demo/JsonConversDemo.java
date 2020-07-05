package com.icf.tsmp.common.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonConversDemo {

    public static void main(String[] args) {
        JsonDemoModel jsonDemoModel = new JsonDemoModel();
        JSONObject object = (JSONObject)JSONObject.toJSON(jsonDemoModel);
        System.out.println("===="+object);
        getAllKey(object);
    }

    /**
     *  遍历jsonobject
     * @param jsonObject
     */
    public static void getAllKey(JSONObject jsonObject){
        if (jsonObject!=null) {
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (entry.getValue() instanceof JSONObject) {
                    getAllKey((JSONObject)entry.getValue());
                }else if (entry.getValue() instanceof JSONArray){
                    JSONArray json = (JSONArray)entry.getValue();
                    if (json!=null && json.size()>0) {
                        for (int i=0; i<json.size(); i++) {
                            if (json.get(i) instanceof JSONObject) {
                                JSONObject job = json.getJSONObject(i);
                                getAllKey(job);
                            }else {
                                // 如果是基本类型的数组则不需要遍历取出值
                                DbParameterCalibration(entry.getKey(),entry.getValue());
                                //TODO 这里按照需求可以在定义一个方法传一个基本类型的数组，遍历数组校验值
                                break;
                            }
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
