CREATE TABLE `grade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

INSERT INTO `grade` (name, type, score, total)
VALUES ('Jon Ralpheo', 'Quiz', 5, 10);
INSERT INTO `grade` (name, type, score, total)
VALUES ('Dwight Schrute', 'Assignment', 8, 10);
INSERT INTO `grade` (name, type, score, total)
VALUES ('Sam Winchester', 'Test', 25, 25);