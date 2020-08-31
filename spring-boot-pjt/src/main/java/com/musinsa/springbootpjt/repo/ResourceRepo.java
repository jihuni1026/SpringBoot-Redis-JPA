package com.musinsa.springbootpjt.repo;

import java.util.Optional;

import com.musinsa.springbootpjt.entity.ResourceEntity;

import org.springframework.data.repository.CrudRepository;

/**
 * Redis Repository interface.
 * @author kjh
 * @version 1.0
 */
public interface ResourceRepo extends CrudRepository<ResourceEntity, String> {
    Optional<ResourceEntity> findByOriginalurl(String originalurl);
    Optional<ResourceEntity> findByShorteningurl(String shorteningurl);
}