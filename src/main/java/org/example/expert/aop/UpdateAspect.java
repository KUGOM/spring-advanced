package org.example.expert.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class UpdateAspect {

    private final HttpServletRequest httpServletRequest;

    public UpdateAspect(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Pointcut("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..)) || execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
    public void serviceLayer() {}

    @Before("serviceLayer()")
    public void updAccess(JoinPoint joinPoint) {
        String userId = httpServletRequest.getHeader("X-User-ID");
        String requestUrl = httpServletRequest.getRequestURL().toString();
        String timestamp = LocalDateTime.now().toString();

        log.info("Log - UserID: {}, Timestamp: {}, URL: {}", userId, timestamp, requestUrl);
    }
}
