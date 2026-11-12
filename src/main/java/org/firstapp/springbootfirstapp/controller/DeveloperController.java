package org.firstapp.springbootfirstapp.controller;

import lombok.RequiredArgsConstructor;
import org.firstapp.springbootfirstapp.model.DeveloperEntity;
import org.firstapp.springbootfirstapp.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping
    public ResponseEntity<DeveloperEntity> createDeveloper(@RequestBody DeveloperEntity developer) {
        DeveloperEntity saved = developerService.saveDeveloper(developer);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DeveloperEntity>> getAllDevelopers() {
        return ResponseEntity.ok(developerService.getAllDevelopers());
    }
}
