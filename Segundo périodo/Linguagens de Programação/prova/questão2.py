class Veiculo():
    def __init__(self,marca, ano,modelo, preco):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano
        self.preco = preco

    def mostrardados(self):
        print(f'Marca: {self.marca}')
        print(f'Modelo: {self.modelo}')
        print(f'Ano: {self.ano}')
        print(f'Preço: {self.preco}')

class Carro(Veiculo):
    def __init__(self, marca, modelo, ano, preco, quantidade_portas):
        super().__init__(marca, modelo ,ano, preco)
        self.quantidade_portas = quantidade_portas
    def mostrardados(self):
        super().mostrardados()
        print(f'Quantidade de portas: {self.quantidade_portas}')
        print('-------------------------------------')
       

class Moto(Veiculo):
    def __init__(self, marca, modelo,ano, preco, cilindradas):
        super().__init__(marca, modelo ,ano, preco)
        self.cilindradas = cilindradas
    def mostrardados(self):
        super().mostrardados()
        print(f'Cilindradas: {self.cilindradas}')
        print('-------------------------------------')

carro1 = Carro('Volkswagen','Gol', '2024', 53000, 4)
carro1.mostrardados()
carro2 = Carro('Fiat','Uno', '2024', 63000, 2)
carro2.mostrardados()
moto1 = Moto('Honda', 'Factor', '2025', 25000, 150)
moto1.mostrardados()