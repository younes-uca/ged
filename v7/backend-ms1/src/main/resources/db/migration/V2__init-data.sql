-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 30 juil. 2023 à 14:21
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.0.28

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ged`
--

--
-- Déchargement des données de la table `access_share_seq`
--

INSERT INTO `access_share_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `document_categorie`
--

INSERT INTO `document_categorie` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-07-30 11:52:54', '', NULL, 'facture', 'Facture', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_categorie_field`
--

INSERT INTO `document_categorie_field` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `document_categorie`, `document_categorie_field_rule`, `field`) VALUES
(1, 'anonymousUser', '2023-07-30 11:52:54', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, 1),
(2, 'anonymousUser', '2023-07-30 11:52:54', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, 2);

--
-- Déchargement des données de la table `document_categorie_field_rule`
--

INSERT INTO `document_categorie_field_rule` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `expresion`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-07-30 11:49:46', '', NULL, 'not-null', '!= null', 'Non vide', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-07-30 11:50:12', '', NULL, 'positif', '> 0', 'Positif', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_categorie_field_rule_seq`
--

INSERT INTO `document_categorie_field_rule_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document_categorie_field_seq`
--

INSERT INTO `document_categorie_field_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document_categorie_seq`
--

INSERT INTO `document_categorie_seq` (`next_val`) VALUES
(2),
(2);

--
-- Déchargement des données de la table `document_field_seq`
--

INSERT INTO `document_field_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `document_field_state`
--

INSERT INTO `document_field_state` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `style`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-07-30 11:54:45', '', NULL, 'valid', 'Valide', 'info', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-07-30 11:55:04', '', NULL, 'non-valid', 'Rejet', 'danger', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_field_state_seq`
--

INSERT INTO `document_field_state_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document_partage_groupe_seq`
--

INSERT INTO `document_partage_groupe_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `document_partage_utilisateur_seq`
--

INSERT INTO `document_partage_utilisateur_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `document_seq`
--

INSERT INTO `document_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `document_state`
--

INSERT INTO `document_state` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `style`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-07-30 11:51:34', '', NULL, 'valid', 'Valide', 'info', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-07-30 11:51:57', '', NULL, 'rejet', 'Rejete', 'danger', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_state_seq`
--

INSERT INTO `document_state_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document_type`
--

INSERT INTO `document_type` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-07-30 11:50:51', '', NULL, 'word', 'Word', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-07-30 11:51:06', '', NULL, 'excel', 'Excel', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_type_seq`
--

INSERT INTO `document_type_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `entite_administrative_seq`
--

INSERT INTO `entite_administrative_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `entite_administrative_type_seq`
--

INSERT INTO `entite_administrative_type_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `etablissement_seq`
--

INSERT INTO `etablissement_seq` (`next_val`) VALUES
(1);

--
-- Déchargement des données de la table `etat_utilisateur_seq`
--

INSERT INTO `etat_utilisateur_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `field`
--

INSERT INTO `field` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-07-30 11:48:14', '', NULL, 'montant-tva', 'montant tva', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-07-30 11:48:32', '', NULL, 'montant-ttc', 'montant ttc', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `field_seq`
--

INSERT INTO `field_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `groupe_seq`
--

INSERT INTO `groupe_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `groupe_utilisateur_seq`
--

INSERT INTO `groupe_utilisateur_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(100),
(100),
(100);

--
-- Déchargement des données de la table `permission`
--

INSERT INTO `permission` (`id`, `name`) VALUES
(1, 'DocumentType.edit'),
(2, 'DocumentType.list'),
(3, 'DocumentType.view'),
(4, 'DocumentType.add'),
(5, 'DocumentType.delete'),
(6, 'GroupeUtilisateur.edit'),
(7, 'GroupeUtilisateur.list'),
(8, 'GroupeUtilisateur.view'),
(9, 'GroupeUtilisateur.add'),
(10, 'GroupeUtilisateur.delete'),
(11, 'DocumentPartageUtilisateur.edit'),
(12, 'DocumentPartageUtilisateur.list'),
(13, 'DocumentPartageUtilisateur.view'),
(14, 'DocumentPartageUtilisateur.add'),
(15, 'DocumentPartageUtilisateur.delete'),
(16, 'DocumentCategorieField.edit'),
(17, 'DocumentCategorieField.list'),
(18, 'DocumentCategorieField.view'),
(19, 'DocumentCategorieField.add'),
(20, 'DocumentCategorieField.delete'),
(21, 'Document.edit'),
(22, 'Document.list'),
(23, 'Document.view'),
(24, 'Document.add'),
(25, 'Document.delete'),
(26, 'Utilisateur.edit'),
(27, 'Utilisateur.list'),
(28, 'Utilisateur.view'),
(29, 'Utilisateur.add'),
(30, 'Utilisateur.delete'),
(31, 'DocumentState.edit'),
(32, 'DocumentState.list'),
(33, 'DocumentState.view'),
(34, 'DocumentState.add'),
(35, 'DocumentState.delete'),
(36, 'RoleUtilisateur.edit'),
(37, 'RoleUtilisateur.list'),
(38, 'RoleUtilisateur.view'),
(39, 'RoleUtilisateur.add'),
(40, 'RoleUtilisateur.delete'),
(41, 'EntiteAdministrativeType.edit'),
(42, 'EntiteAdministrativeType.list'),
(43, 'EntiteAdministrativeType.view'),
(44, 'EntiteAdministrativeType.add'),
(45, 'EntiteAdministrativeType.delete'),
(46, 'EtatUtilisateur.edit'),
(47, 'EtatUtilisateur.list'),
(48, 'EtatUtilisateur.view'),
(49, 'EtatUtilisateur.add'),
(50, 'EtatUtilisateur.delete'),
(51, 'Groupe.edit'),
(52, 'Groupe.list'),
(53, 'Groupe.view'),
(54, 'Groupe.add'),
(55, 'Groupe.delete'),
(56, 'AccessShare.edit'),
(57, 'AccessShare.list'),
(58, 'AccessShare.view'),
(59, 'AccessShare.add'),
(60, 'AccessShare.delete'),
(61, 'DocumentFieldState.edit'),
(62, 'DocumentFieldState.list'),
(63, 'DocumentFieldState.view'),
(64, 'DocumentFieldState.add'),
(65, 'DocumentFieldState.delete'),
(66, 'DocumentPartageGroupe.edit'),
(67, 'DocumentPartageGroupe.list'),
(68, 'DocumentPartageGroupe.view'),
(69, 'DocumentPartageGroupe.add'),
(70, 'DocumentPartageGroupe.delete'),
(71, 'EntiteAdministrative.edit'),
(72, 'EntiteAdministrative.list'),
(73, 'EntiteAdministrative.view'),
(74, 'EntiteAdministrative.add'),
(75, 'EntiteAdministrative.delete'),
(76, 'DocumentField.edit'),
(77, 'DocumentField.list'),
(78, 'DocumentField.view'),
(79, 'DocumentField.add'),
(80, 'DocumentField.delete'),
(81, 'Field.edit'),
(82, 'Field.list'),
(83, 'Field.view'),
(84, 'Field.add'),
(85, 'Field.delete'),
(86, 'DocumentCategorieFieldRule.edit'),
(87, 'DocumentCategorieFieldRule.list'),
(88, 'DocumentCategorieFieldRule.view'),
(89, 'DocumentCategorieFieldRule.add'),
(90, 'DocumentCategorieFieldRule.delete'),
(91, 'DocumentCategorie.edit'),
(92, 'DocumentCategorie.list'),
(93, 'DocumentCategorie.view'),
(94, 'DocumentCategorie.add'),
(95, 'DocumentCategorie.delete');

--
-- Déchargement des données de la table `roles_permissions`
--

INSERT INTO `roles_permissions` (`role_id`, `permission_id`) VALUES
(96, 1),
(96, 2),
(96, 3),
(96, 4),
(96, 5),
(96, 6),
(96, 7),
(96, 8),
(96, 9),
(96, 10),
(96, 11),
(96, 12),
(96, 13),
(96, 14),
(96, 15),
(96, 16),
(96, 17),
(96, 18),
(96, 19),
(96, 20),
(96, 21),
(96, 22),
(96, 23),
(96, 24),
(96, 25),
(96, 26),
(96, 27),
(96, 28),
(96, 29),
(96, 30),
(96, 31),
(96, 32),
(96, 33),
(96, 34),
(96, 35),
(96, 36),
(96, 37),
(96, 38),
(96, 39),
(96, 40),
(96, 41),
(96, 42),
(96, 43),
(96, 44),
(96, 45),
(96, 46),
(96, 47),
(96, 48),
(96, 49),
(96, 50),
(96, 51),
(96, 52),
(96, 53),
(96, 54),
(96, 55),
(96, 56),
(96, 57),
(96, 58),
(96, 59),
(96, 60),
(96, 61),
(96, 62),
(96, 63),
(96, 64),
(96, 65),
(96, 66),
(96, 67),
(96, 68),
(96, 69),
(96, 70),
(96, 71),
(96, 72),
(96, 73),
(96, 74),
(96, 75),
(96, 76),
(96, 77),
(96, 78),
(96, 79),
(96, 80),
(96, 81),
(96, 82),
(96, 83),
(96, 84),
(96, 85),
(96, 86),
(96, 87),
(96, 88),
(96, 89),
(96, 90),
(96, 91),
(96, 92),
(96, 93),
(96, 94),
(96, 95),
(98, 1),
(98, 2),
(98, 3),
(98, 4),
(98, 5),
(98, 6),
(98, 7),
(98, 8),
(98, 9),
(98, 10),
(98, 11),
(98, 12),
(98, 13),
(98, 14),
(98, 15),
(98, 16),
(98, 17),
(98, 18),
(98, 19),
(98, 20),
(98, 21),
(98, 22),
(98, 23),
(98, 24),
(98, 25),
(98, 26),
(98, 27),
(98, 28),
(98, 29),
(98, 30),
(98, 31),
(98, 32),
(98, 33),
(98, 34),
(98, 35),
(98, 36),
(98, 37),
(98, 38),
(98, 39),
(98, 40),
(98, 41),
(98, 42),
(98, 43),
(98, 44),
(98, 45),
(98, 46),
(98, 47),
(98, 48),
(98, 49),
(98, 50),
(98, 51),
(98, 52),
(98, 53),
(98, 54),
(98, 55),
(98, 56),
(98, 57),
(98, 58),
(98, 59),
(98, 60),
(98, 61),
(98, 62),
(98, 63),
(98, 64),
(98, 65),
(98, 66),
(98, 67),
(98, 68),
(98, 69),
(98, 70),
(98, 71),
(98, 72),
(98, 73),
(98, 74),
(98, 75),
(98, 76),
(98, 77),
(98, 78),
(98, 79),
(98, 80),
(98, 81),
(98, 82),
(98, 83),
(98, 84),
(98, 85),
(98, 86),
(98, 87),
(98, 88),
(98, 89),
(98, 90),
(98, 91),
(98, 92),
(98, 93),
(98, 94),
(98, 95);

--
-- Déchargement des données de la table `role_app`
--

INSERT INTO `role_app` (`id`, `authority`, `created_at`, `updated_at`) VALUES
(96, 'ROLE_ADMIN', NULL, NULL),
(98, 'ROLE_AGENT', NULL, NULL);

--
-- Déchargement des données de la table `role_utilisateur_seq`
--

INSERT INTO `role_utilisateur_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(97, 96),
(99, 98);

--
-- Déchargement des données de la table `user_app`
--

INSERT INTO `user_app` (`id`, `created_by`, `created_on`, `updated_by`, `updated_on`, `account_non_expired`, `account_non_locked`, `created_at`, `credentials_non_expired`, `email`, `enabled`, `nom`, `password`, `password_changed`, `prenom`, `updated_at`, `username`, `etablissement`) VALUES
(97, NULL, '2023-07-30 11:46:32', NULL, NULL, b'1', b'1', '2023-07-30 11:46:32', b'1', 'admin', b'1', 'admin', '$2a$10$WS4JI/pvznWNmmrEf/GLH.3LbM48m1OIcDSEYB6QtMeRpm9x71MEC', b'0', 'admin', NULL, 'admin', NULL),
(99, NULL, '2023-07-30 11:46:33', NULL, NULL, b'1', b'1', '2023-07-30 11:46:33', b'1', 'agent', b'1', 'agent', '$2a$10$8M9H6I8jJ0orWGB1spBcg.e5wISYRzv5YyijSbtnk07Ug1O5id6VW', b'0', 'agent', NULL, 'agent', NULL);

--
-- Déchargement des données de la table `utilisateur_seq`
--

INSERT INTO `utilisateur_seq` (`next_val`) VALUES
(1),
(1);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
