
    alter table if exists post_schema.tbl_post_comment 
       drop constraint if exists FKjxswaf946m3x8t5yp7k0123sb;

    alter table if exists post_schema.tbl_post_tags 
       drop constraint if exists FKmf3p1y5q5no81aia3eurjr3fd;

    alter table if exists post_schema.tbl_post_tags 
       drop constraint if exists FKecu6x1cyk70umt8jh1usi4bn5;

    drop table if exists post_schema.tbl_post cascade;

    drop table if exists post_schema.tbl_post_comment cascade;

    drop table if exists post_schema.tbl_post_tags cascade;

    drop table if exists post_schema.tbl_tag cascade;

    drop sequence if exists post_schema.hibernate_sequence;

    drop table if exists user_schema.tbl_user cascade;

    drop sequence if exists user_schema.hibernate_sequence;

    drop table if exists user_schema.tbl_user cascade;

    drop sequence if exists user_schema.hibernate_sequence;
