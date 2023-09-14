package com.example.demo.model.blog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String content;

    private String title;

    private LocalDateTime publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private Set<BlogTags> blogTags; //add 2 thằng BlogTags



}
