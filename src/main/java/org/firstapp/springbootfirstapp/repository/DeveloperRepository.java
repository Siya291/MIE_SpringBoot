package org.firstapp.springbootfirstapp.repository;

import org.firstapp.springbootfirstapp.model.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperEntity, String> {
}
