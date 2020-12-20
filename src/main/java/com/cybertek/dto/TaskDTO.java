package com.cybertek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private ProjectDTO project;
    private UserDTO employee;
    private String subject;
    private String detail;

}
