CREATE TABLE `rent` (
                        `rentId` int(11) NOT NULL AUTO_INCREMENT,
                        `currentOdometer` int(11) NOT NULL,
                        `customerId` int(11) NOT NULL,
                        `rentFrom` datetime(6) DEFAULT NULL,
                        `rentTill` datetime(6) DEFAULT NULL,
                        `returnLocation` varchar(255) DEFAULT NULL,
                        `vehicleId` int(11) NOT NULL,
                        PRIMARY KEY (`rentId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
