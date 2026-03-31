-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2026 at 01:46 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coba`
--

-- --------------------------------------------------------

--
-- Table structure for table `histori_login`
--

CREATE TABLE `histori_login` (
  `kd_histori` int(11) NOT NULL,
  `nm_pengguna` varchar(50) DEFAULT NULL,
  `keterangan` varchar(100) DEFAULT NULL,
  `tgl_wkt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `histori_login`
--

INSERT INTO `histori_login` (`kd_histori`, `nm_pengguna`, `keterangan`, `tgl_wkt`) VALUES
(39, 'JeanRiko', 'Login berhasil', '2026-03-10 10:05:45'),
(40, 'JeanRiko', 'Login berhasil', '2026-03-10 10:08:55'),
(41, 'JeanRiko', 'Login berhasil', '2026-03-10 10:38:44'),
(42, 'JeanRiko', 'Login berhasil', '2026-03-10 10:41:46'),
(43, 'JeanRiko', 'Login berhasil', '2026-03-10 10:43:42'),
(44, 'JeanRiko', 'Login berhasil', '2026-03-10 10:44:35'),
(45, 'JeanRiko', 'Login berhasil', '2026-03-10 10:48:29');

-- --------------------------------------------------------

--
-- Table structure for table `tb_biodata`
--

CREATE TABLE `tb_biodata` (
  `nim` varchar(20) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  `prodi` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_coba`
--

CREATE TABLE `tb_coba` (
  `kode` varchar(25) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan') DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `foto` varchar(150) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `tb_coba`
--

INSERT INTO `tb_coba` (`kode`, `nama`, `jenis_kelamin`, `tgl_lahir`, `foto`) VALUES
('A-1', 'Peter Parker', 'Laki-Laki', '2000-03-10', NULL),
('A-2', 'John Cena', 'Laki-Laki', '1983-03-10', NULL),
('A-3', 'Undertaker', 'Laki-Laki', '1978-03-12', NULL),
('A-4', 'Lara Croft', 'Perempuan', '1983-03-10', NULL),
('A-5', 'Emma Watson', 'Perempuan', '1983-03-10', NULL),
('B11', 'Tony', 'Laki-Laki', '1970-05-29', NULL),
('B12', 'ratu', 'Laki-Laki', '1984-12-03', NULL),
('B13', 'zoro', 'Laki-Laki', '1969-12-18', NULL),
('B14', 'Rogers', 'Laki-Laki', '1918-07-04', NULL),
('B15', 'kartika', 'Laki-Laki', '1989-02-10', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_master`
--

CREATE TABLE `tb_master` (
  `id` int(11) NOT NULL,
  `kode` varchar(50) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `keterangan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pendidikan`
--

CREATE TABLE `tb_pendidikan` (
  `kd_pendidikan` int(10) UNSIGNED NOT NULL,
  `kode` varchar(25) DEFAULT NULL,
  `nama_instansi` varchar(150) DEFAULT NULL,
  `dari_tahun` year(4) DEFAULT NULL,
  `sampai_tahun` year(4) DEFAULT NULL,
  `jurusan` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `tb_pendidikan`
--

INSERT INTO `tb_pendidikan` (`kd_pendidikan`, `kode`, `nama_instansi`, `dari_tahun`, `sampai_tahun`, `jurusan`) VALUES
(6, 'P1', 'LP3I Pekanbaru', '2009', '2020', 'MI');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengalaman_kerja`
--

CREATE TABLE `tb_pengalaman_kerja` (
  `kd_pengalaman` int(10) UNSIGNED NOT NULL,
  `kode` varchar(25) DEFAULT NULL,
  `nama_perusahaan` varchar(150) DEFAULT NULL,
  `jabatan_terakhir` varchar(150) DEFAULT NULL,
  `terakhir_bekerja` year(4) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `tb_pengalaman_kerja`
--

INSERT INTO `tb_pengalaman_kerja` (`kd_pengalaman`, `kode`, `nama_perusahaan`, `jabatan_terakhir`, `terakhir_bekerja`) VALUES
(8, 'PK1', 'Pertamina', 'Admin', '2020');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengguna`
--

CREATE TABLE `tb_pengguna` (
  `nm_pengguna` varchar(50) NOT NULL,
  `psw_pengguna` varchar(50) DEFAULT NULL,
  `level_user` enum('Admin','Operator') DEFAULT NULL,
  `status_akun` enum('Aktif','Suspend','Belum Aktif') NOT NULL,
  `terakhir_login` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `tb_pengguna`
--

INSERT INTO `tb_pengguna` (`nm_pengguna`, `psw_pengguna`, `level_user`, `status_akun`, `terakhir_login`) VALUES
('JeanRiko', '4321', 'Admin', 'Aktif', '2026-03-12 21:43:58'),
('iwal', '090408', 'Admin', 'Aktif', '2026-03-12 21:28:37');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengguna_histori`
--

CREATE TABLE `tb_pengguna_histori` (
  `kd_histori` int(11) NOT NULL,
  `nm_pengguna` varchar(50) DEFAULT NULL,
  `keterangan` varchar(500) DEFAULT NULL,
  `tgl_wkt` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `tb_pengguna_histori`
--

INSERT INTO `tb_pengguna_histori` (`kd_histori`, `nm_pengguna`, `keterangan`, `tgl_wkt`) VALUES
(32, 'JeanRiko', 'Login berhasil', '2026-03-11 22:43:52'),
(33, 'JeanRiko', 'Logout berhasil', '2026-03-11 22:45:15'),
(34, '', 'Logout berhasil', '2026-03-11 22:45:17'),
(35, '', 'Logout berhasil', '2026-03-11 22:45:18'),
(36, '', 'Logout berhasil', '2026-03-11 22:45:20'),
(37, '', 'Logout berhasil', '2026-03-11 22:45:21'),
(38, '', 'Logout berhasil', '2026-03-11 22:45:22'),
(39, '', 'Logout berhasil', '2026-03-11 22:45:23'),
(40, '', 'Logout berhasil', '2026-03-11 22:45:24'),
(41, 'JeanRiko', 'Login berhasil', '2026-03-11 22:50:38'),
(42, 'JeanRiko', 'Logout berhasil', '2026-03-11 22:50:53'),
(43, 'JeanRiko', 'Login berhasil', '2026-03-11 22:51:04'),
(44, 'JeanRiko', 'Login berhasil', '2026-03-11 23:11:39'),
(45, 'JeanRiko', 'Login berhasil', '2026-03-11 23:18:06'),
(46, 'JeanRiko', 'Login berhasil', '2026-03-12 02:42:41'),
(47, 'JeanRiko', 'Logout berhasil', '2026-03-12 02:43:05'),
(48, 'JeanRiko', 'Login berhasil', '2026-03-12 07:03:41'),
(49, 'JeanRiko', 'Login berhasil', '2026-03-12 07:06:30'),
(50, 'JeanRiko', 'Login berhasil', '2026-03-12 07:14:28'),
(51, 'JeanRiko', 'Logout berhasil', '2026-03-12 07:15:14'),
(52, 'JeanRiko', 'Login berhasil', '2026-03-12 07:32:57'),
(53, 'JeanRiko', 'Login berhasil', '2026-03-12 07:41:08'),
(54, 'JeanRiko', 'Logout berhasil', '2026-03-12 07:42:31'),
(55, 'JeanRiko', 'Login berhasil', '2026-03-12 07:57:29'),
(56, 'JeanRiko', 'Logout berhasil', '2026-03-12 08:01:06'),
(57, 'JeanRiko', 'Login berhasil', '2026-03-12 08:22:06'),
(58, 'JeanRiko', 'Login berhasil', '2026-03-12 08:27:43'),
(59, 'JeanRiko', 'Login berhasil', '2026-03-12 08:57:45'),
(60, 'JeanRiko', 'Login berhasil', '2026-03-12 09:09:44'),
(61, 'JeanRiko', 'Login berhasil', '2026-03-12 09:15:14'),
(62, 'JeanRiko', 'Logout berhasil', '2026-03-12 09:19:39'),
(63, 'JeanRiko', 'Login berhasil', '2026-03-12 09:20:10'),
(64, 'JeanRiko', 'Login berhasil', '2026-03-12 09:32:54'),
(65, 'JeanRiko', 'Login berhasil', '2026-03-12 10:17:54'),
(66, 'iwal', 'Login berhasil', '2026-03-12 20:54:54'),
(67, 'iwal', 'Logout berhasil', '2026-03-12 20:55:24'),
(68, 'JeanRiko', 'Login berhasil', '2026-03-12 21:01:04'),
(69, 'JeanRiko', 'Login berhasil', '2026-03-12 21:03:35'),
(70, 'JeanRiko', 'Logout berhasil', '2026-03-12 21:12:41'),
(71, 'JeanRiko', 'Login berhasil', '2026-03-12 21:17:07'),
(72, 'iwal', 'Login berhasil', '2026-03-12 21:18:07'),
(73, 'iwal', 'Login berhasil', '2026-03-12 21:28:37'),
(74, 'JeanRiko', 'Login ke sistem', '2026-03-12 21:43:58');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `histori_login`
--
ALTER TABLE `histori_login`
  ADD PRIMARY KEY (`kd_histori`);

--
-- Indexes for table `tb_biodata`
--
ALTER TABLE `tb_biodata`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `tb_coba`
--
ALTER TABLE `tb_coba`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `tb_master`
--
ALTER TABLE `tb_master`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_pendidikan`
--
ALTER TABLE `tb_pendidikan`
  ADD PRIMARY KEY (`kd_pendidikan`);

--
-- Indexes for table `tb_pengalaman_kerja`
--
ALTER TABLE `tb_pengalaman_kerja`
  ADD PRIMARY KEY (`kd_pengalaman`);

--
-- Indexes for table `tb_pengguna`
--
ALTER TABLE `tb_pengguna`
  ADD PRIMARY KEY (`nm_pengguna`);

--
-- Indexes for table `tb_pengguna_histori`
--
ALTER TABLE `tb_pengguna_histori`
  ADD PRIMARY KEY (`kd_histori`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `histori_login`
--
ALTER TABLE `histori_login`
  MODIFY `kd_histori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `tb_master`
--
ALTER TABLE `tb_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_pendidikan`
--
ALTER TABLE `tb_pendidikan`
  MODIFY `kd_pendidikan` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_pengalaman_kerja`
--
ALTER TABLE `tb_pengalaman_kerja`
  MODIFY `kd_pengalaman` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tb_pengguna_histori`
--
ALTER TABLE `tb_pengguna_histori`
  MODIFY `kd_histori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
