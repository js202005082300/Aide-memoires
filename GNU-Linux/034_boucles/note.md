# [34. Boucles](https://www.youtube.com/watch?v=DIhSTLYIQgw)

Bonjour à tous, bienvenue sur cette séance 34 sur GNU linux où nous continuons de voir comment faire de la programmation de scripts bash et aujourd'hui nous allons voir ensemble comment réaliser des boucles.

C'est un concept très important en programmation informatique qu'on retrouve évidemment dans plein d'autres langages et je vais vous expliquer comment ça fonctionne surtout en termes de syntaxe au niveau de bash puisqu'il y a quand même quelques particularités bien spécifiques à ce langage.

## if double crochet

Pour ceux qui sont attentifs précédemment, j'ai oublié de vous parler d'une notation.

Je l'ai indiqué d'ailleurs dans la vidéo précédente qu'il manquait une notation parmi les trois que je voulais vous présenter donc je vais en profiter et faire une petite parenthèse dans cette vidéo là pour montrer un petit peu même s'il aura pas grand chose à dire parce que vous allez voir que ça vient s'ajouter en fait à ce qu'on a déjà vu dans la vidéo précédente.

On va passer directement sur un script donc rien de nouveau.

```bash
#!/bin/bash

```

Alors on avait vu la syntaxe avec `test` ou simplement les simples crochets `[]` qui est une syntaxe en fait très simple pour réaliser nos structures de contrôle.

Plus avant encore, on avais vu une syntaxe ici avec double parenthèse `(())` pour faire des évaluations d'expression d'accord d'expression arithmétique qu'on peut évaluer. C'est même pas mal pratique dans des cas bien précis de passer par cette syntaxe-là et j'avais oublié de vous parler d'une extension de bash qui utilise tout simplement une syntaxe sous forme de double crochet `[[]]`.

```bash
#!/bin/bash

(())
test [ ]
[[]]
```

Voilà alors ce qu'il faut comprendre c'est que ces syntaxes-là vous pouvez les utiliser dans vos scripts, il n'y a aucun problème même si vous partagez le script pour quelqu'un d'autre, un autre utilisateur qui est sur un autre système qui n'aura pas forcément le même shell que vous.

Ce sont en fait des notations qui sont portables puisque elles suivent une même norme qui est la norme Posix.

La norme Posix sans trop entrer dans le détail parce que vous pouvez toujours vous renseigner si vous voulez, c'est une norme en fait qui détaille les conditions d'accord un ensemble si vous voulez d'éléments techniques ok qui indique en fait peu importe les systèmes ou autre, si on veut respecter cette norme, on va faire fonctionner les choses de telle ou telle manière d'accord s'accorder en fait sur un consensus, sur un ensemble de règles à respecter pour unifier un petit peu tout ça, harmoniser un peu tous les outils et s'assurer que finalement d'un système à l'autre qui est Posix parce qu'on fait le raccourci de cette manière soit valide d'accord que ça fonctionne.

Ici cette notation `[[]]`, pourquoi je vous parle de Posix et bien cette notation justement ne l'est pas d'accord ce n'est pas une notation qui suit la norme Posix c'est une extension de bash qui peut exister sur d'autres shell.

Par exemple je crois que Ksh à partir d'une certaine version l'avait adopté aussi mais ce n'est pas garanti sur tous donc ça veut dire que si vous programmez un  script avec ce type de notation `[[]]` et que vous le partagez avec quelqu'un qui n'utilise pas bash mais éventuellement autre chose il n'est pas sûr que votre script fonctionne sur sa machine.

D'accord donc attention c'est beaucoup moins un portable que ce type de notation là `(()) test [ ]` alors pourquoi cette extension `[[]]` déjà parce que comme l'indique le terme c'est une extension donc ça vient ajouter un ensemble de fonctionnalités au langage bash parce que ça vient de là au départ et ça permet on va dire une certaine souplesse au niveau de la notation.

Alors je vais vous montrer un petit peu la différence, on va employer cette syntaxe là et ensuite celle là vous allez voir un peu la différence.

Ici vous allez pouvoir donc si on reprend une syntaxe finalement standard, on va faire ça on va faire un simple echo comme ceci `echo $@` pour afficher le nombre d'arguments que je passe ici à mon exécutable.

```bash
#!/bin/bash

echo $@
```
```bash
sam@sam:~$ touch main.bash
sam@sam:~$ chmod u+x main.bash
sam@sam:~$ ./main.bash

sam@sam:~$ ./main.bash hello world bye
hello world bye
sam@sam:~$ 
```

Je passe par exemple une information et on retrouve bien toutes les informations que nous avons d'accord.

Alors ça on voit qu'il y a trois arguments d'accord "hello world by" et ça nous affiche les trois arguments.

Maintenant si au niveau de mon script j'ai envie de spécifier deux arguments c'est-à-dire que je veux que "hello world" ce soit un argument donc je vais me servir de ces caractères là `""` parce qu'après tout ils  servent à délimiter finalement une chaîne et "bye" qui serait un autre argument.

Je vais m'amuser à faire ça si je veux avoir un protocole un peu particulier pour dire que chaque argument est entre double guillemets.

```bash
sam@sam:~$ ./main.bash "hello world" "bye"
hello world bye
```

Si je fais ça quand on regarde et bien honnêtement c'est parce que malheureusement j'ai pas de formatage ici au niveau de la séquence pour voir un petit peu à la ligne chaque élément mais en gros tout est traité de la même manière c'est à dire qu'il va traiter ça "hello" comme étant un argument, un deuxième "world" un troisième "bye" alors que nous on voulait qu'il traite ça "hello world" comme un seul argument et ça "bye" comme un deuxième.

Pour éviter ce genre de problème on va devoir ... j'en avais parlé un petit peu parlé précédemment parce qu'il y avait un cas particulier avec les notations dans le code que sont les doubles guillemets "", je vous avais expliqué qu'avec les double guillemets on va effectivement interpréter les variables qui sont entre d'accord on va avoir un cas assez particulier voilà où par exemple on ne le faisait pas notamment avec celle ci '' donc '' c'est pour du texte brut donc on interprétera rien du tout.

A partir de là alors vous verrez la différence à l'affichage mais ne vous inquiétez pas on va avoir l'occasion de revenir là dessus un petit peu plus loin dans cette vidéo mais on a maintenant ce premier argument "hello world" et on en a bien un deuxième "bye" d'accord il aura pris en compte en fait ces caractères là "" là où il ne les prenais pas tout à l'heure puisque pour lui il ne prend pas en compte par rapport à la notation si on échappe pas notre variable ici avec les doubles guillemets.

```bash
#!/bin/bash

echo "$@"
```

Pour éviter ce genre de choses notamment lorsqu'on fait des tests dans nos structures de contrôle donc si par exemple on a un path d'accord genre vous récupérez le répertoire courant `pwd` ici.

```bash
#!/bin/bash

path=`pwd`
```

Et ensuite pour faire une vérification tel que `if [ $path == '/home/robert' ]` vous devez souvent échapper avec des guillemets `if [ "$path" == "/home/robert" ]` bref on a vite fait de faire une erreur, c'est beaucoup moins flexible, c'est beaucoup plus rigoureux et beaucoup plus strict comme notation.

L'avantage de la syntaxe avec les double crochets c'est qu'elle évite en fait la confusion c'est que là vous pourrez parfaitement utiliser ça d'accord `if [[ $path == '/home/robert' ]]`. Vous pourrez en fait avoir ce genre de choses et il n'y aura plus de problème avec les variables qui ne sont pas forcément échappées d'accord c'est beaucoup plus souple.

Alors je rappelle ce n'est pas portable attention ça ne fonctionnera pas partout mais sachez qu'avec bash en tout cas vous pouvez vous en servir d'accord c'est tout à fait utilisable.

Voilà une des premières possibilités d'accord parce  que c'est qu'une extension, c'est pas non plus un truc révolutionnaire. C'est une extension qui vient ajouter des possibilités à ce qui existe déjà et vous allez aussi pouvoir utiliser des expressions rationnelles.

Si vous ne savez pas ce qu'est une expression rationnelle c'est pas grave, vous aurez bien l'occasion de voir que je l'aborde dans d'autres vidéos sur la chaîne donc vous l'apprendrez tôt ou tard si vous ne l'avez pas encore appris c'est pas grave c'est qu'on en avait à priori pas forcément besoin. 

Vous n'êtes pas à un niveau pour apprendre ce qu'est une expression rationnelle et comment vous en servir donc pas de problème là-dessus mais pour ceux qui savent de quoi je parle, sachez que vous pouvez parfaitement faire évaluer des expressions rationnelles avec cette notation là `if [[ $path == '/home/robert' ]]`.

C'est donc bien pratique aussi surtout quand on veut faire des vérifications sur une format bien précis de chaîne ou autre, vous savez pour ceux qui utilisent des expressions rationnelles que c'est très pratique et très puissants comme outil à ce niveau là.

Voilà donc en gros une petite extension à savoir, petite notation `[[` je devais en parler précédemment mais j'avais oublié donc je tenais à le faire ici en début de vidéo.

## while

Ok on va passer maintenant aux boucles, le sujet même de cette séance et on va voir un peu comment tout ceci fonctionne, s'agence parce qu'il y a quand même pas mal de notation mine de rien alors beaucoup moins que la vidéo précédente.

Dans la vidéo précédente, il y avait beaucoup de choses à noter, là il y aura quand moins de notation à connaître et à réutiliser par la suite.

Une boucle pour être simple parce que c'est un concept qu'on retrouve un peu partout en programmation informatique.

Si vous avez programmé ou que vous comptez programmer dans d'autres langages vous allez retrouver ça dans ces langages-là.

C'est une manière de répéter d'accord des instructions un certain nombre de fois.

Au plus simple on va simplement dire que tant qu'une expression, tant qu'une condition est vérifiée et validée alors on va répéter des instructions et on ne s'arrêtera que lorsque cette expression n'est plus valide, n'est plus vrai, n'est plus ... après ça ça dépend des langages attention on verra que dans bash il y a une particularité.

En gros dés que la condition en elle-même, le test n'est plus validé, n'est plus satisfait ou ne renvoie pas ce qu'on attend pour le valider on arrêtera tout simplement cette boucle.

A quoi ça peut servir ? à pas mal de choses, on peut répéter simplement un ensemble d'expression ça peut être répéter un affichage d'accord, ça peut être répéter par exemple une demande de saisie à l'écran tel que demander par exemple le mot de passe de quelqu'un on importe quoi.

Vous pouvez répéter la question autant de fois que nécessaire ou autre d'accord on peut imaginer parfaitement ce genre d'applications.

La boucle peut être aussi pour faire du parcours ça c'est peut-être moins évident pour les gens qui démarre en programmation de penser ça.

Vous avez beaucoup en informatique des éléments qui sont dits séquentiel.

Un élément séquenciel c'est un élément qu'on peut parcourir.

On peut par exemple parcourir une chaîne qui est composée de caractères d'accord c'est une séquence.

On peut également parcourir un fichier qui peut être composé de caractères voir même si c'est un fichier binaire qui peut être composé d'octets et donc on peut parfaitement faire de la lecture binaire aussi d'accord.

Alors on a des choses qui sont séquentielles qu'on va pouvoir parcourir donc on peut parfaitement utiliser une boucle pour ça pour dire par exemple que tant que tu n'es pas arrivé à la fin du fichier tu lis chaque ligne du fichier, tant que t'es pas arrivé à la fin d'un fichier binaire et bien tu récupères chaque octet et après tu fais même si là c'est un peu compliqué une **désérialisation** des données pour pouvoir les injecter dans des données membres au niveau du programme mais si ça ne vous parle pas ce n'est pas grave c'est pour vous expliquer un petit peu le principe.

Voilà comment ça va fonctionner et ça va nous servir à beaucoup beaucoup de choses et quand vous ferez bien évidemment de la programmation de scripts plus avancé vous en verrez très très vite l'utilité que ça a.

Nous pour cet exemple puisque c'est tout nouveau, on va devoir vous montrer des choses assez simple pour que vous comprenniez un peu le principe.

Le principe très simple de base c'est de se dire de réaliser une boucle donc on va faire une boucle la fameuse boucle tant que `while` et se dire que tant que quelque chose est vraie ou en tout cas quelque chose de validé alors qu'on réalise des instructions et ça prend la forme de cette syntaxe c'est-à-dire le mot clé `while`, le terme pour 'tant que' et on va simplement ici avoir notre expression.

```bash
#!/bin/bash

while <expression>
```

Je ne met pas du code ici `<expression>` entre chevrons mais c'est juste pour indiquer qu'on va remplacer par quelque chose, pas d'inquiétude à ce niveau là.

Ensuite on va rajouter le point virgule do `;do` d'accord et la fin de cette structure c'est le `done` d'accord.

```bash
#!/bin/bash

while <expression> ; do

done
```

Alors petite parenthèse parce que j'ai un doute, il ne me semble pas l'avoir détaillé dans les vidéos précédentes et comme j'ai peur que certaines personnes confondent ou un jour se pose la question bon on va anticiper...

Parfois vous avez peut-être vu qu'il avait du point virgule `;` ici et des fois non d'accord même sur le `if` il y a des moments où on avait un point virgule ou pas et des moments où le point virgule était collé à l'expression ou pas et pour éviter que des gens se demandent pourquoi il y a des moments où il y en a et d'autres non ? C'est simplement au niveau de la mise en page on va dire la présentation du code, si on veut par exemple avoir des choses sur une seule, plusieurs expressions sur une seule ligne, hé bien pour les  séparer on utilise le point virgule.

`while <expression> ; do` là comme le `do` est sur la même ligne que le `while` et son expression `<expression>` eh bien on les sépare avec un point virgule.

Si je mets le `do` à la ligne et ça arrangera peut-être pour ceux qui veulent avoir le `do` et le `done` sur la même colonne, ici au même niveau, vous enlever le point virgule.

```bash
#!/bin/bash

while <expression>
do

done
```

D'accord c'est juste par rapport à ça, c'est pas lié au fait qu'on utilise du `while`, du `if` ou autre c'est simplement que quand on a plusieurs expressions d'accord si par exemple j'ai une expression expr1 et une deuxième expr2.

```bash
#!/bin/bash

expr1 ; expr2 ; expr3

while <expression>
do

done
```

Et cetera, et cetera.

Je vais les séparer comme ça d'accord, c'est juste ça et comme j'étais pas sûr d'en avoir parlé au cours de cette formation, je pense que c'est pas mal de le dire et si c'est un rappel et bien tant mieux aussi.

Voilà je vais laisser le `do` ici comme ça pas besoin du point virgule et on va remplacer notre expression.

Alors ce qu'on va faire, au plus simple je vais mette une variable, on va faire une expression voilà ici d'accord donc je vais faire évaluer une expression arithmétique donc je met des doubles parenthèse `((1))`.

```bash
#!/bin/bash

while ((1))
do

done
```

On va rester sur quelque chose de très simple.

```bash
sam@sam:~$ ./main.bash
./main.bash: ligne 6: erreur de syntaxe près du symbole inattendu « done »
./main.bash: ligne 6: `done'
sam@sam:~$ 
```

Voilà ici on a une erreur donc ça c'est parce que j'ai
rien.

On va déjà faire ça.

```bash
#!/bin/bash

while ((1))
do
    echo 'Hi !'
done
```
```bash
sam@sam:~$ ./main.bash
Hi !
Hi !
Hi !
Hi !
Hi !
Hi !
Hi !
Hi !
^C
```

Là j'arrête le programme avec ctrl+C parce que comme vous le voyez le programme ne s'arrête pas d'accord.

Alors on a fait ce qu'on appelle une **boucle infinie** c'est à dire qu'on lui a donné quelque chose qui sera toujours validé d'accord voilà `((1))` ici sera toujours égal à 1 donc en fait ce sera toujours vrai dans ce genre de cas donc on rentre dans le `do` et on effectue ici ce qu'on appelle une **itération** ensuite qu'est ce qui se passe ? une fois qu'on a fait toute l'instruction là j'ai mis qu'un seul `echo`.

J'aurais pu mettre un autre `echo`, faire une autre boucle `while`, faire des conditions avec des `if` etc bref on peut évidemment mettre tout un tas de codes d'accord c'est le même principe on est toujours dans notre script dans de la programmation en langage Bash, il n'y a aucun problème mais quand on arrive à la fin de ces instructions c'est à dire avant ici le `done` en tout cas avant éventuellement d'autres instructions que je vais aborder un peu plus.
 
Ainsi on revient au niveau du `while` et on refait le test, si le test est toujours validé alors on attaque une nouvelle itération donc ici ce serait la deuxième et on refait toutes les instructions dans finalement le contexte, dans la zone du while.

Une fois que c'est fini, on vérifie est-ce que c'est toujours validé ? si oui eh bien on refait une nouvelle itération, etc.

On parle donc bien d'itérations d'accord.

Ici comme vous voyez ça ne peut jamais s'arrêter, il n'y a rien qui fait en fait que ceci `((1))` ne sera plus valide eh bien on en fait un nombre d'itérations infinie et on parle plus généralement, plus globalement de boucle infinie.

Voilà un peu comment que ça se passe.

## break

Alors à ce stade normalement vous comprenez que le seul moyen finalement de pouvoir interrompre ou stopper cette boucle c'est d'avoir un élément pour le faire.

Pour cela on va employer ce qu'on appelle un point d'arrêt alors il y a déjà deux mots assez particulier qui sont intéressants au niveau des boucles qui sont `break` et c'est quelque chose qu'on a vu avec notamment le `case` qui permet d'interrompre la boucle d'accord et donc là si je le fais qu'est ce qu'il va se passer ? ça vérifie ça `((1))` et si ça c'est valide ici, on fait ce qu'il y a dans le `do` on va faire un `echo` et là hop on sort de la boucle `break` càd d'interrompre en fait l'élément qu'on a ici en cours.

```bash
#!/bin/bash

while ((1))
do
    echo 'Hi !'
    break
done
```
```bash
sam@sam:~$ ./main.bash
Hi !
sam@sam:~$ 
```

On va donc sortir terminé donc on va avoir une seule fois l'affichage de ce qu'on a parce qu'on aura qu'une seule itération défectuée ok.

Alors dans ce genre de cas bon ça ne sert pas beaucoup parce que l'exemple est très simple mais c'est pour que vous compreniez.

## continue

On a également parce qu'on le voit pas par défaut mais ici on a une autre instruction qui est implicite le fait de refaire un saut.

On appelle ça un saut alors là on est vraiment dans la programmation élémentaire, dans les instructions les plus simples qu'on peut retrouver au niveau processeur qui veut dire par exemple de refaire un saut ici au début d'accord pour effectuer éventuellement une nouvelle itération et pour cela on en fait un mot clé qui est `continue`.

```bash
#!/bin/bash

while ((1))
do
    continue
    echo 'Hi !'
done
```

D'ailleurs si je fait ça comme ça et bien ce qui va se passer ... c'est quand on va entrer dans le `while`, dans la boucle, ici vous croisez cette instruction qui va dire ok je dois relancer tout de suite une nouvelle itération donc on n'aura même pas exécuté ce qu'il y à la suite dans la boucle on va directement revenir à `while ((1))`, on va faire `do` puis `continue` et on va boucler à l'infini mais sans rien faire.

```bash
sam@sam:~$ ./main.bash
^C
sam@sam:~$ 
```

Voyez faut que j'arrête avec un ctrl+C à mon clavier sinon le script s'exécute sans arrêt d'accord.

D'ailleurs quand vous avez une boucle infinie comme ça, ne laissez pas forcément tourner un programme pendant longtemps longtemps longtemps puisque ça va forcément pompé sur les ressources de votre ordinateur et il ne va pas forcément beaucoup apprécier donc éviter de laisser tourner ça en boucle non plus.

Voilà donc deux mots clés très important, le `continue` qui ici bien sûr n'a pas d'intérêt mais vous verrez plus tard quant vous ferez certains script peut-être en tout cas, il y a des moments où manuellement on veut lancer une nouvelle itération  parce que je ne sais pas on avait effectué certains tests bien précis et on se dit bon bah si on a réalisé les tests qu'on voulait dans la boucle, on n'a pas besoin de faire la suite, on ne veut pas lancer tout de suite une nouvelle itération donc on utilise cette instruction là, `continue`.

Elle n'est pas là pour faire joli, si elle existe c'est qu'elle a une utilité et voilà l'utilité qu'elle peut avoir.

Le `break` on comprend beaucoup plus c'est simplement l'instruction qui va interrompre la boucle donc ça on comprend.

Pareil si on a fait un test et puis à ce moment là on dit bon plus besoin de faire d'autres itérations on a eu ce qu'on voulait... voilà ça peut être par exemple de la recherche, imaginez vous cherchez une  information dans un fichier mais une fois que vous l'avez trouvé est-ce qu'il y a besoin encore de continuer de lire tout le fichier ?

Non si vous aviez besoin d'attendre de récupérer le résultat que vous vouliez, vous pouvez arrêter de lire votre fichier à ce moment là donc on sortirait volontier de la boucle et on comprend parfaitement ce genre d'application.

Voilà donc là j'ai pris le temps parce qu'il y a plein de termes à connaître la boucle, les itérations, etc, les instructions `continue` et `break` qui sont très très importante à ce niveau là.

## point arrêt et compteur

Nous on va faire un point d'arrêt parce qu'on ne veut pas utiliser ces termes là, on veut un point d'arrêt en fait au niveau de notre code.

Le plus simple parce que c'est quelque chose que vous allez retrouver très très souvent en programmation, c'est de passer par un compteur d'accord.

Pour le compteur, je vais faire une simple variable i qui sera initialisée à zéro et je vais réutiliser cette syntaxe `(())` qui est très claire elle suffit largement pour l'évaluation de notre expression arithmétique de dire que tant que i est strictement inférieure à 10 d'accord.

```bash
#!/bin/bash

i=0

while ((i < 10))
do
    echo $i
done
```

Et je veux par exemple qu'il m'affiche le contenue de la variable i.

```bash
sam@sam:~$ ./main.bash
0
0
0
0
0
^C
sam@sam:~$ 
```

Là si je ré exécute, je vais arrêter vous voyez qu'on a une boucle infinie c'est parfaitement normal, on a simplement dit que cette boucle d'accord va se faire tant que i sera strictement inférieure à 10 comme i était égale à zéro, on a à priori dans ce code aucun changement de valeurs de i donc il est logique que la boucle ne s'arrête jamais et qu'on retrouve la même chose.

Certains ont déjà compris à ce stade qu'il va falloir incrémenter d'accord modifier cette valeur de i pour qu'il arrive à terme à 10 voire même tout de suite mais si on le fait tout de suite, on va faire ça `i=10` et là forcément une fois qu'il aura changé de valeur ça va s'exécuté qu'une fois.

```bash
#!/bin/bash

i=0

while ((i < 10))
do
    echo $i
    i=10
done
```

Alors on va donc faire une incrémentation de i+1 c'est à dire qu'on va à chaque fois augmenté i de 1 d'accord c'est une incrémentation qu'on fait beaucoup avec un compteur quand on fait des boucles, quand on fait du parcours et pour faire ça attention en Bash la syntaxe est un peu particulière mais vous l'avez déjà vu... hé bien on l'a déjà employé précédemment, c'est toujours la syntaxe l'évaluation des expressions arithmétique, ceci.

```bash
#!/bin/bash

i=0

while ((i < 10))
do
    echo $i
    i=$(($i+1))
done
```

Voilà `$((i+1))`, vous pouvez mettre des espaces `$((i + 1))` puisqu'on utilise ce genre de syntaxe là comme vous voulez et voilà. Qu'est-ce que ça veut dire ? ça veut dire que i vaudra son ancienne valeur plus 1 ok.

Alors on peut utiliser bien sûr d'autres anciennes syntaxes, rappelez-vous avec `let` on a vu des syntaxes très simple pour faire du += voir même du i++ comme on le ferait en programmation, en langage c, en langage c++ ou autre mais là je vous passe un peu la syntaxe historique celle qu'on connaît bien qui est ce type d'incrémentation.

```bash
sam@sam:~$ ./main.bash
0
1
2
3
4
5
6
7
8
9
```

Et là évidemment si j'exécute ça va s'arrêter à un moment donné, une fois que i est égal à 10 terminé, on a de manière implicite une instruction `break` qui est exécutée et on sort de la boucle terminé.

```bash
#!/bin/bash

i=0

while ((i < 10))
do
    echo $i
    i=$(($i+1))
done

echo 'fin du programme...'
```
```bash
sam@sam:~$ ./main.bash
0
1
2
3
4
5
6
7
8
9
fin du programme...
```

Voilà on fait évidemment ce qu'il y a à la suite et on peut refaire d'autres choses au niveau de notre code, aucun problème.

Voilà comment que ça se passe donc très simple et c'est quelque chose à connaître parce que vous allez souvent devoir le faire.

Alors là le **point d'arrêt** c'est une fois qu'un compteur atteint une certaine valeur, je prenais l'exemple tout à l'heure du fichier, quel serait le point d'arrêt pour la lecture d'un fichier ? bien simplement quand on arrive à la fin du fichier et en informatique bien sûr il existe des caractères spécifique pour dire là nous sommes arrivés à la fin d'un fichier.

En gros quand on arrive à la fin d'un fichier ça va renvoyer un caractère qui va indiquer end of file, la fin du fichier, EOF pour ceux qui font un peu programmation dans d'autres langages.

EOF, une fois qu'on rencontre ce caractère on sait qu'il n'y a plus rien à lire donc on peut s'arrêter.

Voilà donc il y a plein d'éléments comme ça en informatique qui sont bien sûr fait pour avoir des points d'arrêt à disposition au niveau nos programmes.

Ok pour cette syntaxe donc vous voyez pas grand chose de compliqué en soi si vous êtes déjà bien à l'aise avec toutes les syntaxes qu'on a vu : parenthèse simple `()`, crochet `[]` de cetera tout ça c'est que de la révision après il y a quelques nouveaux mots clés mais sinon des choses que nous avons déjà vu précédemment.

## until

Alors petite chose importante et intéressante au niveau de Bash qu'il n'y a pas forcément dans d'autres langages c'est que vous pouvez faire une boucle inverse c'est à dire que là vous voyez par exemple on valide l'information d'accord si l'information est valide donc en gros est vrai, on entre dans la boucle et vous pouvez faire l' inverse avec le mot-clé `until`.

```bash
#!/bin/bash

i=0

until ((i < 10)) # i >= 10
do
    echo $i
    i=$(($i+1))
done

echo 'fin du programme...'
```
```bash
sam@sam:~$ ./main.bash
fin du programme...
```

`until` qui veut dire en fait que tant que finalement i est inférieur à 10 mais avec `until` c'est l'inverse, c'est la négation donc là alors évidemment si je fais ça voilà fin du programme parce qu'évidemment c'est pas bon d'accord.

Pourquoi ce n'est pas bon ? il faut que i avec ce test-là `until ((i < 10))` et donc en gros on
vérifie simplement ceci **i >= 10**.

Alors ce sera vrai si i est supérieur ou égal puisque c'est l'inverse de strictement inférieure à 10 et comme ce n'est pas le cas puisqu'il est égal à zéro, on ne fera jamais ce qu'il y a dans la boucle.

Voilà donc c'est simplement l'opération inverse.

C'est dans le cas où notre test est faux en fait d'accord il n'est pas validé.

C'est un peu compliqué à comprendre mais il faut le voir comme l'inverse d'accord l'inverse en fait de la boucle `while` c'est tout simplement ici la boucle `until`.

Voilà donc ça attention ce n'est pas disponible dans d'autres langages de programmation, c'est pas forcément partout.

Autant le `while` on le retrouve quasiment dans tous les langages, sur tout les langages qu'on utilise aujourd'hui et langage on va dire assez reconnus mais `until` n'est vraiment pas disponible partout voire même dans quasiment aucun autre langage que Bash.

Attention à ce niveau-là de ne pas forcément penser que tout est disponible partout mais sachez que ça existe, ça peut être pas mal utile ok.

## for

Qu'est ce qu'on peut voir d'autres ? après on va voir qu'une seule autre syntaxe qui est la boucle `for` qui est une boucle pareil qu'on retrouve dans pas mal d'autres langages et en plus il y a des notations assez particulière au niveau de Bash.

Première chose c'est d'utiliser ça.

```bash
#!/bin/bash

for <tmp> in <sequence>
do
    echo 'Hello'
done
```

D'accord ici, on va vérifier une information, on va utiliser une variable si vous voulez temporaire donc je mets toujours <tmp> d'accord et ici notre séquence <sequence> d'accord, on met le `do` à la ligne.

Et là c'est une boucle, on exécute un certain nombre de choses.

Ok donc ça c'est surtout utile comme vous voyez pour de la lecture pour comprendre en tout cas plus exactement quand on fait de la lecture séquentielle d'accord rappelez-vous on avait vu au début.

```bash
#!/bin/bash

for arg in $@
do
    echo $arg
done
```

Par exemple `for arg in $@`, on dirait qu'on mettrait des guillemets "$@" pour ne pas avoir de problème mais au début on va laisser tel quel $@ et on verra par la suite si on veux changer ça mais pour le moment on ne va pas s'embêter comme ça vous verrez la différence avec les doubles guillemets, et on fait `echo` de $arg.

On réexécute,

```bash
sam@sam:~$ ./main.bash hello world bye
hello
world
bye
sam@sam:~$ 
```

Je fait ça et ça on se rend bien compte comme il y a un passage à la ligne.

On a bien tous nos arguments ligne par ligne, on arrive bien à les lire.

Maintenant je vais faire ça.

```bash
sam@sam:~$ ./main.bash "hello world" bye
hello
world
bye
sam@sam:~$
```

Et là vous voyez que en fait ça change strictement rien hop et là pareil, aucun changement.

```bash
sam@sam:~$ ./main.bash "hello world" "bye"
hello
world
bye
```

C'est embêtant et c'est pour ça que je vous avais expliqué et je reviens dessus maintenant je peux vous montrer visuellement pourquoi.

```bash
#!/bin/bash

for arg in "$@"
do
    echo $arg
done
```
```bash
sam@sam:~$ ./main.bash "hello world" "bye"
hello world
bye
sam@sam:~$ 
```

C'est vrai que quand on fait ça "$@" tout de suite hop ça marche mieux d'accord voilà toute l'importance encore une fois de faire ça.

Alors si on veut éviter ça quand vous faites votre test rappelez-vous les double crochet vous évite de devoir échapper ça `$@ -> "$@"` mais encore une fois ce n'est pas portable ça ne fonctionnera pas partout donc voilà maintenant comment avec une boucle `for` on peut faire finalement ce genre de vérification d'accords très simplement.

Voyez on parcourt une séquence ici `$@`, c'est une séquence parce que cette variable spécial qu'on a déjà vu précédemment, rassemble en fait l'ensemble des arguments qui sont passés ici lorsqu'on fait le lancement d'exécution d'un programme, `hello world bye` donc comme c'est quelque chose qu'on peut parcourir, qui est séquentielle et bien ici on va créer à chaque itération de notre boucle une variable temporaire dans laquelle on va stocker l'élément voilà à l'itération t d'accord à tel itération on va mettre cet élément.

Au début on va donc stocker le premier argument `hello` dans arg donc c'est pour ça que ça l'affiche bien ensuite  on va stocker celui qui vient à la suite et cetera.

Forcément le point d'arrêt bas il est implicite ça s'arrête quand ça a lus tous les éléments, quand il a plus d'arguments à lire de cette variable $@ il sait qu'il arrive à la fin de la séquence et comme il arrive à la fin de la séquence naturellement la boucle s'arrête, c'est notre points d'arrêt d'accord.

Voilà donc ça très pratique aussi comme notation qui est peut-être plus lisible d'ailleurs comme on voulait faire du parcours d'avoir ce type de notation là, ça vous parlera peut-être beaucoup plus d'avoir ce genre là, `for arg in "$@"`.

Pour ceux parmi vous, on va terminer avec ça, qui font de la programmation en c, en c++, en java et cetera, il y a une syntaxe que vous connaissez bien avec la boucle for, beaucoup plus que celle-là, `for arg in "$@"`, celle-là ne vous parlera pas et d'ailleurs n'existe pas dans plein d'autres langages mais c'est la fameuse syntaxe avec trois expressions c'est à dire la syntaxe où on a finalement l'initialisation un point virgule un test et ensuite évidemment l'opération qu'on fait donc on va dire généralement c'est une opération d'incrémentation, décrémentaion, etc d'accord c'est en trois phases.

```bash
#!/bin/bash

# ((initialisation ; test ; incrémentation))

for arg in "$@"
do
    echo $arg
done
```

Nous avec Bash comme il faut évaluer une expression ça va être des doubles parenthèse comme ceci d'accord. Pas besoin d'espacer avec les parenthèses, c'est pour les crochets qu'il faut espacer.

```bash
# ((initialisation ; test ; incrémentation))
```

Voilà on va faire comme tout à l'heure très simple avec i=0 donc ça c'est l'initialisation d'accord le point de départ, voyez on n'a pas besoin de créer la variable avant, on la met directement ici au niveau de la boucle. Puis un petit point-virgule, ensuite le test c'est comme tout à l'heure par exemple tant que i est plus petit, strictement inférieure à 10 et ensuite qu'est ce qu'il y a à faire ? en fait pour éventuellement définir un point d'arrêt soit quelle opération fait-on finalement à chaque itération ? un incrémentation, le fameux i++.

```bash
#!/bin/bash

# ((initialisation ; test ; incrémentation))

for ((i = 0 ; i < 10 ; i++))
do
    echo $i
done
```
```bash
sam@sam:~$ ./main.bash
0
1
2
3
4
5
6
7
8
9
sam@sam:~$ 
```

Voilà on retrouve notre même boucle ici mais avec une syntaxe qui vous parlera beaucoup plus encore une fois si vous faites de la programmation dans d'autres langages, ça c'est une syntaxe que vous connaissez bien et bien vous serez ravis de voir que ça fonctionne également avec Bash et ça fonctionne très bien.

Encore une fois, pourquoi `for` est pratiques ? parce qu'ici voyez que l'itération, on n'a pas besoin de la faire au sein de la boucle donc pas de risque d'oublier comme dans un `while` càd d'oublier de faire la fameuse syntaxe voilà avec le `i=$(($i+1))`.

```bash
#!/bin/bash

# ((initialisation ; test ; incrémentation))

for ((i = 0 ; i < 10 ; i++))
do
    echo $i
    # i=$(($i+1))
done
```

D'accord comme ceci `i=$(($i+1))`, pas besoin de la faire vous-même car vous la renseigné ici mais voilà elle est directement dans la structure de votre boucle for donc pas de risque en tout cas de l'oublier par la suite.

Voilà c'est une autre possibilité, c'est une autre syntaxe qui existe comme ça vous pouvez vous en servir.

Pour résumer au niveau de cette séance, nous avons vu la boucle `while`, nous avons vu la boucle `until` qui est son inverse en fait et on a vu pour la boucle `for` deux syntaxes, une syntaxe un peu à la c, à la c++, à la java et cetera et une syntaxe du style `for` une variable temporaire `in` qui est un peu l'équivalent du foreach qu'on aurait par exemple dans d'autres langages de programmation mais pas tous.

Voilà le foreach, on l'utilise principalement pour faire du parcours parce que c'est lisible en fait de se dire bah pour chaque lettre d'un mot voilà affiche chaque lettre.

Voyez on pourrait presque avec des termes français  simplement indiquer en fait naturellement comment se lit le code donc c'est beaucoup plus on va dire logique, beaucoup plus évident d'utiliser ce genre de syntaxe-là.

Voilà je pense qu'on a fait le tour et qu'on va s'arrêter ici, je voulais vous montrer un petit peu tout ça.

Est-ce que j'ai d'autres choses à vous montrer là dessus ? je ne pense pas, on a fait le tour pour les boucles.

De toute façon, on va attaquer un passage, on va revenir en détail sur les chaînes de caractères avant de parler des fonctions et les tableaux aussi.

Les tableau parce que c'est un cas particulier, je voulais les garder pour plus tard et après on aura terminé ce cours.

On arrive mine de rien aux dernières séances et on va s'arrêter la, de toute façon on a fait le tour sur les boucles et bien sûr vous allez avoir tout le loisir et toute l'occasion de continuer de vous entraîner, de vous exercer.

Encore une fois l'avantage de ce cours c'est que vous avez moyen de faire plein plein plein de petits programmes pour vous entraîner voire même si vous avez besoin par exemple de vous faire des petits utilitaires pour votre système Linux que vous utiliser au quotidien ou à côté de votre windows ou macos ou je ne sais quoi vous allez pouvoir développer des scripts et pour pouvoir faciliter certaines tâches administratives ou autre que vous avez besoin de faire par exemple pour de la maintenance, de la sauvegarde de fichiers, etc donc c'est un bon exemple de toute façon avec Bash est est fait pour ça.

Bash est un langage de script qui est fait pour vous faciliter la vie, vous apporter en fait des fonctionnalités comme un utilitaire en fait au niveau de votre système, de vos fichiers, etc donc n'hésitez pas à l'utiliser, de l'utiliser même dans des cas concrets.

Bien sûr si vous travaillez sur des fichiers, pensez à faire des sauvegardes de fichiers attention parce que s'amuser à faire des suppressions de fichiers sur des scripts que vous testez, attention au dégats.

Oui c'est la règle dans l'informatique, on fait des backups, on fait des sauvegardes toujours avant mais voilà vous avez de quoi vous entraînez, de quoi vous exercez plutôt que de prendre des exercices bateau de choses qui ne vous seront pas utiles.

Quitte à vous exercez, faites ça sur des cas concrets, sur des choses qui peuvent vous servir.

De toute façon et c'est toujours ce que je répète dans mes cours, à priori si vous apprenez un langage de programmation c'est pour en faire quelque chose.

Personnellement je vous déconseille, après c'est un avis perso mais d'apprendre un langage juste pour apprendre un langage.

Si c'est juste pour indiquer sur un cv que vous avez un jour programmé dans votre vie sur ce langage, honnêtement ça ne vaut pas la peine parce qu'il y a une différence entre connaître un langage parce qu'on en a déjà fait un petit peu dans son enfance, son adolescence et connaître un langage parce qu'on bosse dessus un peu tous les jours parce qu'on a une mise à niveau régulière sur ce langage, une vieille technologique, etc, etc.

Apprenez donc un langage si ça a une utilité pour vous, s'il n'a pas d'utilité, est-ce que ça vaut le coup de l'apprendre ? pas sûr d'accord.

Voilà c'est à vous de voir, en tout cas si vous avez prévu quelque chose dans l'apprentissage de ce langage Bash et bien c'est le moment de mettre tout ça en pratique parce qu'on arrive de toute façon au bout et vous avez déjà largement de quoi faire avec tout ça.

N'hésitez pas si il y la moindre question dans les commentaires de vidéos et je vous dis à bientôt pour une prochaine séance.

On parlera des chaînes de caractères la prochaine fois, c'est très important on aura une grosse vidéo dédiée là dessus parce qu'on va pouvoir faire pas mal de choses avec ça.

A bientôt ciao