CREATE TABLE IF NOT EXISTS Alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    tipo_curso VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Inscripciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT NOT NULL,
    id_curso INT NOT NULL,
    calificacion INT,
    asistencias INT,
    FOREIGN KEY (id_alumno) REFERENCES Alumnos(id),
    FOREIGN KEY (id_curso) REFERENCES Cursos(id)
);