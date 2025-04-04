class Produto:
    def __init__(self, nome, preco, estoque):
        self.nome = nome
        self.preco = preco
        self.estoque = estoque

    def detalhes(self):
        return f"Produto: {self.nome}, Preço: R${self.preco:.2f}, Estoque: {self.estoque} unidades"

produto1 = Produto("Camiseta", 29.90, 100)
print(produto1.detalhes())