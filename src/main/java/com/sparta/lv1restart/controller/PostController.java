package com.sparta.lv1restart.controller;

import com.sparta.lv1restart.Service.PostService;
import com.sparta.lv1restart.dto.PostRequestDto;
import com.sparta.lv1restart.dto.PostResponseDto;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor//무슨역할인가? 무엇에 대한 생성자를 선언하지 않고싶다면 이 애노테이션을 추가 하는것?
@RequestMapping("/api")
public class PostController {
    private final PostService postService;//이 코드의 역할이 뭘 주입한다고?
    public PostController(PostService postService){//생성자이다. postService이녀석이 final로 고정되었기 때문에 값을 함부로 바꿀 수 없다. 그래서 생성자로 postService로 초기화 시켜주는 것.
        this.postService = postService;
    }//@RequiredArgsConstructor가 자동적으로 만들어주는애다.
    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){
        return postService.createPost(requestDto);
    }
    @GetMapping("/posts")//전체조회
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }
    @GetMapping("/post/{id}")//선택조회
    public PostResponseDto getPostById(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.getPostById(id, requestDto);
    }//컨트롤러의 메서드 이름과 서비스의 메서드 이름을 일치 시키면 협업할 때 좋은 코드가 된다.
    @PutMapping("/post/{id}")//게시글 수정
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.updatePost(id, requestDto);
    }
    @DeleteMapping("/post/{id}")
    public Boolean deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.deletePost(id, requestDto);
    }

}
