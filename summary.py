#coding:utf-8

title = "18. Modules"

txt = """
Introduction
Qu'est-ce qu'un module ?
Chargement d'un script comme un module
Création d'un module
Utilisation du module
Exécution du programme via HTTP
Renommage des exports
Création d'un objet module
Chargement dynamique d'un module
Conclusion
"""

def toDash(txt):
    tmp = txt.replace(" ?", "")
    tmp = tmp.replace("?", "")
    tmp = tmp.replace(" ", "-")
    tmp = tmp.replace("'", "-")
    res = tmp.split("\n")

    return list(filter(None, res))

def toH2(txt):
    tmp = txt.replace(" ?", "")
    tmp = tmp.replace("?", "")
    tmp = tmp.replace("'", " ")
    res = tmp.split("\n")

    return list(filter(None, res))

def summaryFormat(txtH, txtD):
    i = 0
    li= []
    while i < len(txtH):
        li.append("+ [{}](#{})".format(txtH[i], txtD[i]))
        i += 1

    return list(filter(None, li))

def headerFormat(txtH):
    i = 0
    li= []
    while i < len(txtH):
        li.append("## {}".format(txtH[i]))
        i += 1

    return list(filter(None, li))

def toText(summary, header):
    text = ""
    for el in summary:
        text += el + "\n"
    
    text += "\n>\n\n"

    for el in header:
        text += el + "\n"

    return text



## Main

print("\n1. Nouvelle ligne pour README.md\n")

name = (title.replace(". ", "_")).lower()
print("|:heavy_check_mark:|[{}](cours/0{}/note.md)".format(title,name))

print("\n2. Table des matières pour note.md\n")

d = toDash(txt)
h2 = toH2(txt)
s = summaryFormat(h2, d)
h = headerFormat(h2)
res = toText(s, h)

print(res)