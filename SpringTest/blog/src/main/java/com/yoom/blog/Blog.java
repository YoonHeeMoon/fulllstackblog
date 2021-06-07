package com.yoom.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog{
    public String title;
    String Author;
    String body;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
}