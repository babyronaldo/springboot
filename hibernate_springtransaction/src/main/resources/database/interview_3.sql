-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 08, 2019 at 05:38 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `interview_3`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE `candidate` (
  `candidateId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `skill` varchar(100) NOT NULL,
  `uniName` varchar(100) NOT NULL,
  `gpa` float NOT NULL,
  `graduateYear` varchar(4) NOT NULL,
  `dayOfBirth` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(20) NOT NULL,
  `address` varchar(250) NOT NULL,
  `degree` varchar(20) NOT NULL,
  `isDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`candidateId`, `name`, `skill`, `uniName`, `gpa`, `graduateYear`, `dayOfBirth`, `email`, `phone`, `address`, `degree`, `isDeleted`) VALUES
(28, 'Solskjae5', 'Position, React', 'Nauy', 8.8, '2009', '1973-02-23', 'ole@mu.vn', 5646789, 'ManchesterU', 'Legend', NULL),
(29, 'Nistelrooy', 'Shooting', 'Amstedam', 9, '2008', '1990-02-26', 'asd@asd.com', 879879, 'Holandddd', 'Footballer', NULL),
(30, 'Paul Scholes', 'Passing', 'Old Trardford', 8.8, '1999', '1974-08-09', 'paul@mu.bt', 879879, 'Dream Thread', 'Legend', NULL),
(31, 'Ibrahimovic Zlatan', 'Five stars', 'Sweden', 5.5, '2013', '1982-10-10', 'zlatan@asd.sw', 87987954, 'PSG', 'Master', NULL),
(32, 'Ander Herrera4', 'Ball controll', 'Althetic Bilbao', 7.7, '2012', '1989-02-01', 'herrera@cm.mu', 98456136, 'Bilbao, Spain', 'Bachelor', NULL),
(33, 'Anthony Martial', 'Dribling', 'Monaco', 6.8, '2016', '1995-02-26', 'martial@mano.fr', 93216547, 'Monaco - France', 'Bachelor', NULL),
(34, 'Marcus Rardford4', ' Acceleration', 'Manchester Uni', 7.5, '2017', '1997-02-25', 'marcus@mu.br', 98721649, 'England', 'Bachelor', NULL),
(35, 'David De Gea', 'React', 'AtleticoMadrid', 9.5, '2011', '1990-02-26', 'degea@gk.mu', 98736789, 'Spain', 'Bachelor', NULL),
(36, 'Paul Pogba', 'Ball Controll', 'Manchester', 8.2, '2010', '1993-10-10', 'pogba@cm.mu', 9842187, 'France', 'Bachelor', NULL),
(38, 'Marcus Rojo', 'Defence', 'SportingLisbon', 7, '2012', '1990-02-26', 'rojo@df.mu', 87243466, 'Argentina', 'Bachelor', NULL),
(39, 'Phil Jones', '8.8', 'Blackburn', 8.2, '2014', '1992-06-03', 'jones@df.mu', 987546798, 'England', 'Bachelor', NULL),
(40, 'Marteo Darmian', 'Defence', 'Torino', 75, '2015', '1989-05-05', 'darmian@df.mu', 654987364, 'Italia', 'Bachelor', NULL),
(41, 'Antonio Valencia', 'Speed Winger', 'Wigan', 7.7, '2007', '1985-05-05', 'valencia@df.mu', 978431654, 'Columbia', 'Bachelor', NULL),
(42, 'Luke Shaw', 'Speed LB', 'Southampton', 7.8, '2017', '1995-05-06', 'shaw@df.mu', 987642483, 'England', 'Bachelor', NULL),
(43, 'Chris Smalling', 'Defence', 'Fullham', 7.5, '2015', '1989-06-25', 'smalling@df.mu', 98754983, 'England', 'Bachelor', NULL),
(44, 'Nemanja Vidic', 'Defence', 'Unknown', 8.9, '2006', '1982-11-25', 'vidic@df.mu', 98761679, 'Sebia', 'Legend', NULL),
(45, 'Rio Ferdinand', 'Defence', 'LeedUnited', 8.9, '2005', '1979-10-10', 'rio@df.mu', 987541431, 'England', 'Master', NULL),
(46, 'Edwin Van de Sar', 'Reflexes', 'Fullham', 9.9, '2004', '1978-03-01', 'desar@gk.mu', 987321464, 'Holand', 'Master', NULL),
(47, 'Cristiano Ronaldo', 'Perfect', 'SportingLisbon', 9.9, '2008', '1985-05-02', 'cris@mf.mu', 987561879, 'Portugal', 'Legend', NULL),
(48, 'Ashley Young', 'Dribbling', 'Aston Villa', 7, '2014', '1990-02-26', 'lukhach@gm.com', 91994566, 'England', 'Doctor', NULL),
(49, 'Michale Carrick', 'Passing', 'Tottenham', 8.6, '2016', '1983-06-15', 'carrick@mf.mu', 987654167, 'Tottenham - England', 'MBA', NULL),
(50, 'Park Ji Sung', 'Physical', 'PSV', 8.5, '2015', '1980-11-23', 'park@mf.mu', 98989898, 'Korea', 'MBA', NULL),
(51, 'Daley Blin', 'Long Passing', 'PSV', 7.7, '2015', '1990-04-01', 'blind@df.mu', 987987987, 'PSV - Holland', 'Bachelor', NULL),
(52, 'Bastian Schweinsteiger', 'Long Shot', 'Bayen Munich', 8.5, '2015', '1983-08-08', 'basti@mf.mu', 85647321, 'Germany', 'MBA', NULL),
(53, 'Henrik Mkhytarian', 'Dribling', 'Dordmund', 9, '2015', '1989-11-21', 'henrik@mf.mu', 31897565, 'Armenia', 'MBA', NULL),
(54, 'asd', 'asd', 'asd', 0, '2015', '1990-02-26', 'ole@mu.vn', 0, 'asd', 'asd', NULL),
(57, 'Bill Clinton', 'Java', 'Oxford', 8.2, '1999', '1973-02-26', 'clinton@usa.com', 987193564, 'New York', 'Master', NULL),
(59, 'Donal Trump', 'Java', 'Harvard', 0, '2000', '1950-02-02', 'Clinton@usa.com', 98761436, 'WhiteHouse', 'Big Boss', NULL),
(62, 'aaaa', 'Shoot', 'asd', 0, '2009', '1973-02-26', 'asd@asd.com', 0, 'Cambodia', 'Master', NULL),
(63, 'asd', 'Shoot', 'asd', 0, '2009', '1973-02-26', 'ole@mu.vn', 0, 'asd', 'Master', NULL),
(64, 'Paul Scholes', 'Shoot', 'asd', 0, '2009', '1973-02-26', 'asd@asd.com', 0, 'asd', 'Master', NULL),
(65, 'Paul Scholes', 'Shoot', 'asd', 0, '2009', '1973-02-26', 'asd@asd.com', 0, 'asd', 'Master', NULL),
(66, 'Paul Scholes', 'Shoot', 'asd', 0, '2009', '1973-02-26', 'asd@asd.com', 0, 'asd', 'Master', NULL),
(67, 'asd', 'Shoot', 'asd', 0, '2009', '1973-02-26', 'asd@asd.com', 0, 'Cambodia', 'Master', NULL),
(68, 'asd', '.Net', 'asd', 0, '2009', '1973-02-26', 'asd@asd.com', 4534, 'asd', 'asd', NULL),
(69, 'Thân Quang Hi?n', ' Acceleration', 'Manchester Uni', 0, '2017', '1989-02-04', 'hien.thanquang@gmail.com', 1, 'England', 'Bachelor', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `interview`
--

CREATE TABLE `interview` (
  `interviewId` int(11) NOT NULL,
  `date` date NOT NULL,
  `candidateId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `position` varchar(30) NOT NULL,
  `iqTest` int(3) NOT NULL,
  `techTest` int(3) NOT NULL,
  `toeic` int(3) NOT NULL,
  `result` tinyint(1) NOT NULL,
  `source` varchar(100) NOT NULL,
  `notes` varchar(100) NOT NULL,
  `comment` varchar(100) NOT NULL,
  `isDeleted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview`
--

INSERT INTO `interview` (`interviewId`, `date`, `candidateId`, `userId`, `position`, `iqTest`, `techTest`, `toeic`, `result`, `source`, `notes`, `comment`, `isDeleted`) VALUES
(6, '2015-12-11', 28, 1, 'Sub', 3, 90, 990, 1, 'ManUtd', 'goodluck', 'Congrat', NULL),
(8, '2016-10-10', 30, 1, 'Manager', 88, 80, 870, 1, 'RedDevils', 'no cmt', 'Congrat', NULL),
(9, '2016-09-09', 31, 3, 'ST, CF', 3, 100, 600, 1, 'PSG, AJAX', 'unbelievable', 'Great', NULL),
(10, '2016-08-10', 32, 7, 'CDM, CM', 70, 80, 660, 1, 'MF-Giggs', 'no cmt', 'Good Attitude', NULL),
(11, '2016-07-10', 33, 7, 'Winger', 70, 77, 770, 1, 'France', 'goodluck', 'Congrat', NULL),
(12, '2016-01-10', 34, 7, 'ST, LW', 82, 78, 830, 1, 'YoungTeam', '8 weeks TFT', 'Potential', NULL),
(13, '2016-02-10', 35, 7, 'GK', 70, 95, 550, 1, 'MainTeam', 'goodluck', 'Great GK', NULL),
(14, '2016-03-22', 36, 5, 'CM, CF, CAM', 77, 88, 660, 1, 'YoungTeam', 'no cmt', 'Great boy', NULL),
(16, '2016-05-10', 38, 5, 'CB, LB', 74, 77, 770, 1, 'MoiseTeam', 'goodluck', 'Good Job', NULL),
(17, '2016-06-06', 39, 5, 'CB, RB, CDM', 70, 80, 880, 1, 'FergieTeam', 'Injury Prone', 'Nice Boy', NULL),
(18, '2016-07-10', 40, 5, 'RB, LB', 75, 75, 550, 1, 'GalTeam', 'Nice', 'Flexible', NULL),
(19, '2016-08-20', 41, 5, 'RB, RM', 70, 70, 700, 1, 'FergieTeam', 'Flexible', 'Patient man', NULL),
(20, '2016-12-14', 42, 5, 'LB', 80, 85, 880, 1, 'FergieTeam', 'Great Speed', 'Great Potential', NULL),
(21, '2016-11-20', 43, 5, 'CB', 70, 65, 850, 1, 'FergieTeam', 'no cmt', 'Ok', NULL),
(22, '2015-11-11', 44, 4, 'CB', 80, 90, 660, 1, 'FergieTeam', 'Legend CB', 'Excellent', NULL),
(23, '2015-10-10', 45, 4, 'CB', 90, 90, 900, 1, 'FergieTeam', 'Legend CB', 'Unbelievable', NULL),
(24, '2015-09-09', 46, 4, 'GK', 80, 99, 710, 1, 'FergieTeam', 'Legend GK', 'Excellent', NULL),
(25, '2015-08-08', 47, 3, 'Winger', 89, 100, 670, 1, 'FergieTeam', 'Excellent tech', 'Excellent', NULL),
(26, '2016-10-10', 48, 4, 'Director', 12, 23, 577, 1, 'TechOne', '8 weeks TFT', 'fdsgflkn', NULL),
(27, '2016-12-15', 49, 3, 'CDM, CM', 80, 77, 890, 1, 'TFT Source', 'goodluck', 'Great assistant', NULL),
(28, '2016-12-11', 50, 7, 'CM LM RM', 70, 80, 660, 1, 'FergieTeam', 'Sub', 'Patience', NULL),
(29, '2016-12-01', 51, 7, 'LB CB CDM', 80, 80, 880, 1, 'GalTeam', '1m70', 'Good Passing', NULL),
(30, '2016-12-02', 52, 7, 'CDM CM', 85, 80, 770, 0, 'GalTeam', 'Sub', 'Weak Physical', NULL),
(31, '2016-12-03', 53, 7, 'AM LM CF', 89, 90, 750, 1, 'MouTeam', 'Injuring', 'Great Tech', NULL),
(32, '2016-07-10', 54, 4, 'CB', 0, 0, 0, 0, 'asd', 'no cmt', 'asd', NULL),
(34, '2016-12-13', 57, 5, 'Director', 80, 77, 950, 0, 'TechOne', 'no cmt', 'improve tech skills', NULL),
(36, '2016-12-12', 38, 3, 'GK', 0, 0, 0, 0, 'TFT Source', 'no cmt', 'asd', NULL),
(37, '2016-11-12', 59, 3, 'GK', 0, 0, 0, 0, 'TechOne', 'no cmt', 'Congrat', NULL),
(39, '2016-12-12', 38, 3, 'GK', 0, 0, 0, 0, 'asd', 'no cmt', 'asd', NULL),
(41, '2016-10-10', 59, 3, 'GK', 0, 0, 0, 0, 'asd', 'no cmt', 'asd', NULL),
(42, '2016-12-12', 62, 3, 'GK', 0, 0, 0, 0, 'asd', 'no cmt', 'asd', NULL),
(43, '2016-12-12', 38, 3, 'GK', 0, 0, 0, 0, 'asd', 'no cmt', 'asd', NULL),
(44, '2016-12-12', 63, 3, 'GK', 0, 0, 0, 0, 'YoungTeam', 'no cmt', 'asd', NULL),
(45, '2016-12-12', 38, 3, 'GK', 0, 0, 0, 0, 'YoungTeam', 'no cmt', 'asd', 1),
(46, '2016-12-12', 38, 3, 'GK', 0, 0, 0, 0, 'TechOne', 'no cmt', 'asd', NULL),
(47, '2016-12-24', 38, 3, 'Engineer', 0, 0, 0, 0, 'TFT Source', '1234', 'asd', NULL),
(48, '2016-12-12', 64, 3, 'GK', 0, 0, 0, 0, 'asd', '1234', 'asd', NULL),
(49, '2016-12-12', 65, 3, 'GK', 0, 0, 0, 0, 'asd', '1234', 'asd', NULL),
(50, '2016-12-12', 66, 3, 'GK', 0, 0, 0, 0, 'asd', '1234', 'asd', NULL),
(51, '2016-12-12', 67, 3, 'GK', 0, 0, 0, 0, 'asd', 'no cmt', 'asd', NULL),
(52, '2016-12-12', 68, 3, 'CB', 0, 0, 0, 0, 'asd', 'no cmt', 'asd', 1),
(54, '2016-12-03', 53, 7, 'AM LM CF', 89, 90, 750, 1, 'MouTeam', 'Injuring', 'Great Tech', NULL),
(62, '0003-03-02', 28, 1, 'Stricker', 55, 0, 0, 0, 'TechOne', '8 weeks TFT', 'improve tech skills', NULL),
(63, '0003-03-02', 28, 1, 'Stricker', 55, 0, 0, 0, 'TechOne', '8 weeks TFT', 'improve tech skills', 1),
(64, '0003-03-02', 28, 1, 'Stricker', 66, 0, 0, 0, 'TechOne', '8 weeks TFT', 'improve tech skills', 1),
(65, '0006-06-04', 28, 1, '6', 0, 0, 0, 0, '6', '6', '9', 1),
(66, '0004-04-03', 28, 1, '6', 0, 0, 0, 0, '3', '3', '3', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `persistent_logins`
--

INSERT INTO `persistent_logins` (`username`, `series`, `token`, `last_used`) VALUES
('admin', 'hygBj+lK7hfM1VuP0C0e0g==', 'DuT6staaQQnBaGEAxPhQPQ==', '2019-10-08 08:09:58'),
('admin', 'xviuJ8XWhX6f33jiBO0cfg==', 'LwSiFu0nc60tKZ54LmKaFQ==', '2019-10-08 08:28:09');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `roleId` int(10) NOT NULL,
  `roleName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `roleName`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_SUPER_USER'),
(3, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `position` varchar(40) NOT NULL,
  `roleId` int(10) NOT NULL,
  `isEnabled` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `name`, `username`, `password`, `position`, `roleId`, `isEnabled`) VALUES
(1, 'Administrator', 'admin', '1234', 'Admin', 1, 1),
(2, 'Interviewer No.01', 'inter01', '1234', 'CFO', 2, 1),
(3, 'ProjectManager', 'pm01', '1234', 'ProjectManager', 3, 1),
(4, 'Alex Ferguson', 'alex', '123', 'Principal PM', 3, 1),
(5, 'Jose Mou', 'jose', '1234', 'Coach', 3, 1),
(7, 'Ryan Giggs', 'ryan', '123', 'Principal PM', 3, 1),
(8, 'Thân Quang Hi?n', 'tqhien', '123456', 'a', 3, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidate`
--
ALTER TABLE `candidate`
  ADD PRIMARY KEY (`candidateId`);

--
-- Indexes for table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`interviewId`),
  ADD KEY `userId` (`userId`) USING BTREE,
  ADD KEY `candidateId` (`candidateId`) USING BTREE;

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `roleId` (`roleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidate`
--
ALTER TABLE `candidate`
  MODIFY `candidateId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `interview`
--
ALTER TABLE `interview`
  MODIFY `interviewId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `roleId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
