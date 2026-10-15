-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Okt 2026 pada 16.38
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_people`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `person`
--

CREATE TABLE `person` (
  `id` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `thn_lahir` int(11) NOT NULL,
  `kategori` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `person`
--

INSERT INTO `person` (`id`, `nama`, `thn_lahir`, `kategori`, `email`) VALUES
('P001', 'Andi Pratama', 2004, 'Mahasiswa', 'andi.pratama@gmail.com'),
('P002', 'Budi Santoso', 2003, 'Mahasiswa', 'budi.santoso@gmail.com'),
('P003', 'Citra Lestari', 2002, 'Mahasiswa', 'citra.lestari@gmail.com'),
('P004', 'Dimas Saputra', 2004, 'Mahasiswa', 'dimas.saputra@gmail.com'),
('P005', 'Eka Putri', 2003, 'Mahasiswa', 'eka.putri@gmail.com'),
('P006', 'Fajar Ramadhan', 2001, 'Mahasiswa', 'fajar.ramadhan@gmail.com'),
('P007', 'Gita Amelia', 2004, 'Mahasiswa', 'gita.amelia@gmail.com'),
('P008', 'Hendra Wijaya', 2002, 'Mahasiswa', 'hendra.wijaya@gmail.com'),
('P009', 'Intan Permata', 2003, 'Mahasiswa', 'intan.permata@gmail.com'),
('P010', 'Joko Firmansyah', 2001, 'Mahasiswa', 'joko.firmansyah@gmail.com'),
('P011', 'Dr. Agus Setiawan', 1980, 'Dosen', 'agus.setiawan@gmail.com'),
('P012', 'Dr. Maya Sari', 1985, 'Dosen', 'maya.sari@gmail.com'),
('P013', 'Rina Kartika', 1982, 'Dosen', 'rina.kartika@gmail.com'),
('P014', 'Dedi Kurniawan', 1978, 'Dosen', 'dedi.kurniawan@gmail.com'),
('P015', 'Siti Nurhaliza', 1987, 'Dosen', 'siti.nurhaliza@gmail.com'),
('P016', 'Agus Hermawan', 1990, 'Staf', 'agus.hermawan@gmail.com'),
('P017', 'Dewi Anggraini', 1992, 'Staf', 'dewi.anggraini@gmail.com'),
('P018', 'Rudi Hartono', 1988, 'Staf', 'rudi.hartono@gmail.com'),
('P019', 'Nina Oktaviani', 1995, 'Staf', 'nina.oktaviani@gmail.com'),
('P020', 'Yoga Prasetyo', 1993, 'Staf', 'yoga.prasetyo@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
