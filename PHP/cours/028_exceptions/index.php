<?php

function show_error($ex)
{
	echo 'ERREUR : '.$ex->getMessage();
}

//set_exception_handler('show_error');

throw new Exception("Utilisateur introuvable");