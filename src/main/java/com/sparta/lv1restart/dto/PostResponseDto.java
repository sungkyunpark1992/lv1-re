package com.sparta.lv1restart.dto;

import com.sparta.lv1restart.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String author;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();//얘는 Timestamped클래스를 만드니깐 활성화가 되었다.
        this.modifiedAt = post.getModifiedAt();//얘는 Timestamped클래스를 만드니깐 활성화가 되었다.
    }
}
