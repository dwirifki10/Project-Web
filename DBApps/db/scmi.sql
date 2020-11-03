-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 03, 2020 at 06:34 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scmi`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(100) NOT NULL,
  `NISN` varchar(25) NOT NULL,
  `code` varchar(25) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `value1` varchar(3) NOT NULL,
  `value2` varchar(3) NOT NULL,
  `value3` varchar(3) NOT NULL,
  `UTS` varchar(3) NOT NULL,
  `UAS` varchar(3) NOT NULL,
  `average` varchar(3) NOT NULL,
  `category` varchar(100) NOT NULL,
  `semester` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `NISN`, `code`, `subject`, `value1`, `value2`, `value3`, `UTS`, `UAS`, `average`, `category`, `semester`) VALUES
(5, '441191107', '2222', 'Pendidikan Olahraga dan Jasmani', '90', '90', '90', '90', '90', '90', 'LULUS', '90'),
(6, '441191107', '2222', 'Pendidikan Olahraga dan Jasmani', '90', '90', '90', '90', '90', '90', 'LULUS', '90'),
(7, '441191107', '2222', 'Pendidikan Olahraga dan Jasmani', '90', '90', '90', '90', '90', '90', 'LULUS', '90'),
(9, '441191107', '3333', 'Pendidikan Bahasa Indonesia', '10', '10', '10', '10', '20', '12', 'REMEDIAL', '2'),
(10, '341191107', '3333', 'Pendidikan Bahasa Indonesia', '30', '30', '30', '30', '30', '30', 'REMEDIAL', '30'),
(11, '441191107', '3333', 'Pendidikan Bahasa Indonesia', '40', '40', '40', '40', '40', '40', 'REMEDIAL', '40'),
(12, '241191107', '3333', 'Pendidikan Bahasa Indonesia', '20', '20', '20', '20', '20', '20', 'REMEDIAL', '20'),
(13, '441191107', '2222', 'Pendidikan Olahraga dan Jasmani', '90', '90', '90', '90', '90', '90', 'LULUS', '90');

-- --------------------------------------------------------

--
-- Table structure for table `data_teacher`
--

CREATE TABLE `data_teacher` (
  `code` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `handphone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_teacher`
--

INSERT INTO `data_teacher` (`code`, `name`, `subject`, `handphone`, `email`, `address`) VALUES
('1111', 'Dwi Rifki Novianto', 'Teknik Informatika', '083872523688', 'dwirifki10@gmail.com', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Pasarkemis, Desa Suka Asih Kabupaten Tangerang, 1556'),
('2222', 'Muhammad Tri Fauzi', 'Pendidikan Olahraga dan Jasmani', '083872523688', 'dwirifki10@gmail.com', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Pasarkemis, Desa Suka Asih Kabupaten Tangerang, 1556	'),
('3333', 'Nur Endang Wahyuni', 'Pendidikan Bahasa Indonesia', '083872523688', 'dwirifki10@gmail.com', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Pasarkemis, Desa Suka Asih Kabupaten Tangerang, 1556	'),
('4444', 'Siti Asropah', 'Pendidikan Bahasa Inggris', '083872523688', 'sitiasropah@gmail.com', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Pasarkemis Desa Suka Asih, Kabupaten Tangerang, Banten 1556'),
('5555', 'Samasi', 'Sejarah Indonesia', '083872523688', 'samasi@gmail.com', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Pasarkemis Desa Suka Asih, Kabupaten Tangerang Banten, 1556\n	'),
('6666', 'Sutriswono', 'Sejarah', '083872523688', 'dwirifki31@gmail.com', 'BTN Bonana Permai Blok B1 No 28');

-- --------------------------------------------------------

--
-- Table structure for table `sign_in`
--

CREATE TABLE `sign_in` (
  `username` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `NISN` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sign_in`
--

INSERT INTO `sign_in` (`username`, `password`, `email`, `NISN`, `type`) VALUES
('dwirifki21', 'dwirifki31', 'dwirifki10@gmail.com', 'Dwi Rifki', 'admin'),
('dwirifki31', 'dwirifki31', 'dwirifki10@gmail.com', 'DWI RIFKI NOVIANTO', 'admin'),
('fauzi22', 'fauzi22', 'dwirifki10@gmail.com', '2222', 'guru'),
('samasi', 'samasi', 'samasi@gmail.com', '5555', 'guru'),
('yuni01', 'yuni01', 'dwirifki10@gmail.com', '3333', 'guru');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `NISN` varchar(25) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `parents` varchar(255) NOT NULL,
  `handphone` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `NIS` varchar(100) NOT NULL,
  `class` varchar(100) NOT NULL,
  `years` varchar(100) NOT NULL,
  `absent` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`NISN`, `name`, `date`, `gender`, `parents`, `handphone`, `school`, `address`, `NIS`, `class`, `years`, `absent`) VALUES
('141191107', 'Dwi Rifki Novianto', '24 November 2000', 'LAKI-LAKI', 'Sutriswono', '083872523688', 'Politeknik Negeri Jember', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Tangerang, Desa Suka Asih Kabupaten Tangerang, Banten 1556', '141191107', '9A ', '2010', '10'),
('241191107', 'Muhammad Tri Fauzi', '22 October 2007', 'LAKI-LAKI', 'Sutriswono', '083872523688', 'SDN 1 Pasarkemis', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Tangerang, Desa Suka Asih Kabupaten Tangerang, Banten 1556', '241191107', '9A', '2010', '10'),
('341191107', 'Nur Endang Wahyuni', '5 June 1996', 'PEREMPUAN', 'Sutriswono', '083872523688', 'Universitas Negeri Surabaya', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Tangerang, Desa Suka Asih Kabupaten Tangerang, Banten 1556', '341191107', '10A', '2009', '19'),
('441191107', 'Siti Asropah', '5 June 1980', 'PEREMPUAN', 'Sutriswono', '083872523688', 'Universitas Negeri Surabaya', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Tangerang, Desa Suka Asih Kabupaten Tangerang, Banten 1556', '441191107', '10A', '2007', '10'),
('541191107', 'Samasi', '25 November 1980', 'LAKI-LAKI', 'Subawi', '083872523688', 'SMPN 2 Pasarkemis', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Pasarkemis Desa Suka Asih, Kabupaten Tangerang Banten 1556', '541191107', '9A', '2010', '20'),
('641191107', 'Sutriswono', '20 December 1980', 'LAKI-LAKI', 'Sutriswono', '083872523688', 'SMAN 1 Tangerang', 'BTN Bonana Permai Blok B1 No 28 RT 03 RW 04 Kecamatan Pasarkemis Desa Suka Asih, Kabupaten Tangerang Banten 1556', '641191107', '8A', '2010', '10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_teacher`
--
ALTER TABLE `data_teacher`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `sign_in`
--
ALTER TABLE `sign_in`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `NISN` (`NISN`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`NISN`),
  ADD UNIQUE KEY `NIS` (`NIS`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
