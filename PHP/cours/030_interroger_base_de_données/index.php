<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
	];
	
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
	
	$sql = 'SELECT * FROM fv_clients';
	
	$results = $PDO->query($sql);
	
	$list_clients = $results->fetchAll(PDO::FETCH_ASSOC);
	
	foreach($list_clients as $client)
	{
		echo '<p>'.$client['client_firstname'].'</p>';
	}
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>