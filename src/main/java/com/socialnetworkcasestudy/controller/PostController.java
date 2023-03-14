package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.PostCreationDto;
import com.socialnetworkcasestudy.dto.PostDto;
import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.repository.UserPostRepository;
import com.socialnetworkcasestudy.service.FriendService;
import com.socialnetworkcasestudy.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*")
public class PostController {
    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private FriendService friendService;

    @GetMapping("/{id}")
    public List<PostDto> feed(@PathVariable Long id){
        return postService.findAllByUser_Id(id);
    }
    @PostMapping
    public ResponseEntity<PostCreationDto> postStatus(@RequestBody PostCreationDto post
//            ,@RequestParam MultipartFile upImg
    ) {
//        String nameFile=  upImg.getOriginalFilename();

        try {
//            FileCopyUtils.copy(upImg.getBytes(),new File("C:\\Users\\Admin\\Desktop\\m6Fe2\\src\\assets\\images\\"+nameFile));
//            post.setImg("/images/"+nameFile);
            postService.createPost(post);
            return new ResponseEntity<>(post, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(post,HttpStatus.CONFLICT);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }


    @GetMapping("/findById/{id}")
    public Post findById(@PathVariable Long id){
        return postService.findById(id);
    }

//    @PutMapping("/delete/{id}")
//    public Post delete(@PathVariable long id){
//        Post post = postService.findById(id);
//
//        post.setPostStatus(PostStatus.Delete);
//        return postService.save(post);
//    }
}
