-- MySQL dump 10.13  Distrib 5.6.19, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: Ademme
-- ------------------------------------------------------
-- Server version	5.5.59-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `Igreja`
--

LOCK TABLES `Igreja` WRITE;
/*!40000 ALTER TABLE `Igreja` DISABLE KEYS */;
INSERT INTO `Igreja` VALUES (1,'2000-01-01','estrutural ','SEDE','Melque','1'),(2,'2007-09-01','SOBRADINHO 2','VILA RABELO','MOÍSES','2'),(3,'2009-12-01','estrututral','QUADRA 15','Elias','1'),(4,'2011-09-01','são sebastião','SÃO SEBASTIÃO','Guto','3'),(5,'2013-09-09','jardim ínga','JARDIN INGÁ','ABRÃO','4'),(6,'2005-01-21','sobradinho','SOBRADINHO','ALBERTO','5'),(7,'2007-02-01','ibirapitanga','IBIRAPITANGA','leo','6'),(8,'2008-12-12','minas gerais','MINAS GERAIS','joão','6'),(9,'2013-09-09','aguas lindas','ÁGUAS LINDAS','cláudio','8'),(10,'2015-08-09','piabanha','PIABANHA','daniel','9'),(11,'2014-03-09','bahia','ILHÉUS','elizeu','10'),(12,'2007-09-23','uabitaba','UBAITABA','jonas','11'),(13,'2018-09-23','CAMPO FORMOSO','CAMPO FORMOSO','marquinhos','12');
/*!40000 ALTER TABLE `Igreja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Membro`
--

LOCK TABLES `Membro` WRITE;
/*!40000 ALTER TABLE `Membro` DISABLE KEYS */;
INSERT INTO `Membro` VALUES (1,'\0','/opt/Ademme/Uploads/2-123.232.png','pastor','(11) 11111-1111','BRASÍLIA','11','11111111111','2018-02-03','2018-02-08','2018-02-28','11','1','2018-02-04','Ensino Fundamental','DF','Casado',NULL,11,'xxxxxx','auda','1','gilead','josue','1','2-123.232','Masculino','(11) 11111-1111',3),(3,'','/opt/Ademme/Uploads/3-333.333.png','pastor','(33) 33333-3333','PLANALTINA','3','33333333333','2018-02-21','2018-02-28','2018-02-20','33','3','2018-02-18','','DF','',NULL,33,'333','33','3','rone','33','3','3-333.333','Masculino','(33) 33333-3333',1),(4,'','/tmp/6154689767344841133.tmp','diaconisa','(44) 44444-4444','PLANALTINA','4','44444444444','2018-02-21','2018-02-21','2018-02-28','4','4','2018-02-26','Ensino Médio','DF','Solteiro',NULL,44,'444','4','4','eliete','4','4','4-444.444','Masculino','(44) 44444-4444',5),(5,'\0','/opt/Ademme/Uploads/5-555.555.png','pastor','(55) 55555-5555','TAGUATINGA','5','55555555555','2018-02-07','2018-02-09','2018-02-09','55','5555','2018-02-04','Ensino Fundamental','DF','Solteiro',NULL,55,'555','55','5','joao','55','5','5-555.555','Masculino','(55) 55555-5555',5),(6,'','/tmp/24555985378751971.tmp','pastor','(66) 66666-6666','','6','66666666666','2018-02-14','2018-02-08','2018-02-08','','6','2018-02-07','','','',NULL,0,'6','66','6','jonas','66','6','6-666.666','Masculino','(66) 66666-6666',2),(7,'\0','/tmp/2467556606720571144.tmp','pastor','(77) 77777-7777','','7','77777777777','2018-02-06','2018-02-02','2018-02-01','','777','2018-02-14','','','',NULL,0,'77','7','7','abrao','7','7','7-777.777','Masculino','(77) 77777-7777',5),(9,'\0','/tmp/6814750565626541810.tmp','missionário','(12) 22222-2222','','12','12222222222','2018-02-27','2018-02-01','2018-02-07','','12','2018-02-27','','','',NULL,0,'21','11','12','andreia','11','12','1-222.222','Feminino','(12) 11122-2222',4),(10,'\0','/tmp/4253228938395558048.tmp','pastor','(13) 33333-3333','','13','13333333333','2018-02-14','2018-02-02','2018-02-08','','13','2018-02-20','','','',NULL,0,'xxx','13','13','nicholas','13','13','1-333.333','Masculino','(13) 33333-3333',8),(12,'','/tmp/8621908496327360863.tmp','diácono','(15) 55555-5555','','15','15555555555','2018-02-22','2018-02-21','2018-02-01','','15','2018-02-06','','','',NULL,0,'15','15','15','adriano','15','15','1-555.555','Masculino','(15) 55555-5555',10),(13,'','/tmp/6086796469649055018.tmp','missionário','(16) 66666-6666','','ee','16666666666','2018-02-28','2018-02-22','2018-02-28','','16','2018-02-27','','','',NULL,0,'eee','ee','ee','elizeu','ee','ee','1-666.666','Masculino','(16) 66666-6666',11),(14,'\0','/tmp/3971627456575047374.tmp','auxiliar','(17) 77777-7777','','gg','17777777777','2018-02-08','2018-02-28','2018-02-28','','676','2018-02-14','','','',NULL,0,'dfg','gg','gff','leandro','gg','dgfg','1-777.777','Masculino','(17) 77777-7777',12),(15,'\0','/tmp/9153391802729175657.tmp','auxiliar','(18) 88888-8888','PLANALTINA','ss','18888888888','2018-02-15','2018-02-22','2018-02-26','ss','18','2018-02-07','Ensino Fundamental','DF','Solteiro',NULL,55,'ss','ss','ss','diego','ss','ss','1-888.888','Masculino','(18) 88888-8888',13),(16,'\0','/tmp/1117413849703463889.tmp','diácono','(18) 88888-8888','BRASÍLIA','fd','18888888888','2018-02-13','2018-02-22','2018-02-20','dfs','1888','2018-02-07','Ensino Médio','DF','Casado',NULL,43,'xxxxxx','dd','fd','marcio','dd','fsddf','1-888.888','Masculino','(18) 88888-8888',4),(17,'\0','/opt/Ademme/Uploads/1-999.999.png','','(21) 32312-3123','','2','19999999999',NULL,NULL,NULL,'','232',NULL,'','','',NULL,12,'','5','2','ana','2','23','1-999.888','Feminino','(23) 21233-3333',2),(19,'\0','/tmp/6568435360190934969.tmp','bispo','(11) 11111-1111','BRASÍLIA','1','22222222200',NULL,'2018-02-23','2018-02-10','1','1',NULL,'Ensino Fundamental','DF','Solteiro',NULL,45,'','32','1','TESTE','32','1','2-222.200','Masculino','(11) 11111-1111',1),(22,'','/opt/Ademme/Uploads/9-090.900.png','pastor','(11) 11111-1111','BRASÍLIA','teste 11','99999999998','2017-10-01','2018-03-04','1993-06-04','teste@gmail.com','estrutural','2000-01-01','Ensino Superior','DF','Casado',NULL,32,'xxxxx','ana','brasileiro','teste 22','adao','mecanico','9-090.900','Masculino','(11) 11111-1111',6),(24,'\0','/opt/Ademme/Uploads/2-323.232.png','','(22) 22222-2222','','','88888888887',NULL,NULL,NULL,'','',NULL,'','DF','',NULL,0,'','','brasil','erinaldo','232','','2-323.232','Masculino','',3),(25,'','/tmp/3013549208937042817.tmp','','(99) 99999-9999','BRASÍLIA','kkkk','00000000003','2018-03-14','2018-03-14','2018-03-14','xxxxxx','99','2018-03-11','Ensino Superior','','Casado',NULL,78,'xxxxx','mmm','bsb','teste 09','sss','99','0-000.003','Masculino','(99) 99999-9999',6),(26,'','/tmp/4401476187670336667.tmp','','(66) 66666-6666','','','00000000022',NULL,NULL,NULL,'','66',NULL,'Ensino Fundamental','','',NULL,0,'','w','','teste igreja 15','we','','0-000.022','Masculino','(66) 66666-6666',3),(27,'','/tmp/4155483323891332272.tmp','','','','','00000000033',NULL,NULL,NULL,'','',NULL,'','','',NULL,0,'','','','teste4','','','1-212.212','','(90) 00000-0000',3),(28,'','/tmp/7059372917595530602.tmp','','','','','00000000044',NULL,NULL,NULL,'','',NULL,'','','',NULL,12,'','','','teste q 15','','','6-666.667','Masculino','',3),(29,'','/tmp/7232848518621240552.tmp','missionária','','','','11111111112',NULL,NULL,NULL,'','',NULL,'','','',NULL,0,'','','','teste sede','','','2-323.332','','(22) 22222-2222',1),(30,'','/tmp/2428271712017114730.tmp','','','BRASÍLIA','','66666666665',NULL,NULL,NULL,'','',NULL,'','DF','',NULL,0,'','','','teste de sao','','','4-466.664','','',4);
/*!40000 ALTER TABLE `Membro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Tarefa`
--

LOCK TABLES `Tarefa` WRITE;
/*!40000 ALTER TABLE `Tarefa` DISABLE KEYS */;
INSERT INTO `Tarefa` VALUES (1,'2018-03-09 02:17:13','tesdcgthvjbknml,ç.',NULL,'ANDAMENTO','teste de teste');
/*!40000 ALTER TABLE `Tarefa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'','04907660138','25/09/1993','ronecosac@gmail.com','santa luzia','Rone Farias','202cb962ac59075b964b07152d234b70','Masculino','(61) 98608-5743','A'),(7,'','23735039804','11/11/1111','','1','nel','bad6539dfb452b7c43fcff4dfaea9bbb','Masculino','(11) 11111-1111','A');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_produto`
--

LOCK TABLES `tb_produto` WRITE;
/*!40000 ALTER TABLE `tb_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-13 17:11:50
