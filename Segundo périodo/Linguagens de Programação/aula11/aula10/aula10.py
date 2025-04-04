'''
class Pessoa:
    def __init__(self,nome,idade, altura):
        self.nome = nome
        self.idade = idade
        self.altura = altura

    def apresentar(self):
        print(f'Olá, meu nome é {self.nome} e tenho {self.idade} anos e minha altura {self.altura:.2f}')
pessoa1 = Pessoa('Gabriel', 18, 1.80)
pessoa1.apresentar()
'''
class Computador:
    def __init__(self, placamae, memoriaram, processador, placadevideo):
        self.placamae = placamae
        self.memoriaram = memoriaram
        self.processador = processador
        self.placadevideo = placadevideo

    def apresentar(self):
        print(f'Placa Mãe: {self.placamae}')
        print(f'Memoria RAM: {self.memoriaram} GB')
        print(f'Processador: {self.processador}')
        print(f'Placa de vídeo: {self.placadevideo} GB')
        print('-----------------------------------------------')
computador1 = Computador('B550', '32', 'Ryzen 5 5600GT', 'RTX 3060 Ti 12')
computador2 = Computador('M5A78L', '16', 'AMD FX-8300', 'GTX 1050Ti 4')
computador1.apresentar()
computador2.apresentar()

