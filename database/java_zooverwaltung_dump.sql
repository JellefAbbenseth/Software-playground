-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 22. Dez 2021 um 15:34
-- Server-Version: 10.1.38-MariaDB
-- PHP-Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `java_zooverwaltung`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `animals`
--

CREATE TABLE `animals` (
  `anId` int(11) NOT NULL,
  `age` int(3) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `species` varchar(25) NOT NULL,
  `type` varchar(25) NOT NULL,
  `coId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `animals`
--

INSERT INTO `animals` (`anId`, `age`, `sex`, `species`, `type`, `coId`) VALUES
(1, 5, 'm', 'Säugetier', 'Löwe', 1),
(2, 4, 'w', 'Säugetier', 'Löwe', 1),
(3, 1, 'm', 'Säugetier', 'Löwe', 1),
(4, 1, 'w', 'Säugetier', 'Löwe', 1),
(5, 30, 'w', 'Reptil', 'Schildkröte', 2),
(6, 4, 'm', 'Vogel', 'Eule', 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `compounds`
--

CREATE TABLE `compounds` (
  `coId` int(11) NOT NULL,
  `type` varchar(25) NOT NULL,
  `haId` int(11) NOT NULL,
  `maxResidents` int(3) NOT NULL,
  `stId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `compounds`
--

INSERT INTO `compounds` (`coId`, `type`, `haId`, `maxResidents`, `stId`) VALUES
(0, 'Nicht zugeordnet', 7, 999, 0),
(1, 'Raubtierhaus', 1, 5, 1),
(2, 'Reptilienhaus', 4, 25, 2),
(3, 'Vogelhaus', 5, 15, 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `habitats`
--

CREATE TABLE `habitats` (
  `haId` int(11) NOT NULL,
  `habitat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `habitats`
--

INSERT INTO `habitats` (`haId`, `habitat`) VALUES
(1, 'Land'),
(2, 'Wasser'),
(3, 'Luft'),
(4, 'Land, Wasser'),
(5, 'Land, Luft'),
(6, 'Wasser, Luft'),
(7, 'Land, Wasser, Luft');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `staff`
--

CREATE TABLE `staff` (
  `stId` int(11) NOT NULL,
  `age` int(3) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `responsibility` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `staff`
--

INSERT INTO `staff` (`stId`, `age`, `sex`, `firstName`, `lastName`, `responsibility`) VALUES
(0, 0, 'O', 'Kein Name', 'Kein Name', 'Keine'),
(1, 24, 'm', 'Tom', 'Schneider', 'Pflege'),
(2, 32, 'w', 'Lena', 'Hauber', 'Fütterung');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`anId`),
  ADD KEY `coId` (`coId`);

--
-- Indizes für die Tabelle `compounds`
--
ALTER TABLE `compounds`
  ADD PRIMARY KEY (`coId`),
  ADD KEY `haId` (`haId`),
  ADD KEY `stId` (`stId`);

--
-- Indizes für die Tabelle `habitats`
--
ALTER TABLE `habitats`
  ADD PRIMARY KEY (`haId`);

--
-- Indizes für die Tabelle `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`stId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
