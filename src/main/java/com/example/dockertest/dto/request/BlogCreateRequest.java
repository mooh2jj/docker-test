package com.example.dockertest.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BlogCreateRequest {

    private String title;

    private String content;

}
