# coding=utf-8

# [9. Tuple or not tuple](https://www.youtube.com/watch?v=FWTezV5QjNk)

"""
EXERCICE PYTHON #9
[Révision : tuples]
> Écrire quelques fonctions pour effectuer des manipulations sur le tuplet donné plus bas :
	1. chercher le caractère voulu et retourner vrai s'il est trouvé, faux sinon
	2. renvoyer un tuple concaténant les éléments de "letters" et de l'élément 'k' (à créer dans un second tuple)
	3. remplacer le n-ième élément de "letters" par un 'X'
	
> Indications :
	- gardez en tête ce qu'est un tuple et soyez logiques dans ce que vous voulez écrire
"""


# Fonction n°1
def find_value(letters, element):
    found = False

    for l in letters:
        if l == element:
            found = True
            break

    return found

#--------------------------------------------------------
# Fonction n°2
def get_new_tuple(letters):
	# créer ici un tuple qui contient l'élement 'k'
    only_one = 'K',
    return letters + only_one

#--------------------------------------------------------
# Fonction n°3
def set_letter(letters, n):
    # letters[n - 1] = 'X' # Attention un tuple est immuable => impossible de réaliser cet exercice sauf si on crée un nouveau tuple et partir de l'ancien en remplacant l'élément.
    print(tuple_letters[0])

#----------------------------------------------------------------------------------

tuple_letters = ('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j')

# Appel à la fonction n°1
print("\n=== Fonction 1 ==========")

if find_value(tuple_letters, 'e'):
	print("L'élement 'e' existe")
else:
	print("L'élément 'e' n'a pas été trouvé")

if find_value(tuple_letters, 'p'):
	print("L'élement 'p' existe")
else:
	print("L'élément 'p' n'a pas été trouvé")

#--------------------------------------------------------
# Appel à la fonction n°2
print("\n=== Fonction 2 ==========")

new_tuple_letters = get_new_tuple(tuple_letters)
print "Nouveau tuple : ", new_tuple_letters #print(f"Nouveau tuple : {new_tuple_letters}")

#--------------------------------------------------------
# Appel à la fonction n°3
print("\n=== Fonction 3 ==========")

print "Avant : ", tuple_letters #print(f"Avant : {tuple_letters}")
set_letter(tuple_letters, 2)
print "Après : ", tuple_letters #print(f"Après : {tuple_letters}\n")