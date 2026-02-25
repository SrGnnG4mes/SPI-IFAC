class Conta_Bancaria:
    def __init__(self, titular, conta, agencia, saldo):
        self.titular = titular
        self.conta = conta
        self.agencia = agencia
        self.saldo = 0

    def mostrarDados(self):
        print(f'Titular: {self.titular}')
        print(f'Conta: {self.conta}')
        print(f'Agencia: {self.agencia}')
        print(f'Conta: {self.saldo}')
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

conta1 = Conta_Bancaria('Gabriel', 1234, 45552, 0)
conta1.mostrarDados()
conta1.depositar(150)
conta1.mostrarDados()
conta1.sacar(150)
conta1.mostrarDados()
