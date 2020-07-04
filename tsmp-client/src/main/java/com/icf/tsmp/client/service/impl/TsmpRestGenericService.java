package com.icf.tsmp.client.service.impl;

import com.icf.tsmp.client.exception.BizCode;
import com.icf.tsmp.client.service.AbstractTsmpGenericService;
import com.icf.tsmp.client.service.TsmpGenericService;
import com.icf.tsmp.common.model.Result;
import com.icf.tsmp.common.model.request.RequestMsg;
import com.icf.tsmp.common.model.response.ResponseMsg;
import com.icf.tsmp.model.response.ServiceConfigResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @auhther Arvin
 * @date 2020/7/3 17:58
 * @description:
 */
public class TsmpRestGenericService extends AbstractTsmpGenericService implements TsmpGenericService {
    private final static Logger logger = LoggerFactory.getLogger(TsmpRestGenericService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Override
    protected ResponseMsg doInvoke(RequestMsg requestMsg, ServiceConfigResp serviceConfig, Class classz) {
        String method = serviceConfig.getPotocol();
        StringBuilder url = new StringBuilder("http://");
        url.append(serviceConfig.getServerName()).append("/").append(serviceConfig.getMethodName());
        ResponseMsg responseMsg = new ResponseMsg();
        Result result = null;
        if (method.equalsIgnoreCase("get")) {
            Object ywqqsj = requestMsg.getYwqqsj();
            if (ywqqsj != null && ywqqsj instanceof Map) {
                url.append("?");
                ((Map) ywqqsj).forEach((key, value) -> {
                    url.append(key).append("=").append(value).append("&");
                });
            }
            result = restTemplate.getForObject(url.toString(), Result.class);
        } else if (method.equalsIgnoreCase("post")) {
            Object ywqqsj = requestMsg.getYwqqsj();
            result= restTemplate.postForObject(url.toString(), ywqqsj, Result.class);
        }else {
            responseMsg.setJcxysj(requestMsg.getJcqqsj());
            responseMsg.setFhm(BizCode.RPC_INVOKE_ERR.getErrorCode());
            responseMsg.setFhmsxx("暂不支持此类型" + method);
            return responseMsg;
        }
        requestMsg.setJcqqsj(requestMsg.getJcqqsj());
        if (null == result) {
            responseMsg.setFhm(BizCode.RPC_INVOKE_ERR.getErrorCode());
            responseMsg.setFhmsxx("服务提供方返回数据为空");
            return responseMsg;
        }
        responseMsg.setFhm(result.getFhm());
        responseMsg.setFhmsxx(result.getFhmsxx());
        responseMsg.setYwxysj(result.getYwxysj());
        return responseMsg;
    }

    @Override
    public ResponseMsg send(RequestMsg requestMsg, Class responseClazz) {
        return super.invoke(requestMsg,responseClazz);
    }
}
