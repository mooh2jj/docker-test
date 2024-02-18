package com.example.dockertest.todo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
@ToString
public class PageResponse<E> {

    private List<E> dtoList;
    private List<Integer> pageNumList;

    private PageRequest pageRequest;

    private boolean prev, next;

    private int totalCount, prevPage, nextPage, totalPage, current;

    public PageResponse(List<E> dtoList, PageRequest pageRequest, long total) {
        this.dtoList = dtoList;
        this.pageRequest = pageRequest;
        this.totalCount = (int) total;

        // 끝페이지 end
        int end = (int) (Math.ceil(pageRequest.getPage() / 10.0)) * 10;

        int start = end - 9;

        // 진짜 마지막
        int last = (int) (Math.ceil(totalCount / (double) pageRequest.getSize()));

        end = end > last ? last : end;
        this.prev = start > 1;
        this.next = totalCount > end * pageRequest.getSize();

        this.pageNumList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

        this.prevPage = prev ? start - 1 : 0;
        this.nextPage = next ? end + 1 : 0;

    }

}
