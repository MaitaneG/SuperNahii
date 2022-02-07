-- Trigerra hr_emplyee taularen erabiltzaileak app_user taulara kopiatu, lehenengoan pasahitza ezin delako irakurri  Androitik

create or replace function copy_users()
returns trigger as 
$$ 
declare
	izena varchar;
begin
	select name into izena from hr_employee where user_id = new.user_id;
	insert into app_users(id,name,username) values (new.user_id,izena,new.login);
	return new;
end;
$$
language 'plpgsql';

create trigger app_newusers 
after insert on res_users
for each row 
execute procedure copy_users();



-- Erabiltzaileak ezabatzerakoan honek app_user taulan ere ezabatzeko triggerra

create or replace function drop_users()
returns trigger as 
$$ 
begin
	delete from app_users where email = old.login;
	retun old;
end;
$$
language 'plpgsql';

create trigger app_oldusers 
before delete on res_users
for each row 
execute procedure drop_users();


-- Jokalariaren departamentua eta adina actualizatzeko triggerra

CREATE OR REPLACE FUNCTION update_ranking()
 RETURNS trigger AS 
 $$ 
declare
	d varchar;
	b varchar;
	a int;
begin
	select name into d from hr_department where id = (select department_id from hr_employee where name = new.jokalari);
	select birthday into b from hr_employee where name = new.jokalari;
    select extract(year from age(to_date(b, 'YYYY-MM-DD'))) into a;
	update ranking_juego_puntuazioa set dept = d, adina = a where jokalari = new.jokalari;
	return new;
end;
$$
language 'plpgsql';

create trigger puntuazioa_new 
after insert on ranking_juego_puntuazioa 
for each row 
execute function update_ranking();