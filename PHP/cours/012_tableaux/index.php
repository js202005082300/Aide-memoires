<?php

$tab_population_villes = 
[
	"Paris" => 14000,
	"Orléans" => 8,
	"Clermont-Ferrand" => 146
];

$nom_ville = "Paris";

foreach($tab_population_villes as $key => $value)
	echo '<p>'.$key.' / '.$value.'<p>';

?>