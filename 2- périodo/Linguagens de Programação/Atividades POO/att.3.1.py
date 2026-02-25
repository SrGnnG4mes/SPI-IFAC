class Instrumento:
    def __init__(self, nome):
        self.nome = nome

    def tocar(self):
        return "Tocando um som genérico."

class Violao(Instrumento):
    def tocar(self):
        return "Tocando acordes no violão."

class Flauta(Instrumento):
    def tocar(self):
        return "Tocando uma melodia na flauta."

instrumento = Instrumento("Instrumento Genérico")
violao = Violao("Violão")
flauta = Flauta("Flauta")
print(instrumento.tocar())
print(violao.tocar())
print(flauta.tocar())