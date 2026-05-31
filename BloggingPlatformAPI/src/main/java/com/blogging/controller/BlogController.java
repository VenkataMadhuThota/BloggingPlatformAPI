package com.blogging.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.requestdto.BlogRequestDTO;
import com.blogging.responsedto.BlogResponseDTO;
import com.blogging.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/blog")
@Tag(name = "Blog API", description = "CRUD operations for blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    @Operation(summary = "Create a new blog")
    public ResponseEntity<BlogResponseDTO> createBlog(@Valid @RequestBody BlogRequestDTO dto) 
    {
        return new ResponseEntity<>(blogService.createBlog(dto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all blogs")
    public ResponseEntity<List<BlogResponseDTO>> getAllBlogs() 
    {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get blog by ID")
    public ResponseEntity<BlogResponseDTO> getBlog(@PathVariable Long id) 
    {
        return ResponseEntity.ok(blogService.getBlog(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a blog")
    public ResponseEntity<BlogResponseDTO> updateBlog(@PathVariable Long id,@Valid @RequestBody BlogRequestDTO dto) 
    {
        return ResponseEntity.ok(blogService.updateBlog(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a blog")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) 
    {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully");
    }

    @GetMapping("/category/{categoryName}")
    @Operation(summary = "Get blogs by category")
    public ResponseEntity<List<BlogResponseDTO>> getBlogsByCategory(@PathVariable String categoryName) 
    {
        return ResponseEntity.ok(blogService.getBlogsByCategory(categoryName));
    }

    @GetMapping("/search")
    @Operation(summary = "Search blogs by title keyword")
    public ResponseEntity<List<BlogResponseDTO>> searchBlogs(@RequestParam String keyword) 
    {
        return ResponseEntity.ok(blogService.searchBlogs(keyword));
    }
}