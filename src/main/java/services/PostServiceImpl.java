package services;

import data.dto.PostDto;
import data.model.Post;
import data.repository.PostDatabase;

public class PostServiceImpl implements PostService{

    private final PostDatabase<Post> postDatabase = PostDatabase.getInstance();

    @Override
    public void save(PostDto postDto) {
        if(postDto == null){
            throw new NullPointerException("Post does not exist");
        }
        Post post = PostDto.unpackDto(postDto);
        postDatabase.save(post);
    }
}
