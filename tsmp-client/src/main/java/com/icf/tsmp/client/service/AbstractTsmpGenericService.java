package com.icf.tsmp.client.service;

import com.icf.tsmp.client.exception.BizCode;
import com.icf.tsmp.common.exception.AppException;
import com.icf.tsmp.common.model.request.RequestMsg;
import com.icf.tsmp.common.model.response.ResponseMsg;
import com.icf.tsmp.model.response.ServiceConfigResp;
import javafx.scene.chart.ScatterChart;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @auhther Arvin
 * @date 2020/7/2 20:21
 * @description:
 */
public abstract class  AbstractTsmpGenericService {
    private static Map<String, ServiceConfigResp> SERVICE_CONFIG_MAP = null;

    @PostConstruct
    public void init() {
        if (SERVICE_CONFIG_MAP == null) {
            try {
                SERVICE_CONFIG_MAP = ConfigService.getAllServiceConfig();
            } catch (AppException e) {
                throw new RuntimeException("获取全部服务配置异常");
            }
        }
    }

    /**
     * 获取响应
     * @param requestMsg
     * @param classz
     * @return
     */
    protected ResponseMsg invoke(RequestMsg requestMsg, Class classz) {
        ServiceConfigResp serviceConfig = null;
        try {
            requestMsg.getJcqqsj().nullFiledValidate();
            serviceConfig = SERVICE_CONFIG_MAP.get(requestMsg.getJcqqsj().getJydm());
            if (serviceConfig == null) {
                throw new AppException(BizCode.RPC_INVOKE_ERR.getErrorCode(),"调用服务配置失败，tranCode："+requestMsg.getJcqqsj().getJydm());
            }
            // TODO 参数校验

        } catch (AppException e) {
            ResponseMsg responseMsg = new ResponseMsg();
            responseMsg.setJcxysj(requestMsg.getJcqqsj());
            responseMsg.setFhm(e.getErrorcode());
            responseMsg.setFhmsxx(e.getMessage());
            return responseMsg;
        }
        return doInvoke(requestMsg, serviceConfig, classz);

    }

    protected abstract ResponseMsg doInvoke(RequestMsg requestMsg, ServiceConfigResp serviceConfig, Class classz);
}
