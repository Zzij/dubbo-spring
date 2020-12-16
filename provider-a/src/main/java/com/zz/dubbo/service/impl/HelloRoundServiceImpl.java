package com.zz.dubbo.service.impl;

import com.zz.dubbo.service.HelloRoundService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zzj
 * @className HelloRoundServiceImpl
 * @description TODO
 * @date 2020/12/16
 */

@DubboService(version = "2.0.0", loadbalance = "roundrobin", actives = 300)
public class HelloRoundServiceImpl implements HelloRoundService {
    @Override
    public String helloRound() {
        System.out.println("a");
        return "hello round";
    }
}
