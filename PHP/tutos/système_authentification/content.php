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