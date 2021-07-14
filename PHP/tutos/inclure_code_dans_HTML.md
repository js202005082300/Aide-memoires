# [Inclure code dans HTML](https://www.youtube.com/watch?v=n6nid7YgvxI)

Démarrer le serveur : \MyWAMP\apache\bin\httpd.exe
Se connecter au serveur local : localhost\

## Inclure du code HTML avec echo en PHP

```php
<?php

echo '<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page web</title>
</head>
<body>
    <p>Bonjour tout le monde</p>
</body>
</html>';
```
Comme c'est affiché sur la sortie du navigateur il a été capable d'interprêter le html sans DOCTYPE et cetera.

Par contre ce n'est pas propre, tout ce met comme une chaîne et prend la même couleur.

Pour les variables c'est encore pire.

## Inclure du code HTML avec echo en PHP avec une variable

```php
<?php

$title = "Tutoriel PHP";

echo '<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>'.$title.'</title>
</head>
<body>
    <p>Bonjour tout le monde</p>
</body>
</html>';
```

Idem c'est évidemment pas propre et imaginez qu'il faut faire des conditions ou des boucles ce qui va rendre tout le code illisible.

Par ailleurs ça ne sert à rien d'utiliser un langage de programmation comme PHP pour afficher du texte parce qu'il suffit du mettre du html à l'extérieur de balises php dans un fichier php pour que le navigateur puisse l'interprêter.

## Pas besoin de php pour afficher du html

Evidemment dans un fichier php, je peux écrire juste du html et ça fonctionne.

```php
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Tutoriel PHP</title>
</head>
<body>
    <p>Bonjour tout le monde</p>
</body>
</html>
```

Voilà pas besoin de langage de programmation pour ça.

## Utiliser l'interprêteur php au sein de code html

Un moyen raccourcis d'utiliser l'interprêteur php au sein du code html est d'utiliser la syntaxe `<?= ?>` au lieu de `<?php ?>`. Voilà il suffit de faire un égal pour faire un echo.

```php
<?php
$title = "Un nouveau titre";

/*
    <?= $title ?>
    <?php echo $title; ?>
*/
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <p>Bonjour tout le monde</p>
</body>
</html>
```

Le gros avantage c'est qu'on bénéficie de la coloration syntaxique et de l'auto-complétion pour le maintient contrairement au echo qui prend tout comme une chaîne de charactères.

Alors on ne va pas se contenter de faire des echo de variable si on avait que ça, on peut mettre du texte en dur.

```php
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= "ok" ?></title>
</head>
<body>
    <p>Bonjour tout le monde</p>
</body>
</html>
```

On va pouvoir faire des instructions au sein du html pour faire des conditions ou des boucles tel que la fameuse boucle foreach() qui permet de parcourir un tableau.

# Une condition dans du html

```php
<?php
$title = "Un nouveau titre";
$number = 10;
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <?php
    if($number == 10)
        echo "OK";
    else
        echo "PAS OK";
    ?>
</body>
</html>
```

Le problème c'est que si on met nos chaîne avec du html c'est qu'on se retrouve à mettre du html dans echo.

```php
<?php
$title = "Un nouveau titre";
$number = 10;
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <?php
    if($number == 10)
        echo "<p>OK</p>";
    else
        echo "<p>PAS OK</p>";
    ?>
</body>
</html>
```

Voilà le problème pour `<p>PAS OK</p>`, il n'y a pas de coloration syntaxique ou d'autocomplétion.

Voilà ce n'est plus à faire parce qu'on mélange du html avec du php.

Pire encore, attention ça pique aux yeux.

```php
<?php
$title = "Un nouveau titre";
$number = 10;
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <?php

    if($number == 10)
    {
        ?>
        <p>OK</p>
        <?php
    }
    else
    {
        ?>
        <p>PAS OK</p>
        <?php
    }

    ?>
</body>
</html>
```

On ouvre du php et dés qu'on a besoin de html, on ferme le php. On ouvre, ferme, ouvre bref on alterne entre les deux ce qui n'est pas propre.

En php, ils ont prévu une syntaxe spéciale qui va faciliter la vie quand on veux lier les deux parce que dans pas mal de projet, le php va être utilisé au final par le développeur front-end qui va se servir des résultats des programmes en php pour afficher quelque chose avec du html, du css.

## Conditions - Syntaxe recommandé

```php
<?php
$title = "Un nouveau titre";
$number = 10;
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <?php if($number == 10): ?>
        <p>OK</p>
    <?php else: ?>
        <p>PAS OK</p>
    <?php endif>
</body>
</html>
```

Il faut mettre deux points ':' avant de fermer la balise php.

Et comme on mélange un peu les deux, on est obligé de donner la fin de la conditions soit endif, endfor, endwhile, endforeach. On met le end- quelque chose et un ';' à la fin.

Voilà c'est plus clair au niveau de lisibilité.

Gros avantage en entreprise, on sépare le rôle des développeurs. Ensuite l'intégrateur, celui qui fait du html css et qu'il a besoin de manipuler des données en php et faire des conditions, il aura juste à apprendre ces syntaxe là : <?php if($number == 10): ?> ... <?php endif>.

Il apprendra un peu de php mais minimaliste et on retrouve ce ces syntaxe là pour les systèmes de template ce qui permet de faire tout un tas de gabarit pour votre site et le réutiliser sur plusieurs page.

On retrouve ce système là notamment sur les systèmes de templates qui permet de faire tout un gabarit pour votre site et le réutiliser sur plusieurs pages souvent les systèmes de template maintenant utilisent ce type de notation ou une autre, il y a une notation avec des % également qui est une notation dit ASP donc un autre langage qui permet pour quelqu'un qui ne fait pas de programmation comme l'intégrateur html css et bien d'utiliser des conditions, de faire des boucles alors que dans un langage comme html ça n'existe pas donc il aura juste à apprendre.

Voilà l'exemple pour les conditions.

## Boucle - Syntaxe recommandé

```php
<?php
$title = "Un nouveau titre";
$number = 10;
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <?php while($number < 20): ?>
        <p>J'affiche une ligne</p>
    <?php $number++; ?>
    <?php endwhile; ?>
</body>
</html>
```

On va utiliser un for pour faire ça parce c'est plus propre.

```php
<?php
$title = "Un nouveau titre";
$number = 10;
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <?php for(; $number < 20; $number++): ?>
        <p>J'affiche une ligne</p>
    <?php endfor; ?>
</body>
</html>
```

Si on a un tableau, on ferra un foreach().

```php
<?php
$title = "Un nouveau titre";
$tab = [1, 2, 3, 4];
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><?= $title ?></title>
</head>
<body>
    <?php foreach($tab as $element): ?>
        <p><?= $element ?></p>
    <?php endforeach; ?>
</body>
</html>
```

Voilà on a fait une boucle dans du html grâce à php parce qu'encore une fois, il nous faut un langage de programmation pour faire ça.

Attention un intégrateur web n'est pas développeur web, c'est deux métiers différents.

En résumé, on peut avoir des variables, des conditions et des boucles php dans du codes html.

```php
/*
    <?= $variable ?>
    <?php echo $variable; ?>

    if():
    elseif():
    endif;

    for():
    endfor;

    while():
    endwhile;

    foreach():
    endforeach;
*/
```

Utiliser de préférence celle ci <?= $variable ?>, en principe aucune raison qu'elle ne fonctionne pas sur votre confirguration et les hébergeurs que vous utiliser sur internet soit OVH, One&One, et cetera. Il n'y a pas de raison que ça ne fonctionne pas.

N'oubliez pas de garder le HTML en dehors de php parce qu'il n'y a pas besoin de langage de programmation pour être interprêter par votre navigateur, il le fait tout seul comme un grand.

Dés qu'il a besoin de manipuler de la programmation, de manipuler des données, des variables, de faire des boucles, des conditions ce que html pour le coup ne sait pas faire, à ce moment là on a une syntaxe tout prévu pour gérer ça dans html sans devoir me mettre un echo de tout le code comme je vous l'ai montrez en début de vidéo ce qui serait évidemment pas propre.

Voilà c'est finis, c'était une annexe au cours de php.