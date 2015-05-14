package main;

public class Generator {
	
	private String database;
	
	//cleanUpQuery
	private String generateCleanUpQuery() {
		String query =
				"USE " + database +";\r\n" + 
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
		System.out.println(query);
		return query;
	}

	//database
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}

}
