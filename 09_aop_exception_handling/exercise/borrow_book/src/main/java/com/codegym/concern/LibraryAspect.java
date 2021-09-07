package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LibraryAspect {
    private int view = 0;

    @Pointcut("execution(* com.codegym.controller.LibraryController.borrowBook(..))")
    public void borrowBook() {
    }

    @AfterReturning("borrowBook()")
    public void afterBorrowBook(JoinPoint joinPoint) {
        System.err.println("Book has been rented - method called : " + joinPoint.getSignature().getName() + " - at : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.controller.LibraryController.giveBook(..))")
    public void giveBook() {
    }

    @AfterReturning("giveBook()")
    public void afterGiveBook(JoinPoint joinPoint) {
        System.err.println("Book has been returned - method called : " + joinPoint.getSignature().getName() + " - at : " + LocalDateTime.now());
    }


    @Pointcut("execution(* com.codegym.controller.LibraryController.*(..))")
    public void viewCount() {
    }

    @Before("viewCount()")
    public void count() {
        view += 1;
        System.err.println("Total views " + view );
    }
}
