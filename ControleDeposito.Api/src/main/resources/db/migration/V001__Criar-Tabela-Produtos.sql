create table Produto(
	codigo bigint not null auto_increment,
	Nome varchar(60) not null,
	Descricao varchar(255) not null,
	
	primary key(codigo)
);