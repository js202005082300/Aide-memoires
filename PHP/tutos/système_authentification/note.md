# [Système d'authentification](https://www.youtube.com/watch?v=u5HqEgBxtss)
19-02-21

## Quid session?

La session est un outil que nous allons utiliser pour mettre en place le système d'authentification.

Par contre la session peut être utilisée pour autre chose que l'authentification d'un utilisateur, on pourrait utiliser la session pour un panier sur un site marchand ou autre.

La session c'est tout simplement un moyen de transmettre des informations sur toute la durée de la navigation.

Là où on va transmettre des informations d'une page à une autre avec notamment un formulaire, des variables super globales GET ou POST par exemple, ou via une url parce qu'on peut passer par une url pas besoin de passer par un formulaire. Là on a l'information qui va être transmise d'une page à une autre et ensuite elle est perdue.

L'avantage des sessions, c'est une super globale pour rappel en php, c'est que durant toute la session donc la navigation de l'utilisateur avant une durée d'expériration ou la fermeture du navigateur les informations pourront être transmises de pages en pages.

Les sessions interviennent dans un système d'authentification donc tout un système utilisateur parce qu'on va avoir besoin d'informations par exemple si l'utilisateur est connecté, s'il est administrateur (accès à espace réservé sur le site) ou visiteur ou la collecte de données ratachées à tel ou tel utilisateur suivant son rôle.

## Codes

index.php
```php
<?php
    if(isset($_POST['valid_connection']))
        if(isset($_POST['form_username']) && !empty($_POST['form_username']) && isset($_POST['form_password']) && !empty($_POST['form_password']))
        {
            echo '<pre>';
            print_r($_POST);
            echo '<pre>';
        }
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page d acceuil</title>
</head>
<body>
    <h1>Page d acceuil</h1>

    <p>Bienvenue sur la page d acceuil</p>

    <hr>
    <h2>Se connecter</h2>

    <form method="post">
        <input type="text" name="form_username" placehomder="Identification...">
        <input type="password" name="form_password" placeholder="Mot de passe...">
        <input type="submit" name="valid_connection" value="Connexion">
    </form>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```

La partie php c'est pour vérifier si le formulaire a été valider et si c'est le cas que les infos ont bien été rempli et si c'est le cas on fait un petit print_r().

content.php
```php
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Autre page</title>
</head>
<body>
    <h1>Autre page</h1>

    <p>Bonjour, je sais toujours qui vous êtes ! :)</p>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```

```sql
CREATE DATABASE IF NOT EXISTS `formationvideo_db`;
USE `formationvideo_db`;

CREATE TABLE IF NOT EXISTS `site_users`
(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(25) NOT NULL,
    `user_password` VARCHAR(255) NOT NULL,
    `user_registerDate` DATETIME NOT NULL,
    `user_admin` TINYINT(1) NOT NULL DEFAULT '0',
    PRIMARY KEY(`id`)
);

INSERT INTO `site_users`(`user_name`, `user_password`, `user_registerDate`, `user_admin`)
VALUES
('jachampagne', 'ahdhdo123', NOW(), 1),
('ChuckNORRIS', 'bfjdjj8888', NOW(), 0),
('BobLePêcheur', '12jjj222', NOW(), 0);
```

```powershell
mysql> SHOW tables;
+-----------------------------+
| Tables_in_formationvideo_db |
+-----------------------------+
| site_users                  |
+-----------------------------+
1 row in set (0.01 sec)

mysql> DESCRIBE site_users;
+-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| id                | int          | NO   | PRI | NULL    | auto_increment |
| user_name         | varchar(25)  | NO   |     | NULL    |                |
| user_password     | varchar(255) | NO   |     | NULL    |                |
| user_registerDate | datetime     | NO   |     | NULL    |                |
| user_admin        | tinyint(1)   | NO   |     | 0       |                |
+-------------------+--------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)

mysql> SELECT * FROM site_users;
+----+---------------+---------------+---------------------+------------+
| id | user_name     | user_password | user_registerDate   | user_admin |
+----+---------------+---------------+---------------------+------------+
|  1 | jachampagne   | ahdhdo123     | 2021-02-20 00:17:50 |          1 |
|  2 | ChuckNORRIS   | bfjdjj8888    | 2021-02-20 00:17:50 |          0 |
|  3 | BobLePêcheur  | 12jjj222      | 2021-02-20 00:17:50 |          0 |
+----+---------------+---------------+---------------------+------------+
3 rows in set (0.00 sec)
```
On considère un compte administrateur lorsque le champ user_admin est à '1' c'est comme un booléen et si c'est '0' par défaut c'est un utilisateur standard et du coup le visiteur ça peut être 1 ou -1 ou de pas de valeur du tout.

On va voir également pourquoi user_password s'étend jusqu'à 255 charactères.

Pour l'exemple, on ne met pas d'e-mail ou autre.

Alors généralement quand on créé son propre site, on crée son propre utilisateur/administrateur en base de données et après d'autres utilisateurs viendrons s'ajouter à la base de données en s'inscrivant.

Dans cet exemple nous n'avons pas fait de formulaire d'inscription mais ça on l'a vu en PHP/SQL.

## Alors comment passe t'on d'un état visiteur à connecté ?

C'est état grâce à une information qui change et cette information on va pouvoir l'utiliser via notre super globale càd les sessions. On pourra travailler avec la super globale des sessions pour ça et on aura une simple information qui dira que tel utilisateur est connecté ou non.

On présentera chaque page du site de manière différente si l'utilisateur est connecté ou non.

Admettons si l'utilisateur est connecté j'affiche un message de bienvenue avec son pseudonyme récupéré en base de données, une information qu'on va avoir besoin de mémoriser en session et sinon on lui affiche un formulaire. On ne va pas afficher un formulaire de connection si l'utilisateur est déjà connecté.

Voilà pensez au visuel, l'uilisateur connecté ne doit pas voir un formulaire de connection.

Si on voit qu'on est connecté avec bienvenue avec pseudonyme, on comprend qu'on est visuellement connecté mais nous au niveau du code c'est qu'on a mémorisé des informations en variable de session.

## init_php_session()

### initialiser la session

Alors un fichier util.php pour mettre des fonctions qu'on va réutiliser souvent.

util.php
```php
<?php

function init_php_session() : bool
{
    if(!session_id())
    {
        session_start(); // 1e info à mettre, démarrer la session.
        session_regenerate_id(); // régénérer l'id à chaque fois par sécurité.
        return true; // si ce qui prècède c'est bien passé.
    }
    return false; // si on est là, la connection a échouée ou l'utilisateur est déjà connecté.
}
```

On fait appel à cette fonction.

    require 'util.php';
    login();

index.php
```php
<?php
    require 'util.php';
    init_php_session();

    if(isset($_POST['valid_connection']))
        if(isset($_POST['form_username']) && !empty($_POST['form_username']) && isset($_POST['form_password']) && !empty($_POST['form_password']))
        {
            echo '<pre>';
            print_r($_POST);
            echo '<pre>';
        }
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page d acceuil</title>
</head>
<body>
    <h1>Page d acceuil</h1>

    <p>Bienvenue sur la page d acceuil</p>

    <hr>
    <h2>Se connecter</h2>

    <form method="post">
        <input type="text" name="form_username" placehomder="Identification...">
        <input type="password" name="form_password" placeholder="Mot de passe...">
        <input type="submit" name="valid_connection" value="Connexion">
    </form>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```

Alors pour le faire encore plus proprement, on ne rappel pas login() car générallement on le fait dans un seul fichier pour faire un système de template et après on peut faire appel au contenu du fichier de template et ça évite de répeter ce code.

Par exemple, on répète plusieurs fois ce menu mais bien sûr on ne va pas s'amuser à dupliquer à chaque fois ce menu `<nav>` sinon on aurais un menu statique.

En gros toute les pages de notre site ont besoin d'initialiser les sessions.

content.php
```php
<?php
    require 'util.php';
    init_php_session();
>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Autre page</title>
</head>
<body>
    <h1>Autre page</h1>

    <p>Bonjour, je sais toujours qui vous êtes !</p>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```

Voilà on a juste initialiser les sessions php.

### détruire la session

Pour détruire les sessions mais on l'avait déjà vu, c'est tout simplement 2 fonctions avec session_unset() pour enlever tout les contenus qui ont été mémorisés et session_detroy() pour enlever tout simplement les sessions.

```php
function clean_php_session() : void
{
    session_unset();
    session_destroy();
}
```

Voilà très simple.

## is_admin()

Alors pour permettre de distinguer un utilisateur standard par rapport à un utilisateur root, il faut choisir comment les distinguer mais pour l'exemple de la vidéo:

* un visiteur ne possède pas de rang parce qu'il n'a aucun compte en base de données.
* un utilisateur standard a la valeur '0' pour le champ user_admin.
* un utilisateur root a la valeur '1' pour le champ user_admin.

```php
function is_admin() : bool
{
    // si user_rank
}
```

Tester user_rank mémorisé en variable de session et si c'est le cas un `return true;` sinon un `return false;`

On complétera pas la suite.

## is_logged()

Tester si l'utilisateur est connecté.

```php
function is_logged() : bool
{
    return true;
}
```

Par exemple, on veux interdire l'accès ou un service à utilisateur qui serrait juste un visiteur dans ce cas on se servirais de is_logged(). Si la fonction valide l'utilisateur c'est qu'il est connecté sinon il ne l'est pas et on pourra gérer le traitement de nos pages en fonction.

Ici pareil, on met par défaut true et on complétera par la suite.

util.php
```php
<?php

function init_php_session() : bool
{
    if(!session_id())
    {
        session_start();
        session_regenerate_id();
        return true;
    }
    return false; 
}

function clean_php_session() : void
{
    session_unset();
    session_destroy();
}

function is_logged() : bool
{
    return true;
}

function is_admin() : bool
{
    return true;
}
```

Très important de distinguer les rôles des utilisateurs où on doit choisir ce qu'on utilise en base de données ou qu'est-ce qu'on utilise dans notre implémentation pour définir des rôles entre chacun des utilisateurs et du coup des droits.

Chaque rôle obtient certains type de droits et pas les mêmes non plus.

On ne veux pas qu'un simple utilisateur ait accès à la partie administration.

## Teste du formulaire

    Se connecter
    [Identifiant] [Mot de passe...] [Connexion]

Si je n'écrit qu'une seule information, en fait ça renvoie sur la même page, ça n'affiche rien, et dés que je saisis l'identifiant et le mot de passe, on récupère bien les informations.

```powershell
Array
(
    [form_username] => Jason
    [form_password] => passe
    [valid_connection] => Connexion
)
```
## Sécurité

On demandera à l'utilisateur de changer ses identifiants plutôt que de lui renvoyer bêtement sur son e-mail donc ne pas céder aux caprices d'un utilisateur un peu fainéant de peur de perdre quelques client sur un site de commerce.

Voilà on ne veux pas mettre à mal l'ensemble des données des autres utilisateurs parce que juridiquement parlant ça posera des problèmes.

En terme de sécurité que stockons-nous ? et comment ?

L'identifiant et le mot de passe.

Attention on ne stocke pas le mot de passe en clair.

    Un hash de "passe" : $2y$10$FCdhOhUhxZNLOP46n4fD0uADTI5W4NyxCPnhdyVrVA4lLAaaT.YHa

Voilà ça ça correspond bien à pass1 et pas autre chose donc on risquerais de ne jamais pouvoir se connecter si on n'a pas l'information nécessaire. 

### Chiffrement vs. hashage

On a deux solutions, la première c'est le chiffrement.

Le chiffrement on a une information en clair, on utilise une clé de chiffrement d'accord qui va chiffrer l'information en clair pour produire une information chiffrée mais au niveau chiffrement on peut revenir à l'inverse c'est-à-dire en ayant la clé de déchiffrement ou en tout cas la clé qui a permis de chiffrer, on peut revenir à l'étape en clair.

En gros, B une information chiffrée qui serra stockée dans nos base de données.
```
    /*
        Chiffrement : A + <clé> => B
    */
```
Jamais on ne stockera A càd le mot de passe que l'utilisateur va entrer avec son clavier par exemple sur un formulaire de connexion.

Et donc si on perd notre clé de chiffrement, vous ne pourrez pas déchiffrer vous aurez perdus vos données.

Il faut B et la clé pour revenir à l'information en clair.
```
    /*
        Chiffrement     : A + <clé> => B
        Déchiffrement   : B + <clé> => A
    */
```
Ca c'est la première méthode, la moins recommandée au niveau web parce qu'il y a possibilité de revenir à l'inverse. Si le pirate arrive a récupérer l'information chiffrée et la clé, il pourra aisement retrouver le mot de passe en clair.

La deuxième méthode, on utilise le principe de hashage.

Le hashage c'est simplement une information en clair A qui va produire l'information B via un algorythme.

```
    /*
        Hash : A -> B
    */
```
Elle peut utiliser également ce qu'on appelle un sel c'est tout simplement une suite de caractères qui va permettre en fait via différentes opérations, itérations complexifier le schéma qui est produit au final.

Et là c'est comme dans la cuisine, on met le salage pour le hash !

Attention ici on n'a pas la possibilité de revenir à l'envers. Il n'y a pas de clé de chiffrement, de déchiffrement ou autre d'accord c'est une fois qu'on a obtenu une information B eh bien ça restera la information B d'accord on ne peut pas faire l'étape inverse mais c'est du coup plus intéressant.

Par exemple, dans notre base de données, on a mit "passe" notre mot de passe en clair pour le premier exemple et ça a donné tout ça.

    Un hash de "passe" : $2y$10$FCdhOhUhxZNLOP46n4fD0uADTI5W4NyxCPnhdyVrVA4lLAaaT.YHa

Voilà ça utilise blowfish comme algorythme mais on ne rentre pas dans les détails. On n'est pas là pour parler des algorythme de chiffrement.

En base de données, on va stocker le hash d'un utilisateur ce qui assure la sécurité point de vue du chiffrement.

Craquer le mot de passe pour revenir en arrière mais il s'agit d'algorythme de hashage qui sont éprouvé d'accord ils sont suffisament fiable pour empêcher cela et en plus de cela, en tant qu'utilisateur root, on ne possède pas le mot de passe de nos utilisateurs. C'est gage de sureté et de confiance supplémentaire. En tant que responsable du site, on n'a pas accès aux mots de passe des autres utilisateurs.

Encore une fois ne jamais faire confiance à l'utilisateur, admettons qu'on récupère l'information en clair, par exemple avec un mot de passe identique à celui utilisé sur d'autres comptes tel que Paypal ou autre. On ne doit pas faire confiance aux autres administrateurs non plus.

Le désavantage c'est que si demain Chuck Norris me demande son mot de passe, je suis incapable de lui donner.

Par ailleurs même si un pirate accède à la base de données, il pourra récupérer un nom d'utilisateur, des dates et hash dont l ne pourra rien faire.

## L'étape de hashage

Comment fait on pour enregistrer cette information ?

Simplement avant de créer son système d'authentification, on créé directement dans la base de données son utilisateur à nous d'accord et du coup vous aurez besoin d'avoir déjà le mot de passe hashé.

On utilise la constante PASSWORD_BCRYPT càd l'algorythme Blowfish qui est à ce jour le plus utile, celui qui est le mieux prit en charge, le mieux éprouvé et celui qui est le plus éfficace.

```php
<?php
$pass = 'passe';
echo password_hash($pass, PASSWORD_BCRYPT);
```

En 3e paramètre de password_hash() on peut mettre le nombre de fois où on va éffectuer des itérations pour en fait éffectuer le hashage et par défaut c'est 10, on peut aller de 4 à 31 mais comprenez que les différentes itération que prendra l'algorythme prendra un certains nombre de temps. Par défaut, dans un tableau associatif on a ça ['cost' => 10].

```php
<?php
$pass = 'passe';
echo password_hash($pass, PASSWORD_BCRYPT, ['cost' => 10]);
```
Si on met ça c'est comme ne rien mettre en 3e argument.

Plus le hash serra long, plus le hash serra éfficace mais le problème c'est que le temps d'exécution pour produire le hash serra long. Idéallement la production d'un hash ne doit pas prendre plus d'1/2 seconde ce qui est une bonne référence. Si ça prend 0,6 ou 1 seconde c'est qu'évidemment le coût est beaucoup trop grand par rapport à la machine. Si ça prend trop de temps pour produire le hash c'est que pour le coup ça devient contre-productif.

Par ailleurs il faut vérifier également le retour de la fonction password_hash() parce que si une erreur est survenue elle ne retournera pas le hash mais elle retournera false.

Un autre avantage c'est que le mot de passe produit à la fin ne serra pas le même dés qu'on actualise la page.

```php
<?php
$pass = 'passe';
echo password_hash($pass, PASSWORD_BCRYPT);
exit;
```

    $2y$10$FCdhOhUhxZNLOP46n4fD0uADTI5W4NyxCPnhdyVrVA4lLAaaT.YHa
    $2y$10$qlAFX0nqaytU9.hr.oOTr.ukD9ud5bvHQtfCcF/57au592sPEqVMW
    $2y$10$dRhrMUku2sUlVY5yprUdS.l94RAY4T7bkGvDhy0DE.4/Hf4c1io0q
    $2y$10$YmZG9vom/vgxqQ5F.M821eAhzW5ExqVhawOgCxdkoIArTl5Ioeql2

A chaque fois que je actualise la page le hash change c'est pour ça qu'au final c'est d'autant plus efficace de hacher un mot de passe plutôt que simplement le chiffrer puisque le hash produit à la fin ne sera pas le même d'accord parce qu'il n'y a pas en fait d'effet inverse c'est-à-dire de partir du hash et revenir à un mot en clair.

Alors si on a le hash qui change à chaque fois sachant que c'est ça qu'on va stocker en base de données, comment on va vérifier qu'un utilisateur est bien connecté parce que si on fait la compraison des deux, il nous dira que c'est pas bon et l'utilisateur ne pourra pas se connecter.

Pour le hashage, on a cette fonction password_hash() qui génère le hash à un instant t et celle qui va le vérifier c'est la fonction password_verif() qui prend en compte le mot de passe en question et le hash qui est stocké en base de donnée.
```php
<?php
$pass = 'passe';
$hash = password_hash($pass, PASSWORD_BCRYPT);

echo password_verify($pass, $hash);
exit;
```
Ca retournera 1 si ça correspond.

Si j'actualise ça fonctionne toujours donc le hash qui est généré à chaque fois est différent pour autant c'est toujours vérifier convaneblement, c'est bien valide et ça nous suffit à valider ce hash en base de données.

    1
    1
    1
    1

Ensuite on va effectuer une requête pour récupérer les informations, pour voir qu'elles existent bien et si elle existe on va vérifier le mot de passe via cette fonction-là donc pour faire une simple comparaison, le user_name correspond à celui que vous avez récupéré de la base de données et pour le mot de passe on utilisera password_verify().

Très rapidement vous avez d'autres fonctions qui sont éventuellement pratique, vous avez aussi password_get_info() qui va renvoyer un tableau d'accord sur le $hash, il faut passer le $hach en arguments et ça vous retournera tout simplement un tableau avec toutes les informations: l'algorithme utilisé, le coup utilisés, etc.
```php
    /*
        password_get_info($hash)
    */

<?php
$pass = 'passe';
$hash = password_hash($pass, PASSWORD_BCRYPT);

echo password_verify($pass, $hash);
exit;
```

### password_needs_rehash()
@https://www.php.net/manual/fr/function.password-needs-rehash.php

```php
<?php
$pass = 'passe';
$hash = password_hash($pass, PASSWORD_BCRYPT);

password_needs_rehash($pass, $hash);

echo password_verify($pass, $hash);
exit;
```

Si un jour, on change le côut (par exemple de 10 à 13) ou bien d'algorythme PASSWORD_BCRYPT, cette fonction va faire à nouveau le hashage de tout les ancien mot de passe si on met d'autres options. On applique aux ancien mots de passe le nouveau hash avec éventuellement le nouvelle algorythme que l'on choisie et éventuellement les nouvelles options.

Voilà si un jour on met à jour notre fonction de hashage, on fait appel à password_needs_rehash() à l'endroit où se connecte l'utilisateur.

### En pratique

index.php
```php
<?php
    require 'Database.php';
    require 'util.php';
    init_php_session();

    if(isset($_POST['valid_connection']))
        if(isset($_POST['form_username']) && !empty($_POST['form_username']) && isset($_POST['form_password']) && !empty($_POST['form_password']))
        {
            $username = $_POST['form_username'];
            $password = $_POST['form_password'];

            $sql = 'SELECT * FROM site_users WHERE user_name = :name';
            $fields = ['name' => $username];

            $req = Database::getInstance()->request($sql, $fields);

            echo '<pre>';
            print_r($req);
            echo '<pre>';
        }
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page d acceuil</title>
</head>
<body>
    <h1>Page d acceuil</h1>

    <p>Bienvenue sur la page d acceuil</p>

    <hr>
    <h2>Se connecter</h2>

    <form method="post">
        <input type="text" name="form_username" placehomder="Identification...">
        <input type="password" name="form_password" placeholder="Mot de passe...">
        <input type="submit" name="valid_connection" value="Connexion">
    </form>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```

45.00
Database.php
