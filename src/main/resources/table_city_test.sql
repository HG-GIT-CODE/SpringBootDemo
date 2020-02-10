
drop table if EXISTS city_test;

CREATE TABLE `city_test` (
  `id` int(11) NOT NULL,
  `province_id` int(11) DEFAULT NULL,
  `city_name` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `test` decimal(11,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8