CREATE TABLE `customer` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `firstName` varchar(255) DEFAULT NULL,
                            `lastName` varchar(255) DEFAULT NULL,
                            `dlNumber` varchar(25) DEFAULT NULL,
                            `zipcode` varchar(50) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;