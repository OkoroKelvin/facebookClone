package data.repository;

import data.model.User;

import java.util.List;

public interface Database<T>{
    void save(T t);
    int size();
    List<T> store();

}
