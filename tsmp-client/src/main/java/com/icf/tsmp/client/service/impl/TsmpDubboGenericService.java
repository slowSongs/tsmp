package com.icf.tsmp.client.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.icf.tsmp.client.dubbo.DubboGenericFactory;
import com.icf.tsmp.client.exception.BizCode;
import com.icf.tsmp.client.model.ParamType;
import com.icf.tsmp.client.service.AbstractTsmpGenericService;
import com.icf.tsmp.client.service.TsmpGenericService;
import com.icf.tsmp.client.utils.Constants;
import com.icf.tsmp.client.utils.JsonUtils;
import com.icf.tsmp.common.model.Result;
import com.icf.tsmp.common.model.request.RequestMsg;
import com.icf.tsmp.common.model.response.ResponseMsg;
import com.icf.tsmp.model.response.ParamConfigResp;
import com.icf.tsmp.model.response.ServiceConfigResp;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.List;
import java.util.Map;

/**
 * @auhther Arvin
 * @date 2020/7/2 21:21
 * @description:
 */
public class TsmpDubboGenericService extends AbstractTsmpGenericService implements TsmpGenericService {

    @Override
    public ResponseMsg send(RequestMsg requestMsg, Class responseClazz) {
        return super.invoke(requestMsg,responseClazz);
    }
    @Override
    protected ResponseMsg doInvoke(RequestMsg requestMsg, ServiceConfigResp serviceConfig, Class responseClassz) {
        ResponseMsg responseMsg = new ResponseMsg();
        Object result=doubleInvoke(requestMsg, serviceConfig);
        responseMsg.setJcxysj(requestMsg.getJcqqsj());
        this.covertToYwyxsj(result, responseMsg, responseClassz);
        return responseMsg;
    }



    private Object doubleInvoke(RequestMsg requestMsg, ServiceConfigResp serviceConfig) {
        GenericService genericService = DubboGenericFactory.getGenericService(serviceConfig.getClassName());
        String method = serviceConfig.getMethodName();

        List<ParamConfigResp> paramConfigList = serviceConfig.getParamConfigList();
        int size = paramConfigList.size();
        String[] types=new String[size];
        Object[]params=new Object[size];
        for (int i = 0; i < paramConfigList.size(); i++) {
            ParamConfigResp paramConfig = paramConfigList.get(i);
            types[i] = paramConfig.getParamType();
            Object ywqqsj = requestMsg.getYwqqsj();
            if (ParamType.META.equals(this.getParamCategroy(paramConfig.getParamType()))) {
                if (size > 1) {
                    Map<String, Object> jwqqsjMap = JsonUtils.jsonToMap(JSON.toJSONString(ywqqsj));
                } else {
                    params[i] = ywqqsj;
                }
            }
            if (ParamType.OBJECT.equals(this.getParamCategroy(paramConfig.getParamType()))) {
                Map<String, Object> jwqqsjMap = JsonUtils.jsonToMap(JSON.toJSONString(ywqqsj));
                params[i] = ywqqsj;
            }
        }
            Object result = null;
            try {
                result = genericService.$invoke(method, types, params);
            } catch (GenericException e) {
                result = new Result().fail(BizCode.SYSTEM_ERR.getErrorCode(), e.getExceptionMessage());
            }
        return result;

    }

    private ParamType getParamCategroy(String paramType) {
        if (paramType.contains("String") || paramType.contains("Interger") || paramType.contains("Long")
                || paramType.contains("Dubbo") || paramType.contains("Float")) {
            return ParamType.META;
        }
        return ParamType.OBJECT;
    }

    private void covertToYwyxsj(Object response, ResponseMsg responseMsg, Class classz) {
        if (response == null) {
            responseMsg.setFhm(BizCode.RPC_INVOKE_ERR.getErrorCode());
            responseMsg.setFhmsxx("服务提供方返回数量");
            return;
        }
        JSONObject result = JSONObject.parseObject(JSON.toJSONString(response));
        if (!BizCode.SUCCESS.getErrorCode().equals(result.getString("fhm"))) {
            responseMsg.setFhm(result.getString(Constants.RESULT_FHM));
            responseMsg.setFhmsxx(result.getString(Constants.RESULT_FHMSXX));
            return;
        }
        responseMsg.setFhm(BizCode.SUCCESS.getErrorCode());
        responseMsg.setFhmsxx(BizCode.SUCCESS.getErrorDesc());
        Object fhsj = result.get(Constants.RESULT_YWXYSJ);
        Object o = JSON.parseObject(JSON.toJSONString(fhsj), classz);
        responseMsg.setYwxysj(o);
    }

}
