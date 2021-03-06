package com.cybertek.implementation;

import com.cybertek.dto.UserDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.CrudService;

import java.util.*;

public abstract class AbstractMapService <T,ID> {

    protected Map<ID,T> map = new LinkedHashMap<>();

    T save(ID id,T object){
       map.put(id,object);
       return object;
    }

    List<T> findAll(){
        return new ArrayList<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry-> entry.getValue().equals(object));
    }

    void update(ID id,T object){

        //delete(object);
        save(id,object);
    }

}
