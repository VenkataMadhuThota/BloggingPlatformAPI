package com.blogging.service;

import java.util.List;

import com.blogging.requestdto.BlogRequestDTO;
import com.blogging.responsedto.BlogResponseDTO;

public interface BlogService 
{
    BlogResponseDTO createBlog(BlogRequestDTO dto);

    List<BlogResponseDTO> getAllBlogs();

    BlogResponseDTO getBlog(Long id);

    BlogResponseDTO updateBlog(Long id, BlogRequestDTO dto);

    void deleteBlog(Long id);

    List<BlogResponseDTO> getBlogsByCategory(String categoryName);

    List<BlogResponseDTO> searchBlogs(String keyword);
}