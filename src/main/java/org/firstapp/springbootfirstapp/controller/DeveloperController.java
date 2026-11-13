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

    @PostMapping("/addDeveloper")
    public ResponseEntity<DeveloperEntity> createDeveloper(@RequestBody DeveloperEntity developer) {
        DeveloperEntity saved = developerService.saveDeveloper(developer);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getAllDevelopers")
    public ResponseEntity<List<DeveloperEntity>> getAllDevelopers() {
        return ResponseEntity.ok(developerService.getAllDevelopers());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DeveloperEntity> getDeveloperById(@PathVariable String id) {
        DeveloperEntity developer = developerService.getDeveloperById(id);
        return ResponseEntity.ok(developer);
    }

    @DeleteMapping("/deleteByID/{id}")
    public String deleteDeveloperById(@PathVariable String id) {
        developerService.deleteDeveloperById(id);
        return "Developer deleted successfully with id: " + id;
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<DeveloperEntity> patchDeveloper(@PathVariable String id, @RequestBody DeveloperEntity partialDetails) {

        DeveloperEntity updatedDeveloper = developerService.patchDeveloper(id, partialDetails);
        return ResponseEntity.ok(updatedDeveloper);
    }
}
