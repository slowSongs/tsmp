package com.icf.tsmp.client;

import com.icf.tsmp.client.configuration.DubboClientAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DubboClientAutoConfiguration.class})
public @interface EnableTsmpClient {

}
