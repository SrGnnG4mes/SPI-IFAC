'''
#Exercicio1 
#1.
frase = input('Escreva uma frase: ')
print(len(frase))
print(frase.count('gost'))
palavraespecifica = input('Me informe a palavra que deseja procurar:')
print(frase.find(palavraespecifica))

#Exercicio2
frase = input('Escreva uma frase: ')
print(frase[::-1])

#Exercicio3
frase = input('Escreva uma frase: ')
palavraparasubstituir = input('Digite a palavra quer substituir:')
palavrasubstituida = input('Digite a sua palavra:')
print(frase.replace(palavraparasubstituir, palavrasubstituida))

#Exercicio4
palindromo = input('Me diga uma palavra: ')
if palindromo == palindromo:
    print('É um palindromo')
else:
    print('Não é um palindromo')

#Exercicio5
nome = input('Digite o seu nome: ')
idade = int(input('Digite a sua idade: '))
altura = float(input('Digite a sua altura: '))
frase = f'Olá {nome}, sua idade é {idade}, e sua altura é {altura:.2f}'
print(frase)
'''