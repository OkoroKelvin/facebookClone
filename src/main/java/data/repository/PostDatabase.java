package data.repository;

import data.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostDatabase <T> implements Database<T>{

    private final List<T> posts = new ArrayList<>();
    private static PostDatabase<Post> instance = null;

    public static PostDatabase<Post> getInstance() {
        if(instance == null){
            instance = new PostDatabase<>();
        }
        return instance;
    }


    @Override
    public void save(T t) {
        posts.add(t);
    }

    @Override
    public int size() {
        return posts.size();
    }

    @Override
    public List<T> store() {
        return posts;
    }
}
