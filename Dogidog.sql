-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dogidog
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comentarios_tarea`
--

DROP TABLE IF EXISTS `comentarios_tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarios_tarea` (
  `id_comentario` int NOT NULL AUTO_INCREMENT,
  `id_tarea` int DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `comentario` text,
  `autor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `id_tarea` (`id_tarea`),
  CONSTRAINT `comentarios_tarea_ibfk_1` FOREIGN KEY (`id_tarea`) REFERENCES `tareas` (`id_tarea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios_tarea`
--

LOCK TABLES `comentarios_tarea` WRITE;
/*!40000 ALTER TABLE `comentarios_tarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentarios_tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentacion`
--

DROP TABLE IF EXISTS `documentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documentacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mascota_id` int NOT NULL,
  `tipo` enum('Consulta','Vacuna Realizada','Desparasitación','Esterilización','Cambio de pienso','Cartilla','Otros') NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` text,
  `archivo` varchar(255) DEFAULT NULL,
  `creado_en` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `mascota_id` (`mascota_id`),
  CONSTRAINT `documentacion_ibfk_1` FOREIGN KEY (`mascota_id`) REFERENCES `mascotas` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentacion`
--

LOCK TABLES `documentacion` WRITE;
/*!40000 ALTER TABLE `documentacion` DISABLE KEYS */;
INSERT INTO `documentacion` VALUES (80,35,'Consulta','2023-09-15','Revisión general de salud. Todo en orden.',NULL,'2023-09-14 22:00:00'),(81,34,'Vacuna Realizada','2023-09-20','Vacuna contra la rabia aplicada.',NULL,'2023-09-19 22:00:00'),(82,35,'Desparasitación','2023-10-01','Desparasitación interna y externa.',NULL,'2023-09-30 22:00:00'),(83,33,'Esterilización','2023-08-10','Esterilización realizada sin complicaciones.',NULL,'2023-08-09 22:00:00'),(84,33,'Cambio de pienso','2023-09-05','Cambio a pienso hipoalergénico por recomendación veterinaria.',NULL,'2023-09-04 22:00:00'),(85,34,'Consulta','2023-07-22','Revisión por posible alergia cutánea.',NULL,'2023-07-21 22:00:00'),(86,34,'Vacuna Realizada','2023-08-01','Vacuna polivalente aplicada.',NULL,'2023-07-31 22:00:00'),(88,1,'Desparasitación','2025-04-17','Le han quitado todas las pulgas a Saiya','','2025-04-29 22:00:00'),(89,1,'Otros','2025-04-09','Paseos','','2025-04-29 22:00:00'),(100,1,'Consulta','2025-05-14','ey','documentacion/100/archivos/tempFile.jpg','2025-05-13 22:00:00'),(110,1,'Consulta','2025-05-14','holooo','documentacion/110/archivos/tempFile.jpg','2025-05-13 22:00:00');
/*!40000 ALTER TABLE `documentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `empleado_id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `puesto` varchar(50) NOT NULL,
  `fecha_contratacion` date NOT NULL,
  `es_administrador` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`empleado_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,1,'Programador','2023-05-10',1),(2,2,'Control de IA','2022-11-15',1),(3,3,'Analista','2021-07-20',0),(4,4,'Jefe de Proyecto','2020-03-05',1),(5,5,'Programador','2023-08-01',0);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logros`
--

DROP TABLE IF EXISTS `logros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logros` (
  `logro_id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `emblema` varchar(255) DEFAULT NULL,
  `usuarios_desbloqueados` int DEFAULT '0',
  PRIMARY KEY (`logro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logros`
--

LOCK TABLES `logros` WRITE;
/*!40000 ALTER TABLE `logros` DISABLE KEYS */;
INSERT INTO `logros` VALUES (1,'?‍? El Guardián del Reino','Tienes un Border Collie, el perro más inteligente y enérgico del reino.','guardian_reino.png',1),(2,'? El Primer Sendero','Realiza tu primer paseo con tu mascota.','primer_sendero.png',0),(3,'⚡ Rastro Veloz','Recorre un total de 500 metros.','rastro_veloz.png',0),(4,'? Conexión Mental','Haz tu primera pregunta a Dogibot.','conexion_mental.png',1),(5,'⚖️ Balance Perfecto','Mantén el peso saludable de tu mascota.','balance_perfecto.png',0),(6,'? Alfa del Clan','Registra una mascota macho.','alfa_del_clan.png',2),(7,'? Reina del Bosque','Registra una mascota hembra.','reina_del_bosque.png',0),(8,'? Guardián de la Salud','Añade una consulta veterinaria a la documentación.','guardian_salud.png',0),(9,'? Nuevo Comienzo','Registra una mascota de 0 años.','nuevo_comienzo.png',1),(10,'? Leyenda Veterana','Registra una mascota de 10 años o más.','leyenda_veterana.png',0),(11,'? Rostro de Héroe','Sube una imagen de tu mascota.','rostro_heroe.png',2),(12,'? Cambio de Sabor','Cambia el pienso de tu mascota.','cambio_sabor.png',0),(13,'? Voz del Pueblo','Comenta en el perfil de otro dueño.','voz_pueblo.png',0),(14,'⭐ Máxima Reputación','Alcanza una valoración de 5 estrellas.','maxima_reputacion.png',0),(15,'? El Despertar','Desbloquea tu primer logro.','el_despertar.png',1);
/*!40000 ALTER TABLE `logros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascotas`
--

DROP TABLE IF EXISTS `mascotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascotas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `raza_id` int NOT NULL,
  `edad` int DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `genero` enum('Macho','Hembra') DEFAULT NULL,
  `esterilizado` tinyint(1) DEFAULT NULL,
  `fecha_proxima_vacunacion` date DEFAULT NULL,
  `fecha_proxima_desparasitacion` date DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `metros_recorridos` bigint DEFAULT '0',
  `pienso` varchar(100) DEFAULT NULL,
  `microchip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  KEY `raza_id` (`raza_id`),
  CONSTRAINT `mascotas_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `mascotas_ibfk_2` FOREIGN KEY (`raza_id`) REFERENCES `razas` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascotas`
--

LOCK TABLES `mascotas` WRITE;
/*!40000 ALTER TABLE `mascotas` DISABLE KEYS */;
INSERT INTO `mascotas` VALUES (1,25,'Saiya',1,3,'2022-03-03',15.00,'Hembra',1,'2025-09-27','2025-09-27','saiya.jpg',0,'Hills Say','1252'),(33,1,'Rex',1,3,'2021-06-15',20.50,'Macho',1,'2025-04-10','2025-05-15','rex.png',500,NULL,''),(34,1,'Luna',2,2,'2022-09-20',18.20,'Hembra',0,'2025-06-01','2025-07-10','luna.png',700,NULL,''),(35,2,'Max',3,4,'2020-03-10',22.80,'Macho',1,'2025-03-22','2025-04-30','max.png',800,NULL,''),(36,3,'Nala',4,1,'2023-11-05',12.40,'Hembra',0,'2025-07-15','2025-08-20','nala.png',600,NULL,''),(37,3,'Toby',5,5,'2019-01-12',25.30,'Macho',1,'2025-02-10','2025-03-20','toby.png',400,NULL,''),(38,4,'Coco',6,2,'2022-08-25',19.70,'Macho',0,'2025-05-05','2025-06-15','coco.png',750,NULL,''),(39,5,'Bella',7,3,'2021-04-18',17.90,'Hembra',1,'2025-04-25','2025-06-05','bella.png',900,NULL,''),(40,6,'Rocky',8,6,'2018-12-30',28.40,'Macho',1,'2025-01-20','2025-03-01','rocky.png',350,NULL,''),(41,7,'Lola',9,4,'2020-06-08',21.10,'Hembra',0,'2025-06-10','2025-07-20','lola.png',820,NULL,''),(42,8,'Simba',10,2,'2022-09-15',14.60,'Macho',0,'2025-07-05','2025-08-10','simba.png',670,NULL,''),(43,9,'Milo',11,5,'2019-02-28',23.90,'Macho',1,'2025-03-15','2025-04-25','milo.png',530,NULL,''),(45,11,'Bruno',13,3,'2021-07-22',20.10,'Macho',1,'2025-04-30','2025-06-10','bruno.png',610,NULL,''),(46,12,'Daisy',14,4,'2020-05-14',18.60,'Hembra',1,'2025-05-20','2025-07-05','daisy.png',740,NULL,''),(47,12,'Zeus',11,2,'2022-11-29',15.50,'Macho',0,'2025-06-20','2025-08-01','zeus.png',580,NULL,''),(48,13,'Kira',12,3,'2021-03-17',22.30,'Hembra',1,'2025-03-10','2025-04-30','kira.png',890,NULL,''),(50,25,'Saiyo',1,0,'2025-04-21',25.00,'Hembra',0,'9999-01-01','9999-01-01','',0,'Nothing','125233'),(51,25,'Brownie',5,0,'2025-04-15',20.00,'Macho',0,'9999-01-01','9999-01-01','',0,NULL,''),(66,25,'hola',1,0,'2025-05-14',55.00,'Macho',0,'9999-01-01','9999-01-01','',0,NULL,NULL);
/*!40000 ALTER TABLE `mascotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `mascota_id` int DEFAULT NULL,
  `titulo` varchar(100) NOT NULL,
  `mensaje` text NOT NULL,
  `fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `leida` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  KEY `mascota_id` (`mascota_id`),
  CONSTRAINT `notificaciones_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `notificaciones_ibfk_2` FOREIGN KEY (`mascota_id`) REFERENCES `mascotas` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
INSERT INTO `notificaciones` VALUES (1,1,NULL,'Recordatorio: Vacuna de tu mascota','No olvides que tu mascota tiene una vacuna pendiente para el 10/10/2023.','2025-03-11 17:33:32',0),(2,1,NULL,'¡Bienvenido a la app!','Gracias por registrarte. ¡Esperamos que disfrutes de nuestros servicios!','2025-03-11 17:33:32',1),(3,2,NULL,'Desparasitación pendiente','Recuerda que tu mascota necesita una desparasitación este mes.','2025-03-11 17:33:32',0),(4,2,NULL,'Actualización de la cartilla completada','La cartilla de vacunación de tu mascota ha sido actualizada correctamente.','2025-03-11 17:33:32',1),(5,1,NULL,'Un usuario te ha valorado con un 3','Juan es un encanto de persona pero su pero no :(','2025-05-11 21:34:42',0),(6,1,NULL,'Un usuario te ha valorado con un 5','Juan es genial!','2025-05-11 22:24:40',0),(7,12,46,'Vacunación próxima','Quedan 5 días para la vacunación de Daisy','2025-05-15 17:40:12',0),(8,1,33,'Desparasitación hoy','HOY es el día de desparasitación de Rex','2025-05-15 17:40:12',0),(12,25,NULL,'? ¡Logro desbloqueado: ? Conexión Mental!','Haz tu primera pregunta a Dogibot.','2025-05-15 21:56:21',1),(13,25,NULL,'? ¡Logro desbloqueado: ? El Despertar!','Desbloquea tu primer logro.','2025-05-15 21:56:21',1),(15,25,NULL,'¡Atención con hola!','Tu mascota hola tiene sobrepeso. Peso actual: 55.00 kg.','2025-05-17 08:32:49',1),(16,25,NULL,'? ¡Logro desbloqueado: ? Alfa del Clan!','Registra una mascota macho.','2025-05-17 08:32:49',1),(17,25,NULL,'? ¡Logro desbloqueado: ? Rostro de Héroe!','Sube una imagen de tu mascota.','2025-05-17 08:32:49',1),(18,25,NULL,'? ¡Logro desbloqueado: ?‍? El Guardián del Reino!','Tienes un Border Collie, el perro más inteligente y enérgico del reino.','2025-05-17 08:32:49',0),(20,25,NULL,'? ¡Logro desbloqueado: ? Nuevo Comienzo!','Registra una mascota de 0 años.','2025-05-17 08:41:02',0),(21,25,51,'¡Alerta con Brownie!','Tu mascota Brownie tiene infrapeso. Peso actual: 20.00 kg.','2025-05-17 09:04:53',0),(22,5,39,'Desparasitación próxima','Quedan 5 días para la desparasitación de Bella','2025-05-31 21:00:42',0),(25,1,NULL,'dsgfa','afds',NULL,NULL),(26,1,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(27,2,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(28,3,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(29,4,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(30,5,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(31,6,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(32,7,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(33,8,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(34,9,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(36,11,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(37,12,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(38,13,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(39,14,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(40,15,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(41,16,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(42,17,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(43,18,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(44,19,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(45,20,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(46,21,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(47,22,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(48,23,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(49,25,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL),(50,26,NULL,'Bienvenidos a Dogibot','Sois los jefes ahora! Vivan los perros :D',NULL,NULL);
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesos_mascota`
--

DROP TABLE IF EXISTS `pesos_mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pesos_mascota` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_mascota` int NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `peso` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_mascota` (`id_mascota`),
  CONSTRAINT `pesos_mascota_ibfk_1` FOREIGN KEY (`id_mascota`) REFERENCES `mascotas` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesos_mascota`
--

LOCK TABLES `pesos_mascota` WRITE;
/*!40000 ALTER TABLE `pesos_mascota` DISABLE KEYS */;
INSERT INTO `pesos_mascota` VALUES (1,1,'2025-05-02 09:09:11',18.00),(2,1,'2025-05-02 10:36:38',20.00),(3,1,'2025-05-02 11:34:29',18.00),(4,1,'2025-05-02 12:08:26',16.00),(5,1,'2025-05-11 23:00:14',50.00),(6,1,'2025-05-11 23:00:27',5.00),(7,1,'2025-05-11 23:14:36',15.00);
/*!40000 ALTER TABLE `pesos_mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntas` (
  `pregunta_id` int NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(255) NOT NULL,
  `respuesta` text,
  `audio_respuesta` varchar(255) DEFAULT NULL,
  `contador_consultas` int DEFAULT '0',
  `fecha_ultima_consulta` datetime DEFAULT NULL,
  `creado_por` int DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pregunta_id`),
  UNIQUE KEY `pregunta` (`pregunta`),
  KEY `creado_por` (`creado_por`),
  CONSTRAINT `preguntas_ibfk_1` FOREIGN KEY (`creado_por`) REFERENCES `empleados` (`empleado_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES (1,'¿Qué tipo de comida es mejor para mi perro?','Depende de la raza, edad y tamaño. Te recomendamos consultar con un veterinario para una dieta personalizada.',NULL,NULL,NULL,NULL,NULL),(2,'¿Cuántas veces al día debo alimentar a mi perro?','Lo ideal es 2 veces al día para adultos y 3-4 veces para cachorros, con porciones adecuadas a su tamaño.',NULL,1,NULL,NULL,'2023-10-01 00:00:00'),(3,'¿Qué debo hacer si mi perro no quiere comer?','Revisa si está estresado o enfermo. Si persiste, consulta a un veterinario para descartar problemas de salud.',NULL,1,NULL,NULL,'2023-10-01 00:00:00'),(4,'¿Cuánto ejercicio necesita mi perro al día?','Depende de la raza. Los perros activos necesitan al menos 1-2 horas de ejercicio, mientras que otros con menos energía pueden necesitar 30 minutos.',NULL,NULL,NULL,NULL,NULL),(5,'¿Cómo puedo saber si mi perro está enfermo?','Observa síntomas como falta de apetito, vómitos, diarrea o letargo. Si notas algo inusual, consulta a un veterinario.',NULL,NULL,NULL,NULL,NULL),(6,'¿Es necesario pasear a mi perro si tengo un jardín?','Sí, los paseos son importantes para su socialización, estimulación mental y ejercicio físico.',NULL,1,NULL,NULL,'2023-10-01 00:00:00'),(7,'¿Qué debo hacer si mi perro tiene sobrepeso?','Ajusta su dieta, reduce las golosinas y aumenta el ejercicio. Consulta a un veterinario para un plan específico.',NULL,1,NULL,NULL,'2023-10-01 00:00:00'),(8,'¿Puedo darle comida humana a mi perro?','Algunos alimentos son seguros, como zanahorias o manzanas, pero evita chocolate, cebolla y uvas, que son tóxicos.',NULL,1,NULL,NULL,'2023-10-01 00:00:00'),(9,'¿Cómo puedo entrenar a mi perro para pasear con correa?','Usa refuerzos positivos, como premios, y practica en un lugar tranquilo hasta que se acostumbre.',NULL,1,NULL,NULL,'2023-10-01 00:00:00'),(10,'¿Qué vacunas son esenciales para mi perro?','Las vacunas básicas incluyen rabia, moquillo y parvovirus. Consulta a un veterinario para un calendario completo.',NULL,1,NULL,NULL,'2023-10-01 00:00:00'),(11,'¿Hola?','¡Hola, amig@! ? ¿En qué puedo ayudarte hoy? ?',NULL,0,NULL,NULL,'2025-05-16 21:11:11'),(12,'¿Adiós?','¡Adiós! Espero que tengas un día maravilloso ??',NULL,0,NULL,NULL,'2025-05-16 21:11:11'),(13,'¿Cómo estás?','¡Estoy genial, gracias por preguntar! ¿Y tú? ??',NULL,0,NULL,NULL,'2025-05-16 21:11:11'),(14,'¿Gracias?','¡De nada! Estoy aquí para lo que necesites ?✨',NULL,0,NULL,NULL,'2025-05-16 21:11:11'),(15,'¿Qué hora es?','No tengo reloj, ¡pero siempre es hora de divertirse! ⏰?',NULL,0,NULL,NULL,'2025-05-16 21:11:11'),(16,'¿Cómo te llamas?','¡Soy Dogibot, tu amigo fiel y peludo! ??',NULL,0,NULL,NULL,'2025-05-16 21:11:11'),(17,'¿Jugar?','¡Sí! Me encanta jugar. ¿Quieres lanzar la pelota? ??',NULL,NULL,NULL,NULL,NULL),(20,'dsfas','sdafadf',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `razas`
--

DROP TABLE IF EXISTS `razas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `razas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `energia` tinyint DEFAULT NULL,
  `inteligencia` tinyint DEFAULT NULL,
  `socializacion` tinyint DEFAULT NULL,
  `cuidado` tinyint DEFAULT NULL,
  `peso_min_macho` decimal(5,2) NOT NULL,
  `peso_max_macho` decimal(5,2) NOT NULL,
  `peso_min_hembra` decimal(5,2) NOT NULL,
  `peso_max_hembra` decimal(5,2) NOT NULL,
  `edad_maxima` int NOT NULL,
  `descripcion` text NOT NULL,
  `dato_curioso` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  CONSTRAINT `razas_chk_1` CHECK ((`energia` between 1 and 5)),
  CONSTRAINT `razas_chk_2` CHECK ((`inteligencia` between 1 and 5)),
  CONSTRAINT `razas_chk_3` CHECK ((`socializacion` between 1 and 5)),
  CONSTRAINT `razas_chk_4` CHECK ((`cuidado` between 1 and 5))
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `razas`
--

LOCK TABLES `razas` WRITE;
/*!40000 ALTER TABLE `razas` DISABLE KEYS */;
INSERT INTO `razas` VALUES (1,'Border Collie',5,5,5,3,14.00,20.00,12.00,19.00,17,'Perro extremadamente inteligente y enérgico, ideal para el pastoreo.','Se considera la raza de perro más inteligente del mundo.'),(2,'Golden Retriever',4,4,5,3,27.00,34.00,25.00,32.00,15,'Perro amigable y versátil, popular como mascota familiar y perro de terapia.','Le encanta el agua y tiene una boca muy suave.'),(3,'Shiba Inu',4,3,3,4,8.00,11.00,6.00,9.00,16,'Raza japonesa independiente y enérgica con una fuerte personalidad.','Su \"sonrisa\" y su ladrido característico \"Shiba scream\" son famosos.'),(4,'King Charles Cavalier Spaniel',3,3,5,4,6.00,8.00,5.00,7.00,14,'Perro de compañía elegante y afectuoso, muy popular en la aristocracia británica.','Eran los perros favoritos de la realeza británica en el siglo XVII.'),(5,'Labrador Retriever',4,4,5,2,29.00,36.00,25.00,32.00,14,'Raza leal, obediente y versátil, usada en labores de asistencia.','Son propensos a la obesidad si no se controlan sus alimentos.'),(6,'Pastor Alemán',5,5,4,3,30.00,40.00,22.00,32.00,13,'Perro de trabajo valiente y leal, utilizado en policía y rescate.','Son excelentes aprendices y tienen un fuerte sentido del deber.'),(7,'Bulldog Francés',3,3,4,4,9.00,14.00,8.00,12.00,12,'Perro pequeño y robusto con una personalidad amigable.','Son conocidos por sus orejas de murciélago.'),(8,'Beagle',4,3,5,3,9.00,11.00,8.00,10.00,15,'Raza curiosa y amigable con un gran sentido del olfato.','Son famosos por su participación en pruebas de detección de olores.'),(9,'Dálmata',4,3,4,3,23.00,32.00,18.00,24.00,16,'Raza enérgica y distintiva por sus manchas.','Son propensos a la sordera congénita.'),(10,'Chihuahua',3,3,4,5,1.00,3.00,1.00,3.00,16,'Raza diminuta pero valiente y con gran personalidad.','Es la raza de perro más pequeña del mundo.'),(11,'San Bernardo',3,3,4,4,64.00,82.00,54.00,64.00,12,'Perro grande y fuerte, conocido por su papel en rescates alpinos.','Llevaban barriles de brandy en el cuello para ayudar a los montañistas.'),(12,'Akita Inu',4,3,3,4,32.00,45.00,25.00,38.00,14,'Raza japonesa noble y reservada, símbolo de lealtad.','El famoso perro Hachiko era un Akita Inu.'),(13,'Pug',3,2,5,5,6.00,9.00,6.00,8.00,15,'Perro pequeño y amigable con una cara arrugada característica.','Los emperadores chinos los adoraban en la antigüedad.'),(14,'Husky Siberiano',5,3,4,4,20.00,27.00,16.00,23.00,14,'Raza resistente y enérgica, criada para tirar de trineos.','Tienen ojos azules o de colores diferentes (heterocromía).');
/*!40000 ALTER TABLE `razas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recorridos`
--

DROP TABLE IF EXISTS `recorridos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recorridos` (
  `recorrido_id` int NOT NULL AUTO_INCREMENT,
  `mascota_id` int NOT NULL,
  `fecha` date NOT NULL,
  `distancia` int DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  PRIMARY KEY (`recorrido_id`),
  KEY `mascota_id` (`mascota_id`),
  CONSTRAINT `recorridos_ibfk_1` FOREIGN KEY (`mascota_id`) REFERENCES `mascotas` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recorridos`
--

LOCK TABLES `recorridos` WRITE;
/*!40000 ALTER TABLE `recorridos` DISABLE KEYS */;
INSERT INTO `recorridos` VALUES (1,1,'2025-05-11',0,0),(2,1,'2025-05-11',0,3),(3,1,'2025-05-11',0,0),(4,1,'2025-05-11',0,0),(5,1,'2025-05-11',0,0),(6,1,'2025-05-11',0,21),(7,50,'2025-05-11',0,0),(8,33,'2025-05-12',0,0),(9,1,'2025-05-11',0,0),(10,1,'2025-05-11',0,0),(11,1,'2025-05-11',0,0),(12,1,'2025-05-11',0,0),(13,1,'2025-05-11',0,0),(14,1,'2025-05-11',0,0),(15,1,'2025-05-11',0,1704),(16,50,'2025-05-11',0,0),(17,1,'2025-05-11',0,0),(18,1,'2025-05-11',0,0),(19,1,'2025-05-11',0,0),(20,1,'2025-05-11',0,0),(21,1,'2025-05-11',0,0),(22,1,'2025-05-11',0,0),(23,1,'2025-05-11',0,0),(24,1,'2025-05-11',0,0),(25,1,'2025-05-11',0,0),(26,1,'2025-05-11',0,0),(27,1,'2025-05-11',0,0),(28,1,'2025-05-11',0,0),(29,1,'2025-05-11',0,0),(30,1,'2025-05-11',0,0),(31,1,'2025-05-11',0,0),(32,1,'2025-05-11',0,0),(33,1,'2025-05-11',0,0),(34,1,'2025-05-11',0,0),(35,1,'2025-05-11',0,0),(36,1,'2025-05-11',0,0),(37,1,'2025-05-11',0,0),(38,1,'2025-05-11',0,0),(39,1,'2025-05-11',0,0),(40,1,'2025-05-11',0,0),(41,1,'2025-05-11',0,0),(42,1,'2025-05-11',0,0),(43,1,'2025-05-11',0,0),(44,1,'2025-05-11',0,0),(45,1,'2025-05-11',0,0),(46,1,'2025-05-11',0,0),(47,1,'2025-05-11',0,0),(48,1,'2025-05-11',0,0),(62,1,'2025-05-17',0,0),(63,1,'2025-05-17',0,0),(64,33,'2025-05-17',0,0),(65,1,'2025-05-17',0,0),(66,1,'2025-05-17',0,0),(67,1,'2025-05-17',0,0),(68,51,'2025-05-17',0,0),(69,1,'2025-05-17',0,0),(70,1,'2025-05-17',0,0),(71,1,'2025-05-17',0,0),(72,1,'2025-05-17',0,0),(73,1,'2025-05-17',0,0),(74,1,'2025-05-17',0,0),(75,1,'2025-05-17',0,0),(76,1,'2025-05-27',0,0),(77,1,'2025-05-27',0,0);
/*!40000 ALTER TABLE `recorridos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tareas`
--

DROP TABLE IF EXISTS `tareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tareas` (
  `id_tarea` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) DEFAULT NULL,
  `descripcion` text,
  `fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_vencimiento` date DEFAULT NULL,
  `prioridad` enum('Alta','Media','Baja') DEFAULT 'Media',
  `estado` enum('Abierta','Pendiente','EnProgreso','Completada','Cancelada') DEFAULT 'Pendiente',
  `id_empleado` int DEFAULT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`empleado_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareas`
--

LOCK TABLES `tareas` WRITE;
/*!40000 ALTER TABLE `tareas` DISABLE KEYS */;
INSERT INTO `tareas` VALUES (2,'Pregunta de usuario','Cuanto mide la Torre eiffel?\n\nSolicitada por: Cirdan7','2025-05-31 02:21:48','2025-06-07','Media','Abierta',1),(13,'Peso de pastor aleman incorrecto','Necesitamos actualizar el peso del pastor aleman.','2025-06-07 17:44:49','2025-06-14','Alta','EnProgreso',1);
/*!40000 ALTER TABLE `tareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` char(32) NOT NULL,
  `contador_preguntas` int DEFAULT '0',
  `latitud` decimal(9,6) DEFAULT NULL,
  `longitud` decimal(9,6) DEFAULT NULL,
  `valoracion` int DEFAULT NULL,
  `foto` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'JuanPerez','juanperez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,37.421998,-122.084000,3,1),(2,'MariaLopez','marialopez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(3,'CarlosGomez','carlosgomez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(4,'LauraMartinez','lauramartinez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(5,'PedroRamirez','pedroramirez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(6,'AnaTorres','anatorres@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(7,'LuisFernandez','luisfernandez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(8,'ElenaSanchez','elenasanchez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(9,'RobertoDiaz','robertodiaz@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(11,'JavierMolina','javiermolina@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(12,'CarmenRojas','carmenrojas@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(13,'AlbertoHerrera','albertoherrera@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(14,'PatriciaCastro','patriciacastro@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(15,'SergioOrtega','sergioortega@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(16,'BeatrizNavarro','beatriznavarro@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(17,'ManuelIglesias','manueliglesias@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(18,'CristinaMendez','cristinamendez@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(19,'RicardoSilva','ricardosilva@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(20,'IsabelRuiz','isabelruiz@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(21,'DavidSantos','davidsantos@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(22,'SofiaCabrera','sofiacabrera@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(23,'FernandoMarin','fernandomarin@email.com','81dc9bdb52d04dc20036dbd8313ed055',0,NULL,NULL,NULL,NULL),(25,'Cirdan7','raul291099@gmail.com','b59c67bf196a4758191e42f76670ceba',1,37.421998,-122.084000,0,15),(26,'usuario_prueba','lala','1234',0,37.450000,-123.084000,4,1),(28,'JuanPerez0','juanitopapasito','1234',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioslogros`
--

DROP TABLE IF EXISTS `usuarioslogros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarioslogros` (
  `usuario_id` int NOT NULL,
  `logro_id` int NOT NULL,
  `fecha_desbloqueo` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`usuario_id`,`logro_id`),
  KEY `logro_id` (`logro_id`),
  CONSTRAINT `usuarioslogros_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `usuarioslogros_ibfk_2` FOREIGN KEY (`logro_id`) REFERENCES `logros` (`logro_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioslogros`
--

LOCK TABLES `usuarioslogros` WRITE;
/*!40000 ALTER TABLE `usuarioslogros` DISABLE KEYS */;
INSERT INTO `usuarioslogros` VALUES (25,1,'2025-05-17 10:32:49'),(25,4,'2025-05-15 23:56:21'),(25,6,'2025-05-17 10:32:49'),(25,9,'2025-05-17 10:41:02'),(25,11,'2025-05-17 10:32:49'),(25,15,'2025-05-15 23:56:21');
/*!40000 ALTER TABLE `usuarioslogros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `valorado_id` int NOT NULL,
  `puntuacion` int NOT NULL,
  `comentario` text,
  `fecha_valoracion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  KEY `valoraciones_ibfk_2` (`valorado_id`),
  CONSTRAINT `valoraciones_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `valoraciones_ibfk_2` FOREIGN KEY (`valorado_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
INSERT INTO `valoraciones` VALUES (1,25,1,1,'Juan es mala gente','2025-05-11 19:02:59'),(2,25,1,3,'Juan es un encanto de persona pero su pero no :(','2025-05-11 19:34:42');
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-08 20:35:04
