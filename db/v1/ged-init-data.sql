-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 02 août 2023 à 17:08
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
-- Déchargement des données de la table `access_share`
--

INSERT INTO `access_share` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 14:51:07', '', NULL, 'write', 'Write', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 14:51:19', '', NULL, 'read', 'Read', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `access_share_seq`
--

INSERT INTO `access_share_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `archive`, `content`, `date_last_update`, `description`, `folder`, `reference`, `size`, `upload_date`, `versionne`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `document_categorie`, `document_state`, `document_type`, `entite_administrative`, `utilisateur`) VALUES
(1, 'anonymousUser', '2023-08-01 20:44:46', '', NULL, b'0', 'nonos', NULL, NULL, b'0', 'd1', 0.00, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL),
(2, 'anonymousUser', '2023-08-01 20:45:34', '', NULL, b'0', 'zouani', NULL, NULL, b'0', 'd2', 0.00, NULL, b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL),
(5, 'anonymousUser', '2023-08-02 14:47:00', '', NULL, b'0', NULL, '2023-08-02 12:46:32', NULL, b'0', 'd4', 300.00, '2023-08-02 12:46:32', b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, NULL, NULL);

--
-- Déchargement des données de la table `document_categorie`
--

INSERT INTO `document_categorie` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 14:43:25', '', NULL, 'facture', 'Facture', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 14:43:51', '', NULL, 'devis', 'Devis', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_categorie_field`
--

INSERT INTO `document_categorie_field` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `document_categorie`, `document_categorie_field_rule`, `field`) VALUES
(1, 'anonymousUser', '2023-08-02 14:43:25', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1),
(2, 'anonymousUser', '2023-08-02 14:43:25', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 2),
(3, 'anonymousUser', '2023-08-02 14:43:51', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 1, 2);

--
-- Déchargement des données de la table `document_categorie_field_rule`
--

INSERT INTO `document_categorie_field_rule` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `expresion`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 14:40:41', '', NULL, 'nn', '! = null', 'Not Null', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 14:41:25', '', NULL, 'not-empty', '.isEmpty() == false', 'Not Empty', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
(4),
(4);

--
-- Déchargement des données de la table `document_categorie_seq`
--

INSERT INTO `document_categorie_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document_field`
--

INSERT INTO `document_field` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `value`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `document`, `document_field_state`, `field`) VALUES
(1, 'anonymousUser', '2023-08-01 20:44:46', '', NULL, '200', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1),
(2, 'anonymousUser', '2023-08-01 20:44:46', '', NULL, '300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 2);

--
-- Déchargement des données de la table `document_field_seq`
--

INSERT INTO `document_field_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document_field_state`
--

INSERT INTO `document_field_state` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `style`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-01 20:42:17', '', NULL, 'valide', 'Valide', 'info', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-01 20:42:52', 'anonymousUser', '2023-08-02 14:37:20', 'rejete', 'Rejete', 'warning', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
(6),
(6);

--
-- Déchargement des données de la table `document_state`
--

INSERT INTO `document_state` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `style`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-01 20:43:22', 'anonymousUser', '2023-08-02 14:42:03', 'valide', 'Valide', 'success', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-01 20:43:43', 'anonymousUser', '2023-08-01 20:45:50', 'rejete', 'Rejete', 'error', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_state_seq`
--

INSERT INTO `document_state_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `document_tag_seq`
--

INSERT INTO `document_tag_seq` (`next_val`) VALUES
(1),
(1);

--
-- Déchargement des données de la table `document_type`
--

INSERT INTO `document_type` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-01 20:39:21', '', NULL, 'word', 'Word', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-01 20:39:27', '', NULL, 'excel', 'Excel', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `document_type_seq`
--

INSERT INTO `document_type_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `entite_administrative`
--

INSERT INTO `entite_administrative` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `description`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `entite_administrative_type`, `utilisateur`) VALUES
(1, 'anonymousUser', '2023-08-02 15:02:38', '', NULL, 'dep-info', NULL, 'Department Inforrmatique', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1),
(2, 'anonymousUser', '2023-08-02 15:03:03', '', NULL, 'div-achat', NULL, 'Division Achat', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2);

--
-- Déchargement des données de la table `entite_administrative_seq`
--

INSERT INTO `entite_administrative_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `entite_administrative_type`
--

INSERT INTO `entite_administrative_type` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 15:00:43', 'anonymousUser', '2023-08-02 15:01:21', 'departement', 'Departement', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 15:01:03', '', NULL, 'division', 'Division', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'anonymousUser', '2023-08-02 15:01:12', '', NULL, 'service', 'Service', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `entite_administrative_type_seq`
--

INSERT INTO `entite_administrative_type_seq` (`next_val`) VALUES
(4),
(4);

--
-- Déchargement des données de la table `etablissement_seq`
--

INSERT INTO `etablissement_seq` (`next_val`) VALUES
(1);

--
-- Déchargement des données de la table `etat_utilisateur`
--

INSERT INTO `etat_utilisateur` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 14:50:37', '', NULL, 'actif', 'Actif', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 14:50:51', '', NULL, 'desactive', 'Desactive', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `etat_utilisateur_seq`
--

INSERT INTO `etat_utilisateur_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `field`
--

INSERT INTO `field` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-01 20:40:29', '', NULL, 'ttc', 'Montant TTC', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-01 20:40:42', '', NULL, 'ht', 'Montant HT', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `field_seq`
--

INSERT INTO `field_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `utilisateur`) VALUES
(1, 'anonymousUser', '2023-08-02 14:59:17', '', NULL, 'ingenieure', 'Ingenieure', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
(2, 'anonymousUser', '2023-08-02 15:00:09', '', NULL, 'chef-department', 'Chef department', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);

--
-- Déchargement des données de la table `groupe_seq`
--

INSERT INTO `groupe_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `groupe_utilisateur`
--

INSERT INTO `groupe_utilisateur` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `date_ajout`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`, `etat_utilisateur`, `groupe`, `role_utilisateur`, `utilisateur`) VALUES
(1, 'anonymousUser', '2023-08-02 14:59:17', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 2),
(2, 'anonymousUser', '2023-08-02 14:59:17', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 2, 3),
(3, 'anonymousUser', '2023-08-02 15:00:09', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 2, 2, 1),
(4, 'anonymousUser', '2023-08-02 15:00:09', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 2, 1, 3);

--
-- Déchargement des données de la table `groupe_utilisateur_seq`
--

INSERT INTO `groupe_utilisateur_seq` (`next_val`) VALUES
(5),
(5);

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
(1, 'DocumentPartageGroupe.edit'),
(2, 'DocumentPartageGroupe.list'),
(3, 'DocumentPartageGroupe.view'),
(4, 'DocumentPartageGroupe.add'),
(5, 'DocumentPartageGroupe.delete'),
(6, 'EtatUtilisateur.edit'),
(7, 'EtatUtilisateur.list'),
(8, 'EtatUtilisateur.view'),
(9, 'EtatUtilisateur.add'),
(10, 'EtatUtilisateur.delete'),
(11, 'GroupeUtilisateur.edit'),
(12, 'GroupeUtilisateur.list'),
(13, 'GroupeUtilisateur.view'),
(14, 'GroupeUtilisateur.add'),
(15, 'GroupeUtilisateur.delete'),
(16, 'RoleUtilisateur.edit'),
(17, 'RoleUtilisateur.list'),
(18, 'RoleUtilisateur.view'),
(19, 'RoleUtilisateur.add'),
(20, 'RoleUtilisateur.delete'),
(21, 'Document.edit'),
(22, 'Document.list'),
(23, 'Document.view'),
(24, 'Document.add'),
(25, 'Document.delete'),
(26, 'DocumentField.edit'),
(27, 'DocumentField.list'),
(28, 'DocumentField.view'),
(29, 'DocumentField.add'),
(30, 'DocumentField.delete'),
(31, 'DocumentFieldState.edit'),
(32, 'DocumentFieldState.list'),
(33, 'DocumentFieldState.view'),
(34, 'DocumentFieldState.add'),
(35, 'DocumentFieldState.delete'),
(36, 'EntiteAdministrativeType.edit'),
(37, 'EntiteAdministrativeType.list'),
(38, 'EntiteAdministrativeType.view'),
(39, 'EntiteAdministrativeType.add'),
(40, 'EntiteAdministrativeType.delete'),
(41, 'DocumentPartageUtilisateur.edit'),
(42, 'DocumentPartageUtilisateur.list'),
(43, 'DocumentPartageUtilisateur.view'),
(44, 'DocumentPartageUtilisateur.add'),
(45, 'DocumentPartageUtilisateur.delete'),
(46, 'DocumentCategorie.edit'),
(47, 'DocumentCategorie.list'),
(48, 'DocumentCategorie.view'),
(49, 'DocumentCategorie.add'),
(50, 'DocumentCategorie.delete'),
(51, 'DocumentCategorieFieldRule.edit'),
(52, 'DocumentCategorieFieldRule.list'),
(53, 'DocumentCategorieFieldRule.view'),
(54, 'DocumentCategorieFieldRule.add'),
(55, 'DocumentCategorieFieldRule.delete'),
(56, 'Groupe.edit'),
(57, 'Groupe.list'),
(58, 'Groupe.view'),
(59, 'Groupe.add'),
(60, 'Groupe.delete'),
(61, 'Field.edit'),
(62, 'Field.list'),
(63, 'Field.view'),
(64, 'Field.add'),
(65, 'Field.delete'),
(66, 'Utilisateur.edit'),
(67, 'Utilisateur.list'),
(68, 'Utilisateur.view'),
(69, 'Utilisateur.add'),
(70, 'Utilisateur.delete'),
(71, 'DocumentState.edit'),
(72, 'DocumentState.list'),
(73, 'DocumentState.view'),
(74, 'DocumentState.add'),
(75, 'DocumentState.delete'),
(76, 'AccessShare.edit'),
(77, 'AccessShare.list'),
(78, 'AccessShare.view'),
(79, 'AccessShare.add'),
(80, 'AccessShare.delete'),
(81, 'DocumentCategorieField.edit'),
(82, 'DocumentCategorieField.list'),
(83, 'DocumentCategorieField.view'),
(84, 'DocumentCategorieField.add'),
(85, 'DocumentCategorieField.delete'),
(86, 'DocumentType.edit'),
(87, 'DocumentType.list'),
(88, 'DocumentType.view'),
(89, 'DocumentType.add'),
(90, 'DocumentType.delete'),
(91, 'EntiteAdministrative.edit'),
(92, 'EntiteAdministrative.list'),
(93, 'EntiteAdministrative.view'),
(94, 'EntiteAdministrative.add'),
(95, 'EntiteAdministrative.delete');

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
-- Déchargement des données de la table `role_utilisateur`
--

INSERT INTO `role_utilisateur` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 14:53:20', '', NULL, 'admin', 'Admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 14:53:29', '', NULL, 'membre', 'Membre', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `role_utilisateur_seq`
--

INSERT INTO `role_utilisateur_seq` (`next_val`) VALUES
(3),
(3);

--
-- Déchargement des données de la table `tag`
--

INSERT INTO `tag` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 11:28:33', '', NULL, 't1', 't1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 11:28:40', '', NULL, 't2', 't2', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'anonymousUser', '2023-08-02 11:28:47', '', NULL, 't3', 't3', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `tag_seq`
--

INSERT INTO `tag_seq` (`next_val`) VALUES
(4),
(4);

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
(97, NULL, '2023-08-01 20:34:08', NULL, NULL, b'1', b'1', '2023-08-01 20:34:08', b'1', 'admin', b'1', 'admin', '$2a$10$IKO8Jpu5nr.iu/4oK2Bnu.89mwxc99hEnfh30T73WyEvqAi5/IQFu', b'0', 'admin', NULL, 'admin', NULL),
(99, NULL, '2023-08-01 20:34:08', NULL, NULL, b'1', b'1', '2023-08-01 20:34:08', b'1', 'agent', b'1', 'agent', '$2a$10$QD3dh104N4oSHyh7GXii/.mdfGrtgpC/rEpf8yUndyWdAvUhs9abe', b'0', 'agent', NULL, 'agent', NULL);

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `email`, `nom`, `prenom`, `action_type`, `data`, `date`, `object_id`, `object_name`, `user_id`, `username`) VALUES
(1, 'anonymousUser', '2023-08-02 14:51:53', '', NULL, 'zouani.younes@gmail.com', 'Zouani', 'Younes', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'anonymousUser', '2023-08-02 14:52:16', '', NULL, 't.ahmed@uca.ma', 'Taoufiq', 'Ahmed', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'anonymousUser', '2023-08-02 14:52:52', '', NULL, 'idrissi@gmail,com', 'Idrissi', 'Idrissi', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Déchargement des données de la table `utilisateur_seq`
--

INSERT INTO `utilisateur_seq` (`next_val`) VALUES
(4),
(4);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
