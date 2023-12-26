package com.example.mvcuser.domain.entity;

import com.example.mvcuser.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password; // TODO hash 암호화
    private String name;
    private String grade;
    private int orderCount;

    @Builder
    public User(Long id, String email, String password, String name, String grade, int orderCount) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.orderCount = orderCount;
    }
}
