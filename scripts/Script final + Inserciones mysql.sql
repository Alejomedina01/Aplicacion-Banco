-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.18-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para banco
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `banco`;

-- Volcando estructura para tabla banco.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` bigint(20) NOT NULL,
  `nombre_cliente` varchar(30) NOT NULL,
  `apellido_cliente` varchar(30) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  `correo` varchar(30) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `CLI_FK_IDL` (`id_lugar`),
  CONSTRAINT `CLI_FK_IDL` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`),
  CONSTRAINT `cli_ck_idc` CHECK (`id_cliente` > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla banco.clientes: ~5 rows (aproximadamente)
DELETE FROM `clientes`;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`id_cliente`, `nombre_cliente`, `apellido_cliente`, `telefono`, `id_lugar`, `correo`) VALUES
	(10076313, 'Maria', 'Perez', 3215478963, 1, 'Maria.perez@gmail.com'),
	(12345678, 'Juan', 'Perez', 3215478965, 1, 'juan.perez@gmail.com'),
	(24156874, 'Pedro', 'Colmenares', 3215478961, 2, 'Pedro.Colmenares@gmail.com'),
	(74335516, 'Nelly', 'Colmenares', 3215478962, 2, 'Nelly.Colmenares@gmail.com'),
	(98765432, 'Camilo', 'Perez', 3215478964, 1, 'Camilo.perez@gmail.com');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para tabla banco.cuentas_bancarias
CREATE TABLE IF NOT EXISTS `cuentas_bancarias` (
  `id_cuenta` int(11) NOT NULL,
  `clave` text NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `id_tipo_cuenta` tinyint(4) NOT NULL,
  `saldo` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cuenta`),
  UNIQUE KEY `id_cuenta` (`id_cuenta`),
  KEY `CUE_FK_IDC` (`id_cliente`),
  KEY `CUE_FK_IDT` (`id_tipo_cuenta`),
  CONSTRAINT `CUE_FK_IDC` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `CUE_FK_IDT` FOREIGN KEY (`id_tipo_cuenta`) REFERENCES `tipos_cuentas` (`id_tipo_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla banco.cuentas_bancarias: ~5 rows (aproximadamente)
DELETE FROM `cuentas_bancarias`;
/*!40000 ALTER TABLE `cuentas_bancarias` DISABLE KEYS */;
INSERT INTO `cuentas_bancarias` (`id_cuenta`, `clave`, `id_cliente`, `id_tipo_cuenta`, `saldo`) VALUES
	(111111, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 24156874, 1, 120000),
	(222222, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 74335516, 2, 9800000),
	(333333, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 10076313, 1, 400000),
	(444444, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 98765432, 2, 39100000),
	(555555, '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 12345678, 1, 600000);
/*!40000 ALTER TABLE `cuentas_bancarias` ENABLE KEYS */;

-- Volcando estructura para tabla banco.lugares
CREATE TABLE IF NOT EXISTS `lugares` (
  `id_lugar` int(11) NOT NULL,
  `codigo_postal` int(11) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `nombre_ciudad` varchar(30) NOT NULL,
  PRIMARY KEY (`id_lugar`),
  CONSTRAINT `lug_ck_idl` CHECK (`id_lugar` > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla banco.lugares: ~2 rows (aproximadamente)
DELETE FROM `lugares`;
/*!40000 ALTER TABLE `lugares` DISABLE KEYS */;
INSERT INTO `lugares` (`id_lugar`, `codigo_postal`, `direccion`, `nombre_ciudad`) VALUES
	(1, 150001, 'Calle 67 #6-24', 'Tunja'),
	(2, 760001, 'Calle 45 #7-20', 'Cali');
/*!40000 ALTER TABLE `lugares` ENABLE KEYS */;

-- Volcando estructura para tabla banco.sucursales
CREATE TABLE IF NOT EXISTS `sucursales` (
  `id_sucursal` smallint(6) NOT NULL,
  `nombre_sucursal` varchar(30) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  PRIMARY KEY (`id_sucursal`),
  KEY `SUC_FK_IDL` (`id_lugar`),
  CONSTRAINT `SUC_FK_IDL` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`),
  CONSTRAINT `suc_ck_ids` CHECK (`id_sucursal` > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla banco.sucursales: ~4 rows (aproximadamente)
DELETE FROM `sucursales`;
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` (`id_sucursal`, `nombre_sucursal`, `id_lugar`) VALUES
	(18316, 'S. Primera', 1),
	(18318, 'S. Segunda', 1),
	(25316, 'S. Primera', 2),
	(25318, 'S. Segunda', 2);
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;

-- Volcando estructura para tabla banco.tipos_cuentas
CREATE TABLE IF NOT EXISTS `tipos_cuentas` (
  `id_tipo_cuenta` tinyint(4) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`id_tipo_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla banco.tipos_cuentas: ~3 rows (aproximadamente)
DELETE FROM `tipos_cuentas`;
/*!40000 ALTER TABLE `tipos_cuentas` DISABLE KEYS */;
INSERT INTO `tipos_cuentas` (`id_tipo_cuenta`, `descripcion`) VALUES
	(1, 'Ahorros'),
	(2, 'Corriente'),
	(3, 'Credito');
/*!40000 ALTER TABLE `tipos_cuentas` ENABLE KEYS */;

-- Volcando estructura para tabla banco.tipos_transacciones
CREATE TABLE IF NOT EXISTS `tipos_transacciones` (
  `id_tipo_transaccion` smallint(2) NOT NULL AUTO_INCREMENT,
  `nombre_transaccion` varchar(30) NOT NULL,
  PRIMARY KEY (`id_tipo_transaccion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla banco.tipos_transacciones: ~1 rows (aproximadamente)
DELETE FROM `tipos_transacciones`;
/*!40000 ALTER TABLE `tipos_transacciones` DISABLE KEYS */;
INSERT INTO `tipos_transacciones` (`id_tipo_transaccion`, `nombre_transaccion`) VALUES
	(1, 'Retiro');
/*!40000 ALTER TABLE `tipos_transacciones` ENABLE KEYS */;

-- Volcando estructura para tabla banco.transacciones
CREATE TABLE IF NOT EXISTS `transacciones` (
  `id_transaccion` int(11) NOT NULL AUTO_INCREMENT,
  `monto_transaccion` bigint(20) NOT NULL,
  `fecha_transaccion` datetime NOT NULL,
  `id_sucursal` smallint(5) NOT NULL,
  `id_tipo_transaccion` smallint(2) NOT NULL,
  `id_cuenta_origen` int(11) NOT NULL,
  `id_cuenta_destino` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transaccion`),
  KEY `TRA_FK_IDC` (`id_cuenta_origen`),
  KEY `TRA_FK_OPC` (`id_cuenta_destino`),
  KEY `TRA_FK_SUC` (`id_sucursal`) USING BTREE,
  KEY `TRA_FK_TIP` (`id_tipo_transaccion`),
  CONSTRAINT `TRA_FK_IDC` FOREIGN KEY (`id_cuenta_origen`) REFERENCES `cuentas_bancarias` (`id_cuenta`),
  CONSTRAINT `TRA_FK_OPC` FOREIGN KEY (`id_cuenta_destino`) REFERENCES `cuentas_bancarias` (`id_cuenta`),
  CONSTRAINT `TRA_FK_SUC` FOREIGN KEY (`id_Sucursal`) REFERENCES `sucursales` (`id_sucursal`),
  CONSTRAINT `TRA_FK_TIP` FOREIGN KEY (`id_tipo_transaccion`) REFERENCES `tipos_transacciones` (`id_tipo_transaccion`)
) ENGINE=InnoDB AUTO_INCREMENT=987713 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla banco.transacciones: ~6 rows (aproximadamente)
DELETE FROM `transacciones`;
/*!40000 ALTER TABLE `transacciones` DISABLE KEYS */;
INSERT INTO `transacciones` (`id_transaccion`, `monto_transaccion`, `fecha_transaccion`, `id_sucursal`, `id_tipo_transaccion`, `id_cuenta_origen`, `id_cuenta_destino`) VALUES
	(987654, 200000, '2021-04-07 00:00:00', 18316, 1, 222222, NULL),
	(987655, 150000, '2021-04-05 00:00:00', 18318, 1, 111111, NULL),
	(987656, 80000, '2021-04-03 00:00:00', 18316, 1, 333333, NULL),
	(987657, 700000, '2021-04-22 00:00:00', 18318, 1, 444444, NULL),
	(987658, 20000, '2021-04-18 00:00:00', 18318, 1, 555555, NULL),
	(987659, 100000, '2021-04-01 00:00:00', 18316, 1, 444444, NULL);
/*!40000 ALTER TABLE `transacciones` ENABLE KEYS */;

-- Volcando estructura para procedimiento banco.update_saldo
DELIMITER //
CREATE PROCEDURE `update_saldo`(
	IN `p_id_cuenta` INT,
	IN `p_nuevo_saldo` BIGINT
)
BEGIN
	UPDATE CUENTAS_BANCARIAS
	SET saldo = (p_nuevo_saldo)
	WHERE id_cuenta = p_id_cuenta;
END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
