CREATE TABLE `vehicle` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `color` varchar(255) DEFAULT NULL,
                           `make` varchar(255) DEFAULT NULL,
                           `model` varchar(255) DEFAULT NULL,
                           `odometerValueOnRegister` int(11) NOT NULL,
                           `type` varchar(255) DEFAULT NULL,
                           `year` int(11) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
