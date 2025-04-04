#R Read Leitura
#W Write Escrita
#a append adicionar
#x Criar arquivos

#arquivo = open('linguagens.txt', 'r')
#arquivo = open('linguagens.txt', 'a')
#arquivo = open('teste.txt', 'x')#Utilizado para criar arquivos
'''
Funções para leitura

#permite leitura
#print(arquivo.readable())
#para ler
#print(arquivo.read())
#para ler uma linha de cada vez
#print(arquivo.readline())
#transforma em uma lista
#print(arquivo.readlines())
#lista = arquivo.readlines()
#print(lista[1])

Funções para escrever
#Escreve
arquivo.write('SQL\n')
arquivo.write('JAVA\n')
arquivo.write('PHP\n')
'''
try:
    with open ('teste2.txt', 'x') as arquivo:
        #print(arquivo.read())
        arquivo.write('Adicionando texto\n')
except FileExistsError:
    print('Arquivo Existente')

#fecha o arquivo
arquivo.close()