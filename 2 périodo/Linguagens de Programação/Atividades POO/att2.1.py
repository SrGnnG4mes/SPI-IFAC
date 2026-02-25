class Veiculo:
    def __init__(self, marca, modelo, ano):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano

    def exibir_detalhes(self):
        return f"Marca: {self.marca}, Modelo: {self.modelo}, Ano: {self.ano}"

class Carro(Veiculo):
    def __init__(self, marca, modelo, ano, tipo_combustivel):
        super().__init__(marca, modelo, ano)
        self.tipo_combustivel = tipo_combustivel

    def exibir_detalhes(self):
        return super().exibir_detalhes() + f", Tipo de Combustível: {self.tipo_combustivel}"

class Moto(Veiculo):
    def __init__(self, marca, modelo, ano, cilindradas):
        super().__init__(marca, modelo, ano)
        self.cilindradas = cilindradas

    def exibir_detalhes(self):
        return super().exibir_detalhes() + f", Cilindradas: {self.cilindradas}"

carro = Carro("Ford", "Fiesta", 2020, "Gasolina")
moto = Moto("Honda", "CB500", 2019, 500)
print(carro.exibir_detalhes())
print(moto.exibir_detalhes())