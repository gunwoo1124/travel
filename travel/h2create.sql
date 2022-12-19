CREATE TABLE z_city_info (
	ct_country_en VARCHAR(45) NOT NULL,
	ct_create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	ct_delete_date TIMESTAMP,
	ct_idx BIGINT NOT NULL,
	ct_like_count BIGINT DEFAULT 0 NOT NULL,
	ct_name_en VARCHAR(45) NOT NULL,
	ct_name_kr VARCHAR(45) NOT NULL,
	ct_state INTEGER DEFAULT 0 NOT NULL,
	ct_update_date TIMESTAMP,
	PRIMARY KEY (ct_idx)
);
CREATE TABLE z_member_info (
	mb_idx BIGINT NOT NULL,
	mb_state INTEGER DEFAULT 0 NOT NULL,
	mb_create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	mb_id VARCHAR(30) NOT NULL,
	PRIMARY KEY (mb_idx)
);
CREATE TABLE z_member_log_action (
	ma_idx BIGINT NOT NULL,
	ma_state INTEGER DEFAULT 0 NOT NULL,
	ma_type INTEGER NOT NULL,
	ma_create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	ma_mb_idx BIGINT NOT NULL,
	ma_ct_idx BIGINT NOT NULL,
	ma_mt_idx BIGINT,
	ma_create_timestamp BIGINT DEFAULT -1 NOT NULL,
	PRIMARY KEY (ma_idx)
);
CREATE TABLE z_member_trip (
	mt_idx BIGINT NOT NULL,
	mt_ct_idx BIGINT NOT NULL,
	mt_mb_idx BIGINT NOT NULL,
	mt_state INTEGER DEFAULT 0 NOT NULL,
	mt_create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	mt_name VARCHAR(45) NOT NULL,
	mt_description VARCHAR(100),
	mt_update_date TIMESTAMP,
	mt_delete_date TIMESTAMP,
	mt_start_date TIMESTAMP NOT NULL,
	mt_end_date TIMESTAMP NOT NULL,
	mt_flag_trip INTEGER DEFAULT 1 NOT NULL,
	mt_create_timestamp BIGINT DEFAULT -1 NOT NULL,
	PRIMARY KEY (mt_idx)
);
INSERT INTO z_city_info(ct_idx, ct_state, ct_create_date, ct_update_date, ct_delete_date, ct_name_kr, ct_name_en, ct_country_en, ct_like_count) VALUES (1, 1, '2022-12-13 18:54:44', '2022-12-14 14:47:44', '2022-12-17 23:27:47', '서울', 'Seoul', 'South Korea', 0);
INSERT INTO z_city_info(ct_idx, ct_state, ct_create_date, ct_update_date, ct_delete_date, ct_name_kr, ct_name_en, ct_country_en, ct_like_count) VALUES (2, 0, '2022-12-18 17:30:52', null, null, '성남', 'SeoungNam', 'South Korea', 0);
INSERT INTO z_member_info(mb_idx, mb_state, mb_create_date, mb_id) VALUES (3, 0, '2022-12-13 16:07:38', 'gunwoo');
INSERT INTO z_member_log_action(ma_idx, ma_state, ma_type, ma_create_date, ma_mb_idx, ma_ct_idx, ma_mt_idx, ma_create_timestamp) VALUES (1, 0, 1, '2022-12-18 17:34:48', 3, 2, null, 1671352488000);
INSERT INTO z_member_log_action(ma_idx, ma_state, ma_type, ma_create_date, ma_mb_idx, ma_ct_idx, ma_mt_idx, ma_create_timestamp) VALUES (2, 0, 1, '2022-12-18 23:50:33', 3, 2, null, 1671375033000);
INSERT INTO z_member_log_action(ma_idx, ma_state, ma_type, ma_create_date, ma_mb_idx, ma_ct_idx, ma_mt_idx, ma_create_timestamp) VALUES (3, 0, 1, '2022-12-18 23:50:34', 3, 2, null, 1671375034000);
INSERT INTO z_member_log_action(ma_idx, ma_state, ma_type, ma_create_date, ma_mb_idx, ma_ct_idx, ma_mt_idx, ma_create_timestamp) VALUES (4, 0, 1, '2022-12-18 23:50:35', 3, 2, null, 1671375035000);
INSERT INTO z_member_trip(mt_idx, mt_ct_idx, mt_mb_idx, mt_state, mt_create_date, mt_name, mt_description, mt_update_date, mt_delete_date, mt_start_date, mt_end_date, mt_flag_trip, mt_create_timestamp) VALUES (1, 1, 3, 1, '2022-12-15 17:53:57', 'seoul tour', '여행설명111', '2022-12-16 16:15:29', '2022-12-16 16:16:26', '2022-12-18 16:07:38', '2022-12-25 16:07:38', 0, 1671094437000);
INSERT INTO z_member_trip(mt_idx, mt_ct_idx, mt_mb_idx, mt_state, mt_create_date, mt_name, mt_description, mt_update_date, mt_delete_date, mt_start_date, mt_end_date, mt_flag_trip, mt_create_timestamp) VALUES (2, 2, 3, 0, '2022-12-18 21:51:17', 'scheduler Test', '스케쥴러테스트', null, null, '2022-12-18 22:21:00', '2022-12-18 22:22:00', 0, 1671367877000);
INSERT INTO z_member_trip(mt_idx, mt_ct_idx, mt_mb_idx, mt_state, mt_create_date, mt_name, mt_description, mt_update_date, mt_delete_date, mt_start_date, mt_end_date, mt_flag_trip, mt_create_timestamp) VALUES (3, 2, 3, 0, '2022-12-18 23:33:18', 'sort Test1', '정렬 테스트1', null, null, '2022-12-18 21:55:00', '2022-12-19 21:56:00', 2, 1671373998000);
INSERT INTO z_member_trip(mt_idx, mt_ct_idx, mt_mb_idx, mt_state, mt_create_date, mt_name, mt_description, mt_update_date, mt_delete_date, mt_start_date, mt_end_date, mt_flag_trip, mt_create_timestamp) VALUES (4, 2, 3, 0, '2022-12-18 23:33:23', 'sort Test2', '정렬 테스트2', null, null, '2022-12-18 21:00:00', '2022-12-19 21:56:00', 2, 1671374003000);
INSERT INTO z_member_trip(mt_idx, mt_ct_idx, mt_mb_idx, mt_state, mt_create_date, mt_name, mt_description, mt_update_date, mt_delete_date, mt_start_date, mt_end_date, mt_flag_trip, mt_create_timestamp) VALUES (5, 2, 3, 0, '2022-12-18 23:33:49', 'sort Test3', '정렬 테스트3', null, null, '2022-12-19 21:00:00', '2022-12-19 21:56:00', 1, 1671374029000);
INSERT INTO z_member_trip(mt_idx, mt_ct_idx, mt_mb_idx, mt_state, mt_create_date, mt_name, mt_description, mt_update_date, mt_delete_date, mt_start_date, mt_end_date, mt_flag_trip, mt_create_timestamp) VALUES (6, 2, 3, 0, '2022-12-18 23:34:08', 'sort Test4', '정렬 테스트4', null, null, '2022-12-19 21:55:00', '2022-12-19 21:56:00', 1, 1671374048000);
