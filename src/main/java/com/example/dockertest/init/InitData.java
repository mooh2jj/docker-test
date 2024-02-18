package com.example.dockertest.init;

import com.example.dockertest.blog.dto.request.BlogCreateRequest;
import com.example.dockertest.blog.service.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData {

    @Bean
    public CommandLineRunner initDevData(BlogService blogService) {
        return args -> {
            if(blogService.getBlogs().size() > 0) {
                return;
            }
            blogService.create(new BlogCreateRequest("title1", "content1"));
            blogService.create(new BlogCreateRequest("title2", "content2"));
        };
    }
}
