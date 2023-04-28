-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 26 avr. 2023 à 21:32
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jj`
--

-- --------------------------------------------------------

--
-- Structure de la table `cartefedilite`
--

CREATE TABLE `cartefedilite` (
  `id` int(11) NOT NULL,
  `num_carte` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cartefedilite`
--

INSERT INTO `cartefedilite` (`id`, `num_carte`) VALUES
(1, 'motaz'),
(22, 'HGF');

-- --------------------------------------------------------

--
-- Structure de la table `packachat`
--

CREATE TABLE `packachat` (
  `id_packAchat` int(11) NOT NULL,
  `date_part` date NOT NULL,
  `num_carte` int(11) NOT NULL,
  `id_Paquet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `packachat`
--

INSERT INTO `packachat` (`id_packAchat`, `date_part`, `num_carte`, `id_Paquet`) VALUES
(110, '2023-03-30', 1, 16),
(111, '2023-03-30', 1, 14),
(114, '2023-04-07', 1, 14),
(115, '2023-04-07', 1, 14),
(116, '2023-04-11', 1, 18),
(117, '2023-04-11', 1, 18),
(118, '2023-04-11', 1, 18),
(119, '2023-04-11', 1, 18),
(120, '2023-04-11', 1, 18),
(121, '2023-04-11', 1, 18),
(122, '2023-04-11', 1, 18),
(123, '2023-04-11', 1, 18),
(124, '2023-04-11', 1, 18),
(125, '2023-04-11', 1, 18),
(126, '2023-04-11', 1, 18),
(127, '2023-04-11', 1, 18),
(128, '2023-04-11', 1, 18),
(129, '2023-04-13', 1, 15),
(130, '2023-04-13', 1, 14),
(131, '2023-04-13', 1, 16),
(132, '2023-04-13', 1, 19),
(133, '2023-04-13', 1, 16),
(134, '2023-04-13', 1, 14),
(135, '2023-04-13', 1, 14),
(138, '2023-04-16', 1, 14),
(139, '2023-04-16', 1, 14),
(140, '2023-04-16', 1, 14),
(141, '2023-04-16', 1, 14),
(142, '2023-04-16', 1, 14),
(143, '2023-04-16', 1, 14),
(144, '2023-04-16', 1, 14),
(145, '2023-04-16', 1, 14),
(146, '2023-04-16', 1, 14),
(147, '2023-04-16', 1, 14),
(148, '2023-04-16', 1, 15),
(149, '2023-04-16', 1, 15),
(150, '2023-04-16', 1, 15),
(151, '2023-04-16', 1, 15),
(152, '2023-04-16', 1, 15),
(153, '2023-04-16', 1, 15),
(154, '2023-04-16', 1, 15),
(155, '2023-04-16', 1, 15),
(156, '2023-04-16', 1, 15),
(157, '2023-04-16', 1, 15),
(158, '2023-04-16', 1, 15),
(159, '2023-04-16', 1, 15),
(160, '2023-04-16', 1, 15),
(161, '2023-04-16', 1, 15),
(162, '2023-04-16', 1, 15),
(163, '2023-04-16', 1, 15),
(164, '2023-04-17', 1, 17),
(165, '2023-04-17', 1, 17),
(166, '2023-04-17', 1, 16),
(167, '2023-04-17', 1, 16),
(168, '2023-04-19', 1, 16),
(169, '2023-04-20', 1, 15),
(170, '2023-04-20', 1, 16),
(171, '2023-04-22', 1, 17),
(172, '2023-04-22', 1, 17),
(173, '2023-04-22', 1, 17),
(174, '2023-04-22', 1, 17),
(175, '2023-04-22', 1, 17),
(176, '2023-04-22', 1, 15),
(177, '2023-04-22', 1, 15),
(178, '2023-04-22', 1, 18),
(179, '2023-04-24', 1, 19),
(180, '2023-04-24', 1, 18),
(181, '2023-04-24', 1, 19),
(182, '2023-04-24', 1, 16),
(183, '2023-04-25', 1, 15),
(184, '2023-04-26', 1, 15),
(185, '2023-04-26', 1, 17);

-- --------------------------------------------------------

--
-- Structure de la table `paquet`
--

CREATE TABLE `paquet` (
  `id_pack` int(11) NOT NULL,
  `code_packAchat` int(11) NOT NULL,
  `nom_Paquet` varchar(50) NOT NULL,
  `type_pack` varchar(50) NOT NULL,
  `image_pack` varchar(255) NOT NULL,
  `description_pack` text NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `paquet`
--

INSERT INTO `paquet` (`id_pack`, `code_packAchat`, `nom_Paquet`, `type_pack`, `image_pack`, `description_pack`, `date`) VALUES
(14, 2, 'ali', 'voiture', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\106.jpg', 'bien ', '2025-04-16'),
(15, 12, 'ahmed', 'telephones', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\180.jpg', 'huaweiS10', '2025-04-17'),
(16, 33, 'hjzezd', 'voiture', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\880.jpg', 'très bien ', '2024-04-25'),
(17, 32, 'ali', 'dazkk', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\59.jpg', 'très bien ', '2026-04-16'),
(18, 12, 'dazdjb', 'czjkb', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\723.jpg', ' bien ', '2026-04-16'),
(19, 27, 'dazhkbdk', 'GOLD', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\146.jpg', 'très bien ', '2026-04-17'),
(28, 27, 'dazhkbdk', 'kiki', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\146.jpg', 'dazhjbd', '2027-04-16'),
(29, 12, 'dazdjb', 'kiki', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\723.jpg', ' bien ', '2026-04-17'),
(30, 12, 'dazdjb', 'lol', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\723.jpg', ' bien ', '2026-04-17'),
(31, 34, 'ali', 'dazkk', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\59.jpg', 'très bien ', '2027-04-17');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cartefedilite`
--
ALTER TABLE `cartefedilite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `packachat`
--
ALTER TABLE `packachat`
  ADD PRIMARY KEY (`id_packAchat`),
  ADD KEY `id_CarteFidelite` (`num_carte`),
  ADD KEY `id_evenement` (`id_Paquet`);

--
-- Index pour la table `paquet`
--
ALTER TABLE `paquet`
  ADD PRIMARY KEY (`id_pack`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cartefedilite`
--
ALTER TABLE `cartefedilite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `packachat`
--
ALTER TABLE `packachat`
  MODIFY `id_packAchat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=186;

--
-- AUTO_INCREMENT pour la table `paquet`
--
ALTER TABLE `paquet`
  MODIFY `id_pack` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `packachat`
--
ALTER TABLE `packachat`
  ADD CONSTRAINT `packachat_ibfk_1` FOREIGN KEY (`num_carte`) REFERENCES `cartefedilite` (`id`),
  ADD CONSTRAINT `packachat_ibfk_2` FOREIGN KEY (`id_Paquet`) REFERENCES `paquet` (`id_pack`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
