package blobsMine.repository;

import java.util.Map;

public interface Repository <T> {

    void add(T blob);

    T findByName(String name);

    Map<String,T> findAll();
}
