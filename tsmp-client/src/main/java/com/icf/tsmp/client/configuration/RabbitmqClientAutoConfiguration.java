package com.icf.tsmp.client.configuration;

import com.icf.tsmp.client.service.impl.TsmpRabbitmqGenericService;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @auhther Arvin
 * @date 2020/7/3 18:15
 * @description:
 */
@ImportAutoConfiguration({RabbitmqClientAutoConfiguration.class})
public class RabbitmqClientAutoConfiguration {
    @Bean("tsmpRabbitmqGenericService")
    public TsmpRabbitmqGenericService tsmpRabbitmqGenericService() {
        return new TsmpRabbitmqGenericService();
    }

    @Autowired
    private Jackson2JsonMessageConverter jsonMessageConverter;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
