<?php

$myFile = fopen("infos.txt", "ab+");

if(!$myFile)
	exit("Ouverture du fichier impossible");//die()

fputs($myFile, "Une nouvelle information\r\n");

if(!fclose($myFile))
	exit("Fermeture du fichier echouee");