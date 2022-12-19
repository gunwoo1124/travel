CREATE TABLE `z_city_info` (
  `ct_idx` bigint NOT NULL AUTO_INCREMENT,
  `ct_state` tinyint(1) NOT NULL DEFAULT '0',
  `ct_create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ct_update_date` datetime DEFAULT NULL,
  `ct_delete_date` datetime DEFAULT NULL,
  `ct_name_kr` varchar(45) NOT NULL,
  `ct_name_en` varchar(45) NOT NULL,
  `ct_country_en` varchar(45) NOT NULL,
  `ct_like_count` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`ct_idx`),
  UNIQUE KEY `ct_idx_UNIQUE` (`ct_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `z_member_info` (
  `mb_idx` bigint NOT NULL AUTO_INCREMENT,
  `mb_state` tinyint(1) NOT NULL DEFAULT '0',
  `mb_create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mb_id` varchar(30) NOT NULL,
  PRIMARY KEY (`mb_idx`),
  UNIQUE KEY `mb_idx_UNIQUE` (`mb_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `z_member_log_action` (
  `ma_idx` bigint NOT NULL,
  `ma_state` tinyint(1) NOT NULL DEFAULT '0',
  `ma_type` tinyint(1) NOT NULL,
  `ma_create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ma_mb_idx` bigint NOT NULL,
  `ma_ct_idx` bigint NOT NULL,
  `ma_mt_idx` bigint DEFAULT NULL,
  `ma_create_timestamp` bigint NOT NULL DEFAULT '-1',
  PRIMARY KEY (`ma_idx`),
  UNIQUE KEY `ma_idx_UNIQUE` (`ma_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `z_member_trip` (
  `mt_idx` bigint NOT NULL,
  `mt_ct_idx` bigint NOT NULL,
  `mt_mb_idx` bigint NOT NULL,
  `mt_state` tinyint(1) NOT NULL DEFAULT '0',
  `mt_create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mt_name` varchar(45) NOT NULL,
  `mt_description` varchar(100) DEFAULT NULL,
  `mt_update_date` datetime DEFAULT NULL,
  `mt_delete_date` datetime DEFAULT NULL,
  `mt_start_date` datetime NOT NULL,
  `mt_end_date` datetime NOT NULL,
  `mt_flag_trip` tinyint(1) NOT NULL DEFAULT '1',
  `mt_create_timestamp` bigint NOT NULL DEFAULT '-1',
  PRIMARY KEY (`mt_idx`),
  UNIQUE KEY `mt_idx_UNIQUE` (`mt_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
