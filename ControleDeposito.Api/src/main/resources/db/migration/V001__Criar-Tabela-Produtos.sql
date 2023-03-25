create table Produto(
	Codigo bigint not null auto_increment,
	Nome varchar(60) not null,
	Descricao varchar(255) not null,
	Quantidade bigint not null,
	Preco double not null,
	
	primary key(Codigo)
);