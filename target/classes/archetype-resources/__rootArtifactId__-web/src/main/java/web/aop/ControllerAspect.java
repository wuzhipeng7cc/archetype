#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ControllerAspect {
    @Around("execution(public * ${package}.web.controller.*.*Controller.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = AspectUtil.logAround(joinPoint);
        return o;
    }
}