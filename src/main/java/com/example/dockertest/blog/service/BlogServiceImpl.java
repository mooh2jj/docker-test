package com.example.dockertest.blog.service;

import com.example.dockertest.blog.dto.request.BlogCreateRequest;
import com.example.dockertest.blog.dto.request.BlogUpdateRequest;
import com.example.dockertest.blog.entity.Blog;
import com.example.dockertest.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Blog getBlog(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(RuntimeException::new);
    }

    @Override
    public void create(BlogCreateRequest request) {
        blogRepository.save(Blog.of(request));
    }

    @Override
    public void update(Long blogId, BlogUpdateRequest request) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(RuntimeException::new);
        blog.update(request);
    }

    @Override
    public void delete(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}
