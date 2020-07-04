package com.icf.tsmp.service;

import com.icf.tsmp.common.model.Result;
import com.icf.tsmp.model.response.ServiceConfigResp;

import java.util.List;

public interface IConfigService {
    /**
     * 根据交易代码获取服务配置信息
     */
    Result<ServiceConfigResp> getServiceConfig(String tranCode);

    /**
     * 查询全部配置信息
     */
    Result<List<ServiceConfigResp>> getAllServiceConfig();
}
