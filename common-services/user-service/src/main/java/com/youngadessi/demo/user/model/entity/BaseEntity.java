package com.youngadessi.demo.user.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@Column(name = "created_by")
    private Long createdBy;

    //@Column(name = "created_date_time")
    private String createdDateTime;

    //@Column(name = "updated_by")
    private Long updatedBy;

    //@Column(name = " updated_date_time")
    private String updatedDateTime;

    //@Column(name = "version")
    private  Integer version;

}
