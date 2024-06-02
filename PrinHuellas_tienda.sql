-- Creación de la Base de Datos AmbientLab.
CREATE DATABASE tienda;
-- Creación de las tablas principales.

-- Creacion de la tabla para Usuario.
CREATE TABLE usuario (
   idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    foto VARCHAR(255),
    permiso INT NOT NULL
    );
-- Creacion de la tabla para la entidad Camiseta.
CREATE TABLE camiseta (
   idCamiseta INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(255) NOT NULL,
    talla VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    color VARCHAR(255) NOT NULL,
    foto VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    foto VARCHAR(255)
    );
-- Creacion de la tabla carrito.
-- en desarrollo
-- Creacion de la tabla pedido.
-- en dearrollo


-- Creamos una serie de datos para rellenar las tablas

-- Insertar usuarios .
INSERT INTO usuario (nombre, correo, contrasena, foto, permiso) VALUES
('admin', 'admin@huellas.es', '18c6d818ae35a3e8279b5330eda01498', 'programador (1).png', 1), -- Usuario Admin.
('Alejandro Ortega', 'alejandro.o@gmail.com','e052450f29b2e0e9a53fd4eb389e25a9', 9), -- Usuario Cliente.
('Rick Sánchez', 'rick@sanchez.com', '07a22908afd8a24323a94b7af43f4daa', 'tshirt_modelo_hombre2.jpg',9);


-- Insertar camisetas de ejemplo
INSERT INTO camiseta (modelo, talla, cantidad, color, foto, estado) VALUES
('Hombre', 'XL', 3, 'azul', 'pata.png', 'preparando'),
('Hombre', 'L', 5, 'azul', 'geek_girl.jpg', 'preparando'),
('Mujer', 'XL', 1, 'negro', 'camisetas_niño.jpg', 'preparando'),
('Niño', 'M', 1, 'gris', 'geek_girl.jpg', 'preparando'),
('Hombre', 'XXL', 30, 'marron', 'camisetas_niño.jpg', 'preparando');









