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

INSERT INTO routines(user_id, name)
VALUES (100000, 'routine1_1'),
       (100000, 'routine2_1'),
       (100000, 'routine3_1'),
       (100001, 'routine1_2'),
       (100001, 'routine2_2'),
       (100001, 'routine3_2'),
       (100002, 'routine1_3'),
       (100002, 'routine2_3'),
       (100002, 'routine3_3');