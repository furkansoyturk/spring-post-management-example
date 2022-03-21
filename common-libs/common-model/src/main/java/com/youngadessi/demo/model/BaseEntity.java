package com.youngadessi.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;

    @CreationTimestamp
    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;

    @LastModifiedBy
    @Column(name = "updated_by")
    private Long updatedBy;

    @UpdateTimestamp
    @Column(name = " updated_date_time")
    private LocalDateTime updatedDateTime;

    @Version
    @Column(name = "version")
    private  Integer version=0;
}