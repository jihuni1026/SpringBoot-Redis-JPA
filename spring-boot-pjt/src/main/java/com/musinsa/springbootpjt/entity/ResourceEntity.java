package com.musinsa.springbootpjt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Resource Entity.
 * @author kjh
 * @version 1.0
 */
@Getter
@Setter
@RedisHash("resourceEntity")
public class ResourceEntity {
 
    @Id
    private String id;
    @Indexed
    private String originalurl;
    @Indexed
    private String shorteningurl;
    private int count;
    // private LocalDateTime refreshTime;
    
    @Builder
    public ResourceEntity(String id, String originalurl, String shorteningurl, int count) {
        this.id = id;
        this.originalurl = originalurl;
        this.shorteningurl = shorteningurl;
        this.count = count;
    }
    
}