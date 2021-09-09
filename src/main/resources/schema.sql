drop table if exists employee;
drop sequence if exists user_ids;

create sequence user_ids;
create table employee (
    id integer primary key default nextval('user_ids'),
    first_name char(100),
    last_name char(100),
    job_title char(100),
    gender char(20),
    department_id integer,
    dateOfBirth date
    );
