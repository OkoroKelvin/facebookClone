package data.repository;

import data.model.Task;
import data.model.User;

import java.util.ArrayList;
import java.util.List;

public class TaskDatabase<T extends Storable> implements Database<T>{
    private final List<T> store = new ArrayList<>();

    private static TaskDatabase<Task> instance = null;

    public static TaskDatabase<Task> getInstance(){
        if (instance == null){
            instance = new TaskDatabase<>();
        }
        return instance;
    }

    @Override
    public void save(T t) {
        store.add(t);
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public List<T> store() {
        return store;
    }

    @Override
    public T findById(String id) {
        return null;
    }
}
