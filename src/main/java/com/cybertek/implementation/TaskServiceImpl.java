package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getId(),object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO object) {
        TaskDTO task = findById(object.getId());
        object.setAssignedDate(task.getAssignedDate());
        object.setTaskStatus(task.getTaskStatus());
        super.update(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {

        return super.findAll().stream().filter(task-> task.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());

    }
}
