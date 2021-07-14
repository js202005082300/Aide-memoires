<?php

class Vehicle
{
	private $_name;
	
	public function __construct(string $name)
	{
		$this->_name = $name;
	}
	
	public function move()
	{
		echo $this->_name.' se deplace...';
	}
}

$obj1 = new Vehicle('Mon bolide');
$obj1->move();