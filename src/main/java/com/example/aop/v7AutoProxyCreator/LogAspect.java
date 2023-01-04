package com.example.aop.v7AutoProxyCreator;

import com.example.aop.trace.LogTrace;
import com.example.aop.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {
    private final LogTrace logTrace;
    public LogAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Pointcut("execution(* com.example.aop.v7AutoProxyCreator..*(..))")
    private void p1(){}

//    @Around("execution(* com.example.aop.v7AutoProxyCreator..*(..))")
    @Around("p1()") //여러 포인트컷의 && || !연산 활용도 가능하다.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;
        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);
            Object result = joinPoint.proceed();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }


    /**
     * order 는 class 단위로만 적용 가능하다.
     * -> advisor 순서 적용 시키려면 클래스화 해야 한다.
     */
//    @Aspect
//    @Component
//    @Order(1)
//    public static class Tmp{
//
//        @Around("p1()")
//        public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
//            return joinPoint.proceed();
//        }
//    }

    /** @Aroung 분리 가능
     * -@Before
     * -@AfterReturning
     * -@AfterThrowing
     * -@After
     */


}
