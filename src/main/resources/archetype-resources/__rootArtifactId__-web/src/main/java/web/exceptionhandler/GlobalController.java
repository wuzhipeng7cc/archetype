#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.exceptionhandler;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.alibaba.fastjson.JSON;
import ${package}.common.dto.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: wzp
 * date: 2019/10/2
 */
@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class GlobalController {


    @ExceptionHandler({Exception.class})
    @ResponseBody
    public CommonResult handException(Exception e) throws Exception {
        log.error("抓到异常e:", e);
        CommonResult<Object> result = new CommonResult<>();
        result.setStatus(500);
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity handleBindGetException(ConstraintViolationException ex){
        log.error(   "单个参数校验异常",ex);
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        CommonResult<String> commonResult = new CommonResult<>();
        commonResult.setStatus(500);
        commonResult.setData(JSON.toJSONString(defaultMsg));
        return new ResponseEntity<>(commonResult,HttpStatus.BAD_REQUEST);
    }

}
