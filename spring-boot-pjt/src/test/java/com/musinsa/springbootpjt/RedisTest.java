package com.musinsa.springbootpjt;

import java.util.Optional;

import com.musinsa.springbootpjt.entity.ResourceEntity;
import com.musinsa.springbootpjt.repo.ResourceRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Redis.
 * @author kjh
 * @version TEST
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private ResourceRepo resourceRepo;
 
    // @After
    // public void after_delete() throws Exception {
    //     resourceRepo.deleteAll();
    // }

    // Redis 저장 
    @Test
    public void testRedis_save() {
        // System.out.println("Redis Key Count : " + resourceRepo.count());
        ResourceEntity resourceEntity = ResourceEntity.builder()
            .id(Long.toString((int) resourceRepo.count() + 1))
            .originalurl("www.naver.com")
            .shorteningurl("ABCD")
            .count(1)
            .build();

        resourceRepo.save(resourceEntity);

        Optional<ResourceEntity> result = resourceRepo.findById(resourceEntity.getId());
        assertEquals("www.naver.com", result.get().getOriginalurl());
        assertEquals("ABCD", result.get().getShorteningurl());
    }

    // Redis 조회
    @Test
    public void testRedis_find() {
        if (resourceRepo.existsById("1")) {
            Optional<ResourceEntity> result = resourceRepo.findById("1");
            System.out.println(result.get().getOriginalurl());
            System.out.println(result.get().getShorteningurl());
        }

        Optional<ResourceEntity> result1 = resourceRepo.findByOriginalurl("www.naver.com");
        System.out.println("result1 : " + result1.isPresent());
        Optional<ResourceEntity> result2 = resourceRepo.findByShorteningurl("ABCD");
        System.out.println("result2 : " + result2.isPresent());

        assertTrue(resourceRepo.existsById("1"));
    }

    // Redis 수정
    @Test
    public void testRedis_modify() {
        if (resourceRepo.existsById("1")) {
            ResourceEntity result = resourceRepo.findById("1").get();
            result.setCount(result.getCount() + 1);
            resourceRepo.save(result);
        }
    }

    // Redis 삭제
    @Test
    public void testRedis_delete() {
        if (resourceRepo.existsById("1")) {
            resourceRepo.deleteById("1");
        }
        System.out.println("Redis Count : " + resourceRepo.count());
    }
}