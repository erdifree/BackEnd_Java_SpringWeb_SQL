
insert into users(username, password, first_name, last_name, date_of_birth) values('johndoe', 'password', 'John', 'Doe', '1990-01-06');

insert into users(username, password, first_name, last_name, date_of_birth) values('johndoe', 'password', 'John', 'Doe', '1990-01-06');

insert into users(username, password, first_name, last_name, date_of_birth) values('erdifree', 'lol87lol', 'Erdison', 'Dosti', '1987-02-18');

insert into users(username, password, first_name, last_name, date_of_birth) values('ClaCel', 'password95', 'Claudio', 'Cerniglia', '1995-11-06');


insert into tasks(content, completed, deadline,user_id) values ('learn Spring',0, '2023-03-01',1),('learn Hibernate', 0, '2023-03-20',1),('learn Java', 0, '2022-03-20',3),('learn C++', 0, '2023-02-20',4);

insert into tags(name,color)values('home','dfdfdf'),('music','c2c2c2'),('film','ffffff');


insert into task_tag(task_id, tag_id) values (1,1),(1,2),(2,1),(2,3);