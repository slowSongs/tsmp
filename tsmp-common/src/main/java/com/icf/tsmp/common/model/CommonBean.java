package com.icf.tsmp.common.model;

import com.icf.tsmp.common.exception.AppException;

import java.lang.reflect.Field;

/**
 * @auhther Arvin
 * @date 2020/7/2 10:38
 * @description:
 */
public class CommonBean implements java.io.Serializable {
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getClass().getSimpleName()).append("[");
        Class<?> s = this.getClass();
        Field[] declaredFields = s.getDeclaredFields();
        for (Field field : declaredFields) {
            if (!"serialVersionUID".equals(field.getName())) {
                field.setAccessible(true);
                try{
                    Object value = field.get(this);
                    if (value != null) {
                        stringBuilder.append(field.getName()).append("=").append(value).append(",");
                    }
                } catch (IllegalAccessException e) {
                }
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void nullFiledValidate() throws AppException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(this);
                } catch (IllegalAccessException e) {

                }
                NotNull notNull = field.getAnnotation(NotNull.class);
                if (null == value) {
                    throw new AppException("000003", notNull.filedName() + "不能为空");
                }
            }
        }
    }
}
