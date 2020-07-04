package com.icf.tsmp.client.service;

import com.icf.tsmp.common.model.request.RequestMsg;
import com.icf.tsmp.common.model.response.ResponseMsg;

public interface TsmpMqGenericService {
    /**
     * 异步服务调用
     * @param requestMsg 请求参数
     * @return
     */
    ResponseMsg send(RequestMsg requestMsg);
}
