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

1. Listar Produtos localhost:8080/produtos
2. Buscar Produtos por Id localhost:8080/produtos/id/{id}
3. Buscar Produtos por Nome localhost:8080/produtos/nome/{nome}
4. Listar Encomendas localhost:8080/encomendas
5. Buscar Encomendas por Id localhost:8080/encomendas/id/{id}
6. Buscar Encomendas por Nome localhost:8080/encomendas/nome/{nome}

## Métodos POST ##

1. Cadastrar Produtos localhost:8080/produtos
2. Cadastrar Encomendas localhost:8080/encomendas

## Método PUT ##

1. Atualizar Produtos por Completo ( INDIVIDUALMENTE POR ID) localhost:8080/produtos/{id}
2. Atualizar Quantidade de Produto ( INDIVIDUALMENTE POR ID) localhost:8080/produtos/qt/{id}/{Quantidade}
3. Atualizar Nome de Produto ( INDIVIDUALMENTE POR ID) localhost:8080/produtos/no/{id}/{nome}
4. Atualizar Descricao de Produto ( INDIVIDUALMENTE POR ID) localhost:8080/produtos/des/{id}/{descricao}
5. Atualizar Preco de Produto ( INDIVIDUALMENTE POR ID) localhost:8080/produtos/pre/{id}/{preco}
6. Atualizar Encomenda por Completo ( INDIVIDUALMENTE POR ID) localhost:8080/encomendas/{id}
7. Atualizar Status para Cancelado ( INDIVIDUALMENTE POR ID) localhost:8080/encomendas/{id}/Cancelar
8. Atualizar Status para Finalizado ( INDIVIDUALMENTE POR ID) localhost:8080/encomendas/{id}/Finalizado
9. Atualizar Quantidade de Encomenda ( INDIVIDUALMENTE POR ID) localhost:8080/encomendas/qt/{id}/{Quantidade}
10. Atualizar Nome da Encomenda ( INDIVIDUALMENTE POR ID) localhost:8080/encomendas/no/{id}/{Nome}
11. Atualizar Descricao da Encomenda ( INDIVIDUALMENTE POR ID) localhost:8080/encomendas/des/{id}/{descricao}

## Método DELETE ##

1. Deletar Produto localhost:8080/produtos/{id}
2. Deletar Encomenda localhost:8080/encomendas/{id}


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
## Buscar Produto por Nome ##

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
## Listar Encomendas ##

Método: **Post**
localhost:8080/encomendas

### Responses ### 

**Status: 201 **

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
## Buscar Encomendas por Código ##

Método: **GET**

http://localhost:8080/encomendas/id/{id}


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
## Buscar Encomendas por Nome ##

Método: **GET**
localhost:8080/encomendas/nome/{nome}

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
## Cadastrar Produtos ##

Método: **POST**
localhost:8080/produtos

### Responses ### 

**Status: 200 - Um array de Produtos**

Exemplo de resposta do Servidor

```json
[

]
```

## Cadastrar Encomendas ##

Método: **POST**
localhost:8080/encomendas

### Responses ### 

**Status: 200 - Um array de Produtos**

Exemplo de resposta do Servidor

```json
[

]
```
## Atualizar Produtos por Completo ##

Método: **PUT**
localhost:8080/produtos/{id}

### Parâmetros ###
Parâmetro| tipo
---------|-------
codigo   | numeral

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
## Atualizar Quantidade de Produto ##

Método: **PUT**
localhost:8080/produtos/qt/{id}/{Quantidade}

### Parâmetros ###
Parâmetro| tipo           
---------|-------         
codigo   | numeral        
```
Parâmetro| tipo
---------|-------
codigo   | numeral


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










