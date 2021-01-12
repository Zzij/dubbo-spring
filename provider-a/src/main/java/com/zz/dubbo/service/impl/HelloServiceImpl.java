package com.zz.dubbo.service.impl;

import com.zz.dubbo.object.HelloObject;
import com.zz.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zzj
 * @className HelloServiceImpl
 * @description TODO
 * @date 2020/12/15
 */
@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        System.out.println("a");
        return "hello";
    }

    @Override
    public String hello(String name) {
        System.out.println("a");
        return "hello " + name;
    }

    @Override
    public String hello(HelloObject helloObject) {
        System.out.println("a");
        return "hello " + helloObject.getName();
    }
}
