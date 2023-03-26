#Projeto-de-Software-de-Deposito
---

Uma API Rest desenvolvida com Spring e banco de dados MySQL, para controle de Deposito.

Tecnologias Utilizadas
---
+	Spring Framework
+	Flayway

Entidades do Sistema
---
+	Produto

Diagrama de classes
---

![Classe UML (1)](https://user-images.githubusercontent.com/68473916/227798929-4fc7a992-1a33-44ee-8d52-0221d889925c.png)


Diagrama de Metodos
---

 ![image](https://user-images.githubusercontent.com/68473916/227796778-df49fa84-d4fe-47fd-876d-e092b1c583ed.png)


API de Deposito
---

Versao: v0.0.1

## Métodos GET ##

1. Listar Produtos
2. Buscar Produtos por Id
3. Buscar Produtos por Nome
4. Listar Encomendas
5. Buscar Encomendas por Id
6. Buscar Encomendas por Nome

## Métodos POST ##

1. Cadastrar Produtos
2. Cadastrar Encomendas

## Método PUT ##

1. Atualizar Produtos por Completo ( INDIVIDUALMENTE POR ID)
2. Atualizar Quantidade de Produto ( INDIVIDUALMENTE POR ID)
3. Atualizar Nome de Produto ( INDIVIDUALMENTE POR ID)
4. Atualizar Descricao de Produto ( INDIVIDUALMENTE POR ID)
5. Atualizar Preco de Produto ( INDIVIDUALMENTE POR ID)
6. Atualizar Encomenda por Completo ( INDIVIDUALMENTE POR ID)
7. Atualizar Status para Cancelado ( INDIVIDUALMENTE POR ID)
8. Atualizar Status para Finalizado ( INDIVIDUALMENTE POR ID)
9. Atualizar Quantidade de Encomenda ( INDIVIDUALMENTE POR ID)
10. Atualizar Nome da Encomenda ( INDIVIDUALMENTE POR ID)
11. Atualizar Descricao da Encomenda ( INDIVIDUALMENTE POR ID)

## Método DELETE ##

1. Deletar Produto
2. Deletar Encomenda


## Listar Produtos ## 

Método: **GET**
http://localhost:8080/produtos

### Responses ### 

**Status: 200 - Um array de Produtos**

Exemplo de resposta do Servidor

```json
[
	{
		"codigo": 1,
		"nome": "Banana",
		"descricao": "Banana Prata",
		"preco": 2.2,
		"quantidade": 5
	},
	{
		"codigo": 2,
		"nome": "Uva",
		"descricao": "Cabernet Franc",
		"preco": 2.2,
		"quantidade": 5
	},
	{
		"codigo": 3,
		"nome": "Arroz",
		"descricao": "Integral",
		"preco": 2.2,
		"quantidade": 5
	}
]
```

## Buscar Produto por Codigo ##

Método: **GET**

http://localhost:8080/produtos/id/{Codigo}


### Parâmetros ###
Parâmetro| tipo
---------|-------
codigo   | numeral

### Responses ### 
**Status: 200 - Um objeto Produto**


Exemplo de Resposta do servidor

```json
{
		"codigo": 1,
		"nome": "Banana",
		"descricao": "Banana Prata",
		"preco": 2.2,
		"quantidade": 5
}
```

Método: **GET**
localhost:8080/produtos/nome/{nome}

### Parâmetros ###
Parâmetro| tipo
---------|-------
nome   | string

### Responses ### 

**Status: 200 - Um array de Produtos**

Exemplo de resposta do Servidor

```json
[
	{
		"codigo": 1,
		"nome": "Banana",
		"descricao": "Banana Prata",
		"preco": 2.2,
		"quantidade": 5
	}
]
```
 
Método: **DELETE**
localhost:8080/produtos/{id}

### Parâmetros ###
Parâmetro| tipo
---------|-------
id   | numeral

### Responses ### 

**Status: 204 **

Exemplo de resposta do Servidor

```json
[]
```

