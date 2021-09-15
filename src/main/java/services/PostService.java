package services;

import data.dto.PostDto;
import data.model.Post;
import exceptions.unAuthenticatedUser;

import java.util.List;

public interface PostService {
    void save(PostDto postDto);
    List<Post> viewPost(String userEmail) throws unAuthenticatedUser;
}
