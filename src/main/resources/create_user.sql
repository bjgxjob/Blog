CREATE TABLE IF NOT EXISTS USER (
	_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id VARCHAR(50) NOT NULL DEFAULT '5b6b8f7018926d3e15bbb5eed75a6e3a',
	name VARCHAR(50) NOT NULL DEFAULT '刘富频',
	nameName VARCHAR(50) NOT NULL DEFAULT 'leleliu008',
	age INT NOT NULL DEFAULT 20,
	password VARCHAR(32) NOT NULL DEFAULT '5b6b8f7018926d3e15bbb5eed75a6e3a',
	phoneNumber VARCHAR(20) ,
	email VARCHAR(50) ,
	city VARCHAR(50) NOT NULL DEFAULT '北京',
	level INT NOT NULL DEFAULT 0,
	levelName VARCHAR(50) NOT NULL DEFAULT '江湖小虾');