-- noinspection SqlWithoutWhere

DELETE
FROM routines;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO routines(name)
VALUES ('name1'),
       ('name2'),
       ('name3');