create
database mmd;

drop table user
create table user
(
    id       int auto_increment primary key,
    username varchar(255) null,
    password varchar(255) null,
    email    varchar(255) null,
    created  date null,
    phone    varchar(255) null
) charset = utf8;

drop table traffic
create table traffic
(
    id      int auto_increment primary key,
    root_no varchar(255) null,
    year    long,
    xxhc    long,
    zxhc    long,
    dxhc    long,
    tdhc    long,
    jzxc    long,
    zxkc    long,
    dkc     long
) charset = utf8;