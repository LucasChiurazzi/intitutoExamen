-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `examen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `domicilio` varchar(250) DEFAULT NULL,
  `fechanac` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipodni` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `apellido`, `dni`, `domicilio`, `fechanac`, `nombre`, `sexo`, `telefono`, `tipodni`) VALUES
(3, 'Perez', 32173506, 'Maestro Gonzalez 820', '1986-06-04', 'Jhon', 'masculino', '1234567', 'DNI'),
(4, 'Perez', 32173506, 'Maestro Gonzalez 820', '1986-06-04', 'Juan', 'masculino', '1234567', 'DNI'),
(5, 'Perez', 4444444, 'Maestro Gonzalez 820', '1986-06-03', 'Peter', 'masculino', '1234567', 'DNI'),
(6, 'Perez', 32173506, 'Maestro Gonzalez 820', '1986-06-04', 'Pedro', 'masculino', '1234567', 'DNI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursada`
--

CREATE TABLE `cursada` (
  `id` bigint(20) NOT NULL,
  `fecha_cursada` datetime DEFAULT NULL,
  `nota` double DEFAULT NULL,
  `alumno_id` bigint(20) DEFAULT NULL,
  `curso_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursada`
--

INSERT INTO `cursada` (`id`, `fecha_cursada`, `nota`, `alumno_id`, `curso_id`) VALUES
(2, '2015-03-02 00:00:00', 10, 4, 4),
(3, '2018-03-01 00:00:00', 9, 5, 3),
(4, '2019-08-05 00:00:00', 5, 6, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre_curso` varchar(255) DEFAULT NULL,
  `notaxaprobar` int(11) DEFAULT NULL,
  `profesor_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id`, `descripcion`, `nombre_curso`, `notaxaprobar`, `profesor_id`) VALUES
(2, 'Introduccion', 'Programacion', 7, 2),
(3, 'Idioma ingles', 'Ingles 1', 7, 4),
(4, 'Numeros', 'Matematica', 6, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `domicilio` varchar(250) DEFAULT NULL,
  `fechanac` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipodni` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id`, `apellido`, `dni`, `domicilio`, `fechanac`, `nombre`, `sexo`, `telefono`, `tipodni`) VALUES
(2, 'Chiurazzi2', 32173506, 'Maestro Gonzalez 820', '2018-06-03', 'Lu', 'masculino', '1234567', 'DNI'),
(3, 'Chiurazzi2', 32173506, 'Maestro Gonzalez 820', '2018-06-03', 'Profesor', 'masculino', '1234567', 'DNI'),
(4, 'Chiurazzi2', 5555555, 'Maestro Gonzalez 820', '2018-06-02', 'Pepe Profesor', 'masculino', '1234567', 'DNI'),
(5, 'Chiurazzi2', 1111111, 'Maestro Gonzalez 820', '2018-06-03', 'Andres', 'masculino', '1234567', 'DNI');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cursada`
--
ALTER TABLE `cursada`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbky7pssgt2q34bfi18n67mclr` (`alumno_id`),
  ADD KEY `FKn21qmcbhl94ox64a7ess2v1f` (`curso_id`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2w3lfylwy3y81e5kubeyu4t3k` (`profesor_id`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `cursada`
--
ALTER TABLE `cursada`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cursada`
--
ALTER TABLE `cursada`
  ADD CONSTRAINT `FKbky7pssgt2q34bfi18n67mclr` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`),
  ADD CONSTRAINT `FKn21qmcbhl94ox64a7ess2v1f` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`);

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `FK2w3lfylwy3y81e5kubeyu4t3k` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
