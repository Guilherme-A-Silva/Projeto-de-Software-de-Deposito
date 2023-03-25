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

 ![image](https://user-images.githubusercontent.com/68473916/227722050-d5e0b7ac-0e55-4f02-aac7-c81e94045dd6.png)


API de Deposito
---

Versao: v0.0.1

## Métodos GET ##

1. Listar Produtos
2. Buscar Produtos por ID

## Métodos POST ##

1. Cadastrar Produtos

## Método PUT ##

1. Atualizar Produtos

## Método DELETE ##

1. Deletar Produtos


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
		"quantidade": 5
	},
	{
		"codigo": 2,
		"nome": "Uva",
		"descricao": "Cabernet Franc",
		"quantidade": 5
	},
	{
		"codigo": 3,
		"nome": "Arroz",
		"descricao": "Integral",
		"quantidade": 5
	}
]
```

## Buscar Produto por Codigo ##

Método: **GET**

http://localhost:8080/produtos/{Codigo}


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
		"quantidade": 5
}
```
 
