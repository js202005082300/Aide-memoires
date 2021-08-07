# [8. Where is Bryan ?](https://www.youtube.com/watch?v=gmQp9F1oMIE)

"""
EXERCICE PYTHON #8
[Révision : chaînes de caractères, listes]

> Plusieurs petits résultats à faire afficher pour répondre aux problèmes suivants :
    - afficher tous les éléments de la liste
    - trier les prénoms par ordre alphabétique
    - combien d'éléments contient la liste ?
    - où est Bryan ?
    - supprimer tous les éléments commençant par la lettre J (vérifier en affichant la liste)
    - notre ami Mike doit devenir Michel
    - ajouter les prénoms Henri, Bryan Junior et Kumiko
    - créer une nouvelle liste (à afficher) des prénoms de plus de 5 lettres
    - retrouvez Bryan Junior et Françoise pour former un couple -> format(str) : <name> + <name> = <3

> Indications :
    - parcourir une liste en ayant l'indice de l'élémentcourant -> for i in range len(<list>)
    - cherchez au plus simple (pensez aux méthodes des chaînes et des listes)
    - vous pouvez implémenter certaines parties dans des fonctions
"""

people = [
    "Laura", "Camille", "Bryan", "Josh", "Amélia", "Kamel", "Nami", "Clint", "Mike", "Samia", "Jean-Charles", "Quentin", "Ben", "Marie", "Françoise", "Jordana", "Farid"
]

#01 - afficher tous les éléments de la liste
print(people[:])
# ou
for name in people:
    print(name)

#02 - trier les prénoms par ordre alphabétique
people.sort()
print(people[:])

#03 - combien d'éléments contient la liste ?
print("Nombre de gens :", len(people))

#04 - où est Bryan ?
for name in people:
    if name == "Bryan":
        print("Trouvé !")
# ou
for i in range(len(people)):
    if people[i] == "Bryan":
        print(f"Trouvé à l'indice {i}")
# ou
print("où est Bryan ?", people.index("Bryan"))

#05 supprimer tous les éléments commençant par la lettre J (vérifier en affichant la liste)
for name in people:
    if name[0] == "J":
        people.remove(name)
print(people[:])

#06 notre ami Mike doit devenir Michel
for i in range(len(people)):
    if people[i] == "Mike":
        people[i] = "Michel"
print(people[:])

"""
Utiliser `for i in range(len(people)):` pour travailler sur des indices et `for name in people:` sans utiliser d'indice.
"""

#07 ajouter les prénoms Henri, Bryan Junior et Kumiko
people.append("Henri")
people.append("Bryan Junior")
people.append("Kumiko")
print(people[:])
"""
people.append("Henri, Bryan Junior et Kumiko") -> va retourner une liste dans notre liste.
"""
# ou
people = people + ["Henri", "Bryan Junior", "Kumiko"]
print(people[:])
# ou
people.extend(["Henri", "Bryan Junior", "Kumiko"])
print(people[:])

#08 créer une nouvelle liste (à afficher) des prénoms de plus de 5 lettres
new_list = []

for name in people:
    if len(name) > 5:
        new_list.append(name)

print(new_list[:])

#09 retrouvez Bryan Junior et Françoise pour former un couple -> format(str) : <name> + <name> = <3
print("------------------")
people = ["Laura", "Camille", "Bryan", "Josh", "Amélia", "Kamel", "Nami", "Clint", "Mike", "Samia", "Jean-Charles", "Quentin", "Ben", "Marie", "Françoise", "Jordana", "Farid"]

people.extend(["Henri", "Bryan Junior", "Kumiko"])

def get_index_with_name(name):
    for i in range(len(people)):
        if people[i] == name:
            return i
    raise Exception("Name not found")

text = " + ".join([people[get_index_with_name("Bryan Junior")], people[get_index_with_name("Françoise")]])

print(f"{text} = <3")