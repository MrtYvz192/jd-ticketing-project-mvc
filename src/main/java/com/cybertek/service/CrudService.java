package com.cybertek.service;

import com.cybertek.dto.UserDTO;

import java.util.List;

public interface CrudService <T,ID>{

    T save(T object);
    T findBYID(ID id);
    List<T> findAll();
    void delete(T object);
    void deleteBy(ID id);
}
