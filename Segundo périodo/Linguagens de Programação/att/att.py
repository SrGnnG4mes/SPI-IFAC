import matplotlib.pyplot as plt

# Dados de exemplo
meses = ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez']
vendas_produto_a = [150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650, 700]
vendas_produto_b = [100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650]

# Configurando o estilo do gráfico
plt.style.use('ggplot')

# Criando o gráfico
plt.figure(figsize=(10, 6))
plt.plot(meses, vendas_produto_a, marker='o', linestyle='-', color='b', label='Produto A')
plt.plot(meses, vendas_produto_b, marker='^', linestyle='--', color='r', label='Produto B')

# Adicionando título e rótulos
plt.title('Vendas dos Produtos A e B ao Longo do Ano')
plt.xlabel('Meses')
plt.ylabel('Vendas')

# Adicionando a legenda
plt.legend()

# Ativando o grid
plt.grid(True)

# Exibindo o gráfico
plt.show()