DROP TABLE IF EXISTS AGENT;

CREATE TABLE AGENT (
	id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	id_number VARCHAR(20) NOT NULL,
	team_id VARCHAR(20),
	manager_id VARCHAR(20)
);

INSERT INTO AGENT (first_name, last_name, id_number, team_id) VALUES
	('Peter', 'Kh', '1234567890123', '1'),
	('John', 'B', '8501126010080', '2'),
	('Sipho', 'M', '8501136001525', '3'),
	('Anele', 'M', '8501015662070', '4');

DROP TABLE IF EXISTS MANAGER;

CREATE TABLE MANAGER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    id_number VARCHAR(20) NOT NULL,
    team_id VARCHAR(20)
);

INSERT INTO MANAGER (first_name, last_name, id_number, team_id) VALUES
    ('Ben', 'Kh', '1234567890123', '1'),
    ('Noni', 'B', '8501126010080', '2'),
    ('Spera', 'M', '8501136001525', '3'),
    ('Pam', 'M', '8501015662070', '4');

DROP TABLE IF EXISTS TEAM;

CREATE TABLE TEAM (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	agent_id VARCHAR(20),
	manager_id VARCHAR(20)
);

INSERT INTO TEAM (name) VALUES
	('Green'),
	('Blue'),
	('Red'),
	('Yellow');
