package com.icf.tsmp.common.check;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @auhther Arvin
 * @date 2020/7/6 11:05
 * @description:
 */
@Component
public class InspceionCheckerChooser implements ApplicationContextAware {
    private ApplicationContext context;

    private Map<String, InspectionChecker> chooseMap = new HashMap<>();

    public InspectionChecker choose(String typeCheck) {
        return chooseMap.get(typeCheck);
    }

    @PostConstruct
    public void register() {
        Map<String, InspectionChecker> map = context.getBeansOfType(InspectionChecker.class);
        for (InspectionChecker checkers : map.values()) {
            for (String support : checkers.supports()) {
                chooseMap.put(support, checkers);
            }
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }
}