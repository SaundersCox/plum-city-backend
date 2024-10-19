package com.plumcity.plum_city.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "todo_items", schema = "dbo")
@Data
@RequiredArgsConstructor
public class TodoItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(length = 50)
  private String status;

  @Column(updatable = false)
  private LocalDateTime createdAt;

  @Column private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoItem todoItem = (TodoItem) o;
    return id != null && id.equals(todoItem.id);
  }

  @Override
  public final int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
