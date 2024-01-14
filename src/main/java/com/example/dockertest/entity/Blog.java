package com.example.dockertest.entity;

import com.example.dockertest.dto.request.BlogCreateRequest;
import com.example.dockertest.dto.request.BlogUpdateRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blog")
@ToString
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;


    @Builder
    public Blog(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static Blog of(BlogCreateRequest request) {
        return Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public void update(BlogUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
