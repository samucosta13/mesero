CREATE SCHEMA mesero;
USE mesero;

CREATE TABLE administrador(
id_administrador INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(300) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
senha VARCHAR(100) NOT NULL,
PRIMARY KEY (id_administrador)
);

CREATE TABLE atendente(
id_atendente INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(300) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
senha VARCHAR(100) NOT NULL,
PRIMARY KEY (id_atendente)
);

CREATE TABLE central(
id_central INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
id_administrador INT NOT NULL,
CONSTRAINT FOREIGN KEY (id_administrador) REFERENCES administrador(id_administrador) ON DELETE CASCADE,
PRIMARY KEY (id_central)
);

CREATE TABLE item_pedido(
id_item_pedido INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
descricao VARCHAR(300),
id_central INT NOT NULL,
CONSTRAINT FOREIGN KEY (id_central) REFERENCES central(id_central) ON DELETE CASCADE,
PRIMARY KEY (id_item_pedido)
);

CREATE TABLE comanda(
id_comanda INT NOT NULL AUTO_INCREMENT,
numero INT NOT NULL,
descricao VARCHAR(200),
id_central INT NOT NULL,
id_atendente INT NOT NULL,
CONSTRAINT FOREIGN KEY (id_central) REFERENCES central(id_central) ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY (id_atendente) REFERENCES atendente(id_atendente) ON DELETE CASCADE,
PRIMARY KEY (id_comanda)
);

CREATE TABLE pedido(
id_pedido INT NOT NULL AUTO_INCREMENT,
mesa INT NOT NULL,
estado VARCHAR(25) NOT NULL,
id_comanda INT NOT NULL,
CONSTRAINT FOREIGN KEY (id_comanda) REFERENCES comanda(id_comanda) ON DELETE CASCADE,
PRIMARY KEY (id_pedido)
);

CREATE TABLE registro(
id_registro INT NOT NULL AUTO_INCREMENT,
id_pedido INT NOT NULL,
id_item_pedido INT NOT NULL,
quantidade INT NOT NULL,
salvo_em DATETIME 
DEFAULT CURRENT_TIMESTAMP 
ON UPDATE CURRENT_TIMESTAMP,
CONSTRAINT FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY (id_item_pedido) REFERENCES item_pedido(id_item_pedido) ON DELETE CASCADE,
PRIMARY KEY (id_registro)
);