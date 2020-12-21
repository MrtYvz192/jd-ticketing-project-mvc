package com.cybertek.controller;


import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;


    @GetMapping("/create")
    public String projectCreate(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project){
        project.setProjectStatus(Status.OPEN);
        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectCode){
        projectService.deleteById(projectCode);


        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectCode){
        //projectService.findBYId(projectCode).setProjectStatus(Status.COMPLETE);
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String editProject(@PathVariable("projectcode") String projectCode, Model model){

        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "project/update";
    }

    @PostMapping("/update/{projectcode}")
    public String updateProject(@PathVariable("projectcode") String projectcode, ProjectDTO project){

        //project.setProjectStatus(projectService.findById(projectcode).getProjectStatus()); ==> can also be used in order not to lose Status data
        projectService.update(project);

        return "redirect:/project/create";
    }

    @GetMapping("/manager/complete")
    public String getProjectsByManager(Model model){

       UserDTO manager = userService.findById("john@cybertek.com");
       List<ProjectDTO> projects = getCountedListOfProjectDTO(manager);
       model.addAttribute("projects",projects);

        return "/manager/project-status";
    }

     List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager){

        List<ProjectDTO> list = projectService.findAll().
                stream().
                filter(project->project.getAssignedManager().equals(manager)).
                map(x->{
                    List<TaskDTO> tasklist = taskService.findTasksByManager(manager);
                    int completeCount = (int) tasklist.stream().filter(t-> t.getProject().equals(x) && t.getTaskStatus() == Status.COMPLETE).count();
                    int incompleteCount = (int)tasklist.stream().filter(t-> t.getProject().equals(x) && t.getTaskStatus() != Status.COMPLETE).count();

//                    return new ProjectDTO(x.getProjectName(),x.getProjectCode(),userService.findById(x.getAssignedManager().
//                            getUserName()),x.getStartDate(),x.getEndDate(),x.getProjectDetail(),x.getProjectStatus(),
//                            completeCount,incompleteCount);

                    x.setUnfinishedTaskCount(incompleteCount);
                    x.setCompleteTaskCount(completeCount);
                    return  x;
                }).collect(Collectors.toList());

        return list;
    }


}
