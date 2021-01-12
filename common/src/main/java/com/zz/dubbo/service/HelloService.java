package com.zz.dubbo.service;

import com.zz.dubbo.object.HelloObject;

/**
 * @author zzj
 * @className HelloService
 * @description TODO
 * @date 2020/12/15
 */
public interface HelloService {
    /**
     * 打招呼
     * @return hello
     */
    String hello();

    /**
     * 打招呼
     * @param name 打招呼的名字
     * @return  hello name
     */
    String hello(String name);

    /**
     * 打招呼
     * @param helloObject
     * @return
     */
    String hello(HelloObject helloObject);
}
