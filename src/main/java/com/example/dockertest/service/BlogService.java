package com.example.dockertest.service;

import com.example.dockertest.dto.request.BlogCreateRequest;
import com.example.dockertest.dto.request.BlogUpdateRequest;
import com.example.dockertest.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getBlogs();

    Blog getBlog(Long blogId);

    void create(BlogCreateRequest request);

    void update(Long blogId, BlogUpdateRequest request);

    void delete(Long blogId);
}
