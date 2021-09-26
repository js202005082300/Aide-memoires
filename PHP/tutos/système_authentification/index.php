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