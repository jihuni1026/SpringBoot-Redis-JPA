package com.musinsa.springbootpjt.controller;

import java.util.Optional;

import com.musinsa.springbootpjt.entity.ResourceEntity;
import com.musinsa.springbootpjt.repo.ResourceRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Redirection Controller.
 * @author kjh
 * @version 1.0
 */
@Controller
public class RedirectionController {
    
    @Autowired
    ResourceRepo resourceRepo;

    @GetMapping("/{shorteningurl}")
    public String HandleRedirect(@PathVariable(value = "shorteningurl", required = true) String shorteningurl) {
        String returnUrl = "redirect:";

        Optional<ResourceEntity> result = resourceRepo.findByShorteningurl(shorteningurl);
        if (result.isPresent()) {
            String originalurl = result.get().getOriginalurl();
            returnUrl += originalurl;
        } else {
            returnUrl += "/error";
        }

        return returnUrl;
    }

}