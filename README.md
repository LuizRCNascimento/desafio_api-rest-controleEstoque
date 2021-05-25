**Desafio API REST - Sistema de controle de estoque e vendas de uma loja**

-	Produto (GET, POST, PUT, DELETE)
	o Nome
	o Descrição
	o Unidade (Ex: Unidade, Kg, Dúzia e etc.)
-	Estoque (GET, PUT)
	o Produto
	o Quantidade
	o Valor de Venda
-	Fornecedor (GET, POST, PUT, DELETE)
	o CNPJ
	o Nome
	o Telefone
	o Email
	o Endereço
-	Cliente (GET, POST, PUT, DELETE)
	o CPF
	o Nome
	o Telefone
	o Email
	o Endereço
-	Compra (GET, POST)
	o Fornecedor
	o Itens da Compra [Criar entidade relacionada]
		. Produto
		. Quantidade
		. Valor
-	Venda (GET, POST, PUT)
	o Cliente
	o Itens da Venda [Criar entidade relacionada]
		. Produto
		. Quantidade
		. Valor

O sistema de delivery deverá possuir 2 perfis de acesso:
	• Loja
	• Cliente

**Descrição do Sistema:**
-	Usuário do perfil Loja:
O usuário do perfil Loja deverá cadastrar produtos e fornecedores.
A Loja deverá realizar compras para gerar estoque. Cada compra deve ser registrada e deve acrescentar estoque.
Uma compra pode ter vários produtos(itens).
A única alteração no Estoque possível é a alteração do Valor de Venda.
-	Usuário do perfil Cliente:
Este usuário deverá poder se registrar por conta própria, ou seja, sem autenticação necessária.
O cliente deve conseguir listar os produtos da loja, mas somente aqueles que tem em estoque e com Valor de Venda definido.
Quando efetuar uma venda, verificar se o produto possui estoque, se não possuir, deve enviar uma mensagem de erro para o usuário e não permitir a operação.
Uma venda deverá ter vários produtos(itens).
Ao efetuar uma venda, ela deverá ser criado com um Status: “Pendente”. O Cliente será responsável por confirmar o recebimento do produto.

**Exceeds:**
-	Validação de CPF e de CNPJ
-	Enviar um e-mail para o Cliente com o recibo da compra
-	Criar os seguintes endpoints:
		/api/produtos/asc Listar os produtos em ordem alfabética crescente por nome
		/api/produtos/desc Listar os produtos em ordem alfabética decrescente por nome
		/api/produtos/nome/{nome} Buscar produto por nome
-	Criar filtros para as entidades

**Obrigatório:**
-	Todos os campos deverão ser validados
-	O endereço deverá ter todos os campos necessários(Logradouro, Número, Complemento, CEP, Bairro, Município, Estado e etc.)
-	Bco de Dados: loja_locc
