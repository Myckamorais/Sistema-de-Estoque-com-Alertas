# Sistema de Estoque com Alertas

## Enunciado

Você recebe uma lista de produtos de um estoque. Cada produto tem: `nome`, `categoria`, `quantidade` e `precoUnitario`.

Implemente um programa que:

1. Calcule o **valor total em estoque** (soma de `quantidade * precoUnitario` de todos os produtos).
2. Liste os produtos com **quantidade abaixo de 10** (considerados "estoque baixo"), ordenados pelo nome.
3. Agrupe os produtos por **categoria**, mostrando a soma da quantidade de itens em cada categoria.
4. Encontre o produto **mais caro** (maior `precoUnitario`).

## Dados de entrada

| Nome      | Categoria    | Quantidade | Preço Unitário |
|-----------|--------------|------------|----------------|
| Mouse     | Periféricos  | 15 un      | R$ 45,00       |
| Teclado   | Periféricos  | 8 un       | R$ 120,00      |
| Monitor   | Eletrônicos  | 5 un       | R$ 850,00      |
| Cabo HDMI | Acessórios   | 30 un      | R$ 25,00       |
| Webcam    | Periféricos  | 6 un       | R$ 210,00      |
| Headset   | Acessórios   | 12 un      | R$ 180,00      |
| SSD 1TB   | Eletrônicos  | 20 un      | R$ 430,00      |

## Saída esperada

```
=== VALOR TOTAL EM ESTOQUE ===
R$ 18.655,00

=== ESTOQUE BAIXO (< 10 unidades) ===
Monitor - 5 un
Teclado - 8 un
Webcam - 6 un

=== QUANTIDADE POR CATEGORIA ===
ACESSORIOS: 42
ELETRONICOS: 25
PERIFERICOS: 29

=== PRODUTO MAIS CARO ===
Monitor - 850.00
```

## Observações

- Sem restrição de implementação: pode ser resolvido com loop tradicional, Streams, Collections, etc.
- Solução implementada com Java Streams, separando as regras de negócio em uma camada de `service` (`ProductService`), enquanto `Program` (classe de entrada) apenas orquestra as chamadas e formata a saída.