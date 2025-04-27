package com.seon.workflow.domain.user;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    /*@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }*/

}
