create database bd_librum;
use bd_librum;

CREATE TABLE libro (
    isbn VARCHAR(50) NOT NULL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descripcion TEXT NOT NULL,
    autor VARCHAR(100) NOT NULL,
    genero VARCHAR(100) NOT NULL
) engine = InnoDB DEFAULT CHARSET=latin1;

SELECT * FROM libro;

-- datos
INSERT INTO libro (isbn, titulo, descripcion, autor, genero)
VALUES
('978-3-16-148410-0', 'El Alquimista', 'Un joven llamado Paulo busca encontrar su leyenda personal a través de un viaje lleno de magia, misterio y enseñanzas.', 'Paulo Coelho', 'Ficción'),
('978-0-14-017739-8', '1984', 'Una sociedad distópica controlada por un régimen totalitario, donde la privacidad y la libertad de pensamiento están prohibidas.', 'George Orwell', 'Ciencia Ficción'),
('978-0-7432-7356-5', 'Sapiens: De animales a dioses', 'Una historia de la humanidad desde los primeros Homo sapiens hasta la era moderna, explorando cómo hemos llegado a dominar el mundo.', 'Yuval Noah Harari', 'No Ficción');
