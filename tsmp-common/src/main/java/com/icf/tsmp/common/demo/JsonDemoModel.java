package com.icf.tsmp.common.demo;

import java.util.Arrays;
import java.util.List;

public class JsonDemoModel {

    private JsonDemoInnerModel jsonDemoInnerModel = new JsonDemoInnerModel();

    private String value1 = "value1";

    private String value2 = "value2";

    private Integer intVlaue = 1;

    private Integer[] ints = {1, 2, 3};
  private List<JsonArrayModel> arrayModels = Arrays.asList(new JsonArrayModel());

    public JsonDemoInnerModel getJsonDemoInnerModel() {
        return jsonDemoInnerModel;
    }

    public void setJsonDemoInnerModel(JsonDemoInnerModel jsonDemoInnerModel) {
        this.jsonDemoInnerModel = jsonDemoInnerModel;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public List<JsonArrayModel> getArrayModels() {
        return arrayModels;
    }

    public void setArrayModels(List<JsonArrayModel> arrayModels) {
        this.arrayModels = arrayModels;
    }

    public Integer getIntVlaue() {
        return intVlaue;
    }

    public void setIntVlaue(Integer intVlaue) {
        this.intVlaue = intVlaue;
    }

    public Integer[] getInts() {
        return ints;
    }

    public void setInts(Integer[] ints) {
        this.ints = ints;
    }
}
