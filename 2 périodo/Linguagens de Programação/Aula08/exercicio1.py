#Gravar frases em um arquivo
#Solicitar 3 frases

frases = []
for i in range (3):
    frase = input(f'Digite a frase {i+1}:')
    frases.append(frase)

#Gravar as frases em um arquivo
with open('frases.txt', 'w') as arquivo:
    for frase in frases:
        arquivo.write(f'{frase}\n')

with open('frases.txt', 'r') as arquivos:
    print(arquivo.read())