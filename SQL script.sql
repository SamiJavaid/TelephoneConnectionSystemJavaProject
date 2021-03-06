USE [TCS]
GO
/****** Object:  Table [dbo].[tblConMode]    Script Date: 08/20/2017 17:01:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblConMode](
	[cm_id] [int] IDENTITY(1,1) NOT NULL,
	[cm_mode] [varchar](30) NULL,
 CONSTRAINT [PK__tblConMo__682312EC07020F21] PRIMARY KEY CLUSTERED 
(
	[cm_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_rol]    Script Date: 08/20/2017 17:01:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_rol](
	[r_id] [int] IDENTITY(1,1) NOT NULL,
	[r_name] [varchar](10) NULL,
 CONSTRAINT [PK_tbl_rol] PRIMARY KEY CLUSTERED 
(
	[r_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblConType]    Script Date: 08/20/2017 17:01:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblConType](
	[ct_id] [int] IDENTITY(1,1) NOT NULL,
	[ct_type] [varchar](30) NULL,
 CONSTRAINT [PK__tblConTy__33D47D090AD2A005] PRIMARY KEY CLUSTERED 
(
	[ct_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblEmployee]    Script Date: 08/20/2017 17:01:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblEmployee](
	[e_id] [int] IDENTITY(1,1) NOT NULL,
	[e_name] [varchar](30) NULL,
	[e_contact] [varchar](30) NULL,
	[userName] [varchar](10) NULL,
	[userPass] [varchar](10) NULL,
	[r_id] [int] NULL,
 CONSTRAINT [PK__tblEmplo__3E2ED64A2C3393D0] PRIMARY KEY CLUSTERED 
(
	[e_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblConnectionUser]    Script Date: 08/20/2017 17:01:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblConnectionUser](
	[u_id] [int] IDENTITY(1,1) NOT NULL,
	[u_name] [varchar](30) NULL,
	[u_contact] [varchar](30) NULL,
	[u_gender] [varchar](30) NULL,
	[u_address] [text] NULL,
	[u_city] [varchar](30) NULL,
	[ct_id] [int] NULL,
	[cm_id] [int] NULL,
	[e_id] [int] NULL,
 CONSTRAINT [PK__tblConne__B51D3DEA412EB0B6] PRIMARY KEY CLUSTERED 
(
	[u_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[tec]    Script Date: 08/20/2017 17:01:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[tec]
as
select type.ct_id,conn.u_name as Name,conn.u_contact as Contact,conn.u_gender as Gender,conn.u_address as Address,conn.u_city as City ,type.ct_type as ConnectionMode from tblConnectionUser as conn
join tblConType as type
on
type.ct_id = conn.ct_id
GO
/****** Object:  View [dbo].[rec]    Script Date: 08/20/2017 17:01:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[rec]
as
select mode.cm_id,conn.u_name as Name,conn.u_contact as Contact,conn.u_gender as Gender,conn.u_address as Address,conn.u_city as City ,mode.cm_mode as ConnectionMode from tblConnectionUser as conn
join tblConMode as mode
on
mode.cm_id = conn.cm_id
GO
/****** Object:  ForeignKey [FK_tblConnectionUser_tblConMode]    Script Date: 08/20/2017 17:01:36 ******/
ALTER TABLE [dbo].[tblConnectionUser]  WITH CHECK ADD  CONSTRAINT [FK_tblConnectionUser_tblConMode] FOREIGN KEY([cm_id])
REFERENCES [dbo].[tblConMode] ([cm_id])
GO
ALTER TABLE [dbo].[tblConnectionUser] CHECK CONSTRAINT [FK_tblConnectionUser_tblConMode]
GO
/****** Object:  ForeignKey [FK_tblConnectionUser_tblConType]    Script Date: 08/20/2017 17:01:36 ******/
ALTER TABLE [dbo].[tblConnectionUser]  WITH CHECK ADD  CONSTRAINT [FK_tblConnectionUser_tblConType] FOREIGN KEY([ct_id])
REFERENCES [dbo].[tblConType] ([ct_id])
GO
ALTER TABLE [dbo].[tblConnectionUser] CHECK CONSTRAINT [FK_tblConnectionUser_tblConType]
GO
/****** Object:  ForeignKey [FK_tblConnectionUser_tblEmployee]    Script Date: 08/20/2017 17:01:36 ******/
ALTER TABLE [dbo].[tblConnectionUser]  WITH CHECK ADD  CONSTRAINT [FK_tblConnectionUser_tblEmployee] FOREIGN KEY([e_id])
REFERENCES [dbo].[tblEmployee] ([e_id])
GO
ALTER TABLE [dbo].[tblConnectionUser] CHECK CONSTRAINT [FK_tblConnectionUser_tblEmployee]
GO
/****** Object:  ForeignKey [FK_tblEmployee_tbl_rol]    Script Date: 08/20/2017 17:01:36 ******/
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD  CONSTRAINT [FK_tblEmployee_tbl_rol] FOREIGN KEY([r_id])
REFERENCES [dbo].[tbl_rol] ([r_id])
GO
ALTER TABLE [dbo].[tblEmployee] CHECK CONSTRAINT [FK_tblEmployee_tbl_rol]
GO
