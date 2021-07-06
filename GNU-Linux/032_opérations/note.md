# [32. Opérations](https://www.youtube.com/watch?v=zTSv0lhRKBw)

Bonjour à tous, j'espère que vous allez bien on se retrouve pour cette formation GNU Linux avec la séance numéro 32 et on va voir comment faire des opérations toujours dans le cadre de la programmation de scripts en langage Bash.

Si vous vous souvenez précédemment je vous avais montré et on avait abordé ensemble les variables.

On avait vu comment les déclarer, affecter des valeurs, afficher éventuellement ces valeurs voir modifier le contenu donc la valeur d'une variable.

Ensuite j'avais montré en fin de vidéo, en fin de séance assez rapidement qu'il n'était pour le coup pas possible d'enregistrer par exemple des opérations ou en tout cas le résultat d'une opération.

Alors si vous avez déjà programmé dans d'autres langages c'est quelque chose qui est assez déroutant parce que en c, en python, en php, en java ou ce que vous voulez, vous pouvez parfaitement affecter à une variable un calcul donc vous faites une expression avec différents opérateurs de comparaison arithmétique, binaire, peu importe et on peut parfaitement récupérer ce résultat.

Voilà ce qui n'est pas forcément le cas ici en langage Bash et c'est tout le sujet de cette séance, c'est ce que je vais vous montrer maintenant.

On va repartir en tout cas sur un exemple, sur un bout de code qu'on avait fait un petit peu précédemment pour revenir là dessus et on partira de celui là, on va revenir directement sur un script.

```sh
#!/bin/bash

number=145
echo $number
```

On avait vu pour la création d'une variable, je rappelle qu'il ne faut pas d'espace pour éviter les problèmes. On fait ceci et avec un petit `echo` on affichait parfaitement la valeur.

```bash
sam@sam:~/Documents$ ./main.sh
145
```

Voilà on retombe sur l'affichage de la valeur, aucun problème à ce niveau là par contre si je commence à faire encore une fois comme dans d'autres langages de programmation si vous n'avez jamais programmé avant vous ne serez pas spécialement perdu à ce niveau là.

Je fais ce genre de calcul d'accord un petit  opérateur pour faire une simple addition.

```sh
#!/bin/bash

number=145+5
echo $number
```
```bash
sam@sam:~/Documents$ ./main.sh
145+5
```

Et ici quand on tente d'afficher, on retrouve l'information telle quelle ça rejoint un petit peu ce que je vous avais dit précédemment dans le fait que tout est traité comme une chaîne c'est à dire ça ça reviendrait quasiment à avoir ce genre d'informations là `number='145+5'` d'accord c'est exactement de la même manière que c'est traité.

```sh
#!/bin/bash

number='145+5'
echo $number
```
```bash
sam@sam:~/Documents$ ./main.sh
145+5
```

`number='145+5'` ici il ne va pas considérer qu'on a un nombre entier `145`, un opérateur pour faire une somme et un autre entier `5` mais il considère que tout ceci `'145+5'` est une chaîne et voilà il ne fait pas tellement la distinction et j'aurais pu noter un petit peu n'importe quoi, `145+5hello`.

```sh
#!/bin/bash

number=145+5hello
echo $number
```

```bash
sam@sam:~/Documents$ ./main.sh
145+5hello
```

Voilà ça va faire un mélange un peu bizarre mais voilà un petit peu ce que ça donne d'accord tout est traité sous forme de chaîne c'est pour ça qu'on doit faire attention aux espaces dans ce genre de déclarations ici de variables.

Je vais vous montrer parce que le langage a pas mal évolué et qu'on a retrouvé évidemment tout un tas de nouvelles fonctionnalités ou autres de syntaxes possibles pour pouvoir faire vos opérations.

Il est possible que vous en trouviez d'autres surtout quand on va aborder d'autres séances par exemple quand on va attaquer les structures conditionnelles vous verrez qu'on ne verra pas forcément toutes les syntaxes parce que beaucoup des syntaxes sont assez ancienne, d'autres sont arrivés par la suite et le langage Bash étant basé en tout cas sur du C, a pas mal repris aussi des fonctionnalités du langage c pour pouvoir en fait s'ajouter un peu plus de performances, de puissance et surtout d'outils.

Il faudra donc vous habituer à ça parce que vous verrez souvent des outils du c que l'on retrouve petit
à petit en langage Bash donc on va aborder ces derniers-là.

Première chose que je vais vous montrer alors on pourrait utiliser la commande `declare` que je vous avais montré avec un petit tiret i `declare -i` et puis là on fait un nombre qui serait un nombre entier on peut faire ce genre de choses mais je vais passer là dessus.

On l'avait un petit peu abordé la dernière fois parce que ce n'est pas forcément le plus efficace.

## let

Première syntaxe possible on peut utiliser une autre commande un terme qui est la commande `let` d'accord on fait cette commande là je déclare le nombre ici et je mets une valeur.

```sh
#!/bin/bash

let number=145+6
echo $number
```

Cette fois-ci voyez que je fais mon calcul comme d'habitude et là avec un affichage on obtient bien le résultat de l'addition d'accord.

```bash
sam@sam:~/Documents$ ./main.sh
151
```

L'opérateur a bien été pris en compte grâce à `let` ça permet ici d'assigner finalement donc faire des opérations ici et de pouvoir affecter le tout sans problème..

On a un comportement complètement différent.

Petite astuce également au niveau de `let` si vous voulez un petit peu aéré votre syntaxe et on peut parfaitement tout séparer comme ça en entourant de  limiteurs qu'on utilise habituellement pour les
chaînes donc si je fais ça ça fonctionne aussi.

```sh
#!/bin/bash

let 'number = 145 + 6'
echo $number
```
```bash
sam@sam:~/Documents$ ./main.sh
151
```
Alors ça c'est particulier encore une fois c'est pour cela que j'insiste beaucoup sur le cours au niveau de l'usage, des notations parce que Bash a des notations diverses et variées et pas toujours on va dire pratique pour les gens qui débutent avec la programmation en Bash c'est une chose mais les gens qui viennent d'autres langages de programmation ça peut être beaucoup plus déroutant à ce niveau là.

Alors évidemment en fonction du type de shell que vous allez utiliser si vous n'utilisez pas bash et que vous utilisez un autre shell, vous pouvez avoir des syntaxes différentes voire des fonctionnalités encore plus modernes ou des choses un peu plus light ou un peu plus complète.

Tout dépend encore une fois ici on essaie de trouver des outils les plus généraux possible que vous allez retrouver un petit peu partout.

## commande composé

Alors dans le cas des opérations même si vous voyez que ça marche plutôt bien ici, il n'y pas de problème à ce niveau là, on va plutôt pour faire évaluer une expression utiliser une commande composé plutôt que la commande `let` ici que je vous met en commentaire.

On va de préférence se servir simplement de nos commandes composés avec le fameux dollars et ici en doublant nos parenthèses.

```sh
#!/bin/bash

# let 'number = 145 + 6'

number=$((145 + 66))
echo $number
```

A partir de là on peut écrire notre calcul sans problème d'ailleurs on est même pas obligé de ne pas mettre d'espaces, on peut très bien espacer il n'y aura pas de problème.

```bash
sam@sam:~/Documents$ ./main.sh
211
```

Voyez on a notre résultat et vous voyez que ça traite parfaitement l'opération donc très pratique à ce niveau là, une autre syntaxe en tout cas pour faire vos différentes opérations vous pouvez utiliser celle-ci.

## Opérateurs

En plus elle va vous permettre d'utiliser tous les opérateurs issus du langage c qui est forcément bien plus pratique surtout quand on va voir les conditions vous verrez que les moyens de faire des comparaisons à l'ancienne si je puis dire était quand même moins évidente que ce qu'on peut retrouver maintenant dans quasiment tous les langages de programmation qui utilise accessoirement tous les mêmes opérateurs d'accord les mêmes syntaxes, la même notation pour les opérateurs donc on s'y retrouve très facilement.

```sh
#!/bin/bash

# + - * ** / %
```

Pour faire très simple on va retrouver les opérateurs arithmétique `+ - * ** / %` où on double les asthérisques pour faire une puissance, ensuite ´/´ pour récupérer le résultat de la division, et `%` pour récupérer le reste de cette division qui sert pour le modulo.

`%` c'est un opérateur qu'on rencontre beaucoup en arithmétique aussi, encodage, etc.

Voilà ça ce sont les principaux, on a évidemment des opérateurs d'affectation, je vous les montre assez vite on en a qu'on connaît bien qui est celui-là `=` pareil si vous avez déjà fait du c que vous connaissez le langage vous savez qu'il existe d'autres opérateurs d'affectation comme `= += -= *= %=`.

```sh
#!/bin/bash

# + - * ** / %
# = *= -= *= %=
```

Là je ne vais pas tous les énumérer en gros on utilise les opérateurs arithmétique suivi de l'opérateur d'affectation donc ça permet tout simplement pas au lieu d'avoir ce genre de calcul `a = a + 1` ce qui répèterai à chaque fois l'usage de la variable et dont on peut tout simplement faire `a += 1` voilà si on veut faire l'inverse avec `-=` c'est la même syntaxe d'accord.

```sh
#!/bin/bash

# + - * ** / %
# = *= -= *= %=

# a = a + 1
# a += 1
```
 
Voilà des petits raccourcis de syntaxe.

On va pouvoir également utiliser les syntaxes raccourci pour l'incrémentation par exemple d'augmenter une variable de 1, de la réduire de 1 donc ces syntaxles-là `a++, a--` pareil avec les valeurs préfixées `++a, --a` et cetera donc ça encore une fois c'est du langage c d'accords en termes de notation qui sont réutilisables en bash grâce notamment avec ce genre de commandes composé.

```sh
#!/bin/bash

# + - * ** / %
# = *= -= *= %=
# a++, a--, ++a, --a

# a = a + 1
# a += 1
```

C'est donc plus pratique vous avez quelque chose d'un peu plus récent, d'un peu plus moderne et qui sera surtout assez voisins des autres langages de programmation que vous avez l'habitude d'utiliser parce que vous verez par la suite selon le type de données, on ne fait pas des comparaisons de la même manière avec des nombres qu'avec par exemple des chaînes de caractères mais je pense que je dédierais une vidéo spécialement pour les chaînes de caractères parce que je vous donnerai au passage quelques petits outils pour faire des opérations usuelles de base sur des chaînes de caractères qui peuvent je pense être assez utile dans ce cours. On regardera donc ça un petit peu plus tard.

Voilà donc on peut parfaitement aligner des choses assez intéressante à ce niveau-là.

## test commande composé

Petit test aussi où je vais faire un echo de l'addition de a+b.

```sh
#!/bin/bash

result=$((a + b))
echo $result
```
```bash
sam@sam:~/Documents$ ./main.sh
0
```

Voyez on a 0 donc on traite parfaitement ici l'expression et non pas de la concaténation de chaîne or je peux m'amuser également à complexifier un peu tout ça en faisant ce genre de test.

```sh
#!/bin/bash

result=$(('a' + 'b'))
echo $result
```
```bash
sam@sam:~/Documents$ ./main.sh
./main.sh: ligne 3: 'a' + 'b' : erreur de syntaxe : opérande attendu (le symbole erroné est « 'a' + 'b' »)
```

Voilà et vous aurez des erreurs de syntaxe pour ça que je vous avez dit que pour les chaînes de caractères, on va avoir quand même des cas assez particulier qu'on abordera plus tard.

On va avoir d'autres notations en plus des parenthèses, il y a des crochets fin bref il y a énormément de notations possibles en bash et le but c'est que vous soyez assez à l'aise avec ça pour en aborder un maximum donc on va rester sur des normes très simple de cette manière il n'y aura pas de souci à ce niveau-là ça s'affichera vous n'aurez pas d'erreur et tout va bien.

```sh
#!/bin/bash

result=$((45 + 23))
echo $result
```

Voilà donc `$((45 + 23))` c'est la commande composé d'accord c'est celle à privilégier pour les calculs et vous avez éventuellement la commande interne avec `let` qui permet de faire la même chose mais elle ne sert pas forcément qu'à ça mais on peut parfaitement l'utiliser.

Il y a aussi la commande `ex` pour les expressions, il y a la commande d'évaluation mais pareil il ne faut pas faire n'importe quoi avec, c'est généralement dans d'autres usages et pas forcément dans le cas de l'évaluation par exemple d'une opération arithmétique ou autre.

Voilà encore une fois Bash est un langage qui est assez puissant, on a plein de commandes disponibles, plein de possibilités, plein de fonctionnalités donc il existe toujours tout un tas de syntaxe finalement pour faire un peu la même chose.

Après il y a des contextes différents d'utilisation et des cas où on va plutôt utiliser tel format ou plutôt tel format donc à vous de voir, à vous de pratiquer et vous verrez par la suite.

Moi je vous donne en tout cas l'essentiel parce qu'il n'y a pas forcément besoin de toutes les apprendre et de toute façon encore une fois `$((45 + 23))` est plutôt à privilégier pour ses différentes opérations qui est de toute façon un petit peu le but de cette vidéo.

Alors on verra pleins d'autres opérateurs parce que par la suite on va attaquer un peu les structures conditionnel donc évidemment c'était une vidéo sur les opérations je voulais faire quelque chose d'assez court mais on va voir d'autres opérateurs par la suite donc on est loin d'avoir tout vu bien sûr il y aura plein d'opérateurs de comparaison qu'on va aborder pour la suite et encore une fois si vous avez fait du c même pour les opérateurs binaire, je ne vous les ai pas montré parce que vous en aurez de toute façon pas l'usage mais bien sûr ils sont totalement applicable.

On peut parfaitement s'en servir ici.

Voilà donc ici vous pouvez utiliser les opérateurs du issus du langage c il y a aucun problème ça marchera.

On peut parfaitement faire ça.

Voilà je vous dis à bientôt je ne vous ai pas montré trop trop de choses parce que voilà je ne voulais pas faire trop long, il n'y avait pas énormément de choses quand même et je voulais garder une petite vidéo là dessus parce que c'est quand même à part finalement du simple usage de variables mais n'hésitez pas avec ces petites syntaxes à vous entraîner, à faire des petits scripts en plus c'est facile et assez rapide de faire plein de petit script et de tester tout un tas de notations différentes et l'avantage c'est qu'avec des petits `echo` vous pouvez afficher le résultat et voir ce que ça vous donne.

Voilà donc c'est assez facile pour vous d'apprendre et de comprendre que telle notation va en fait agir de telle manière sur votre code et tel autre va plutôt traité le code d'une autre manière.

Rappelez-vous encore une fois un pour terminer des fameuses notation avec la simple quote, la double et celle qu'on avait vue pour la back d'accord la quote inverse ici.

```sh
#!/bin/bash

# ' " `
```

D'accord on avait remarqué la dernière fois qu'on avait une grosse différence entre ces trois là et bien là c'est pareil selon les commandes utilisées on va avoir des différences aussi.

Voilà on va s'arrêter là on ne va pas aller trop trop loin, on va garder d'autres choses de toute façon pour la suite.

J'espère que ça vous a apporté déjà quelques éléments je voulais vraiment insister là dessus et je vais assez souvent insister de toute façon pour ce dernier chapitre du cours linux parce qu'en Bash encore une fois il y a pas mal de choses et le but quand même c'est que vous appreniez les bonnes syntaxes et pas forcément des choses qu'on n'utilise plus totalement ou voire même simplement des choses qu'on n'utilise pas forcément dans certains contextes d'accord.

En fonction de l'usage que vous aurez vous n'employé pas forcément les mêmes commandes, les mêmes syntaxes donc on va essayer d'être le plus efficace à ce niveau là pour que vous ayez quelque chose de bien à l'arrivée.

Je vous dis à bientôt n'hésitez pas dans les commentaires si il y a des questions bien sûr comme d'habitude je serai disponible si besoin.

A bientôt pour la prochaine séance.

Ciao