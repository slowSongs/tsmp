package com.icf.tsmp.config.service;

import com.icf.tsmp.common.model.Result;
import com.icf.tsmp.config.model.ParamConfigDo;
import com.icf.tsmp.config.model.ServiceConfigDo;
import com.icf.tsmp.config.repository.ParamConfigMapper;
import com.icf.tsmp.config.repository.ServiceConfigMapper;
import com.icf.tsmp.model.response.ParamConfigResp;
import com.icf.tsmp.model.response.ServiceConfigResp;
import com.icf.tsmp.service.IConfigService;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auhther Arvin
 * @date 2020/7/2 18:05
 * @description:
 */
public class ConfigServiceImpl implements IConfigService {
    private static final Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Autowired
    private ServiceConfigMapper serviceConfigMapper;

    @Autowired
    private ParamConfigMapper paramConfigMapper;
    @Override
    public Result<ServiceConfigResp> getServiceConfig(String tranCode) {
        logger.info("IConfigService.getServiceConfig start,result:{}", tranCode);
        ServiceConfigDo serviceConfigDo = this.serviceConfigMapper.queryByJYDM(tranCode);
        if (null == serviceConfigDo) {
            return null;
        }
        List<ParamConfigDo> paramConfigDoList = paramConfigMapper.queryByJYDM(tranCode);
        ServiceConfigResp resp = this.converToServiceConfigResp(serviceConfigDo, paramConfigDoList);
        logger.info("IConfigService.getServiceConfig end,result:{}",resp);
        return new Result<ServiceConfigResp>().success(resp);
    }


    @Override
    public Result<List<ServiceConfigResp>> getAllServiceConfig() {
        logger.info("IConfigService.getAllServiceConfig start");
        List<ServiceConfigDo> list = serviceConfigMapper.getAllServiceConfig();
        ArrayList<ServiceConfigResp> result = new ArrayList<>();
        for (ServiceConfigDo serviceConfigDo : list) {
           ServiceConfigResp serviceConfigResp=converToServiceConfigResp(serviceConfigDo, serviceConfigDo.getParams());
            result.add(serviceConfigResp);
        }
        logger.info("IConfigService.getAllServiceConfig end");
        return new Result<List<ServiceConfigResp>>().success(result);
    }
    private ServiceConfigResp converToServiceConfigResp(ServiceConfigDo serviceConfigDo, List<ParamConfigDo> paramConfigDoList) {
        ServiceConfigResp serviceConfigResp = new ServiceConfigResp();
        serviceConfigResp.setAppId(serviceConfigDo.getXtbh());
        serviceConfigResp.setServerName(serviceConfigDo.getFwmc());
        serviceConfigResp.setClassName(serviceConfigDo.getFwlm());
        serviceConfigResp.setMethodName(serviceConfigDo.getFwffm());
        serviceConfigResp.setTranCode(serviceConfigDo.getJydm());
        serviceConfigResp.setPotocol(serviceConfigDo.getFwffm());
        serviceConfigResp.setDesc(serviceConfigDo.getFwms());
        List<ParamConfigResp> paramConfigRespList = paramConfigDoList.stream().map(this::converToParamConfigResp).collect(Collectors.toList());
        serviceConfigResp.setParamConfigList(paramConfigRespList);
        return serviceConfigResp;
    }

    private ParamConfigResp converToParamConfigResp(ParamConfigDo paramConfigDo) {
        ParamConfigResp paramConfigResp = new ParamConfigResp();
        paramConfigResp.setParamName(paramConfigDo.getCsmc());
        paramConfigResp.setParamType(paramConfigDo.getCslx());
        paramConfigResp.setComplexConfig(paramConfigDo.getCslx());
        paramConfigResp.setParamNo(paramConfigDo.getCsbh());
        return paramConfigResp;
    }

}
