CREATE TABLE courses (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    owner VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

-- Insertar 15 registros en la tabla courses
INSERT INTO courses (title, description, owner, price) VALUES
    ('Introducción a Java', 'Curso introductorio sobre programación en Java', 'FastLearn', 49.99),
    ('Desarrollo web con Spring Boot', 'Aprende a crear aplicaciones web con Spring Boot', 'FastLearn', 59.99),
    ('Fundamentos de Python', 'Curso básico sobre Python para principiantes', 'FastLearn', 29.99),
    ('Machine Learning con Python', 'Curso avanzado sobre machine learning con Python', 'FastLearn', 39.99),
    ('Diseño de bases de datos', 'Aprende a diseñar bases de datos relacionales', 'FastLearn', 69.99),
    ('Desarrollo de aplicaciones móviles', 'Curso sobre desarrollo de aplicaciones móviles con Android', 'FastLearn', 79.99),
    ('Introducción a la inteligencia artificial', 'Conceptos básicos sobre inteligencia artificial', 'FastLearn', 89.99),
    ('Programación en C++', 'Curso avanzado sobre programación en C++', 'FastLearn', 99.99),
    ('Análisis de datos con R', 'Curso sobre análisis de datos utilizando el lenguaje R', 'FastLearn', 109.99),
    ('Desarrollo de APIs RESTful', 'Aprende a crear APIs RESTful con Node.js', 'FastLearn', 119.99),
    ('Seguridad informática', 'Curso sobre seguridad informática y hacking ético', 'FastLearn', 129.99),
    ('Introducción al cloud computing', 'Conceptos básicos sobre cloud computing y servicios en la nube', 'FastLearn', 139.99),
    ('Administración de servidores Linux', 'Curso avanzado sobre administración de servidores Linux', 'FastLearn', 149.99),
    ('Desarrollo de aplicaciones web con React', 'Aprende a crear aplicaciones web modernas con React', 'FastLearn', 159.99),
    ('Introducción a la programación funcional', 'Curso introductorio sobre programación funcional en Haskell', 'FastLearn', 169.99);
