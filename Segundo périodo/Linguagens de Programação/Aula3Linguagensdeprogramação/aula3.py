'''
var = 5
print(5 > var) #Maior que
print(5 >= var) #Maior ou igual
print(5 < 4) #Menor
print(5 <= 4) #Menor ou igual
print(5 == 4) #Igualdade

#And, or, Not
print(5 > 5 or 5 > 4) #Verdade quando um dos itens é verdade
print(5 > 5 and 5 > 4) #Verdade quando os dois itens são verdade
print(not(not(True and False and False and True))) #Operadores Lógicos

idade = int(input('Digite a sua idade:'))

if idade >= 60:
    print('Pessoa Idosa')
elif idade <= -1:
    print('Idade incorreta')    
elif idade >=18 and idade < 60:
    print('Pessoa Adulta')
else:
    print('Menor de idade')

import datetime
categoria = int(input('Digite a categoria:'))
if categoria == 1:
    print('O valor é 10,00 R$')
elif categoria == 2:
    print('O valor é 18,00 R$')
elif categoria == 3:
    print('O valor é 23,00 R$')
elif categoria == 4:
    print('O valor é 26,00 R$')
elif categoria == 5:
    print('O valor é 31,00 R$')
else:
    print('Categoria invalida!')

import datetime
dataatual = datetime.datetime.now()

if dataatual.hour > 18:
    print('Boa noite')
elif dataatual.hour >= 12 and dataatual.hour < 18:
    print('Boa tarde')
else:
    print('Bom dia')

import random

numeroaleatorio = random.randint(0,10)
chute = int(input('Digite um numero de 0 a 10:'))
if chute == numeroaleatorio:
    print('Parabéns você acertou o número!')
else:
    print('Você errou o número :´C')
    print(f'O seu número era {chute} e que foi sorteado é {numeroaleatorio}')
'''

