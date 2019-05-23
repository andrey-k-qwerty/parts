CREATE DATABASE IF NOT EXISTS test
    COLLATE utf8_general_ci;

USE test;

DROP TABLE IF EXISTS part;

CREATE TABLE part
(
    id          INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title       VARCHAR(50)         NULL,
    need        BIT                 NOT NULL DEFAULT FALSE,
    count       int(5)                       DEFAULT 0,
    description varchar(150)        NULL

)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

insert into part(title, need, count, description)
values ('материнская плата' ,true,10,'')
      ,('звуковая карта' ,false,4,'')
      ,('процессор' ,true,5,'')
      ,('подсветка корпуса' ,false,15,'')
      ,('HDD диск' ,false,6,'')
      ,('корпус' ,true,25,'')
      ,('память' ,true,14,'')
      ,('SSD диск' ,true,8,'')
      ,('видеокарта' ,false,7,'')
      ,('клавиатура' ,false,18,'')
      ,('мышь' ,false,18,'')
      ,('монитор' ,false,9,'')
      ,('принтер' ,false,3,'')
      ,('сетевая карта' ,false,4,'')
      ,('ИБП' ,false,9,'')
      ,('роутер' ,false,5,'')
      ,('маршрутизатор' ,false,5,'')
      ,('блок питания' ,true,15,'')
      ,('вентилятор CPU' ,true,15,'')
      ,('акустическая система' ,false,10,'')
      ,('оптический привод' ,false,6,'')

