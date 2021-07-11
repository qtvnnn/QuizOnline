USE [onlineQuiz]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 11/03/2021 11:09:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[UserName] [varchar](100) NOT NULL,
	[PassWord] [varchar](100) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[t_id] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Option]    Script Date: 11/03/2021 11:09:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Option](
	[o_id] [int] IDENTITY(1,1) NOT NULL,
	[O_content] [nvarchar](500) NOT NULL,
	[q_id] [int] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_Option] PRIMARY KEY CLUSTERED 
(
	[o_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 11/03/2021 11:09:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[q_id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](500) NOT NULL,
	[date_Create] [date] NOT NULL,
 CONSTRAINT [PK_Question] PRIMARY KEY CLUSTERED 
(
	[q_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserType]    Script Date: 11/03/2021 11:09:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserType](
	[t_id] [int] NOT NULL,
	[Type] [varchar](100) NOT NULL,
 CONSTRAINT [PK_UserType] PRIMARY KEY CLUSTERED 
(
	[t_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'', N'admin1', N'', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'     sa', N'123', N'tiendung@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'1', N'123', N'f@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'admin1', N'admin1', N'thaont.design@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'admin11', N'123', N'dunghthe1307611@fpt.edu.vn', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'admin7', N'admin9', N'thaont.design@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'admin8', N'admin9', N'thaont.design@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'admin9', N'admin9', N'thaont.design@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'demo1', N'123', N'123@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'nang', N'123', N'nang61299@gmail.com', 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'Student1', N'123', N'stu', 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'studenta', N'aaa', N'studenta@gmail.com', 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'Teaacher', N'123', N'teacher', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'tiendung', N'123', N'htd061299@gmail.com', 1)
GO
SET IDENTITY_INSERT [dbo].[Option] ON 

INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (307, N'1', 79, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (308, N'2', 79, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (309, N'3', 79, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (310, N'4', 79, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (311, N'1', 80, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (312, N'2', 80, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (313, N'3', 80, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (314, N'4', 80, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (315, N'1', 81, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (316, N'2', 81, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (317, N'3', 81, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (318, N'4', 81, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (319, N'1', 82, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (320, N'2', 82, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (321, N'3', 82, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (322, N'4', 82, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (323, N'1', 83, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (324, N'2', 83, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (325, N'3', 83, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (326, N'4', 83, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (327, N'       ', 84, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (328, N'      ', 84, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (329, N'      ', 84, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (330, N'       ', 84, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (331, N'1', 85, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (332, N'2', 85, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (333, N'3', 85, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (334, N'4', 85, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (335, N'    ', 86, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (336, N'    ', 86, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (337, N'  ', 86, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (338, N'   ', 86, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (339, N'a', 87, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (340, N'a', 87, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (341, N'a', 87, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (342, N'a', 87, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (355, N'1', 91, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (356, N'1', 91, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (357, N'1', 91, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (358, N'1', 91, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (359, N'11', 92, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (360, N'11', 92, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (361, N'33', 92, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (362, N'33', 92, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (363, N'asfdasd', 93, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (364, N'sad', 93, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (365, N'asd', 93, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (366, N'asd', 93, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (367, N'a', 94, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (368, N'a', 94, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (369, N'a', 94, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (370, N'a', 94, 0)
SET IDENTITY_INSERT [dbo].[Option] OFF
GO
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (79, N'demo1', CAST(N'2021-02-24' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (80, N'demo2', CAST(N'2021-02-24' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (81, N'demo1', CAST(N'2021-02-24' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (82, N'demo3', CAST(N'2021-02-24' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (83, N'demo4', CAST(N'2021-02-24' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (84, N'        ', CAST(N'2021-02-25' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (85, N'dung', CAST(N'2021-02-25' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (86, N'        ', CAST(N'2021-02-25' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (87, N'a', CAST(N'2021-02-25' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (91, N'123', CAST(N'2021-02-25' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (92, N'   1234', CAST(N'2021-02-25' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (93, N'   adfasfd', CAST(N'2021-02-25' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (94, N'        a', CAST(N'2021-03-04' AS Date))
SET IDENTITY_INSERT [dbo].[Question] OFF
GO
INSERT [dbo].[UserType] ([t_id], [Type]) VALUES (1, N'Student')
INSERT [dbo].[UserType] ([t_id], [Type]) VALUES (2, N'Teacher')
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_UserType] FOREIGN KEY([t_id])
REFERENCES [dbo].[UserType] ([t_id])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_UserType]
GO
ALTER TABLE [dbo].[Option]  WITH CHECK ADD  CONSTRAINT [FK_Option_Question] FOREIGN KEY([q_id])
REFERENCES [dbo].[Question] ([q_id])
GO
ALTER TABLE [dbo].[Option] CHECK CONSTRAINT [FK_Option_Question]
GO
