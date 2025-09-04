package com.back.domain.post.comment.entity;

import com.back.domain.post.post.entity.Post;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor // 내가 사용 용도
@NoArgsConstructor // JPA가 사용 용도
public class Comment extends BaseEntity {

    private String content;

    @ManyToOne //Many -> 외래키 부여
    private Post post;
}
