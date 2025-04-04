class Produto:
    def __init__(self, nome, quantidade, preco):
        self.nome = nome
        self.quantidade = quantidade
        self.preco = preco

    def mostrardados(self):
        print(f'Nome do produto: {self.nome}')
        print(f'Quantidade em estoque: {self.quantidade}')
        print(f'Valor do produto: {self.preco}')
        print('-------------------------------------')

    def adicionar(self, valor):
        self.quantidade += valor
        print(f'Foi adicionado {valor} no estoque estoque, quantidade no estoque: {self.quantidade}')
        print('-------------------------------------')

    def retirar (self, valor):
        if valor > self.quantidade:
            print(f'Não há produtos o suficiente no estoque para retirar, quantidades de produtos agora: {self.quantidade}')
        else:
            self.quantidade -= valor
            print(f'Foi retirado {valor} do estoque {self.quantidade}')
        print('-------------------------------------')





produto1 = Produto('Arroz', 5, 10.5)
produto2 = Produto('Feijao', 3, 15.5)

produto1.mostrardados()
produto1.retirar(5)
produto1.adicionar(6)
produto1.mostrardados()
