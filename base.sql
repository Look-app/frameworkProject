/*SEQUENCE */
CREATE sequence seq_Client  start with 1 increment by 1;
CREATE sequence seq_TypeVol  start with 1 increment by 1;
CREATE sequence seq_TypeAvion  start with 1 increment by 1;
CREATE sequence seq_TypeClasse  start with 1 increment by 1;
CREATE sequence seq_Billet  start with 1 increment by 1;
CREATE sequence seq_Destination  start with 1 increment by 1;
CREATE sequence seq_Reservation  start with 1 increment by 1;

/*TABLE */
create table Client(
	id varchar(15) primary key,
	nom varchar(50),
	prenom varchar(50));
	
create table TypeVol(
	id varchar(15) primary key,
	valeur varchar(50));
	
create table TypeClasse(
	id varchar(15) primary key,
	valeur varchar(50));
	
create table TypeAvion(
	id varchar(15) primary key,
	valeur varchar(50));
	
create table Destination(
	id varchar(15) primary key,
	valeur varchar(50),
	prix decimal (10,2));
	
create table Billet(
	id varchar(15) primary key,
	idDestination varchar(50),
	daty datetime,
	prixUnitaire decimal (10,2));
	
create table Avion(
	id varchar(15) primary key,
	idTypeAvion varchar(15),
	idTypeVol varchar(15),
	
	nom varchar(50),
	foreign key (idTypeAvion) references TypeAvion(id),
	foreign key (idTypeVol) references TypeVol(id)
);
create table Reservation(
	id varchar(15) primary key,
	idClient varchar(15),
	idBillet varchar(15),
	idTypeClasse varchar(15),
	dateReservation datetime,
	
	foreign key (idClient) references Client(id),
	foreign key (idTypeClasse) references TypeClasse(id),
	foreign key (idBillet) references Billet(id));
	
	
/*DONNEES mila misy micreer*/

