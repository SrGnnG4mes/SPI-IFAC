'''
#Aula passada
#def = função
def soma(num1, num2):
    print(num1+num2)
#função de processamento, do executa algum
soma(5,9)
soma(2,2)
soma(8,8)

def somacomreturn(num1, num2):
    return num1+num2
somacomreturn(5,2)
#a diferença é que a com return, não imprimi na tela o resultado, mas pode ser acionado um print

somaa = somacomreturn(5,2)

print(somaa)

filmes = ['Vingadores', 'The Witcher']
print(filmes[1])
nome = 'Gabriel Nogueira'
print(nome[0:17])
print(nome[::-1])
print(nome.lower())
print(nome.upper())
print(nome.capitalize())
print(nome.title())
========================================================================================
frase = 'Eu gosto de gostar, mas não gosto de gostar, mas gostar eu gosto, de gostar'
print(len(frase))
print(frase.count('gostar'))
print(frase.find('gost'))
print(frase.strip())
print(frase.replace('gostar', 'amar'))
print(frase.split())
print('-'.join(frase))

nome = 'Gabriel'
idade = 18
print('Olá'+nome)
print(f'Ola{nome}, voce tem {idade}')
'''
pi = 3.14159
print(f'O valor de pi é {pi:.2f}')