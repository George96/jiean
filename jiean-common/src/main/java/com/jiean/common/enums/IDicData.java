package com.jiean.common.enums;

import com.jiean.common.utils.DictUtils;

/**
 * 字典表接口
 * @author : george
 */
public interface IDicData {

    String getCode();

    String getText();

    /**
     * 通过 code 获取指定 枚举类型中的 枚举对象
     *
     * @param enumClass
     * @param code
     * @param <T>
     * @return
     */
    static <T extends IDicData> T getByCode(Class<T> enumClass, String code) {
        //通过反射取出Enum所有常量的属性值
        for (T each : enumClass.getEnumConstants()) {
            //利用code进行循环比较，获取对应的枚举
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

    /**
     * 通过 code 获取指定 枚举类型中的 text
     *
     * @param enumClass
     * @param code
     * @param <T>
     * @return
     */
    static <T extends IDicData> String getTextByCode(Class<T> enumClass, String code) {
        IDicData byCode = getByCode(enumClass, code);
        if (null == byCode) {
            return null;
        }
        return byCode.getCode();
    }

    /**
     * 当前对象的 code 是否 和参数中的 code 相等
     * @param code
     * @return
     */
    default boolean isCode(String code) {
        return this.getCode().equals(code);
    }

    /**
     * 当前对象是否和已知对象不等
     * @param gender
     * @return
     */
    default boolean isNotEquals(IDicData gender) {
        return this != gender;
    }
}
