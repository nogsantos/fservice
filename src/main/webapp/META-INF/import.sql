INSERT INTO administration.person(
    id,     
    name
) VALUES (
    1,    
    'Admin'
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
    'admin',
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
	name,
        description
)values(
	1,
	now(),
	'Administrador',
        'Perfil de administrador do sistema'
);

insert into administration.sys_user_role
values(1,1);