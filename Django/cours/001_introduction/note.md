# [1. Introduction](https://www.youtube.com/watch?v=iBGhDHtysAA)

+ Application écrite en Python pour développer une application web.
+ Framework non obligatoire pour faire du web d'où voir le cours mais certains évoqués peuvent manquer.
+ Pour suivre ce Framework, être à l'aise avec Python.
+ Séance d'installation de Django qui utilise la base de données SQLite.
+ Portable, multi-plateforme graçe à ces outils Python.

---

```powershell
python -m pip install Django
```
```py
PS C:> python
Python 3.9.6 (tags/v3.9.6:db3ff76, Jun 28 2021, 15:26:21) [MSC v.1929 64 bit 
>>> import django 
>>> print(django.get_version())
3.2.6
>>> exit()
PS C:> 
```

Donner un nom qui n'est pas réseré par Python (FV) qui va générer des outils.

```py
> django-admin startproject FV
```
```txt
C.
|_ FV
    |_ FV
    |   |_ __init__.py
    |   |_ asgi.py
    |   |_ settings.py
    |   |_ urls.py
    |   |_ vsgi.py
    |
    |_ db.sqlite3
    |_ manage.py
```

Lancer le serveur.

```py
> cd FV
> python manage.py runserver
```
On test.
http://localhost:8000/