package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
        object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());
        super.update(object.getProjectCode(),object);

    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void delete(ProjectDTO object) {
        super.delete(object);
    }

    @Override
    public void complete(ProjectDTO project) {
        findById(project.getProjectCode()).setProjectStatus(Status.COMPLETE);
        findById(project.getProjectCode()).setEndDate(LocalDate.now());
    }

//    @Override
//    public List<ProjectDTO> managerProjects() {
//        return findAll().stream().filter(project->project.getAssignedManager().equals() )
//
//    }
}
