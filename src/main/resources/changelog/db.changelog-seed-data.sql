CREATE TABLE students
(
    id    UUID         NOT NULL,
    name  varchar(500) NOT NULL,
    email varchar(500) NOT NULL,
    PRIMARY KEY (id)
);

----------- students index -----------
CREATE INDEX idx_student_id
    ON students (id);
CREATE unique index idx_unique_students__email
    on students (email);


----------- add students  -----------
INSERT INTO students (id, name, email)
VALUES ('fa86fd87-7192-4fa3-bdcd-da93c2a8f4b9', 'Admin', 'admin@admin.com');




