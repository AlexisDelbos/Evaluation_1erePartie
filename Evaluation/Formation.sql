-- -----------------------------------------------------------------------------
-- - Reconstruction de la B.D.D                        ---
-- -----------------------------------------------------------------------------
DROP DATABASE IF EXISTS Formation;
CREATE DATABASE Formation;
USE Formation;

-- -----------------------------------------------------------------------------
-- - Construction de la table des catégories                         ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_category (
    idCategory INT(4) AUTO_INCREMENT PRIMARY KEY,
    nameCategory VARCHAR(100) NOT NULL,
    descriptionCategory VARCHAR(100)
)ENGINE = InnoDB;

INSERT INTO T_category (nameCategory, descriptionCategory) VALUES ('Dev Web', 'A sujet des sites web');
INSERT INTO T_category (nameCategory, descriptionCategory) VALUES ('Cms', 'Site e-commerce');
INSERT INTO T_category (nameCategory, descriptionCategory) VALUES ('Bureautique', 'Logiciel gestion');
INSERT INTO T_category (nameCategory, descriptionCategory) VALUES ('IA', 'Gestion & utilisation IA');
INSERT INTO T_category (nameCategory, descriptionCategory) VALUES ('CyberSecurite', 'Securite reseau');

-- -----------------------------------------------------------------------------
-- - Construction de la table des Formations en vente                         ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_formations (
    idFormation INT(4) AUTO_INCREMENT PRIMARY KEY,
    nameFormation VARCHAR(100) NOT NULL,
    descriptionFormation VARCHAR(100) NOT NULL,
    durationFormation INT(4),
    typeFormation ENUM('presentiel', 'distanciel') NOT NULL,
    priceFormation FLOAT(8, 2) NOT NULL DEFAULT 0,
    idCategory				int(4),
	FOREIGN KEY (idCategory)	REFERENCES T_category(idCategory)

)ENGINE = InnoDB;

INSERT INTO T_formations (nameFormation, descriptionFormation, durationFormation, typeFormation, priceFormation,idCategory) VALUES  ('Java', 'Java SE8 : Syntaxe & POO', 20, 'presentiel', 2000.00,5);
INSERT INTO T_formations (nameFormation, descriptionFormation, durationFormation, typeFormation, priceFormation,idCategory) VALUES   ('Java avance', 'Exceptions, fichiers,formation JDBC, threads', 20, 'distanciel', 2500.00,4);
INSERT INTO T_formations (nameFormation, descriptionFormation, durationFormation, typeFormation, priceFormation,idCategory) VALUES    ('Spring', 'Spring Core/MVC/Security', 20, 'presentiel', 2300.00,3);
INSERT INTO T_formations (nameFormation, descriptionFormation, durationFormation, typeFormation, priceFormation,idCategory) VALUES    ('PHP Frameworks', 'Symfony', 15, 'distanciel', 1800.00,2);
INSERT INTO T_formations (nameFormation, descriptionFormation, durationFormation, typeFormation, priceFormation,idCategory) VALUES    ('C#', 'DotNet Core', 20, 'presentiel', 2100.00,1);
    
-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
	idUser				int(4)		PRIMARY KEY AUTO_INCREMENT,
	loginUser			varchar(20)	NOT NULL UNIQUE,
	passwordUser			varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users (idUser, loginUser, passwordUser) VALUES ( 1, 'Sung' ,	'Jinwoo' );
INSERT INTO T_Users (idUser, loginUser, passwordUser) VALUES ( 2, 'Aoi',	'Ashito' );
INSERT INTO T_Users (idUser, loginUser, passwordUser) VALUES ( 3, 'Son' ,	'Goku' );
INSERT INTO T_Users (idUser, loginUser, passwordUser) VALUES ( 4, 'Cha'   ,	'Hae' );
INSERT INTO T_Users (idUser, loginUser, passwordUser) VALUES ( 5, 'Peepo'     ,	'Thefrog' );


-- -----------------------------------------------------------------------------
-- - Construction de la table des clients	                                 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Customers (
	idCustomer				int(4)		PRIMARY KEY AUTO_INCREMENT,
	nameCustomer					varchar(30)	NOT NULL,
	surnameCustomer				varchar(30)	NOT NULL,
	emailCustomer 					varchar(30)	NOT NULL unique,
	phoneCustomer 					varchar(20)	,
	addressCustomer					varchar(50)	,
	idUser					int(4)		NOT NULL,
	FOREIGN KEY (idUser)	REFERENCES T_Users(idUser)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Construction de la table des commandes                         ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Order (
	idOrder				int(4)		PRIMARY KEY AUTO_INCREMENT,
	amountOrder				float(4)	NOT NULL DEFAULT 0,
	idCustomer          INT(4)   	NOT NULL
) ENGINE = InnoDB;


  
CREATE TABLE T_Order_Items (
	idOrderItem			int(4)	PRIMARY KEY AUTO_INCREMENT,
	
	idFormation           INT(4)   NOT NULL,
	FOREIGN KEY(idFormation) REFERENCES T_formations(idFormation),
	
	quantity			FLOAT(4) NOT NULL DEFAULT 1,
	unitaryPrice		FLOAT(4)	NOT NULL DEFAULT 0,
	
	idOrder             INT(4)   NOT NULL,
	FOREIGN KEY(idOrder) REFERENCES T_Order(idOrder)
) ENGINE = InnoDB;



-- SELECT nameFormation,descriptionFormation,durationFormation,typeFormation,priceFormation,nameCategory FROM T_formations INNER JOIN T_category ON T_formations.idCategory=T_category.idCategory;
