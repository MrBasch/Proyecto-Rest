BEGIN TRANSACTION;
--
--PAISES
--
DROP TABLE IF EXISTS pais CASCADE;
CREATE TABLE pais(
    pk bigserial NOT NULL, -- Autoincremental
    codeAlpha2 varchar(255) NOT NULL, -- codigo lpha 2 del pais segun ISO 3166-1
    codeAlpha3 varchar(255) NOT NULL, -- codigo lpha 3 del pais segun ISO 3166-1
    currencyCode varchar(255) NOT NULL, -- codigo de la moneda
    currencyName varchar(255) NOT NULL, -- nombre de la moneda
    Lang varchar(255) NOT NULL, -- codigo ISO 639
    Name varchar(255) NOT NULL, -- nombre del pais
    UNIQUE  (codeAlpha2),
    UNIQUE (codeAlpha3),
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX ON pais(UPPER(TRIM (both FROM codeAlpha2)));
CREATE UNIQUE INDEX ON pais(UPPER(TRIM (both FROM codeAlpha3)));

--
--INDICADORES
--
DROP TABLE IF EXISTS indicador CASCADE;
CREATE TABLE indicador(
    pk bigserial NOT NULL, --Autoincremental
    Name varchar(255) NOT NULL, -- nombre del indicador
    unit varchar(255) NOT NULL, -- unidad del indicador
    descripcion varchar(800) NOT NULL, -- descripcion del indicador
    cod varchar(255) NOT NULL, -- codigo del indicador
    PRIMARY KEY (pk)
);

--
--PERIODOS
--
DROP TABLE IF EXISTS periodo CASCADE;
CREATE TABLE periodo(
    pk bigserial NOT NULL, --Autoincremental
    año int NOT NULL DEFAULT '0',  -- periodo de los datos (año) 
    PRIMARY KEY (pk)
);

--
--VALORES
--
DROP TABLE IF EXISTS fact CASCADE;
CREATE TABLE fact(
    pk bigserial NOT NULL, -- Autoincremental
    fk_periodo bigint NOT NULL, --referencia a la tabla periodo, fecha de los datos 
    fk_pais bigint NOT NULL, --referencia al pais al cual le pertenecen los datos 
    fk_indicador bigint NOT NULL, -- referencia a los datos de los indicadores 
    Valor float NOT NULL DEFAULT '0', -- Valor del indicador 
    FOREIGN KEY (fk_periodo) REFERENCES periodo(pk) ON UPDATE CASCADE ON DELETE CASCADE, 
    FOREIGN KEY (fk_pais) REFERENCES pais(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (fk_indicador) REFERENCES indicador(pk) ON UPDATE CASCADE ON DELETE CASCADE, 
    PRIMARY KEY (pk)
);
CREATE INDEX ON fact(fk_periodo);
CREATE INDEX ON fact(fk_indicador);
CREATE INDEX ON fact(fk_pais);
COMMIT;
