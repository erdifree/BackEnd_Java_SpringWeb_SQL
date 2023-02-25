insert
into museums(name, city, country, img)
values
('Louvre','Parigi','Francia',''),
('Musei Vaticani','Citta del Vaticanto','Italia',''),
('British Museum','Londra','Inghilterra',''),
('Museo del Prado','Madrid','Spagna',''),
('Ermitage',' San Pietroburgo','Russia',''),
('Museum of London','Londra','Inghilterra','');

insert
into artists (last_name, first_name, country)
values
('Pablo','Picasso','Spagna'),
('Claude','Monet','Francia'),
('Van','Gogh','Olanda'),
('Leonardo','da Vinci','Italia'),
('Sandro','Botticelli','Italia'),
('Frida','Kahlo','Mesico'),
('Karl','Pavlovic Brjullov','Russia'),
('Salvador','Dalí','Spagna'),
('Raffaello','Sanzio','Italia'),
('Michelangelo','Merisi','Italia');

insert into artworks(title, museum_id, artist_id)
values
('Ultima Cena','2','4'),
('Gioconda','1','4'),
('Guernica','4','1'),
('Notte stellata','3','3'),
('Nascita di Venere','2','5'),
('La Gazza','5','2'),
('La cavallerizza','5','7'),
('Le due Frida','1','6'),
('Lo Stagno delle Ninfee','4','2'),
('Giuditta e Oloferne','2','10'),
('Il vecchio chitarrista cieco','3','4'),
('Salvator mundi','1','4'),
('Dama con l ermellino','1','4');

insert into characters(name, artwork_id)
value
('monalisa','2'),
('Gesu','1'),
('Dama','13'),
('Ninfee','9'),
('Frida','8'),
('Venere','5'),
('Notte','4'),
('Gazza','6'),
('Il Vecchio','11'),
('Salvator','12');