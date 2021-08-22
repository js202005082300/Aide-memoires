# [shells Windows](#)

## [Powershell](https://ss64.com/ps/)
> [Doc Scripting PowerShell](https://docs.microsoft.com/en-us/powershell/scripting/lang-spec/chapter-01?view=powershell-7.1)
+ Change le prompt
```powershell
function prompt {"> "}
```
+ Simple boucle
```powershell
for ($i=1;$i -le 10;$i++){echo dossier$i}
for ($i=1;$i -le 10;$i++){mkdir dossier$i}
for ($i=1;$i -le 10;$i++){rm dossier$i}
Remove-Item test.txt
```

## [Batch](#)

> [Source](https://ss64.com/nt/)
```batch
@echo off &::affiche le résultat uniquement
chcp 65001 &::encodage UTF-8
title MonTitre
color B0 &::format <background>/<foreground>
:: 0 (noir), 1 (bleu), 2 (vert), 3 (aqua), 4 (rouge), 5 (violet), 6 (jaune), 7 (blanc), 8 (gris), 9 (bleu clair), A (vert clair), B (aqua clair), C (rouge clair), D (violet clair), E (jaune clair) et F (blanc lumineux).
mode CON COLS=32 LINES=25
```
### variables
```batch
set "P=C:\Users\sam\test\"
::compteur et incrémentation
set i=0
set /a i+=1
::saisie au clavier
set /p a[0].str=votre chaîne ? 
::variables d'environnement
setx MYPATH "%MYPATH%;%cd%\mysql\bin;%cd%\apache\bin" &::ajouter manuellement MYPATH à PATH
```
### Tableaux et structures
```batch
set /p a[0].str=votre chaîne ? 
set a[0].int=30
```
### Boucles
```batch
::for
for /l %a in (1 1 3) do @echo %a

set "str=Passer le premier caractère rencontré en minuscule"
for /F "tokens=1-7 delims= " %i in ("%str%") do @echo %i_%j_%k_%l_%m_%n_%l_%o
Passer_le_premier_caractère_rencontré_en_caractère_minuscule

:: lister le répertoire et le stocker dans un tableau.
set i=0
Setlocal EnableDelayedExpansion
for /f "delims=" %%B in ('DIR /B') do (
	echo !i!:%%B
	set TAB[!i!]=%%B
	set /a i+=1
)
endlocal

::<label>
set i=0
:loop
set /a i+=1
echo %i%
if %i% lss 9 goto loop
```
### Dossier et fichier
```batch
mkdir MonSite
(echo ^<!-- 
echo Je suis un 
echo fichier html
echo --^>) > MonSite/fichier.html
```
### Date
```batch
set date_auj=%date:~0,2%%date:~3,2%20%date:~6,4%
echo %date_auj%
```
### Chaîne de caractères
```batch
set str=123456789abcdef0

:: extraire 5 premiers caractères.
set subStr=%str:~0,5%
echo %subStr%
::12345

:: extraire 5 caractères àpd du 8e.
set subStr=%str:~7,5%
echo %subStr%
::89abc

:: extraire tous les caractères àpd du 8e
set subStr=%str:~7%
echo %subStr%
::89abcdef0

:: extraire les 7 dernier caractères.
set subStr=%str:~-7%
echo %subStr%
::abcdef0

:: extraire tout sauf les 7 dernier caractères.
set subStr=%str:~0,-7%
echo %subStr%
::123456789

:: extraire entre les 7 du début et les 5 de la fin.
set subStr=%str:~7,-5%
echo %subStr%
::89ab

:: extraire 5 caractères de la fin avant les 7 derniers.
set subStr=%str:~-7,5%
echo %subStr%
::abcde

:: extraire entre 7 de la fin et 5 de la fin.
set subStr=%str:~-7,-5%
echo %subStr%
::ab

:: extraire avec une longueur variable
set startChar=2
set length=1
set str=884777
call set subStr=%%str:~%startChar%,%length%%%
echo (%subStr%)
::(4)
```
```batch
:: remplacer.
set str=monSuperFichier
set str=%str:Super=Petit%
echo %str%

:: suprimer.
set str=monSuperFichier
set str=%str:Super=%
echo %str%

:: suprimer ce qui prècede un mot (non compris).
set str=monSuperFichier
set str=%str:*Super=%
echo %str%

:: suprimer ce qui suit un mot (compris).
set str=monSuperFichier
set tmp=%str:*Super=%
call set str=%%str:%tmp%=%%
echo %str%

:: remplacer espace par _
set str= je suis Denver le dernier dinosaure.
set str=%str: =_%
echo %str%

:: trouver une sous chaîne.
set str="je suis Denver le dernier dinosaure."
set tmp=%str:Denver=%
if not %tmp% == %str% (echo Denver trouvé.) else (echo Denver non trouvé.)

set "str=je suis Denver le dernier dinosaure."
set "subStr=Denver"
call set tmp=%%str:%subStr%=%%
if /i "%tmp%"=="%str%" (echo %subStr% non trouvée.) else (echo %subStr% trouvé.)

:: échapper et remplacer par %.
Setlocal EnableDelayedExpansion
set str=toutPvaPbien.
set str=!str:P=%%!
echo %str%
endlocal
```
> Sources et curiosités :  
https://ss64.com/nt/syntax-replace.html  
https://ss64.com/nt/syntax-substring.html  
https://www.dostips.com/DtTipsStringManipulation.php  

### Recherche menu
```batch
:: moteur de recherche.
set "dos=C:\Users\sam\Desktop\dossierXXX"
set /p sousDos=Chercher ? 
setlocal EnableDelayedExpansion
set i=0
for /f "delims=" %%A in ('DIR /b %dos%') do (
	set "temp=%%A"
	set res=!temp:%sousDos%=!
	if not "!res!"=="!temp!" (
		echo [!i!]%%A
		set tab[!i!]=%%A
		set /a i+=1
	)
)
set /p x=Que voulez vous ouvrir ? 
start /max %dos%\!tab[%x%]!\
endlocal
```
### Fonction simple
```batch
set "myvar="
echo %myvar%
call :myfunction myvar
echo %myvar%
pause & exit

:myfunction
set %1=filled
goto :eof
```
### strlen, retourne la taille d'une chaîne de caractères
```batch
set len=
set "str=samuel"
echo initial : %str%
call:strlen %str% len
echo final: %str% a %len% charactères.
pause & exit

:strlen
setlocal
set "i=1" & set "str=%~1"
:strlen_loop
set str=%str:~0,-1%
if "%str%"=="" ( endlocal & set /a %2=%i% & goto:eof ) else ( set /a i+=1 & goto strlen_loop )
```
### nombre aléatoire
```batch
set /a x=%RANDOM% * 100 / 32768 + 1 #nombre aléatoire entre 1 et 100.
set /a x=%random%*2/32768+1 || if %x%==1 ( echo nombre 1 ) else ( echo nombre 2 )
```
### Paramètres
```batch
:: taille fichier.
for %G in ("C:\Users\sam\Desktop\main.bash") do @echo %~zG
::167

:: date/heure fichier.
for %G in ("C:\Users\sam\Desktop\main.bash") do @echo %~tG
::21-03-21 12:57

:: attributs fichier.
for %G in ("C:\Users\sam\Desktop\main.bash") do @echo %~aG
::--a--------

:: afficher les variables d'environnement.
for %G in (%PATH%) do @echo %G

:: ~ retire les quotes.
for %G in ("C:\Users\sam\Desktop\main.bash") do @echo %~G
::C:\Users\sam\Desktop\main.bash
for %G in ("C:\Users\sam\Desktop\main.bash") do @echo %G
::"C:\Users\sam\Desktop\main.bash"
```
> src :  
https://ss64.com/nt/syntax-args.html  

### Quitter
```batch
endlocal & pause & exit
```
### VLC (& touches de raccourcis globales)
```batch
vlc.exe https://www.youtube.com/watch?v=wItB9sia1rg & EXIT

--global-key-play-pause=Esc
--global-key-jump-extrashort=Insert
--extrashort-jump-size=1.5
--rate=1.3
--start-time=%RES% &::SET /A RES=%SEC%+%MIN%*60
--video-on-top

::dans une boucle
Setlocal EnableDelayedExpansion
	vlc.exe --global-key-play-pause=Esc --global-key-play-pause=Esc --global-key-jump-extrashort=Insert --extrashort-jump-size=1 --rate=1.2 "%P%!TAB[%X%]!" 
endlocal
```