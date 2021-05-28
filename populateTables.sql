DROP TABLE `loja_locc`.`fornecedor`, `loja_locc`.`produto`, `loja_locc`.`estoque`;

DROP TABLE `loja_locc`.`fornecedor`, `loja_locc`.`produto`, `loja_locc`.`estoque`, `loja_locc`.`compra`, `loja_locc`.`cliente`;

INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Danilo Matheus Diogo Moreira',40375436138,'danilomatheusdiogomoreira..danilomatheusdiogomoreira@i9tec.com.br',77024384,'Quadra 1202 Sul Avenida NS 2',116,'Plano Diretor Sul','Palmas','TO',6327319528);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Matheus Guilherme Renato da Cruz',87784669038,'mmatheusguilhermerenatodacruz@oliveiraesouza.adv.br',66085550,'Vila São José',599,'Pedreira','Belém','PA',9127506020);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Melissa Antônia Baptista',30085280666,'melissaantoniabaptista..melissaantoniabaptista@solarisbrasil.com.br',60731020,'Rua São Felipe',641,'Canindezinho','Fortaleza','CE',8527477115);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Aurora Emily Jennifer Aragão',85054535659,'aauroraemilyjenniferaragao@semco.com.br',40720262,'Rua do Bispo de Periperi',487,'Periperi','Salvador','BA',7129520330);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Letícia Nair Silvana da Paz',89208501191,'leticianairsilvanadapaz_@qualita.srv.br',47802401,'Rua da Libertação',915,'Novo Horizonte','Barreiras','BA',7738960781);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Kaique Matheus Melo',65549003147,'kaiquematheusmelo_@semco.com.br',04849514,'Viela Canaã',812,'Cantinho do Céu','São Paulo','SP',1128104534);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Sueli Clara Fogaça',43047676151,'sueliclarafogaca..sueliclarafogaca@girocenter.com.br',06805130,'Rua Rogério Gonçalves',111,'Jardim Tomé','Embu das Artes','SP',1129930822);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Igor Tomás Nicolas da Mata',32684267006,'iigortomasnicolasdamata@jpmanager.com.br',53635700,'Travessa Jardim Tropical',699,'Rubina','Igarassu','PE',8136735808);

INSERT INTO `loja_locc`.`produto` (`id`, `descricao`, `nome`, `unidade`) VALUES ('1', 'a', 'a', 'UN');
INSERT INTO `loja_locc`.`produto` (`id`, `descricao`, `nome`, `unidade`) VALUES ('2', 'b', 'b', 'UN');
INSERT INTO `loja_locc`.`produto` (`id`, `descricao`, `nome`, `unidade`) VALUES ('3', 'c', 'c', 'UN');
INSERT INTO `loja_locc`.`produto` (`id`, `descricao`, `nome`, `unidade`) VALUES ('4', 'd', 'd', 'UN');


INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('210', '1100', '1');
INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('220', '1200', '2');
INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('230', '1300', '3');
INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('240', '1400', '4');

INSERT INTO `loja_locc`.`produto` (`descricao`, `nome`, `unidade`) VALUES ('a', 'a', 'UN');
INSERT INTO `loja_locc`.`produto` (`descricao`, `nome`, `unidade`) VALUES ('b', 'b', 'UN');
INSERT INTO `loja_locc`.`produto` (`descricao`, `nome`, `unidade`) VALUES ('c', 'c', 'UN');

