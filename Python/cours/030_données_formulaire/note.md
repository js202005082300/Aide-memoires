# [30. Données formulaire](https://www.youtube.com/watch?v=FBW4HTd8ilA)

+ [http-server.py](http-server.py)
+ [index.py](index.py)
+ [result.py](result.py)

Bonjour tout le monde est bienvenu pour la séance 30 en python. 

On continue avec notre serveur http mais cette fois c'est au niveau de nos pages web nous allons transmettre des données via nos formulaires. 

Vous avez appris les formulaires en HTML. 

Avec PHP, vous avez appris à récupérer les données transmises via un formulaire pour pouvoir les exploiter et je vous rappelle comme je vous l'avais dit précédemment, python remplace le langage PHP et il fonctionne côté serveur. 

Donc on va voir comment récupérer une petite donnée en python directement dans notre petit script. 

Alors j'ai toujours le même code au niveau du serveur action sans changement et je veux pouvoir d'ailleurs le relancer tout de suite par ailleurs … finalement je le lancerais après ça ne presse pas.

Donc là je vais m'en ficher index.py 
```py
    #coding:utf-8
    import cgi

    print("Content-type: text/html; charset=utf-8\n")

    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Page web avec Python CGI</title>
    </head>
    <body>
        <h1>Page web avec Python CGI</h1>
    </body>
    </html>
    """

    print(html)
```
Donc c'est toujours le même que la dernière fois, je n'ai pas changé donc voilà toujours notre petite page HTML d'accord donc pas de nouveautés à ce niveau là. 

Et on va évidemment avoir notre fichier qui va recevoir les données et on va l'appeler result.py

On va lui passer la même chose et on fera un petit peu par la suite comment le compléter.

+ result.py
```py
    #coding:utf-8
```
Donc si on va faire notre formulaire acheter ml qui va nous permettre de rentrer comme ça des informations pour les passer. 

Donc là je ne vous apprends rien de spécial, si vous ne savez pas faire des formulaires, il faut avoir suivi la formation en HTML. 

On va le passer en mode post. 
```html
    <form method="post"
```
Alors ça je vais en parler, en python, le langage ne fait pas de différence entre get et post. 

Là où certains langages pourraient faire la différence, par exemple en PHP, on a une variable $get ou là variable $post. On peut bien distinguer les 2, en python il n'y a pas de différence par contre vous verrez que ça peut s'utiliser directement via le formulaire en post pour avoir des choses beaucoup plus pratique. 

Donc le get si vous vous souvenez c'est le fait que vous pouvez passer par l'URL. 

Alors on va faire ça, on va lui passer l'action et du coup c'est result.py et on ferme déjà le formulaire pour ne pas l'oublier. 
```html
    <form method="post" action="result.py">
    </form>
``` 
Vous voyez c'est vraiment tout pareil c'est à dire que ici au lieu de passer un fichier PHP ou HTML, on lui passe le fichier python et à partir de là on peut renseigner les informations donc je vais mettre `<input type="text" ...` suivi du nom du champ et nous on va rester sur username.
```html
    <form method="post" action="result.py">
        <input type="text" name="username">
    </form>
```
On va donc faire un truc vraiment très très très simple et ensuite on termine avec un bouton de soumission.
```html
    <form method="post" action="result.py">
        <p><input type="text" name="username">
        <input type="submit" value="Envoyer"></p>
    </form>
```
Voilà on est vraiment sur du formulaire basique, il n'y a rien de nouveau par rapport à tout ce que vous avez déjà fait en HTML.

+ index.py
```py
    #coding:utf-8
    import cgi

    print("Content-type: text/html; charset=utf-8\n")

    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Page web avec Python CGI</title>
    </head>
    <body>
        <h1>Page web avec Python CGI</h1>
        
        <form method="post" action="result.py">
            <p><input type="text" name="username">
            <input type="submit" value="Envoyer"></p>
        </form>
    </body>
    </html>
    """

    print(html)
```
À partir de là, on va lancer notre script puis on verra évidemment notre formulaire.

+ http-server.py
```py
#coding:utf-8
import http.server

port = 80
address = ("", port)

server = http.server.HTTPServer

handler = http.server.CGIHTTPRequestHandler
handler.cgi_directories = ["/"]

httpd = server(address, handler)

print(f"Serveur démarré sur le PORT {port}")
httpd.serve_forever()
```
Je vais d'abord faire exécuter le serveur, ce ne sera pas mal. 
```powershell
    >python http-server.py
    Serveur démarré sur le PORT 80
```
Voilà donc le serveur est en route et doncici on est sur index.py. J'actualise ma page et voilà ce qu'on on obtient.
```txt
    http://localhost/index.py

    Page web avec Python CGI
    +-----------+
    |           | Envoyer
    +-----------+
```
Je rappelle vite fait, je fait un petit affichage du code source.
```html
    <html><head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
        <h1>Page web avec Python CGI</h1>
        
        <form method="post" action="result.py">
            <p><input type="text" name="username">
            <input type="submit" value="Envoyer"></p>
        </form>



    </body></html>
```
C'est bien ce que nous avons dans notre fichier, le formulaire est bien présent. 

Vous voyez que ça respect vraiment bien l'indentation tout ce qui a été fait est bien respecté à ce niveau-là. 

Donc on a cet affichage là, la forcément dès que je vais rentrer quelque chose, je vais valider "Envoyer" et là on arrive sur localhost/result.py où pour le moment il ne se passe rien ou encore en tout cas on voit qu'il y a bien eu un changement de page, on est bien arrivé sur result.py. 

Par contre on n'a pas reçu l'information lorsqu'on a complété le champ mais pas de problème on va juste développer la partie résultats. 

On va utiliser cgi, c'est toujours pareil mais on va utiliser maintenant un autre module qui va nous permettre d'avoir un espèce de gestionnaire pour les cgi et notamment pour traiter les données de formulaire, et pour pouvoir travailler avec. Ça va nous servir notamment pour tout ce qui est débogage si par exemple on a des erreurs au niveau de notre code, on pourra avoir l'affichage des erreurs et on pourra ainsi comme ça déboguer notre programme. 

+ result.py
```py
    #coding:utf-8
    import cgi
```
Et donc l'autre … je vais le mettre à la ligne bien que je pourrais ajouter les import à la suite avec une virgule peu importe … j'importe cgitb.

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
```
On va activer le mode débug mais attention c'est activé en développement c'est-à-dire que la ligne que je vais mettre ici n'est pas un mettre quand votre site est en production, qu'il est en ligne. Il faudra penser à la commenter ou la retirer. Ou bien à la gérer par un système de paramétrage, de réglage au niveau de votre site pour pouvoir modifier ça rapidement. Ça vient de ce module cgitb évidemment et on fait enable() et là on va donc activer le mode débug.

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
    
    cgitb.enable()
```
À partir de là nous allons pouvoir démarrer la récupération des données de notre formulaire donc on va créer un form parce que c'est le nom qu'on donne généralement parce que c'est suffisamment parlant, et depuis le module cgi, on va créer un FieldStorage() qui va tout simplement récupérer l'ensemble des informations d'un formulaire éventuellement transmis d'accord.

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
    
    cgitb.enable()
    form = cgi.FieldStorage()
```
Donc on va récupérer les informations de notre formulaire juste à votre c'est cette ligne là. 

Et à partir de là nous allons pouvoir travailler avec nos données donc je rappelle que au niveau HTML (index.py), on a un champ qui s'appelle username. 

Donc ce champ là, première chose et ça c'est la règle partout en terme de sécurité, c'est que tout ce qui est fait par l'utilisateur, vous ne devez pas faire confiance par rapport aux saisies, par rapport aux informations transmises par un utilisateur tout simplement parce qu'il ne pourrait rien transmettre, soit transmettre des données qui serait inattendu donc il faut évidemment vérifier entièrement et filtrer les résultats pour être sûr d'avoir l'information. 

La première chose à faire qui semble logique c'est de vérifier que ce champ username qu'on attend existe donc moi je vais faire une simple condition en python donc on va utiliser form.getvalue() tout simplement comme ceci, et à l'intérieur vous allez passer le nom du champ de formulaire donc username. 

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
    
    cgitb.enable()
    form = cgi.FieldStorage()
    
    if form.getvalue("username")
```
On va lui dire simplement que si il existe, il forme un champ formulaire qui porte le nom username et donc on va faire quelque chose (:). Si il n'existe pas la manière la plus simple (else:) même si on peut faire ça plus proprement par la suite parce qu'on pourrait faire try/except pour gérer les exceptions mais en tout cas vous pouvez lever une exception standard sans mettre de valeur précise et lui mettre par exemple "pseudo non transmis".

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
    
    cgitb.enable()
    form = cgi.FieldStorage()
    
    if form.getvalue("username"):
    
    else:
        raise Exception("Pseudo non transmis")
```  
Voilà comme ça on verra tout à l'heure. Évidemment il y a des manières beaucoup plus propres de gérer le cas où on n'aurait pas transmis l'information mais nous pour être sûr qu'on a trait au minimum, le minimum à faire c'est ça. 

Et dans le cas où on l'a, Eh bien on peut du coup l'enregistrer pourquoi avoir à retaper à chaque fois from.getvalue("username") pour pouvoir récupérer le pseudo, ce qui est un peu long, je vais donc le stocker dans une variable. Ce sera beaucoup plus rapide.

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
    
    cgitb.enable()
    form = cgi.FieldStorage()
    
    if form.getvalue("username"):
        username = form.getvalue("username")
    else:
        raise Exception("Pseudo non transmis")
```   
Voilà et comme ça username contient bien la valeur récupérée. 

Après vous pouvez toujours faire des tests si vous voulez par exemple contrôler la longueur du champ où je-ne-sais-quoi. Vous pouvez toujours évidemment faire d'autres tests, vous savez maintenant faire des tests sur des chaînes de caractères ou encore des nombres en python donc là vous n'avez rien à apprendre de plus, c'est des choses que vous savez déjà. Il n'y a pas de problème. 

Maintenant que ça c'est fait on va pouvoir tout simplement refaire notre page HTML d'accord une fois que tout ça est fait. 

Là on va dire que j'ai déjà fait la partie traitement mais maintenant on va pouvoir s'occuper de l'affichage et Pour ce faire je ne vais pas me embêter je vais reprendre directement ça html="…" de index.py que je met ici. 

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
    
    cgitb.enable()
    form = cgi.FieldStorage()
    
    if form.getvalue("username"):
        username = form.getvalue("username")
    else:
        raise Exception("Pseudo non transmis")
        
    print("Content-type: text/html; charset=utf-8\n")

    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
        <h1>Page web avec Python CGI</h1>
        
        <form method="post" action="result.py">
            <p><input type="text" name="username">
            <input type="submit" value="Envoyer"></p>
        </form>
    </body>
    </html>
    """
    
    print(html)
```
Donc je précise que j'ai bien un document HTML (…content-type:… charset=utf-8…). Je lui repasse toutes les infos (html="…") que je vais nommer pages de résultats et dans `<body></body>` je pourrais passer tout un tas de choses par exemple.

Ici je vais faire un print(html) et puis un autre d'accord et entre les 2 morceaux. Vous voyez que je prends le premier morceau de ma page et je vais afficher mon résultat dans un autre print(), c'est simplement que ce sera plus pratique a ajouté. Je vais faire simplement un print() que je vais faire en fstring et ici on va mettre Bonjour {username} et là c'est une simple variable. Il n'y a absolument aucun problème.

Alors on vire ce qu'il y a dans `<body></body>`, c'est-à-dire `<h1>` et le formulaire.

+ result.py
```py
    #coding:utf-8
    import cgi
    import cgitb
    
    cgitb.enable()
    form = cgi.FieldStorage()
    
    if form.getvalue("username"):
        username = form.getvalue("username")
    else:
        raise Exception("Pseudo non transmis")
        
    print("Content-type: text/html; charset=utf-8\n")

    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
    """
    
    print(html)
    
    print(f"Bonjour {username} !")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
j'espère que à ce niveau là il y a plein de vide avant de le prendre en compte, normalement oui ça devrait passer et donc on va actualiser.
```txt
    http://localhost/index.py

    Page web avec Python CGI
    +-----------+
    |           | Envoyer
    +-----------+
    
    http://localhost/result.py

    Bonjour sam ! 
```
Voilà pour la page de résultats, on peut revenir sur la page index.py, on envoie et on a bien l'information. 

Alors là où je vous avais dit que python ne fait pas la différence entre post et get, c'est que malgré le fait que nous soyons passés par un formulaire post et que si à cet endroit je m'amuse à mettre un champ dans le url, localhost/result.py? … Ce qui correspondrait à une information passée en get, ça fonctionnera. 

Par exemple si je fait ça.
```txt
    localhost/result.py?username=Toto
    
    Bonjour Toto !
```
Donc là vous voyez le ? Username= donc ça vous savez le faire. Si vous avez déjà fait du web c'est que vous connaissez et là vous voyez qu'on obtient évidemment un changement qui est fait au niveau du nom d'utilisateur tout le fait qu'il n'y a pas de différence entre get et post à ce niveau là par rapport à ça. 

Et là il suffit de le voir au niveau du code, envoyer que là au niveau de if form.getvalue("username"), nulle part on a quelque chose qui indique que ce serait du get ou du post donc il n'y aura pas de différence à ce niveau-là. 

En tout cas ça fonctionne, dans tous les cas vous pouvez récupérer des informations. 

Alors je ne vais pas montrer tous les autres types de champs parce que vous connaissez un peu, ça va être ça pour tous que ce soit pour un champ de texte, un champ de text area, un bouton radio, le check button également, c'est la même chose. Simplement vous allez récupérer avec form.getvalue("username"), getvalue().

Et après bien évidemment par exemple pour un champ qualité valider ou non, par rapport à cette valeur getvalue() s'il existe c'est qu'il est à "on" et que si il n'existe pas ce qu'il est à "off", ce qui n'a pas été coché, par exemple ce genre de chose. 

Donc voilà je ne vais pas vous montrer tous les exemples parce que ça me semble très très simple mais en tout cas c'est comme ça que ça fonctionne donc vous voyez comme ça comment récupérer des informations depuis un formulaire. 

Alors évidemment le plus propre je vous le dis encore une fois plutôt que de lever comme ça une exception …

Raise Exception("Pseudo non transmis")
… c'est de faire tout simplement un try except pour faire simple proprement, pour voir en fait les choses. 

On pourrait peut être le modifier mais je vais d'abord vous montrer le qu on a aucune information, et là vous pouvez voir qu'une exception est bien levée.
```txt
    http://localhost/result.py
     
    Exception	Python 3.8.5: C:\Users\js201\OneDrive\Formations\ProgrammesPortable\python\python.exe
    Thu Oct 22 23:48:19 2020

    A problem occurred in a Python script. Here is the sequence of function calls leading up to the error, in the order they occurred.
     C:\Users\js201\OneDrive\Formations\FormationVideo\Ressources\Python\030_données_formulaire\result.py in <module>
          9     username = form.getvalue("username")
         10 else:
    =>   11     raise Exception("Pseudo non transmis")
         12     
         13 print("Content-type: text/html; charset=utf-8\n")
    builtin Exception = <class 'Exception'>

    Exception: Pseudo non transmis
          args = ('Pseudo non transmis',)
          with_traceback = <built-in method with_traceback of Exception object>
```
Et là vous voyez qu'une exception est bien levé, l'exception a bien été indiquée et bien géré à ce niveau-là parce que là j'ai activé, j'ai directement accéder à cette page localhost/result.py sans être passé par là précédente qui est un formulaire post et sans passer de variable en get donc là automatiquement comme il n'y a aucune information qui a été récupérée, il le voit au niveau de ma condition c'est à dire le fameux if qu'on a fait dans result.py, if form.getvalue("username")

Ça form.getvalue("username") n'existe pas du coup, username n'existe pas et donc on a bien l'exception raise Exception("pseudo non transmis") qui est levé donc pas de problème à ce niveau-là. 

Comme ça vous pouvez gérer un petit peu les choses proprement à ce niveau-là pour avoir dépêches qui traite en tout cas des informations qui existe parce que si les informations n'existent pas ce serait un petit peu compliqué. 

Alors ce qu'on peut éventuellement faire, c'est un try except ... et là on va mélangé du coup parce que on veux gérer l'affichage ou autre.

+ result.py
```py
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
            print(f"Bonjour {username} !")
        else:
            raise Exception("Pseudo non transmis")
    except:
        print("Pseudo non trnasmis")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Voilà on termine la page HTML la on refait la même chose et on actualise. 
```txt
    http://localhost/result.py
    
    Pseudo non trnasmis
```
Et voilà, vous voyez qu'on est bien dans notre code HTML directement.
```html
    <html><head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>

    Pseudo non trnasmis




    </body></html>
```
Vous pouvez bien évidemment mélanger les choses comme ça, il n'y a absolument aucun problème. 

Si on passe l'information bien sûr, sans les doubles guillemets parce que ça ne sert à rien, ?username=Jason
```txt
    localhost/result.py?username=Jason
    
    Bonjour Jason ! 
```
Bien sûr même chose, l'information a bien été passée dans le code source.
```html
    <html><head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>

    Bonjour Jason !




    </body></html>
```
Si on veut faire proprement, on mettra ça dans une balise de paragraphe bien évidemment, vous savez comment faire en HTML dans tous les cas donc il n'y a pas de souci. On peut le faire, c'est juste ça `<p>Bonjour {username} !</p>` pas besoin de chercher compliqué. C'est tout simplement juste ça `<p>pseudo non transmis</p>`. Vous pouvez même mettre du CSS, ici j'en ai pas mis mais vous pouvez très bien mettre des fichier CSS, ça ne pose aucun aucun souci évidemment.

+ result.py
```py
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
        else:
            raise Exception("Pseudo non transmis")
    except:
        print("<p>Pseudo non trnasmis</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Ca ne pose aucun soucis.
```txt
    http://localhost/result.py?username=Jason
    
    Bonjour Jason !
```
Voilà comme ça on gère ça sous forme de paragraphe.
```html
    <!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>

    <p>Bonjour Jason !</p>

    </body>
    </html>
```
Alors je n'ai pas montré pour cette vidéo parce que je voulais faire une vidéo courte pour le coup parce qu'il n'y a pas grand chose à montrer pour la transmission de formulaire mais évidemment vous pouvez partir d'un fichier HTML évidemment, il n'y a pas de problème. 

Même si vous êtes en CGI, vous pouvez très bien vous dire que dans votre dossier, vous faites votre fichier html où vous mettez votre formulaire.
```html
    <form method="post" action="result.py">
    </form>
```
Et ce fichier HTML évidemment comme vous avez ça index.py, il va pointer donc il va envoyer ses résultats via un fichier python et comme vous êtes en CGI avec l'interface CGI ça tombe bien, ce fichier là pourra traiter notre formulaire donc c'est tout à fait possible, on n'est pas obligé de faire ça depuis un autre script python. On peut très bien passer par des pages HTML.

Vous pouvez associer des pages HTML avec des scripts python, après je sais qu'il y a des gens qui préféreront n'avoir que des fichiers en Python pour pouvoir gérer ça donc libre à vous de voir comment vous arranger les choses mais vous pouvez très bien mélanger les 2 donc faire du HTML et faire du python séparément et même du CSS sans problème. 

Voilà du coup tout est dit à ce niveau-là, alors ici je peux vous montrer en petite note de fin, on va faire un print(). On va mettre un petit code en javascript.
```py
    print("<script>alert('ok')</script>")
```
dans,

+ result.py
```py
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
```
Et on va aller sur 
```txt
    localhost/result.py?username=Jason
    
    Bonjour Jason !
    
    +-------------------+
    |                   |
    |        Ok         |
    |                   |
    +-------------------+
```
Voilà donc je rappelle et ça c'est un petit peu logique comme vous êtes sur de l'exécution de script et que vous êtes de toute façon sur de l'interprétation de page, y compris de la page HTML, comme pour de l'HTML standard, le javascript fonctionne évidemment donc vous pouvez aussi utiliser du javascript ici dans python avec votre HTML.

Donc attention aussi à ce niveau-là merci de bien vérifier les choses par rapport à ce que vous faites en termes d'affichage en sécurisant par exemple vos affichages donc pensez bien sûr à tout ça c'est-à-dire de bien vérifier les choses à chaque fois. 

Par exemple ici ce qu'on pourrait faire …
```py
    try:
        if form.getvalue("username"):
            username = form.getvalue("username")
            print(f"<p>Bonjour {username} !</p>")
            print("<script>alert('ok')</script>")
```
… Par exemple on vérifierait dans le username si on n'a pas mis de script après de toute façon je pense que le navigateur doit bloquer, je pense que si on essaie de faire ça :
```txt
    localhost/result.py?username=<script>alert("ok")</script>
```
le navigateur devrait bloquer l'exécution de scripts parce que maintenant ils sont suffisamment intelligents pour le faire, ce qui est bien parce qu'aujourd'hui ça bloqué l'exécution de l'utilisation de file x2s mais du coup on ne sait pas si c'est notre code qui a un problème ou pas parce que le navigateur corrigé le bug à notre place. 
```txt
    localhost/result.py?username=<script>alert("ok")</script>
    
    Bonjour
    
    +-------------------+
    |                   |
    |        Ok         |
    |                   |
    +-------------------+
```
Mais là on voit qu'il le prend quand même en compte, il le prend en compte.
```txt
    +-------------------+
    |                   |
    |        Ok         |
    |   #   Empêcher cette page d'ouvrir des
    |       dialogues supplémentaires
    |                   |
    +-------------------+
```
je vais envoyer une ligne de script dans le code pour être sûr (result.py) et on va refaire l'exécution, et on va mettre Bonjour dans le script en get pour s'assurer qu'il le prend en compte.

+ result.py
```py
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
        else:
            raise Exception("Pseudo non transmis")
    except:
        print("<p>Pseudo non trnasmis</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
On ré-actualise avec le script.
```txt
    localhost/result.py?username=<script>alert("Bonjour")</script>

    +-------------------+
    |                   |
    |      Bonjour      |
    |                   |
    +-------------------+
```
OK voilà vous voyez que ce n'est pas sécurisé donc attention, c'est pareil en python vous savez comment faire. Vous pouvez faire des tests sur une chaîne pour vérifier simplement qu'il n'y a pas de balise où transformer tout ce qui est balise en non balise par exemple s'il y a du script ou autre donc c'est tout à fait possible de sécuriser ça. 

Il n'y a pas évidemment de fonction PHP parce que vous savez que en PHP, on a htmlspecialchars, htmlentetities pour ceux qui font du PHP. 

Vous avez évidemment des fonctions ou en tout cas des moyens équivalent en python pour sécuriser ou pour en tout cas filtrer les données que vous avez. 

Ça existe donc renseignez vous un petit peu au niveau des méthodes que vous avez sur la chaîne de caractères qu'on a pu revoir d'ailleurs pour la plupart ou pour d'autres et vous trouverez pas mal de choses intéressantes à ce niveau là. 

Donc attention et ça je le rappelle parce que c'est super important, toute donnée qui est saisie où transmise par un utilisateur doit être absolument vérifié tout le temps, tout le temps parce que vous ne savez pas ce que la personne va envoyer comme information et vous ne savez même pas d'ailleurs si elle veut envoyer l'information. 

C'est ça aussi déjà la base est-ce que cette personne va envoyer l'information et une fois qu'elle aura envoyé est-ce qu'elle envoie l'information que l'on attend donc ça c'est super important. 

Vérifiez toujours en termes de sécurité, le résultat ou en tout cas le contenu des données récupéré par un utilisateur. 

Je vais vous laisser avec cette vidéo qui n'était pas très longue comme vous le voyez parce qu'il n'y avait pas grand-chose à vous expliquer parce que c'est quand même relativement simple. 

Tout ce qu'il y a vraiment à retenir c'est l'utilisation cgitb pour gérer le mode débug cgitb.enable().

On produit ici form = sgi.fieldStorage() qui permet de récupérer toutes les données transmises via un formulaire HTML. 

Et ensuite tout simplement à coup de condition via ce fonctionnement là form.getvalue() qui permet de récupérer chacun des champs, on fait tous les tests que l'on veut, et après évidemment une fois qu'on a les données récupérées, on fait ce que l'on veut. Ça devient des données comme dans des variables python standard username = form.getvalue("username") comme si on ne faisait pas de web et à ce moment-là on en fait ce qu'on veut. 

On en fait ce qu'on veut, on les affiche, on les traite, on les met dans des listes bref on les compare, on fait absolument tout ce que l'on veut avec ça. 

Voilà je vous laisse avec tout ça, je vous dis à bientôt pour une prochaine vidéo en python. 

En attendant entraînez vous bien, si vous avez des commentaires ou quoi que ce soit n'hésitez pas à le faire sous la vidéo youtube. 

À bientôt tout le monde