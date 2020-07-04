package com.icf.tsmp.client.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @auhther Arvin
 * @date 2020/7/2 20:31
 * @description:
 */
public class Config {
    static Logger logger = LoggerFactory.getLogger(Config.class);

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(Config.class.getResourceAsStream("tsmp-client.properties"));
        } catch (IOException e) {
            logger.error("加载配置文件失败", e);
        }
    }

    public static String getObject(String key) {
        return properties.getProperty(key);
    }
}
