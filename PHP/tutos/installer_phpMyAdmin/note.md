# [Installer phpMyAdmin](https://www.youtube.com/watch?v=S0mR_Gl7Rg4)
18-02-21

phpMyAdmin permet d'aministrer via une interface graphique nos DB MySQL, administrer nos DB via un serveur web.

C'est une application écrite en php.

## installation

https://www.phpmyadmin.net/

Télécharger et placer ce dossier dans le répertoire où on met nos projets de sites web notamment le serveur web Apache dans htdocs et nommez le comme ceci.

	\MyWAMP\apache\htdocs\phpmyadmin\

Nous devons configurer phpMyAdmin pour qu'il puisse démarrer sur notre installation de MySQL surtout si on a déjà créé des bases via le terminal, il faut faire le lien avec l'interface et on pourra se connecter via l'interface graphique directement de PhpMyAdmin.

On crée une copie de config.sample.inc.php pour le back-up et ensuite on renomme config.sample.inc.php en config.inc.php

config.sample.inc.php
> config.inc.php
> config.sample.inc - Copie.php

## configurer \MyWAMP\apache\htdocs\phpmyadmin\config.inc.php

On va utiliser une connexion par cookie.

Première chose pour chiffrer la connexion à un système d'authentification pour avoir quelque chose d'un peu plus sécurisé, on va avoir un petit mot de passe (32 chars) pour faire le chiffrement.

```php
/**
 * This is needed for cookie based authentication to encrypt password in
 * cookie. Needs to be 32 chars long.
 */
$cfg['blowfish_secret'] = '';
```
@https://www.motdepasse.xyz/

Voilà de simple variables php pour la configuration et on voit que la configuration par serveur est représenté par un numéro donc notre premier serveur serra le n°1.

```php
/**
 * Servers configuration
 */
$i = 0;

/**
 * First server
 */
$i++;
```

On indique ici que l'authentification est par cookie.

```php
/* Authentication type */
$cfg['Servers'][$i]['auth_type'] = 'cookie';
```

Voilà c'est toujours une variable $cfg pour config. 'Servers' au pluriel et un S majuscule. Sur [$i] parce que c'est le nom du serveur en question et ensuite ['auth_type'], très important, qui permet de choisir le type d'authentification qui est un identifiant pour le tableau associatif en php. Et on lui dit qu'il est en 'cookie'.

Ensuite pour les paramètres de serveur c'est ce que vous aviez mis après que vous ayez fait l'installation de MySQL avec l'hôte sur localhost parce qu'on est en local. Alors sans mot de passe pour root, il faudra passer True pour AllowNoPassword sinon ça ne fonctionnera pas.

```php
/* Server parameters */
$cfg['Servers'][$i]['host'] = 'localhost';
$cfg['Servers'][$i]['compress'] = false;
$cfg['Servers'][$i]['AllowNoPassword'] = false;
```

1. configuration de la langue 

Obtenir l'interface de phpMyAdmin en français par défaut.

```php
$cfg['DefaultLang'] = 'fr';
```

1. indiquer le serveur par défaut au démarrage

Indiquer que l'on démarre sur le 1er serveur par défaut.

```php
$cfg['ServerDefault'] = 1;
```

Ce n'est pas obligatoire mais puisqu'on peut avoir plusieurs serveur phpMyAdmin, il est recommandé de le mettre.

1. indiquer un nom pour le serveur

```php
$cfg['Server'][$i]['verbose'] = 'root';
```

Par exemple, on met ici ce qui correspond à notre configuration locale.

C'est n'est pas important.

1. Utilisateur

On fait correspondre nos information MySQL avec phpMyAdmin donc 'root'.

```php
$cfg['Server'][$i]['user'] = 'root';
```

1. Mot de passe

Pour se connecter à MySQL s'il y en a un.

```php
$cfg['Server'][$i]['password'] = '';
```

## Resume

En résumé, nous avons:

```php
<?php
declare(strict_types=1);
/* Pour le chiffrement, pour cookie */
$cfg['blowfish_secret'] = 'Vcu6f87GwsS74RYc66Zz43Cc6PXmz7jN';
$i = 0;
$i++;
/* Préciser une authentification par cookie sinon blowfish_secret ne servirais à rien */
$cfg['Servers'][$i]['auth_type'] = 'cookie';
/* Ensuite quelques informations obligatoire host, verbose, user et le password */
$cfg['Servers'][$i]['host'] = 'localhost';
$cfg['Server'][$i]['verbose'] = 'root';
$cfg['Server'][$i]['user'] = 'root';
$cfg['Server'][$i]['password'] = '';

/* AllowNoPassword à true si on veut pouvoir se connecter sans mot de passe et par défaut false pour la compression qu'on laisse */
$cfg['Servers'][$i]['compress'] = false;
$cfg['Servers'][$i]['AllowNoPassword'] = true;

/* Ensuite en plus par défaut une langue choisie et le serveur qui est chargé par défaut */
$cfg['DefaultLang'] = 'fr';
$cfg['ServerDefault'] = 1;

/* reste du fichier, non abordé dans ce tuto */

$cfg['UploadDir'] = '';
$cfg['SaveDir'] = '';
```

## Configuration \MyWAMP\apache\php.ini

Activer l'extension pour MySQLi en décommentant:

```ini
extension=mysqli
```

Voilà c'est terminé.

## tester

On va démarrer tout les services, en premier le serveur Apache, serveur web, parce que comme c'est du php il faut que ça tourne sur un serveur.

	httpd.exe

On démarre le serveur MySQL parce que je rappelle que phpMyAdmin n'est qu'une interface graphique, elle ne fait que se connecter sur un serveur déjà installé sur notre système.

	mysqld.exe

Se connecter en local.

	http://localhost/phpmyadmin/

Et mettre les informations comme si on se connectait avec le client MySQL en ligne de commandes.

## Mise à jour

Renommer l'ancien dossier phpmyadmin en old puis vous mettez votre nouveau répertoire phpmyadmin et vous n'aurez plus qu'à copier votre fichier config.inc.php de l'ancienne à la nouvelle installation.

Voilà c'est simplement un remplacement de fichiers.