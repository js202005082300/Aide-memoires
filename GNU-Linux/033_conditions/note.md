# [33. Conditions](https://www.youtube.com/watch?v=bP7lBGERtfA)

Bonjour c'est la 33e vidéo et on se retrouve pour la suite un petit peu de cette programmation de scripts bash pour voir ensemble les structures conditionnelle.

Dernièrement on a vu ensemble les variables, je vous ai montré comment faire quelques opérations, éventuelles avec ces variables et on va avoir un petit peu comment effectuer des tests.

Le principe d'un test c'est de vérifier une expression et si cette expression est validée, de pouvoir exécuter un certain nombre d'instructions de commandes et cetera seulement si ce test tout simplement est valide donc ça permet d'exécuter des commandes dans un cas précis et pas par défaut durant toute l'exécution de notre script.

On va regarder ça, je vais vous expliquer comment ça marche on verra quelques syntaxes, principalement 3 même si on a deux qui sont finalement similaire et comme ça ça fait un peu tout notre séance avec beaucoup de choses bien sûr que vous allez voir notamment au niveau des syntaxes.

Alors si des gens parmi vous programmes déjà ça va être assez déroutant parce que vous n'aurez pas forcément toujours les mêmes notation qu'avec d'autres langages de programmation donc n'hésitez pas durant cette vidéo à  prendre des notes, à mettre sur pause plusieurs fois parce qu'il y aura beaucoup beaucoup d'éléments de syntaxe à connaître et à retenir par la suite même s'il n'y a pas besoin encore une fois de retenir par coeur, j'insiste bien là dessus.

Ok on passe sur l'autre scène.

```bash
#!/bin/bash

```

## exit status

Alors au niveau de ça, première chose en tout cas qui me semble important à savoir dans ce cas précis, c'est comment fonctionne finalement ce principe de test d'accord puisque ce n'est pas forcément ce qu'on va voir partout dans d'autres langages et c'est important de le savoir parce que nous allons réaborder certains détails plus loin dans d'autres vidéos dédiées au niveau de ce cours.

Pour cela je vais vous montrez directement dans le terminal, on va même pas passer par un script pour le moment comment fonctionne un peu ce principe.

Voyons une expression très simple quand j'utilise les doubles parenthèses qui nous permettent d'utiliser des opérateurs arithmétique qu'on connaît bien partout pour pouvoir vérifier ça.

```bash
sam@sam:~/Documents$ ((1 < 2))
sam@sam:~/Documents$ 
```

Par exemple le 1 strictement inférieure à 2 d'accord je fait ceci dans mon terminal, je fais la touche entrer ok on ne voit pas trop ce qui s'est passé et là nous avons une variable spécial d'accord une variable particulière ici Bash dans laquelle a été affecté une valeur qui est en fait un code de retour ce qu'on appelle le **exit status** d'accord un code d'état finalement qui va permettre d'indiquer finalement le déroulement d'accord le retour de  cette expression là qui a été évaluée alors cette variable c'est dollars comme d'habitude avec le point d'interrogation `$?`. Là vous allez récupérer cette valeur.

```bash
sam@sam:~/Documents$ ((1 < 2))
sam@sam:~/Documents$ echo $?
0
```

Si je fais entrer on obtient la valeur de zéro.

Ce qu'il faut comprendre, 0 ça va simplement dire que cette expression est vrai d'accord 1 est effectivement strictement inférieure à 2.

Si on évalue notre expression, je peux faire par exemple l'inverse comme ceci et en refaisant un petit echo et là on tombe sur 1 d'accord.

```bash
sam@sam:~/Documents$ ((1 > 2))
sam@sam:~/Documents$ echo $?
1
```

Voilà comment ça va fonctionner ? dans le cas où l'expression est vérifiée, est validée d'accord finalement ça s'est passé tel qu'on l'attendait 1 strictement inférieure à 2 par exemple ça retournera le code 0.

Dans le cas contraire ça retournera le code 1 voir un autre code, une autre valeur éventuellement dans des cas particuliers ou même si vous avez vu dans certains langages on peut retrouver ce genre de choses.

Alors là ça peut être un peu particulier parce que vous voyez finalement bas quand l'expression était vrai ça retourne 0 et quand elle était fausse ça retourne 1.

Pourquoi j'insiste parce que si vous venez d'autres langages de programmation vous savez très généralement qu'on va plutôt retrouver l'inverse c'est à dire que la valeur correspondant à **true** qui veut dire vrai en informatique correspond au caractère 1, au nombre ou chiffre même pour être exact 1 et dans le cas de **false** on va plutôt entendre parler du chiffre zéro d'accord voilà là on parle non pas simplement de valeur booléenne 1 ou 0 d'accord vrai ou faux, oui ou non, on et off mais de retour d'état par rapport à l'usage d'une commande et plus tard comme on le verra dans ce cours, de retour de fonction.

En gros comprenez et si vous avez peut-être vu dans d'autres langages programmation je pense genre au c, au c++ quand on fait la fameuse instruction `return 0`, `return -2` ou ce genre de choses, vous avez remarqué qu'on return 0, on fait un retour de 0 quand tout a bien fonctionné, qu'il n'y a pas eu d'erreur que voilà il y a eu un succès on parle de `success`, du script, du programme, etc et dans le cas contraire on va retourner 1 ou autre chose ça peut être -1, 4, -2, -10, peu importe qui voudra dire simplement qu'il y a une erreur en particulier et que ça n'a pas fonctionné.

C'est donc exactement le même principe ici 0 en cas de succès, 1 dans ce cas particulier en cas de non-succès d'accord quand ça n'a pas été vérifié voir autre chose s'il y a des cas particuliers.

Voilà ce qu'il faut retenir.

Pourquoi je vous ai parlé de ça tout simplement parce que nous allons retrouver ce principe au niveau de nos tests, c'est ceci qui va être vérifié finalement, c'est ce code le fameux dollar point d'interrogation `$?` qui va être vérifié.

`$?` c'est ça qui va nous permettre de rentrer dans une condition ou non, c'est ce cas particuliers.

## if test

Exemple tout bête, on va faire alors `nb1=24` on va faire une `nb2=28` et on va faire `nb3=24` qui sera finalement la même valeur en dur que nb1 d'accord.

```bash
#!/bin/bash

nb1=24
nb2=28
nb3=24
```

Voyons comment faire notre premier test, première syntaxe très simple un **if** qui est tout simplement le terme anglais pour dire **si** le mot clé `test` et ensuite l'expression à vérifier.

```bash
#!/bin/bash

nb1=24
nb2=28
nb3=24

if test $nb1 < $nb2 ; then

fi
```

Alors dans beaucoup de langage programmation quand on veut faire un test avec encore une fois ce fameux opérateur arithmétique on ferait tout simplement `if test $nb1 < $nb2` alors là on va respecter la syntaxe du Bash, ce genre de choses d'accord on complète un expression avec des points virgules vous pouvez le coller directement ou mettre une espace c'est vous qui voyez moi je mets toujours un petit espace et puis là je mets le mot-clé `then` parce qu'il est obligatoire et ensuite nous avons notre expression.

Contrairement à d'autres langages également il faut pouvoir terminer cette structure conditionnelle et comme elle commence par le mot clé `if`, on va prendre l'inverse des caractères et ça donne `fi` et vous terminer comme ça la structure voilà ça permet de délimiter celle ci parce que vous voyez qu'il n'y a pas d'accolades dans ce langage, il n'y pas de crochets ou il n'y a pas de deux points ici `if test $nb1 < $nb2 ; then :` comme on le ferait par exemple dans un langage comme python.

Ok donc il faut bien pouvoir indiquer la fin de notre structure et tout ce qui va être à l'intérieur donc vous pouvez faire une tabulation pour que ce soit mieux présenté sera réalisée, sera exécuté si et seulement si cette vérification est vrai donc en gros si son code de retour, son code d'état est égal à 0 d'accord retourne 0.

Voilà comment il faut le voir c'est pour ça que je voulais en parler parce que je trouve c'est important de dire un peu ce qui se cache derrière ces tests là et que  c'est pas simplement finalement une simple opération arithmétique qu'on pourrait des fois retrouver dans d'autres langages de programmation avec de simples opérateurs de comparaison.

```bash
#!/bin/bash

nb1=24
nb2=28
nb3=24

if test $nb1 < $nb2 ; then
    echo 'nb1 < nb2'
fi
```

Ok donc là je mets tout simplement un texte en dur ça veut dire que `$nb1` est plus petit que `$nb2` donc on fait `echo` si effectivement `$nb1 < $nb2` est validé.

Alors là si j'essaie de l'exécuter, on va faire déjà `chmod u+x` et je remplace l'extension pour être plus rigoureux je met .bash au lieu de .sh parce qu'on parle pas du même shell ici.

```bash
sam@sam:~/Documents$ chmod u+x main.bash
```

`sh` est un shell beaucoup plus limité, je vais vous en parler un peu et ensuite on
fait `./main.bash`.

```bash
sam@sam:~/Documents$ ./main.bash
./main.bash: ligne 7: 28: Aucun fichier ou dossier de ce type
```
Et voilà ça vous met Aucun fichier ou dossier de ce type, ou alors un message en anglais si vous avez une distribution qui n'est pas localisée en français tout simplement parce que ce caractère comme vous l'avez vu, rappelez-vous dans les opérateurs finalement de redirection on faisait ça par exemple `2>` pour rediriger en sortie. Rappelez vous même en redirigeant par des sorties standards, sortie d'erreur, etc et celui-là `<` pour lire par exemple depuis une entrée d'accord c'est des caractères qu'on utilise déjà en Bash, on les a vus précédemment pour pas mal de commandes.

Ici donc on ne peut pas utiliser ce type de caractère alors les syntaxes que je vais vous montrer comme il s'agit d'une syntaxe `test` et on va avoir une syntaxe synonyme avec des crochets c'est la syntaxe la plus historique d'accord c'est celle qui vient tout simplement du Shell Bourne, le Bourn Shell donc c'est `sh` pour être exacte qui par la suite étant assez limité, très minimaliste à donner finalement naissance à pas mal d'autres Shell : bash, csh, zsh, ksh.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
```

bash, csh, zsh, ksh et cetera qui sont basés sur sh mais avec des fonctionnalités, des outils supplémentaires.

Alors ça existe peut être mais je n'ai pas spécialement mémoire connaissance d'un shell qui ne serait pas basé sur sh ou même sur un de ceux-là, bash, csh, zsh, ksh.

En gros un shell qui partirait vraiment d'un langage de 0 où la personne aurait absolument tout programmé de zéro sans se baser sur un autre shell existant déjà.

shell (sh) est donc quelque chose d'historique mais l'avantage c'est que vous êtes normalement si vous êtes sur une distribution GNU Linux voir même certaines distributions bsd et sur mac os aussi parce que mac os est un système Unix on rappelle donc propose généralement des Shell comme ça et vous vous assurez en fait que ce type de syntaxe sera normalement quasi fonctionnel parce que je ne peux pas en être sûr à 100%.

Je ne connais pas tous les shell du monde entier, il y en a surement que je ne connais pas et à partir de là de vous assurer que ce type de syntaxe fonctionne.

On verra une syntaxe un peu plus évolué par la suite qui n'existe pas avec sh puis qui existe avec les autres, on regardera tout ça.

### Expressions de test

On fait ce test `if test $nb1 < $nb2 ; then` avec comme ceci `<` est un caractère déjà utilisé on va devoir utiliser des expressions, des arguments différents pour finalement désigner un petit peu toutes ces choses d'accord ça ne marchera pas et vous voyez que ça crée ce genre d'erreur parce qu'il essaye en fait de prendre `$nb2` comme entrée pour mettre dans `$nb1`, de s'en servir pour l'expression de `$nb1`.

```bash
sam@sam:~/Documents$ ./main.bash
./main.bash: ligne 7: 28: Aucun fichier ou dossier de ce type
```

Pour lui donc forcément c'est incompréhensible puisque ce ne sont pas des commandes comme on le ferait dans notre shell.

Très simplement alors pour faire cette vérification ici on va utiliser l'argument tiret ... on va utiliser un tiret comme quand on fait des options aux commandes suivi de lt pour lower than, `-lt`.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq
```

`-lt` lower than pour inférieur ici strictement.

Si on veut dire lower or equal donc inférieur ou égal, on utilisera tirer le, `-le`.

Vous avez donc compris que l'inverse si vous parlez un petit peu anglais c'est greater than, `-gt` ou greater or equal donc `-ge`.

Et si on veut carrément faire les simples égalité, on va avoir `eq` pour equal et on va avoir l'inverse `-ne` pour not equal.

Ok alors là `-ne` ils ont gardé que deux caractères plutôt que -neq parce que c'est plus simple de dire qu'on a toujours deux caractères ici tout simplement.

Voilà donc ça ce sont des outils à utiliser pour des nombres d'accord quand on travaillera sur des chaînes de caractères on verra que c'est différent.

Pour les nombres, ne vous embêtez pas vous pouvez directement travailler avec ça.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=24
nb2=28
nb3=24

if test $nb1 -lt $nb2 ; then
    echo 'nb1 < nb2'
fi
```

Je remplace donc mon caractére qui n'est pas bon `<` par cette syntaxe `-lt` ok.

Je fais ça et je réactualise et là vous voyez que ça fonctionne.

```bash
sam@sam:~/Documents$ ./main.bash
nb1 < nb2
```

Comme cette expression `$nb1 -lt $nb2` qui est donc finalement traitée, exécutée, cette expression a comme code de retour, le `exit status` le code de sortie peu importe 0 c'est donc valide donc on rentre dans le `then` et on rentre finalement dans notre structure `if` on affiche bien ce `echo`.

Si je faisais l'inverse `-gt` comme tout à l'heure dans le prompt là ça ne marche pas.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=24
nb2=28
nb3=24

if test $nb1 -gt $nb2 ; then
    echo 'nb1 > nb2'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
sam@sam:~/Documents$ 
```
Là ça ne marche pas donc on affichera absolument rien.

Voilà très simple à savoir.

## if crochet

Syntaxe équivalent du `test` si vous ne voulez pas rajouter trop de termes vous pouvez utiliser des crochets, des simples crochets par contre attention à mettre une espace ici, `if [ $nb1 -gt $nb2 ] ; then` voilà il y a une espace là de chaque coté des crochets sinon vous aurez tout simplement une erreur.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=24
nb2=28
nb3=24

if [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
sam@sam:~/Documents$ 
```

Alors ça c'est une syntaxe équivalente d'accord on a le mot clé test et on a aussi cette syntaxe sous forme de simple crochet c'est vous qui voyez encore une fois je ne recommande pas une en particulier c'est selon vos préférences donc vos goût et vous vous débrouillez à ce niveau là.

Voilà comment ça fonctionne pour ce type de vérification.

Alors je ne vais pas tous vous les montrez ainsi si vous voulez tester une égalité vous utilisez celui-là `-eq` etc, je pense que c'est relativement simple.

Il n'y a pas de problème et de toute façon ce sera tout l'occasion pour vous après de vous entraîner, vous exercer avec plein d'autres outils, de tests que vous pourrez faire pour voir un peu comment ça fonctionne.

Voilà ça on a une condition pour le coup qui est assez simple, on fait juste un `if` et c'est terminé on aura peut-être besoin de vérifier d'autres choses par exemple alors bon on va revenir à ça `-lt` j'aurais peut-être envie de vérifier par exemple si ce n'est pas nb1 qui est inférieur strictement à nb2, hé bien on peut vérifier l'inverse c'est-à-dire est-ce qu'il n'est pas par exemple supérieur strictement.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=24
nb2=28
nb3=24

if [ $nb1 -lt $nb2 ] ; then
    echo 'nb1 < nb2'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
sam@sam:~/Documents$ 
```

## elif

Et dans ce cas là, on peut faire une autre vérification avec un petit `elif` donc on va le mettre ici et vous faites la même chose mais bien sûr avec votre autre test donc ça sans oublier les espaces puis à nouveau un ; et `then` et un echo pour l'inverse.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=24
nb2=28
nb3=24

if [ $nb1 -lt $nb2 ] ; then
    echo 'nb1 < nb2'
elif [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
nb1 < nb2
```

Voilà ça permet de tester les deux. 

Si j'inverse par exemple je teste que nb1 devient plus grand.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=34
nb2=28
nb3=24

if [ $nb1 -lt $nb2 ] ; then
    echo 'nb1 < nb2'
elif [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
nb1 > nb2
```

Hop automatiquement on rentre dans le `elif` et non plus dans le `if` voilà donc on peut comme ça créer des structures un peu plus complexe.

Nous avons un dernier cas alors les `elif` vous pouvez en faire plein, le `if` il y en a forcément qu'un seul c'est le premier test.

Les `elif` vous pouvez en cumuler, on peut en faire plein et faire plein d'autres vérifications.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=34
nb2=28
nb3=24

if [ $nb1 -lt $nb2 ] ; then
    echo 'nb1 < nb2'
elif [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
elif [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
fi
```

C'est dire qu'en gros il va tester ça si cela ne fonctionne pas et que ce n'est pas validé alors il va tester le suivant, si c'est pas validé il va tester le troisième d'accord donc si au bout d'un moment il en valide un, il ne testera pas d'accord ici les autres du `elif` puisqu'il sortira d'accord il faudrait sinon mettre des `if` à la suite qui sont chacun séparés pour tester absolument tous les `if` d'accord si je fais ça par exemple, on un `fi` pour chaque `if` et là effectivement il va tous les tester.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=34
nb2=28
nb3=24

if [ $nb1 -lt $nb2 ] ; then
    echo 'nb1 < nb2'
fi

if [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
fi

if [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
fi
```

D'accord là, il va tous les tester voilà donc un peu moins performant bon attention quand vous faites ça.

## else

On peut revenir sur le code d'avant donc je vais assez vite parce que bon c'est beaucoup de choses qu'il faudra que vous testiez ça n'a rien de compliqué à ce niveau là. On peut également prévoir un cas par défaut c'est à dire par exemple si on n'a ni validé ça `$nb1 -lt $nb2` ni validé `elif` ou les éventuels `elif` qu'il y a, on va tout simplement mettre un `else` qu'on retrouve dans d'autres langages ici.

D'accord le `else` très important voilà pour comme ça faire différentes test donc à vous de voir ok par rapport à ça ce qu'on peut faire.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

nb1=24
nb2=24
nb3=24

if [ $nb1 -lt $nb2 ] ; then
    echo 'nb1 < nb2'
elif [ $nb1 -gt $nb2 ] ; then
    echo 'nb1 > nb2'
else
    echo 'nb1 = nb2'
fi
```

Le `else` permettra simplement de dire que si on a validé aucun finalement on va  retrouver un petit peu tout ça voilà donc c'est important de voir un petit peu tout ce qu'il ya là ok.

Je vous laisserai encore au moment où j'ai enregistré cette vidéo je n'avais pas fait de playlists d'exercice pour linux donc vous aurez bien sûr quelques execices pour des simples commandes dans le terminal et il y a évidemment de prévu des exercices de script, de programmation de script parce que c'est intéressant je trouve à ce niveau là.

Voilà tout ça mérite finalement d'être vu aussi.

`if`, `elif` et `else`, vous pouvez toujours faire le `else` on ne fait pas de conditions, on ne fait pas de nouveaux tests puisque le `else` en fait c'est le test par défaut d'accord donc en gros c'est simplement de se dire finalement que si c'est ni plus petit ni plus grand c'est qu'à priori ça veut dire que c'est égal.

```bash
sam@sam:~/Documents$ ./main.bash
nb1 = nb2
```

Voilà vous voyez ils sont égaux, nb1 est égale à nb2, voilà ça va ni valider ça `[ $nb1 -lt $nb2 ]`, ni valider ça `[ $nb1 -gt $nb2 ]` et donc le simple `else` donc pas besoin de  `then`, de `;` et encore moins de `test` d'accord c'est encore une fois le cas par défaut pour dire si aucun autre n'a été validé.

## OU ET

On peut aussi cumuler plusieurs vérifications sur un simple `if` d'accord.

Par exemple admettons qu'on veut faire un inférieur ou égal donc en gros ceci `-le` lower equal.Evidemment si on veut être propre on va faire ce simple opérateur d'accord cette simple vérification parce qu'on ne va pas s'amuser à en faire plusieurs mais ça reviendrait finalement à décomposer en deux c'est à dire décomposer en lower than `-lt` donc inférieur strictement ou en equal `-eq` et pour présenter ce symbole de **OU** on va utiliser ce caractère `||`.

Alors ça ressemble beaucoup à un héritage du c.

Alors si on peut vérifier avec un **ET** c'est une double esperluette ou un et commercial d'accord ce symbole là `&&`.

Pour vérifier les tests doivent bien être mis à chaque fois chaque entre crochets ou alors vous utilisez le mot-clé `test` donc je peux
faire simplement `if` nb1 strictement inférieure à nb2 ou alors je refais des crochets pour nb1 égal à nb2.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

# ||, &&

nb1=24
nb2=24
nb3=24

if [ $nb1 -lt $nb2 ] || [ $nb1 -eq $nb2 ] ; then
    echo 'nb1 < nb2 ou nb1 = nb2'
fi
```

Alors donc ça veut dire que si ça valide `[ $nb1 -lt $nb2 ]` ou alors que ça valide `[ $nb1 -eq $nb2 ]` d'accord on a bien un ou `||` ici alors c'est pas un ou exclusif, c'est un ou normale, standard alors ça ça fonctionnera.

Voilà donc ça veut dire ça `'nb1 < nb2 ou nb1 = nb2'` donc pas besoin d'avoir les deux de valides d'accord c'est pas un **ET** mais c'est un **OU**.

Ok seulement l'un ou l'autre donc là ils sont égaux.

```bash
sam@sam:~/Documents$ ./main.bash
nb1 < nb2 ou nb1 = nb2
sam@sam:~/Documents$ 
```

Ils sont égaux voyez comme nb1 est égal à nb2, `[ $nb1 -lt $nb2 ]` n'est pas validé parce que nb1 n'est pas strictement inférieure à nb2 mais comme nb1 est égal à nb2 ça va fonctionner, ça à vérifier une des deux égalités.

Maintenant s'il faut que ce soit les deux comme ça voilà ça ne marchera pas.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq

# ||, &&

nb1=24
nb2=24
nb3=24

if [ $nb1 -lt $nb2 ] && [ $nb1 -eq $nb2 ] ; then
    echo 'nb1 < nb2 ou nb1 = nb2'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
sam@sam:~/Documents$ 
```

Voilà voilà ça ne marchera pas parce que là il faudrait qu'il soit inférieur strictement et en plus qui soit égal ce qui est impossible.

On ne peut pas avoir une valeur inférieure à une autre et en même temps égal ou alors on est dans un univers un peu bizarre, un peu étrange c'est presque du x files donc attention.

Ok donc ça on peut cumuler, on peut cumuler avec du `||`, du `&&` voyez pareil je vous laisserai vous entraînez, vous exercez avec plein de scrips pour vous donner plein de possibilités et d'idées de scripts à faire avec ça d'accord je vais essayer de ne pas trop perdre de temps parce qu'on pourrait montrer 15 millions d'exemples mais ça ne va pas spécialement vous aider et ça va surcharger on va dire la vidéo pour rien.

Voilà pour les nombres, pour les vérifications.

## vérification de chaînes

On va passer très rapidement aux chaînes de caractères d'accord parce qu'on va voir que c'est un petit peu différent par rapport à ça.

Alors évidemment je ne vous ai pas montré forcément toutes les vérifications, on aurait pu vérifier par exemple qu'un caractère est vrai avec un autre ou pas c'est-à-dire qu'au lieu d'utiliser les symboles là `||`, `&&` on peut utiliser le tiret a `-a` en fait pour vérifier ce `&&` d'accord donc là on met un -a entre deux valeurs, $nb1 -a $nb2.

Mettre un tiret a entre 2 valeurs ça reviendra au même ou alors on met un tiret o `-o` pour dire que l'une est vrai ou l'autre est vrai.

On a plusieurs syntaxe différente puisque ont n'a pas en particulier une syntaxe pour des nombres et une syntaxe finalement pour des chaînes qu'on va voir juste après.

Voilà donc vous voyez, on peut finalement cumuler, faire des structures assez complexe du `elif`, du `else`, etc.

Passons rapidement aux chaînes mais comme je vous avez dit, vous allez avoir une séance dédiée aux chaînes de caractères parce que je veux aller un peu plus loin dans le détail sur les chaînes de caractères mais rapidement pour les chaînes nous n'allons pas utiliser cette syntaxe.

```bash
#!/bin/bash

# Bourne (sh) -> bash, csh, zsh, ksh.
# -lt, -le
# -gt, -ge
# -eq, -neq
```

D'accord cette syntaxe est réservée est vraiment au
nombre ok pour les chaînes nous allons utiliser une syntaxe très simple qui est `=` pour l'égalité et `!=` pour l'inégalité.

```bash
#!/bin/bash

# =, !=
```

On a également pour les expressions rationnelles mais comme c'est un cas un cas particulier qui ne sera pas intéressant pour le moment parce qu'on ne sait même pas pour beaucoup ce que c'est, on va juste se contenter de ça.

Alors ce que je vais faire simplement, je crée des chaînes. Alors comment vérifier deux cas là, on va regarder cette syntaxe ou le test peu importe et on va dire simplement est-ce que str1 est égal à str2.

```bash
#!/bin/bash

# =, !=

str1='hello'
str2='world'
str3='hello'

if [ $str1 = $str2 ] ; then
    echo 'EGALES'
fi
```

Alors donc il n'y a pas deux symboles égale donc ça je le dis pour ceux qui viennent d'autres langages de programmation.

L'égalité ici se fait simplement par simple égale là donc si c'est le cas je met que les chaînes sont égales.

```bash
sam@sam:~/Documents$ ./main.bash
sam@sam:~/Documents$ 
```

Voilà elles ne sont pas égales, str1 et str2 donc on ne rentre pas dedans.

Maintenant si je teste str1 avec str3 ça fonctionne.

```bash
#!/bin/bash

# =, !=

str1='hello'
str2='world'
str3='hello'

if [ $str1 = $str3 ] ; then
    echo 'EGALES'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
EGALES
```

Alors ça fonctionne voilà très simplement pour vérifier qu'elles sont différents vous utilisez cet opérateur-là `!=` de différence et ça fonctionnera aussi.

Pas de problème à ce niveau là voilà pour cette vérification et je m'arrêterai là pour les chaînes parce qu'on verra plein d'autres choses par la suite sur une vidéo dédiée.

Je vous montrerai notamment alors je peux rapidement le suggérer càd comment vérifier par exemple qu'une chaîne est vide ou alors ne l'est pas d'accord.

Si vous voulez vérifier simplement qu'une chaîne est vide, vous pouvez sur une seule chaîne genre str1 et vous utilisez ça `-z` d'accord tiret z pour dire que c'est en fait égal à zéro.

```bash
#!/bin/bash

# =, !=

str1=''
str2='world'
str3='hello'

if [ -z $str1 ] ; then
    echo 'VIDE :('
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
VIDE :(
```

Voyez ça fonctionne.

Si je veux vérifier que ce n'est pas vide je mets un tiret n `-n` pour non vide en fait simplement donc je remet `str1='hello'`.

```bash
#!/bin/bash

# =, !=

str1='hello'
str2='world'
str3='hello'

if [ -n $str1 ] ; then
    echo 'PAS VIDE :D'
fi
```
```bash
sam@sam:~/Documents$ ./main.bash
PAS VIDE :D
```

Voilà ne vous inquiétez pas, les chaînes je vais assez vite parce que c'est pas forcément l'objet de cette vidéo et je voulais vraiment faire une vidéo à part juste pour ça parce qu'il y a quand même pas mal à dire sur les chaînes de caractères et ça méritait au moins une vidéo.

Nous pouvons également utiliser d'autres éléments d'accord sur les chaînes que je vous ai montré, comment vérifier qu'une chaîne est vide ou pas vide et on va pouvoir également travailler sur les systèmes de fichiers.

L'avantage encore une fois de programmer des scripts tel que je vous l'ai dit c'est de pouvoir travailler pour votre système, de faire un petit programme.

## vérification de fichiers

Voilà il y a peut-être des gens parmi vous qui vont programmer dans d'autres langages et veulent toutes les semaines que ça fasse finalement une copie de vos fichiers de programmation dans une archive et que ça les envoie sur un autre sur un autre disque voire même sur un serveur distant d'accord une machine à distance.

Bref on va très souvent avoir besoin de travailler sur nos fichiers et nos répertoires, sur les arborescences et il faut qu'on ait accès à tout ça.

Il existe pour cela pas mal d'autres outils qu'on va pouvoir trouver ici dans les tests qu'on va faire qui me semble assez pratique et que je peux vous citer.

Je ne vais pas tous vous les nommer parce qu'il en a plein plein plein mais je vais en tout cas vous donner les principaux ceux qui me semble en tout cas essentielles à connaître.

Alors le premier très simple, c'est par exemple vérifier simplement l'existence de quelque chose dans le répertoire courant.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire
```

D'accord existe dans le répertoire courant pour le tiret e `-e` où on va pouvoir vérifier simplement que quelque chose est un fichier avec un tiret f `-f` et son autre complément, c'est de vérifier que quelque chose est un répertoire `-d`.

Si je fais le test `ls` où je suis dans mon répertoire personnel voilà.

```bash
sam@sam:~$ ls
Bureau     Images   Musique  Public  Téléchargements
Documents  Modèles  Partage  snap    Vidéos
```

Voilà je peux dire est-ce que j'ai un répertoire de musique que je met entre symboles-là, simple quote, et j'écrit 'Ce dossier existe' ou bien 'Musique est un dossier'.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire

if [ -d 'Musique' ] ; then
    echo 'Musique est un dossier'
fi
```

D'accord un if -d pour répertoire, directory 'Musique' alors on fait ça et il va chercher là dedans (~$).

```bash
sam@sam:~$ ./main.bash
Musique est un dossier
```

Voyez là il ne fait pas un test sur une chaîne de caractères, il va vraiment prendre ça dans l'arborescence et il va fouiller à ce niveau là il va voir qu'on pourra récupérer cette information donc pourquoi je vous donne ce genre de petites commandes parce que c'est très pratique voyez qu'on n'a pas besoin de faire de `ls`, de `cat`, de `echo` ou autre.

Faites attention d'ailleurs quand vous utilisez des `ls` ou des commandes comme `cat`, des commandes de parcours ou autres dans vos scripts parce que vous verrez qu'avec des simples petites options, des simples arguments vous pourrez en fait réaliser la même chose et de manière beaucoup plus rapide beaucoup plus performante dans vos scripts.

Ayez donc quand même un certain usage directement dans la ligne de commandes et quand vous êtes dans la programmation de script vous allez avoir des outils beaucoup plus puissants, beaucoup plus pratique qui feront le même travail mais mieux d'accord.

Faites attention quand on veut lister des répertoires ici en programmation, s'amuser à faire un `ls` par exemple n'est pas forcément utile alors qu'on pourrait simplement utiliser le symbole `*` finalement qui liste un peu tout ce qu'on a d'accord pour lister dans un répertoire et puis on a ça d'accord `dir /*`. C'est plus rapide que de faire des `ls` bizarre.

```bash
#!/bin/bash

dir /*
```

Attention donc mais de toute façon on aura l'occasion d'en parler un petit peu plus et pareil avec les tutoriels disponibles pour pour la formation GNU Linux, il y a pas mal d'astuces et de techniques qui vous seront donnés aussi donc on peut vérifier ça.

Evidemment si je fais ça `-f`.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire

if [ -f 'main.bash' ] ; then
    echo 'main.bash est un fichier'
fi
```
```bash
sam@sam:~$ ./main.bash
main.bash est un fichier
```

Voilà vous voyez que ça marche.

Il y a aussi tiret e aussi `-e` et je vais mettre un message très rapide pour montrer.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire

if [ -e 'Musique' ] ; then
    echo 'Musique OK'
fi
```
```bash
sam@sam:~$ ./main.bash
Musique OK
```

Voilà donc ça existe et donc c'est trouvé.

Il n'y a pas de souci à ce niveau là.

## vérification de droits

Qu'est-ce qui peut être intéressant aussi donc là c'est plus pour l'existence et le type qu'on va avoir au niveau de nos fichiers, on peut vérifier par exemple le niveau des permissions.

On a beaucoup parlé des permissions précédemment donc on peut aborder ce genre de chose aussi avec trois autres symboles : le petit r `-r` simplement disponible en lecture. On va avoir le `-w` rappelez vous le w pour disponible en écriture et tout simplement `-x` disponible pour l'exécution, en exécution ou en parcours.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire

# -r : disponible en lecture
# -w : disponible en écriture
# -x : disponible en exécution
```

Rappelez-vous que pour pouvoir par exemple parcourir un répertoire, il faut qu'il ait les droits d'exécution sinon ça ne marche pas on ne pourra pas le parcourir.

Alors ça j'en avais déjà parlé sur la vidéo concernant les droits mais j'en profite pour le rappeler parce que des fois des gens mettent ces droits là à un répertoire `-r et -w` mais quand il essaye de faire un `ls` dessus ou d'aller à l'interieur du répertoire, il s'étonne que ça marche pas parce qu'il faut ce droit d'exécution.

Forcément exécution, on pense à l'exécution d'un fichier d'un script mais on ne pense pas forcément que les droits d'exécution sur un répertoire  permettent d'aller dedans, d'entrer dans l'arborescence donc très important.

Voilà on a ces cas là, après on a un grand N `-N` si je ne dis pas de bêtises pour ne pas me tromper qui est par exemple pour vérifier qu'un fichier a été modifié avant le moment d'aller tester.

Par exemple, vous avez un programme vous avez besoin de faire d'afficher par exemple le contenu d'un fichier, n'importe quoi ben il n'y a peut-être pas besoin de le faire si par exemple rien n'a changé depuis la dernière fois.

Imaginez un système par exemple qui actualiserait le contenu d'un fichier, on n'a pas forcément besoin d'afficher quelque chose qui est identique s'il n'a pas été modifié.

Après la modification ne veut pas forcément dire que ça a changé mais ça veut dire quand même que le fichier a été ouvert ou autre, qu'il y a une modification dans tous les cas qui a été prise en compte au niveau du disque donc on peut vérifier ça.

`-N` donc ça s'est vérifier s'il y a eu en fait  modifications depuis la dernière lecture en fait le dernier accès plutôt.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire

# -r : disponible en lecture
# -w : disponible en écriture
# -x : disponible en exécution

# -N : s'il y a eu modification depuis dernier accès
```

Voilà donc plein de vérifications comme ça.

Qu'est ce qu'on peut vérifier aussi ? voilà on a le `-N` pour les droits de fichier et je peux montrer aussi `-s` pour la taille de fichier si un fichier a une taille supérieure à 0, on va dire ça comme ça donc en gros si on a pas un fichier n'est pas vide.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire

# -r : disponible en lecture
# -w : disponible en écriture
# -x : disponible en exécution

# -N : s'il y a eu modification depuis dernier accès
# -s : si un fichier a une taille > 0
```

Voilà ça peut servir aussi donc un petit tiret s `-s` et là j'ai pas tellement d'exemples. Il faudrait éventuellement que je crée par exemple un fichier test `touch test.txt` et là si je fais ça.

```bash
#!/bin/bash

# -e : existe dans le répertoire courant
# -f : si c'est un fichier
# -d : si c'est un répertoire

# -r : disponible en lecture
# -w : disponible en écriture
# -x : disponible en exécution

# -N : s'il y a eu modification depuis dernier accès
# -s : si un fichier a une taille > 0

if [ -s 'test.txt' ] ; then
    echo "Le fichier n'est pas vide"
fi
```
```bash
sam@sam:~$ touch test.txt
sam@sam:~$ ./main.bash
sam@sam:~$ 
sam@sam:~$ ls -s test.txt
0 test.txt
sam@sam:~$ echo hello > test.txt
sam@sam:~$ ls -s test.txt
4 test.txt
sam@sam:~$ ./main.bash
Le fichier n est pas vide
```

Le fichier n'est pas vide par défaut il a une taille ok.

Et là si je refait un petit echo pour ajouter du texte et maintenant il nous dit que le fichier n'est pas vide. 

Voyez qu'en quelques secondes, j'ai créé un fichier en ligne de commande et comme il était vide, et le programme nous a rien retourné parcequ'il n'avait pas une taille supérieur à 0.

Ensuite j'ai fait un petit `echo` pour envoyer ça avec ce petit symbole arithmétique (>) dans le texte qu'on avait créé précédemment et vous voyez que pour le coup ça marche et un petit `cat` pour pour voir qu'on a bien quelque chose dedans.

```bash
sam@sam:~$ cat test.txt
hello
```

Voilà donc finalement tout ça c'est que du rappel de choses que vous avez vues et oui, on peut  parfaitement mêler un peu tout ça.

On pourra faire plein de commandes depuis notre chaîne, on peut dans nos scripts programmer plein de choses aussi et ce sont des outils qui sont là en tout cas pour vous faciliter la vie, ajouter pas mal de possibilités et vous en verrez plein d'autres parce que voilà le but n'est pas de vous montrer 100% des options des commandes que vous pouvez faire mais au moins vous vous rendez compte un petit peu de la puissance d'un langage comme Bash, surtout un langage un peu plus étoffé comme comme celui-ci et comment on peut l'associer parfaitement dans nos script et également au niveau du shell.

Voilà pour beaucoup de choses qui finalement qui fonctionnent à ce niveau ok.

Alors on a vu beaucoup beaucoup beaucoup de choses on va terminer cette séance et après on s'arrêtera là parce qu'on a déjà vu pas mal de choses.

## case

Je vous avais dit bien qu'il aurait énormément d'éléments à noter mais on va terminer simplement avec une autre structure bien pratique notamment quand on a plein de if à faire d'accord plein de tests à vérifier.

Quand on ne veut pas forcément tous cumuler, on peut utiliser la fameuse structures en `case` qui va en fait gérer plusieurs cas de valeurs différentes et en fonction de la valeur que l'on a et bien on effectuera un traitement bien particulier donc elle est non obligatoire.

On peut parfaitement s'en passer mais ça évite par exemple des fois de faire des structures en `if`, `elif`, `else` qui sont extrêmement conséquentes d'accord quand ça commence à prendre pas mal de taille c'est à dire que par exemple qu'on vérifie 5 6 7 cas différents voire plus, on peut utiliser ce genre de syntaxe qui sera beaucoup plus lisible pour vous et beaucoup plus pratique.

On va le faire d'ailleurs sur la récupération par exemple d'une valeur, ça va faire réviser un petit peu lecture depuis clavier. On va faire ça `read -p` et puis on va demander d'entrer du texte qu'on mettra dans `cmd`.

```bash
#!/bin/bash

read -p "> " cmd
```

Alors dans un vrai programme on ne ferait pas ça parce que l'utilisateur ne sais même pas ce qu'il doit faire et on va utiliser `case` et comme pour le `if` pour terminer cette structure ont fait l'inverse donc c'est `esac` comme ceci.

```bash
#!/bin/bash

read -p "> " cmd

case $cmd in
    1) echo 'Un';;
    2) echo 'Deux';;
    5) echo 'Cinq';;
    *) echo $cmd;;
esac
```

Voilà on fait ça comme ça et on va dire qu'on vérifie cmd `$cmd in` et là on va traiter les différents cas que nous avons et pour les indiquer on va mettre la valeur que l'on veut suivi d'une parenthèse par exemple si on a tapé 1 parenthèse on fera `echo 'Un'`, etc. Et le cas par défaut, le fameux else, vous le mettez avec une astérisque voyez l'astérisque comme j'avais dit dans un script c'est très pratique parce que ça évite de faire par exemple tout un tas de commandes pour tout réceptionner.

`*` c'est un petit joker, caractère spécial ici qu'on a qui permet d'indiquer 'tout' donc c'est à dire tout le reste si ce n'est pas du `1)`, pas `2)`, pas `5)` alors par défaut ça affichera à la rigueur ce que j'ai mis, on peut faire ça.

On peut faire ça pourquoi pas.

```bash
sam@sam:~$ ./main.bash
> 1
Un
```

Ne pas oublier les `;;`.

Alors ça `1)` c'est pour la présenter vous pouvez mettre ça autrement et on peut avoir bien sûr plusieurs instructions, indiqué plein de choses avant le prochain. Par exemple je peux faire tout un tas de commandes, c'est tout ce qui sera fait au  niveau du cas 1.

```bash
#!/bin/bash

read -p "> " cmd

case $cmd in
    1) echo 'Un';;
    #autres commandes...
    2) echo 'Deux';;
    5) echo 'Cinq';;
    *) echo $cmd;;
esac
```
```bash
sam@sam:~$ ./main.bash
> 1
Un
sam@sam:~$ ./main.bash
> 5
Cinq
sam@sam:~$ ./main.bash
> 6
6
sam@sam:~$ ./main.bash
> ieirfnfe
ieirfnfe
```

Là si j'exécute, on peut mettre du texte d'accord ok.

Bien pratique d'accord donc ici je vais assez vite parce que c'est pas compliqué à utiliser mais très vite quand vous commencerez à avoir beaucoup de tests à éffectuer, vous verez que cette syntaxe est quand même bien pratique.

`1)` c'est la valeur, on pourrait remplacer par `if $cmd=1 ; then`alors je fais tout ce qui suit jusqu'aux deux points `;;` sinon `elif $cmd=2` alors je fait tout ce qu'il y a jusqu'au deux points sinon
donc `elif $cmd=5` ou `else` et je fait tout jusqu'aux deux points, ça c'est le cas par défaut.

Un cas par défaut, ça c'est vraiment ce que je répète dans tout est langage de programmation où on voit ce genre de structure donc ça c'est l'équivalent pour ceux qui programment dans d'autre langage du switch c'est le fameux switch que vous retrouvez en c, en java, en c#, etc.

## 3e syntaxe

Reporté à la prochaine séance...

Voilà voilà voilà voilà voilà voilà, je pense qu'on va s'arrêter là.

La prochaine fois, on abordera les boucles.

Les boucles comme son nom l'indique c'est de pouvoir répéter un traitement un certain nombre de fois voir des fois on peut s'en servir pour faire du parcours aussi.

On aura beaucoup de syntaxe à voir au niveau des boucles mais on a gagné pas mal de temps mine de rien avec ce que je vous ai montré déjà ici donc on a vu beaucoup de choses qui nous permettra de l'aborder la suite plus sereinement je pense.

Je vous conseille, je vous recommande même si c'est un conseil qui tient finalement pour n'importe quand mais surtout à ce moment là de bien revoir voir et revoir tout ce que vous avez vu pas seulement en programmation mais aussi au niveau des commandes dés maintenant parce que si vous n'êtes pas à l'aise avec certaines choses que j'ai pu montrer quand j'ai fait mes petits test par exemple en faisant des `cat`, commande `echo`, `touch` et envoyer (>) dans un fichier tout ça.

Si tout ça vous ne comprenez pas à ce stade de la formation dites vous qu'il n'y a rien de nouveau, on l'a vu précédemment dans le détail donc c'est que vous n'êtes peut-être pas au  point et qu'il y a encore des petites lacunes donc prenez votre temps encore une fois c'est jamais une course.

Les cours ils sont en ligne, vous avez tout le temps de les apprendre, il n'y a pas besoin d'aller vite ou trop vite vous avez le temps.

Prenez le temps d'être à l'aise avec ça et de ne pas manquer d'information parce que tous les petits détails ont leur importance surtout dans ce langage là parce qu'une erreur est très vite arrivée finalement donc il faut faire attention de ce côté là.

Pour la prochaine fois comme je l'ai dis on se retrouvera pour les boucles.

J'espère que ça vous a plu, n'hésitez pas à aimer partager cette vidéo à toute votre famille finalement voilà surtout à l'approche des fêtes de fin d'année.

N'hésitez pas.

Je vous dis à bientôt pour une prochaine vidéo, on va avancer de toute façon là dessus pour la prochaine séance et n'hésitez pas dans les commentaires si besoin bien sûr d'aides sur vos scripts et entraînez-vous surtout.

Entraînez-vous c'est important.

A bientôt