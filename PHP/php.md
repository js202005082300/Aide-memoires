# Le langage PHP

## cours # -  Apache & PHP

### Linux

#### installer serveur Apache

	sudo apt-get install apache2
	
Empecher le service de se lancer au démarrage de l'OS

	sudo systemctl disable apache2

Démarrer le service

	sudo systemctl start apache2
	sudo systemctl stop apache2
	sudo systemctl restart apache2

#### Editer nos pages web

Tester nos droits sur ce répertoire

	ls -l /var/www/html

Accorder l'accès

	sudo chmod 755 -R /var/www/html

Devenir propriétaire

	sudo chown $USER:$USER -R /var/www/html

#### Installer l'interpreteur PHP

installation de PHP et du module d'Apache

	sudo apt-get install php libapache2-mod-php

Editer config php

	sudo vim /etc/apache2/mods-available/php7.4.conf

... en fin de fichier

	php_value display_errors on
	
Editer config apache2

	sudo vim /etc/apache2/apache2.conf

```
<Directory /var/www/>			
	Options Indexes FollowSymLinks
	AllowOverride All	(None devient All, permettre .htaccess)			
	Require all granted			
</Directory>
AccessFileName  .htaccess
```

Editer php.ini

	sudo vim /etc/php/7.4/apache2/php.ini

```
error_reporting = E_ALL
display_errors = On
display_startup_errors = On
html_errors = On
default_charset = "UTF-8"
```

Editer nos pages PHP

	sudo vim /var/www/html/index.php
```
<?php
	echo "Hello world";
```

Test

	sudo systemctl start apache2
	localhost/
	localhost/monsite/
	sudo systemctl stop apache2