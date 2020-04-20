DROP schema IF exists `nimhans`;
CREATE SCHEMA `nimhans`;
USE `nimhans`;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`(
	`ehr_id` int(11) NOT NULL AUTO_INCREMENT,
    `pname` varchar(30) DEFAULT NULL,
    `pcontact` varchar(10) DEFAULT NULL,
    `age` int(3) DEFAULT NULL,
    `gender` varchar(10) DEFAULT NULL,
    `doctor` int(11) DEFAULT NULL,
    
    FOREIGN KEY (`doctor`) REFERENCES `doctor` (`emp_id`),
    PRIMARY KEY(`ehr_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`(
	`uh_id` int(11) NOT NULL,
    primary key(`uh_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `ehrid_uhid_mapper`;
CREATE TABLE `ehrid_uhid_mapper`(	
	`ehr_id` int(11) NOT NULL,
	`uh_id` int(11) NOT NULL,
    PRIMARY KEY(`ehr_id` ,`uh_id`),
    
    FOREIGN KEY(`ehr_id`) REFERENCES `patient`(`ehr_id`),
    FOREIGN KEY(`uh_id`) REFERENCES `demo`(`uh_id`)    
    
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`(
	`emp_id` int(11) NOT NULL AUTO_INCREMENT,
	`dname` varchar(30) DEFAULT NULL,
	`dcontact` varchar(15) DEFAULT NULL,
	`demail` varchar(20) DEFAULT NULL,
	`daddress` varchar(50) DEFAULT NULL,
    
	PRIMARY KEY (`emp_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `encounter`;
CREATE TABLE `encounter`(
	`eid` int(11) NOT NULL AUTO_INCREMENT,
	`ehr_id` int(11) DEFAULT NULL,
	`emp_id` int(11) DEFAULT NULL,
	`start_date` DATE DEFAULT NULL,
	`closed_date` DATE DEFAULT NULL,
	`clinical_id` int(11) DEFAULT NULL,
	`neurological_id` int(11) DEFAULT NULL,
	`physical_id` int(11) DEFAULT NULL,
	`demo_id` int(11) DEFAULT NULL,
	`discharge_id` int(11) DEFAULT NULL,
	`flag` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`eid`),
    FOREIGN KEY (`emp_id`) REFERENCES `doctor` (`emp_id`),
    FOREIGN KEY (`ehr_id`) REFERENCES `patient` (`ehr_id`),
    FOREIGN KEY (`clinical_id`) REFERENCES `clinical_details` (`clinical_id`),
    FOREIGN KEY (`neurological_id`) REFERENCES `neurological_details` (`neuro_id`),
    FOREIGN KEY (`physical_id`) REFERENCES `physical_details` (`physical_id`),
    FOREIGN KEY (`discharge_id`) REFERENCES `discharge_details` (`discharge_id`),
    FOREIGN KEY (`demo_id`) REFERENCES `demographic_details` (`demo_id`)

	ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE= InnoDB auto_increment=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `clinical_details`;
CREATE TABLE `clinical_details` (
	`clinical_id` int(11) NOT NULL AUTO_INCREMENT,    
	`data` json DEFAULT NULL,
    
-- 	`line23` boolean DEFAULT NULL,
--     `line24_duration` int(3) DEFAULT NULL,
--     `line24` varchar(400) DEFAULT NULL,
--     `line25` varchar(400) DEFAULT NULL,
--     `line26` varchar(400) DEFAULT NULL,
--     `line27` varchar(400) DEFAULT NULL,
--     `name_of_resident` varchar(30) DEFAULT NULL,
    
	PRIMARY KEY (`clinical_id`)    
)ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `discharge_details`;
CREATE TABLE `discharge_details` (
	`discharge_id` int(11) NOT NULL AUTO_INCREMENT,
    
	`data` json DEFAULT NULL,
-- 	`line28` varchar(400) DEFAULT NULL,
--     `line29_treatment` varchar(400) DEFAULT NULL,
--     `line29_option1` boolean DEFAULT FALSE,
--     `line29_option2` boolean DEFAULT FALSE,
	
    PRIMARY KEY (`discharge_id`)
)ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `physical_details`;
CREATE TABLE `physical_details`(
	`physical_id` int(11) NOT NULL AUTO_INCREMENT,    
	`data` json DEFAULT NULL,
-- `rta` boolean DEFAULT FALSE,
-- 	`fall` boolean DEFAULT FALSE,
--     `assault` boolean DEFAULT FALSE,
--     `other` boolean DEFAULT FALSE,
--     `driver` boolean DEFAULT FALSE,
--     `passenger` boolean DEFAULT FALSE,
--     `pedestrian` boolean DEFAULT FALSE,
--     `helmet` boolean DEFAULT FALSE,
--     `alcohol` boolean DEFAULT FALSE,
--     
--     `loss_of_conscious` boolean DEFAULT FALSE,
--     `lucid_interval` boolean DEFAULT FALSE,
--     `seizures` boolean DEFAULT FALSE,
--     `vomiting` boolean DEFAULT FALSE,
--     `amnesia` boolean DEFAULT FALSE,
--     `bleeding_ear` boolean DEFAULT FALSE,
--     `bleeding_nose` boolean DEFAULT FALSE,
--     
--     `airway_on_arrival_clear` boolean DEFAULT FALSE,
--     `airway_on_arrival_requires_intubation` boolean DEFAULT FALSE,
--     `spontaneous_respiration_normal` boolean DEFAULT FALSE,
--     `spontaneous_respiration_tachypnoeic` boolean DEFAULT FALSE,
--     `spontaneous_respiration_gasping` boolean DEFAULT FALSE,
--     
--     `pulse_rate` int(4) DEFAULT null,
--     
--     `carotid_pulsations_right` boolean DEFAULT FALSE,
--     `carotid_pulsations_left` boolean DEFAULT FALSE,
--     
--     `blood_pressure_on_arrival` int(4) DEFAULT null,
--     
--     `blood_pressure_after_half_hour` int(4) DEFAULT null,
--     
--     `csf_rhinorrhoea` boolean DEFAULT FALSE,
--     `otorrhoea` boolean DEFAULT FALSE,
--     `active_peripheral_bleeding` boolean DEFAULT FALSE,
--     `fractures` boolean DEFAULT FALSE,
--     `peripheral_pulses` boolean DEFAULT FALSE,
--     `chest_injury` boolean DEFAULT FALSE,
--     `abdominal_injury` boolean DEFAULT FALSE,
--     `wounds` boolean DEFAULT FALSE,
--     
--     `spinal_tenderness` boolean DEFAULT FALSE,
--     `spinal deformity` boolean DEFAULT FALSE,
    
    PRIMARY KEY (`physical_id`)
)ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `demographic_details`;
CREATE TABLE `demographic_details`(
`demo_id` int(11) NOT NULL AUTO_INCREMENT,
`data` json DEFAULT NULL,
-- `ehr_id` int(11) DEFAULT NULL,
-- `referred_from` varchar(30) DEFAULT NULL,
-- `date_of_examination` DATE DEFAULT NULL,
-- `time_of_examination` time DEFAULT NULL,
-- `place_of_injury` varchar(50) DEFAULT NULL,
-- `eyewitness` boolean DEFAULT FALSE,
-- `hearsay` boolean DEFAULT FALSE,

PRIMARY KEY (`demo_id`)
)ENGINE= InnoDB auto_increment=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `neurological_details`;
CREATE TABLE `neurological_details`(
`neuro_id` int(11) NOT NULL AUTO_INCREMENT,
`data` json DEFAULT NULL,
-- `eyes_opening_score_initial` int(1) DEFAULT NULL,
-- `eyes_opening_score_after` int(1) DEFAULT NULL,
-- `motor_response_score_initial` int(1) DEFAULT NULL,
-- `motor_response_score_after` int(1) DEFAULT NULL,
-- `verbal_response_score_initial` int(1) DEFAULT NULL,
-- `verbal_response_score_after` int(1) DEFAULT NULL,
-- `line19_right` int(1) DEFAULT NULL,
-- `line19_left` int(1) DEFAULT NULL,
-- `line20_left_val` int(3) DEFAULT NULL,
-- `line20_left_reaction` int(2) DEFAULT NULL,
-- `line20_right_val` int(3) DEFAULT NULL,
-- `line20_right_reaction` int(2) DEFAULT NULL,
-- `line21_utr` varchar(50) DEFAULT NULL,
-- `line21_utl` varchar(50) DEFAULT NULL,
-- `line21_upr` varchar(50) DEFAULT NULL,
-- `line21_upl` varchar(50) DEFAULT NULL,
-- `line21_ltr` varchar(50) DEFAULT NULL,
-- `line21_ltl` varchar(50) DEFAULT NULL,
-- `line21_lpr` varchar(50) DEFAULT NULL,
-- `line21_lpl` varchar(50) DEFAULT NULL,
-- `line22` varchar(200) DEFAULT NULL,

PRIMARY KEY (`neuro_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- DROP TABLE IF EXISTS `authorities`;
-- CREATE TABLE `authorities`(
-- 	`username` varchar(50) NOT NULL,
--     `authority` varchar(50) NOT NULL,
--     UNIQUE KEY `auth_idx` (`username`,`authority`),
--     CONSTRAINT `auth_fk` FOREIGN KEY (`username`) REFERENCES `users`(`username`)
-- )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- DROP TABLE IF EXISTS `users`;
-- CREATE TABLE `users`(
-- 	`username` varchar(50) NOT NULL,
--     `password` varchar(100) NOT NULL,
--     `enabled` tinyint(1) NOT NULL,
--     
--     PRIMARY KEY(`username`)
-- )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users_auth`;
CREATE TABLE `users_auth`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(50) NOT NULL,
    `password` varchar(100) NOT NULL,
    `role` varchar(100) NOT NULL,
    
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS=1;

INSERT INTO `nimhans`.`users_auth` (`username`, `password`, `role`) VALUES ('doc_0', '$2a$10$v4CGBCwvFdi8CBr6fZNGFOsjpLX4g42QdyJAI/fAPM10KHuCorLAG', 'ROLE_DOCTOR');
INSERT INTO `nimhans`.`users_auth` (`username`, `password`, `role`) VALUES ('doc_1', '$2a$10$v4CGBCwvFdi8CBr6fZNGFOsjpLX4g42QdyJAI/fAPM10KHuCorLAG', 'ROLE_DOCTOR');
INSERT INTO `nimhans`.`users_auth` (`username`, `password`, `role`) VALUES ('doc_2', '$2a$10$v4CGBCwvFdi8CBr6fZNGFOsjpLX4g42QdyJAI/fAPM10KHuCorLAG', 'ROLE_DOCTOR');
INSERT INTO `nimhans`.`users_auth` (`username`, `password`, `role`) VALUES ('doc_3', '$2a$10$v4CGBCwvFdi8CBr6fZNGFOsjpLX4g42QdyJAI/fAPM10KHuCorLAG', 'ROLE_DOCTOR');
INSERT INTO `nimhans`.`users_auth` (`username`, `password`, `role`) VALUES ('doc_4', '$2a$10$v4CGBCwvFdi8CBr6fZNGFOsjpLX4g42QdyJAI/fAPM10KHuCorLAG', 'ROLE_DOCTOR');

