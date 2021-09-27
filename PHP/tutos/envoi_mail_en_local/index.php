<?php

$to = "js202002080712@gmail.com";
$subject = "Utilisation de mail() avec PHP depuis Windows";
$message = "Salut, comment ça va ? 😀";

$headers = "Content-Type : text/plain; charset=utf-8\r\n";
$headers .= "From: js202002080712@gmail.com\r\n";

if(mail($to, $subject, $message, $headers))
    echo 'Envoye !';
else
    echo 'Erreur envoi';