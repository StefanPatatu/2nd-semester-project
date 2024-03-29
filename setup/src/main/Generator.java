package main;

import java.util.Random;

public class Generator {
	
	private String DBquery;
	private String DBTablePrefix;
	
	//change this stuff
	private final String DBDriver = "//kraka.ucn.dk:1433";
	private final String DBName = "dmai0914_2Sem_5";
	private final String DBUserName = "dmai0914_2Sem_5";
	private final String DBPassword = "IsAllowed";
	
	public Generator() {
		
		this.DBTablePrefix = generateDBTablePrefix();
		this.DBquery = generateFinalQuery();
		
	}
	
	public String getDBQuery() {
		return DBquery;
	}
	public String getDBTablePrefix() {
		return DBTablePrefix;
	}
	public String getDBDriver() {
		return DBDriver;
	}
	public String getDBName() {
		return DBName;
	}
	public String getDBUserName() {
		return DBUserName;
	}
	public String getDBPassword() {
		return DBPassword;
	}
	
	private String generateFinalQuery() {
		String finalQuery = generateCleanUpQuery(DBName) + "\r\n" + generateCreateTablesQuery(DBTablePrefix);
		System.out.println(finalQuery);
		return finalQuery;
	}
	
	private String generateDBTablePrefix() {
		final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(7);
		for (int i=0; i<7; i++) {
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		}
		sb.append("_");
		return sb.toString();
	}
	
	//cleanUpQuery
	private String generateCleanUpQuery(String DBName) {
		String query =
				"USE " + DBName +";\r\n" + 
				"\r\n" + 
				"/* Drop all non-system stored procs */\r\n" + 
				"DECLARE @name VARCHAR(128)\r\n" + 
				"DECLARE @SQL VARCHAR(254)\r\n" + 
				"\r\n" + 
				"SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'P' AND category = 0 ORDER BY [name])\r\n" + 
				"\r\n" + 
				"WHILE @name is not null\r\n" + 
				"BEGIN\r\n" + 
				"    SELECT @SQL = 'DROP PROCEDURE [dbo].[' + RTRIM(@name) +']'\r\n" + 
				"    EXEC (@SQL)\r\n" + 
				"    PRINT 'Dropped Procedure: ' + @name\r\n" + 
				"    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'P' AND category = 0 AND [name] > @name ORDER BY [name])\r\n" + 
				"END\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"/* Drop all views */\r\n" + 
				"DECLARE @name VARCHAR(128)\r\n" + 
				"DECLARE @SQL VARCHAR(254)\r\n" + 
				"\r\n" + 
				"SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'V' AND category = 0 ORDER BY [name])\r\n" + 
				"\r\n" + 
				"WHILE @name IS NOT NULL\r\n" + 
				"BEGIN\r\n" + 
				"    SELECT @SQL = 'DROP VIEW [dbo].[' + RTRIM(@name) +']'\r\n" + 
				"    EXEC (@SQL)\r\n" + 
				"    PRINT 'Dropped View: ' + @name\r\n" + 
				"    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'V' AND category = 0 AND [name] > @name ORDER BY [name])\r\n" + 
				"END\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"/* Drop all functions */\r\n" + 
				"DECLARE @name VARCHAR(128)\r\n" + 
				"DECLARE @SQL VARCHAR(254)\r\n" + 
				"\r\n" + 
				"SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] IN (N'FN', N'IF', N'TF', N'FS', N'FT') AND category = 0 ORDER BY [name])\r\n" + 
				"\r\n" + 
				"WHILE @name IS NOT NULL\r\n" + 
				"BEGIN\r\n" + 
				"    SELECT @SQL = 'DROP FUNCTION [dbo].[' + RTRIM(@name) +']'\r\n" + 
				"    EXEC (@SQL)\r\n" + 
				"    PRINT 'Dropped Function: ' + @name\r\n" + 
				"    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] IN (N'FN', N'IF', N'TF', N'FS', N'FT') AND category = 0 AND [name] > @name ORDER BY [name])\r\n" + 
				"END\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"/* Drop all Foreign Key constraints */\r\n" + 
				"DECLARE @name VARCHAR(128)\r\n" + 
				"DECLARE @constraint VARCHAR(254)\r\n" + 
				"DECLARE @SQL VARCHAR(254)\r\n" + 
				"\r\n" + 
				"SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' ORDER BY TABLE_NAME)\r\n" + 
				"\r\n" + 
				"WHILE @name is not null\r\n" + 
				"BEGIN\r\n" + 
				"    SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)\r\n" + 
				"    WHILE @constraint IS NOT NULL\r\n" + 
				"    BEGIN\r\n" + 
				"        SELECT @SQL = 'ALTER TABLE [dbo].[' + RTRIM(@name) +'] DROP CONSTRAINT [' + RTRIM(@constraint) +']'\r\n" + 
				"        EXEC (@SQL)\r\n" + 
				"        PRINT 'Dropped FK Constraint: ' + @constraint + ' on ' + @name\r\n" + 
				"        SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' AND CONSTRAINT_NAME <> @constraint AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)\r\n" + 
				"    END\r\n" + 
				"SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'FOREIGN KEY' ORDER BY TABLE_NAME)\r\n" + 
				"END\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"/* Drop all Primary Key constraints */\r\n" + 
				"DECLARE @name VARCHAR(128)\r\n" + 
				"DECLARE @constraint VARCHAR(254)\r\n" + 
				"DECLARE @SQL VARCHAR(254)\r\n" + 
				"\r\n" + 
				"SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' ORDER BY TABLE_NAME)\r\n" + 
				"\r\n" + 
				"WHILE @name IS NOT NULL\r\n" + 
				"BEGIN\r\n" + 
				"    SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)\r\n" + 
				"    WHILE @constraint is not null\r\n" + 
				"    BEGIN\r\n" + 
				"        SELECT @SQL = 'ALTER TABLE [dbo].[' + RTRIM(@name) +'] DROP CONSTRAINT [' + RTRIM(@constraint)+']'\r\n" + 
				"        EXEC (@SQL)\r\n" + 
				"        PRINT 'Dropped PK Constraint: ' + @constraint + ' on ' + @name\r\n" + 
				"        SELECT @constraint = (SELECT TOP 1 CONSTRAINT_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' AND CONSTRAINT_NAME <> @constraint AND TABLE_NAME = @name ORDER BY CONSTRAINT_NAME)\r\n" + 
				"    END\r\n" + 
				"SELECT @name = (SELECT TOP 1 TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE constraint_catalog=DB_NAME() AND CONSTRAINT_TYPE = 'PRIMARY KEY' ORDER BY TABLE_NAME)\r\n" + 
				"END\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"/* Drop all tables */\r\n" + 
				"DECLARE @name VARCHAR(128)\r\n" + 
				"DECLARE @SQL VARCHAR(254)\r\n" + 
				"\r\n" + 
				"SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'U' AND category = 0 ORDER BY [name])\r\n" + 
				"\r\n" + 
				"WHILE @name IS NOT NULL\r\n" + 
				"BEGIN\r\n" + 
				"    SELECT @SQL = 'DROP TABLE [dbo].[' + RTRIM(@name) +']'\r\n" + 
				"    EXEC (@SQL)\r\n" + 
				"    PRINT 'Dropped Table: ' + @name\r\n" + 
				"    SELECT @name = (SELECT TOP 1 [name] FROM sysobjects WHERE [type] = 'U' AND category = 0 AND [name] > @name ORDER BY [name])\r\n" + 
				"END\r\n" + 
				"GO";
		//System.out.println(query);
		return query;
	}
	
	//createTablesQuery
	private String generateCreateTablesQuery(String DBTablePrefix) {
		String query = "CREATE TABLE " + DBTablePrefix + "Address(\r\n" + 
				"	id_address		int							identity(1,1),\r\n" + 
				"	country			nvarchar(128)				NOT NULL,\r\n" + 
				"	city			nvarchar(128)				NOT NULL,\r\n" + 
				"	PRIMARY KEY (id_address)\r\n" + 
				");\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"CREATE TABLE " + DBTablePrefix + "Customer(\r\n" + 
				"	id_customer		int							identity(1,1),\r\n" + 
				"	name			nvarchar(128)				NOT NULL,\r\n" + 
				"	phoneNr			nvarchar(16)				NOT NULL,\r\n" + 
				"	email			nvarchar(128)				NOT NULL,\r\n" + 
				"	c_address		int							NOT NULL,\r\n" + 
				"	street			nvarchar(128)				NOT NULL,\r\n" + 
				"	PRIMARY KEY (id_customer),\r\n" + 
				"	FOREIGN KEY (c_address) REFERENCES " + DBTablePrefix + "Address(id_address) ON DELETE NO ACTION ON UPDATE CASCADE,\r\n" + 
				"	CONSTRAINT CUSTOMER_UNIQUE_EMAIL UNIQUE(email)\r\n" + 
				");\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"CREATE TABLE " + DBTablePrefix + "Employee(\r\n" + 
				"	id_employee		int							identity(1,1),\r\n" + 
				"	person_id		nvarchar(11)				NOT NULL,\r\n" + 
				"	name			nvarchar(128)				NOT NULL,\r\n" + 
				"	phoneNr			nvarchar(16)				NOT NULL,\r\n" + 
				"	email			nvarchar(128)				NOT NULL,\r\n" + 
				"	pass			char(1024)					NOT NULL,\r\n" + 
				"	salt			char(512)					NOT NULL,\r\n" + 
				"	rights			int							NOT NULL,\r\n" + 
				"	e_address		int							NOT NULL,\r\n" + 
				"	street			nvarchar(128)				NOT NULL,\r\n" + 
				"	PRIMARY KEY (id_employee),\r\n" + 
				"	FOREIGN KEY (e_address) REFERENCES " + DBTablePrefix + "Address(id_address) ON DELETE NO ACTION ON UPDATE CASCADE,\r\n" + 
				"	CONSTRAINT EMPLOYEE_UNIQUE_PERSON_ID UNIQUE(person_id),\r\n" + 
				"	CONSTRAINT EMPLOYEE_UNIQUE_PHONENR UNIQUE(phoneNr),\r\n" + 
				"	CONSTRAINT EMPLOYEE_UNIQUE_EMAIL UNIQUE(email)\r\n" + 
				");\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"CREATE TABLE " + DBTablePrefix + "Item(\r\n" + 
				"	id_item			int							identity(1,1),\r\n" + 
				"	barcode			nvarchar(32)				NOT NULL,\r\n" + 
				"	name			nvarchar(128)				NOT NULL,\r\n" + 
				"	price			float						NOT NULL,\r\n" + 
				"	stock			int							NOT NULL,\r\n" + 
				"	itemType		nvarchar(16)				NOT NULL,\r\n" + 
				"	category		nvarchar(16)				NOT NULL,\r\n" + 
				"	PRIMARY KEY (id_item),\r\n" + 
				"	CONSTRAINT ITEM_UNIQUE_BARCODE UNIQUE(barcode),\r\n" + 
				"	CONSTRAINT ITEM_UNIQUE_NAME	UNIQUE(name)\r\n" + 
				");\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"CREATE TABLE " + DBTablePrefix + "Invoice(\r\n" + 
				"	id_invoice		int							identity(1,1),\r\n" + 
				"	invoiceNr		nvarchar(32)				NOT NULL,\r\n" + 
				"	dateCreated		datetime DEFAULT getdate()	NOT NULL,\r\n" + 
				"	isPaid			BIT							NOT NULL,\r\n" + 
				"	datePaid		datetime DEFAULT getdate(),\r\n" + 
				"	id_c			int							NOT NULL,\r\n" + 
				"	PRIMARY KEY (id_invoice),\r\n" + 
				"	FOREIGN KEY (id_c) REFERENCES " + DBTablePrefix + "Customer(id_customer) ON DELETE NO ACTION ON UPDATE NO ACTION,\r\n" + 
				"	CONSTRAINT INVOICE_SALE_UNIQUE UNIQUE(invoiceNr)\r\n" + 
				");\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"CREATE TABLE " + DBTablePrefix + "Sale(\r\n" + 
				"	id_sale			int							identity(1,1),\r\n" + 
				"	saleNr			nvarchar(32)				NOT NULL,\r\n" + 
				"	discount		int							NOT NULL,\r\n" + 
				"	dateCreated		datetime DEFAULT getdate()	NOT NULL,\r\n" + 
				"	isPacked		BIT							NOT NULL,\r\n" + 
				"	datePacked		datetime DEFAULT getdate(),\r\n" + 
				"	isSent			BIT							NOT NULL,\r\n" + 
				"	dateSent		datetime DEFAULT getdate(),\r\n" + 
				"	isPaid			BIT							NOT NULL,\r\n" + 
				"	datePaid		datetime DEFAULT getdate(),\r\n" + 
				"	id_e			int							NOT NULL,\r\n" + 
				"	id_c			int							NOT NULL,\r\n" + 
				"	id_inv			int,\r\n" + 
				"	PRIMARY KEY (id_sale),\r\n" + 
				"	FOREIGN KEY (id_e) REFERENCES " + DBTablePrefix + "Employee(id_employee) ON DELETE NO ACTION ON UPDATE NO ACTION,\r\n" + 
				"	FOREIGN KEY (id_c) REFERENCES " + DBTablePrefix + "Customer(id_customer) ON DELETE NO ACTION ON UPDATE NO ACTION,\r\n" + 
				"	FOREIGN KEY (id_inv) REFERENCES " + DBTablePrefix + "Invoice(id_invoice) ON DELETE NO ACTION ON UPDATE NO ACTION,\r\n" + 
				"	CONSTRAINT SALE_UNIQUE_SALENR UNIQUE(saleNr)\r\n" + 
				");\r\n" + 
				"GO\r\n" + 
				"\r\n" + 
				"CREATE TABLE " + DBTablePrefix + "SaleLine(\r\n" + 
				"	id_saleLine		int							identity(1,1),\r\n" + 
				"	quantity		int							NOT NULL,\r\n" + 
				"	price			float						NOT NULL,\r\n" + 
				"	id_i			int							NOT NULL,\r\n" + 
				"	id_s			int							NOT NULL,\r\n" + 
				"	PRIMARY KEY (id_saleLine),\r\n" + 
				"	FOREIGN KEY (id_i) REFERENCES " + DBTablePrefix + "Item(id_item) ON DELETE NO ACTION ON UPDATE NO ACTION,\r\n" + 
				"	FOREIGN KEY (Id_s) REFERENCES " + DBTablePrefix + "Sale(id_sale) ON DELETE NO ACTION ON UPDATE NO ACTION\r\n" + 
				");\r\n" + 
				"GO\r\n" + 
				"INSERT INTO " + DBTablePrefix + "Address (country, city) VALUES ('Heaven', 'Utopia');\r\n" + 
				"INSERT INTO " + DBTablePrefix + "Employee (person_id, name, phoneNr, email, pass, salt, rights, e_address, street) VALUES ('000', 'God', '666-666-666', 'burnInHell@god.saint', 't02wHpL/Qn6hdNQLaOupusaQdk5U38aoz4Qqu7Llz1E=', 'CmIK8DKzTfgfy74EucwueA==', '3', '1', 'Hope no. 12');\r\n" + 
				"";
		//System.out.println(query);
		return query;
	}

}
