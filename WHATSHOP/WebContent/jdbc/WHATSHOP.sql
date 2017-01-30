drop schema if exists WHATSHOP;
create schema WHATSHOP;
use WHATSHOP;


create table USERS (
id_user int NOT NULL AUTO_INCREMENT,
username varchar(20) NOT NULL,
password varchar(20) NOT NULL,
email varchar(50) NOT NULL,
cognome varchar(20) NOT NULL,
nome varchar(20) NOT NULL,
data date NOT NULL,
cap int(5) NOT NULL,
citta varchar(20) NOT NULL,
indirizzo varchar(20) NOT NULL,
admin bool NOT NULL,
primary key (id_user)
);


create table CATEGORIE (
tipo_categoria varchar(50) NOT NULL,
id_categoria int NOT NULL AUTO_INCREMENT,
primary key (id_categoria)
);

create table NEGOZIO_ONLINE (
id_negozio int NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
email varchar(50) NOT NULL,
partita_iva varchar (16) NOT NULL,
cap int(5) NOT NULL,
citta varchar(20) NOT NULL,
indirizzo varchar(20) NOT NULL,
primary key (id_negozio, nome)
);

create table ORDINE (
id_ordine int NOT NULL AUTO_INCREMENT,
data datetime NOT NULL,
USER_id int NOT NULL,
primary key (id_ordine),
foreign key (USER_id) references USERS(id_user) on delete cascade
);

create table PRODOTTI (
id_prodotti int NOT NULL AUTO_INCREMENT, 
nome varchar(100) NOT NULL,
prezzo double NOT NULL,
disponibilita bool NOT NULL,
quantita int NOT NULL,
link varchar(100) NOT NULL,
CATEGORIA_id int NOT NULL,
NEGOZIO_id int NOT NULL,
descrizione varchar(100) NOT NULL,
primary key (id_prodotti),
foreign key (CATEGORIA_id) references CATEGORIE(id_categoria) on delete cascade,
foreign key (NEGOZIO_id) references NEGOZIO_ONLINE(id_negozio) on delete cascade
);


create table PAGAMENTO (
transazione int NOT NULL AUTO_INCREMENT,
data datetime NOT NULL,
cvv2 int default null,
scadenza_carta date,
numero_carta bigint ,
totale double NOT NULL,
ORDINE_id int NOT NULL,
USER_id int NOT NULL,
primary key (transazione),
foreign key (ORDINE_id) references ORDINE(id_ordine) on delete cascade,
foreign key (USER_id) references USERS(id_user) on delete cascade
);

create table CARRELLO (
USER_id int NOT NULL,
PRODOTTI_id int NOT NULL,
quantita int NOT NULL,
foreign key (USER_id) references USERS(id_user) on delete cascade,
foreign key (PRODOTTI_id) references PRODOTTI(id_prodotti) on delete cascade
);

create table VENDE (
PRODOTTI_id int NOT NULL,
NEGOZIO_id int NOT NULL,
foreign key (PRODOTTI_id) references PRODOTTI(id_prodotti) on delete cascade,
foreign key (NEGOZIO_id) references NEGOZIO_ONLINE(id_negozio) on delete cascade
);

create table EFFETTUA_USERS (
ORDINE_id int NOT NULL,
USER_id int NOT NULL,
PRODOTTI_id int NOT NULL,
foreign key (ORDINE_id) references ORDINE(id_ordine) on delete cascade,
foreign key (USER_id) references USERS(id_user) on delete cascade,
foreign key (PRODOTTI_id) references PRODOTTI(id_prodotti) on delete cascade
);

create table NEGOZIO_USER (
NEGOZIO_id int NOT NULL,
USER_id int NOT NULL,
foreign key (USER_id) references USERS(id_user) on delete cascade,
foreign key (NEGOZIO_id) references NEGOZIO_ONLINE(id_negozio) on delete cascade
);

