-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 04:48:46
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
-- Base de datos: `grupo30elgranhotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL,
  `idTipoHab` int(11) NOT NULL,
  `numHabitacion` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `categoriaHabitacion` varchar(30) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`idHabitacion`, `idTipoHab`, `numHabitacion`, `estado`, `categoriaHabitacion`, `descripcion`) VALUES
(3, 0, '3', 1, 'Estandar Simple', 'eee'),
(7, 0, '2', 0, 'Doble', '22'),
(8, 0, '1', 1, 'Estandar Simple', 'Incluye desayuno a la cama.'),
(9, 0, '5', 1, 'Doble', 'ff');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `idHuesped` int(11) NOT NULL,
  `tipoDocumento` varchar(20) NOT NULL,
  `numDocumento` varchar(40) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `domicilio` varchar(40) NOT NULL,
  `celular` varchar(11) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `cancelacion` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`idHuesped`, `tipoDocumento`, `numDocumento`, `apellido`, `nombre`, `domicilio`, `celular`, `correo`, `estado`, `cancelacion`) VALUES
(14, 'ddd', '222', 'www', 'www', 'ssseeddd', '222', 'ssss', 0, 0),
(15, 'ddd', 'sss', 'ssiiii', 'sssoooffff', 'ssjjjj', '3333444', 'ss', 0, 0),
(17, 'w', 's', 's', 's', 's', 's', 's', 0, 0),
(19, 'DNI', '95358109', 'Robles', 'Juan', 'Corrientes 1388', '11234567', 'jrelgranhotel@hotmail.com', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idHuesped` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `cantPersonas` int(11) NOT NULL,
  `fechaReserva` date NOT NULL,
  `fechaEntrada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `estado` varchar(30) NOT NULL,
  `tipoReserva` varchar(20) NOT NULL,
  `totalDias` int(11) NOT NULL,
  `pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `idHuesped`, `idHabitacion`, `cantPersonas`, `fechaReserva`, `fechaEntrada`, `fechaSalida`, `estado`, `tipoReserva`, `totalDias`, `pago`) VALUES
(12, 14, 3, 2, '1929-10-29', '1929-10-29', '1930-10-30', 'Por confirmar', 'Por confirmar', 0, 23),
(13, 17, 7, 5, '1929-10-29', '1929-10-29', '1930-10-30', 'Por confirmar', 'Por confirmar', 0, 1111),
(14, 15, 3, 3, '1929-10-29', '1930-10-30', '1931-10-31', 'Por confirmar', 'Por confirmar', 0, 3333),
(15, 19, 8, 1, '1929-10-29', '1931-10-31', '1904-11-04', 'Por confirmar', 'Por confirmar', 0, 30000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipohabitacion`
--

CREATE TABLE `tipohabitacion` (
  `idTipoHab` int(11) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `cantPersonas` int(10) NOT NULL,
  `cantCamas` int(10) NOT NULL,
  `categoriaCama` varchar(30) NOT NULL,
  `tipoHabitacion` varchar(30) NOT NULL,
  `precioNoche` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipohabitacion`
--

INSERT INTO `tipohabitacion` (`idTipoHab`, `codigo`, `cantPersonas`, `cantCamas`, `categoriaCama`, `tipoHabitacion`, `precioNoche`) VALUES
(1, '1', 1, 1, 'simple', 'doble', 20000),
(2, '2', 2, 2, 'dobles', 'triples', 10000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idHabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`idHuesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`);

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
  MODIFY `idHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `idHuesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  MODIFY `idTipoHab` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
