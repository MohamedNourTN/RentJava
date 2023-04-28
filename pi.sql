-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 23 fév. 2023 à 02:22
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pi`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `nom_categorie` varchar(255) NOT NULL,
  `id_produit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id_commentaire` int(11) NOT NULL,
  `id_service` int(11) NOT NULL,
  `contenu_commentaire` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `echange`
--

CREATE TABLE `echange` (
  `id_echange` int(11) NOT NULL,
  `id_CarteFidelite` int(11) NOT NULL,
  `date_echange` date NOT NULL,
  `lieu_echange` varchar(50) NOT NULL,
  `type_echange` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Paquet`
--

CREATE TABLE `Paquet` (
  `id_pack` int(11) NOT NULL,
  `nom_Paquet` varchar(255) NOT NULL,
  `type_pack` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `image_pack` varchar(255) NOT NULL,
  `description_pack` varchar(255) NOT NULL,
  `code_achatPack` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Paquet`
--

INSERT INTO `Paquet` (`id_pack`, `nom_Paquet`, `type_pack`, `date`, `image_pack`, `description_pack`, `code_achatPack`) VALUES
(2, 'ala', 'type', '2023-03-02', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\832.jpg', 'des', 66),
(3, 'alaaaaa', 'type', '2023-03-02', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\174.jpg', 'des', 66),
(4, 'aaa', 'aadzzdc', '2023-03-09', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\255.jpg', 'eddd', 664),
(5, 'bbb', 'ty', '2023-03-02', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\539.jpg', 'des', 9),
(6, 'bujkn', 'aadzzdc', '2023-02-28', 'C:\\\\xampp\\\\htdocs\\\\imageP\\\\997.jpg', 'eddd', 664);

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

CREATE TABLE `livraison` (
  `id_livraison` int(11) NOT NULL,
  `date_livraison` date NOT NULL,
  `type_livraison` varchar(255) NOT NULL,
  `adress_livraison` varchar(255) NOT NULL,
  `idproduit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `livreur`
--

CREATE TABLE `livreur` (
  `id_livreur` int(11) NOT NULL,
  `nom_livreur` varchar(255) NOT NULL,
  `prenom_livreur` varchar(255) NOT NULL,
  `num_livreur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `packAchat`
--

CREATE TABLE `packAchat` (
  `id_achatPack` int(11) NOT NULL,
  `id_CarteFidelite` int(11) NOT NULL,
  `id_Paquet` int(11) NOT NULL,
  `date_part` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `packAchat`
--

INSERT INTO `packAchat` (`id_achatPack`, `id_CarteFidelite`, `id_Paquet`, `date_part`) VALUES
(1, 1, 2, '2023-02-23'),
(2, 1, 3, '2023-02-23'),
(3, 1, 4, '2023-02-23');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `nom_produit` varchar(255) NOT NULL,
  `image_produit` varchar(255) NOT NULL,
  `description_produit` varchar(255) NOT NULL,
  `prix_produit` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

CREATE TABLE `rating` (
  `id echange` int(255) NOT NULL,
  `note` int(1) NOT NULL,
  `id_CarteFidelite_notant` int(8) NOT NULL,
  `id_CarteFidelite_note` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_reclamation` int(11) NOT NULL,
  `id_echange` int(11) NOT NULL,
  `date_reclamation` date NOT NULL,
  `description_reclamation` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE `service` (
  `id_service` int(11) NOT NULL,
  `titre_service` varchar(50) NOT NULL,
  `type_service` varchar(50) NOT NULL,
  `description_service` varchar(50) NOT NULL,
  `date_service` date NOT NULL,
  `lieu_service` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_CarteFidelite` int(8) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `email` varchar(50) NOT NULL,
  `numero_tel` int(20) NOT NULL,
  `rating` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`),
  ADD KEY `test` (`id_produit`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id_commentaire`);

--
-- Index pour la table `Paquet`
--
ALTER TABLE `Paquet`
  ADD PRIMARY KEY (`id_pack`);

--
-- Index pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD PRIMARY KEY (`id_livraison`);

--
-- Index pour la table `livreur`
--
ALTER TABLE `livreur`
  ADD PRIMARY KEY (`id_livreur`);

--
-- Index pour la table `packAchat`
--
ALTER TABLE `packAchat`
  ADD PRIMARY KEY (`id_achatPack`),
  ADD KEY `fk_id_pack` (`id_Paquet`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_CarteFidelite`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Paquet`
--
ALTER TABLE `Paquet`
  MODIFY `id_pack` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `livraison`
--
ALTER TABLE `livraison`
  MODIFY `id_livraison` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `livreur`
--
ALTER TABLE `livreur`
  MODIFY `id_livreur` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `packAchat`
--
ALTER TABLE `packAchat`
  MODIFY `id_achatPack` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_CarteFidelite` int(8) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `packAchat`
--
ALTER TABLE `packAchat`
  ADD CONSTRAINT `fk_id_pack` FOREIGN KEY (`id_Paquet`) REFERENCES `Paquet` (`id_pack`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
