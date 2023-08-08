-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 02 août 2023 à 17:06
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

-- --------------------------------------------------------

--
-- Structure de la table `access_share`
--

CREATE TABLE `access_share` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `access_share_seq`
--

CREATE TABLE `access_share_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `archive` bit(1) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date_last_update` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `folder` bit(1) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `size` decimal(19,2) DEFAULT NULL,
  `upload_date` datetime DEFAULT NULL,
  `versionne` bit(1) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `document_categorie` bigint(20) DEFAULT NULL,
  `document_state` bigint(20) DEFAULT NULL,
  `document_type` bigint(20) DEFAULT NULL,
  `entite_administrative` bigint(20) DEFAULT NULL,
  `utilisateur` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_categorie`
--

CREATE TABLE `document_categorie` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_categorie_field`
--

CREATE TABLE `document_categorie_field` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `document_categorie` bigint(20) DEFAULT NULL,
  `document_categorie_field_rule` bigint(20) DEFAULT NULL,
  `field` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_categorie_field_rule`
--

CREATE TABLE `document_categorie_field_rule` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `expresion` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_categorie_field_rule_seq`
--

CREATE TABLE `document_categorie_field_rule_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_categorie_field_seq`
--

CREATE TABLE `document_categorie_field_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_categorie_seq`
--

CREATE TABLE `document_categorie_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_field`
--

CREATE TABLE `document_field` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `document` bigint(20) DEFAULT NULL,
  `document_field_state` bigint(20) DEFAULT NULL,
  `field` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_field_seq`
--

CREATE TABLE `document_field_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_field_state`
--

CREATE TABLE `document_field_state` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_field_state_seq`
--

CREATE TABLE `document_field_state_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_partage_groupe`
--

CREATE TABLE `document_partage_groupe` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `date_share` datetime DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `access_share` bigint(20) DEFAULT NULL,
  `document` bigint(20) DEFAULT NULL,
  `groupe` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_partage_groupe_seq`
--

CREATE TABLE `document_partage_groupe_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_partage_utilisateur`
--

CREATE TABLE `document_partage_utilisateur` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `date_share` datetime DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `access_share` bigint(20) DEFAULT NULL,
  `document` bigint(20) DEFAULT NULL,
  `utilisateur` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_partage_utilisateur_seq`
--

CREATE TABLE `document_partage_utilisateur_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_seq`
--

CREATE TABLE `document_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_state`
--

CREATE TABLE `document_state` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_state_seq`
--

CREATE TABLE `document_state_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_tag`
--

CREATE TABLE `document_tag` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `document` bigint(20) DEFAULT NULL,
  `tag` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_tag_seq`
--

CREATE TABLE `document_tag_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_type`
--

CREATE TABLE `document_type` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `document_type_seq`
--

CREATE TABLE `document_type_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entite_administrative`
--

CREATE TABLE `entite_administrative` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `entite_administrative_type` bigint(20) DEFAULT NULL,
  `utilisateur` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entite_administrative_seq`
--

CREATE TABLE `entite_administrative_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entite_administrative_type`
--

CREATE TABLE `entite_administrative_type` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entite_administrative_type_seq`
--

CREATE TABLE `entite_administrative_type_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

CREATE TABLE `etablissement` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement_seq`
--

CREATE TABLE `etablissement_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etat_utilisateur`
--

CREATE TABLE `etat_utilisateur` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etat_utilisateur_seq`
--

CREATE TABLE `etat_utilisateur_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `field`
--

CREATE TABLE `field` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `field_seq`
--

CREATE TABLE `field_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `utilisateur` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `groupe_seq`
--

CREATE TABLE `groupe_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `groupe_utilisateur`
--

CREATE TABLE `groupe_utilisateur` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `date_ajout` datetime DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `etat_utilisateur` bigint(20) DEFAULT NULL,
  `groupe` bigint(20) DEFAULT NULL,
  `role_utilisateur` bigint(20) DEFAULT NULL,
  `utilisateur` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `groupe_utilisateur_seq`
--

CREATE TABLE `groupe_utilisateur_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `roles_permissions`
--

CREATE TABLE `roles_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role_app`
--

CREATE TABLE `role_app` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role_utilisateur`
--

CREATE TABLE `role_utilisateur` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role_utilisateur_seq`
--

CREATE TABLE `role_utilisateur_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tag`
--

CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tag_seq`
--

CREATE TABLE `tag_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user_app`
--

CREATE TABLE `user_app` (
  `id` bigint(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_changed` bit(1) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `etablissement` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_seq`
--

CREATE TABLE `utilisateur_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `access_share`
--
ALTER TABLE `access_share`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKen91sbyklybdhvgdpnlr39xrf` (`document_categorie`),
  ADD KEY `FKb6aryo02mphdjxb258c9lg0eu` (`document_state`),
  ADD KEY `FK2kokkipw9627qe8qc7i4x33j0` (`document_type`),
  ADD KEY `FKfq1xmtat4o9cnyxuofnmclyuf` (`entite_administrative`),
  ADD KEY `FK1lwj04jj6pxqxx12tn2m82g80` (`utilisateur`);

--
-- Index pour la table `document_categorie`
--
ALTER TABLE `document_categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `document_categorie_field`
--
ALTER TABLE `document_categorie_field`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrp1x6fqs42ih020o6y7vwsn4l` (`document_categorie`),
  ADD KEY `FKs94tov86jfkdvdqwmal4o75jb` (`document_categorie_field_rule`),
  ADD KEY `FK2j7mkjk67qb2vi0uscgpvpcst` (`field`);

--
-- Index pour la table `document_categorie_field_rule`
--
ALTER TABLE `document_categorie_field_rule`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `document_field`
--
ALTER TABLE `document_field`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgt37ce155dcied3wlfc48dxxc` (`document`),
  ADD KEY `FK15j8h2ouepcs4e62xqpy9y5w9` (`document_field_state`),
  ADD KEY `FKaeltl24m8qrakbs12avbixfhn` (`field`);

--
-- Index pour la table `document_field_state`
--
ALTER TABLE `document_field_state`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `document_partage_groupe`
--
ALTER TABLE `document_partage_groupe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcoir8ul014oeskj12b416t272` (`access_share`),
  ADD KEY `FK3ohjjieisndi4cq742aeu6e2` (`document`),
  ADD KEY `FKm316ppyawykghotwgtmfc7crp` (`groupe`);

--
-- Index pour la table `document_partage_utilisateur`
--
ALTER TABLE `document_partage_utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnu0wpg04nsj10x5ncp9getluw` (`access_share`),
  ADD KEY `FK95mn6rlm038whbdw971rtqnl8` (`document`),
  ADD KEY `FKbdo49bg0gj71m3yn02bh7vkwd` (`utilisateur`);

--
-- Index pour la table `document_state`
--
ALTER TABLE `document_state`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `document_tag`
--
ALTER TABLE `document_tag`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9mj03r1iafai7idm108udicum` (`document`),
  ADD KEY `FKb9j3gsnv79xx4fthjh16mbew1` (`tag`);

--
-- Index pour la table `document_type`
--
ALTER TABLE `document_type`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `entite_administrative`
--
ALTER TABLE `entite_administrative`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7eeck7at0hx7mo9rcr8xk068e` (`entite_administrative_type`),
  ADD KEY `FK5sw4kyxfsy8ycbu14ebinjgf` (`utilisateur`);

--
-- Index pour la table `entite_administrative_type`
--
ALTER TABLE `entite_administrative_type`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `etat_utilisateur`
--
ALTER TABLE `etat_utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `field`
--
ALTER TABLE `field`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpo0t0gbytq9uk7rpr4jo15be5` (`utilisateur`);

--
-- Index pour la table `groupe_utilisateur`
--
ALTER TABLE `groupe_utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8r9yfmhipmib92hllsh06vblf` (`etat_utilisateur`),
  ADD KEY `FKiy2le8hl3xcec086nvn0ot4g6` (`groupe`),
  ADD KEY `FKhsrf4xth1khrkrrhtigf9pvok` (`role_utilisateur`),
  ADD KEY `FK71pukqb2w18m0ta1wv6keiny` (`utilisateur`);

--
-- Index pour la table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `roles_permissions`
--
ALTER TABLE `roles_permissions`
  ADD KEY `FKboeuhl31go7wer3bpy6so7exi` (`permission_id`),
  ADD KEY `FK3q3rt3at2wf4ooe7npa3et6yb` (`role_id`);

--
-- Index pour la table `role_app`
--
ALTER TABLE `role_app`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `role_utilisateur`
--
ALTER TABLE `role_utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FK4e8pdqeupv69eukb2bvy2ftbd` (`role_id`),
  ADD KEY `FK50gpsre6oxwwqf394f8wov1yf` (`user_id`);

--
-- Index pour la table `user_app`
--
ALTER TABLE `user_app`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2xblr2jfuwcj4ktkjxbf8ir13` (`etablissement`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
