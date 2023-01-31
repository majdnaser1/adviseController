package com.example.springbootday7.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "title should be not Empty")
//    @Column(columnDefinition = "varchar(20) not null unique")
    private String title;
    @NotEmpty(message = "body should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String body;


}
