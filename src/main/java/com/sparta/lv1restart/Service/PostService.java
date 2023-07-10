package com.sparta.lv1restart.Service;

import com.sparta.lv1restart.dto.PostRequestDto;
import com.sparta.lv1restart.dto.PostResponseDto;
import com.sparta.lv1restart.entity.Post;
import com.sparta.lv1restart.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {
        // RequestDto -> Entity
        Post post = new Post(requestDto);
        //DB저장
        Post savePost = postRepository.save(post);
        // Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto(savePost);
        return postResponseDto;
    }

    public List<PostResponseDto> getPosts() {
        //DB조회
        return postRepository.findAllByOrderByModifiedAtDesc().stream().map(PostResponseDto::new).toList();
    }

    public PostResponseDto getPostById(Long id, PostRequestDto requestDto) {
        //해당 메모가 DB에 존재하는지 확인
        Post post = findPost(id, requestDto);
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        //해당 메모가 DB에 존재하는지 확인
        Post post = findPost(id, requestDto);
        // DB수정
        post.update(requestDto);
        //Entity -> ResponseDto
        PostResponseDto responseDto = new PostResponseDto(post);
        return responseDto;
    }
    public Boolean deletePost(Long id, PostRequestDto requestDto) {
        //해당 메모가 DB에 존재하는지 확인
        Post post = findPost(id, requestDto);
        postRepository.delete(post);//Repository와 Entity의 차이점이 뭘까? Entity에서 직접삭제하지 않고 Repository의 메소드를 통해 삭제하네? 왜?
        return true;
    }
    private Post findPost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(()->//postRepository.findById(id)메소드를 찾아들어가면 boolean값을 반환하는데 어떻게 Post타입의 변수에 담길수 있는지?
                new IllegalArgumentException("선택한 글은 존재하지 않습니다."));
        if(!post.getPassword().equals(requestDto.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return post;
    }


}
