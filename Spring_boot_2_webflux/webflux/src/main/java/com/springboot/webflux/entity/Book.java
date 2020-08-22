package com.springboot.webflux.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

// NOTE : Prefer this way to create entity classes

@Entity
@Table(name="book")
// This will be the name to table to store 'book' objects in db.
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @NotNull
    @Column(name = "book_id", nullable = false)
    // This will be the name of column to store 'id'
    // member field of book object in db table
    private String id;

    @Column(name = "book_name")
    // This will be the name of column to store 'name'
    // member field of book object in db table
    private String name;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    @LastModifiedDate
    private Date updatedAt;
}