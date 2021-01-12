package com.zz.dubbo.controller;

import com.zz.dubbo.object.HelloObject;
import com.zz.dubbo.service.HelloRoundService;
import com.zz.dubbo.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author zzj
 * @className HelloController
 * @description TODO
 * @date 2020/12/15
 */
@RestController
@RequestMapping("hello")
@Api(value = "测试接口")
public class HelloController {

    @DubboReference
    private HelloService helloService;

    @DubboReference(version = "2.0.0")
    private HelloRoundService helloRoundService;

    @GetMapping("test")
    @ApiOperation(value = "普通的默认配置下的dubbo", notes = "默认")
    public String hello() {
        return helloService.hello();
    }

    @GetMapping("who")
    @ApiOperation(value = "一致性hash轮询策略", notes = "轮询策略")
    @ApiImplicitParam(paramType = "query", name = "name", value = "名称", dataType = "String", required = true, allowMultiple = false)
    public String hello(@RequestParam("name") String name) {
        return helloService.hello(name);
    }

    @PostMapping("object")
    @ApiOperation(value = "一致性hash轮询策略，实体对象", notes = "轮询策略")
    public String helloObject(@RequestBody HelloObject helloObject) {
        return helloService.hello(helloObject);
    }

    @GetMapping("round")
    @ApiOperation(value = "轮询", notes = "轮询策略")
    public String helloRound() {
        return helloRoundService.helloRound();
    }
}
