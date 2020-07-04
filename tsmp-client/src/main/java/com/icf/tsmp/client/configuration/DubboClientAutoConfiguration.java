package com.icf.tsmp.client.configuration;

import com.icf.tsmp.client.service.impl.TsmpDubboGenericService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auhther Arvin
 * @date 2020/7/2 19:44
 * @description:
 */
@Configuration
public class DubboClientAutoConfiguration {
    @Bean("tsmpDubboGenericService")
    public TsmpDubboGenericService tsmpDubboGenericService() {
        return new TsmpDubboGenericService();
    }
}
