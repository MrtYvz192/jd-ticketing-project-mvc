package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public ProjectDTO findBYId(String s) {
        return super.findById(s);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
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
}
