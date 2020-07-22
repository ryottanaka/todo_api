# todo_api

# DDL
CREATE TABLE TODO (
	ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	TITLE VARCHAR(20) NOT NULL,
	DETAIL VARCHAR(255),
	DEADLINE DATE ,
	IS_COMPLETED INT NOT NULL,
	REGISTER_DATE DATE not null,
	UPDATE_DATE DATE not null
);