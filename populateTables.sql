DROP TABLE `loja_locc`.`fornecedor`, `loja_locc`.`produto`, `loja_locc`.`estoque`;

DROP TABLE `loja_locc`.`fornecedor`, `loja_locc`.`produto`, `loja_locc`.`estoque`, `loja_locc`.`compra`, `loja_locc`.`cliente`;

DROP DATABASE `loja_locc`;

INSERT INTO `loja_locc`.`user` (`id`, `password`, `username`) VALUES ('1', '$2a$10$Eq8Ao8dUsmea1rU836Dbd.GpkvGe9OdX.bhLdxFgzvzoAuOpr7YBC', 'adm');
INSERT INTO `loja_locc`.`user` (`id`, `password`, `username`) VALUES ('2', '$2a$10$cyY.msFg4rbeEJkOWGzpS.tRUStAXxUgR3SaAFDSFFmSvQi121ef.', 'user');


INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('1','FDanilo Matheus Diogo Moreira',80815390000197,'danilomatheusdiogomoreira..danilomatheusdiogomoreira@i9tec.com.br',77024384,'Quadra 1202 Sul Avenida NS 2',116,'Plano Diretor Sul','Palmas','TO',6327319528);
INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('2','FMatheus Guilherme Renato da Cruz',17644460000155,'mmatheusguilhermerenatodacruz@oliveiraesouza.adv.br',66085550,'Vila São José',599,'Pedreira','Belém','PA',9127506020);
INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('3','FMelissa Antônia Baptista',19549606000109,'melissaantoniabaptista..melissaantoniabaptista@solarisbrasil.com.br',60731020,'Rua São Felipe',641,'Canindezinho','Fortaleza','CE',8527477115);
INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('4','FAurora Emily Jennifer Aragão',87220157000100,'aauroraemilyjenniferaragao@semco.com.br',40720262,'Rua do Bispo de Periperi',487,'Periperi','Salvador','BA',7129520330);
INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('5','FLetícia Nair Silvana da Paz',00926706000189,'leticianairsilvanadapaz_@qualita.srv.br',47802401,'Rua da Libertação',915,'Novo Horizonte','Barreiras','BA',7738960781);
INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('6','FKaique Matheus Melo',97686362000110,'kaiquematheusmelo_@semco.com.br',04849514,'Viela Canaã',812,'Cantinho do Céu','São Paulo','SP',1128104534);
INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('7','FSueli Clara Fogaça',12943363000140,'sueliclarafogaca..sueliclarafogaca@girocenter.com.br',06805130,'Rua Rogério Gonçalves',111,'Jardim Tomé','Embu das Artes','SP',1129930822);
INSERT INTO loja_locc.fornecedor(id,nome,cnpj,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('8','FIgor Tomás Nicolas da Mata',63207007000107,'iigortomasnicolasdamata@jpmanager.com.br',53635700,'Travessa Jardim Tropical',699,'Rubina','Igarassu','PE',8136735808);


INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Danilo Matheus Diogo Moreira',40375436138,'danilomatheusdiogomoreira..danilomatheusdiogomoreira@i9tec.com.br',77024384,'Quadra 1202 Sul Avenida NS 2',116,'Plano Diretor Sul','Palmas','TO',6327319528);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Matheus Guilherme Renato da Cruz',87784669038,'mmatheusguilhermerenatodacruz@oliveiraesouza.adv.br',66085550,'Vila São José',599,'Pedreira','Belém','PA',9127506020);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Melissa Antônia Baptista',30085280666,'melissaantoniabaptista.melissaantoniabaptista@solarisbrasil.com.br',60731020,'Rua São Felipe',641,'Canindezinho','Fortaleza','CE',8527477115);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Aurora Emily Jennifer Aragão',85054535659,'aauroraemilyjenniferaragao@semco.com.br',40720262,'Rua do Bispo de Periperi',487,'Periperi','Salvador','BA',7129520330);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Letícia Nair Silvana da Paz',89208501191,'leticianairsilvanadapaz_@qualita.srv.br',47802401,'Rua da Libertação',915,'Novo Horizonte','Barreiras','BA',7738960781);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Kaique Matheus Melo',65549003147,'kaiquematheusmelo_@semco.com.br',04849514,'Viela Canaã',812,'Cantinho do Céu','São Paulo','SP',1128104534);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Sueli Clara Fogaça',43047676151,'sueliclarafogaca.sueliclarafogaca@girocenter.com.br',06805130,'Rua Rogério Gonçalves',111,'Jardim Tomé','Embu das Artes','SP',1129930822);
INSERT INTO loja_locc.cliente(nome,cpf,email,cep,logradouro,numero,bairro,municipio,estado,telefone) VALUES ('Igor Tomás Nicolas da Mata',32684267006,'iigortomasnicolasdamata@jpmanager.com.br',53635700,'Travessa Jardim Tropical',699,'Rubina','Igarassu','PE',8136735808);
 
INSERT INTO `loja_locc`.`produto` (`id`,`descricao`, `nome`, `unidade`) VALUES ('1','tonner Samsung', 'tonner', 'UN');
INSERT INTO `loja_locc`.`produto` (`id`,`descricao`, `nome`, `unidade`) VALUES ('2','impressora Wifi jato de tinta - Epson', 'impressora', 'UN');
INSERT INTO `loja_locc`.`produto` (`id`,`descricao`, `nome`, `unidade`) VALUES ('3','impressora multilase ', 'multilaser', 'UN');
INSERT INTO `loja_locc`.`produto` (`id`,`descricao`, `nome`, `unidade`) VALUES ('4','Multifuncional Laser colorida M5521CDN', 'Multifuncional colorida', 'UN');
INSERT INTO `loja_locc`.`produto` (`id`,`descricao`, `nome`, `unidade`) VALUES ('5','Rolo fusor Sharp Código X', 'Rolo fusor', 'UN');

INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('210', '1100', '1');
INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('220', '1200', '2');
INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('230', '1300', '3');
INSERT INTO `loja_locc`.`estoque` (`quantidade_estoque`, `valor_venda`, `id_produto`) VALUES ('240', '1400', '4');


INSERT INTO `loja_locc`.`pedido_compra` (`id`, `dao_user_id`, `fornecedor_id`) VALUES ('1', '1', '1');
INSERT INTO `loja_locc`.`pedido_compra` (`id`, `dao_user_id`, `fornecedor_id`) VALUES ('2', '1', '2');
INSERT INTO `loja_locc`.`pedido_compra` (`id`, `dao_user_id`, `fornecedor_id`) VALUES ('3', '1', '1');

INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('1', '11', '100', '1', '1');
INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('2', '12', '200', '2', '1');
INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('3', '13', '300', '3', '1');
INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('4', '14', '400', '4', '1');
INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('5', '21', '210', '1', '2');
INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('6', '23', '230', '3', '2');
INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('7', '32', '320', '2', '3');
INSERT INTO `loja_locc`.`compra` (`id_requisicao`, `quantidade_compra`, `valor_compra`, `estoque_id_produto`, `pedido_compra_id`) VALUES ('8', '33', '330', '3', '3');
