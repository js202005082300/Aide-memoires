<?php

$nb1 = 14;
$nb2 = "8";

$result = ($nb1 != $nb2) && (gettype($nb1) != gettype($nb2));

if($result)
	echo "Différents en valeur ET en type";