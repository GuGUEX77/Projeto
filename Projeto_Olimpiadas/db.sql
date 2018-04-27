drop database if exists jogosOlimpicos;
create database jogosOlimpicos;

use jogosOlimpicos;

create table if not exists pais (
	id_pais int not null auto_increment,
    nome varchar(60) not null,
    populacao bigint,
    area decimal(15,2),
    constraint pk_pais primary key (id_pais)
);

create table if not exists modalidade (
	id_modalidade int not null auto_increment,
	nome varchar(25) not null,
	tipo char,
	constraint pk_modalidade primary key (id_modalidade)
);

create table if not exists ano (
	ano int not null,
	tipo char,
	constraint pk_ano primary key (ano)
);

create table if not exists olimpiada (
    id_olimpiada int not null auto_increment,
	ouro int not null,
	prata int not null,
	bronze int not null,
	tipo char not null,
	idPais int,
	idAno int,
    idModalidade int,
    constraint pk_olimpiada primary key (id_olimpiada),
    constraint fk_id_pais foreign key (idPais) references pais(id_pais),
    constraint fk_id_ano foreign key (idPais) references pais(id_pais),
    constraint fk_id_modalidade foreign key (idModalidade) references modalidade(id_modalidade)
);

select * from olimpiada;

insert into pais (nome, populacao, area) values ("China", "1379302771", "9596961");
insert into pais (nome, populacao, area) values ("Estados Unidos", "308745538", "9371175");
insert into pais (nome, populacao, area) values ("Brasil", "207660929", "8515767");

insert into modalidade (nome, tipo) values ("Curling", "I");
insert into modalidade (nome, tipo) values ("Salto em Distância", "V");
insert into modalidade (nome, tipo) values ("Voleibol", "V");

insert into ano (ano, tipo) values (2018, "I");
insert into ano (ano, tipo) values (2016, "V");
insert into ano (ano, tipo) values (2014, "I");
