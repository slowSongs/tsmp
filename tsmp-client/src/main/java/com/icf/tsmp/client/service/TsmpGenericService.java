package com.icf.tsmp.client.service;

import com.icf.tsmp.common.model.request.RequestMsg;
import com.icf.tsmp.common.model.response.ResponseMsg;

public interface TsmpGenericService {
    /**
     * 服务调用
     * @param requestMsg 请求参数
     * @param responseClazz 响应对象类型
     * @return
     */
    ResponseMsg send(RequestMsg requestMsg, Class responseClazz);
}
