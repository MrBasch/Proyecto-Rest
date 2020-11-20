BEGIN TRANSACTION;

DROP TABLE IF EXISTS pais CASCADE;
CREATE TABLE pais(
    pk bigserial NOT NULL, -- Autoincremental
    codeAlpha2 varchar(255), -- codigo lpha 2 del pais segun iso 3166-1
    codeAlpha3 varchar(255), -- codigo lpha 3 del pais segun iso 3166-1
    currencyCode varchar(255), -- codigo de la moneda
    currencyName varchar(255), -- nombre de la moneda
    Lang varchar(255), -- codigo iso 4217 nombre moneda nacional
    Name varchar(255), -- nombre del pais 
    Region varchar(255), -- region a la cual pertenece el pais 
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX ON pais(UPPER(TRIM(both FROM codeAlpha2)));
CREATE UNIQUE INDEX ON pais(UPPER(TRIM(both FROM codeAlpha3)));
CREATE UNIQUE INDEX ON pais(UPPER(TRIM(both FROM currencyCode)));
CREATE UNIQUE INDEX ON pais(UPPER(TRIM(both FROM Region)));
CREATE UNIQUE INDEX ON pais(UPPER(TRIM(both FROM Lang)));
CREATE UNIQUE INDEX ON pais(UPPER(TRIM(both FROM currencyCode)));

DROP TABLE IF EXISTS indicador CASCADE;
CREATE TABLE indicadores(
    pk bigserial NOT NULL, --Autoincremental
    Name varchar(255), -- nombre del indicador
    unit varchar(255), -- unidad del indicador
    cod varchar(255), -- codigo del indicador
    PRIMARY KEY (pk)
);

DROP TABLE IF EXISTS periodo CASCADE;
CREATE TABLE periodos(
    pk bigserial NOT NULL, --Autoincremental
    año int NOT NULL,  -- periodo de los datos (año) 
    PRIMARY KEY (pk)
);

DROP TABLE IF EXISTS fact CASCADE;
CREATE TABLE fact(
    pk bigserial NOT NULL, -- Autoincremental
    fk_periodo bigint NOT NULL, --referencia a la tabla periodo, fecha de los datos 
    fk_pais bigint NOT NULL, --referencia al pais al cual le pertenecen los datos 
    fk_indicadores bigint NOT NULL, -- referencia a los datos de los indicadores 
    PIB int, -- Producto interno bruto 
    TDA int,  --Tasa de desempleo anual
    IFL int,  -- Inflacion
    IVA int,  --Impuesto valor agregado
    PRF int,  -- Presion fiscal 
    SMI int,  -- Salario minimo
    TSC int, -- Tasa de cambio US$ a actuales 
    DBI int,  -- Doing business index (indice de facilidad para hacer negocios)
    FOREIGN KEY (fk_periodo) REFERENCES periodo(pk) ON UPDATE CASCADE ON DELETE CASCADE, 
    FOREIGN KEY (fk_pais) REFERENCES pais(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (fk_indicadores) REFERENCES indicador(pk) ON UPDATE CASCADE ON DELETE CASCADE, 
     PRIMARY KEY (pk)
);
COMMIT;
