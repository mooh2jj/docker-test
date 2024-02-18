package com.example.dockertest.blog.service;

import com.example.dockertest.blog.dto.request.BlogCreateRequest;
import com.example.dockertest.blog.dto.request.BlogUpdateRequest;
import com.example.dockertest.blog.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getBlogs();

    Blog getBlog(Long blogId);

    void create(BlogCreateRequest request);

    void update(Long blogId, BlogUpdateRequest request);

    void delete(Long blogId);
}
