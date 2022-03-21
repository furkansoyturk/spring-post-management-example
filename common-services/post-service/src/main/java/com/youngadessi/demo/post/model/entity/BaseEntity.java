package com.youngadessi.demo.post.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BaseEntity {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false)
    //private Long id;

    //@Column(name = "created_by")
    private Long createdBy;

    //@Column(name = "created_date_time")
    private String createdDateTime;

    //@Column(name = "updated_by")
    private Long updatedBy;

    //@Column(name = " updated_date_time")
    private String updatedDateTime;

}
