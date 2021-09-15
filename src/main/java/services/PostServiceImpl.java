package services;

import data.dto.PostDto;
import data.model.Post;
import data.model.User;
import data.repository.PostDatabase;
import data.repository.UserDatabase;
import exceptions.unAuthenticatedUser;

import java.util.List;

import static java.lang.String.format;

public class PostServiceImpl implements PostService{

    private final PostDatabase<Post> postDatabase = PostDatabase.getInstance();
    private final UserDatabase<User> userDatabase = UserDatabase.getInstance();

    @Override
    public void save(PostDto postDto) {
        if(postDto == null){
            throw new NullPointerException("Post does not exist");
        }
        Post post = PostDto.unpackDto(postDto);
        postDatabase.save(post);
    }

    public List<Post> viewPost(String userEmail) throws unAuthenticatedUser {
        boolean isValid = userDatabase.existByEmail(userEmail);
        if (!isValid) throw new unAuthenticatedUser(format("User with email %s is not valid", userEmail));
        return postDatabase.store();
    }
}
