package com.sparta.lv1restart.entity;

import com.sparta.lv1restart.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "blogpost")
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "password", nullable = false)
    private String password;

    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();

    }


    public void update(PostRequestDto requestDto) {
       this.title = requestDto.getTitle();
       this.author = requestDto.getAuthor();
       this.contents = requestDto.getContents();
       this.password = requestDto.getPassword();
    }
}
