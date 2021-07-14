<?php

abstract class Mere
{	
	abstract protected function parler($message);
}

class Fille extends Mere
{	
	public function parler($message, $param = 10)
	{
		echo $message.' | '.$param.'<br>';
	}
}

$obj = new Fille();
$obj->parler('Bonjour');
$obj->parler('Comment vas-tu ?');

?>