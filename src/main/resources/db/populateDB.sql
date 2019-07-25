-- noinspection SqlWithoutWhere
DELETE
FROM users;
-- noinspection SqlWithoutWhere
DELETE
FROM routines;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users(name, email)
VALUES ('user1', 'email1'),
       ('user2', 'email2'),
       ('user3', 'email3');

INSERT INTO routines(name)
VALUES ('routine1'),
       ('routine2'),
       ('routine3');