DROP DATABASE IF EXISTS dadosdeteste;

CREATE DATABASE IF NOT EXISTS dadosdeteste;

CREATE TABLE dadosdeteste.projeto
(
    NAME VARCHAR(100),
    STATUS INT NOT NULL,
    ENABLED INT NOT NULL,
    VIEW_STATE INT NOT NULL,
    ACCESS_MIN INT NOT NULL,
    DESCRIPTION VARCHAR(240),
    CATEGORY_ID INT NOT NULL,
    INHERIT_GLOBAL INT NOT NULL,
    PRIMARY KEY (NAME)
);

INSERT INTO dadosdeteste.projeto(NAME, STATUS, ENABLED, VIEW_STATE, ACCESS_MIN, DESCRIPTION, CATEGORY_ID, INHERIT_GLOBAL)
VALUES('teste01',10,1,10,10,'teste automatizado',1,1),
('teste02',30,1,10,10,'teste automatizado',1,1),
('teste03',50,1,10,10,'teste automatizado',1,1),
('teste04',70,1,10,10,'teste automatizado',1,1),
('teste05',10,1,10,10,'teste automatizado',1,0),
('teste06',30,1,10,10,'teste automatizado',1,0),
('teste07',50,1,10,10,'teste automatizado',1,0),
('teste08',70,1,10,10,'teste automatizado',1,0),
('teste09',10,1,50,10,'teste automatizado',1,1),
('teste10',30,1,50,10,'teste automatizado',1,1),
('teste11',50,1,50,10,'teste automatizado',1,1),
('teste12',70,1,50,10,'teste automatizado',1,1),
('teste13',10,1,50,10,'teste automatizado',1,0),
('teste14',30,1,50,10,'teste automatizado',1,0),
('teste15',50,1,50,10,'teste automatizado',1,0),
('teste16',70,1,50,10,'teste automatizado',1,0),
('teste17',70,0,50,10,'teste automatizado',1,0);

CREATE TABLE dadosdeteste.usuario
(
    USERNAME VARCHAR(240),
    REALNAME VARCHAR(240),
    EMAIL VARCHAR(240),
    ENABLED INT NOT NULL,
    PROTECTED INT NOT NULL,
    ACCESS_LEVEL INT NOT NULL,
    COOKIE_STRING VARCHAR(100),
    TIPO_USUARIO VARCHAR(100),
    PRIMARY KEY (USERNAME)
);

INSERT INTO dadosdeteste.usuario(USERNAME,REALNAME,EMAIL,ENABLED,PROTECTED,ACCESS_LEVEL,COOKIE_STRING, TIPO_USUARIO)
VALUES('UserAdministrador','Administrador teste','UserAdministrador@teste.com',1,0,90,'UserAdministrador','administrador'),
('UserGerente','Gerente teste','UserGerente@teste.com',1,0,70,'UserGerente','gerente'),
('UserDesenvolvedor','Desenvolvedor teste','UserDesenvolvedor@teste.com',1,0,55,'UserDesenvolvedor','desenvolvedor'),
('UserAtualizador','Atualizador teste','UserAtualizador@teste.com',1,0,40,'UserAtualizador','atualizador'),
('UserRelator','Relator teste','UserRelator@teste.com',1,0,25,'UserRelator','relator'),
('UserVisualizador','Visualizador teste','UserVisualizador@teste.com',1,0,10,'UserVisualizador','visualizador');

CREATE TABLE dadosdeteste.tarefa(
    id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT NOT NULL,
    reporter_id INT NOT NULL,
    handler_id INT NOT NULL,
    duplicate_id INT NOT NULL,
    priority INT NOT NULL,
    severity INT NOT NULL,
    reproducibility	INT NOT NULL,
    status INT NOT NULL,
    resolution INT NOT NULL,
    projection INT NOT NULL,
    eta	INT NOT NULL,
    profile_id INT NOT NULL,
    view_state INT NOT NULL,
    summary	VARCHAR(240),
    sponsorship_total INT NOT NULL,
    sticky INT NOT NULL,
    category_id	INT NOT NULL,
    date_submitted INT NOT NULL,
    due_date INT NOT NULL,
    last_updated INT NOT NULL
);

INSERT INTO dadosdeteste.tarefa(project_id,reporter_id, handler_id, duplicate_id, priority, severity, reproducibility, status, resolution, projection, eta, profile_id, view_state, summary, sponsorship_total, sticky, category_id, date_submitted, due_date, last_updated)
VALUES(0,1,1,0,10,10,10,50,10,10,10,0,10,"teste",0,0,1,0,1,0);

CREATE TABLE dadosdeteste.bug_text(
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(240),
    steps_to_reproduce VARCHAR(240),
    additional_information VARCHAR(240)
);

INSERT INTO dadosdeteste.bug_text(description, steps_to_reproduce, additional_information)
VALUES("Description for sample REST issue.","steps to reproduce the issue.","More info about the issue");

CREATE TABLE dadosdeteste.bug_history(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    bug_id INT NOT NULL,
    field_name VARCHAR(240),
    old_value VARCHAR(240),
    new_value VARCHAR(240),
    type INT NOT NULL,
    date_modified INT NOT NULL
);

INSERT INTO dadosdeteste.bug_history(user_id, bug_id, field_name, old_value, new_value, type, date_modified)
VALUE(0,0,"teste","mantishub","mantisteste",25,1687233436);

CREATE TABLE dadosdeteste.tag
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(240)
);

INSERT INTO dadosdeteste.tag(user_id, name)
VALUE(0,"mantishub");