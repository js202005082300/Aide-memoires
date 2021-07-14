<p><a href="index.php">&laquo; Retour au formulaire</a></p>

<pre>
<?php
/*
	isset() : FALSE -> 	NULL
						var $maVariable;
	
	empty() : FALSE ->	" "
						TRUE
						\0
*/

if(isset($_POST['user']) && !empty($_POST['user']))
		echo htmlspecialchars($_POST['user']);

if(isset($_POST['choice']) && !empty($_POST['choice']))
		echo htmlspecialchars($_POST['choice']);

?>
</pre>