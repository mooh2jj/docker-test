package com.example.dockertest.todo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder // 상속시, 기본값을 설정해주는 어노테이션
public class PageRequestDto {

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    @Builder
    public PageRequestDto(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
