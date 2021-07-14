<?php

class Vehicle
{
	private $_name;
	private $_speed;
	
	public function getName()
	{
		return $this->_name;
	}

	public function setName(string $name)
	{
		if(strlen($name) > 25)
			echo 'ERREUR : Nom de vehicule trop long';
		else
			$this->_name = $name;
	}
	
	public function __construct(string $name, int$speed)
	{
		$this->_name = $name;
		$this->_speed = $speed;
	}
	
	public function move()
	{
		echo 'Le Vehicule '.$this->_name.' se deplace a '.$this->_speed.'km/h';
	}
}

//Nous sommes en dehors de la classe
$obj1 = new Vehicle('XC450', 650);
echo $obj1->getName();
$obj1->setName('XF22000000000000000000646484151168890000');
echo $obj1->getName();