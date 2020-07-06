package com.icf.tsmp.common.check.checker;

import com.icf.tsmp.common.check.InspectionChecker;
import com.icf.tsmp.common.utils.CheckConstants;
import org.springframework.stereotype.Component;

/**
 * @auhther Arvin
 * @date 2020/7/6 11:12
 * @description:
 */
@Component
public class NotNullChecker extends InspectionChecker {

    //校验规则
    @Override
    public boolean check(Object value) {
        System.out.println("执行了对应的非空校验规则");
        return true;
    }

    //支持的类型
    @Override
    public String[] supports() {
        return new String[]{CheckConstants.NOT_NULL};
    }

}
