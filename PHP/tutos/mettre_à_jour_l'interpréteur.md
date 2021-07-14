# [Mettre à jour l'interpréteur](https://www.youtube.com/watch?v=wPFqy_QvWjs)
19-02-21

\MyWAMP\apache\bin\httpd.exe
http://localhost/PHP/tutos/

## version
```php
<?php
phpinfo();
exit;
```

## installation

On récupère les binaires pour Windows

@https://www.php.net/downloads
@https://windows.php.net/download#php-8.0

Su Linux, il faudra mettre à jour via les dépot de Ubuntu.

On récupère le zip de la version x64 Thread Safe.

Ensuite on coupe le serveur Apache et on renome l'ancien répertoire php:

    \MyWAMP\php-bak

On crée un nouveau répertoire php.

    MKDIR \MyWAMP\php

Ensuite on va pouvoir tout déplacer et on doit vérifier php8apache2_4.dll qui est super important et sans ça php ne pourra pas fonctionner avec le serveur Apache.

Tant qu'on a vu que ça fonctionnait, on ne supprimera pas le back-up.

## \MyWAMP\apache\php.ini

Renomer l'ancien fichier php.ini par le nouveau.

    CD C:\...\MyWAMP\apache\
    RENAME php.ini php.ini.bak
    CD ..
    COPY php\php.ini-development apache\php.ini

Ouvrir apache\php.ini.bak et apache\php.ini et comparer (c'est les mêmes).

## \MyWAMP\apache\conf\httpd.conf

La version pour PHP actuelle est la 8. En conséquence, le module à configurer pour Apache a changé de nom (auparavant php7_module, devenu php_module - on n'indique pas de "8").

Avec PHP 7 :
LoadModule php7_module "C:/WebApache/php/php7apache2_4.dll"

Avec PHP 8 :
LoadModule php_module "C:/WebApache/php/php8apache2_4.dll"

```conf
# PHP 8
LoadModule php_module "C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/php/php8apache2_4.dll"

<FilesMatch "\.php$">
	AddHandler application/x-httpd-php .php
</FilesMatch>

<IfModule php_module>
	PHPiniDir "C:/Users/sam/OneDrive/Formations/FormationVideo/MyWAMP/apache"
</IfModule>

<IfModule mine_module>
	AddType application/x-httpd-php .php .html
</IfModule>
```

## tester

\MyWAMP\apache\bin\httpd.exe
http://localhost/
http://localhost/PHP/tutos/

A l'usage, il faudra tester lles modules et s'assurer que tout fonctionne.

```php
<?php
echo 'Hello World !';
exit;
```