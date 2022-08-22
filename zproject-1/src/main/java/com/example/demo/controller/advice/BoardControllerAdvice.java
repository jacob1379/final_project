package com.example.demo.controller.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BoardControllerAdvice {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationException() {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("내용이 누락되었습니다");
	}
}
