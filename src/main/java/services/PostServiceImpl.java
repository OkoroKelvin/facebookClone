package services;

import data.dto.PostDto;
import data.model.Post;
import data.model.User;
import data.repository.PostDatabase;
import data.repository.UserDatabase;
import exceptions.unAuthenticatedUser;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class PostServiceImpl implements PostService{

    private final PostDatabase<Post> postDatabase = PostDatabase.getInstance();
    private final UserDatabase<User> userDatabase = UserDatabase.getInstance();

    @Override
    public void save(PostDto postDto, String userEmail) {
        User user = userDatabase.findByEmail(userEmail);
        if (user == null){
            throw new NullPointerException("User not with email not found");
        }
        if(postDto == null){
            throw new NullPointerException("Post does not exist");
        }
        Post post = PostDto.unpackDto(postDto);
        user.getPostIds().add(post.getPostId());
        post.setUserId(user.getEmail());
        postDatabase.save(post);
    }

    public List<Post> viewAllPost(String userEmail) throws unAuthenticatedUser {
        User user = userDatabase.findByEmail(userEmail);
        if (user == null) throw new unAuthenticatedUser(format("User with email %s is not valid", userEmail));
        List<String> postIds = user.getPostIds();
        List<Post> userPosts = new ArrayList<>();
        postIds.forEach(postId -> userPosts.add(postDatabase.findById(postId)));
        return userPosts;
    }
}
