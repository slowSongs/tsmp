package com.icf.tsmp.client.service.impl;

import com.icf.tsmp.client.exception.BizCode;
import com.icf.tsmp.client.service.AbstractTsmpGenericService;
import com.icf.tsmp.client.service.TsmpMqGenericService;
import com.icf.tsmp.common.model.request.RequestMsg;
import com.icf.tsmp.common.model.response.ResponseMsg;
import com.icf.tsmp.model.response.ServiceConfigResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auhther Arvin
 * @date 2020/7/3 15:09
 * @description:
 */
public class TsmpRabbitmqGenericService extends AbstractTsmpGenericService implements TsmpMqGenericService {
    private final static Logger logger = LoggerFactory.getLogger(TsmpRabbitmqGenericService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    protected ResponseMsg doInvoke(RequestMsg requestMsg, ServiceConfigResp serviceConfig, Class classz) {
        String routingkey = serviceConfig.getMethodName();
        String exchangeName = serviceConfig.getClassName();
        ResponseMsg responseMsg = new ResponseMsg();
        try {
            rabbitTemplate.convertAndSend(exchangeName, routingkey, requestMsg);
        } catch (AmqpException e) {
            logger.error("消息异常", e);
            responseMsg.setJcxysj(requestMsg.getJcqqsj());
            responseMsg.setFhm(BizCode.RPC_INVOKE_ERR.getErrorCode());
            responseMsg.setFhmsxx("mq client error"+e.getMessage());
            return responseMsg;
        }
        responseMsg.setJcxysj(requestMsg.getJcqqsj());
        responseMsg.setFhm(BizCode.SUCCESS.getErrorCode());
        responseMsg.setFhmsxx(BizCode.SUCCESS.getErrorDesc());
        return responseMsg;
    }

    @Override
    public ResponseMsg send(RequestMsg requestMsg) {
        return super.invoke(requestMsg, null);
    }
}
