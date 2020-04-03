-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2020 at 08:20 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lab4`
--

-- --------------------------------------------------------

--
-- Table structure for table `bug`
--
USE lab4;

CREATE TABLE `bug` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `id_resolver` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `id_author` int(11) NOT NULL,
  `priority` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bug`
--

INSERT INTO `bug` (`id`, `name`, `description`, `id_resolver`, `id_product`, `id_author`, `priority`, `status`) VALUES
(1, 'Bug Logare', 'Cand Utiliatorul se logheaza cu contului lui nu se salveaza toate datele in sesiune.', 2, 1, 1, 1, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bug`
--
ALTER TABLE `bug`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_resolver` (`id_resolver`),
  ADD KEY `id_author` (`id_author`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bug`
--
ALTER TABLE `bug`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bug`
--
--ALTER TABLE `bug`
--  ADD CONSTRAINT `bug_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE,
--  ADD CONSTRAINT `bug_ibfk_2` FOREIGN KEY (`id_resolver`) REFERENCES `employee` (`id`) ON DELETE CASCADE,==
--  ADD CONSTRAINT `bug_ibfk_3` FOREIGN KEY (`id_author`) REFERENCES `employee` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
