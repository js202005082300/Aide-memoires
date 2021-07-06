#<!DOCTYPE html>
#<html lang="fr">
#<head>
#    <meta charset="UTF-8">
#    <title>Une page web avec Python et HTML !</title>
#</head>
#<body>
#    <h1>Bienvenue</h1>
#    <p>Je suis en Python, avec une page web HTML</p>
#</body>
#</html>

#coding:utf-8
import cgi

print("Content-type: text/html; charset=utf-8\n")

html = """<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <h1>Bonjour !</h1>
    <p>bla bla bla</p>
</body>
</html>
"""

print(html)