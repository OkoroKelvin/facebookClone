package data.repository;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class BookShelf<T> implements Database<T>{
   private  List<T> store = new ArrayList<>();

    @Override
    public void save(T t) {

    }

    @SafeVarargs
    public final void save(T... t) {
        store.addAll(Arrays.asList(t));
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<T> store() {
        return null;
    }

    public List<T> books() {
        return store;
    }
}
