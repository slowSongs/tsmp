package com.icf.tsmp.client.configuration;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryAutoConfiguration;
import com.alibaba.cloud.nacos.ribbon.RibbonNacosAutoConfiguration;
import com.icf.tsmp.client.service.impl.TsmpRestGenericService;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.commons.util.UtilAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @auhther Arvin
 * @date 2020/7/3 18:25
 * @description:
 */
@ImportAutoConfiguration({NacosDiscoveryAutoConfiguration.class, LoadBalancerAutoConfiguration.class,
        UtilAutoConfiguration.class, RibbonAutoConfiguration.class, RibbonNacosAutoConfiguration.class})
public class RestClientAutoConfiguration {
    @Bean("tsmpRestGenericService")
    public TsmpRestGenericService tsmpRestGenericService() {
        return new TsmpRestGenericService();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
