CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `user_t`(`id`,`user_name`,`password`,`age`) values (1,'测试','sfasgfaf',24);

CREATE TABLE `cooperative_base_info` (
  `id` varchar(32) NOT NULL,
  `cooperativeno` varchar(32) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `gender` binary(1) DEFAULT '0' COMMENT '性别0：女 ，1,：男',
  `age` int(3) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `visitordate` varchar(10) DEFAULT NULL,
  `invoiceno` varchar(32) DEFAULT NULL,
  `compensateamount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;