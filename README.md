Al ejecutar el backend la base de datos de genera sola, sin embargo este es el script y las inserciones
-------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `activos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activos` (
  `cod_activo` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `marca_cod_marca` bigint DEFAULT NULL,
  PRIMARY KEY (`cod_activo`),
  KEY `FKlxygq4d1vdgpmaj6s0umvhj1w` (`marca_cod_marca`),
  CONSTRAINT `FKlxygq4d1vdgpmaj6s0umvhj1w` FOREIGN KEY (`marca_cod_marca`) REFERENCES `marcas` (`cod_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `activos` WRITE;
/*!40000 ALTER TABLE `activos` DISABLE KEYS */;
INSERT INTO `activos` VALUES (1,'Pc','Bueno','Referenceuno',1),(2,'Teclado','Malo','Referencedos',1);
/*!40000 ALTER TABLE `activos` ENABLE KEYS */;
UNLOCK TABLES;

-------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `cod_marca` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'HP');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;
-------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `cod_movimiento` bigint NOT NULL AUTO_INCREMENT,
  `fecha_mov` bigint DEFAULT NULL,
  `origen` varchar(255) DEFAULT NULL,
  `activos_cod_activo` bigint DEFAULT NULL,
  `ubicacion_cod_ubicacion` bigint DEFAULT NULL,
  `activo_cod_activo` bigint DEFAULT NULL,
  PRIMARY KEY (`cod_movimiento`),
  KEY `FKqivg61r60fbjoukljycrgc3d3` (`activos_cod_activo`),
  KEY `FKsfjaootoyx9e24f6ixj7h6bbx` (`ubicacion_cod_ubicacion`),
  KEY `FKpmi210134815x6u97ujqx3usd` (`activo_cod_activo`),
  CONSTRAINT `FKpmi210134815x6u97ujqx3usd` FOREIGN KEY (`activo_cod_activo`) REFERENCES `activos` (`cod_activo`),
  CONSTRAINT `FKqivg61r60fbjoukljycrgc3d3` FOREIGN KEY (`activos_cod_activo`) REFERENCES `activos` (`cod_activo`),
  CONSTRAINT `FKsfjaootoyx9e24f6ixj7h6bbx` FOREIGN KEY (`ubicacion_cod_ubicacion`) REFERENCES `ubicaciones` (`cod_ubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,3032023,'Cali',1,1,1),(2,29032021,'Cali',1,1,1);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;
-------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `ubicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ubicaciones` (
  `cod_ubicacion` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_ubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `ubicaciones` WRITE;
/*!40000 ALTER TABLE `ubicaciones` DISABLE KEYS */;
INSERT INTO `ubicaciones` VALUES (1,'Bogota');
/*!40000 ALTER TABLE `ubicaciones` ENABLE KEYS */;
UNLOCK TABLES;
