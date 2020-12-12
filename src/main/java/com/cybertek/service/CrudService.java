package com.cybertek.service;

import com.cybertek.dto.UserDTO;

import java.util.List;

public interface CrudService <T,ID>{

    T save(T user);
    T findBYID(ID id);
    List<T> findAll();
    void delete(T user);
    void deleteBy(ID id);
}
