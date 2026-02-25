class Funcionario:
    def __init__(self, nome, salario):
        self.nome = nome
        self.salario = salario

    def calcular_salario_anual(self):
        return self.salario * 12

class Gerente(Funcionario):
    def __init__(self, nome, salario, bonus):
        super().__init__(nome, salario)
        self.bonus = bonus

    def calcular_salario_anual(self):
        return (self.salario * 12) + self.bonus

class Vendedor(Funcionario):
    def __init__(self, nome, salario, comissao):
        super().__init__(nome, salario)
        self.comissao = comissao

    def calcular_salario_anual(self):
        return (self.salario * 12) + self.comissao

gerente = Gerente("Carlos", 5000, 1000)
vendedor = Vendedor("Ana", 3000, 500)
print(f"Salário Anual do Gerente: R${gerente.calcular_salario_anual():.2f}")
print(f"Salário Anual do Vendedor: R${vendedor.calcular_salario_anual():.2f}")