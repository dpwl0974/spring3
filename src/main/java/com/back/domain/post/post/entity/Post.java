package com.back.domain.post.post.entity;

import com.back.domain.post.comment.entity.Comment;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
public class Post extends BaseEntity {
    private String title;
    private String content;

    // mappedBy -> 외래키 줘야할 진짜는 post다 알려줌
    // cascade -> 부모 추가되거나 삭제되면 자식도 같이 (트랜잭셔널 안에서만 작용)
    // fetch.Lazy -> 필요한 순간에 나중에
    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Comment addComment(String content) {

        // this = post (부모)
        // post와 comment는 함께이므로 추가
        Comment comment = new Comment(content, this);
        this.comments.add(comment);

        return comment;
    }

    public void deleteComment(Long commentId) {
        comments.stream()
                .filter(c -> c.getId().equals(commentId))
                .findFirst()
                .ifPresent(comments::remove);
    }
}