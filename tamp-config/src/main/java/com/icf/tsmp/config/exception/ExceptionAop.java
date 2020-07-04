package com.icf.tsmp.config.exception;

import com.icf.tsmp.common.exception.AppException;
import com.icf.tsmp.common.model.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @auhther Arvin
 * @date 2020/7/2 17:32
 * @description:
 */
@Aspect
@Component
public class ExceptionAop {
    private static final Logger logger=LoggerFactory.getLogger(Exception .class);

    @Pointcut(value = "execution(* com.icf.tsmp.config.service..*.*(..))")
    public void customerPointcut() {

    }

    @Around("customerPointcut()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            logger.error("tsmp config 处理异常，e:",e);
            return handlerException(pjp, e);
        }
    }

    private Result handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result result = new Result();

        if (e instanceof AppException) {
            result.setFhm(((AppException) e).getErrorcode());
            result.setFhmsxx((((AppException) e).getMessage()));
        } else {
            logger.error("tsmp handlerExpection", e);
            result.setFhm(TsmpCode.SYSTEM_ERR.getErrorCode());
            result.setFhmsxx(e.toString());
        }
        logger.error("异常结果封装，result:{}", result);
        return result;
    }
}
