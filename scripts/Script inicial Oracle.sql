--Creacion de la base de datos banco nacional
--Autor: Alejandro Medina
--Fecha creacion: 26-04-2020
--Observaciones:
--

CREATE USER banco IDENTIFIED BY banco;

GRANT CONNECT, RESOURCE TO banco;

CONN banco/banco;

DROP TABLE CLIENTES CASCADE CONSTRAINT;
DROP TABLE CUENTAS_BANCARIAS CASCADE CONSTRAINT;
DROP TABLE TIPOS_CUENTAS CASCADE CONSTRAINT;
DROP TABLE TIPOS_TRANSACCIONES CASCADE CONSTRAINT;
DROP TABLE TRANSACCIONES CASCADE CONSTRAINT;
DROP TABLE SUCURSALESs CASCADE CONSTRAINT;
DROP TABLE LUGARES CASCADE CONSTRAINT;

PURGE RECYCLEBIN;

CREATE TABLE CLIENTES(
	id_cliente					NUMBER(12)			NOT NULL,
	nombre_cliente				VARCHAR2(30)		NOT NULL,
	apellido_cliente			VARCHAR2(30)		NOT NULL,
	telefono					NUMBER(10)			NOT NULL,
	id_lugar					NUMBER(5)			NOT NULL,
	correo						VARCHAR2(30)		NOT NULL,
	CONSTRAINT cli_pk_idc		PRIMARY KEY(id_cliente)
);

CREATE TABLE CUENTAS_BANCARIAS(
	id_cuenta					NUMBER(6)			NOT NULL,
	clave 						VARCHAR2(4)			NOT NULL,
	id_cliente					NUMBER(12)			NOT NULL,
	id_tipo_cuenta 				NUMBER(2)			NOT NULL,
	saldo						NUMBER(9)			NOT NULL,
	CONSTRAINT cue_pk_idc		PRIMARY KEY(id_cuenta)
);

CREATE TABLE TIPOS_CUENTAS(
	id_tipo_cuenta 				NUMBER(2)			NOT NULL,
	descripcion					VARCHAR2(30)		NOT NULL,
	CONSTRAINT tipc_pk_idt		PRIMARY KEY(id_tipo_cuenta)
);

CREATE TABLE TIPOS_TRANSACCIONES(
	id_tipo_transaccion			NUMBER(2)			NOT NULL,
	nombre_transaccion			VARCHAR2(30)		NOT NULL,
	CONSTRAINT tipt_pk_idt		PRIMARY KEY(id_tipo_transaccion)
);

CREATE TABLE TRANSACCIONES(
	id_transaccion				NUMBER(6)			NOT NULL,
	monto_transaccion			NUMBER(9)			NOT NULL,
	fecha_transaccion			DATE				NOT NULL,
	id_cuenta_origen			NUMBER(6)			NOT NULL,
	id_cuenta_destino			NUMBER(6)					,
	CONSTRAINT tra_pk_idt		PRIMARY KEY(id_transaccion)
);

CREATE TABLE SUCURSALES(
	id_sucursal					NUMBER(4)			NOT NULL,
	nombre_sucursal				VARCHAR2(30)		NOT NULL,
	id_lugar					NUMBER(5)			NOT NULL,
	CONSTRAINT suc_pk_ids		PRIMARY KEY(id_sucursal)
);

CREATE TABLE LUGARES(
	id_lugar					NUMBER(5)			NOT NULL,
	codigo_postal				NUMBER(8)			NOT NULL,
	direccion					VARCHAR2(30)		NOT NULL,
	nombre_ciudad 				VARCHAR2(30)		NOT NULL,
	CONSTRAINT lug_pk_idl		PRIMARY KEY(id_lugar)
);

ALTER TABLE CLIENTES add(
   CONSTRAINT cli_ck_idc check (id_cliente > 0),
   CONSTRAINT cli_fk_idl foreign key (id_lugar) references LUGARES(id_lugar)
);

ALTER TABLE CUENTAS_BANCARIAS add(
	CONSTRAINT tipc_fk_idc foreign key (id_cliente) references CLIENTES(id_cliente),
	CONSTRAINT tipc_fk_idt foreign key (id_tipo_cuenta) references TIPOS_CUENTAS(id_tipo_cuenta)
);

ALTER TABLE LUGARES add(
	CONSTRAINT lug_ck_idl check (id_lugar>0)
);

ALTER TABLE SUCURSALES add(
	CONSTRAINT suc_ck_ids check (id_sucursal>0),
	CONSTRAINT suc_fk_idl foreign key (id_lugar) references LUGARES(id_lugar)
);

ALTER TABLE TRANSACCIONES add(
	CONSTRAINT tra_ck_idt check (id_transaccion>0),
	CONSTRAINT tra_ck_mon check (monto_transaccion>0),
	CONSTRAINT tra_fk_idc foreign key (id_cuenta_origen) references CUENTAS_BANCARIAS(id_cuenta),
	CONSTRAINT tra_fk_opc foreign key (id_cuenta_destino) references CUENTAS_BANCARIAS(id_cuenta)
);


--Inserciones de lugares-----------
INSERT INTO LUGARES
VALUES (1, 150001, 'Calle 67 #6-24', 'Tunja');

INSERT INTO LUGARES
VALUES (2, 760001, 'Calle 45 #7-20', 'Cali');

-- Inserciones de clientes -------------
INSERT INTO CLIENTES
VALUES (12345678, 'Juan', 'Perez', 3215478965, 1, 'juan.perez@gmail.com');

INSERT INTO CLIENTES
VALUES (98765432, 'Camilo', 'Perez', 3215478964, 1, 'Camilo.perez@gmail.com');

INSERT INTO CLIENTES
VALUES (10076313, 'Maria', 'Perez', 3215478963, 1, 'Maria.perez@gmail.com');

INSERT INTO CLIENTES
VALUES (74335516, 'Nelly', 'Colmenares', 3215478962, 2, 'Nelly.Colmenares@gmail.com');

INSERT INTO CLIENTES
VALUES (24156874, 'Pedro', 'Colmenares', 3215478961, 2, 'Pedro.Colmenares@gmail.com');

--Inserciones tipos de cuenta-----------------
INSERT INTO TIPOS_CUENTAS
VALUES (1, 'Ahorros');

INSERT INTO TIPOS_CUENTAS
VALUES (2, 'Corriente');

INSERT INTO TIPOS_CUENTAS
VALUES (3, 'Credito');

--Inserciones cuentas bancarias 
INSERT INTO CUENTAS_BANCARIAS
VALUES (555555, 1234, 12345678, 1, 2500000);

INSERT INTO CUENTAS_BANCARIAS
VALUES (444444, 1234, 98765432, 2, 40000000);

INSERT INTO CUENTAS_BANCARIAS
VALUES (333333, 1234, 10076313, 1, 452000);

INSERT INTO CUENTAS_BANCARIAS
VALUES (222222, 1234, 74335516, 2, 10000000);

INSERT INTO CUENTAS_BANCARIAS
VALUES (111111, 1234, 24156874, 1, 148000);

--Inserciones de sucursales
INSERT INTO SUCURSALES
VALUES (18316, 'S. Primera', 1);

INSERT INTO SUCURSALES
VALUES (18318, 'S. Segunda', 1);

INSERT INTO SUCURSALES
VALUES (25316, 'S. Primera', 2);

INSERT INTO SUCURSALES
VALUES (25318, 'S. Segunda', 2);

--Inserciones de tipos transacciones
INSERT INTO TIPOS_TRANSACCIONES
VALUES (1, 'Retiro');
--Inserciones de transacciones
INSERT INTO TRANSACCIONES
VALUES (987654, 200000, TO_DATE('07/05/21'), 18316, 1, 222222, null);

INSERT INTO TRANSACCIONES
VALUES (987655, 150000, '2021-05-05', 18318, 1, 222222, null);

INSERT INTO TRANSACCIONES
VALUES (987656, 80000, '2021-05-03', 18316, 1, 222222, null);

INSERT INTO TRANSACCIONES
VALUES (987657, 700000,'2021-04-22', 18318, 1, 222222, null);

INSERT INTO TRANSACCIONES
VALUES (987658, 20000,'2021-04-18', 18318, 1, 222222, null);

INSERT INTO TRANSACCIONES VALUES (100000, '2021-05-01', 18316, 1, 111111, null);

--Procedimiento actualizar saldo 
CREATE OR REPLACE PROCEDURE update_saldo (
	p_id_cuenta IN CUENTAS_BANCARIAS.id_cuenta%TYPE,
	p_nuevo_saldo IN INT
) IS
BEGIN
	UPDATE CUENTAS_BANCARIAS
	SET saldo = (p_nuevo_saldo)
	WHERE id_cuenta = p_id_cuenta;
END;

--Consultas usadas
SELECT b.id_cuenta, c.nombre_cliente, c.apellido_cliente, b.saldo, t.descripcion
FROM CUENTAS_BANCARIAS b, CLIENTES c, TIPOS_CUENTAS t
WHERE b.id_cliente = c.id_cliente
AND b.id_tipo_cuenta = t.id_tipo_cuenta
AND b.id_cuenta = 555555
AND b.clave = SHA2('1234', 256);

SELECT s.id_sucursal, s.nombre_sucursal, l.nombre_ciudad
FROM SUCURSALES s, LUGARES l
WHERE s.id_lugar = l.id_lugar;

SELECT t.id_transaccion, t.monto_transaccion, t.fecha_transaccion, t.id_sucursal
FROM transacciones t, sucursales s, lugares l
WHERE t.id_sucursal = s.id_sucursal
AND s.id_lugar = l.id_lugar
AND t.id_cuenta_origen = 555555;

INSERT INTO TRANSACCIONES 
VALUES (NULL, monto_transaccion, (SELECT NOW()), id_sucursal, 1, id_cuenta_origen, null);

SELECT DISTINCT s.id_sucursal, s.nombre_sucursal, l.nombre_ciudad, l.direccion
FROM SUCURSALES s, LUGARES l, TRANSACCIONES t
WHERE t.id_sucursal = s.id_sucursal
AND s.id_lugar = l.id_lugar
AND t.id_cuenta_origen = &id_cuenta;

SELECT * 
FROM transacciones 
WHERE EXTRACT(MONTH FROM fecha_transaccion) = 05
AND EXTRACT(YEAR FROM fecha_transaccion) = 2021
AND id_cuenta_origen = 555555;

