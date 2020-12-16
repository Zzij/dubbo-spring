package com.zz.dubbo.controller;

import com.zz.dubbo.service.HelloRoundService;
import com.zz.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzj
 * @className HelloController
 * @description TODO
 * @date 2020/12/15
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @DubboReference
    private HelloService helloService;

    @DubboReference(version = "2.0.0")
    private HelloRoundService helloRoundService;

    @GetMapping("test")
    public String hello() {
        return helloService.hello();
    }

    @GetMapping("who")
    public String hello(@RequestParam("name") String name) {
        return helloService.hello(name);
    }

    @GetMapping("round")
    public String helloRound() {
        return helloRoundService.helloRound();
    }
}
