INSERT INTO customer
  (name, cpf, birthdate, email)
VALUES
  ('Helena Laís Sales', '55275901399', '1956-08-26', 'hhelenalaissales@expressotaubate.com.br'),
  ('Eliane Alícia Bruna Rodrigues', '08638820305', '1973-07-16', 'elianealiciabrunarodrigues-98@fertility.com.br'),
  ('Laura Rosângela Cristiane da Rocha', '20279809387', '1948-02-05', 'laurarosangelacristianedarocha..laurarosangelacristianedarocha@bb.com.br'),
  ('Hugo Manuel Cauê Sales', '51564822362', '1958-02-08', 'hugomanuelcauesales..hugomanuelcauesales@sinsesp.com.br'),
  ('Guilherme Theo Fernandes', '94526106380', '1941-05-14', 'guilhermetheofernandes..guilhermetheofernandes@msltecnologia.com.br'),
  ('Levi Isaac da Costa', '83194205390', '1971-05-21', 'leviisaacdacosta_leviisaacdacosta@recnev.com.br'),
  ('Rita Marina Rayssa Nunes', '78323193304', '1972-08-11', 'ritamarinarayssanunes_ritamarinarayssanunes@supercleanlav.com.br'),
  ('Henrique Hugo Benedito Moreira', '74661609301', '1962-09-17', 'henriquehugobeneditomoreira-79@grupogil.com.br'),
  ('Oliver Breno Marcos da Mota', '49196367334', '1979-03-16', 'oliverbrenomarcosdamota_@original-veiculos.com.br'),
  ('Erick Thomas Gael Carvalho', '01913650332', '1989-12-16', 'erickthomasgaelcarvalho-80@alkbrasil.com.br'),
  ('Vitória Luzia Agatha Almeida', '40590641301', '1994-08-27', 'vvitorialuziaagathaalmeida@stetnet.com.br'),
  ('Flávia Daiane de Paula', '57775985364', '1988-04-14', 'flaviadaianedepaula_flaviadaianedepaula@advocaciand.adv.br'),
  ('Marcela Clarice Campos', '75956715316', '1956-10-19', 'marcelaclaricecampos_marcelaclaricecampos@jcoronel.com.br'),
  ('Marlene Silvana Renata Duarte', '08190880306', '1973-05-23', 'marlenesilvanarenataduarte..marlenesilvanarenataduarte@audiogeni.com.br'),
  ('Heloisa Maya Cavalcanti', '59968921386', '1948-02-12', 'heloisamayacavalcanti_heloisamayacavalcanti@laramjeirabaumann.com.br'),
  ('Pedro Henrique Fábio Gustavo da Mata', '44555933303', '1973-07-16', 'pedrohenriquefabiogustavodamata..pedrohenriquefabiogustavodamata@jp.ind.br'),
  ('Luciana Malu Silveira', '33473560391', '1978-05-22', 'lucianamalusilveira_lucianamalusilveira@revati.com.br'),
  ('Francisco Oliver Caleb Brito', '99142899320', '1950-03-21', 'franciscoolivercalebbrito_@gerdau.com.br'),
  ('Elisa Bruna Sueli Cavalcanti', '52286494339', '1963-11-27', 'elisabrunasuelicavalcanti__elisabrunasuelicavalcanti@onvale.com');

INSERT INTO phones
  (customer_id, number)
VALUES
  (1, '98982639282'),
  (2, '98981036521'),
  (3, '98982218883'),
  (4, '98991326794'),
  (5, '98987011105'), 
  (6, '98981447699'),
  (7, '98996397947'),
  (8, '98987126109'),
  (9, '98985601747'),
  (10, '98987590510'),
  (11, '98995282099'),
  (12, '98993352074'),
  (13, '98988204074'),
  (14, '98987089534'),
  (15, '98981004885'),
  (16, '98997245580'),
  (17, '98998954794'),
  (18, '98981332412'),
  (19, '98989015573');

INSERT INTO address
  (customer_id, cep, street, number, neighborhood, city, uf)
VALUES
  (1, '65070360', 'Rua do Motor', '778', 'Vila Vicente Fialho', 'São Luís', 'MA'),
  (2, '65058231', 'Rua 09', '962', 'Cidade Operária', 'São Luís', 'MA'),
  (3, '65058353', 'Rua São Pedro', '535', 'Vila Riod', 'São Luís', 'MA'),
  (4, '65020394', '4ª Travessa Jardim Esperança', '788', 'Camboa', 'São Luís', 'MA'),
  (5, '65066645', 'Rua Alcântara', '823', 'Vivendas do Turu', 'São Luís', 'MA'),
  (6, '65095905', 'Avenida Engenheiro Emiliano Macieira km 0', '224', 'Tirirical', 'São Luís', 'MA'),
  (7, '65054100', 'Rua Seis', '970', 'Forquilha', 'São Luís', 'MA'),
  (8, '65082081', 'Rua São João', '773', 'Vila Isabelo da Guarda)', 'São Luís', 'MA'),
  (9, '65058620', 'Rua São Tomé', '792', 'Santa Clara', 'São Luís', 'MA'),
  (10, '65062590', 'Travessa São José', '383', 'Vila Padre Xavier', 'São Luís', 'MA'),
  (11, '65055550', 'Travessa São Cristóvão', '911', 'Tirirical', 'São Luís', 'MA'),
  (12, '65064400', 'Travessa Nossa Senhora da Luz', '558', 'Aurora', 'São Luís', 'MA'),
  (13, '65059640', 'Travessa Nossa Senhora da Luz', '862', 'João de Deus', 'São Luís', 'MA'),
  (14, '65043790', 'Travessa Guaramirim', '275', 'Coroadinho', 'São Luís', 'MA'),
  (15, '65095223', 'Rua do Campo', '370', 'Tibiri', 'São Luís', 'MA'),
  (16, '65058011', 'Rua 15', '722', 'Cidade Operária', 'São Luís', 'MA'),
  (17, '65058099', 'Rua Lindalva Serejo', '372', 'Cidade Operária', 'São Luís', 'MA'),
  (18, '65137971', 'Avenida Três 19 Quadra 90', '769', 'Conjunto Maiobão', 'Paço do Lumiar', 'MA'),
  (19, '65137970', 'Avenida 4 28 Quadra 76', '191', 'Conjunto Maiobão', 'Paço do Lumiar', 'MA');

INSERT INTO book
  (isbn, title, publishing_company, author, release_year, price, stock, created_at)
VALUES
  ('857522462X', 'Python Fluente: Programação Clara, Concisa e Eficaz', 'Novatec', 'Luciano Ramalho', 2015, 3, 3, current_date), -- 1
  ('9781491956779', 'Introducing Elixir', 'OReilly', 'Simon St.Laurent', 2017, 2, 4, current_date),
  ('9781449392772', 'Programming PHP', 'OReilly', 'Rasmus Lerdorf', 2013, 2, 2, current_date),
  ('9781935182979', 'RabbitMQ in Action', 'MANNING', 'ALVARO VIDELA', 2012, 3, 2, current_date), -- 4
  ('020189551X', 'Object-oriented analysis and design with applications', 'Addison-Wesley', 'Grady Booch', 2007, 5, 2, current_date),
  ('0132350882', 'Clean Code', 'Pearson', 'Robert C. Martin', 2008, 4, 5, current_date),
  ('0321125215', 'Domain-driven design: tackling complexity in the heart of software', 'Addison-Wesley', 'Eric Evans', 2004, 4, 2, current_date), -- 7
  ('9781617291999', 'Java 8 in Action', 'Manning Publications', 'Alan Mycroft', 2015, 3, 2, current_date),
  ('0735619670', 'Code Complete - 2nd Ed', 'Microsoft Press', 'Steven C. McConnell', 2004, 5, 1, current_date), -- 9
  ('9781449373191', 'PostgreSQL: Up and Running, Second Edition', 'OReilly', 'Regina O. Obe', 2015, 1, 2, current_date);

INSERT INTO item
  (code, book_id)
VALUES
  ('B001', 1),
  ('B002', 1),
  ('B003', 1),
  ('B004', 2),
  ('B005', 2),
  ('B006', 2),
  ('B007', 2),
  ('B008', 4),
  ('B009', 4),
  ('B010', 3),
  ('B011', 3),
  ('B012', 5),
  ('B013', 5),
  ('B014', 6),
  ('B015', 6),
  ('B016', 6),
  ('B017', 7),
  ('B018', 6),
  ('B019', 7),
  ('B020', 6),
  ('B021', 9),
  ('B022', 8),
  ('B023', 10),
  ('B024', 8),
  ('B025', 10);

INSERT INTO tag
  (name, tag)
VALUES
  ('Banco de Dados', 'bd'), -- 1
  ('Algoritmos', 'algoritmos'), -- 2
  ('Desenvolvimento Web', 'web'), -- 3
  ('Desenvolvimento Mobile', 'mobile'), -- 4
  ('Inteligência Artificial', 'ia'), -- 5
  ('Python', 'python'), -- 6
  ('Programação Orientada a Objetos', 'poo'), --7
  ('Programação Funcional', 'fp'), -- 8
  ('PHP', 'php'), -- 9
  ('Filas e Menssageria', 'queue'), --10
  ('Java', 'java'); -- 11

INSERT INTO book_tag
  (book_id, tag_id)
VALUES
  (1, 6),
  (2, 8),
  (3, 9),
  (3, 3),
  (3, 7),
  (4, 10),
  (5, 7),
  (6, 7),
  (7, 7),
  (8, 11),
  (8, 7),
  (9, 7),
  (10, 1);
