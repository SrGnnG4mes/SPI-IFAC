class ContaBancaria:
    def __init__(self, titular, cpf, conta, agencia, saldo):
        self.titular = titular
        self.cpf = cpf
        self.conta = conta
        self.agencia = agencia
        self.saldo = 0

    def mostrarDados(self):
        print(f'Titular: {self.titular}')
        print(f'CPF: {self.cpf}')
        print(f'Conta: {self.conta}')
        print(f'Agencia: {self.agencia}')
        print(f'Saldo: {self.saldo}')
        print('-------------------------------------')

    def depositar(self, valor):
        self.saldo += valor
        print(f'Foi depositado {valor} na conta de {self.titular}')
        print('-------------------------------------')

    def sacar (self, valor):
        if valor > self.saldo:
            print(f'Saldo insuficiente para saque na conta de {self.titular}')
        else:
            self.saldo -= valor
            print(f'Foi sacado {valor} na conta de {self.titular}')
        print('-------------------------------------')

conta1 = ContaBancaria('Gabriel', '000.000.000-00',213, 45552, 0)
conta1.mostrarDados()
conta1.depositar(150)
conta1.mostrarDados()
conta1.sacar(150)
conta1.mostrarDados()


class ContaPoupanca(ContaBancaria):
    def __init__(self, titular, cpf, agencia, conta, saldo, taxa_redimento):
        super().__init__(titular, cpf, conta, agencia, saldo)
        self.taxa_redimento = taxa_redimento

    def mostrarDados(self):
        super().mostrarDados()
        print(f'Taxa de Redimento: {self.saldo*0.005}')
        print('-------------------------------------')

conta2 = ContaPoupanca('Gabriel', '000.000.000-00', 232, 54552, 0, 0)
conta2.depositar(150)
conta2.mostrarDados()
