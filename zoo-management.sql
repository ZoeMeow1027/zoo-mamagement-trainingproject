create database ZooManagement;

use ZooManagement;

create table Contracts (
	ID_Contract int NOT NULL AUTO_INCREMENT primary key,
	Details text
	);


create table Staff_Type (
	ID_Staff_Type int NOT NULL AUTO_INCREMENT primary key,
	Staff_Type varchar(50),
	Details text
	);


create table Account_Type (
	ID_Account_Type int NOT NULL AUTO_INCREMENT primary key,
	Role varchar(50)
	);


create table Account (
	Username varchar(50) primary key,
	Pass varchar(50),
	ID_Account_Type int,

	foreign key (ID_Account_Type) references Account_Type(ID_Account_Type)
	);


create table Staff (
	ID_Staff int NOT NULL AUTO_INCREMENT primary key,
	Staff_Name varchar(50),
	Salary int,
	ID_Contract int unique,
	ID_Staff_Type int,
	Username varchar(50) unique,

	foreign key (ID_Contract) references Contracts(ID_Contract),
	foreign key (ID_Staff_Type) references Staff_Type(ID_Staff_Type),
	foreign key (Username) references Account(Username)
	);



create table Cage (
	ID_Cage int NOT NULL AUTO_INCREMENT primary key,
	Name_Cage varchar(50),
	`Limit` int,
	ID_Staff int,

	foreign key (ID_Staff) references Staff(ID_Staff)
	);


create table Animal_Type (
	ID_Animal_Type int NOT NULL AUTO_INCREMENT primary key,
	Animal_Type varchar(50)
	);


create table Animal (
	ID_Animal int NOT NULL AUTO_INCREMENT primary key,
	ID_Cage int,
	ID_Animal_Type int,
	Animal_Status varchar(50),
	Animal_Name varchar(50),
	Details text,
	Food varchar(50),

	foreign key (ID_Cage) references Cage(ID_Cage),
	foreign key (ID_Animal_Type) references Animal_Type(ID_Animal_Type) 
	);


create table Supplier_Type (
	ID_Supplier_Type int NOT NULL AUTO_INCREMENT primary key,
	Supplier_Type varchar(50)
	);


create table Supplier (
	ID_Supplier int NOT NULL AUTO_INCREMENT primary key,
	ID_Contract int unique,
	ID_Supplier_Type int,
	Supplier_Name varchar(50),

	foreign key (ID_Contract) references Contracts(ID_Contract),
	foreign key (ID_Supplier_Type) references Supplier_Type(ID_Supplier_Type)
	);



create table Payment (
	ID_Payment int NOT NULL AUTO_INCREMENT primary key,
	Payment_Type varchar(50)
	);


create table Customer (
	ID_Customer int NOT NULL AUTO_INCREMENT primary key,
	Customer_Name varchar(50),
    Address varchar(100),
	Email varchar(50),
	Phone varchar(10),
	Username varchar(50) unique,

	foreign key (Username) references Account(Username)
	);

create table Ticket_Type (
	ID_Ticket_Type int NOT NULL AUTO_INCREMENT primary key,
	Ticket_Type varchar(50),
    Ticket_Description text
	);

create table Ticket_Age (
	ID_Ticket_Age int NOT NULL AUTO_INCREMENT primary key,
    Age_Description varchar(100)
);

create table Ticket (
	ID_Ticket int NOT NULL AUTO_INCREMENT primary key,
	ID_Ticket_Type int,
	ID_Ticket_Age int,
	Amount int,
	Price int,
    
	foreign key (ID_Ticket_Age) references Ticket_Age(ID_Ticket_Age),
	foreign key (ID_Ticket_Type) references Ticket_Type(ID_Ticket_Type)
	);

create table Ticket_History (
	ID_Ticket_History int NOT NULL AUTO_INCREMENT primary key,
	Purchase_Date date,
	Amount int,
    ID_Ticket int,
	ID_Customer int,
	ID_Staff int,
	ID_Payment int,
	foreign key (ID_Ticket) references Ticket(ID_Ticket),
	foreign key (ID_Staff) references Staff(ID_Staff),
	foreign key (ID_Payment) references Payment(ID_Payment),
	foreign key (ID_Customer) references Customer(ID_Customer)
	);

create table Product_Type (
	ID_Product_Type int NOT NULL AUTO_INCREMENT primary key,
	Product_Type varchar(50)
	);


create table Inventory (
	ID_Inventory int NOT NULL AUTO_INCREMENT primary key,
	Inventory_Address text,
	Inventory_Name varchar(50),
	ID_Inventory_Type int,

	foreign key (ID_Inventory_Type) references Product_Type(ID_Product_Type)
	);

create table Product (
	ID_Product int NOT NULL AUTO_INCREMENT primary key,
	Product_Name varchar(100),
	
	Amount int,
	ID_Supplier int,
	ID_Inventory int,
	Price int,

	foreign key (ID_Supplier) references Supplier(ID_Supplier),
	foreign key (ID_Inventory) references Inventory(ID_Inventory)
	);

create table Bill (
	ID_Bill int NOT NULL AUTO_INCREMENT primary key,
	Bill_Type bit,
	Bill_Name varchar(50),
	ID_Supplier int,

	foreign key (ID_Supplier) references Supplier(ID_Supplier)
	);


create table Bill_Detail (
	ID_Bill_Detail int NOT NULL AUTO_INCREMENT primary key,
	ID_Bill int,
	Amount_Transfer varchar(50),
	Transfer_Date date,
	ID_Product int,

	foreign key (ID_Bill) references Bill(ID_Bill),
	foreign key (ID_Product) references Product(ID_Product)
	);




INSERT INTO `ZooManagement`.`Ticket_Type` (`Ticket_Type`, `Ticket_Description`) VALUES ('Vé vào cổng', 'Yêu cầu đặt vé trực tuyến trước để vào cổng');
INSERT INTO `ZooManagement`.`Ticket_Type` (`Ticket_Type`, `Ticket_Description`) VALUES ('Vé tàu SEPTA PZ Express', 'Tham gia chuyến tàu SEPTA PZ Express của chúng tôi để có được trải nghiệm tốt nhất');

INSERT INTO `ZooManagement`.`Ticket_Age` (`Age_Description`) VALUES ('Người lớn (Trên 12 tuổi)');
INSERT INTO `ZooManagement`.`Ticket_Age` (`Age_Description`) VALUES ('Trẻ em (Từ 2-11 tuổi)');
INSERT INTO `ZooManagement`.`Ticket_Age` (`Age_Description`) VALUES ('Trẻ em (Dưới 2 tuổi)');

INSERT INTO `ZooManagement`.`Ticket` (`ID_Ticket_Type`, `ID_Ticket_Age`, `Amount`, `Price`) VALUES ('1', '1', '1000', '80000');
INSERT INTO `ZooManagement`.`Ticket` (`ID_Ticket_Type`, `ID_Ticket_Age`, `Amount`, `Price`) VALUES ('1', '2', '1000', '60000');
INSERT INTO `ZooManagement`.`Ticket` (`ID_Ticket_Type`, `ID_Ticket_Age`, `Amount`, `Price`) VALUES ('1', '3', '1000', '0');

INSERT INTO `ZooManagement`.`Ticket` (`ID_Ticket_Type`, `ID_Ticket_Age`, `Amount`, `Price`) VALUES ('2', '1', '50', '60000');
INSERT INTO `ZooManagement`.`Ticket` (`ID_Ticket_Type`, `ID_Ticket_Age`, `Amount`, `Price`) VALUES ('2', '2', '50', '40000');
INSERT INTO `ZooManagement`.`Ticket` (`ID_Ticket_Type`, `ID_Ticket_Age`, `Amount`, `Price`) VALUES ('2', '3', '50', '0');

INSERT INTO `ZooManagement`.`Account_Type` (`Role`) VALUES ('Customer');
INSERT INTO `ZooManagement`.`Account_Type` (`Role`) VALUES ('Admin');

INSERT INTO `ZooManagement`.`Account` (`Username`, `Pass`, `ID_Account_Type`) VALUES ('ngaly', '123456789', '1');
INSERT INTO `ZooManagement`.`Account` (`Username`, `Pass`, `ID_Account_Type`) VALUES ('admin', 'admin', '2');

-- insert into Account_Type values(3, "Staff");
-- insert into Account value("nva","nva", 3);
-- insert into Account value("nvb","nvb", 3);
-- insert into Account value("nvc","nvc", 3);
-- insert into Account value("nvd","nvd", 3);
-- insert into Account value("nve","nve", 3);
-- insert into Account value("nvf","nvf", 3);
-- insert into Account value("nvg","nvg", 3);
-- insert into Account value("nvh","nvh", 3);
-- insert into Account value("nvi","nvi", 3);
-- insert into Account value("nta","nta", 3);
-- insert into Account value("ntb","ntb", 3);
-- insert into Account value("ntc","ntc", 3);
-- insert into Account value("ntd","ntd", 3);
-- insert into Account value("nte","nte", 3);
-- insert into Account value("ntf","ntf", 3);
-- insert into Account value("ntg","ntg", 3);
-- insert into Account value("nth","nth", 3);
-- insert into Account value("nti","nti", 3);

-- insert into Staff_Type values (1, "Nhân viên bán vé"  , "Bán vé");
-- insert into Staff_Type values (2, "Nhân viên thú y"   , "Chăm sóc sức khỏe động vật");
-- insert into Staff_Type values (3, "Nhân viên vệ sinh" , "Dọn dẹp vệ sinh");
-- insert into Staff_Type values (4, "Nhân viên chăm sóc", "Cho ăn, trông coi động vật");

-- insert into contracts values (1, "nothing");
-- insert into contracts values (2, "nothing");
-- insert into contracts values (3, "nothing");
-- insert into contracts values (4, "nothing");
-- insert into contracts values (5, "nothing");
-- insert into contracts values (6, "nothing");
-- insert into contracts values (7, "nothing");
-- insert into contracts values (8, "nothing");
-- insert into contracts values (9, "nothing");
-- insert into contracts values (10, "nothing");
-- insert into contracts values (11, "nothing");
-- insert into contracts values (12, "nothing");
-- insert into contracts values (13, "nothing");
-- insert into contracts values (14, "nothing");
-- insert into contracts values (15, "nothing");
-- insert into contracts values (16, "nothing");
-- insert into contracts values (17, "nothing");
-- insert into contracts values (18, "nothing");

-- insert into staff values (1, "Nguyễn Văn A", 100, 1, 1, "nva");
-- insert into staff values (2, "Nguyễn Văn B", 100, 2, 2, "nvb");
-- insert into staff values (3, "Nguyễn Văn C", 100, 3, 1, "nvc");
-- insert into staff values (4, "Nguyễn Văn D", 100, 4, 1, "nvd");
-- insert into staff values (5, "Nguyễn Văn E", 100, 5, 2, "nve");
-- insert into staff values (6, "Nguyễn Văn F", 100, 6, 3, "nvf");
-- insert into staff values (7, "Nguyễn Văn G", 100, 7, 3, "nvg");
-- insert into staff values (8, "Nguyễn Văn H", 100, 8, 3, "nvh");
-- insert into staff values (9, "Nguyễn Văn I", 100, 9, 4, "nvi");
-- insert into staff values (10, "Nguyễn Thị A", 100, 10, 1, "nta");
-- insert into staff values (11, "Nguyễn Thị B", 100, 11, 2, "ntb");
-- insert into staff values (12, "Nguyễn Thị C", 100, 12, 1, "ntc");
-- insert into staff values (13, "Nguyễn Thị D", 100, 13, 1, "ntd");
-- insert into staff values (14, "Nguyễn Thị E", 100, 14, 2, "nte");
-- insert into staff values (15, "Nguyễn Thị F", 100, 15, 3, "ntf");
-- insert into staff values (16, "Nguyễn Thị G", 100, 16, 3, "ntg");
-- insert into staff values (17, "Nguyễn Thị H", 100, 17, 3, "nth");
-- insert into staff values (18, "Nguyễn Thị I", 100, 18, 4, "nti");

-- insert into Account (Username, Pass, ID_Account_Type) VALUE ('kh1', 'kh1', 3);
-- insert into Account (Username, Pass, ID_Account_Type) VALUE ('kh2', 'kh2', 3);
-- insert into Account (Username, Pass, ID_Account_Type) VALUE ('kh3', 'kh3', 3);
-- insert into Account (Username, Pass, ID_Account_Type) VALUE ('kh4', 'kh4', 3);
-- insert into Account (Username, Pass, ID_Account_Type) VALUE ('kh5', 'kh5', 3); 


-- INSERT INTO customer (Customer_Name, Email, Phone, Username) VALUE ('Khách Hàng 1', 'kh1@gmail.com', 0978987765, 'kh1');
-- INSERT INTO customer (Customer_Name, Email, Phone, Username) VALUE ('Khách Hàng 2', 'kh2@gmail.com', 0978987765, 'kh2');
-- INSERT INTO customer (Customer_Name, Email, Phone, Username) VALUE ('Khách Hàng 3', 'kh3@gmail.com', 0978987765, 'kh3');
-- INSERT INTO customer (Customer_Name, Email, Phone, Username) VALUE ('Khách Hàng 4', 'kh4@gmail.com', 0978987765, 'kh4');
-- INSERT INTO customer (Customer_Name, Email, Phone, Username) VALUE ('Khách Hàng 5', 'kh5@gmail.com', 0978987765, 'kh5');

-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 2, 1, 1, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 3, 2, 1, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 2, 4, 1, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 3, 5, 1, 3);

-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 2, 1, 2, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 3, 2, 2, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 2, 4, 2, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-13', 3, 5, 2, 3);

-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-10', 5 , 1, 3, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-10', 10, 2, 3, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-10', 5 , 4, 3, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-03-10', 10, 5, 3, 3);

-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-13', 2, 1, 4, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-13', 3, 2, 4, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-13', 2, 4, 4, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-13', 3, 5, 4, 3);

-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-12', 2, 1, 5, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-12', 5, 2, 5, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-12', 2, 4, 5, 3);
-- INSERT INTO ticket_history (Purchase_Date, Amount, ID_Ticket, ID_Customer, ID_Staff) VALUE ('2023-02-12', 5, 5, 5, 3);

INSERT INTO Contracts (Details) VALUES ('Contract 1 details');
INSERT INTO Contracts (Details) VALUES ('Contract 2 details');
INSERT INTO Contracts (Details) VALUES ('Contract 3 details');
INSERT INTO Contracts (Details) VALUES ('Contract 4 details');
INSERT INTO Contracts (Details) VALUES ('Contract 5 details');
INSERT INTO Contracts (Details) VALUES ('Contract 6 details');
INSERT INTO Contracts (Details) VALUES ('Contract 7 details');
INSERT INTO Contracts (Details) VALUES ('Contract 8 details');
INSERT INTO Contracts (Details) VALUES ('Contract 9 details');
INSERT INTO Contracts (Details) VALUES ('Contract 10 details');
INSERT INTO Contracts (Details) VALUES ('Contract 11 details');
INSERT INTO Contracts (Details) VALUES ('Contract 12 details');
INSERT INTO Contracts (Details) VALUES ('Contract 13 details');

INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Manager', 'Manager details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Zookeeper', 'Zookeeper details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Trainer', 'Trainer details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Janitor', 'Janitor details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Security guard', 'Security guard details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Chef', 'Chef details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Tour guide', 'Tour guide details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Veterinarian', 'Veterinarian details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Photographer', 'Photographer details');
INSERT INTO Staff_Type (Staff_Type, Details) VALUES ('Driver', 'Driver details');

INSERT INTO Account_Type (Role) VALUES ('Staff');

INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('customer1', 'customer1pass', 1);
INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('customer2', 'customer2pass', 1);
INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('customer3', 'customer3pass', 1);

INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('staff1', 'staff1pass', 3);
INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('staff2', 'staff2pass', 3);
INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('staff3', 'staff3pass', 3);
INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('staff4', 'staff4pass', 3);
INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('staff5', 'staff5pass', 3);
INSERT INTO Account (Username, Pass, ID_Account_Type) VALUES ('staff6', 'staff6pass', 3);

INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('Staff 1', 1000, 1, 2, 'staff1');
INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('Staff 2', 1200, 2, 3, 'staff2');
INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('Staff 3', 1500, 3, 1, 'staff3');
INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('Staff 4', 800, 4, 4, 'staff4');
INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('Staff 5', 900, 5, 5, 'staff5');
INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('Staff 6', 1100, 6, 6, 'staff6');
INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('Manager 1', 2000, 7, 1, 'admin');

INSERT INTO Cage (Name_Cage, `Limit`, ID_Staff) VALUES ('Cage 1', 5, 2);
INSERT INTO Cage (Name_Cage, `Limit`, ID_Staff) VALUES ('Cage 2', 2, 2);
INSERT INTO Cage (Name_Cage, `Limit`, ID_Staff) VALUES ('Cage 3', 3, 3);
INSERT INTO Cage (Name_Cage, `Limit`, ID_Staff) VALUES ('Cage 4', 4, 4);
INSERT INTO Cage (Name_Cage, `Limit`, ID_Staff) VALUES ('Cage 5', 2, 5);
INSERT INTO Cage (Name_Cage, `Limit`, ID_Staff) VALUES ('Cage 6', 1, 6);

INSERT INTO Animal_Type (Animal_Type) VALUES ('Lion');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Tiger');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Bear');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Giraffe');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Elephant');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Monkey');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Kangaroo');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Dolphin');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Penguin');
INSERT INTO Animal_Type (Animal_Type) VALUES ('Seal');

INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (1, 1, 'Healthy', 'Lion 1', 'Lion details', 'Meat');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (2, 2, 'Healthy', 'Tiger 1', 'Tiger details', 'Meat');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (3, 3, 'Healthy', 'Bear 1', 'Bear details', 'Fish');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (4, 4, 'Healthy', 'Giraffe 1', 'Giraffe details', 'Leaves');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (5, 5, 'Healthy', 'Elephant 1', 'Elephant details', 'Fruits');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (6, 6, 'Healthy', 'Monkey 1', 'Monkey details', 'Bananas');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (2, 7, 'Healthy', 'Kangaroo 1', 'Kangaroo details', 'Grass');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (3, 8, 'Healthy', 'Dolphin 1', 'Dolphin details', 'Fish');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (4, 9, 'Healthy', 'Penguin 1', 'Penguin details', 'Fish');
INSERT INTO Animal (ID_Cage, ID_Animal_Type, Animal_Status, Animal_Name, Details, Food) VALUES (5, 10, 'Healthy', 'Seal 1', 'Seal details', 'Fish');

INSERT INTO Product_Type (Product_Type) VALUES ('Electronics');
INSERT INTO Product_Type (Product_Type) VALUES ('Apparel');
INSERT INTO Product_Type (Product_Type) VALUES ('Home Goods');
INSERT INTO Product_Type (Product_Type) VALUES ('Sports Equipment');
INSERT INTO Product_Type (Product_Type) VALUES ('Beauty Products');
INSERT INTO Product_Type (Product_Type) VALUES ('Food and Beverages');
INSERT INTO Product_Type (Product_Type) VALUES ('Pet Supplies');


INSERT INTO Inventory (Inventory_Address, Inventory_Name, ID_Inventory_Type) VALUES ('123 A St', 'A Storage', 1);
INSERT INTO Inventory (Inventory_Address, Inventory_Name, ID_Inventory_Type) VALUES ('456 B St', 'B Street Storage', 2);
INSERT INTO Inventory (Inventory_Address, Inventory_Name, ID_Inventory_Type) VALUES ('789 C St', 'C Street Storage', 3);
INSERT INTO Inventory (Inventory_Address, Inventory_Name, ID_Inventory_Type) VALUES ('111 D St', 'D Street Storage', 4);
INSERT INTO Inventory (Inventory_Address, Inventory_Name, ID_Inventory_Type) VALUES ('222 E St', 'E Storage', 5);
INSERT INTO Inventory (Inventory_Address, Inventory_Name, ID_Inventory_Type) VALUES ('333 F St', 'F Storage', 6);
INSERT INTO Inventory (Inventory_Address, Inventory_Name, ID_Inventory_Type) VALUES ('444 G St', 'G Storage', 7);

INSERT INTO Supplier_Type (Supplier_Type) VALUES ('Electronics');
INSERT INTO Supplier_Type (Supplier_Type) VALUES ('Clothing');
INSERT INTO Supplier_Type (Supplier_Type) VALUES ('Furniture');
INSERT INTO Supplier_Type (Supplier_Type) VALUES ('Food and Beverages');
INSERT INTO Supplier_Type (Supplier_Type) VALUES ('Pet Supplies');
INSERT INTO Supplier_Type (Supplier_Type) VALUES ('Medicine');

INSERT INTO Supplier (ID_Contract, ID_Supplier_Type, Supplier_Name) VALUES (8, 1, 'A Inc.');
INSERT INTO Supplier (ID_Contract, ID_Supplier_Type, Supplier_Name) VALUES (9, 2, 'B Inc.');
INSERT INTO Supplier (ID_Contract, ID_Supplier_Type, Supplier_Name) VALUES (10, 3, 'C Inc');
INSERT INTO Supplier (ID_Contract, ID_Supplier_Type, Supplier_Name) VALUES (11, 4, 'D Inc');
INSERT INTO Supplier (ID_Contract, ID_Supplier_Type, Supplier_Name) VALUES (12, 5, 'E Inc');
INSERT INTO Supplier (ID_Contract, ID_Supplier_Type, Supplier_Name) VALUES (13, 6, 'F Inc');

INSERT INTO Product (Product_Name, Amount, ID_Supplier, ID_Inventory, Price) VALUES ('Meat', 100, 1, 1, 999);
INSERT INTO Product (Product_Name, Amount, ID_Supplier, ID_Inventory, Price) VALUES ('Fruits', 500, 2, 2, 20);
INSERT INTO Product (Product_Name, Amount, ID_Supplier, ID_Inventory, Price) VALUES ('Electronis', 50, 3, 3, 499);
INSERT INTO Product (Product_Name, Amount, ID_Supplier, ID_Inventory, Price) VALUES ('Pictures', 200, 4, 4, 29);
INSERT INTO Product (Product_Name, Amount, ID_Supplier, ID_Inventory, Price) VALUES ('Medicine', 300, 5, 5, 10);
INSERT INTO Product (Product_Name, Amount, ID_Supplier, ID_Inventory, Price) VALUES ('Books', 1000, 6, 6, 15);

INSERT INTO Bill (Bill_Type, Bill_Name, ID_Supplier) VALUES (1, 'Electronics order', 1);
INSERT INTO Bill (Bill_Type, Bill_Name, ID_Supplier) VALUES (1, 'Home goods order', 2);
INSERT INTO Bill (Bill_Type, Bill_Name, ID_Supplier) VALUES (1, 'Sports equipment order', 3);
INSERT INTO Bill (Bill_Type, Bill_Name, ID_Supplier) VALUES (1, 'Beauty products order', 4);
INSERT INTO Bill (Bill_Type, Bill_Name, ID_Supplier) VALUES (1, 'Books order', 5);
INSERT INTO Bill (Bill_Type, Bill_Name, ID_Supplier) VALUES (1, 'Food and beverages order', 6);

INSERT INTO Bill_Detail (ID_Bill, Amount_Transfer, Transfer_Date, ID_Product) VALUES (1, 50, '2023-03-20', 1);
INSERT INTO Bill_Detail (ID_Bill, Amount_Transfer, Transfer_Date, ID_Product) VALUES (2, 200, '2023-03-21', 2);
INSERT INTO Bill_Detail (ID_Bill, Amount_Transfer, Transfer_Date, ID_Product) VALUES (3, 10, '2023-03-22', 3);
INSERT INTO Bill_Detail (ID_Bill, Amount_Transfer, Transfer_Date, ID_Product) VALUES (4, 100, '2023-03-23', 4);
INSERT INTO Bill_Detail (ID_Bill, Amount_Transfer, Transfer_Date, ID_Product) VALUES (5, 150, '2023-03-24', 5);
INSERT INTO Bill_Detail (ID_Bill, Amount_Transfer, Transfer_Date, ID_Product) VALUES (6, 500, '2023-03-25', 6);

INSERT INTO Payment (Payment_Type) VALUES ('Credit Card');
INSERT INTO Payment (Payment_Type) VALUES ('Debit Card');
INSERT INTO Payment (Payment_Type) VALUES ('PayPal');
INSERT INTO Payment (Payment_Type) VALUES ('Momo');
INSERT INTO Payment (Payment_Type) VALUES ('Apple Pay');
INSERT INTO Payment (Payment_Type) VALUES ('Google Wallet');
INSERT INTO Payment (Payment_Type) VALUES ('Cash');
INSERT INTO Payment (Payment_Type) VALUES ('Samsung Pay');
INSERT INTO Payment (Payment_Type) VALUES ('Shopee Pay');
INSERT INTO Payment (Payment_Type) VALUES ('Bitcoin');

INSERT INTO Customer (Customer_Name, Address, Email, Phone, Username) VALUES ('Customer1', 'VN', 'abc@email.com', '555-1234', 'customer1');
INSERT INTO Customer (Customer_Name, Address, Email, Phone, Username) VALUES ('Customer2', 'USA', 'def@email.com', '555-5678', 'customer2');
INSERT INTO Customer (Customer_Name, Address, Email, Phone, Username) VALUES ('Customer3', 'China', 'ijk@email.com', '555-9012', 'customer3');
