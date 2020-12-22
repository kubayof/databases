DROP TABLE IF EXISTS projects_technologies;
DROP TABLE IF EXISTS programmers_technologies;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS programmers;
DROP TABLE IF EXISTS technologies;
DROP TABLE IF EXISTS managers;

CREATE TABLE managers
(
    id         SERIAL primary key,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL
);

CREATE TABLE projects
(
    id      SERIAL primary key,
    name    VARCHAR(30) NOT NULL,
    manager INTEGER UNIQUE,
    check (length(name) >= 5),
    foreign key (manager) references managers (id) ON DELETE CASCADE
);

CREATE TABLE technologies
(
    id   serial primary key,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE projects_technologies
(
    project_id    INT,
    technology_id INT,
    primary key (project_id, technology_id),
    foreign key (project_id) references projects (id),
    foreign key (technology_id) references technologies (id) ON DELETE CASCADE
);

CREATE TABLE programmers
(
    id         SERIAL primary key,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL,
    manager    INT,
    foreign key (manager) references managers (id) ON DELETE CASCADE
);

CREATE TABLE programmers_technologies
(
    programmer_id INT,
    technology_id INT,
    primary key (programmer_id, technology_id),
    foreign key (programmer_id) references programmers (id) ON DELETE CASCADE,
    foreign key (technology_id) references technologies (id) ON DELETE CASCADE
);

INSERT INTO managers(first_name, last_name)
VALUES ('Jeff', 'Klinton'),
       ('Ren', 'Lee');

INSERT INTO projects(name, manager)
VALUES ('Interpreter for c++', 1),
       ('Python compiler for jvm', 2);

INSERT INTO technologies(name)
VALUES ('ANTLR parser generator'),
       ('Java ASM'),
       ('C language'),
       ('C++ language'),
       ('Java language');

INSERT INTO projects_technologies(project_id, technology_id)
VALUES (1, 1),
       (1, 4),
       (2, 1),
       (2, 2),
       (2, 3);

INSERT INTO programmers(first_name, last_name, manager)
VALUES ('Rob', 'Benton', 1),
       ('Larry', 'Olsen', 1),
       ('Tom', 'Lawton', 2),
       ('Sam', 'Lee', 2);

INSERT INTO programmers_technologies(programmer_id, technology_id)
VALUES (1, 3),
       (1, 4),
       (2, 3),
       (2, 4),
       (3, 1),
       (3, 2),
       (3, 3),
       (4, 1),
       (4, 3);

