class Veiculo:
    def __init__(self, tipo):
        self.tipo = tipo

    def mover(self):
        print(f'O veiculo {self.tipo} ta se movendo')








class Carro(Veiculo):
    def __init__(self, tipo, modelo):
        super().__init__(tipo)
        self.modelo = modelo

    def mover (self):
        print(f'O veiculo do tipo {self.tipo} e modelo {self.modelo} ta se movendo')





veiculo1 = Veiculo('moto')
veiculo1.mover()

veiculo2 = Carro('Volkswagen', 'Gol')
veiculo2.mover()