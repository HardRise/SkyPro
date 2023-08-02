-- liquibase formatted sql

-- changeset morozov:1
CREATE INDEX student_name_index ON student (name);

-- changeset morozov:2
CREATE INDEX colour_and_name_faculty_index ON faculty (colour, name);