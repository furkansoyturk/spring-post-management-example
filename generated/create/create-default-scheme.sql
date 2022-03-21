create sequence post_schema.hibernate_sequence start 1 increment 1;

    create table post_schema.tbl_post (
       id int8 not null,
        created_by int8,
        created_date_time timestamp,
        updated_by int8,
        updated_date_time timestamp,
        version int4,
        content varchar(255),
        created_by_name varchar(255),
        primary key (id)
    );

    create table post_schema.tbl_post_comment (
       id int8 not null,
        created_by int8,
        created_date_time timestamp,
        updated_by int8,
        updated_date_time timestamp,
        version int4,
        balalal varchar(255),
        comment_date_time timestamp,
        comment_text varchar(255),
        created_by_name varchar(255),
        post_id int8,
        primary key (id)
    );

    create table post_schema.tbl_post_tags (
       post_id int8 not null,
        tag_id int8 not null
    );

    create table post_schema.tbl_tag (
       id int8 not null,
        created_by int8,
        created_date_time timestamp,
        updated_by int8,
        updated_date_time timestamp,
        version int4,
        tag_name varchar(255),
        primary key (id)
    );

    alter table if exists post_schema.tbl_post_comment 
       add constraint FKjxswaf946m3x8t5yp7k0123sb 
       foreign key (post_id) 
       references post_schema.tbl_post;

    alter table if exists post_schema.tbl_post_tags 
       add constraint FKmf3p1y5q5no81aia3eurjr3fd 
       foreign key (tag_id) 
       references post_schema.tbl_tag;

    alter table if exists post_schema.tbl_post_tags 
       add constraint FKecu6x1cyk70umt8jh1usi4bn5 
       foreign key (post_id) 
       references post_schema.tbl_post;
create sequence user_schema.hibernate_sequence start 1 increment 1;

    create table user_schema.tbl_user (
       id int8 not null,
        created_by int8,
        created_date_time timestamp,
        updated_by int8,
        updated_date_time timestamp,
        version int4,
        password varchar(255),
        username varchar(255),
        primary key (id)
    );
create sequence user_schema.hibernate_sequence start 1 increment 1;

    create table user_schema.tbl_user (
       id int8 not null,
        created_by int8,
        created_date_time timestamp,
        updated_by int8,
        updated_date_time timestamp,
        version int4,
        password varchar(255),
        username varchar(255),
        primary key (id)
    );
