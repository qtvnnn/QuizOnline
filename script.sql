USE [onlineQuiz]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 7/26/2021 12:32:33 PM ******/
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
/****** Object:  Table [dbo].[Option]    Script Date: 7/26/2021 12:32:33 PM ******/
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
/****** Object:  Table [dbo].[Question]    Script Date: 7/26/2021 12:32:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[q_id] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](500) NOT NULL,
	[date_Create] [date] NOT NULL,
 CONSTRAINT [PK_Question] PRIMARY KEY CLUSTERED 
(
	[q_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserType]    Script Date: 7/26/2021 12:32:33 PM ******/
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
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'demo1', N'123', N'123@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'nang', N'123', N'nang61299@gmail.com', 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'nangnn', N'123456', N'qtvnnn@gmail.com', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'nangnn1', N'123456', N'nangn@cd.co', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'nangnn2', N'123456', N'aww3@dc.cs', 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'nangnn5', N'123456', N'atnd@gc.co', 2)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'Student1', N'123', N'stu', 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'studenta', N'aaa', N'studenta@gmail.com', 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Email], [t_id]) VALUES (N'Teaacher', N'123', N'teacher', 2)
GO
SET IDENTITY_INSERT [dbo].[Option] ON 

INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1487, N'măng', 1126, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1488, N'ngô', 1126, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1489, N'trúc', 1126, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1490, N'liễu', 1126, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1491, N'11', 1127, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1492, N'32', 1127, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1493, N'26', 1127, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1494, N'10', 1127, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1495, N'Tây Ninh.', 1128, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1496, N'Bắc Bộ.', 1128, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1497, N'Bắc Ninh.', 1128, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1498, N'Ninh Bình.', 1128, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1499, N'Lào Cai', 1129, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1500, N'Ninh Bình', 1129, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1501, N'Bát Tràng', 1129, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1502, N'Hội An', 1129, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1503, N'2', 1130, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1504, N'3', 1130, 0)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1505, N'1', 1130, 1)
INSERT [dbo].[Option] ([o_id], [O_content], [q_id], [status]) VALUES (1506, N'4', 1130, 0)
SET IDENTITY_INSERT [dbo].[Option] OFF
GO
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (1126, N' Điền vào dấu ba chấm: "Tre già ... mọc."      ', CAST(N'2021-07-19' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (1127, N' Điền số vào dấu chấm hỏi: 1, 2, 4, 8, 16, ?', CAST(N'2021-07-19' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (1128, N'Hát quan họ là sản phẩm văn hóa đặc trưng của vùng miền nào nước ta:', CAST(N'2021-07-19' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (1129, N' Một làng nghề làm gốm nổi tiếng ở nước ta ở vùng Bắc Bộ thuộc vùng:', CAST(N'2021-07-19' AS Date))
INSERT [dbo].[Question] ([q_id], [content], [date_Create]) VALUES (1130, N'Rắn có mấy lá phổi', CAST(N'2021-07-19' AS Date))
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
