package com.hehe.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class TestEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    public void changeNameAndAge(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
