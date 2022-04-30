# [Créer exécutable JAR](https://www.youtube.com/watch?v=f5hvSH6x-eY)

On va créer un format d'archive en java .jar qui va permettre d'exécuter diretement nos programme. Dans un vrai projet, on peut avoir plusieurs fichiers .java avec tout un tas de fichier .class comme on l'a vu quand on crée une compilation avec la commande `javac`. Le problème pour partager notre programme, on aura tout un tas de fichiers ce qui est moins pratique qu'une archive que la personne aurait qu'à cliquer dessus et la lancer depuis un terminal pour exécuter notre programme. 

```txt
C.
|_ FV
    |_ files
    |_ MainApp.java
```

On commence par pré-compiler notre programme.

```powershell
> cd C:\.\Aide-mémoires\Java\tutos\créer_exécutable_JAR\FV
> ls


    Répertoire : \Aide-mémoires\Java\tutos\créer_exécutable_JAR\FV


Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
da---l        18/08/2021     12:42                files
-a---l        18/08/2021     12:42            138 MainApp.java
> javac .\MainApp.java
```

Si on a plusieurs fichiers java, il suffira de faire `javac *.java` au lieu de `javac MainApp.java`.

On obtient un fichier `MainApp.class` et on va créer un manifeste, un petit fichier qui va nous indiquer le point d'entrée de notre programme.

c'est à dire qu'on veut savoir sur quel classe le programme démarre même si encore une fois pour mon exemple c'est très simple parce que je n'ai qu'un seul fichier mais si on a plusieurs fichiers avec l'extension .class, il faut savoir avec quel fichier Java va devoir démarrer en premier, dans lequel de ces fichiers il y a la fameuse méthode main() qui est le point d'entrée de notre programme tel qu'on l'a vu au départ de la formation.

Par habitude notre fichier manifeste sera simple fichier .txt qu'on va renommer MANIFEST.MF qui est le non conventionnel.

```txt
C.
|_ FV
    |_ files
    |_ MainApp.java
    |_ MainApp.class
    |_ MANIFEST.MF
```

La première chose à indiquer dans ce fichier c'est la classe de départ avec le point d'entrée, `Main-Class: `.

+ MANIFEST.MF
```MF
Main-Class: MainApp

```

C'est plus tard nous avons d'autres archives .JAR c'est à dire d'autres exécutables que notre programme utilise, on pourra les préciser avec une autre ligne en mettant `Class-Path: ` qui sera tout simplement un lien qui nous permettra d'atteindre un dossier jar qui possède plein de fichiers avec l'extension .jar ainsi je pourrais très bien faire ce genre de choses et de la même manière éventuellement en indiquaient plusieurs bref on pourrait comme ça on indiquait plusieurs.

```txt
C.
|_ FV
    |_ files
    |_ jar
    |   |_ fichier.jar
    |_ MainApp.java
    |_ MainApp.class
    |_ MANIFEST.MF
```
+ MANIFEST.MF
```MF
Main-Class: MainApp
Class-Path: \jar\fichier.jar

```

Alors ce qui est très important au niveau de ce fichier MANIFESTE.MF est de laisser un retour à la ligne sinon on risque d'avoir des erreurs donc vérifiez d'avoir une ligne vide à la fin de ce fichier.

Par convention, ce fichier MANIFESTE.MF est dans un dossier META-MF mais on est pas obligé de le faire parce que quand on va créer notre exécutable .jar,il va automatiquement créer ce répertoire mais on ne le créera pas dans cette vidéo.

```txt
C.
|_ FV
    |_ files
    |_ META-MF
    |   |_ MANIFEST.MF
    |
    |_ MainApp.java
    |_ MainApp.class
```

Voilà on a notre/nos fichier(s) de classes, notre manifeste (même si il pourrait être dans un répertoire META-MF) et de là nous allons créer notre fichier .jar

```txt
C.
|_ FV
    |_ files
    |_ MainApp.java
    |_ MainApp.class
    |_ MANIFEST.MF
```

On utilise la commande `jar` qui est le nom de l'archive en Java, c'est une archive exécutable qui va pouvoir être exécuté par la machine virtuelle en Java. On va lui passer 4 options mais elles ne sont pas tout obligatoires, la première c'est le petit c `jar c` pour dire que nous allons créer un fichier .jar et non pas simplement le lire ou l'interpréter donc un c pour create. Si on veut avoir toutes les informations du fichier .jar, on peut passer en mode verbeux donc on utilisera l'option v `jar cv` mais si vous ne voulez pas avoir les informations intermédiaires vous ne le mettez pas parce que ce n'est pas obligatoire mais nous on va le mettre pour le tutoriel. Ensuite on va mettre l'option m pour dire qu'on va utiliser un fichier manifest `jar cvm` parce que si on ne le fait pas c'est Java qui va essayer de déterminer le lancement de notre programme mais comme nous on a des choses bien apprécié c'est qu'on en utilise un, on va l'indiquer en option. Enfin comme on crée un fichier .jar, envoie utiliser l'option f, `jar cvmf` pour avoir les 4 options.

```powershell
> jar cvmf
```

Ensuite on indique le fichier manifest, le chemin du fichier manifest, ensuite le nom du fichier que l'on veut obtenir avec l'extension .jar et ensuite tous les fichiers class qui vont être inclus dans cette archive parce que vous verrez que c'est une simple archive ce type de fichier et comme je peux en avoir éventuellement plusieurs on va simplement mettre une étoile `*.class` comme ça on prend tout.

```powershell
> jar cvmf .\MANIFEST.MF prog.jar *.class
added manifest
adding: MainApp.class(in = 434) (out= 298)(deflated 31%)
> 
```

Quelques informations sont affichées grâce à l'option v, il nous indique le nom de quelques fichiers avec un certain niveau de compression parce qu'il y a effectivement une compression qui a été effectuée puisqu'il s'agit d'une archive.

Alors peut être ici que l'archive est un peu plus grande parce que je n'avais qu'un seul fichier donc au niveau taille elle devrait être un peu plus grande et en effet 776 octets alors que si on regarde le fichier MainApp.class ne fait que 434 octets. Voilà prog.jar prend un peu plus de place parce qu'il faut bien que ça enregistre l'information de l'archive mais dans notre programme, on a bien une archive qui a été créée.

```txt
C.
|_ FV
    |_ files
    |_ MainApp.java
    |_ MainApp.class
    |_ MANIFEST.MF
    |_ prog.jar
```

Voilà prog.jar est une archive donc c'est comme un .zip et donc si vous essayer de l'ouvrir avec votre gestionnaire d'archive, on retrouvera toutes les informations dans lequel vous allez voir que dans lequel le répertoire META-MF a été créé tout seul et à l'intérieur on retrouvera notre fameux fichier manifest.

+ MANIFEST.MF
```MF
Manifest-Version: 1.0
Main-Class: MainApp
Created-by: 10.0.1 (Oracle Corporation)
```

Voilà on a des informations en plus, avec un numéro de version et il nous met qu'il a été créé directement parce qu'on a utilisé la commande `jar` voilà il est possible que le fichier soit un peu différent mais c'est le même car on retrouve notre commande `Main-Class: MainApp`.

On peut ranger notre programme dans un répertoire build et le partager à un amis, sur internet pour qu'il teste votre programme.

```txt
C.
|_ FV
    |_ files
    |_ build
    |   |_ prog.jar
    |_ MainApp.java
    |_ MainApp.class
    |_ MANIFEST.MF
```

## Executer l'archive

La commande pour l'exécuter c'est `java` c'est-à-dire la machine virtuelle de Java donc n'importe qui qui installer Java, pas les outils de développement mais juste le JRE, le Java Runtime Environment, il pourra utiliser cette commande dans son terminal `java -jar` avec l'option -jar pour dire qu'on va interpréter, exécuter un fichier .jar puis le nom en question `java -jar .\prog.jar`.

```powershell
> java -jar .\prog.jar
Salut les p'tits mousses !
```

Voilà ça s'affiche évidemment parce que c'est un programme en console.

Maintenant si vous voulez que l'utilisateur puisse double-cliquer sur l'archive pour l'exécuter, vous pouvez faciliter la tâche à l'utilisateur en crayon affiché de script pour Windows launch.bat (launch.sh sur Linux/MacOS).

+ launch.bat
```bat
@echo off

java -jar prog.jar
pause

@echo on
```
+ run.sh
```sh
#!/bin/bash
java -jar prog.jar
```

Voilà notre fichier .bat, un fichier batch qu'est un langage de script de Shell pour Windows qui permet simplement de double-cliquer dessus pour lancer le programme.

Voilà pour ne pas avoir les commandes dans le terminal on va les masquer avec `@echo off` pour dire de cacher les informations et de cacher les commandes qui suivront et bien sûr on remet à `@echo on` à la fin de script.

On a plus qu'a transmettre le contenu de ce dossier build avec notre programme de lancement à un utilisateur, à l'intérieur d'un fichier .zip quel qu'il soit.

Alors dans un programme graphique, on n'aura pas besoin de ce script de lancement il suffira tout simplement de cliquer sur notre archive .jar et cetera.

Petite distinction si on utilise la commande `java`, on lance une console automatiquement mais si on veut pouvoir proposer quelque chose comme ça sans lancer de console parce que même dans un programme graphique on pourrait très bien se dire qu'on lance une console quand même admettons pour du débogage et voir si le programme tourne bien ou en cas d'erreur afficher des logs mais on peut volontairement dire d'afficher un programme sans affichage de la console et dans ce cas là au lieu d'utiliser la simple commande `java`, il faudra utiliser `javaw` qui signifie java Window, en mode fenêtré, c'est-à-dire En d'autres termes de ne pas exécuter Java avec une console puisqu'on travaillera en mode fenêtré.

+ launch.bat
```bat
@echo off

javaw -jar prog.jar
pause

@echo on
```

`javaw` signifie qu'on va exécuter en mode fenêtré sans affichage de console et si on met la commande standard `java` ça s'exécutera avec l'ouverture, ce qui va ouvrir la console de notre système pour exécuter le fichier .jar

Voilà comment exécuter notre fichier avec ou sans console avec l'utilisation d'un petit script pour faire gagner du temps à l'utilisateur à qui on partegare l'archive build.zip

```txt
C.
|_ FV
    |_ files
    |_ build
    |   |_ prog.jar
    |   |_ launch.bat
    |   |_ run.sh
    |   |_ build.zip
    |
    |_ MainApp.java
    |_ MainApp.class
    |_ MANIFEST.MF
```

À Bientôt tout le monde