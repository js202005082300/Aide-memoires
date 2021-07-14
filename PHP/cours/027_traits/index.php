<?php

trait tRouting
{
	function parse()
	{
		echo 'parsing...';
	}
	
	function get($req)
	{
		echo $req;
	}
}

class ModuleManager
{
	use tRouting;
}

class Template
{
	use tRouting;
}

$test = new ModuleManager();
$test->parse();
echo '<br>';
$html = new Template();
$html->get('news/mon-remier-article');

?>