package com.musinsa.springbootpjt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.musinsa.springbootpjt.entity.ResourceEntity;
import com.musinsa.springbootpjt.repo.ResourceRepo;
import com.musinsa.springbootpjt.utils.EndecryptionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Index Controller.
 * 
 * @author kjh
 * @version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    ResourceRepo resourceRepo;

    @Autowired
    EndecryptionUtil endecryptionUtil;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/shortening")
    public @ResponseBody Map<String, String> HandleShortening(@RequestParam(value = "originalurl", required = true) String originalurl) {
        Map<String, String> resultMap = new HashMap<String, String>();

        Optional<ResourceEntity> result = resourceRepo.findByOriginalurl(originalurl);
        if (result.isPresent()) {
            result.get().setCount(result.get().getCount() + 1);
            resourceRepo.save(result.get());

            resultMap.put("shorteningurl", result.get().getShorteningurl());
        } else {
            int resourceEntityId = (int) resourceRepo.count() + 1;
            String shorteningurl = endecryptionUtil.encode(resourceEntityId + 1000000);

            ResourceEntity resourceEntity = ResourceEntity.builder()
            .id(Long.toString(resourceEntityId))
            .originalurl(originalurl)
            .shorteningurl(shorteningurl)
            .count(1)
            .build();

            resourceRepo.save(resourceEntity);
            resultMap.put("shorteningurl", shorteningurl);
        }

        return resultMap;
    }
    
}