DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employee;

CREATE TABLE account (
  id       INTEGER PRIMARY KEY IDENTITY,
  name     VARCHAR(255),
  volume   DOUBLE,
  owner_id INTEGER,

  CONSTRAINT acc_field_notnull check (coalesce(id, name, volume, owner_id) is not null)
);
CREATE TABLE company (
  id    INTEGER PRIMARY KEY IDENTITY,
  title VARCHAR(255),

  CONSTRAINT comp_field_notnull check (coalesce(id, title) is not null)
);
CREATE TABLE owner (
  id          INTEGER PRIMARY KEY IDENTITY,
  first_name  VARCHAR(255),
  second_name VARCHAR(255),
  company_id  INTEGER,

  CONSTRAINT owner_field_notnull check (coalesce(id, first_name, second_name, company_id) is not null)
);