package com.icf.tsmp.config;

import com.icf.tsmp.common.utils.AesEncrypt;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @auhther Arvin
 * @date 2020/7/2 17:14
 * @description:
 */
public class TsmpDataSource extends HikariDataSource {
    private static final Logger logger = LoggerFactory.getLogger(TsmpDataSource.class);

    private String pwd;
    @Value("${password.key}")
    private String key;

    @Value("${password.iv}")
    private String iv;

    @Override
    public String getPassword() {
        if (StringUtils.isBlank(pwd)) {
            return pwd;
        }
        String password = super.getPassword();
        if (StringUtils.isBlank(password)) {
            logger.error("数据库密码没配置");
            return null;
        }
        pwd=AesEncrypt.deCipheringAES(password,key, iv);
        return pwd;
    }
}
