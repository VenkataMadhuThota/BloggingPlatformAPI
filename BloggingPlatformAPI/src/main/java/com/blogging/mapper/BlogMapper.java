package com.blogging.mapper;

import org.springframework.stereotype.Component;

import com.blogging.entity.BlogEntity;
import com.blogging.requestdto.BlogRequestDTO;
import com.blogging.responsedto.BlogResponseDTO;

@Component
public class BlogMapper 
{

    public BlogResponseDTO toDto(BlogEntity blog) 
    {
        BlogResponseDTO dto = new BlogResponseDTO();
        dto.setId(blog.getId());
        dto.setTitleName(blog.getTitleName());
        dto.setContent(blog.getContent());
        dto.setCategoryName(blog.getCategoryName());
        dto.setTags(blog.getTags());
        dto.setCreatedAt(blog.getCreatedAt());
        dto.setUpdatedAt(blog.getUpdatedAt());
        return dto;
    }

    public BlogEntity toEntity(BlogRequestDTO dto) 
    {
        BlogEntity blog = new BlogEntity();
        blog.setTitleName(dto.getTitleName());
        blog.setContent(dto.getContent());
        blog.setCategoryName(dto.getCategoryName());
        blog.setTags(dto.getTags());
        return blog;
    }
}