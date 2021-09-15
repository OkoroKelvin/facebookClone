package data.repository;

import data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase<T extends Storable> implements Database<T> {
    private final List<T> store = new ArrayList<>();

    private static UserDatabase<User> instance = null;

    public static UserDatabase<User> getInstance(){
        if (instance == null){
            instance = new UserDatabase<>();
        }
        return instance;
    }

    @Override
    public void save(T t) {
        store.add(t);
    }


    @Override
    public int size(){
        return store.size();
    }

    @Override
    public List<T> store(){
        return store;
    }

    public T findByEmail(String email){
        for (T t: store) {
            if (t.getEmail().equals(email)) {
                return t;
            }
        }
        return null;
    }

    public boolean existByEmail(String email) {
        boolean isValidUser = false;
        for (T t: store) {
            if (t.getEmail().equals(email)) {
                isValidUser = true;
            }
        }
        return isValidUser;
    }
}
