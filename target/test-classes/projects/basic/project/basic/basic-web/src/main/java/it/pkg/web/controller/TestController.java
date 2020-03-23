package it.pkg.web.controller;

import it.pkg.db.model.Test;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.annotation.Cacheable;

/**
 * author: wzp
 * date: 2019/9/29
 */
@RestController
@RefreshScope
@Api("测试类")
public class TestController {

    @Value("${test.text}")
    private String text;
    @RequestMapping("test")
    @ApiOperation("测试方法")
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
            @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
    })
    @Cacheable(value="users", key="#mobile")
    public String test(@RequestBody Test test, String mobile){
        System.out.println(test);
        return String.valueOf(test);
    }
}
