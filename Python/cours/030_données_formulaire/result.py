#coding:utf-8
import cgi
import cgitb

cgitb.enable()
form = cgi.FieldStorage()
       
print("Content-type: text/html; charset=utf-8\n")

html = """<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>Ma page web</title>
</head>
<body>
"""
print(html)

try:
    if form.getvalue("username"):
        username = form.getvalue("username")
        print(f"<p>Bonjour {username} !</p>")
        print("<script>alert('ok')</script>")
    else:
        raise Exception("Pseudo non transmis")
except:
    print("<p>Pseudo non trnasmis</p>")

html = """
</body>
</html>
"""
print(html)