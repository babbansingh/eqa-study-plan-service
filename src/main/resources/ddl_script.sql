create database eqa-surveydb;
use eqa-surveydb;
CREATE TABLE `survey_form_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `survey_id` bigint DEFAULT NULL,
  `student_serial_number` int DEFAULT NULL,
  `clo_id` bigint DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `course_code` varchar(255) DEFAULT NULL,
  `section` int DEFAULT NULL,
  `department_id` varchar(255) DEFAULT NULL,
  `campus_id` varchar(255) DEFAULT NULL,
  `college_id` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf16 COLLATE=utf8_unicode_ci;

CREATE TABLE `survey_link_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_code` varchar(255) DEFAULT NULL,
  `section_number` int DEFAULT NULL,
  `no_of_days` int DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `department_id` varchar(255) DEFAULT NULL,
  `campus_id` varchar(255) DEFAULT NULL,
  `college_id` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `clos_count` int DEFAULT NULL,
  `student_count` int DEFAULT NULL,
  `conducted_survey_count` int DEFAULT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf16 COLLATE=utf8_unicode_ci;

ALTER TABLE survey_form_data
PARTITION BY LIST COLUMNS (year, semester) (
    PARTITION p_2022_spring VALUES IN ((2024, 'Spring')),
    PARTITION p_2022_fall VALUES IN ((2024, 'Fall')),
    PARTITION p_2023_spring VALUES IN ((2025, 'Spring')),
    PARTITION p_2023_fall VALUES IN ((2025, 'Fall')),
    PARTITION p_2024_spring VALUES IN ((2026, 'Spring')),
    PARTITION p_2024_fall VALUES IN ((2026, 'Fall'))
);

ALTER TABLE survey_form_data
PARTITION BY LIST COLUMNS (college_id, campus_code) (
    PARTITION p_college1_campus1 VALUES IN (('College1', 'Campus1')),
    PARTITION p_college1_campus2 VALUES IN (('College1', 'Campus2')),
    PARTITION p_college2_campus1 VALUES IN (('College2', 'Campus1')),
    PARTITION p_college2_campus2 VALUES IN (('College2', 'Campus2'))
);
