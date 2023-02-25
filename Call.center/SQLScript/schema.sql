
create table phonecalls (id integer not null auto_increment, end datetime, rate float(53) not null, start datetime, primary key (id)) engine=InnoDB;
create table subscribers (id integer not null auto_increment, cityofbirth varchar(255), cretid float(53) not null, dob date, firstname varchar(255), lastname varchar(255), primary key (id)) engine=InnoDB;
