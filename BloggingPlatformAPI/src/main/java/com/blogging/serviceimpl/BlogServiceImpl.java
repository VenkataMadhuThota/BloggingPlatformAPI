package com.blogging.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogging.entity.BlogEntity;
import com.blogging.exception.BlogNotFoundException;
import com.blogging.exception.DuplicateBlogTitleException;
import com.blogging.mapper.BlogMapper;
import com.blogging.repository.BlogRepository;
import com.blogging.requestdto.BlogRequestDTO;
import com.blogging.responsedto.BlogResponseDTO;
import com.blogging.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService 
{
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper) 
    {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public BlogResponseDTO createBlog(BlogRequestDTO dto) 
    {
        if (blogRepository.existsByTitleNameIgnoreCase(dto.getTitleName()))
            throw new DuplicateBlogTitleException("A blog with title '" + dto.getTitleName() + "' already exists.");

        BlogEntity blog = blogMapper.toEntity(dto);
        return blogMapper.toDto(blogRepository.save(blog));
    }

    @Override
    public List<BlogResponseDTO> getAllBlogs() 
    {
        return blogRepository.findAll()
                .stream()
                .map(blogMapper::toDto)
                .toList();
    }

    @Override
    public BlogResponseDTO getBlog(Long id) 
    {
        return blogMapper.toDto(findBlogById(id));
    }

    @Override
    public BlogResponseDTO updateBlog(Long id, BlogRequestDTO dto) 
    {
        BlogEntity blog = findBlogById(id);
        blog.setCategoryName(dto.getCategoryName());
        blog.setContent(dto.getContent());
        blog.setTags(dto.getTags());
        blog.setTitleName(dto.getTitleName());
        blogRepository.save(blog); 
        return blogMapper.toDto(blog);
    }

    @Override
    public void deleteBlog(Long id) 
    {
        blogRepository.delete(findBlogById(id));
    }

    @Override
    public List<BlogResponseDTO> getBlogsByCategory(String categoryName) 
    {
        return blogRepository.findByCategoryNameIgnoreCase(categoryName)
                .stream()
                .map(blogMapper::toDto)
                .toList();
    }

    @Override
    public List<BlogResponseDTO> searchBlogs(String keyword) 
    {
        return blogRepository.findByTitleNameContainingIgnoreCase(keyword)
                .stream()
                .map(blogMapper::toDto)
                .toList();
    }
 
    private BlogEntity findBlogById(Long id) 
    {
        return blogRepository.findById(id).orElseThrow(() -> new BlogNotFoundException("Blog not found with id: " + id));
    }
}