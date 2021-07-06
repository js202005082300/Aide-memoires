# [AIDE - gérer plusieurs versions de fichiers (Git)](https://www.youtube.com/watch?v=CEb_JM_hsFw)
@https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/Aide

[Créer un nouveau dépot](https://github.com/new)
```git
	git clone https://github.com/jasonchampagne/FormationVideo.git

	git config --global user.email "js201910271836@outlook.com"
	git config --global user.name "js"
	git remote add origin

	git pull [dépot]
	git add *
	git commit -a -m "-"
	git push [dépot]
	https://github.com/js202005082300/Aide-memoires.git
	https://github.com/js202005082300/samuel.jacquet.github.io.git
	https://github.com/js202005082300/Partage.git
```
+ mode change 100644 => 100755 (Linux)
```bash
sudo chmod 644 .                    (set old mode of all files)
git config core.fileMode false      (set core.fileMode to false in config file)
sudo chmod 755 .                    (change the permissions of all files)
git config core.fileMode true       (set core.fileMode to true)
```
+ warning: Pulling without specifying how to reconcile divergent branches is discouraged (Windows)
```bash
git config pull.rebase false		# merge (the default strategy)
```

## Git

C'est un gestionnaire de version.

Intérêt de pouvoir gérer un système de version sur des fichiers. 

Pratique en développement de logiciels en gérant plusieurs versions de ces fichiers et de revenir en arrière en cas d'erreurs ou de revenir à une version antérieure (TimeMachine). 

Git permet de faire du travail collaboratif sur du travail synchroniser avec tout le monde. Utile à toute personne qui a besoin d'un système de gestion de version (développeur, écrivain, etc.).

Git est un logiciel Open-Source.

Logiciel qui est utilisé en ligne de commandes (ou avec un client et son interface, une GUI tel que TortoiseGit avec une licence GPL et Open Source, totalement gratuit).

Github est un site qui permet d'avoir un ensemble de dépôts distants à récupérer. Il permet de récupérer une archive zip ou une version toujours à jour d'un dépôt avec le chemin vers ce dépôt afin de le cloner en local dans notre répertoire.

## Installation standard (tout par défaut)

    https://git-scm.com/download/win
    https://git-scm.com/download/linux

## Configurer Git

Ouvrir git.exe

> Ajouter "git.path" à settings.json sur VS code
> {
>     "git.path": "C:/.../git/bin/git.exe",
> }

    git config --global user.name "js"
    git config --global user.email "js201910271836@outlook.com"
    git config --global user.mail "js201910271836@outlook.com"

> Afficher les fichiers, dossiers et lecteurs cachés : 
> Options de l'Explorateur de fichiers -> Affichage (onglet) -> Fichiers et dossiers cachés -> Afficher les fichiers, dossiers et lecteurs cachés.

## Gérer un dépôt
Dépôt, c'est un répertoire de travail qui contient un projet.
cd C:/.../Formations/FormationVideo/GitRepos/

Lister le contenu du répertoire \<chemin\>

    ls <chemin>

Make directory, permet de créer un répertoire \<name\>

    mkdir <name>

Accéder à \<chemin\>

    cd <chemin>

## Initialiser un nouveau dépôt

Initialiser un dépôt Git à cet endroit, quand on est dans le bon répertoire.

    git init

Récupérer un dépôt distant

    git clone https://github.com/jasonchampagne/FormationVideo.git

Cloner un dépôt distant (url, liens -> https://<depot> ou répertoire pour git-> git://<depot>) mais on peut choisir un nom pour le nommer différemment du dépôt en ligne.

    git clone <chemin> <name>

## Activer l'historique sur de nouveaux fichiers

Activer l'historique sur de nouveaux fichiers permet de revenir en arrière en cas de problèmes car Git sauvegarde l'historique complet des événements sur le dépôt. D'où l'intérêt de faire des commits réguliers pour revenir en arrière facilement via l'historique de Git.

Les 3 états d'un fichier : 

* État de modification : en cours de mordication quand on est en train de travailler dessus.

* État stage (git add) : fichier modifié et prêt à être sauvegardé. La stage area est la zone de la préparation à la sauvegarde de tout ce qu'il y a dans le dépôt.

* État commit (git commit) : fichier sauvegardé à l'historique de Git.

## Opération sur l'ensemble des fichiers

Ajouter un fichier en vue d'être sauvegardé (en mode stage).

    git add <file>

Préparer la sauvegarde de tout.

    git add --all / git add *

Déplacer et/ou renommer un fichier.

    git mv <ancien_nom> <nouveau_nom>

Supprimer le fichier.

    git rm <file>

## Sauvegarde des fichiers

Sauvegarder (id -> 28401f2).

    git commit [-m "Description"]

Ajouter (-a) et sauvegarder

    git commit -a -m "Description"

## Opérations de vérifications

Afficher l'historique de ce qui a été sauvegardé (commit stage).

    git log

Afficher l'historique de ce qui n'as pas encore été sauvegardé (stage state).

    git status

## Opérations d'analyses

Comparer la différence entre plusieurs commits.

    git diff < id_commit1> < id_commit2>

## Synchroniser avec le dépôt distant

Se synchroniser avec le dépôt distant.

    git pull

Pousser vers la branche principale du dépôt les modifications faites (possibilité de revenir en arrière).

    git push origin master

## Revenir en arrière, à l'état de commit

Annuler tous les changement depuis le dernier commit (roll back). HEAD est un pointeur vers la branche principale.

    git reset -hard HEAD

Supprimer ce qui a été fait au dernier commit.

    git reset -hard HEAD^

Restaurer le dépôt dans l'état du commit identifié (TimeMachine).

    git revert <id_commit>

# Le dépôt, c'est équivalent à un arbre

Master, c'est la branche principale du dépôt. 

HEAD-> MASTER, c'est le nom de la branche courante, principale.

HEAD est un pointeur qui mène vers cette branche, la branche courante, celle qu'on est en train d'utiliser. La branche MASTER est suffisante pour les projets.

Créer une branche, c'est modifier le projet sans infecter la branche principale (travailler sur une copie sans infecter l'original en travaillant sur une version parallèle) pour in fine fusionner notre branche avec la branche principale. 

Exemples :

* correction d'un bug sur un projet de 2-3 personnes et quand le bug sera corrigé, il suffira de fusionner le projet avec la branche principale avec git pull.
* tester ou développer un ajout de fonctionnalité.
* développer un projet en parallèle (branches qui ne fusionne jamais). Par exemple, une branche pour chaque console de jeux (PC, XBOX, PS4).

Lister les branches.

    git branch

Créer une nouvelle branche.

    git branch <name>

Changer de branche courante. Le pointeur HEAD va pointer sur la branche spécifier.

    git checkout <name>

## Fusionner avec la branche principale

Switch sur une branche. On ne peut pas changer de branche s'il y a des commits à faire.

    git checkout <name>

Fusionner avec une autre branche.
Supprimer une branche
    
    git merge <name>

## Supprimer une branche.

    git branch -d <name>

## Récupérer les changements d'un dépôt distant

Récupérer l'accès au dépôt.

    git remote add <name> https://<depot>

Synchroniser avec un dépôt distant.

    git fetch <name>

Récupérer le dernier état du dépôt en question.

    git pull <name>

