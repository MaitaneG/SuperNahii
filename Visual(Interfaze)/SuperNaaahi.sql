USE [master]
GO
/****** Object:  Database [SuperNaaahi]    Script Date: 14/02/2022 10:11:46 ******/
CREATE DATABASE [SuperNaaahi]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SuperNaaahi', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\SuperNaaahi.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SuperNaaahi_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\SuperNaaahi_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [SuperNaaahi] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SuperNaaahi].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SuperNaaahi] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SuperNaaahi] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SuperNaaahi] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SuperNaaahi] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SuperNaaahi] SET ARITHABORT OFF 
GO
ALTER DATABASE [SuperNaaahi] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SuperNaaahi] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SuperNaaahi] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SuperNaaahi] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SuperNaaahi] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SuperNaaahi] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SuperNaaahi] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SuperNaaahi] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SuperNaaahi] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SuperNaaahi] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SuperNaaahi] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SuperNaaahi] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SuperNaaahi] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SuperNaaahi] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SuperNaaahi] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SuperNaaahi] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SuperNaaahi] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SuperNaaahi] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SuperNaaahi] SET  MULTI_USER 
GO
ALTER DATABASE [SuperNaaahi] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SuperNaaahi] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SuperNaaahi] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SuperNaaahi] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SuperNaaahi] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SuperNaaahi] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [SuperNaaahi] SET QUERY_STORE = OFF
GO
USE [SuperNaaahi]
GO
/****** Object:  Table [dbo].[Foroa]    Script Date: 14/02/2022 10:11:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Foroa](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Korreoa] [nvarchar](50) NULL,
	[Komentarioa] [nvarchar](150) NULL,
	[Data] [datetime] NULL,
 CONSTRAINT [PK_Foroa] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Inkesta]    Script Date: 14/02/2022 10:11:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inkesta](
	[Korreoa] [nvarchar](50) NOT NULL,
	[Balorazioa] [int] NULL,
	[Hobetzeko] [nvarchar](50) NULL,
	[Gomendatu] [bit] NULL,
 CONSTRAINT [PK_Inkesta] PRIMARY KEY CLUSTERED 
(
	[Korreoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Foroa] ON 

INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (19, N'moreno.manuel@uni.eus', N'Ta bonico! in jenerral', CAST(N'2022-02-01T13:26:56.950' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (20, N'gallastegui.maitane@uni.eus', N'Pues se ha quedado bonito', CAST(N'2022-02-01T13:27:34.817' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (21, N'oihanaarambarri@uni.eus', N'Naaahi?', CAST(N'2022-02-01T13:28:08.153' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (22, N'oihanaarambarri@uni.eus', N'???', CAST(N'2022-02-02T08:09:53.573' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (23, N'oihanaarambarri@uni.eus', N'ee?', CAST(N'2022-02-02T08:12:00.070' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (24, N'moreno.manuel@uni.eus', N'Baaai!!', CAST(N'2022-02-02T08:16:26.140' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (25, N'oihanaarambarri@uni.eus', N'balee', CAST(N'2022-02-07T13:59:01.940' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (26, N'gallastegui.maitane@uni.eus', N'balee', CAST(N'2022-02-07T14:02:15.890' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (27, N'gallastegui.maitane@uni.eus', N'nik ezin det', CAST(N'2022-02-07T14:04:27.910' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (28, N'gallastegui.maitane@uni.eus', N'Barkau naztu inaiz eztet naaahi', CAST(N'2022-02-07T14:06:58.563' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (29, N'oihanaarambarri@uni.eus', N'timestamp eure ustez', CAST(N'2022-02-11T09:10:01.770' AS DateTime))
INSERT [dbo].[Foroa] ([Id], [Korreoa], [Komentarioa], [Data]) VALUES (30, N'oihanaarambarri@uni.eus', N'Oso ona', CAST(N'2022-02-14T09:29:13.043' AS DateTime))
SET IDENTITY_INSERT [dbo].[Foroa] OFF
GO
INSERT [dbo].[Inkesta] ([Korreoa], [Balorazioa], [Hobetzeko], [Gomendatu]) VALUES (N'gallastegui.maitane@uni.eus', 6, N'pufffff gauz asko', 0)
INSERT [dbo].[Inkesta] ([Korreoa], [Balorazioa], [Hobetzeko], [Gomendatu]) VALUES (N'moreno.manuel@uni.eus', 5, N'Errealitatea', 1)
INSERT [dbo].[Inkesta] ([Korreoa], [Balorazioa], [Hobetzeko], [Gomendatu]) VALUES (N'oihanaarambarri@uni.eus', 10, N'Ezer ez', 1)
GO
USE [master]
GO
ALTER DATABASE [SuperNaaahi] SET  READ_WRITE 
GO
