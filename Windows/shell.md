# [shells Windows](#)

+ [Powershell](#Powershell)
+ [Batch](#Batch)

>

## [Powershell](https://ss64.com/ps/)
> [Doc Scripting PowerShell](https://docs.microsoft.com/fr-fr/powershell/)

### Change le prompt
```ps1
function prompt {"> "}
```

### Version
```ps1
Get-Host
```

### Variable de préférence/d'encodage
```ps1
$PSDefaultParameterValues['Out-File:Encoding'] = 'utf8' # Pour les sorties avec les opérateurs de redirection > et >>
$PSDefaultParameterValues['*:Encoding'] = 'utf8' # Pour les commandes qui ont le paramètre Encoding

$PSDefaultParameterValues['*:Encoding'] = 'utf8'

# Zone
[Threading.Thread]::CurrentThread.CurrentCulture = 'fr-BE'

## Informations sur l'encodage
[psobject].Assembly.GetTypes() | Where-Object { $_.Name -eq 'ClrFacade'} |
ForEach-Object {
    $_.GetMethod('GetDefaultEncoding', [System.Reflection.BindingFlags]'nonpublic,static').Invoke($null, @())
}
```

### Créer un objet (une chaîne)
```ps1
$Filepath = Get-Item "C:\Users\52556\OneDrive - SPW\CODE\_PS1_\Imprimer"
```

### Saisie
```ps1
$test = Read-Host -Prompt 'Un messag?'
```

### Créer un fichier ou un répertoire
```ps1
New-Item -Path 'Texte.txt' -ItemType File -Encoding "UTF8"
```

```ps1
New-Item c:\directory -ItemType directory
md c:\directory
```

### Détruire un fichier
```ps1
Remove-Item test.txt
```

### Nombre de fichier
```ps1
(Get-Item *.sql).Count
```

### Retourne les propriétés d'un fichier
```ps1
Get-Item -Path $Filepath | Get-Member -MemberType Properties

echo $Filepath.Exists
echo $Filepath.Length
echo $Filepath.BaseName # [System.IO.Path]::GetFileNameWithoutExtension($Filepath)
echo $Filepath.Extension
echo $Filepath.Name
echo $Filepath.DirectoryName # Split-Path $Filepath
echo $Filepath.FullName
```

### La date du jour
```ps1
"Today is $(Get-Date)"
[datetime]::Now # opérateur de classe
(Get-Date).ToShortDateString()
```

### Autre exemple d'opérateur de classe :
```ps1
'MinValue', 'MaxValue' | Foreach-Object { [int]:: $_ }
```

### Créer un tableau
```ps1
$myArray = 1,2,3
$SingleArray = ,1
Write-Output (,1)
```

### Colletion & Index opérateur
```ps1
$a = 1, 2, 3
$a[0]
$a[-1]
$a[2, 1, 0]

(2,2,5)[2]
(2)[1] -eq $null
(2)[0,0] -eq $null

$h = @{key="value"; name="PowerShell"; version="2.0"}
$h["name"]

$x = [xml]"<doc><intro>Once upon a time...</intro></doc>"
$x["doc"]
```

### Conditions
```ps1
if ($a -gt 2) {
    Write-Host "The value $a is greater than 2."
}
elseif ($a -eq 2) {
    Write-Host "The value $a is equal to 2."
}
else {
    Write-Host ("The value $a is less than 2 or" +
        " was not created or initialized.")
}
```

### Opérateurs logiques
```ps1
(1 -eq 1) -and (1 -eq 2) # False
(1 -eq 1) -or (1 -eq 2) # True
(1 -eq 1) -xor (2 -eq 2) # False
-not (1 -eq 1) # False
!(1 -eq 1) # False
## [Opérateurs de comparaisons](https://docs.microsoft.com/fr-fr/powershell/module/microsoft.powershell.core/about/about_comparison_operators?view=powershell-7.2)
# -eq       égal à
# -ne       non égal
# -gt       supérieur à
# -ge       supérieur ou égal à
# -lt       inférieur à
# -le       inférieur ou égal à
$a = (1, 2) -eq 3
$a.GetType().Name # Object[]
$a.Count # 0

$a = 1, 2, $null, 4, $null, 6
$a -ne $null # Output: 1, 2, 4, 6

$a=5, 6, 7, 8, 9
Write-Output "Test collection:`n"
$a
$a -gt 7 # Members greater than 7
$a -ge 7 # Members greater than or equal to 7
$a -lt 7 # Members smaller than 7
$a -le 7 # Members smaller than or equal to 7

## Switch

switch (3)
{
   1 {"Un."}
   2 {"Deux."}
   3 {"Trois."}
   4 {"Quatre."}
}
```

### Imprimer en pdf
```ps1
Get-Content -Path ./readme.txt | Out-Printer -name "Microsoft Print to PDF"
```

### Réécriture de System.IEquatable<T> pour comparer deux fichiers
```ps1
class MyFileInfoSet : System.IEquatable[Object] {
    [String]$File
    [Int64]$Size

    [bool] Equals([Object] $obj) {
        return ($this.File -eq $obj.File) -and ($this.Size -eq $obj.Size)
    }
}
$a = [MyFileInfoSet]@{File = "C:\Windows\explorer.exe"; Size = 4651032}
$b = [MyFileInfoSet]@{File = "C:\Windows\explorer.exe"; Size = 4651032}
$a -eq $b
```

### Ternaire
```ps1
$message = (Test-Path $path) ? "Path exists" : "Path not found"

$service = Get-Service BITS
$service.Status -eq 'Running' ? (Stop-Service $service) : (Start-Service $service)
```

### Boucles
```ps1
for ($i=1;$i -le 10;$i++){echo dossier$i}
for ($i=1;$i -le 10;$i++){mkdir dossier$i}
for ($i=1;$i -le 10;$i++){rm dossier$i}

1..10 # Opérateur de plage ..
foreach ($a in 1..$max) {Write-Host $a}
10..1
5..-5 | ForEach-Object {Write-Output $_}
'a'..'f'
'F'..'A'
```

### Chaîne de caractères
```ps1
Get-ChildItem *.txt | Rename-Item -NewName { $_.name -creplace '\.txt$','.log' }
# -replace, -ireplace : case isentisitive
# -creplace : case sensitive
```

### Exécuter un script dans l'étendue actuelle
```ps1
. c:\scripts\sample.ps1 1 2 -Also:3
```

### Process
```ps1
Get-Process | Get-Member
Get-Service | Where-Object {$_.StartType -eq 'Automatic'}
Get-Process notepad && Stop-Process -Name notepad # si notepad est trouvé
(Get-Process PowerShell).kill()
```

### Install
```ps1
npm install || Remove-Item -Recurse ./node_modules # si npm est installé
```

### Créer un fichier word
```ps1
[Threading.Thread]::CurrentThread.CurrentCulture = 'fr-BE'
$word = New-Object -ComObject "Word.Application" # Lancement de MS Word
$word.Visible = $True # Word se lance
$doc = $word.documents.add() # créer un document vide
$doc.content.text = "=== Computer report ==="
# Quelques variables de remplissage
$description = Get-WmiObject -Class Win32_OperatingSystem | Select Description
$version = Get-WmiObject -Class Win32_OperatingSystem | Select Version
$processor = Get-WmiObject win32_processor | Select Name
$others = Get-WmiObject -Class Win32_ComputerSystem

$doc.content.insertparagraphafter()
$doc.Paragraphs.item(2).range.font.name = "Calibri"
$doc.Paragraphs.item(2).range.font.size = 11
$doc.Paragraphs.item(2).range.text = "Computer name : " + $env:computername + "`nDescription : " + $description.Description + "`nVersion OS : " + $version.Version + "`nProcesseur : " + $processor.Name + "`nManufacturer : " + $others.Manufacturer + "`nModel : " + $others.Model + "`nComputer Name : " + $others.Name + "`nPhysicial Memory (RAM) : " + $others.TotalPhysicalMemory + "`nCurrent user logged : " +  [Environment]::UserName + "`nFull login : " + $others.PrimaryOwnerName + "`nDomain : " + $others.Domain 

$doc.SaveAs("C:\Users\Thibault\Desktop\Computer_Report.docx") # Pour éventuellement sauvegarder le fichier
$doc.close() # Pour fermer le document en cours dans Word (Word reste démaré)
$word.Quit() # Pour quitter Word
$doc.SaveAs("C:\Users\52556\Desktop\Computer_Report.docx", $FormatPDF)
$doc.close()
$word.Quit()

$null = [System.Runtime.InteropServices.Marshal]::ReleaseComObject([System.__ComObject]$word)
[gc]::Collect()
[gc]::WaitForPendingFinalizers()
Remove-Variable word
```

>

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