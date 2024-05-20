INSERT INTO Alumnos(nombre) VALUES('Jose');
INSERT INTO Alumnos(nombre) VALUES('Daniel');
INSERT INTO Alumnos(nombre) VALUES('Emilia');
INSERT INTO Alumnos(nombre) VALUES('Diana');
INSERT INTO Alumnos(nombre) VALUES('Karen');
INSERT INTO Alumnos(nombre) VALUES('Carlos');
INSERT INTO Alumnos(nombre) VALUES('Pedro');

INSERT INTO Cursos(nombre, tipo_curso) VALUES('Ciencias', 'MIXTO'); 
INSERT INTO Cursos(nombre, tipo_curso) VALUES('Matematicas', 'CALIFICACION');
INSERT INTO Cursos(nombre, tipo_curso) VALUES('Etica', 'ASISTENCIA');
INSERT INTO Cursos(nombre, tipo_curso) VALUES('Historia', 'MIXTO');
INSERT INTO Cursos(nombre, tipo_curso) VALUES('Lengua', 'ASISTENCIA');

INSERT INTO Inscripciones(id_alumno, id_curso, calificacion) VALUES(1, 2, 8);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion, asistencias) VALUES(1, 4, 9, 80);
INSERT INTO Inscripciones(id_alumno, id_curso, asistencias) VALUES(2, 3, 50);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion) VALUES(3, 2, 1);
INSERT INTO Inscripciones(id_alumno, id_curso, asistencias) VALUES(4, 3, 90);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion) VALUES(4, 5, 10);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion, asistencias) VALUES(5, 4, 10, 90);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion) VALUES(5, 2, 7);
INSERT INTO Inscripciones(id_alumno, id_curso, asistencias) VALUES(5, 3, 78);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion, asistencias) VALUES(6, 1, 8, 80);
INSERT INTO Inscripciones(id_alumno, id_curso, asistencias) VALUES(6, 5, 50);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion) VALUES(7, 2, 3);
INSERT INTO Inscripciones(id_alumno, id_curso, calificacion, asistencias) VALUES(7, 4, 10, 100);