# [C++ #1 - introduction](https://www.youtube.com/watch?v=f3UVQPbw32w)
19-03-21

langage de programmation C++, créé par Bjarne Stroustrup en 1983, et très employé dans de nombreux domaines de l'informatique.

Bjarne Stroustrup est un Danois qui publie encore des travaux.

Compiler un code pour obtenir un programme que l'on va rendre exécutable sur une machine. Pour cela, on passe par un compilateur par exemple le compilateur du projet GNU qui est gcc qui possède un alias g++ pour compiler g++.

## Installation de l'éditeur

> [Visual Studio Code](https://github.com/js202005082300/Aide-memoires/blob/main/Aide/VS_Code.md)  

## Installation du compilateur

Pour les distributions Debian, on a ce paquet `sudo apt-get install build-essential`.

En installant gcc, on installe également un débogueur tel que gdb dont parlera plutard.

Le compilateur doit prendre en compte les derniers standards parce que c++ est un langage qui continue d'évoluer.

Au minimum, il faut avoir une version 8 de gcc/g++ parce qu'elle prend en charge le standard **C++ 2017** qui reprend la totalité des fonctionnalités pour suivre la formation.

```
C:\Users\sam>gcc --version
gcc (MinGW.org GCC Build-2) 9.2.0
Copyright (C) 2019 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
```

On a un dépot ppa sur la doc d'Ubuntu mais finallement on parvient à mettre gcc 10 (> à 8) avec `apt upgrade`.

```bash
#https://doc.ubuntu-fr.org/gcc
#sam@sam:~$ sudo add-apt-repository ppa:ubuntu-toolchain-r/test
sam@sam:~$ sudo apt update
sam@sam:~$ sudo apt upgrade

#infos, pour agrandir/rétraicir VB.
#cd "C:\Program Files\Oracle\VirtualBox"
#VBoxManage.exe modifyhd "C:\Users\%USERNAME%\VirtualBox VMs\Ubuntu\Ubuntu.vdi" --resize 32000
#VBoxManage.exe modifyhd "C:\Users\%USERNAME%\VirtualBox VMs\Ubuntu\Ubuntu.vdi" --compact 32000

sam@sam-sam:~/Bureau$ gcc --version
gcc (Ubuntu 9.3.0-17ubuntu1~20.04) 9.3.0
Copyright (C) 2019 Free Software Foundation, Inc.
This is free software; see the source for copying conditions.  There is NO
warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
```

Pour Windows,

Tutoriel Windows - 
[installer MinGW (vidéo)](https://www.youtube.com/watch?v=y-i96kqT53A&t=504s) - 
[installer MinGW (note)](https://github.com/js202005082300/Aide-memoires/blob/main/Windows/Tutoriel_Windows/installer_MinGW.md)