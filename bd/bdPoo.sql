Create database youchoose1;
Use youchoose1;

CREATE TABLE Codigopostal (
			cp_id int  not null auto_increment,
            cp_concelho varchar (30) not null,
            cp_freguesia varchar (30)not null ,
            cp_pais varchar (30) not null ,
            cp_4D int not null,
            cp_3D int not null,
            Constraint pk_cp primary key (cp_id),
/* Verificar se os valores inseridos pelo utilizador equivalem a 4 digitos para o cp_4d e de 3 digitos para o cp_3d */
            Check (length (cp_4D) = 4),
            check (length (cp_3D) = 3)
            
);
/*
A tabela escalao serve para fazer o ranking dos utilzadores atraves de pontos, apartir dos quais 
poderão subir .*/

CREATE TABLE Escalao (
			esc_id int not null auto_increment ,
            esc_nome varchar (30)not null,
            esc_pontos int default 0,	-- Quantidade total de pontos do utlizador,
            Constraint pk_esc primary key (esc_id)
            
);
/* A tabela evento consiste nos eventos que a youchoose irá propror aos utilizadores **/

CREATE TABLE Evento (
			ev_id int not null auto_increment,
            ev_data date not null,
            ev_nome varchar (50) not null,
            tev_id int not null,
            Constraint Pk_ev primary key (ev_id),
            Constraint fk_tev3 foreign key (tev_id)references tipo_evento (tev_id)
);

/* A tabela Forum consiste no apoio para quem tiver dificuldades em certos setores da app como 
inserir os dados de exercicio */

CREATE TABLE Forum (
			forum_id int not null auto_increment,
            forum_nome varchar (30),
			constraint Pk_for primary key (forum_id)
);



/* Caracteristicas do evento proposto pela youchoose */

CREATE TABLE Tipo_evento (
			tev_id int not null auto_increment,
            tev_nome varchar (50) not null,
            tev_data date,
            Constraint pk_pktev primary key (tev_id)
);

/********
*  Lista de Entidades Informaconais fracas
********/

/* O tutorial estao inseridos no forum e apoiam no esclarecimento de duvidas dos utilizadores */
CREATE TABLE Tutorial ( 
			tut_id int not null auto_increment,
            tut_data date not null,
            tut_nome varchar (30) not null,
            constraint pk_pktut primary key (tut_id)
);


/********
*  Lista de Entidades Informaconais com FK
********/

/* Dados pessoais inseridos pelo utlizador ao criar a sua conta na youchoose */

CREATE TABLE Utilizador (
			ut_id int default 0 not null ,
            ut_proprio varchar (50) not null,
            ut_apelido varchar (50) not null ,
            ut_datanasc date not null , 
            ut_idade int not null ,
            ut_total_pontos int not null ,
            cp_id int not null,
            esc_id int not null,
            ut_genero varchar (20) not null ,
            Constraint pk_ut primary key (ut_id),
            Constraint fk_cp1 foreign key (cp_id)references Codigopostal(cp_id),
            Constraint fk_esc1 foreign key (esc_id)references escalao (esc_id),
             /* segundo as regras de integridade de negócio da youchoose 
            não são permitidas pessoas com idade inferior a 18 anos*/
            
			check (ut_idade >= 18)
		
);

 /* Caracteristicas do evento proposto pela youchoose */    
 
CREATE TABLE Tipo_evento_tev_caract (
			tevcaract_id int not null auto_increment,
            tev_caract varchar (150),
            tev_id int not null,
            Constraint pk_tevcaract primary key (tevcaract_id),
            Constraint fk_tev1 foreign key (tev_id) references Tipo_evento (tev_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION
            
);


/* Caracteristicas dos tutoriais */

CREATE TABLE tutorial_tut_caract (
			tut_caract_id int not null auto_increment,
            tut_caract varchar (150),
            tut_id int not null,
            Constraint pk_tut_caract primary key (tut_caract_id),
            Constraint fk_tut foreign key (tut_id) references Tutorial (tut_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION
            
);

/*********************************************/

INSERT INTO Codigopostal values
	(1, "lisboa" ,"Campolide" , "Portugal", "1070" ,  "183"),
	(2, "Vila Franca de Xira" ,"Alverca" , "Portugal", "2615" ,  "268"),
	(3, "Cascais " ,"Cascais" , "Portugal", "2750" ,  "179"),
	(4, "Lisboa" ,"Alvalade" , "Portugal", "1450" ,  "134"),
	(5, "Cascais " ,"S Pedro" , "Portugal", "2765" ,  "467"),
	(6, "Albufeira " ,"Albufeira" , "Portugal", "8200" ,  "105"),
	(7, "Lisboa " ,"Campo de Ourique" , "Portugal", "1500" ,  "158"),
	(8, "Cascais" ,"Alcabideche" , "Portugal", "2645" ,  "107"),
	(9, "Cascais" ,"Estoril" , "Portugal", "2765" ,  "103"),
	(10, "Porto" ,"Foz do Douro" , "Portugal", "4000" ,  "125"),
	(11, "Lisboa" ,"Belem" , "Portugal", "1055" ,  "234"),
	(12, "Vila Franca de Xira" ,"Alhandra" , "Portugal", "2665" ,  "368"),
	(13, "Lisboa" ,"Alcantara" , "Portugal", "1256" ,  "378"),
	(14, "Amadora" ,"Alfragide" , "Portugal", "1765" ,  "265"),
	(15, "lisboa" ,"Campolide" , "Portugal", "1070" ,  "183"),
	(16, "Vila Franca de Xira" ,"Alverca" , "Portugal", "2615" ,  "268"),
	(17, "Cascais " ,"Cascais" , "Portugal", "2750" ,  "179"),
	(18, "Lisboa" ,"Alvalade" , "Portugal", "1450" ,  "134"),
	(19, "Cascais " ,"S Pedro" , "Portugal", "2765" ,  "467"),
	(20, "Albufeira " ,"Albufeira" , "Portugal", "8200" ,  "105"),
	(21, "Lisboa " ,"Campo de Ourique" , "Portugal", "1500" ,  "158"),
	(22, "Cascais" ,"Alcabideche" , "Portugal", "2645" ,  "107"),
	(23, "Cascais" ,"Estoril" , "Portugal", "2765" ,  "103"),
	(24, "Porto" ,"Foz do Douro" , "Portugal", "4000" ,  "125"),
	(25, "Lisboa" ,"Belem" , "Portugal", "1055" ,  "234"),
	(26, "Vila Franca de Xira" ,"Alhandra" , "Portugal", "2665" ,  "368"),
	(27, "Lisboa" ,"Alcantara" , "Portugal", "1256" ,  "378"),
	(28, "Amadora" ,"Alfragide" , "Portugal", "1765" ,  "265"),
	(29, "Amadora" ,"Alfragide" , "Portugal", "1765" ,  "265"),
	(30, "lisboa" ,"Campolide" , "Portugal", "1070" ,  "183");


INSERT INTO Escalao values
	(1, "Novato" ,"20"),
	(2, "Junior" ,"50"),
	(3, " Atleta" ,"70"),
	(4, "Mestre" ,"100");

Select * from Escalao ;

INSERT INTO Evento values 
	(1, "2021-06-26" ,"Maratona de Lisboa ",1),
	(2, " 2021-04-27" ,"Caminhada em Monsanto",2),
	(3, " 2021-06-01" ,"Caminhada da Criança",3),
	(4, " 2021-07-15" ,"Corrida Solidária",4),
	(5, " 2021-09-29" ,"Corrida de São Silvestre",5),
	(6, " 2021-12-23" ,"Caça aos presentes",6),
	(7, " 2021-08-07" ,"Volta ao Algarve",7),
	(8, " 2021-09-28" ,"Arrábida Walking Festival",8),
	(9, " 2021-10-14" ,"EDP Maratona de Lisboa",9),
	(10, " 2021-09-08" ,"Meia Maratona de Lisboa",10),
	(11, " 2021-08-27" ,"Algarve Bike Challenge",11),
	(12, " 2021-11-27" ,"Victoria Golf Course",12),
	(13, " 2021-05-29" ,"Millennium Estoril Open",13),
	(14, " 2021-09-12" ,"50m no Tejo",14),
	(15, " 2021-07-16" ,"Hidroginástica",15),
	(16, " 2021-12-27" ,"Caminhada fim de ano",16),
	(17, " 2021-07-30" ,"Corta Mato Passeio Maritimo",17),
	(18, " 2021-08-15" ,"Padel da Marinha",18),
	(19, " 2021-09-07" ,"Esgrima de Belem",19),
	(20, " 2021-10-23" ,"Passeio Maritimo de Algés",20),
	(21, " 2021-08-03" ,"Caminhada no Guincho",21),
	(22, " 2021-11-18" ,"Danças de Salão",22),
	(23, " 2021-09-26" ,"Snooker em Carcavelos",23),
	(24, " 2021-08-10" ,"Marcha na Marginal",24),
	(25, " 2021-10-19" ,"Corrida ativa",25),
	(26, " 2021-08-13" ,"Fit Moves",26),
	(27, " 2021-04-27" ,"Caminhada na Serra de Sintra",27),
	(28, " 2021-11-15" ,"Gap class",28),
	(29, " 2021-09-05" ,"Yoga na Praia da Poça",29),
	(30, " 2021-10-23" ,"Padel em Alcantara",30);

Select*from Evento;

INSERT INTO Tipo_evento values 
	(1, "Corrida" ,"2021-06-26"),
	(2, "Caminhada" ,"2021-04-27"),
	(3, "Passeio" ,"2021-06-01"),
	(4, "Corrida" ,"2021-07-15"),
	(5, "Corrida" ,"2021-09-29"),
	(6, "Caça ao tesouro" ,"2021-12-23"),
	(7, "Bicicleta" ,"2021-08-07"),
	(8, "Caminhada" ,"2021-09-28"),
	(9, "Corrida" ,"2021-10-14"),
	(10, " Corrida" ,"2021-09-08"),
	(11, "Bicicleta" ,"2021-08-27"),
	(12, "Golf" ,"2021-11-27"),
	(13, "Ténis" ,"2021-05-29"),
	(14, "Natação" ,"2021-09-12"),
	(15, "Hidroginástica" ,"2021-07-16"),
	(16, "Caminhada" ,"2021-12-27"),
	(17, "Corrida" ,"2021-07-30"),
	(18, "padel" ,"2021-08-15"),
	(19, "Esgrima" ,"2021-09-07"),
	(20, "Passeio" ,"2021-10-23"),
	(21, "Caminhada" ,"2021-08-03"),
	(22, "Dança" ,"2021-11-18"),
	(23, "Snooker" ,"2021-09-26"),
	(24, "Marcha" ,"2021-08-10"),
	(25, "Corrida" ,"2021-10-19"),
	(26, "Ginástica" ,"2021-08-13"),
	(27, "Caminhada" ,"2021-04-27"),
	(28, "ginástica" ,"2021-11-15"),
	(29, "Yoga" ,"2021-09-05"),
	(30, "Padel" ,"2021-10-23");

select *from Tipo_evento;

INSERT INTO Utilizador values 
	(1, "Marta","Marques", "2001-05-21","19", 15, 1,1,"Feminino"),
	(2, "Andreia ","Silva", "2000-07-16","20", 67, 2,2,"Feminino"),
	(3, "Simão","Antunes", "2001-01-05","20", 51, 3,3,"Masculino"),
	(4, "Luis","Cardoso", "1961-03-25","60", 80, 4,4,"Masculino"),
	(5, "Sara","Melo","2001.08.19","60", 31, 5,4,"Feminino"),
	(6, "Carolina","Santos", "1996-05-01","25", 70, 6,3,"Feminino"),
	(7, "António","Pascoal", "1998-05-01","23", 56, 7,2,"Masculino"),
	(8, "Angêla","Alves", "1951-03-21","70", 21, 8,1,"Feminino"),
	(9, "Rosa","Maria", "1943-03-14","78", 30, 9,2,"Feminino"),
	(10, "Herculano","Ferreira", "1944-02-01","77", 40, 10,3,"Maculino"),
	(11, "Rita","Mendes", "1969-05-19","51", 100, 11,4,"Feminino"),
	(12, "António","Almeida", "1939-11-14","81",120, 12,2,"Maculino"),
	(13, "Lourenço","Cabeçadas", "1940-02-01","81", 76, 13,1,"Maculino"),
	(14, "Helena","Saraiva", "1945-01-26","76", 22, 14,4,"Feminino"),
	(15, "Mário","Ferreira", "1941-02-01","80",65, 15,3,"Maculino"),
	(16, "Gonçalo","dos Santos", "1953-04-29","68", 90, 16,1,"Maculino"),
	(17, "Amélia","Vasconselos", "1948-02-21","73",33, 17,1,"Feminino"),
	(18, "Jacinta","Meireles", "1932-08-24","89",45, 18,2,"Feminino"),
	(19, "Paulo","Amaral", "1936-05-01","85", 55, 19,3,"Maculino"),
	(20, "Gisela","Marques", "2002-04-03","19",41, 20,4,"Feminino"),
	(21, "Roberto","Oliveira", "1939-12-09","81",88, 21,1,"Maculino"),
	(22, "Rafael","Hernesto", "1946-04-29","75",99, 22,2,"Maculino"),
	(23, "Jeremias","Augusto", "1948-01-30","73",31, 23,3,"Maculino"),
	(24, "Rute","Carvalho", "1946-11-24","76",87, 24,4,"Feminino"),
	(25, "Isis","Belviso", "1940-10-21","80", 77, 25,2,"Feminino"),
	(26, "Matias","Matos", "1942-09-12","78", 11, 26,1,"Maculino"),
	(27, "Tomás","Alves", "1955-07-24","65", 140, 27,1,"Masculino"),
	(28, "Augusta","Fernandes", "1947-10-26","73", 40, 28,2,"Feminino"),
	(29, "Inês","Antunes", "1943-09-20","77",76, 29,1,"Feminino"),
	(30, "Alfredo","Gonçalves", "1954-05-05","67", 21, 30,3,"Maculino");

select*from Utilizador;


INSERT INTO Forum values 
	(1, "Dados"),
	(2, "Eventos"),
	(3, "Escalões"),
	(4, "Pontos"),
	(5, "Dados Pessoais");

select*from Forum;

INSERT INTO Tutorial values 
	(1, "2021-05-03", "Introduzir dados de exercicio"),
	(2, "2021-08-23", "Inscrever num evento"),
	(3, "2021-09-12", "Consultar o escalão"),
	(4, "2021-11-10", "Visualizar os pontos"),
	(5, "2021-07-23", "Como ganhar pontos"),
	(6, "2021-12-18", "Editar campo de dados pessoais");

select*from Tutorial;
