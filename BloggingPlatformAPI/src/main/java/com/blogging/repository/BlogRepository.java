package com.blogging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogging.entity.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> 
{

    List<BlogEntity> findByCategoryNameIgnoreCase(String categoryName);

    List<BlogEntity> findByTitleNameContainingIgnoreCase(String keyword);

    boolean existsByTitleNameIgnoreCase(String titleName);
}