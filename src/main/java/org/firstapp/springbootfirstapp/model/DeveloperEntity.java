package org.firstapp.springbootfirstapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class DeveloperEntity {
    private String devId;
    private String name;
    private String email;
    private List<String> techStack;

}
