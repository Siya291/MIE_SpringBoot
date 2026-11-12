package org.firstapp.springbootfirstapp.service;

import lombok.RequiredArgsConstructor;
import org.firstapp.springbootfirstapp.model.DeveloperEntity;
import org.firstapp.springbootfirstapp.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperEntity saveDeveloper(DeveloperEntity developer) {
        return developerRepository.save(developer);
    }

    public List<DeveloperEntity> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public DeveloperEntity getDeveloperById(String id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Developer not found with id: " + id));
    }
}
