# [2. Structure d'un projet](https://www.youtube.com/watch?v=rMHSCeA8Bfw)

On a procédé à l'installation.
```powershell
python -m pip install Django
```
```py
django-admin startproject FV
cd FV
python manage.py runserver
```
http://localhost:8000/

On va gérer ce script manage.py
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
+ données regroupées dans un fichier sqlite.
+ déploiement du serveur web dit classique grâçe à vsgi.py, et le serveur web dit asynchrone asgi.py mais on va se soucier de lancer le projet sur le serveur natif.
+ configurations avec settings.py
+ urls.py sont les liens de notre application

## Configuration

+ en production, on désactivera tout les modes de débogage mais on reste sur du développement.
+ settings.py est un module et les répertoires sont des packages.

```py
LANGUAGE_CODE = 'fr-FR'
```