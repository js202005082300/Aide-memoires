# Tutoriel PHP - système d'authentification
@https://www.youtube.com/watch?v=u5HqEgBxtss
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
        <input type="text" name="form_username" placeholder="Identifiant...">
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
DROP DATABASE IF EXISTS `formationvideo_db`;
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
('jachampagne', '$2y$10$Fdlb6svlSAJKxVEWtK.UjOUz9FZg5G17C2Ekt6MrV/AsrXFnIeM8a', NOW(), 1),
('ChuckNORRIS', '$2y$10$2S1yQapCZG9t8gA9yoRp9.c3W5VhjaIdnuKlwJ8qOgreqksFIPbPm', NOW(), 0),
('BobLePêcheur', '$2y$10$i2FLupW7brb5Sx0a5TCUFO0NOKqgE0GbILUwOw6yE4aZdu5bMzHoO', NOW(), 0); 

--mdp jachampagne : passe1
--mdp ChuckNORRIS : passe2
--mdp BobLePêcheur : passe3
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
+----+---------------+------------------+---------------------+------------+
| id | user_name     | user_password    | user_registerDate   | user_admin |
+----+---------------+------------------+---------------------+------------+
|  1 | jachampagne   | passe1           | 2021-09-22 14:45:48 |          1 |
|  2 | ChuckNORRIS   | passe2           | 2021-09-22 14:45:48 |          0 |
|  3 | BobLePêcheur  | passe3           | 2021-09-22 14:45:48 |          0 |
+----+---------------+------------------+---------------------+------------+
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
    init_php_session();

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

+ util.php
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

+ util.php
```php
function is_admin() : bool
{
    // si user_rank
}
```

Tester user_rank mémorisé en variable de session et si c'est le cas un return true; sinon un return false;

On complétera pas la suite.

## is_logged()

Tester si l'utilisateur est connecté.

+ util.php
```php
function is_logged() : bool
{
    return true;
}
```

Par exemple, on veux interdire l'accès ou un service à utilisateur qui serrait juste un visiteur dans ce cas on se servirais de is_logged(). Si la fonction valide l'utilisateur c'est qu'il est connecté sinon il ne l'est pas et on pourra gérer le traitement de nos pages en fonction.

Ici pareil, on met par défaut true et on complétera par la suite.

+ util.php
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

### password_hash()

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

### password_verif()

Pour le hashage, on a cette fonction password_hash() qui génère le hash à un instant t et celle qui va le vérifier c'est la fonction password_verif() qui prend en compte le mot de passe en question et le hash qui est stocké en base de donnée.

+ index.html
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

Voilà suffit à vérifier le hash que j'ai en base de données.

### password_get_info()

Très rapidement vous avez d'autres fonctions qui sont éventuellement pratique, vous avez aussi password_get_info() qui va renvoyer un tableau d'accord sur le $hash, il faut passer le $hach en arguments et ça vous retournera tout simplement un tableau avec toutes les informations: l'algorithme utilisé, le coup utilisés, etc.
```php
    /*
        password_get_info($hash) --> array
    */

<?php
$pass = 'passe';
$hash = password_hash($pass, PASSWORD_BCRYPT);

echo password_verify($pass, $hash);
exit;
```

Cette fonction est utilisée lorsqu'on va avoir besoin de refaire un hash de mot de passe.

Dans quel cas ça peut servir de refaire un hash de mot de passe ? Admettons que par défaut on hashais nos mot de passe avec les options par défaut c'est-à-dire avec un côut de 10 `$hash = password_hash($pass, PASSWORD_BCRYPT);` ainsi tous les utilisateurs qui vont s'inscrire lorsqu'on enregistre en base de données leurs mots de passe, on va utiliser cette fonction `password_hash()` c'est-à-dire qu'avant de stocker en base de données leurs mots de passe et leurs pseudonymes on utilise cette fonction qui aura eu un coût de 10 et c'est ce qui serra stocké en base de données.

Admettons demain on décide de renforcer un peu plus et on met un coût à 13 au lieu de 10 mais le problème comme l'utilisateur va s'inscrire sur le nouveau code que l'on a fait, le coût utilisé pour le hashage serra de 13. En revanche pour tous les utilisateurs déjà enregistré avant comme on les avaient enristrés avec un coût de 10 avant, ils resteront à 10. Ainsi dans ce cas-là, on peut décider d'utiliser la fonction password_needs_rehash().

### password_needs_rehash()
@https://www.php.net/manual/fr/function.password-needs-rehash.php

Cette fonction prend le mot de passe et elle va prendre le hash. Elle se sert des informations du hash (le fameux password_get_info() vu tout à l'heure) et en fonction comme ell va retrouver l'algorithme, le coût parce qu'on changera peut être d'algorythme plus tard, si un jour, ils sortent un algorythme plus éfficace et qu'on veut remplacer notre fonction de hashage par ce nouveaux algorythme, vous avez peut être envie de l'appliquer aux anciens utilisateurs de notre base de données et pas seulement les prochains qui s'inscrivent.

En faisant ça, il va comprarer par rapport à toutes ces informations et si cette fonction password_needs_rehash() voit que des choses ont changé par rapport aux informations du hash, que les options que nous avons indiquées sont à mettre à jour, il va faire un hashage à nouveau de tous les anciens mots de passe pour leur appliquer le nouveau hash avec éventuellement le nouveau algorythme choisi et éventuellement de nouvelles options.

```php
<?php
$pass = 'passe';
$hash = password_hash($pass, PASSWORD_BCRYPT);

password_needs_rehash($pass, $hash);

echo password_verify($pass, $hash);
exit;
```

Si un jour, on change le côut (par exemple de 10 à 13) ou bien d'algorythme PASSWORD_BCRYPT, cette fonction va faire à nouveau le hashage de tout les ancien mot de passe si on met d'autres options. On applique aux ancien mots de passe le nouveau hash avec éventuellement le nouvelle algorythme que l'on choisie et éventuellement les nouvelles options.

Voilà si un jour on met à jour notre fonction de hashage, on fait appel à password_needs_rehash() à l'endroit où se connecte l'utilisateur. Ainsi si on fait un changement sur le hash, on utilise cette fonction password_needs_rehash() pour l'appliquer à l'ensemble de tous les utilisateurs, c'est plutôt intéressant.

Où mettons cette fonction password_needs_rehash() ? Hé bien si un jour, on met à jour notre fonction de hashage, hé hé biens à l'endroit où on connecte l'utilisateur, on ferra appel à cette fonction, ainsi si l'utilisateur est déjà à jour, ce ne serra pas appliqué et si ce n'est pas le cas ce serra fait.

Ainsi le hash de tous les utilisateurs qui se connecterons au site aurons le hash de leur mot de passe mis à jour dans la base de données et donc d'avoir quelque chose de plus sécurisé à ce niveau-là.

### En pratique

On va passer en pratique et voir comment on vérifie tout ça en base de données.

On a deux informations $username et &password, et en premier on vérifie que l'utilisateur existe bien via une requête.

En faisant comme ceci, on récupère l'information en clair :
```php
$sql = 'SELECT * FROM site_users WHERE user_name = :name AND user_password = :password';
$fields = 
[
    'name' => $username,
    'hash' => $password;
]
```
Mais ici nous allons récupérer le hash.

+ index.php
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
            echo '</pre>';
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
+ localhost
```
Array
(
    [id] => 1
    [user_name] => jachampagne
    [user_password] => $2y$10$Fdlb6svlSAJKxVEWtK.UjOUz9FZg5G17C2Ekt6MrV/AsrXFnIeM8a
    [user_registerDate] => 2021-09-22 14:45:48
    [user_admin] => 1
)
```

Voilà la requête a bien récupéré toutes les informations et c'est le hash qui va nous intéresser parce qu'il faut qu'on compare le mot de passe en question.

On a donc bien récupéré les informations ici `$req = Database::getInstance()->request($sql, $fields);`. Voilà donc ici on a bien une classe Database au niveau de la méthode request() qui fait tout proprement c'est à dire qu'elle nettoie la requête et cetera donc tout est fait dedans et on a plus qu écrire cette seule ligne. Voilà nous devons faire ça proprement c'est à dire la connexion avec un try/catch ensuite notre requête, le petit curseur si nécessaire tel que je vous l'ai montré sur les vidéos où évidemment on travaille en base de données avec les PHP.

À partir de là nous allons faire une 2e vérification pour voir si on est connecté. Attention ne jamais mettre le quel entre l'identifiant ou le mot de passe est incorrect, on ne veux pas aider l'éventuel pirate à trouver ce qu'il a bien renseigné.

```php
if(password_verify($password, $req->user_password))
{
    echo 'Connecté';
}
else
{
    echo 'Identifiant ou mot de passe incorrect';
}
```
:warning: `$req->user_password` doit être remplacé par `$req['user_password']` pour correspondre à mon fichier Database.php
+ index.php
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

            if(password_verify($password, $req['user_password']))
            {
                echo 'Connecté';
            }
            else
            {
                echo 'Identifiant ou mot de passe incorrect';
            }

            echo '<pre>';
            print_r($req);
            echo '</pre>';
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
+ localhost
```
Connecté
Array
(
    [id] => 1
    [user_name] => jachampagne
    [user_password] => $2y$10$Fdlb6svlSAJKxVEWtK.UjOUz9FZg5G17C2Ekt6MrV/AsrXFnIeM8a
    [user_registerDate] => 2021-09-22 14:45:48
    [user_admin] => 1
)
```

Voilà dans la vidéo, on utilise `$req->user_password` mais nous ce sera bien évidemment différent au niveau de la vérification et là si l'utilisateur est connecté. Et s'il n'est pas connecté je vais mettre un simple message « identifiant ou mot de passe incorrect ". Très important, ne mettez jamais l'un ou l'autre parce que si vous indiquez ce qui est incorrect parmi les 2, l'utilisateur sera s'il a trouvé le bon mot de passe ou le bon identifiant parce que sachant qu'il y a certains sites qui utilisent comme identifiant l'adresse mail et ça on ne va pas la montrer publiquement quand on navigue sur des forums ou autres donc par exemple si l'utilisateur entre une bonne adresse mail mais pas un mot de passe et que vous mettez derrière le message «  mot de passe invalide " Eh bien l'utilisateur va se dire que l'adresse mail qu'il a rentrée est valide et donc derrière on donne la moitié des informations exactes au potentiel pirate.

Ainsi on précise toujours identifiant **ou** mot de passe d'accord on indique toujours que l'un ou l'autre est faux, peut être les 2, mais on ne donne pas plus d'indication et on se contente juste de ça.

Voilà et si les informations sont bonnes on dira que l'utilisateur est connecté bien que comme ça on n'aura pas changé grand-chose en terme d'état mais pour le moment on va se contenté d'indiquer qu'il l'est.

Voilà on voit bien que password_verify() fais très bien le boulot.

On peut également tester avec un autre utilisateur, bon pour l'instant on n'a pas encore initialisé les 2 sessions pour le moment et ainsi on va écrire l'identifiant ChuckNORRIS et son mot de passe *passe2*.

+ localhost
```
Connecté
Array
(
    [id] => 2
    [user_name] => ChuckNORRIS
    [user_password] => $2y$10$2S1yQapCZG9t8gA9yoRp9.c3W5VhjaIdnuKlwJ8qOgreqksFIPbPm
    [user_registerDate] => 2021-09-22 14:45:48
    [user_admin] => 0
)
```

Voilà on se connecte aussi avec toutes les informations retournées donc ça évidemment on n'a plus besoin de les afficher donc on enlève cette partie pour faire ça proprement.

```php
echo '<pre>';
print_r($req);
echo '</pre>';
```

Maintenant si on met des informations erronées quel qu'il soit, on obtient le message suivant.

```
Warning: Trying to access array offset on value of type bool in C:\.\MyWAMP\apache\htdocs\MonSite\index.php on line 17
Identifiant ou mot de passe incorrect
```

On a ce message mais ce n'est pas ça qu'on voulait donc on va changer un petit peu la condition parce que s'il n'a pas pu se connecter, la variable `$req` n'a pas été créé donc il ne la trouvera pas.
```php
if($req && password_verify($password, $req['user_password']))
    echo 'Connecté';
else
    echo 'Identifiant ou mot de passe incorrect';
```

+ index.php
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

            if($req && password_verify($password, $req['user_password']))
                echo 'Connecté';
            else
                echo 'Identifiant ou mot de passe incorrect';
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
+ localhost
```

```

Voilà on recommence en mettant n'importe quoi et évidemment on n'est pas connecté.

En résumé, on récupère les informations. Ensuite, on fait la requête comme ça, ça permet de récapituler. On vérifie du coup via à la roquette qu'on a bien récupéré un utilisateur qui possède $username Indiqué. Si c'est bien qu on prépare notre requête. Si on a bien l'utilisateur qui est récupéré, on vérifie son mot de passe. Et s'il est bien connecter, on l'a indique.

En principe, on devrait vérifier le mot de passe et rediriger vers une nouvelle page ce qui permettrait de ne pas lire la suite.

```php
if($req && password_verify($password, $req['user_password']))
{
    echo 'Connecté';
    header(Location: index.php);
}
else
    echo 'Identifiant ou mot de passe incorrect';
```

Voilà on écrit Location puis le nom du fichier en question (index.php) ait attention pour `Location:`, on ne doit pas faire un espace entre location et les : sinon ça ne fonctionnera pas.

Pour l'instant, ce n'est pas très propre ce qu'on a fait ici, il faudrait peut être même nous l'afficher au niveau du formulaire et cetera mais ce n'est pas le but de la vidéo donc c'est pour ça qu'ici on a un petit peu tout mélangé dans le fichier index.php et ce sera à vous prochainement de séparer l'affichage des traitements.

Ici c'est un petit peu mélangé dans notre fichier index.php mais pour faire ça proprement on ferait ça autrement.

Ce qui nous intéresse, c'est de dire que l'utilisateur est connecté à partir d'ici.

En gros on a la **session** qui va être mise au point donc on va passer par la petite fonction init_php_session() et de faire ceci.

```php
if($req && password_verify($password, $req['user_password']))
{
    init_php_session();
}
else
    echo 'Identifiant ou mot de passe incorrect';
```

Voilà à partir de là on va pouvoir gérer tout un tas d'informations et bien sûr on va pouvoir faire une fonction et là on va pouvoir dire `$_SESSION[‘username'] = $username;`

```php
if($req && password_verify($password, $req['user_password']))
{
    init_php_session();

    $_SESSION['username'] = $username;
}
else
    echo 'Identifiant ou mot de passe incorrect';
```

À partir du moment vous allez vouloir réfléchir une information à l'utilisateur, il ne faut pas oublier d'échapper les caractères même si l'utilisateur a pu se connecter c'est qu'a priori l'utilisateur correspond donc attention c'est dans doute l'utilisateur a mis comme  pseudonyme mais un script javascript. À partir du moment où vous allez vouloir afficher son username, il va exécuter un script et il va y avoir un problème donc toujours attention dès qu'on passe à l'affichage d'information parce qu'il peut y avoir éventuellement de l'exécution de code, de script, donc il faut s'assurer que lorsqu'on va afficher $username qu'il peut y avoir qu'un pseudonyme mais pas autre chose, épingle l'information qui peut être problématique pour la suite.

Après on peut éventuellement ajouter d'autres informations, un peu ce que l'on veut par exemple on va pouvoir récupérer ce qu'on a récupéré de la requête.

```php
if($req && password_verify($password, $req['user_password']))
{
    init_php_session();

    $_SESSION['username'] = $username;
    $_SESSION['rank'] = $req->user_admin;
}
else
    echo 'Identifiant ou mot de passe incorrect';
```

Voilà à partir de là on a récupéré le rang en session `$req->user_admin` donc au fur et à mesure qu'on va naviguer sur la page, on va récupérer ces 2 informations de l'utilisateur qui ont été sauvegardés ainsi ce sont les 2 seules informations qu'on a besoin par rapport à ce qu'on a mis dans la base de données. On a le mot de passe, la date et cetera mais ça on en aura pas besoin donc ces 2 informations là on va s'en servir.

Ainsi pour la fonction is_logged(), on va se servir de ces informations et vérifier que username existe avec la fonction isset() dans tous les cas, dans ce cas-là on retourne vrai.

```php
function is_logged() : bool
{
    if(isset($_SESSION['username']))
        return true;

    return false;
}
```

Ici on vérifie tout simplement si on a bien déjà enregistré une information dans session et ça ça a pu arriver que si on a pu connecter l'utilisateur. Voilà c'est l'utilisateur est connecté on a pu initialiser la session en sauvegardant cette information `$_SESSION[‘username'] = $username ;`. Ainsi cette information existe seulement si l'utilisateur est connecté,  dans l'état connecté.

Voilà on commence par vérifier d'abord qu'il est bien connecté, et maintenant on va vérifier s'il est administrateur et Pour ce faire on va d'abord vérifier qu'il est bien connecter.

```php
function is_admin() : bool
{
    if(is_logged())
        if(isset($_SESSION['rank']) && $_SESSION['rank'] == 1)
            return true;

    return false;
}
```

Du coup si l'utilisateur est connecté, que le rang existe et que le rang égale 1 en admettant que l'administrateur ait un rang 1 mais tout ça dépend de la manière dont on prévoit de distinguer chaque rôle d'utilisateur et dans ce cas-là on va retourner vrai et dans l'inverse des cas, on retourne faux.

On se sert finalement le du retour de is_logged() pour vérifier si c'est un administrateur mais encore faut-il qu'il soit déjà connecté.

On va pouvoir se servir de notre fonction is_logged() au niveau du formulaire HTML Et donc on va intégrer un contenu PHP dans notre fichier HTML Ainsi s'il n'est pas connecté on va afficher le formulaire sinon on affichera simple message de bienvenue et si on veut faire les choses proprement avec une petite sécurité supplémentaire on utilisera `htmlspecialchars($S_SESSION[‘username'])` Pour afficher le nom d'utilisateur en passant par la variable de session.

```php
<?php if(is_logged()): ?>
    <p>Bienvenue <?= htmlspecialchars($_SESSION['username']) ?> !</p>
<?php else: ?>
    <form method="post">
        <input type="text" name="form_username" placehomder="Identification...">
        <input type="password" name="form_password" placeholder="Mot de passe...">
        <input type="submit" name="valid_connection" value="Connexion">
    </form>
<?php endif; ?>
```

Voilà on va actualiser.

+ index.php
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

            if($req && password_verify($password, $req['user_password']))
            {
                init_php_session();

                $_SESSION['username'] = $username;
                $_SESSION['rank'] = $req->user_admin;
            }
            else
                echo 'Identifiant ou mot de passe incorrect';
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

    <?php if(is_logged()): ?>
        <p>Bienvenue <?= htmlspecialchars($_SESSION['username']) ?> !</p>
    <?php else: ?>
        <form method="post">
            <input type="text" name="form_username" placehomder="Identification...">
            <input type="password" name="form_password" placeholder="Mot de passe...">
            <input type="submit" name="valid_connection" value="Connexion">
        </form>
    <?php endif; ?>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```
+ localhost
```
Page d acceuil
Bienvenue sur la page d acceuil

Se connecter
Bienvenue jachampagne !

Acceuil
Page
```

Voilà maintenant comment allons-nous faire pour nous déconnecter ainsi tant que j'ai pas quitté mon navigateur ou relancer une session, Eh bien elle sera toujours enregistré parce qu'il y a une date minimum avant expiration pour une session et ça on l'a vu également. On a vu comment configurer cette expiration pour une session.

On va donc mettre un lien de déconnexion ici. On pourra éventuellement utiliser un bouton mais ça c'est nous qui allons voir.

```php
<?php if(is_logged()): ?>
    <p>Bienvenue <?= htmlspecialchars($_SESSION['username']) ?> | <a href="index.php?action=logout">Se déconnecter</a></p>
<?php else: ?>
    <form method="post">
        <input type="text" name="form_username" placehomder="Identification...">
        <input type="password" name="form_password" placeholder="Mot de passe...">
        <input type="submit" name="valid_connection" value="Connexion">
    </form>
<?php endif; ?>
```

Pour la déconnexion on lui passe comme information `action=logout` pour simplifier, pour ne pas encore avoir ajouté une nouvelle page au site sinon ça va rajouter tout un tas de code inutilement donc je fais juste ça `action=logout` donc c'est une information en GET.

```php
if(isset($_GET['action']) && !empty($_GET['action'] && $_GET['action'] == "logout"))
{
    clean_php_session();
    header('Location: index.php');
}
```

Alors bien sûr on peut faire une page juste pour la déconnexion, ensuite on fait un `header(Location: deconn.php)` qui renvoie sur la page d'accueil par exemple une fois que l'utilisateur est déconnecté.

Voilà on a fait une fonction pour se déconnecter clean_php_session(), ainsi on actualise la page et on reviens sur index.php

Voilà on revient éventuellement sur la page index.php.

Alors on a mis ce code de connexion ici mais si vous voulez proposer le formulaire de connexion sur toutes les pages, vous le mettez sur un menu de connexion ou autre et du coup dans votre template dans la manière dont vous gérez les inclusions de toutes vos pages par exemple du menu de toutes vos pages web, vous aurez ce code de vérification qui sera inclus parce que vous n'allez pas répéter le même code à chaque fois.

Ainsi ici nous avons fait un site statique parce qu'il n'y a pas grand chose de dynamique à part la vérification en base de données pour la connexion mais sinon tout le reste est statique tel qu'on l'a déjà vu comment faire de l'inclusion d'un fichier dans un autre fichier donc c'est très très simple à ce niveau-là.

+ index.php
```php
<?php
    require 'Database.php';
    require 'util.php';
    init_php_session();

    if(isset($_GET['action']) && !empty($_GET['action'] && $_GET['action'] == "logout"))
    {
        clean_php_session();
        header('Location: index.php');
    }

    if(isset($_POST['valid_connection']))
        if(isset($_POST['form_username']) && !empty($_POST['form_username']) && isset($_POST['form_password']) && !empty($_POST['form_password']))
        {
            $username = $_POST['form_username'];
            $password = $_POST['form_password'];

            $sql = 'SELECT * FROM site_users WHERE user_name = :name';
            $fields = ['name' => $username];

            $req = Database::getInstance()->request($sql, $fields);

            if($req && password_verify($password, $req['user_password']))
            {
                init_php_session();

                $_SESSION['username'] = $username;
                $_SESSION['rank'] = $req['user_admin'];
                //On utilise $req['user_admin'] au lieu de $req->user_admin;
            }
            else
                echo 'Identifiant ou mot de passe incorrect';
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

    <?php if(is_logged()): ?>
        <p>Bienvenue <?= htmlspecialchars($_SESSION['username']) ?> | <a href="index.php?action=logout">Se déconnecter</a></p>
    <?php else: ?>
        <form method="post">
            <input type="text" name="form_username" placehomder="Identification...">
            <input type="password" name="form_password" placeholder="Mot de passe...">
            <input type="submit" name="valid_connection" value="Connexion">
        </form>
    <?php endif; ?>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```
+ localhost
```
```

Ainsi si l'utilisateur veut se déconnecter, on fait appel à ces 2 fonctions session_unset() et session_destroy() dont la première va virer toutes les informations là `$_SESSION['username']`, `$_SESSION['rank']` et cetera tandis que destroy va véritablement détruire la session. Ensuite on fait une redirection en propre vers l'index `header('Location: index.php');` sans problème.

Alors vous voyez qu'on peut naviguer d'une page à l'autre **Accueil** à **Page** et inversement alors que vous voyez que sur la **Page**, On devrait bien sûr vérifier que ça passe d'une page à l'autre lorsqu'on est connecté à une session sur la page content.php donc c'est pour ça qu'on a créé cette page et là on va indiquer la même information `<?=htmlspecialchars($_SESSION['username']) ?>` pour voir qu'il est bien passé d'un endroit à l'autre.

+ content.php
```php
<?php
    require 'util.php';
    init_php_session();
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Autre page</title>
</head>
<body>
    <h1>Autre page</h1>

    <p>Bonjour, je sais toujours qui vous êtes <?=htmlspecialchars($_SESSION['username']) ?> :)</p>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```

Ainsi je vais pouvoir changer de page autant de fois que je veux, l'information ne sera jamais perdu et en principe s'il affiche toujours l'username sur toutes les pages c'est qu'on est toujours connecté. Les informations existent tout le temps.

Voilà vous voyez qu'on peut changer de page autant de fois que l'on veut, l'information n'est jamais perdue, et c'est la page affiche le nom d'utilisateur ce qui a priori c'est qu'il est toujours dans l'état connecté ainsi l'information en session existe tout le temps mais maintenant si on se déconnecte qu'on revient sur **Page** on obtiendra une erreur parce que l'information n'existe plus.

+ localhost
```
Autre page
Bonjour, je sais toujours qui vous êtes
Warning: Undefined array key "username" in C:\Users\sam\OneDrive\MyWAMP\apache\htdocs\MonSite\content.php on line 14
:)

Acceuil
Page
```

Ainsi si on va sur **Page**, il y a une erreur parce que l'information n'existe plus mais au moins ça nous montre qu'on a bien nettoyé la super globale `$_SESSION` et donc l'information n'existe plus.

Admettons maintenant qu'on ait besoin d'accéder à une page administrateur et ainsi pour vérifier que l'utilisateur est admin, on peut le faire comme ceci.

```php
<?php if(is_admin()): ?>
    <p>Bonjour ADMIN</p>
<?php endif; ?>
```

+ content.php
```php
<?php
    require 'util.php';
    init_php_session();
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Autre page</title>
</head>
<body>
    <h1>Autre page</h1>

    <p>Bonjour, je sais toujours qui vous êtes <?=htmlspecialchars($_SESSION['username']) ?> :)</p>

    <?php if(is_admin()): ?>
        <p>Bonjour ADMIN</p>
    <?php endif; ?>

    <nav>
        <ul>
            <li><a href="index.php">Acceuil</a></li>
            <li><a href="content.php">Page</a></li>
        </ul>
    </nav>
</body>
</html>
```
```
Autre page
Bonjour, je sais toujours qui vous êtes jachampagne :)

Bonjour ADMIN

Acceuil
Page
```

Et encore une fois le fait de passer par une fonction ça évite de retaper à chaque fois le même code.

Si on connecte ChuckNORRIS qui lui n'est pas admin, et qu'on va sur **PAGE**, on verra que le message d'administration n'est pas affiché.

```
Autre page
Bonjour, je sais toujours qui vous êtes chuckNORRIS :)

Acceuil
Page
```

Voilà ici on a fait l'exemple sur un simple affichage de texte mais imaginez une section administration, ainsi toutes les pages qui sont relatives à l'administration de notre site, on fait en tout début de page c'est à dire avant l'accès à notre page, on fait la vérification c'est l'administrateur est admin. Est ce que l'utilisateur est administrateur ? si oui okay sinon vous indiquez que l'accès est non autorisé Voir même refaire une redirection vers la page d'accueil `header('Location: index.php');`.

Voilà pour cette vidéo de tutoriel.

Pour récapituler, Gardez en tête que le système d'authentification est un **système d'état** c'est à dire que vous devez choisir vous-même comment vous distinguer un simple visiteur d'un utilisateur qui est connecté donc qui est membre de notre site, par rapport à un administrateur, chef technique, développeur et cetera. On peut définir tout un tas de rôles et ainsi définir clairement ces rôles en base de données dans la table des utilisateurs.

N'oubliez surtout pas de stocker vos mots de passe de manière hashé de préférence plutôt que le chiffrement, un petit hash ça suffit.

Également retenez qu'il faut utiliser password_hash(), password_getIngos(), password_verify() Et cetera pour faire toutes les vérifications que l'on a vu dans ce tutoriel.

Nous avons donc utilisé une requête pour récupérer les informations que l'on veut et à partir de là on compare le username et le mot de passe donc c'est à dire le hash en l'occurrence le mot de passe et si les informations sont bonnes, on connecte l'utilisateur en mémorisant les informations que nous voulons dans la super globale `$_SESSION`.

```php
if($req && password_verify($password, $req['user_password']))
{
    init_php_session();

    $_SESSION['username'] = $username;
    $_SESSION['rank'] = $req['user_admin'];
    //On utilise $req['user_admin'] au lieu de $req->user_admin;
}
else
    echo 'Identifiant ou mot de passe incorrect';
```

Ensuite une fois que vous considérez que l'utilisateur veut se déconnecter, il faudra penser à bien tout supprimer, il faudrait utiliser les bonnes fonctions ici.

```php
function clean_php_session() : void
{
    session_unset();
    session_destroy();
}
```

Voilà ici je vous ai montré le système minimal qui est tout à fait réutilisable, qu'il faudra compléter pour que ce soit bien adapté sur votre site.

On a vu un code d'exemple sans aucun design, avec une vraie mise en page sachant bien sûr que le but n'était pas de nous montrer de l’HTML mais c'était de montrer comment ça s’agence et qu'on récupère bien l'information sur la page content.php

Ainsi on peut se servir de ce systèmes pour faire un panier, lorsqu'on crée un site d'e-commerce par exemple, et ainsi dans les variables de session vous pouvez stocker le panier d'un utilisateur et ainsi il peut naviguer d'une page à l'autre en faisant en sorte que tout cela soit conservé donc on peut gérer ce système là.

## Bonus

Alors pour un petit bonus de cette vidéo, comment faisons nous lorsqu'on a un espace membre qui est créé, comment allons-nous faire pour un système de profil ? et bien c'est pareil lorsque vous allez sur la page de profil d'un utilisateur soit vous faites une requête de l'utilisateur pour récupérer toutes les informations soit vous les avez déjà récupérées en variable de session donc ça va dépendre, et à ce moment-là vous affichez les informations du profil de l'utilisateur. Vous proposer éventuellement à l'utilisateur de modifier ces informations donc ça y aura bien sûr des requêtes s'il veut modifier son mail ou son mot de passe ou d'autres informations et voilà c'est toujours aussi simple que ça.

Alors je n'ai pas montrer parce que ça ne concerne pas l'authentification, comment conserver une session même quand on a quitté son navigateur mais je vous donne la petite indication si ça vous intéresse parce que je ne pense pas qu'on fera une vidéo là-dessus sachant qu'on peut pas faire une vidéo pour chaque cas particulier en programmation web, en programmation de secours sinon on aurait 2000000 de vidéos, on peut ensuite tout simplement se servir des cookies.

En gros vous utilisez un cookie, ainsi quand l'utilisateur ré accède à notre site, à sa page, on vérifie si le cookie existe mais attention ne mettez pas l'information en clair dedans au cas où un un pirate pourrait récupérer mes informations à l'intérieur du cookie. Cela fonctionne pareil, il faut mettre les informations chiffrées ou hashées à l'intérieur, et si vous trouvez que le cookie existe et que les informations sont bien indiquées dedans, et bien vous connecter automatiquement l'utilisateur sans qu'il ait besoin de refaire le formulaire.

Voilà on peut choisir ce système là sinon vous pouvez choisir qu'une session expirent au bout d'un certain temps sinon la session va expirer lorsque l'utilisateur va fermer son navigateur donc si vous ne voulez pas que l'utilisateur se reconnecte à chaque fois et il revient sur le site, vous pouvez utiliser ce principe de cookies et mettre un petit bouton "se souvenir de moi" tel qu'on peut le voir sur certains sites.

Ainsi vous mettez juste une cage à cocher et si vous voulez qu'on se souvienne des identifiants la personne, on utilise un simple cookie pour faire ce système là. Ainsi c'est très simple à développer et à mettre en place, il n'y a vraiment rien de compliqué de toute façon on a vu une vidéo sur les cookies, et ainsi pour aller plus loin avec ce tutoriel n'hésitez pas à développer cette petite fonctionnalité supplémentaire et vous verrez que ça n'a rien de compliqué.

Á bientôt tout le monde, ciao ciao.