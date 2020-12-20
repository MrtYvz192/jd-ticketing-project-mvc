package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,UserDTO> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO object) {
        return null;
    }

    @Override
    public TaskDTO findById(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<TaskDTO> findAll() {
        return null;
    }

    @Override
    public void delete(TaskDTO object) {

    }

    @Override
    public void deleteById(UserDTO userDTO) {

    }

    @Override
    public void update(TaskDTO object) {

    }
}
