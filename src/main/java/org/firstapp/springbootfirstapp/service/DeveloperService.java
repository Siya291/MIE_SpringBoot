package org.firstapp.springbootfirstapp.service;

import lombok.RequiredArgsConstructor;
import org.firstapp.springbootfirstapp.model.DeveloperEntity;
import org.firstapp.springbootfirstapp.repository.DeveloperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void deleteDeveloperById(String id) {
        DeveloperEntity developer = getDeveloperById(id);
        developerRepository.delete(developer);
    }

    @Transactional
    public DeveloperEntity patchDeveloper(String id, DeveloperEntity detailToChange) {
        DeveloperEntity existingDev = getDeveloperById(id);

        if (detailToChange.getName() != null && !detailToChange.getName().isBlank()) {
            existingDev.setName(detailToChange.getName());
        }

        if (detailToChange.getEmail() != null && !detailToChange.getEmail().isBlank()) {
            existingDev.setEmail(detailToChange.getEmail());
        }

        if (detailToChange.getTechStack() != null) {
            existingDev.getTechStack().clear();
            existingDev.getTechStack().addAll(detailToChange.getTechStack());
        }

        return developerRepository.save(existingDev);
    }

}
