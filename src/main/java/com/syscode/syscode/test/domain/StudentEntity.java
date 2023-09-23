package com.syscode.syscode.test.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "students",
        uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;

    public StudentEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
