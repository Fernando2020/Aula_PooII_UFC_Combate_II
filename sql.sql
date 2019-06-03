create database ufccombate;
use ufccombate;

create table Fighter(
Id int primary key,
Name varchar(30),
Category varchar(30),
Parents varchar(30),
Sex char(1)
)engine innodb, charset=utf8;

create table Championship(
Id int primary key,
Name varchar(30),
Ano varchar(5)
)engine innodb, charset=utf8;

create table FighterChampionship(
Id int primary key auto_increment,
IdFighter int,
IdChampionship int
)engine innodb, charset=utf8;

alter table FighterChampionship add foreign key (IdFighter) references Fighter(Id) on delete cascade on update cascade;
alter table FighterChampionship add foreign key (IdChampionship) references Championship(Id) on delete cascade on update cascade;

create table Combat(
Id int primary key auto_increment,
Name varchar(30),
Category varchar(30),
IdChampionship int,
IdFirst int,
IdSecond int, 
IdWinner int,
IdLoser int,
KO boolean,
PointWinner int,
PointLoser int
)engine innodb, charset=utf8;

alter table Combat add foreign key (IdChampionship) references Championship(Id) on delete cascade on update cascade;