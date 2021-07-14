<?php

class Card
{
	protected $_name;
	protected $_description;
	
	public function __construct($name, $description)
	{
		$this->_name = $name;
		$this->_description = $description;
	}
	
	public function hello()
	{
		echo 'Je suis la carte '.$this->_name;
	}
}

class TrapCard extends Card
{
	private $_effect;
	
	public function __construct($name, $description, $effect)
	{
		parent::__construct($name, $description);
		$this->_effect = $effect;
	}

	public function hello()
	{
		echo 'Nom : '.$this->_name.'<br>';
		echo 'Description : '.$this->_description.'<br>';
		echo 'Effet : '.$this->_effect.'<br>';
	}
}

$mytrapcard = new TrapCard('Fosse', 'Une grande fosse...', 'Detruit tous les ennemis sur le terrain');
$mytrapcard->hello();
echo '<br><br>';
$myotherCard = new Card('test', 'ma description');
$myotherCard->hello()

?>