<?php

class Database
{
	public static $_sgbd = 'MySQL';
	
	public static function connect()
	{
		echo 'Je me connecte...';
	}
}

//En dehors de la classe
echo Database::$_sgbd;