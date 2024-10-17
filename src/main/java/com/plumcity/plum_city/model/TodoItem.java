package com.plumcity.plum_city.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "todo_items") // Map the class to the database table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor // Lombok annotations to generate constructors, getters, and setters
public class TodoItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
  private Integer id;

  @Column(nullable = false) // Title cannot be null
  private String title;

  @Column(columnDefinition = "TEXT") // For longer descriptions
  private String description;

  @Column(nullable = false, length = 50) // Status cannot be null
  private String status;

  @Column(name = "created_at", updatable = false) // Do not update this field
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Override
  public final boolean equals(Object o) {
    // Check reference equality first
    if (this == o) {
      return true;
    }

    // Check if 'o' is null or not an instance of TodoItemService
    if (!(o instanceof TodoItem that)) {
      return false;
    }

    // Handle HibernateProxy for both 'this' and 'o'
    Class<?> oEffectiveClass = (o instanceof HibernateProxy hibernateProxy)
        ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
        : that.getClass(); // Use 'that' instead of 'o' to avoid re-evaluating the type

    Class<?> thisEffectiveClass = (this instanceof HibernateProxy hibernateProxyThis)
        ? hibernateProxyThis.getHibernateLazyInitializer().getPersistentClass()
        : this.getClass();

    // Compare the effective classes
    if (!Objects.equals(thisEffectiveClass, oEffectiveClass)) {
      return false;
    }

    // Compare the IDs
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy hibernateProxy ? hibernateProxy.getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
  }
}
