-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2023 a las 22:47:17
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `grupo30hotel1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL,
  `idTipoHab` int(11) NOT NULL,
  `numHabitacion` varchar(12) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `categoriaHabitacion` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`idHabitacion`, `idTipoHab`, `numHabitacion`, `estado`, `categoriaHabitacion`, `descripcion`) VALUES
(12, 3, '7', 1, 'simple', 'ff'),
(13, 2, '7', 1, 'Doble', 'vista al mar'),
(14, 1, '3', 0, 'Estandar Simple', 'paseos'),
(15, 1, '5', 1, 'Estandar Simple', 'e34'),
(16, 1, '4', 1, 'Estandar Simple', 'gg'),
(17, 1, '22', 1, 'Estandar Simple', 'dddd'),
(18, 1, '43', 1, 'Estandar Simple', 'con desayunos '),
(20, 1, '12', 1, 'Estandar Simple', 'incluye paseos'),
(21, 1, '121', 1, 'Doble', 'con vistas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `idHuesped` int(11) NOT NULL,
  `tipoDocumento` varchar(20) NOT NULL,
  `numDocumento` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `domicilio` varchar(40) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `correo` varchar(20) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `cancelacion` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`idHuesped`, `tipoDocumento`, `numDocumento`, `apellido`, `nombre`, `domicilio`, `celular`, `correo`, `estado`, `cancelacion`) VALUES
(1, 'Pasaporte', '235', 'Lopez   llosa', 'Andrea', 'Roca', '22222', 'ddelm', 0, 0),
(2, 'Pasaporte', '225', 'Juarez hugo', 'Ana', 'Soliz', '238647', 'mmm@cc.com', 0, 0),
(9, 'DNI', '1223', 'rodriguez', 'meli', 'bellavista', '121212', 'ssss', 0, 0),
(14, 'Pasaporte', '4343', 'Llosa', 'mario', 'arequipa', '121212', 'llosa@gmail', 1, 1),
(15, 'DNI', '333', 'abelardo', 'abel', 'avenida', '1234', 'gmai.com', 1, 1),
(16, 'DNI', '111', 'a', 'b', 'd', '123', 'm.1@gma', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idHuesped` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `cantPersonas` int(15) NOT NULL,
  `fechaReserva` date NOT NULL,
  `fechaEntrada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `tipoReserva` varchar(10) NOT NULL,
  `totalDias` int(11) NOT NULL,
  `pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `idHuesped`, `idHabitacion`, `cantPersonas`, `fechaReserva`, `fechaEntrada`, `fechaSalida`, `estado`, `tipoReserva`, `totalDias`, `pago`) VALUES
(23, 1, 14, 4, '1909-11-09', '1910-11-10', '1916-11-16', 0, 'Por confir', 0, 0),
(27, 9, 16, 1, '2023-11-04', '2023-11-12', '2023-11-15', 1, 'ESTANDAR', 3, 138),
(29, 1, 16, 1, '1905-11-05', '1912-11-12', '1918-11-18', 0, 'ESTANDAR', 0, 1920),
(30, 2, 16, 1, '1904-11-04', '1905-11-05', '1909-11-09', 0, 'ESTANDAR', 0, 400);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipohabitacion`
--

CREATE TABLE `tipohabitacion` (
  `idTipoHab` int(11) NOT NULL,
  `codigo` varchar(12) NOT NULL,
  `cantPersonas` varchar(11) NOT NULL,
  `cantCamas` varchar(11) NOT NULL,
  `categoriaCama` varchar(20) NOT NULL,
  `tipoHabitacion` varchar(20) NOT NULL,
  `precioNoche` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipohabitacion`
--

INSERT INTO `tipohabitacion` (`idTipoHab`, `codigo`, `cantPersonas`, `cantCamas`, `categoriaCama`, `tipoHabitacion`, `precioNoche`) VALUES
(1, '1', '3', '4', 'estandar', 'suit', 0),
(2, '2', '2', '3', 'simple', 'doble', 3000),
(3, '3', '4', '4', 's', 's', 5),
(6, '2', '2', '3', 'simple', 'doble', 3000),
(7, '1', '2', '3', 'simple', 'simple', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idHabitacion`),
  ADD KEY `idTipoHab` (`idTipoHab`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`idHuesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `idHabitacion` (`idHabitacion`),
  ADD KEY `idHuesped` (`idHuesped`);

--
-- Indices de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  ADD PRIMARY KEY (`idTipoHab`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `idHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `idHuesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  MODIFY `idTipoHab` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`idTipoHab`) REFERENCES `tipohabitacion` (`idTipoHab`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idHuesped`) REFERENCES `huesped` (`idHuesped`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
