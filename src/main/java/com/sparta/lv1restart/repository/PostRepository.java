package com.sparta.lv1restart.repository;

import com.sparta.lv1restart.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {//jpa가 관리하는 엔티티, 엔티티의 프라이머리 타입 id 키값
    List<Post> findAllByOrderByModifiedAtDesc();
    //처음에 List<PostResponseDto> getPosts에서 빨강글씨로 생성하면 Collection<Object> 타입으로 생성된다. 이건 뭘까?
    //그리고 Collection<Object>타입일땐 map(PostResponseDto::new)부분에서 빨간지렁이 나온다.
}
