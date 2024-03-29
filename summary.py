#coding:utf-8

title = "5. fichiers statiques"

txt = """
Introduction
Petits rappels
Qu'est-ce qu'un fichier statique ?
Fichiers statiques pour une application
Fichiers statiques du projet global
Conclusion
"""

def modif(txt):
    tmp = txt.replace(" ?", "")
    tmp = tmp.replace("?", "")
    tmp = tmp.replace(":", "-")
    tmp = tmp.replace("'", " ")
    tmp = tmp.replace("+", "plus")
    tmp = tmp.replace("(", "")
    tmp = tmp.replace(")", "")
    tmp = tmp.replace("\"", "")
    return tmp

def toDash(txt):
    tmp = modif(txt)
    tmp = tmp.replace(" ", "-")
    res = tmp.split("\n")
    return list(filter(None, res))

def toH_original(txt):
    res = txt.split("\n")
    return list(filter(None, res))

def toH2(txt):
    tmp = modif(txt)
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
name = name.replace(" ", "_")
name = name.replace("_-_", "_")
print("|:heavy_check_mark:|[{}](cours/0{}/note.md)".format(title,name))

print("\n2. Table des matières pour note.md\n")

d = toDash(txt)
h2 = toH2(txt)
h_o = toH_original(txt)
s = summaryFormat(h_o, d)
h = headerFormat(h2)
res = toText(s, h)

print(res)