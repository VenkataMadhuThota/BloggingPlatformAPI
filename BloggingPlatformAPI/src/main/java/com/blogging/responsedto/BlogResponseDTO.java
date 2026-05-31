package com.blogging.responsedto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class BlogResponseDTO 
{
    private Long id;
    private String titleName;
    private String content;
    private String categoryName;
    private List<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}