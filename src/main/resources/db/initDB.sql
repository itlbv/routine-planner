DROP TABLE IF EXISTS routines;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
  id    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name  VARCHAR NOT NULL,
  email VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE routines
(
  id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id INTEGER NOT NULL,
  name    VARCHAR NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
