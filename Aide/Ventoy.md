# [Créer votre clé USB Multiboot avec Ventoy ! (Windows, Ubuntu, Debian, Antivirus, Sauvegarde...)](https://www.youtube.com/watch?v=xVJHE27EJxA)

Au lieu d'avoir une clé usb pour chaque système (Ubuntu, Windows 10), ici on va pourvoir avoir une seule clé usb qui va pouvoir regrouper tout nos systèmes ou alors tous nos outils bootables.

Il existe d'autres outils pour faire ça comme Easy2Boot ou Yumi qui existe depuis longtemps.

On parle d'un logiciel qui est utltra simple à utiliser et open-source et gratuit.

Ventoy en ligne
===============

Les sources de Ventoy sont disponible sur GitHub mais il y a également un site internet dédié à Ventoy, avec pleins d'informations, documentations.

Ce site est ici :

	https://www.ventoy.net/en/index.html

Il n'est pas très beau mais il est fonctionnel et dés l'entrée sur ce site, on peut voir les features, les fonctionnalitées que l'on va restrouver sur Ventoy.

Une des plus grosse fonctionnalité qui dépasse la concurrence, c'est qu'il va supporter le BIOS et l'UEFI, c'est à dire que l'on va pouvoir démarrer avec une clé usb multiboot que ce soit sur un vieux pc ou sur un pc plus récent avec de l'UEFI.

Lorsqu'on utilise des clé bottable, ça peut être très compliqué de passer d'un bios à un UEFI et donc là pas de problème.

Pour tout les pcs qui ont le secure boot d'activé, il faut en théorie désactiver le secure boot quand on utilise ce type d'outil.

Ici Ventoy a une option et il désactive, by-passe le secure boot.

C'est encore une fonctionnalité en test mais qui semble fonctionner pas mal mais il est possible que ca ne fonctionne pas sur toutes les cartes mère. 

Ventoy est un outils avec pleins de fonctionnalités et indispensable car il permet de créer en quelques minutes notre clé usb bootable.

Et après, on aura plus qu'à dropper, glisser-déposer nos ISO sur la clé usb et c'est fini, il n'y a rien d'autres à faire.

Tested ISO
----------

Actuellement, il y a plus de 260 ISO qui ont été testés, on peut voir la liste en cliquant sur Tested ISO :

	https://www.ventoy.net/en/isolist.html

Reprend toute la liste des ISO qui ont été testés et qui sont fonctionnels. Si ca ne fonctionne pas, il y aura une petite remarque.

Il est recommandé d'utiliser une clé usb extrémement rapide pour charger les ISO.

Documentation
-------------

Dans la documentation, on voit que Ventoy va pouvoir créer 3 partitions :

* Une pour le BIOS ,
* Une pour l'UEFI ,
* Une pour les ISO ,

... même une pour nos données.

On parle des données parcequ'une fois qu'on aura formater la clé usb avec Ventoy, on pourra l'utiliser pour autre chose.

Preparation et installation
===========================

Aller dans la catégorie Downloads pour télécharger l'outil :

	https://www.ventoy.net/en/download.html

Il y a la version pour Windows et la version pour Linux.

Ainsi on télécharge et on décompresse le dossier :

	ventoy-1.0.12-windows.zip

Ainsi on lance l'outil : Ventoy2Disk.exe

L'interface reconnait l'usb ainsi que la version téléchargée et celle déjà installée.

rem. Il y a une option simple option pour que ça fonctionne même si il y a le secure boot mais attention, c'est actuellement une fonction Beta mais  semble fonctionner mais autrement il ne faut pas hésiter à la décocher.

On fait ensuite l'installation qui va formater la clé donc il faut sauvegarder les données éventuelles qui sont sur la clé.

Il faut ensuite doublement confirmer le formatage de la clé. Il y en a pour quelques secondes avant que la clé soit prête.

Bouton Mise à jour
==================

Permet tout simplement de mettre à jour notre clé sans avoir à la reformater.

C'est-à-dire que tout les ISOs mis dessus ne seront pas touchés. Ce qui est plutôt pratique, il suffira alors de télécharger la dernière mise à jour et de cliquer sur le bouton de mise à jour.

Vérification
============

On retourne dans l'explorateur et on constate qu'une partitions vient d'être crée avec le nom Ventoy.

La clé est alors vite, il n'y a aucune structure, il n'y a rien parce que tout est dans les partitions cachés.

Et là, on va juste pouvoir glisser-déposer nos ISOs soit directement sur la clé, sur la racine mais si on veut, on peut créer des dossiers et des sous-dossiers.

Ventoy va en fait regarder dans tout les dossiers et nous afficher chacun des outils.

Sur certains appareils, le zalman, le dossier contenant les ISOs s'appele "_ISO". Donc on va nommer notre dossier de la même manière.

Une fois le chargement terminé, on peut y stocker par exemple :

* un petit android pour faire des tests ;

* un outil de backup ACRONIS ;

* un ISO de Windows 10 20.04 ;

* des utilitaires : 
	* medicat_v19.10.stable.iso, 
	* gparted-live-1.1.0-1-amd64.iso, 
	* boot-repair-disk-64bit.iso (pour réparer le boot sur notamment Windows)

* pfSense-CE-2.4.5-RELEASE-amd64.iso (routeur virtuel PfSense pour quelques tests)

On met nos ISO tel quels dans un dossier "_ISO".

Démarrage
=========

On la débranche et depuis un ordinateur, on essaye de démarrer sur Ventoy.

Directement sur l'ordinateur sur le quel on veux booter.

On démarre l'ordinateur en appuyant sur la touche de boot pour afficher le boot menu.

Ou bien dans le BIOS ou l'UEFI et changer l'ordre des périphériques de démarrage.

La touche F2 va permettre d'afficher tous les périphériques bootables.

On sélectionne ensuite la clé usb afin de pouvoir booter sur Ventoy.

Ventoy est extrèmement rapide.

On apperçoit tous les ISOs mais pas les dossiers créés.

Le bouton F3 permet de passer en vue arborescence explorateur.

On peut ainsi booter sur un système ou bien un outil de backup tel que Acronis pour faire nos images.

Interface : Elle peut être changé quand on est technicien informatique et qu'on veut la changer, la personnaliser au nom de notre société.

En bas à gauche, on a le numéro de version de Ventoy et si on est en UEFI, ou en Bios.

On a aussi une petite fonction avec F1 qui affiche en tant que MainDisk lorsqu'on utilise certains ISO.

Et notamment en mode BIOS et que ca ne fonctionne pas, parfois il est nécessaire que l'ISO soit chargé en mémoire c'est là que MainDisk fait le nécessaire pour des ISO qui pose problème.

En F2, on a power ou tout simplement pour rebooter ou arrêter complétèment la machine.

Et pour rappel, F3 c'est pour l'aboréscnece.

En démarrant Acrononis, on peut faire une restauration ou encore une sauvegarde de notre système.

On peut mettre dans Ventoy tous les ISOs, tous les outils bootable et ainsi avoir une seule clé pour gérer l'ensemble de nos ISOs.