class Livro:
    def __init__(self, titulo, autor):
        self.titulo = titulo
        self.autor = autor
        self.emprestado = False

    def emprestar(self):
        if not self.emprestado:
            self.emprestado = True
            return True
        return False

    def devolver(self):
        if self.emprestado:
            self.emprestado = False
            return True
        return False

class Usuario:
    def __init__(self, nome):
        self.nome = nome
        self.livros_emprestados = []

    def pegar_emprestado(self, livro):
        if livro.emprestar():
            self.livros_emprestados.append(livro)
            return f"{self.nome} pegou emprestado '{livro.titulo}'."
        return f"'{livro.titulo}' já está emprestado."

    def devolver_livro(self, livro):
        if livro in self.livros_emprestados:
            if livro.devolver():
                self.livros_emprestados.remove(livro)
                return f"{self.nome} devolveu '{livro.titulo}'."
        return f"{self.nome} não possui o livro '{livro.titulo}'."

class Bibliotecario:
    def __init__(self, nome):
        self.nome = nome

    def adicionar_livro(self, livro):
        return f"Livro '{livro.titulo}' adicionado à biblioteca."

    def remover_livro(self, livro):
        return f"Livro '{livro.titulo}' removido da biblioteca."

# Exemplo de uso
livro1 = Livro("1984", "George Orwell")
livro2 = Livro("O Senhor dos Anéis", "J.R.R. Tolkien")
usuario = Usuario("Alice")
bibliotecario = Bibliotecario("Carlos")

print(bibliotecario.adicionar_livro(livro1))
print(bibliotecario.adicionar_livro(livro2))

print(usuario.pegar_emprestado(livro1))
print(usuario.pegar_emprestado(livro1))

print(usuario.devolver_livro(livro1))
print(usuario.devolver_livro(livro1))