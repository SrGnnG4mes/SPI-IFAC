class Animal:
    def __init__(self, nome):
        self.nome = nome

    def fazer_som(self):
        return "Som genérico do animal."

class Cachorro(Animal):
    def fazer_som(self):
        return "Au Au!"

class Gato(Animal):
    def fazer_som(self):
        return "Miau!"

animal = Animal("Animal Genérico")
cachorro = Cachorro("Rex")
gato = Gato("Miau")
print(animal.fazer_som())
print(cachorro.fazer_som())
print(gato.fazer_som())