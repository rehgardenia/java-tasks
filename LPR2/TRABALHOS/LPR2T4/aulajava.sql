CREATE DATABASE aulajava;
GO

USE aulajava;
GO

CREATE TABLE tbcargos (
    cd_cargo SMALLINT NOT NULL PRIMARY KEY,
    ds_cargo CHAR(20) NULL
);

CREATE TABLE tbfuncs (
    cod_func DECIMAL(9,0) NOT NULL PRIMARY KEY,
    nome_func CHAR(30) NULL,
    sal_func MONEY NULL,
    cod_cargo SMALLINT NULL,
    CONSTRAINT FK_tbfuncs_tbcargos FOREIGN KEY (cod_cargo) REFERENCES tbcargos(cd_cargo)
);

INSERT INTO tbcargos (cd_cargo, ds_cargo) VALUES (1, 'Administrativo');
INSERT INTO tbcargos (cd_cargo, ds_cargo) VALUES (2, 'Desenvolvedor');
INSERT INTO tbcargos (cd_cargo, ds_cargo) VALUES (3, 'Analista');

INSERT INTO tbfuncs (cod_func, nome_func, sal_func, cod_cargo) VALUES (1, 'Marcelo', 2000.00, 1);
INSERT INTO tbfuncs (cod_func, nome_func, sal_func, cod_cargo) VALUES (2, 'Marcelo Santos', 3500.00, 2);
INSERT INTO tbfuncs (cod_func, nome_func, sal_func, cod_cargo) VALUES (3, 'Maria Oliveira', 4200.50, 3);
INSERT INTO tbfuncs (cod_func, nome_func, sal_func, cod_cargo) VALUES (4, 'Marcos Silva', 1800.00, 1);
GO