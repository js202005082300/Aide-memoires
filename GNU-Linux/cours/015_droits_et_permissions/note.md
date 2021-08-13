# [15. Droits et permissions](https://www.youtube.com/watch?v=AvdVbh3j-50)

Maintenant on sait comment fonctionne un utilisateur et les groupe. Un utilisateur peut appartenir à plusieurs groupes. Ce système de groupes permet de contrôler, filtrer ce qui est sur le système.

On va travaller en terme de droits sur les fichiers et sur Linux tout est fichier. Un périphérique est un fichier par exemple pour l'accès à un disque dur externe.

On commence par une petite parenthèse, history.

## history

Le terminal peut retrouver toutes les commandes précédente stockées dans un fichier qui permet de stocker cette historique.

	/home/sam/.bash_history #ctrl+H (fichier caché)

Il faut savoir qu'on a un identifiant pour chacune de ces commandes.

On peut supprimer le fichier via l'interface graphique ou via la commande `rm` mais on peut supprimer l'historique du shell actuel, `history -c` et pour supprimer l'historique de tout les shells, `history -w`. Et `man history` pour en savoir plus.

```bash
history #afficher l'historique des commandes.
!18 #éxécuter la commande 18.
history -c #vider l'historique.
history -w #vider l'historique de tout les shell.
man history
```

## ls

On revient sur la commande de listing et on va expliquer ces lettres, `drwxrwxrwx` qui concerne le système de droits et le type de fichier.

```bash
ls -l
	...
	drwxrwxrwx 1 root root 8192 déc 24 23:24 windows
	-rw-rw-r-- 1 sam sam  8025 déc 25 23:05 doc.txt
	drwxr-xr-x 3 sam sam 4096 déc 25 23:02 Bureau
```

## type de fichier

Sur Linux tout est fichier mais il faut pouvoir distinguer un fichier d'un répertoire.

```bash
sam@sam:~$ touch doc.txt
sam@sam:~$ ls -l
total 40
drwxr-xr-x 2 sam sam 4096 fév 25 21:26 Bureau #répertoire.
-rw-rw-r-- 1 sam sam    0 fév 28 01:16 doc.txt #fichier.
``` 

Voilà par exemple un `l` pour les liens symboliques. Pour les périphériques, la lettre `b` pour tout ce qui est bloc, la lettre `c` pour tout ce qui est caractère selon le type de périphérique. Un répertoire `d` et un fichier `-`.

Voilà un premier symbole pour le **type de fichier**.

## système de droits

Ensemble de droits au niveau des répertoires ce qui fait toute la sécurité du système.

1er groupe, droit de l'utilisateur actuel.
2e groupe, droit pour le groupe mais pas moi, je ne suis pas inclus dedans.
```bash
drwxr-xr-x #voilà mes droits rwx, et ceux des autres utilisateurs du groupe r-x.
```
3e groupe, autres utilisateurs, autres groupes. Les autres c'est ni moi ni les gens qui sont dans le groupe.
```bash
drwxr-xr-x #les droits des autres, r-x.
```

Pour ceux qui ont fait du web si vous connaissez le système de droits parce que la plupart du temps les serveur sont basés sur Linux mais c'est le système qui va permettre de gérer tout ce qui est la lecture `r`, l'écriture, `w` et l'éxécution `x` (ou accès pour un répertoire ou droit d'exécuter une commande ls dessus).

### exécution

read, write et l'exécution. On parle d'exécution pour un fichier. Pour un fichier ordinaire, le fait d'avoir un ´x´ c'est qu'on peut éxécuter le fichier. _doc.txt_ n'est pas un script, on ne peut pas exécuter le fichier. On a juste besoin de le lire ou d'écrire dedans.

```bash
sam@sam:~$ ls -l
-rw-rw-r-- 1 sam sam    0 fév 28 01:16 doc.txt
```

Dans le cas d'un répertoire avec un droit d'exécution signifie qu'on a le droit d'accéder à ce répertoire et à ses sous-répertoire.

Il faut comprendre que la lecture c'est ouvrir le fichier alors que le x, exécution, ça peut être exécuter un script ou bien traverser un répertoire càd y accéder.

Voilà ces 3 points-là, le `r` pour la lecture, le `w` pour l'écriture et le `x` pour tout ce qui est exécution.

```txt
r : lecture
w : écriture
x : exécution (ou accès pour un répertoire)
```

Il faut retenir que sans l'accès au répertoire, on ne pourrait pas aller dedans.

### base octale

Le système de droit va fonctionner sur une base octale (0->7).

Ce sont les système de base numérique (octale, héxadécimale, binaire etc) comme a pas mal vu. Il faut juste retenir que le système décimale va de 0 à 9 et le système octale va de 0 à 7.

Alors pour le `r` la taille va être de 4, tout ce qui est écriture `w` c'est 2 et tout ce qui est exécution `x` c'est 1. A partir de là, on obtient des droits particuliers.

```txt
r = 4 / w = 2 / x = 1
```

Si je veux que la lecture, c'est 4. Pareil pour le groupe 4 et pour les autres, il n'y aura rien donc 0. `440` là on obtient le droit complet sur un fichier. Je pourrais assigné le droit `440` à un fichier dans le répertoire.

## chmod
Gestion des systèmes droits.

On va voir comment appliquer un droit mais d'abord notre fichier doc.txt `-rw-r--r--` moi je peux lire et écrire dedans `rw-` et les gens de mon groupe n'ont que la lecture seule `r--` et les autres `r--` n'ont que la lecture càd les autres personnes hormis moi ne pourrons pas modifier le document. Si quelqu'un d'autre éssayait d'accéder à ce document, il ne pourrait pas mais il n'aurait pas la permission.

Cette commande peut fonctionner de manière récurssive, rappelez-vous le `-R`.

Pour ajouter des droits à moi, j'utilise le symbole `chmod u+` et ce que j'ajoute à moi-même. Pour le groupe, je vais faire `chmod g+` et si c'est pour tout les autres je fait `chmod o+` pour other. Et si c'est à tout le monde, je met `chmod a+` pour all.

```bash
chmod u+ #ajouter à l'utilisateur.
chmod g+ #ajouter au groupe.
chmod o+ #ajouter aux autres.
chmod a+ #ajouter à tous (All).
```

Si on veut ajouter le droit en écriture pour le groupe sur le fichier doc.txt et un `ls -l` pour voir la différence.

```bash
ls -l doc.txt
	-rw-r--r-- 1 sam sam 0 fév 28 20:12 doc.txt
chmod g+w doc.txt #ajouter droit d'écriture au groupe pour doc.txt.
ls -l doc.txt
	-rw-rw-r-- 1 sam sam 0 fév 28 20:12 doc.txt
```

On avait `-rw-r--r--` et maintenant on a `-rw-rw-r--` et les gens qui sont dans mon groupe vont pouvoir écrire dans le document.

On peut leur rétirer le droit en écriture.

```bash
chmod g-w doc.txt #retirer droit d'écriture au groupe pour doc.txt.
ls -l doc.txt
	-rw-r--r-- 1 sam sam 0 fév 28 20:12 doc.txt
```

On a `rw-` pour moi même donc 4+2=6 traduit en octale pour la partie à moi. Pour le groupe, c'est 4 et pour les autres c'est 4.

`-rw-r--r--` pour le fichier doc.txt correspond à la valeur `644` en octale.

Accorder les mêmes droits au groupe et aucun droit aux autres, alors c'est `660`.

```bash
chmod 660 doc.txt #ajouter droits sur une base octale (-rw-rw---- = 660).
ls -l doc.txt
	-rw-rw---- 1 sam sam 0 fév 28 20:12 doc.txt
```

Pour les autres `---` pour dire qu'il n'ont plus aucun droit càd même pas le droit de `ls -l`, il ne sauront pas qu'il existe. Voilà il faut des droit pour juste afficher des informations.

Voilà retenez que la lecture en octale c'est 4, l'écriture c'est 2 et l'exécution c'est 1 mais si vous voulez tout les droits c'est 7, chiffre maximun de la base octale.

Si vous voulez mettre tout les droits à tout le monde ce qui serait assez bizzare, il suffit de faire :

```bash
chmod 777 doc.txt #max des droits.
ls -l doc.txt
	-rwxrwxrwx 1 sam sam 0 fév 28 20:12 doc.txt
```

Tout le monde a tout les droits sur ce document là.

Ici retirons les droits en lecture et en exécution pour le groupe et les autres.

```bash
chmod go-wx doc.txt #retirer des droits.
ls -l doc.txt
	-rwxr--r-- 1 sam sam 0 fév 28 20:12 doc.txt
```

Spécifier les droits en octale de manière générale si on est dans une université ou autre et qu'on ne veux pas que les autres accèdent à nos fichiers comment faisont nous ça.

Si par exemple vous voulez autorisez les gens de l'université à accéder en lecture sur vos documents, dans ce cas on se contente de `5` parce que c'est le droit de lecture et le droit d'exécution donc ils n'auront pas le droit en écriture, vous n'aurez peut être pas envie que les autres viennent modifier votre fichier.

En général si on veux que les autres accèdent quand même à nos fichiers, on va mettre le droit `755` dans une université ou autre ce qui signifie que le groupe ont accès en lecture et en accès, et les autres ont le droit ont le droit en lecture et en accès.

Admettons si je veux que le gens puissent aller voir ce qu'il y a dans _doc.txt_, je vais faire `chmod 775 doc.txt` pour le document en question.

```bash
chmod 755 doc.txt #accorder la lecture et l'éxécution aux autres utilisateurs, le droit d'exécuter la commande ls dessus.
```

Les gens pourront faire un `ls` dessus mais par contre ils ne pourront pas le modifier il serra protégé.

Dans le cas général, où je veux que les gens ne puissent accéder à rien du tout du document, il parraît logique de faire `700`.

```bash
chmod 700 doc.txt #j'ai tout les droits et les autres n'ont rien du tout.
ls -l doc.txt
	-rwx------ 1 sam sam 0 fév 28 20:12 doc.txt
```

Voilà ce document est parfaitement privé. Il n'y a que moi qui pourrait éccader à ce document là parce que les droits sont définis sur `u` pour user.

Rappelez vous, `u` pour user, `g` pour groupe et `o` pour other et le `a` pour all.

Puis rappelez vous qu'on peut le faire de manière récurssive `-R`. Admettons que je veux que tout le monde puisse lire ma musique.

```bash
chmod 755 -R Musique/ #accorder rx aux autres mais pas w sur le répertoire musique.
```

Ca veut dire que le monde pourra lire, écouter la musique de mon répertoire personnel mais ils ne pourront pas la modifier, ils ne pourront pas la supprimer, ils ne pourront pas enregistrer de nouveaux fichiers dans mon répertoire de musique puisque je n'ai pas envie que des gens ajoutent des trucs dans mes documents mais ils pourront les lire.

```bash
chmod 755 -R Images/
```

Pareil pour les images et les gens ne pourront ni ajouter des images dedans ni supprimer quoi que ce soit, ni modifier, ils pourront juste aller voir les images.

Ca ce sont des choses à faire de manière récurssive, ça va se faire dans tout les répertoires et sous répertoires du dossier images.

Voilà pour les droits des fichiers et retenez que grace à ce système octale, on gère tout les cas possibles. Très bien conçu pour gérer tout les types de droits.

```bash
chmod 755 -R ~ #accorder rx aux autres mais pas w sur mon dossier personnel.
```

## chown
Change le propriétaire du fichier.

Alors le fichier n'a qu'un seul propriétaire définis avec un certain type de droit particulier.

Ce propriétaire peut être changé évidemment, je fait `chown` et je change le propriétaire. Par exemple je vais dire que le fichier appartient maintenant à Chuck.

```bash
ls -l doc.txt
	-rwx------ 1 sam sam 0 fév 28 20:12 doc.txt
sudo chown chuck doc.txt #changer le proprio mais en root.
ls -l doc.txt
	-rwx------ 1 chuck sam 0 fév 28 20:12 doc.txt
```

Voilà pour faire ça il faut être en super utilisateur, mais au moment de la vidéo on n'a pas les commandes `root`.

Si un jour vous récuper une clé usb Windows et si on rencontre des problème de lecture par exemple si on fait du web et lorsqu'on va vouloir afficher notre site, ça ne marche pas, permission non accordée, c'est qu'à priori il y a de forte chance que vous n'ayez pas la propriété sur ce fichier parce que quelqu'un vous la passé ou qu'il vient d'un autre pc, c'est qu'à priori il faudra le changer mais il faudra le faire en `root` en appliquant le nom d'utilisateur propriétaire et ensuite il faut mettre deux point et le groupe qui par défaut est le même.

```bash
chown sam:sam doc.txt #devenir proprio.
ls -l doc.txt
	-rwx------ 1 sam sam 0 fév 28 20:12 doc.txt
chown chuck:chuck doc.txt
	chown: modification du propriétaire de 'doc.txt': Opération non permise
sudo chown chuck:chuck doc.txt
ls -l doc.txt
	-rwx------ 1 chuck chuck 0 fév 28 20:12 doc.txt
```

Voilà il n'y a que le `root` qui peut donner la propriété à une autre personne, et on verra après les commandes en `root` et que créer les utilisateurs.

Admettons pour ceux qui sont à l'université, vous pouvez gérer parfaitement les droits, si par exemple vous voulez partarger certains boût de code en école d'informatique et vous voulez partager certains boût de code pour partager vos devoir ou votre code source avec d'autres étudiants, vous pouvez par exemple autoriser l'accès à certains fichiers.

Voilà comment partager.

```bash
ls
	Bureau     Images   Musique  snap             Vidéos
	Documents  Modèles  Public   Téléchargements
mkdir Partage
chmod 755 Partage
chmod 755 -R Partage
```

Bien évidemment si plutard vous ajoutez de nouveaux fichiers dans ce répertoire, ils auront leurs droits de bases donc à chaque fois refaire cette commande.

Si vous ajoutez à l'intérieur un fichier en droits 644 et quand il va arriver dans le répertoire il serra toujours en `644`, chaque fichier a ses propres droits et un périphérique pourra avoir ses propres droit pour bloquer l'accès càd la lecture, l'écriture ce genre de chose.

Voilà tester si on est en réseaux, si on est sur un serveur, si on a plusieurs personnes sur notre système ou alors comme moi vous créer deux utilisateurs puis vous changer certains droits et gérer les droits de chuck, le droit d'accéder à certains fichiers ou pas. Tester en se connectant sur cet utilisateur.

## su

Je me connecte sur le compte de Chuck et je constate que la commande `ls` n'est pas permise.

```bash
sudo chmod 700 -R ~
ls -l #drwx------

su chuck #ouvrir une session utilisateur.
ls -l
	ls: impossible d ouvrir le répertoire '.': Permission non accordée
exit #fermer la session.

sudo chmod 755 -R ~
ls -l #drwxr-xr-x
```

Voyez quand on fait exit on revient sur ma session.

Alors en `755` chuck peut même ouvrir mes documents mais par contre il ne pourra pas le modifier.

```bash
chuck@sam:/home/sam/Bureau$ ls -l doc.txt
-rwxr-xr-x 1 sam sam    4 mar  1 09:26 doc.txt

chuck@sam:/home/sam/Bureau$ gedit doc.txt
No protocol specified
Unable to init server: Impossible de se connecter : Connexion refusée

(gedit:2748): Gtk-WARNING **: 09:29:40.270: cannot open display: :0

chuck@sam:/home/sam/Bureau$ exit
```

`su` pour se connecter à l'autre utilisateur mais on parlera de root plus tard, et `exit` pour fermer la session de Chuck.

Voir aussi gérer les permissions via une interface graphique.

![permissions en mode graphique](permissions_en_mode_graphique.JPG)

Voilà on a le choix, lecture seule ou lecture et écriture ou autoriser l'exécution du fichier comme un programme etc. 

Si on retire l'exécution en mode graphique:

```bash
sam@sam:~$ cd ~/Bureau
sam@sam:~/Bureau$ ls -l doc.txt
-rwxr-xr-x 1 sam sam 4 mar  1 09:26 doc.txt
```
![permissions en mode graphique sans exécution](permissions_en_mode_graphique_sans_exécution.JPG)

```bash
sam@sam:~/Bureau$ ls -l doc.txt
-rw-r--r-- 1 sam sam    4 mar  1 09:26 doc.txt
sam@sam:~/Bureau$ chmod u+x doc.txt
sam@sam:~/Bureau$ ls -l doc.txt
-rwxr-xr-x 1 sam sam 4 mar  1 09:26 doc.txt
```

Voilà en faisant `chmod u+x doc.txt` on récupère tout les droits.

Si j'avais `-rwx------` revient à utiliser la base octale `700`.

```bash
sam@sam:~/Bureau$ sudo chmod 700 doc.txt
sam@sam:~/Bureau$ ls -l doc.txt
-rwx------ 1 sam sam 4 mar  1 09:26 doc.txt
```