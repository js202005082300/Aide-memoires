<?php

$number = 0;

while($number < 10)
{
	$number++;
	
	if($number == 5)
		continue;
		
	echo '<p>'.$number.'<p>';
}