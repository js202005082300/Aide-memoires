<?php

class Vehicle
{
	public function __construct()
	{
		echo 'Je suis construit !';
	}
	
	public function __destruct()
	{
		echo 'Je suis détruit !';
	}
}

$obj1 = new Vehicle();
$obj2 = new Vehicle();