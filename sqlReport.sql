use ufcCombate;

delete from fighter;
delete from combat;
delete from championship;
delete from fighterchampionship;

select *from fighter;
select *from combat;
select *from championship;
select *from fighterchampionship;

-- 01 Computar os lutadores vencedores de cada luta
select fighter.name as fighter, combat.name as combat, combat.category from fighter
inner join combat on fighter.id = combat.idwinner;

-- 02 Computar as lutas ocorridas em cada liga (2015, 2016, 2017, 2018 e 2019)
select combat.name as combat, combat.category, championship.ano, fighter.name as fighter from combat
inner join championship on combat.idchampionship = championship.id
inner join fighter on combat.idwinner = fighter.id
where championship.ano>='2015';

select combat.name as combat, combat.category, championship.ano, fighter.name as fighter from combat
inner join championship on combat.idchampionship = championship.id
inner join fighter on combat.idloser = fighter.id
where championship.ano>='2015';

-- 03 Computar os pontos ganhos para cada jogador em cada luta
select fighter.name as fighter, combat.name as combat, combat.pointwinner from fighter
inner join combat on fighter.id = combat.idwinner;

select fighter.name as fighter, combat.name as combat, combat.pointloser from fighter
inner join combat on fighter.id = combat.idloser;

-- 04 Número de vitórias por país
select fighter.parents, count(fighter.id) as numberwinner from fighter
inner join combat on fighter.id = combat.idwinner
group by fighter.parents;

-- 05 Número de vitórias por jogador
select fighter.name as fighter, count(fighter.id) as numberwinner from fighter
inner join combat on fighter.id = combat.idwinner
group by fighter.name;

-- 06 Maior vencedor por categoria
select fighter.name as fighter, fighter.category as category, count(fighter.id) as numberwinner from fighter
inner join combat on fighter.id = combat.idwinner
group by fighter.name, fighter.category
order by fighter.category, numberwinner desc, fighter.name;

-- 07 Número de lutas computadas no total
select count(combat.id) from combat
inner join championship on combat.idchampionship = championship.id;

-- 08 Nomes dos lutadores, categoria, país, sexo e quantidade de vitorias (ordenado em ordem crescente de vitórias dentro de cada categoria)
select fighter.name as fighter, fighter.category as category, fighter.parents, fighter.sex, count(fighter.id) as numberwinner from fighter
inner join combat on fighter.id = combat.idwinner
group by fighter.name, fighter.category
order by fighter.category, numberwinner asc, fighter.name;