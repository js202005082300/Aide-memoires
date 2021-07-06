# [31. Cookies](https://www.youtube.com/watch?v=NL5AwnU3akE)

+ [http-server.py](http-server.py)
+ [index.py](index.py)

Bonjour à tous, vous êtes sur la séance 31 sur la formation au langage python. 

On continue avec le web pour découvrir une nouvelle notion qui concerne les cookies alors s'il y a des gens parmi vous qui ont déjà fait du web dans un autre langage comme PHP ou d'autres également disponibles, vous connaissez certainement le concept de cookie.

Mais comme je pars du principe que vous ne partez de rien et que vous n'avez pas vu d'autres formations avant celle-ci, je je vais vous expliquer un petit peu le concept. 

Alors c'est très très simple un cookies c'est tout simplement un fichier texte tout bêtement que votre navigateur va enregistrer et qui permet de stocker une information donc un cookie va porter un nom de préférence. 

On va lui mettre une valeur et il aura une date d'expiration parce qu'on n'est pas obligé de garder un cookie indéfiniment, on peut demander à ce qu'il soit détruit à un certain moment, et d'autres informations intéressantes. Voilà à quoi ça sert. 

Alors ce n'est pas prévu à la base pour pouvoir stocker des informations capital comme par exemple le pseudonyme et le mot de passe pour se connecter un site parce que vu que c'est comme juste un fichier, vous imaginez bien qu'avec le navigateur vous allez pouvoir les modifier. 

Et si par exemple quelqu'un venait à modifier un cookie de votre site, il pourrait prendre possession du compte de quelqu'un d'autre, ou avoir des accès non autorisés. 

C'est pas fait du tout pour ça, ça fait pour stocker des informations beaucoup moins importantes et ça peut concerner notamment des informations de préférence utilisateur, admettons que vous ayez un site multilingue, Eh bien là on pourra sauvegarder en tant que cookie, la langue préférée de l'utilisateur, français l'anglais et cetera. 

Ça peut par exemple servir si vous avez un site avec plusieurs thèmes pour pouvoir sauvegarder le thème préféré, ou ça peut par exemple servir pour éviter à la personne de devoir se reconnecter c'est-à-dire de lui remettre une espèce de jetons pour dire que la personne était déjà connectée, qu'on se souvienne en fait de sa connexion pour pouvoir me reconnecter automatiquement et qu'il n'y ait pas besoin à chaque fois de se reconnecter tout le temps au site. 

Voilà des utilisations assez intéressantes au niveau des cookies évidemment je vais vous montrer comment on gère tout ça en python. 

Alors ce qu'il faut savoir au niveau de PHP et je vous en avais parlé rapidement sans trop rentrer dans les détails puisque nous allons de toute façon revenir dessus, c'est qu'on va fonctionner à partir d'en tête ce qu'on appelle les headers en anglais. 

+ index.py
```py
    #coding:utf-8
    import cgi
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Une première en tête que vous avez découvert, c'est l'en-tête content-type qui permet simplement de choisir le type de fichier que nous avons donc en l'occurrence ici text/html mais si on voulait simplement un format textuel, on mettrait simplement text/plain mais nous comme on voulait un document HTML, on met text/html. 

Et on lui a précisé un encodage, charset=utf-8, alors là syntaxe comment est-ce qu'elle va fonctionner. On a d'abord le nom de l'en-tête content-type suivi de :, un espace toujours et ensuite il faut mettre un ensemble de valeurs comme ça text/html mais alors des fois ça peut être un nom suivie d'un égal une valeur ou alors c'est directement égal à une valeur et on les sépare par un ; et un espace donc ça c'est le format typique des en-têtes pour http. 

Justement pour les cookies, nous allons utiliser une en-tête également. Il y a une en-tête précise pour les cookies. 

Alors si on veut le faire à la dur donc c'est-à-dire le faire comme on a fait ici pour HTML, on pourrait simplement taper une chaîne de caractères qui va créer un cookie.

+ index.py
```py
    #coding:utf-8
    import cgi
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Donc le format de la chaîne de caractères pour les cookies, je vais vous le montrer. C'est tout simplement Set-Cookie, : et un espace. 
```py
"""
Set-Cookie: 
"""
```
En général on donne un nom en cookie donc par exemple ça peut être … attention le nom est très très recherché … username égale une valeur je vais par exemple mettre notre prénom. 
```py
"""
Set-Cookie: username=Jason
"""
```
Peu importe mais bien on pourrait mettre aussi pref_lang pour ma langue préférée pour votre site par exemple et admettons 20 mettre fr.
```py
"""
Set-Cookie: pref_lang=fr
"""
```
Et ensuite on peut éventuellement mettre d'autres choses, on peut mettre un ;  un espace et puis ensuite d'autres informations. 

Au niveau des cookies on a plusieurs informations utiles. On a expires qui est la date d'expiration du cookie et on en reparlera parce qu'on va l'utiliser. 

Path c'est tout simplement le lien sur lequel on va pouvoir travailler avec le cookie mais nous on n'aura pas forcément besoin, je ne pense pas qu'on aura besoin. Comment c'est pour faire des commentaires sur le cookie, pareil on va passer. 

Domain c'est par rapport à votre domaine de site donc soit c'est la racine du site soit c'est un sous-domaine ou autre retourne ça peut servir à ce niveau-là mais nous on ne s'en servira pas. 

Max-age, attention ce n'est pas compatible avec tous les navigateurs et je pense que Internet Explorer ne fonctionne pas avec donc c'est pour choisir l'âge maximum c'est-à-dire la durée pour le cookie mais vous voyez de toute façon qu'on aille date d'expiration mais celui-là on n'est même pas obligé de le mettre donc finalement éviter le je vais me lever, ne l'utilisé pas. 

Secure ça peut servir dans le cas où vous voulez que votre coquille fonctionne exclusivement sur une connexion dite HTTPS donc sécurisé donc pas de HTTP. Par contre en mettant Secure, tout ce qui est connexion http ne fonctionnera pas en tout cas le cookie ne fonctionnera pas sur ce type de connexion donc pareil utilisez le quand vous êtes sûr que ça fonctionnera pour tout le monde. 

Ensuite on a version et ça c'est pour la version du cookie, on peut mettre 1.0, 2.0 et cetera.

Et on a, ça c'est un argument très important httponly c'est tout simplement pour empêcher que le cookie soit exploitable depuis javascript tout simplement. Pour éviter que par exemple avec du code javascript, on puisse récupérer un cookie la valeur modifiée ou ce genre de chose donc tout simplement pour que ça fonctionne simplement en http comme le nom l'indique.

+ index.py
```py
    #coding:utf-8
    import cgi
    
    """
    expires
    path
    comment
    domain
    secure
    version
    httponly

    Set-Cookie: pref_lang=fr
    """
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Alors comment fonctionnent ces arguments, Hé bien expires ça va être un nom égal une valeur donc ce sera une date. Le path ça va être pareil donc ce sera égal en chemin. Comment ça va être égale à un commentaire. Domain c'est pareil. Secure c'est juste un mot à mettre tout seul donc par exemple on va mettre comme ceci.
```txt
    Set-Cookie: pref-lang=fr; Secure
```
Voilà httponly c'est pareil donc en principe il faudrait un ; entre les 2.
```txt
    Set-Cookie: pref-lang=fr; Secure; httponly
```
Peu importe de toute façon Secure on ne va pas l'utiliser. On va mettre httponly uniquement. On ne va pas mettre httponly=True, on met juste httponly.
```txt
    Set-Cookie: pref-lang=fr; httponly
```
De toute façon Secure on ne va pas l'utiliser, on va juste mettre httponly et il le prendra en compte donc voilà le format de cette ligne. 

Alors comment est-ce qu'on va l'utiliser, on pourrait très bien faire ceci si on voulait vraiment faire quelque chose de vraiment très standard. 
```py
    print("Set-Cookie: pref_lang=fr; httponly")
```
Voilà on pourrait procéder de cette manière.

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("Set-Cookie: pref_lang=fr; httponly")
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Et là il enregistrerait tout simplement l'en-tête donc juste en écrivant tout ça. 

Nous on va se servir du langage python pour faire ça un peu plus proprement via un système de dictionnaire comme le propose python alors la règle à savoir au niveau de l'en-tête des cookies c'est qu'elle doit être utilisée, générée avant tout code HTML. 

Alors pour toucher qui font du PHP notamment, vous connaissez bien ça tout ce qui concerne les cookies notamment, les sessions mais on aura d'ailleurs l'occasion d'en reparler. 

Vous savez que si vous mettez, vous générez un cookie ou vous ouvrez une session après que du code HTML ait été chargé ou ou après en tout cas que l'en-tête a été chargé.

Après,
```py
    print("content-type: text/html; charset=utf-8\n")
```
Même si en PHP on ne la voit pas directement, Eh bien ça ne marchera pas tout simplement. 

Donc pour python c'est la même chose d'où le fait de mettre cette partie là avant.

Avant,
```py
    print("Set-Cookie: pref_lang=fr; httponly")
```
D'ailleurs au début on va le mettre après pour voir le résultat, je peux vous montrer d'ailleurs si je le mets après. Qu'est-ce qui va se passer à votre avis ? Eh bien on va nous afficher du texte.
```py
    print("Set-Cookie: pref_lang=fr; httponly")
    print("content-type: text/html; charset=utf-8\n")
# -->
    print("content-type: text/html; charset=utf-8\n")
    print("Set-Cookie: pref_lang=fr; httponly")
```
Eh bien ça devrait nous afficher du texte, alors on va le charger et ça devrait nous gérer comme un simple texte.

+ index.py
```py
    #coding:utf-8
    import cgi
    
    print("content-type: text/html; charset=utf-8\n")
    print("Set-Cookie: pref_lang=fr; httponly")
    
    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
        <h1>Cookies avec Python</h1>
    """
    print(html)
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
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
```txt
    http://localhost/index.py

    Set-Cookie: pref_lang=fr; httponly
    Cookies avec Python

    Bonjour ! :)
```
Et là vous voyez du coup qu'il affiche alors la première ligne permet de vérifier que c'est bien affiché Set-Cookie: pref_lang=fr; httponly

Donc voilà un petit peu le format que ça va prendre du coup ce n'est pas forcément très pratique parce que ça se sous entend que vous devez connaître par cœur les termes. En plus, il est probable que il faut une majuscule à HttpOnly sur le H et le O, enfin bref des fois il y a des choses assez strictes à respecter pour que ce soit valide donc évidemment on va pas faire comme ça pour les cookies. 

On l'a fait autant pour HTML parce qu'il n'y avait pas grand chose à mettre, c'était simple à retenir Par contre pour les cookies on va éviter de procéder comme ça. 

Donc au lieu de faire ça.
```py
    print("content-type: text/html; charset=utf-8\n")
    print("Set-Cookie: pref_lang=fr; httponly")
```
Donc au lieu de faire ça, on va passer par un module de python donc
```py
    import http.cookies
```
Module avec lequel nous allons travailler.

Pour cela ce module propose différentes classes et notamment la classe SimpleCookie qui va nous permettre de créer à ce niveau là et de les gérer donc de pouvoir générer et créer un cookie. 

On y va et on va donc l'appeler my_cookie on va rester sur un terme simple comme ça. 
```py
    import http.cookies

    my_cookie = http.cookies.SimpleCookie()
```
Donc c'est un constructeur, SimpleCookie() donc on lui met pas de valeur, on ne va pas se embêter à lui mettre des valeurs ici, on le fera après. 

Et là ça va fonctionner comme un dictionnaire, vous allez pouvoir le mettre plusieurs valeurs. 

Pour gérer le cas, le pref_lang=fr, ce qu'on avait fait tout à l'heure en écrivant en texte dur, Eh bien vous fonctionnez comme un dictionnaire … je vous renvoie sur le cours sur le dictionnaire si vous n'avez pas compris en python parce que ça va évidemment vous servir pour la suite.
```py
    import http.cookies

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
```
Donc on met ça pour gérer la préférence de langue. Si je fais ça et on verra pour le print() après, c'est comme pour tout à l'heure. 

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Alors ce qu'on avait avec httponly, lui c'est un cas un petit peu particulier comme là on passe par un dictionnaire pour le coup on est obligé de mettre une valeur donc on va juste faire ça en remettant le nom du copié que nous avons, pref_lang, et ensuite on remet des crochets pour charger un argument dans pref_lang donc pour ce cookie là en particulier donc le fameux httponly.
```py
    import http.cookies

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["httponly"]= #...
```
Et ça comme c'est du code python on lui met effectivement une valeur booléenne donc n'oubliez pas c'est un T majuscule ou un F majuscule pour False, c'est important.
```py
    import http.cookies

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["httponly"] = True
```
De toute façon si vous ne voulez pas faire httponly ne faites pas False, vous ne mettez juste pas cette ligne, c'est tout. 

Et on pourrait éventuellement lui mettre aussi une date d'expiration, le minimum c'est d'avoir évidemment un nom et une valeur, une date d'expiration et pensez à mettre httponly, mettez le tout le temps parce que c'est comme ça beaucoup plus sécurisé. 

Donc je vais mettre ici, encore une fois my_cookie, `my_cookie["pref_lang"]["expires"]`.
```py
    import http.cookies

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["expires"] = #...
    my_cookie["pref_lang"]["httponly"] = True
```
Donc vous voyez que c'est les mêmes termes que tout à l'heure et ici on va pouvoir lui mettre une date mais pour la date je vais passer par un petit ensemble de variables pour faire ça plus proprement parce qu'elles doivent avoir un format particulier c'est-à-dire que la date doit être écrite dans le format Sat, jj-mm-yy 12:45:17.
```py
    Sat, jj-mm-yy 12:45:17
```
Voilà quelque chose comme ça donc c'est un format particulier à respecter, éventuellement aussi un fuseau horaire UTC, PDT, GMT et cetera mais nous on ne le mettra pas.
```py
    Sat, jj-mm-yy 12:45:17 UTC
```
Mais en tout cas il faut ce format là précisément donc on va justement formater une date pour avoir ce format là dessus. 

Et là on va réviser un petit peu ce qu'on a vu sur les dates. 

Vous voyez tout ce qu'on a vu précédemment en ce qui concerne la vidéo sur la gestion des dates, la gestion du temps et tout ça, c'était fait justement pour vous servir après au niveau web et réseaux.
```py
    import datetime

    expiration = datetime.datetime.now()
```
Donc on va importer datetime, et ensuite on va appeler expiration, un nom de variable, qui va être égal datetime.datetime.now() donc ça si vous ne savez pas, vous pouvez soit revoir la vidéo sur les dates, et je ne sais plus si je l'avais montré exactement mais de toute façon si je ne voulais pas montrer vous pouvez voir dans la doc de python, ça permet simplement d'avoir la date du jour d'accord. 

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import datetime

    expiration = datetime.datetime.now()

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["expires"] = #...
    my_cookie["pref_lang"]["httponly"] = True
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Et on lui ajouter ce qu'on veut, admettons je veux un cookie qui se termine dans un an, 365 jours donc on va les ajouter + datetime.timedelta().
```py
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta()
```
Et timedelta() va prendre simplement une durée. En argument il peut prendre pas mal de choses, le nombre de jours, un nombre de secondes, un nombre de pas mal d'information mais nous on va lui passer days= et on va mettre 365 voilà. 
```py
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta(days=365)
```
À partir de là nous avons un format de durée en fait, d'expiration correcte mais maintenant il ne s'agit plus que de la formater donc je vais mettre directement dans expiration et comme c'est une chaîne de caractères on va la formater avec strftime() dans lequel nous allons faire le formatage que l'on veut.
```py
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta(days=365)
    expiration = expiration.strftime(#...)
```
Alors le %a qui permet d'avoir les 3 lettres en anglais pour le jour donc dans notre cas ça va être SAT pour Saterday. Ensuite ça va être %d … mais je peux peut-être me tromper, c'est toujours galère entre les langages parce que des fois il y a des différences et on peut très souvent se gourer sur les formats de date donc en général on se sert de la doc si on a des oublis. Servez-vous de la doc pour avoir la bonne valeur … donc logiquement on a %d-%b-%Y et ensuite ça va être %H:%M … Attention ici c'est M et pas I parce que pour PHP c'est H I S mais ici c'est H M S donc il faut faire attention parce que entre les langages on peut avoir des formats un peu bizarre est un peu différent.  
```py
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta(days=365)
    expiration = expiration.strftime("%a, %d-%b-%Y %H:%M:%S")
```
Logiquement ça doit passer mais de toute façon je vais vite le voir si ce n'est pas bon … et ici Regardez maintenant je n'ai plus qu'a faire ça maintenant que ma date est prête.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta(days=365)
    expiration = expiration.strftime("%a, %d-%b-%Y %H:%M:%S")         #          <--------

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["expires"] = expiration                    #          <--------
    my_cookie["pref_lang"]["httponly"] = True
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Donc plus pratique de faire ça plutôt que de mettre tout le formatage strftime() dans my_cookie[][] ça aurait alourdi l'écriture donc n'hésitez pas à utiliser des variables intermédiaires évidemment, ça ne coûtera rien du tout et ça permet de simplifier le code et de rendre les choses beaucoup plus facile à modifier. 

Le jour où je veux modifier la date d'expiration, j'ai juste à changer days=365 si je veux modifier le nombre de jours donc je n'ai pas besoin d'aller fouiller je ne sais pas où dans le code, vous pouvez le mettre vers le haut de votre code pour avoir une information de configuration on peut même éventuellement l'exporter dans une autre variable pour le nombre de jours et comme ça nous pourrons passer par exemple directement le nom d'une variable à la place d'un nombre en brut éventuellement, et ce sera comme ça encore plus optimisé. 

Et une fois qu'on a ça, on va pouvoir charger donc on va pouvoir générer le cookie donc moi plutôt que de l'enregistrer tout de suite, donc on va l'afficher pour voir s'il affiche la chaîne comme il faut. 

Donc je vais le faire directement après la génération de l'HTML c'est-à-dire après ça, `print("content-type: text/html; charset=utf-8\n")`.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta(days=365)
    expiration = expiration.strftime("%a, %d-%b-%Y %H:%M:%S")

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["expires"] = expiration
    my_cookie["pref_lang"]["httponly"] = True
    
    print("content-type: text/html; charset=utf-8\n")
    #                                                         <------------
    
    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
        <h1>Cookies avec Python</h1>
    """
    print(html)
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Donc print() mais on va pas faire comme tout à l'heure le Set-Cookie, on va simplement utiliser sur notre my_cookie, la méthode output().

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta(days=365)
    expiration = expiration.strftime("%a, %d-%b-%Y %H:%M:%S")

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["expires"] = expiration
    my_cookie["pref_lang"]["httponly"] = True
    
    print("content-type: text/html; charset=utf-8\n")
    print(my_cookie.output())
    
    html = """<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>Ma page web</title>
    </head>
    <body>
        <h1>Cookies avec Python</h1>
    """
    print(html)
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Tout simplement c'est vraiment aussi simple que ça. 

On y va et là logiquement il va m'afficher une grande ligne sauf si j'ai fait des erreurs. 
```txt
    http://localhost/index.py

    Set-Cookie: pref_lang=fr; expires=Sun, 24-Oct-2021 22:04:59; HttpOnly
    Cookies avec Python

    Bonjour ! :)
```
Alors il m'aime bien effectivement je sais Set-Cookie qui met bien que le nom égale valeur et le fameux HttpOnly et vous constatez que c'est bien ce que je vous disais, il vous met un H et un O en majuscules donc c'est bien pour vous montrer que ça n'a pas été marqué à la main ça a été généré effectivement comme il faut grâce au module de python.

Vous voyez également expires=Fri pour Friday puis 26-Apr avec les 3 premières lettres du mois, ce n'est pas en chiffres. Il vous met l'année et l'heure suivi d'un ; et cetera. 

Alors maintenant qu'on a ça l'en-tête me paraît correct, je ne vois pas d'erreur, on peut l'enregistrer. Alors le seul truc à savoir c'est très important il faut générer le cookie avant HTML. Ça je le dis tout le temps c'est super important.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import datetime

    expiration = datetime.datetime.now() + datetime.timedelta(days=365)
    expiration = expiration.strftime("%a, %d-%b-%Y %H:%M:%S")

    my_cookie = http.cookies.SimpleCookie()
    my_cookie["pref_lang"] = "fr"
    my_cookie["pref_lang"]["expires"] = expiration
    my_cookie["pref_lang"]["httponly"] = True
    print(my_cookie.output())#                                                   <------------
    
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
```txt
    http://localhost/index.py

    Set-Cookie: pref_lang=fr; expires=Sun, 24-Oct-2021 22:04:59; HttpOnly
    Cookies avec Python

    Bonjour ! :)
```
Et là au lieu d'afficher cette petite ligne, il va l'enregistrer sur le navigateur.
```txt
    Set-Cookie: pref_lang=fr; expires=Sun, 24-Oct-2021 22:04:59; HttpOnly
```
Voilà donc rien s'affiche, vous allez dans options pour Firefox et vous voyez en fonction de votre navigateur. Puis dans vie privée et sécurité, supprimer des cookies spécifiques et vous pouvez cliquer sur du coup localhost à et là regardez pref_lang est disponible ici.
```txt
    Firefox > Options > Vie privé et sécurité > Cookies et données du site
```
Pref_lang est disponible ici, son contenu c'est bien "fr", et pour le chemin, je n'ai rien mit donc il prend la racine "/".  Et la date d'expiration c'est bien ça, le vendredi 26/4/2019 à 14h57 et 36 secondes. 

Voilà pour le cookie. 

Donc c'est aussi simple que ça, vous pouvez sauvegarder des informations de cette manière avec ce petit module et vous pouvez bien évidemment travailler avec les dates pour lequel je vous ai donné une petite astuce ici now(), timedelta() et strftime() pour avoir une date bien formatée heureusement qu'on n'est pas fait d'erreur parce que ce n'est pas simple mais ça va nous nous sommes pas trompés par rapport à PHP donc ça va.

Donc ça c'était pour l'enregistrement la création d'un cookie. 

Maintenant c'est le cookie nous voulons le lire c'est-à-dire qu'on a un cookie à récupérer et on veut le lire. 

Nous allons enlever une partie du code mais alors normalement il aurait fallu faire des conditions c'est-à-dire vérifier si le cookie existe et s'il n'existe pas vous le créez, sinon vous le lisez. 

Mets-moi ici pour simplifier le code sinon on va avoir une vidéo beaucoup trop longue, Je vais considérer que c'est bon et on part du principe qu'on va devoir en créer un parce que le cookie vous avez vu qu'il était déjà enregistré et qu'on ne l'a pas enlevé.  

Hormis cette parenthèse notre code devient après l'avoir néttoyer.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import datetime
   
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
    
    print("<p>Bonjour ! :)</p>")
    
    html = """
    </body>
    </html>
    """
```
Donc on a simplifié le code et maintenant on va lire notre cookie et le récupérer. 

Alors on commence par vérifier si il existe toujours parce qu'on aura du mal à lire un cookie qui n'existe plus et du coup nous allons pouvoir le récupérer et donc on va la récupérer à ce niveau là donc ici. 

+ index.py
```py
    #coding:utf-8
    import cgi
   
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
    
    #                                    <--------------
    
    html = """
    </body>
    </html>
    """
```
Voilà à ce niveau là, là où j'avais coupé le code HTML en 2. Alors comment est-ce que ça va se récupérer ? Eh bien comme je vous avais expliqué qu'il y a plusieurs en-têtes disponibles pour http, nous avons également des variables d'environnement disponibles et il y en a une qui est important pour les cookies qui s'appelle HTTP_COOKIE tout en majuscules bien évidemment. 

Cette variable d'environnement va enregistrer tous les cookies que vous avez au niveau du chemin où vous êtes et moi comme je suis à la racine (/) c'est à dire localhost, il va en faites avoir tous les cookies disponible à localhost. 

Donc logiquement si je fait print() … pardon ça ne marchera pas. Il faut la récupérer en tant que variable d'environnement donc on va importer os. 

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
    
    HTTP_COOKIE#                                    <--------------
    
    html = """
    </body>
    </html>
    """
```
Alors vous importez os qui permet de travailler sur tout ce qui est système d'exploitation et nous allons récupérer la variable d'environnement HTTP_COOKIE et le moyen de la récupérer c'est os.environ… et ça s'écrit comme ceci.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
    
    os.environ["HTTP_COOKIE"]
    
    html = """
    </body>
    </html>
    """
```
Et comme ça va durer la variable d'environnement HTTP_COOKIE donc logiquement en faisant un print() vous pouvez l'afficher.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
    
    print(os.environ["HTTP_COOKIE"])
    
    html = """
    </body>
    </html>
    """
```
Mais le mieux c'est évidemment de faire une vérification avant, de voir si HTTP_COOKIE existe dans os.environ parce que si vous affichez quelque chose qui n'existe pas vous aurez une erreur donc c'est quand même mieux un minimum de vérifier les erreurs sinon print() de HTTP_COOKIE n'existe pas voilà.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
    
    if "HTTP_COOKIE" in os.environ:
        print(os.environ["HTTP_COOKIE"])
    else:
        print("HTTP_COOKIE n'existe pas")
    
    html = """
    </body>
    </html>
    """
```
Voilà on y va.
```txt
    http://localhost/index.py

    Cookies avec Python
    pref_lang=fr 
```
    
Et voilà ce qu'on a, on récupère ça pref_lang=fr, et là on a du bol parce qu'il n'y a qu'un seul cookie enregistré sur ce navigateur, en tout cas sur localhost. Si admettons j'avais créé plein d'autres cookies sur mon domaine localhost, vous auriez vu plein de cookies comme ça la suite qui aurait été séparé notamment par des points-virgules espace comme on avait vu pour les en-têtes. 

Donc on va partir du principe qu'il y en a plusieurs parce qu'on n'est pas sûr qu'il n'y en aura qu'un seul, il faut avoir quelque chose de générique en terme de code donc on va devoir modifier le code donc extraire les données proprement pour pouvoir les récupérer. 

Et Comment ça va fonctionner? De manière très très simple en tout cas grâce à l'utilisation de ce module http.cookies. 

Alors je ne vais pas faire if…else…, on va faire un try except d'accord on va faire les choses proprement.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
    
    except:
    
    html = """
    </body>
    </html>
    """
```
Voilà dans le try donc nous ce qu'on veut récupérer c'est la langue donc je vais l'appeler user_lang tout simplement et on va récupérer ça proprement, on fait http.cookies.SimpleCookie() et là on va lui passer des valeurs. 

Ici il prend un entrée quelque chose et pour le coup on va pouvoir lui passer notre variable d'environnement pour récupérer ça. 

Alors n'oubliez pas qu'on est ici dans un try, pas besoin de faire un if… puisque si ça marche pas, on aura une exception de levé. 

Donc on fait `http.cookies.SimpleCookie(os.environ["HTTP_COOKIE"]` et voilà.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
        user_lang = http.cookies.SimpleCookie(os.environ["HTTP_COOKIE"]
    except:
    
    html = """
    </body>
    </html>
    """
```
Donc il essaie de récupérer ça et directement on va l'afficher donc pour l'afficher il aura récupéré tous les cookies éventuels donc nous aussi on veut afficher celui qu'on attend il suffit juste de le choisir par son nom et ça va être tout simplement ma variable.
```py
    print(user_lang[""])
```
Et en paramètre il faut lui mettre le nom du cookie, et nous rappelez vous il s'appelait pref_lang et vous utilisez .value d'accord pour avoir la valeur de pref_lang.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
        user_lang = http.cookies.SimpleCookie(os.environ["HTTP_COOKIE"]
        print(user_lang["pref_lang"].value)
    except:
    
    html = """
    </body>
    </html>
    """
```
Donc qu'est-ce qu'elle va m'envoyer, elle va me renvoyer fr parce qu'on avait mis "fr" comme valeur. 

Et si ça n'a pas fonctionné, en cas d'exception, on va avoir 2 exceptions possible. 

La première c'est … alors il ne faut pas oublier le chemin complet parce qu'on a apporté comme ça … c'est 
```txt
    http.cookies.CookieError
```
CookieError c'est un type texte d'exception concernant les cookies ou éventuellement KeyError. C'est l'une ou l'autre et du coup si on a une erreur, vous faites ce que vous voulez mais moi je vais mettre non trouvé voilà.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
        print(user_lang["pref_lang"].value)
    except(http.cookies.CookieError, KeyError):
        print("Non trouvé")
    
    html = """
    </body>
    </html>
    """
    print(html)
```
Voilà, on y va et on charge, et on a bien récupérer fr.
```txt
    http://localhost/index.py

    Cookies avec Python
    fr 
```
On peut même faire ça plus proprement.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
    
    html = """
    </body>
    </html>
    """
    print(html)
```
```txt
    http://localhost/index.py

    Cookies avec Python
    La langue choisie par l'utilisateur est : fr 
```
Voilà ça fonctionne mais depuis les options on ne peut pas modifier un cookie apparemment, bref quoi qu'il arrive il y a plein d'extensions, il y a des moyens pour modifier un cookie mais vous pouvez toujours vous amuser à changer ici la valeur de votre cookie et puis ensuite on actualisant votre page et vous pouvez voir que ça actualise bien au niveau du résultat d'où le fait de ne pas enregistrer des informations très très importantes comme par exemple des mots de passe et des identifiants ou des trucs comme ça. Ce n'est pas fait pour ça. 

Voilà n'enregistre pas un compte bancaire ou un numéro de carte parce que évidemment ça pourrait poser souci s'il y a des gens qui achètent sur votre site donc il faut vraiment faire très attention à ce que vous enregistrer en tant que cookie. 

En tout cas voilà comment ça marche. 

Alors si le cookie n'a pas été trouvé, regardez on va faire le test aussi donc on va le supprimer et là on obtiendra un message comme quoi il a été non trouvez.

*Firefox > Options > Vie privée et sécurité > Cookies et données de sites > Gérer les données > Gérer les données... > Supprimer les sites sélectionnés > Enregistrer les changements.*
```txt
    http://localhost/index.py
    
    Cookies avec Python
    Non trouv�
```
Voilà on supprime tout, et là on obtiendra un message comme quoi il a été non trouvé. 

Et ça tombe bien parce que je voulais terminer en bonus pour cette vidéo pour gérer l'encodage parce que vous vous rendez compte que les accents ne sont pas affichés. 

Je ne vous l'avais pas dit avant parce qu'on n'avait pas eu l'occasion d'en parler mais les accents par défaut ne sont pas gérées c'est-à-dire que si je fais `<p>Il était une fois...</p>`.

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
   
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
```
Je charge et vous voyez que les accents ne sont pas gérés.
```txt
    http://localhost/index.py
    
    Cookies avec Python
    Non trouv�

    Il �tait une fois...
```
Pourtant si vous regardez bien vous voyez que le document est en utf 8 et de toute façon c'est ton utf 8 par défaut au niveau de python et au niveau de la page HTML c'est en utf 8 aussi.
```html
    meta charset="utf-8"
```
Par contre le problème c'est que au niveau de la fonction print() ici.
```py
    ...
    print("La langue choisie par l'utilisateur est : ", user_lang["pref_lang"].value)
```
Elle va gérer un mode de texte donc le texte ici c'est par rapport à du texte donc il ne va pas prendre en compte en tout cas pour HTML, l'encodage qu'on lui a donné ici. 

L'encodage sera bon concernant le HTML mais il ne sera pas bon concernant du texte notamment utilisé avec print(). 

Donc je vais vous donner, il y a plusieurs moyens, il existe énormément de moyens de pouvoir spécifier un encodage correct pour l'utilisation de pages web en python mais moi je vous donne le moyen que j'utilise en général et qui est le plus court à mon avis à utiliser en se servant du module de codec. 

Le module de codec, c'est lui qui va concerner en fait tout ce qui touche à l'encodage et le décodage des informations, et autant l'utiliser ça va vous faire découvrir un nouveau module que vous pourrez éventuellement aller voir en détail via la documentation python. 

Donc ce qu'on va faire, 7 importer le module de système ça marche sys et on va importer … alors je sais qu'on peut les mettre à la suite avec des virgules mais moi je les met tous à la ligne pour que vous voyez qu'ils sont comme ceci … 

+ index.py
```py
    #coding:utf-8
    import cgi
    import http.cookies
    import os
    import sys           #                   <-------------
    import codecs        #                   <-------------
   
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
```
Et à partir de là, le mieux c'est de le mettre dès le départ comme ça vous êtes sûr d'avoir un bon encodage, vous allez re modifier l'encodage pour la sortie standard donc `sys.stdout=`
```py
    import sys
    import codecs
    
    sys.stdout = codecs.getwriter()
```
codecs.getwriter() Donc en fait ici je récupère le descripteur pour l'écriture en sortie standard en l'occurrence en spécifiant donc là je vais le mettre "utf-8". 
```py
    import sys
    import codecs

    sys.stdout = codecs.getwriter("utf-8")
```
Alors c'est une syntaxe un peu particulière, ça va peut-être vous faire bizarre mais si vous comprenez pas ce n'est pas bien grave de toute façon ce sont des choses que vous ne connaissez peut-être pas et ce n'est pas forcément plus important que ça, c'est juste de la syntaxe. Le truc c'est de bien comprendre ce que l'on fait c'est-à-dire qu'on récupère le descripteur et on modifie l'encodage de la sortie standard. 

Et comme print() utilise la sortie standard, ça écrit sur stdout donc sys.stdout.

D'ailleurs vous auriez pu le modifier comme je vous l'ai déjà montré dans une autre vidéo du cours, et bien ça aurait modifier l'encodage que ce soit du HTML ou autre puisque ça va fonctionner directement avec le print() ici.
```py
    print("La langue choisie par l'utilisateur est : ", user_lang["pref_lang"].value)
```
Ça va fonctionner directement avec print() donc partout où il sera utilisé, on aura un changement de fait. Et là du coup on va faire le changement sur sys.stdout.detach() pour qu'il soit vraiment indépendant et qu'on peut gérer ça correctement au niveau de l'encodage.
```py
    import sys
    import codecs

    sys.stdout = codecs.getwriter("utf-8")(sys.stdout.detach())
```
Et là normalement si j'actualise, nous avons l'encodage utf 8 qui doit bien être géré. 

+ index.py
```py
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
```
```txt
    http://localhost/index.py

    Cookies avec Python
    Non trouvé

    Il était une fois...
```
Donc ici l'encodage utf 8 est bien géré et ce n'est pas une question de document ou autre. 

D'ailleurs je rappelle ici on petite parenthèse, n'oubliez pas d'avoir vos fichiers également enregistrer en utf 8 sinon vous n'arriverez pas à exécuter vos programmes, ou compiler même dans d'autres formations. C'est toujours un soucis comme ça c'est que votre fichier n'est pas encodé en utf 8. 

Pensez toujours que quand vous travaillez en utf 8, tout doit être en utf 8 que ce soit le langage, que ce soit la syntaxe, que ce soit les en-têtes, que ce soit le fichier en lui-même physiquement et tout le reste. 

Si c'est une base de données c'est pareil, dans l'idéal on la mettra en utf 8 aussi donc voilà tout doit être au maximum en utf 8 pour être sûr de ne pas avoir de problème parce que comme ça vous pourrez gérer tout. 

Vous pourrez écrire du texte en japonais, vous pouvez écrire dans n'importe quelle langue, ça fonctionnera tout de suite. 

Il vous suffira juste de le taper dans le print() et ça fonctionnerait sans problème donc faites attention à ça. 

Et voilà ça c'était la petite astuce de fin que vous pouvez éventuellement appliquer pour vos autres pages parce que dernièrement on ne l'avait pas vu. 

Donc avec juste sys et codecs, vous mettez juste cette petite ligne sys.stdout = codecs.getwriter("utf-8")( sys.stdout.detach()), voilà c'est vraiment très court parce qu'il existe sûrement des autres solutions pour changer ça en faisant des fonctions ou autres mais ça me semble beaucoup mieux de procéder comme ça. 

Comme ça on est sûr que print() va directement travailler en utf 8. 

De toute façon, je ne vois pas l'intérêt de travailler avec un autre encodage à l'heure d'aujourd hui donc autant travailler tout en utf 8 une bonne fois pour toute et au moins on est sûr. 

Et en plus maintenant vous avez appris à gérer des cookies, je vous ai montré comment en créé et comment les lire une fois qu'ils sont enregistrés. 

J'espère que cette vidéo vous a plu, il y avait encore beaucoup de choses à apprendre mais c'est honnêtement une vidéo qui n'est pas évidente. 

Pourtant le concept derrière les cookies est très simple, c'est juste un fichier texte qui a une syntaxe à respecter. Rien d'autre pour que ce soit enregistré. 

Après au niveau programmation, c'est vrai qu'on avait pas mal de choses je ne sais pas combien on avait de modules en plus. 

On a vu des modules standard de python qui ne sont pas forcément très très connu et qu'on n'a pas forcément utilisé avant donc ça fait pas mal de choses je pense à digérer mais au moins comme ça ça vous sera utile et vous avancerez beaucoup plus loin.

Encore une fois on ne se contente pas des bases, on ne se contente pas de faire les choses au minimum et puis ensuite vous vous débrouillez pour la suite … non non on va vraiment vachement loin, et s'il y a le moindre problème au niveau de nos pages on essaie de le résoudre pour avoir quelque chose de fonctionnel. 

L'intérêt c'est ça d'où le fait ici de vous avoir proposé l'encodage utf 8 pour être sûr. 

Donc ici pas de problème au niveau de vos accents, vous pouvez les gérer dans vos pages internet avec python il n'y aura aucun problème. 

Si vous avez des commentaires des questions, des remarques, des likes, des dislikes, vous faites ce que vous voulez. 

Encore une fois n'hésitez pas à partager la vidéo toujours toujours mais je ne le dis pas tout le temps non plus mais c'est très important si vous utilisez Twitter, Facebook même Google plus ou Snapchat, partagez les vidéos, partager le lien de la chaîne, partager le discord et si vous n'êtes pas de ceux rejoignez nous. On est quand même plus de 800 au moment où je fais cette vidéo. 

Et puis voilà il y aura probablement d'autres abonnés qui pourront vous aider,  répondre à vos questions et vous pouvez assister au live bien évidemment que je fais régulièrement sur twitch. 

D'ailleurs je compte sur vous pour être présent régulièrement sur les lives pour faire évoluer la chaîne encore et encore, ça ne pourra apporter que du bon pour la suite de formation vidéo et des autres projets que je fais également partout sur internet. 

Voilà merci à vous encore une fois, merci de votre fidélité, merci d'être présent parce que c'est grâce à vous que les vidéos continuent d'avancer et qu'il y a plein de nouvelles formations qui vont arriver parce que vous êtes là pour les voir et pour les regarder et à bientôt pour une nouvelle vidéo sur formation vidéo. 

À bientôt tout le monde,

ciao