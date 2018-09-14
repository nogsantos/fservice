INSERT INTO administration.person(
    id,     
    name
) VALUES (
    1,    
    'Fabricio Nogueira'
);

insert into administration.sysuser(
    id,
    login,    
    password,
    dt_block, 
    dt_cadastre, 
    dt_update
)values(
    1,
    'nogsantos',
    '$shiro1$SHA-256$500000$ZL0t/qw6b5wSHjcx5TpYsA==$GG8ghVDxw3iwPJER5USaeXmkl9vF25B0og6yeaFYnaQ=',
    null,
    now(),
    null
);

insert into administration.person_email (
    person_id,
    email
)values(
    1,
    'nogsantos@gmail.com'
);

insert into administration.person_email (
    person_id,
    email
)values(
    1,
    'nogsantos@ufg.br'
);

insert into administration.sysrole(
	id, 
	dt_cadastre, 
	name
)values(
	1,
	now(),
	'Admin'
);

insert into administration.sys_user_role
values(1,1);