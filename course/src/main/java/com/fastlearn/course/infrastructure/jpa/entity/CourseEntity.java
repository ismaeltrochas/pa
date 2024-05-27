package com.fastlearn.course.infrastructure.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  private String owner;
  private Double price;
  @Column(columnDefinition = "text")
  private String imgUrl;

}
