package com.icf.tsmp.client.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @auhther Arvin
 * @date 2020/7/2 21:31
 * @description:
 */
public class JsonUtils {
    public static Map<String, Object> jsonToMap(String json) {
        JSONObject obj = JSON.parseObject(json);
        Map<String, Object> data = new HashMap<>();
        Iterator it = obj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,Object> entry = (Map.Entry<String, Object>) it.next();
            data.put(entry.getKey(), entry.getValue());
        }
        return data;
    }
}
