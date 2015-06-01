USE dmai0914_2Sem_5;

/* Drop all non-system stored procs */
DECLARE @name VARCHAR(128)
DECLARE @SQL VARCHAR(254)

SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'P' AND category = 0 ORDER BY [name])

WHILE @name is not null
BEGIN
    SELECT @SQL = 'DROP PROCEDURE [dbo].[' + RTRIM(@name) +']'
    EXEC (@SQL)
    PRINT 'Dropped Procedure: ' + @name
    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'P' AND category = 0 AND [name] > @name ORDER BY [name])
END
GO

/* Drop all views */
DECLARE @name VARCHAR(128)
DECLARE @SQL VARCHAR(254)

SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'V' AND category = 0 ORDER BY [name])

WHILE @name IS NOT NULL
BEGIN
    SELECT @SQL = 'DROP VIEW [dbo].[' + RTRIM(@name) +']'
    EXEC (@SQL)
    PRINT 'Dropped View: ' + @name
    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'V' AND category = 0 AND [name] > @name ORDER BY [name])
END
GO

/* Drop all functions */
DECLARE @name VARCHAR(128)
DECLARE @SQL VARCHAR(254)

SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] IN (N'FN', N'IF', N'TF', N'FS', N'FT') AND category = 0 ORDER BY [name])

WHILE @name IS NOT NULL
BEGIN
    SELECT @SQL = 'DROP FUNCTION [dbo].[' + RTRIM(@name) +']'
    EXEC (@SQL)
    PRINT 'Dropped Function: ' + @name
    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] IN (N'FN', N'IF', N'TF', N'FS', N'FT') AND category = 0 AND [name] > @name ORDER BY [name])
END
GO

/* Drop all Foreign Key constraints */
DECLARE @name VARCHAR(128)
DECLARE @constraint VARCHAR(254)
DECLARE @SQL VARCHAR(254)

SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' ORDER BY TABLE_NAME)

WHILE @name is not null
BEGIN
    SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)
    WHILE @constraint IS NOT NULL
    BEGIN
        SELECT @SQL = 'ALTER TABLE [dbo].[' + RTRIM(@name) +'] DROP CONSTRAINT [' + RTRIM(@constraint) +']'
        EXEC (@SQL)
        PRINT 'Dropped FK Constraint: ' + @constraint + ' on ' + @name
        SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' AND CONSTRAINT_NAME <> @constraint AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)
    END
SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' ORDER BY TABLE_NAME)
END
GO

/* Drop all Primary Key constraints */
DECLARE @name VARCHAR(128)
DECLARE @constraint VARCHAR(254)
DECLARE @SQL VARCHAR(254)

SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' ORDER BY TABLE_NAME)

WHILE @name IS NOT NULL
BEGIN
    SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)
    WHILE @constraint is not null
    BEGIN
        SELECT @SQL = 'ALTER TABLE [dbo].[' + RTRIM(@name) +'] DROP CONSTRAINT [' + RTRIM(@constraint)+']'
        EXEC (@SQL)
        PRINT 'Dropped PK Constraint: ' + @constraint + ' on ' + @name
        SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' AND CONSTRAINT_NAME <> @constraint AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)
    END
SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' ORDER BY TABLE_NAME)
END
GO

/* Drop all tables */
DECLARE @name VARCHAR(128)
DECLARE @SQL VARCHAR(254)

SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'U' AND category = 0 ORDER BY [name])

WHILE @name IS NOT NULL
BEGIN
    SELECT @SQL = 'DROP TABLE [dbo].[' + RTRIM(@name) +']'
    EXEC (@SQL)
    PRINT 'Dropped Table: ' + @name
    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'U' AND category = 0 AND [name] > @name ORDER BY [name])
END
GO

CREATE TABLE Address(
	id_address		int							identity(1,1),
	country			nvarchar(128)				NOT NULL,
	city			nvarchar(128)				NOT NULL,
	PRIMARY KEY (id_address)
);
GO

CREATE TABLE Customer(
	id_customer		int							identity(1,1),
	name			nvarchar(128)				NOT NULL,
	phoneNr			nvarchar(16)				NOT NULL,
	email			nvarchar(128)				NOT NULL,
	c_address		int							NOT NULL,
	street			nvarchar(128)				NOT NULL,
	PRIMARY KEY (id_customer),
	FOREIGN KEY (c_address) REFERENCES Address(id_address) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT CUSTOMER_UNIQUE_EMAIL UNIQUE(email)
);
GO

CREATE TABLE Employee(
	id_employee		int							identity(1,1),
	person_id		nvarchar(11)				NOT NULL,
	name			nvarchar(128)				NOT NULL,
	phoneNr			nvarchar(16)				NOT NULL,
	email			nvarchar(128)				NOT NULL,
	pass			char(64)					NOT NULL,
	salt			char(20)					NOT NULL,
	rights			int							NOT NULL,
	e_address		int							NOT NULL,
	street			nvarchar(128)				NOT NULL,
	PRIMARY KEY (id_employee),
	FOREIGN KEY (e_address) REFERENCES Address(id_address) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT EMPLOYEE_UNIQUE_PERSON_ID UNIQUE(person_id),
	CONSTRAINT EMPLOYEE_UNIQUE_PHONENR UNIQUE(phoneNr),
	CONSTRAINT EMPLOYEE_UNIQUE_EMAIL UNIQUE(email)
);
GO

CREATE TABLE Item(
	id_item			int							identity(1,1),
	barcode			nvarchar(32)				NOT NULL,
	name			nvarchar(128)				NOT NULL,
	price			float						NOT NULL,
	stock			int							NOT NULL,
	itemType		nvarchar(16)				NOT NULL,
	category		nvarchar(16)				NOT NULL,
	PRIMARY KEY (id_item),
	CONSTRAINT ITEM_UNIQUE_BARCODE UNIQUE(barcode),
	CONSTRAINT ITEM_UNIQUE_NAME	UNIQUE(name)
);
GO

CREATE TABLE Invoice(
	id_invoice		int							identity(1,1),
	invoiceNr		nvarchar(32)				NOT NULL,
	dateCreated		datetime DEFAULT getdate()	NOT NULL,
	isPaid			BIT							NOT NULL,
	datePaid		datetime DEFAULT getdate(),
	id_c			int							NOT NULL,
	PRIMARY KEY (id_invoice),
	FOREIGN KEY (id_c) REFERENCES Customer(id_customer) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT INVOICE_SALE_UNIQUE UNIQUE(invoiceNr)
);
GO

CREATE TABLE Sale(
	id_sale			int							identity(1,1),
	saleNr			nvarchar(32)				NOT NULL,
	discount		int							NOT NULL,
	dateCreated		datetime DEFAULT getdate()	NOT NULL,
	isPacked		BIT							NOT NULL,
	datePacked		datetime DEFAULT getdate(),
	isSent			BIT							NOT NULL,
	dateSent		datetime DEFAULT getdate(),
	isPaid			BIT							NOT NULL,
	datePaid		datetime DEFAULT getdate(),
	id_e			int							NOT NULL,
	id_c			int							NOT NULL,
	id_inv			int,
	PRIMARY KEY (id_sale),
	FOREIGN KEY (id_e) REFERENCES Employee(id_employee) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (id_c) REFERENCES Customer(id_customer) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (id_inv) REFERENCES Invoice(id_invoice) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT SALE_UNIQUE_SALENR UNIQUE(saleNr)
);
GO

CREATE TABLE SaleLine(
	id_saleLine		int							identity(1,1),
	quantity		int							NOT NULL,
	price			float						NOT NULL,
	id_i			int							NOT NULL,
	id_s			int							NOT NULL,
	PRIMARY KEY (id_saleLine),
	FOREIGN KEY (id_i) REFERENCES Item(id_item) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (Id_s) REFERENCES Sale(id_sale) ON DELETE NO ACTION ON UPDATE NO ACTION
);
GO
