#coding:utf-8
import cgi
import http.cookies
import os
import sys
import codecs

sys.stdout = codecs.getwriter("utf-8")(sys.stdout.detach())

print("content-type: text/html; charset=utf-8\n")

html = """<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
    <h1>Cookies avec Python</h1>
"""
print(html)

try:
    user_lang = http.cookies.SimpleCookie(os.environ["HTTP_COOKIE"])
    print("La langue choisie par l'utilisateur est : ", user_lang["pref_lang"].value)
except(http.cookies.CookieError, KeyError):
    print("Non trouvé")

html = """<p>Il était une fois...</p>
</body>
</html>
"""
print(html)