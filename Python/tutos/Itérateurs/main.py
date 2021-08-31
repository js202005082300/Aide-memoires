class Inventory:
    def __init__(self, name):
        self.name = name
        self.content = []

    def __iter__(self):
        return iter(self.content)

    def __next__(self):
        return next(self.content)
    
    def add(self, item):
        self.content.append(item)

chest = Inventory("Large malle")

chest.add("Épée en bois")
chest.add("Potion de soins mineurs")
chest.add("Masque d'honneur")

for item in chest:
    print(item)