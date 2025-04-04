class Aluno:
    def __init__(self, nome, idade, curso):
        self.nome = nome
        self.idade = idade
        self.curso = curso

    def exibir_dados(self):
        return f"Nome: {self.nome}, Idade: {self.idade}, Curso: {self.curso}"

aluno1 = Aluno("João", 20, "Engenharia")
aluno2 = Aluno("Maria", 22, "Medicina")
print(aluno1.exibir_dados())
print(aluno2.exibir_dados())