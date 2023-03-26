create table Encomenda(
	Codigo bigint not null auto_increment,
	Nome varchar(60) not null,
	Descricao varchar(255) not null,
	Quantidade bigint not null,
	Status varchar(20) not null,
	
	primary key(Codigo)
);