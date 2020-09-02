/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50645
Source Host           : localhost:3306
Source Database       : unisocial-spark

Target Server Type    : MYSQL
Target Server Version : 50645
File Encoding         : 65001

Date: 2020-09-02 18:00:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aporte
-- ----------------------------
DROP TABLE IF EXISTS `aporte`;
CREATE TABLE `aporte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `topico_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4jd49htc53v8wv544do73qv1t` (`topico_id`),
  KEY `FK_bnvx7pailxlfelbidm0qwci8i` (`usuario_id`),
  CONSTRAINT `FK_4jd49htc53v8wv544do73qv1t` FOREIGN KEY (`topico_id`) REFERENCES `topico` (`id`),
  CONSTRAINT `FK_bnvx7pailxlfelbidm0qwci8i` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of aporte
-- ----------------------------

-- ----------------------------
-- Table structure for archivo
-- ----------------------------
DROP TABLE IF EXISTS `archivo`;
CREATE TABLE `archivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `ruta` varchar(255) DEFAULT NULL,
  `aporte_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fe3kmh6ms5fyo9tlstjaf0p86` (`aporte_id`),
  CONSTRAINT `FK_fe3kmh6ms5fyo9tlstjaf0p86` FOREIGN KEY (`aporte_id`) REFERENCES `aporte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of archivo
-- ----------------------------

-- ----------------------------
-- Table structure for permiso
-- ----------------------------
DROP TABLE IF EXISTS `permiso`;
CREATE TABLE `permiso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of permiso
-- ----------------------------
INSERT INTO `permiso` VALUES ('1', 'Permite crear aportes', 'Alta de aportes');
INSERT INTO `permiso` VALUES ('2', 'Permite crear usuarios', 'Alta de usuarios');

-- ----------------------------
-- Table structure for puntuciaon
-- ----------------------------
DROP TABLE IF EXISTS `puntuciaon`;
CREATE TABLE `puntuciaon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `aporte_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_36k4qm3e289t3ek11hb7ya2b8` (`aporte_id`),
  KEY `FK_n7rkmqrqx84jko3aa4xy5l9s7` (`usuario_id`),
  CONSTRAINT `FK_36k4qm3e289t3ek11hb7ya2b8` FOREIGN KEY (`aporte_id`) REFERENCES `aporte` (`id`),
  CONSTRAINT `FK_n7rkmqrqx84jko3aa4xy5l9s7` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of puntuciaon
-- ----------------------------

-- ----------------------------
-- Table structure for reputacion
-- ----------------------------
DROP TABLE IF EXISTS `reputacion`;
CREATE TABLE `reputacion` (
  `tipo` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of reputacion
-- ----------------------------
INSERT INTO `reputacion` VALUES ('buena', '1');
INSERT INTO `reputacion` VALUES ('buena', '2');
INSERT INTO `reputacion` VALUES ('buena', '3');
INSERT INTO `reputacion` VALUES ('buena', '5');

-- ----------------------------
-- Table structure for rol
-- ----------------------------
DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rol
-- ----------------------------
INSERT INTO `rol` VALUES ('1', 'Administrador');
INSERT INTO `rol` VALUES ('2', 'Docente');
INSERT INTO `rol` VALUES ('3', 'Alumno');

-- ----------------------------
-- Table structure for rol_permiso
-- ----------------------------
DROP TABLE IF EXISTS `rol_permiso`;
CREATE TABLE `rol_permiso` (
  `Rol_id` int(11) NOT NULL,
  `permisos_id` int(11) NOT NULL,
  KEY `FK_1bcy3u4hxtb0dc1ra2w8761cd` (`permisos_id`),
  KEY `FK_cohg8qovoqea416s4bxbiaqt6` (`Rol_id`),
  CONSTRAINT `FK_1bcy3u4hxtb0dc1ra2w8761cd` FOREIGN KEY (`permisos_id`) REFERENCES `permiso` (`id`),
  CONSTRAINT `FK_cohg8qovoqea416s4bxbiaqt6` FOREIGN KEY (`Rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rol_permiso
-- ----------------------------

-- ----------------------------
-- Table structure for topico
-- ----------------------------
DROP TABLE IF EXISTS `topico`;
CREATE TABLE `topico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of topico
-- ----------------------------
INSERT INTO `topico` VALUES ('1', 'Parciales sin resolver o resueltos por docentes o alumnos', 'Parciales');
INSERT INTO `topico` VALUES ('2', 'Finales sin resolver o resuletos por docentes o alumnos', 'Finales');
INSERT INTO `topico` VALUES ('3', 'Enunciados de trabajos prácticos', 'Trabajo Práctico');
INSERT INTO `topico` VALUES ('4', 'Apuntes y guias de cursadas', 'Apuntes y guias');
INSERT INTO `topico` VALUES ('5', 'Libros digitalizados', 'Libros');
INSERT INTO `topico` VALUES ('6', 'Ejercicios resueltos o sin resolver', 'Ejercicios');
INSERT INTO `topico` VALUES ('7', 'Recomendaciones de cursadas', 'Recomendaciones');
INSERT INTO `topico` VALUES ('8', 'Dudas sobre cursadas', 'Dudas');
INSERT INTO `topico` VALUES ('9', 'Consultas referentes a trámites con la universidad', 'Consultas administrativas');
INSERT INTO `topico` VALUES ('10', 'Toda otra cosa que no se clasifique en otro tópico', 'Otro');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `legajo` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `reputacion_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombreDeUsuario` varchar(255) DEFAULT NULL,
  `rol_id` int(11) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l67cywj7tpy6odsa9qmj74rt0` (`reputacion_id`),
  KEY `FK_9hfl8tdutsxq1r5er252rnssq` (`rol_id`),
  CONSTRAINT `FK_9hfl8tdutsxq1r5er252rnssq` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FK_l67cywj7tpy6odsa9qmj74rt0` FOREIGN KEY (`reputacion_id`) REFERENCES `reputacion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('1', 'Saclier', null, '112233', 'Lucas', '1156585936', '1', '', 'lsaclier', '1', '1234567');
INSERT INTO `usuario` VALUES ('2', 'Escobar', null, '112244', 'Ezequiel', '1156339837', '2', '', 'eescobar', '2', '1234567');
INSERT INTO `usuario` VALUES ('3', 'Prieto', null, '112255', 'Gaston', '1156449831', '3', '', 'gprieto', '2', '1234567');
INSERT INTO `usuario` VALUES ('4', 'Sosa', null, '112266', 'Ezequiel', '1156559832', '5', '', 'esosa', '2', '1234567');
