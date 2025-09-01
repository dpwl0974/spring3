package com.back.domain.post.post.entity;

import com.back.global.jpa.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class Post extends BaseEntity {
    private String title;
    private String content;
}