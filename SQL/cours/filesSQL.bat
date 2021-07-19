@echo off
:: NE SURTOUT PAS ACTIVER .BAT SUR DES FICHIERS DEJA EXISTANT SANS IF NOT EXIST.
:: Comparaison :
:: EQU - égal à
:: NEQ - différent de
:: LSS - inférieur à
:: LEQ - inférieur ou égal à
:: GTR - supérieur à
:: GEQ - supérieur ou égal à 

:: encodage UTF-8.
chcp 65001

::==================== Mise en tableau de structures ========================

setlocal enabledelayedexpansion 

SET "file=C:\Users\js201\OneDrive\Formations\Programmation\FormationVideo\Playlists\sql-cours.md"
SET count=0

FOR /F "tokens=3 delims=.[] skip=3" %%i IN ('type %file%') DO (
	set "n=%%i"
	set "n=!n: =_!"
	set tab[!count!].name=!n!
	set /A count+=1 )

SET count=0

FOR /F "tokens=2 delims=() skip=3" %%i IN ('type %file%') DO (
	SET tab[!count!].link=%%i
	SET /A count+=1 )

::======================== Création des fichiers ============================

set /a V = 1
set /a X = 0
set "MYCUSTOMTAB=		"
set "S= "
:BOUCLE
IF %V% LEQ 9 (
	set NAME=00%V%_SQL.sql
	set NUM=00%V%!tab[%X%].name!
) ELSE IF %V% LEQ %count% (
	set NAME=0%V%_SQL.sql
	set NUM=0%V%!tab[%X%].name!
) ELSE (
	PAUSE&EXIT
)
mkdir %NUM%

set "n=!tab[%X%].name!"
set "n=!n:_= !"

IF NOT EXIST %NAME% (
	echo.%MYCUSTOMTAB%/*
	echo.%MYCUSTOMTAB%╔═══════════════════════╦═══════════════════════════════════════════════════════════╗
	echo.%MYCUSTOMTAB%║Formation				║	SQL cours -!n!								║
	echo.%MYCUSTOMTAB%║YouTube				║	!tab[%X%].link!				║
	echo.%MYCUSTOMTAB%║Auteur					║	Jason Champagne											║
	echo.%MYCUSTOMTAB%║Langage				║	MySQL													║
	echo.%MYCUSTOMTAB%║Paradigme				║	Langage de requête										║
	echo.%MYCUSTOMTAB%║Compilateur			║	-														║
	echo.%MYCUSTOMTAB%║Interprêteur			║	-														║
	echo.%MYCUSTOMTAB%╠═══════════════════════╬═══════════════════════════════════════════════════════════╣
	echo.%MYCUSTOMTAB%║Date					║	%DATE%												║
	echo.%MYCUSTOMTAB%║Dernière modification	║	%DATE%												║
	echo.%MYCUSTOMTAB%╚═══════════════════════╩═══════════════════════════════════════════════════════════╝
	echo.%MYCUSTOMTAB%*/
	echo.
	echo.
	echo.%MYCUSTOMTAB%/*
	echo.
	echo.%MYCUSTOMTAB%====================
	echo.
	echo.
	echo.
	echo.%MYCUSTOMTAB%--------------------
	echo.
	echo.%MYCUSTOMTAB%*/
	echo.
	echo.%MYCUSTOMTAB%/*
	echo.
	echo.%MYCUSTOMTAB%====================
	echo.
	echo.
	echo.
	echo.%MYCUSTOMTAB%--------------------
	echo.
	echo.%MYCUSTOMTAB%*/
	echo. ) > %NUM%/%NAME%
)

set /a V = %V% + 1
set /a X = %X% + 1
GOTO BOUCLE

ren filesSQL.bat filesSQL.txt