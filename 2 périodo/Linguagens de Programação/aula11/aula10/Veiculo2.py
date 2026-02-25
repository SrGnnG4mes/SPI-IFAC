class Veiculo:
    def __init__(self, ano, cor, chassi, placa, modelo):
        self.ano = ano
        self.cor = cor
        self.chassi = chassi
        self.placa = placa
        self.modelo = modelo
    
    def mostrardados(self):
        print('|------|Aqui temos informações do carro|------|')
        print(f'Ano: {self.ano}')
        print(f'Cor: {self.cor}')
        print(f'N. Chassi: {self.chassi}')
        print(f'N. Placa: {self.placa}')
        print(f'Modelo: {self.modelo}')



class Moto(Veiculo):
    def __init__(self, ano, cor, chassi, placa, modelo, cilindrada):
        super().__init__(ano, cor, chassi, placa, modelo)
        self.cilindrada = cilindrada
    
    def som(self):
        print('Som da moto')
    
    def mostrardados(self):
        super().mostrardados()
        print(f'Cilindrada: {self.cilindrada}')
 
class Carro(Veiculo):
    def __init__(self, ano, cor, chassi, placa, modelo, potencia):
        super().__init__(ano, cor, chassi, placa, modelo)
        self.potencia = potencia

    def mostrardados(self):
        super().mostrardados()
        print(f'Cavalos: {self.potencia}')





veiculo1 = Veiculo('2013/2014', 'Vermelho', 5451242, 'OVG2804', 'Gol')
veiculo1.mostrardados()
veiculo2 = Moto(2017, 'preta', 2546998, 'sd74sd', 'Factor', 160)
veiculo2.mostrardados()
veiculo2.som()