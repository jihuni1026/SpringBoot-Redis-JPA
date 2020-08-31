package com.musinsa.springbootpjt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Redirection Controller.
 * @author kjh
 * @version 1.0
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    
    private static final String ERROR_PATH = "error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping("/error")
    public String HandleError() {
        return "error/error";
    }
}