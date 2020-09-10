DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE `ingredient` (
  `id` varchar(4) NOT NULL,
  `name` varchar(25) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `taco`;
CREATE TABLE `taco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `taco_ingredients`;
CREATE TABLE `taco_ingredients` (
  `taco_id` bigint(20) NOT NULL,
  `ingredients_id` varchar(4) NOT NULL,
  KEY `taco` (`taco_id`),
  KEY `ingredient` (`ingredients_id`),
  CONSTRAINT `taco_ingredients_ibfk_1` FOREIGN KEY (`taco_id`) REFERENCES `taco` (`id`),
  CONSTRAINT `taco_ingredients_ibfk_2` FOREIGN KEY (`ingredients_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `taco_order`;
CREATE TABLE `taco_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zip` varchar(10) NOT NULL,
  `cc_number` varchar(16) NOT NULL,
  `cc_expiration` varchar(5) NOT NULL,
  `cccvv` varchar(3) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `taco_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `taco_order_tacos`;
CREATE TABLE `taco_order_tacos` (
  `order_id` bigint(20) NOT NULL,
  `tacos_id` bigint(20) NOT NULL,
  KEY `tacoOrder` (`order_id`),
  KEY `taco` (`tacos_id`),
  CONSTRAINT `taco_order_tacos_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `taco_order` (`id`),
  CONSTRAINT `taco_order_tacos_ibfk_2` FOREIGN KEY (`tacos_id`) REFERENCES `taco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `fullname` varchar(20) DEFAULT NULL,
  `street` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
