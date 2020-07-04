package com.icf.tsmp.client.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.icf.tsmp.client.dubbo.DubboGenericFactory;
import com.icf.tsmp.client.exception.BizCode;
import com.icf.tsmp.client.utils.Constants;
import com.icf.tsmp.common.exception.AppException;
import com.icf.tsmp.model.response.ServiceConfigResp;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auhther Arvin
 * @date 2020/7/2 20:25
 * @description: 通用化服务配置调用接口
 */
public class ConfigService {
    /**
     * 根据交易码获取配置信息
     *
     * @param trancode
     * @return
     * @throws AppException
     */
    public static ServiceConfigResp getServiceConfig(String trancode) throws AppException {
        GenericService genericService = DubboGenericFactory.getGenericService(Constants.TSMP_CONFIG_SERVICE);
        Object object = genericService.$invoke(Constants.TSMP_GET_SERVICE_METHOD, new String[]{"java.lang.String"}, new Object[]{trancode});
        if (null == object) {
            throw new AppException(BizCode.SERVICE_CONFIG_NULL_ERR.getErrorCode(), BizCode.SERVICE_CONFIG_NULL_ERR.getErrorDesc());
        }
        JSONObject result = JSONObject.parseObject(JSON.toJSONString(object));
        if (!BizCode.SUCCESS.getErrorCode().equals(result.getString(Constants.RESULT_FHM))) {
            throw new AppException(BizCode.RPC_INVOKE_ERR.getErrorCode(), "调用服务配置失败，tranCode" + trancode);
        }
        Object fhsj = result.get(Constants.RESULT_YWXYSJ);
        if (null == fhsj) {
            throw new AppException(BizCode.SERVICE_CONFIG_NULL_ERR.getErrorCode(), BizCode.SERVICE_CONFIG_NULL_ERR.getErrorDesc());
        }
        return JSONObject.parseObject(JSON.toJSONString(fhsj), ServiceConfigResp.class);
    }

    /**
     * 获取全部配置信息
     */
    public static Map<String, ServiceConfigResp> getAllServiceConfig() throws AppException {
        GenericService genericService = DubboGenericFactory.getGenericService(Constants.TSMP_CONFIG_SERVICE);
        Object object = genericService.$invoke(Constants.TSMP_GET_ALL_SERVICE_NETHOD, new String[]{}, new Object[]{});
        if (null == object) {
            throw new AppException(BizCode.SERVICE_CONFIG_NULL_ERR.getErrorCode(), BizCode.SERVICE_CONFIG_NULL_ERR.getErrorDesc());
        }
        JSONObject result = JSONObject.parseObject(JSON.toJSONString(object));
        if (!BizCode.SUCCESS.getErrorCode().equals(result.getString(Constants.RESULT_FHM))) {
            throw new AppException(BizCode.RPC_INVOKE_ERR.getErrorCode(), "获取全部服务配置失败");
        }
        Object fhsj = result.get(Constants.RESULT_YWXYSJ);
        if (null == fhsj) {
            throw new AppException(BizCode.SERVICE_CONFIG_NULL_ERR.getErrorCode(), BizCode.SERVICE_CONFIG_NULL_ERR.getErrorDesc());
        }
        List<ServiceConfigResp> list = JSONObject.parseArray(JSON.toJSONString(fhsj), ServiceConfigResp.class);
        Map<String, ServiceConfigResp> map = list.stream().collect(Collectors.toMap(ServiceConfigResp::getTranCode, (a) -> a));
        return map;
    }
}
