package org.firstapp.springbootfirstapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "developers")
public class DeveloperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "full_name", nullable = false, length = 25)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 30)
    private String email;

    @ElementCollection
    @CollectionTable(name = "user_tech_stack", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "technology")
    private List<String> techStack;
}
