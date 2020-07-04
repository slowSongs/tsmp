package com.icf.tsmp.client.dubbo;

import com.icf.tsmp.client.utils.Config;
import javafx.application.Application;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.Optional;

/**
 * @auhther Arvin
 * @date 2020/7/2 19:49
 * @description:
 */
public class DubboGenericFactory {
    private static ApplicationConfig getApplicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(Config.getObject("dss_appliction_name"));
        return applicationConfig;
    }

    private static RegistryConfig getRegistryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(Config.getObject("dss_registry_address"));
        return registryConfig;
    }

    public static GenericService getGenericService(String interfaceName) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        Optional<ApplicationConfig> applicationConfigOptional = ConfigManager.getInstance().getApplication();
        //client为dubbo应用时，不能重复设置application
        if (!applicationConfigOptional.isPresent()) {
            reference.setApplication(getApplicationConfig());
        }
        reference.setRegistry(getRegistryConfig());
        //设置调用的reference属性，下面设置了协议、接口名、版本、超时时间
        reference.setProtocol("dubbo");
        reference.setTimeout(Integer.valueOf(Config.getObject("dss_dubbo_timeout")));
        reference.setGeneric(true);
        reference.setInterface(interfaceName);
        //本次不做检查
        reference.setValidation("true");

        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        return genericService;
    }
}
