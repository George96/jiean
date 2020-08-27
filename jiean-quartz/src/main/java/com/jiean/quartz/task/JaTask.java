package com.jiean.quartz.task;

import org.springframework.stereotype.Component;
import com.jiean.common.utils.StringUtils;

/**
 * 定时任务调度测试
 *
 * @author george
 */
@Component("jaTask")
public class JaTask {
    public void jaMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void jaParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void jaNoParams() {
        System.out.println("执行无参方法");
    }
}
