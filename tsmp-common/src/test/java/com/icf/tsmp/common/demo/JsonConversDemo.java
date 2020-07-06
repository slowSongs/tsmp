package com.icf.tsmp.common.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icf.tsmp.common.TsmpCommonApplication;
import com.icf.tsmp.common.check.InspceionCheckerChooser;
import com.icf.tsmp.common.utils.CheckConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TsmpCommonApplication.class)
public class JsonConversDemo {

    @Autowired
    private  InspceionCheckerChooser chooser;

    @Test
    public void main() {
        JsonDemoModel jsonDemoModel = new JsonDemoModel();
        JSONObject object = (JSONObject) JSONObject.toJSON(jsonDemoModel);
        System.out.println("====" + object);
        getAllKey(object);
    }

    /**
     * 遍历jsonobject
     *
     * @param jsonObject
     */
    public  void getAllKey(JSONObject jsonObject) {
        if (jsonObject != null) {
            for (Map.Entry entry : jsonObject.entrySet()) {
                if (entry.getValue() instanceof JSONObject) {
                    getAllKey((JSONObject) entry.getValue());
                } else if (entry.getValue() instanceof JSONArray) {
                    JSONArray json = (JSONArray) entry.getValue();
                    if (json != null && json.size() > 0) {
                        for (int i = 0; i < json.size(); i++) {
                            if (json.get(i) instanceof JSONObject) {
                                JSONObject job = json.getJSONObject(i);
                                getAllKey(job);
                            } else {
                                // 如果是基本类型的数组则不需要遍历取出值
                                DbParameterCalibration(entry.getKey(), entry.getValue());
                                //TODO 这里按照需求可以在定义一个方法传一个基本类型的数组，遍历数组校验值
                                break;
                            }
                        }
                    }
                } else {
                    // 调用校验方法
                    DbParameterCalibration(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    /**
     * 获取数据库中的规则进行校验
     */
    public  void DbParameterCalibration(Object key, Object value) {
        //假设数据库查出的校验规则
        String rule = CheckConstants.NOT_NULL;
        chooser.choose(rule);
        System.out.println("key:" + key + "，value：" + value);
    }
}
