use master
drop database QL_BD_7
create database QL_BD_7
use QL_BD_7
go

create table KhachHang(
	ID INT IDENTITY(1,1),
    maKH AS 'KH' + RIGHT('00000' + CAST(ID AS VARCHAR(5)), 5) PERSISTED PRIMARY KEY CLUSTERED,
	tenKH nvarchar(50) not null,
	sdt nchar(10) not null,
	diaChi nvarchar(MAX)  
)
go
create table TaiKhoan(
	tenTK varchar(16) not null primary key,
	matKhau varchar(16) not null,
	hoTen nvarchar(50),
	email nvarchar(30),
	sdt char(10), 
	quyen int not null, -- 0 Quản lý .1 Nhân viên
	truyCap int not null -- 0 Không .1 Được phép truy cập 
)

go
create table TheLoai(
	maTL int not null primary key, -- 1 Film 2 Game
	tenTL nvarchar(10) not null,
	giaThue int,
--	gioiHanNgayThue int,
	giaPhat int,
--	gioiHanNgayPhat int,
	giaDenBu int
)
go

create table TieuDe(
	ID INT IDENTITY(1,1),
    maTD AS 'TD' + RIGHT('00000' + CAST(ID AS VARCHAR(5)), 5) PERSISTED PRIMARY KEY CLUSTERED,
	tenTD nvarchar(MAX) not null,
)
go

create table Dia(
	ID INT IDENTITY(1,1),
    maDia AS 'BD' + RIGHT('00000' + CAST(ID AS VARCHAR(5)), 5) PERSISTED PRIMARY KEY CLUSTERED,
	maTL int not null,
	maTD varchar(7) not null,
	tinhTrang int, --0 Kho 1.Thuê 2.Được đặt hàng
	huHong int, --0 không 1.hư
	foreign key (maTL) references TheLoai,
	foreign key (maTD) references TieuDe
)

create table PhieuThue(
	ID INT IDENTITY(1,1),
    maPT AS 'PT' + RIGHT('00000' + CAST(ID AS VARCHAR(5)), 5) PERSISTED PRIMARY KEY CLUSTERED,
	maKH varchar(7) not null,
	ngayThue date,
	tenTK varchar(16) not null,
	tongTien int,
	foreign key (maKH) references KhachHang,
	foreign key (tenTK) references TaiKhoan
)

create table ChiTietPhieuThue(
	maPT varchar(7) not null,
	maDia varchar(7) not null,
	hanTra date,
	thanhTien int,
	primary key (maPT,maDia),
	foreign key (maPT) references PhieuThue,
	foreign key (maDia) references Dia
)
go

create table PhieuTra(
	ID INT IDENTITY(1,1),
    maPTr AS 'PTr' + RIGHT('0000' + CAST(ID AS VARCHAR(4)), 4) PERSISTED PRIMARY KEY CLUSTERED,
	maPT varchar(7) not null,
	maDia varchar(7) not null,
	ngayTra date,
	tenTK varchar(16) not null,
	quaHan int,
	huHong int,
	foreign key (maPT) references PhieuThue,
	foreign key (maDia) references Dia,
	foreign key (tenTK) references TaiKhoan
)
go

create table PhiTreHan(
	maPTr varchar(7) not null primary key,
	phatQuaHan int,
	phatHuHong int,
	tongTien int,
	traTruoc int,
	thanhToan int,
	foreign key (maPTr) references PhieuTra,
)
go

create table ThanhToan(
	ID INT IDENTITY(1,1),
    maTT AS 'TT' + RIGHT('00000' + CAST(ID AS VARCHAR(5)), 5) PERSISTED PRIMARY KEY CLUSTERED,
	maKH varchar(7) not null,
	ngayThanhToan date,
	tongTien int,
	tenTK varchar(16) not null,
	foreign key (maKH) references KhachHang,
	foreign key (tenTK) references TaiKhoan
)

create table ChiTietThanhToan(
	maTT varchar(7) not null,
	maPTr varchar(7) not null,
	soTien int,
	primary key(maTT,maPtr),
	foreign key (maTT) references ThanhToan,	
	foreign key (maPTr) references PhiTrehan,
)

create table PhieuDat(
	ID INT IDENTITY(1,1),
    maPD AS 'PD' + RIGHT('00000' + CAST(ID AS VARCHAR(5)), 5) PERSISTED PRIMARY KEY CLUSTERED,
	maKH varchar(7) not null,
	maTD varchar(7) not null,
	ngayDat date,
	gio time,
	tenTK varchar(16) not null,
	trangThai int, --0. Chưa có đĩa 1. Chờ khách 2.Đã hoàn thành
	foreign key (maTD) references TieuDe,
	foreign key (maKH) references KhachHang,
	foreign key (tenTK) references TaiKhoan
)

create table ChiTietPhieuDat(
	maPD varchar(7) not null,
	maDia varchar(7) not null,
	trangThai int, --0. khách chưa nhận 1. Khách đã nhận
	primary key (maPD),
	foreign key (maPD) references PhieuDat,
	foreign key (maDia) references Dia,
)
go


--select * from TheLoai
--insert into TheLoai values(1,'Phim',10000,12000,50000),(2,'Game',15000,20000,100000)

--select * from TaiKhoan
--insert into TaiKhoan 
--values('admin','123','Adminn','nmdd@nmeh.com.vn','1239845124',0,1),
--		('giahung','123',N'Gia Hưng','nmdd@nmeh.com.vn','1239845124',1,1)

--select * from KhachHang
--insert into KhachHang(tenKH,sdt,diaChi)
--values (N'Lê Văn Long','0983412754',N'11 Lê Duẩn'),
--		(N'Nguyên Văn Tèo','0198999954',N'19 Lê Thánh Tôn'),
--		(N'Trần Thê Sơn','0912412754',N'110 Chu Văn An'),
--		(N'Lê Văn Phúc','0983410333',N'22 Phan Xích Long'),
--		(N'Phan Hoàng Kiên','0001141254',N'41 Đồng Nai'),
--		(N'Trần Nhật Duy','0909123451',N'57 Nguyên Huệ'),
--		(N'Bùi Xuân Phú','0883091541',N'90 Phan Chu Trinh'),
--		(N'Phạm Minh Hiếu','0900111321',N'207 Nơ Trang Long')

--select * from TieuDe
--insert into TieuDe(tenTD) 
--values (N'Chuyên gia xảo quyệt'),(N'Đội bóng thiếu lâm'),(N'Vua hài kịch HK'),(N'Mỹ nhân ngư '),(N'Hậu duệ mặt trời'),(N'Quan xẩm lốc cốc'),
--		(N'Đường bá hổ HK'),(N'Vua bánh mì 2'),(N'Trạng nguyên Tô Khất Nhi'),(N'Tân lộc đỉnh ký'),(N'Đại nội mật thám'),
--		(N'Tây du kí ngoại truyện'),(N'Chuyên gia bắt ma'),(N'Quốc sản 007'),(N'Tân tinh võ môn'),
--		(N'Fifa online 4'), (N'Dragon ball LDS'),(N'Spider man 2020'),(N'WWE ofline 2020'),(N'Samurai Shodown'),(N'GTA online 5'),(N'EA sport UFC 2020'),(N'NBA online 2020')
		
-- 1-15 Phim 16-23 Game
--select * from Dia
--insert into Dia(maTL,maTD,tinhTrang,huHong)
--values (1,'TD00001',0,0),(1,'TD00001',0,0),(1,'TD00001',0,0),(1,'TD00001',0,0),(1,'TD00001',0,0),
--		(1,'TD00002',0,0),(1,'TD00002',0,0),(1,'TD00002',0,0),(1,'TD00002',0,0),
--		(1,'TD00003',0,0),(1,'TD00003',0,0),(1,'TD00003',0,0),(1,'TD00003',0,0),(1,'TD00003',0,0),(1,'TD00003',0,0),	
--		(1,'TD00004',0,0),
--		(1,'TD00005',0,0),(1,'TD00005',0,0),(1,'TD00005',0,0),
--		(1,'TD00006',0,0),(1,'TD00006',0,0),(1,'TD00006',0,0),(1,'TD00006',0,0),(1,'TD00006',0,0),(1,'TD00006',0,0),
--		(1,'TD00007',0,0),(1,'TD00007',0,0),
--		(1,'TD00008',0,0),
--		(1,'TD00009',0,0),
--		(1,'TD00010',0,0),(1,'TD00011',0,0),(1,'TD00012',0,0),(1,'TD00013',0,0),(1,'TD00014',0,0),(1,'TD00015',0,0),
--		(2,'TD00016',0,0),(2,'TD00016',0,0),
--		(2,'TD00017',0,0),(2,'TD00017',0,0),
--		(2,'TD00018',0,0),(2,'TD00019',0,0),(2,'TD00020',0,0),(2,'TD00021',0,0),(2,'TD00022',0,0),(2,'TD00023',0,0)


go
create function CongNo_KhachHang(@maKH nchar(7))
returns table
as
return
(
	select * from PhiTreHan 
	where maPTr in 
		( select maPTr from PhieuThue pt join PhieuTra ptr on pt.maPT = ptr.maPT where maKH = @maKH )
		 and thanhToan = 0
)
go

--Thực thi (gọi hàm)
--select * from dbo.CongNo_KhachHang('KH00003')

go
create function TongNo_KhachHang(@maKH nchar(7))
returns int
as
begin
	declare @tongNo int
	set @tongNo=   (select sum(tongTien)-sum(traTruoc) from PhiTreHan 
					where maPTr in 
						( select maPTr from PhieuThue pt join PhieuTra ptr on pt.maPT = ptr.maPT where maKH = @maKH )
						 and thanhToan = 0
				   )
	return @tongNo
end

go

--select * from PhieuThue where maKH = 'KH00003'
--select dbo.TongNo_KhachHang('KH00003')

go
create function TimPhieuThue(@txt nvarchar(30))
returns table
as
return
(
	select * from PhieuThue 
	where maPT in 
		( select maPT from PhieuThue pt join KhachHang kh on pt.maKH = kh.maKH 
			where kh.tenKH like '%' + convert(nvarchar(30),@txt) +'%' or pt.maPT like '%' + convert(nvarchar(30),@txt) +'%'
		)
)
go

--select * from dbo.TimPhieuThue('PT0002')

--drop function TimPhieuTra
go
create function TimPhieuTra(@txt nvarchar(30))
returns table
as
return
(
	select * from PhieuTra 
	where maPTr in 
		( select maPTr from PhieuTra ptr join Dia d on ptr.maDia = d.maDia 
			join TieuDe td on td.maTD = d.maTD
			where ptr.maPTr like '%' + convert(nvarchar(30),@txt) +'%' or td.tenTD like '%' + convert(nvarchar(30),@txt) +'%'
				or ptr.maDia like '%' + convert(nvarchar(30),@txt) +'%'
		)
)
go

--select * from dbo.TimPhieuTra(N'Mỹ nhân ngư')

go
create function TimPhieuDat(@txt nvarchar(30))
returns table
as
return
(
	select * from PhieuDat
	where maPD in 
		( select maPD from PhieuDat pd join KhachHang kh on pd.maKH = kh.maKH 
			join TieuDe td on td.maTD = pd.maTD
			where pd.maPD like '%' + convert(nvarchar(30),@txt) +'%' or td.tenTD like '%' + convert(nvarchar(30),@txt) +'%' or
				kh.tenKH like '%' + convert(nvarchar(30),@txt) +'%'
		)
)
go

--select * from dbo.TimPhieuDat(N'Tèo')

go
create view dbo.vwBaoCaoDia
as
select td.maTD,td.tenTD,
		(select count(d.maTD) from Dia d where d.maTD = td.maTD) as SoLuong,
		(select count(d.maTD) from Dia d where tinhTrang = 1 and d.maTD = td.maTD) as Chothue,
		(select count(d.maTD) from Dia d where tinhTrang = 0 and d.maTD = td.maTD) as Kho,
		(select count(pd.maTD) from PhieuDat pd where trangThai = 1 and pd.maTD = td.maTD) as DatHang 
from TieuDe td 
group by td.maTD,td.tenTD

--select * from dbo.vwBaoCaoDia
select * from TaiKhoan


