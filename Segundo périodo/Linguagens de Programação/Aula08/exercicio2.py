with open ('linguagens.txt', 'r') as arquivo:
    lista = arquivo.readlines()
    numero_linhas = len(lista)
    print(f'Numero de linhas: {numero_linhas}')