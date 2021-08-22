# [[ARCHIVE] Hacking #4 - débogage langage C](https://www.youtube.com/watch?v=Ve9eDc3N-pQ&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=11)

> Les commandes de débogage vues
+ [help](#help)
+ [run ou r](#run-ou-r)
+ [break](#break)
+ [info](#info)
+ [continue ou cont](#continue-ou-cont)
+ [step](#step)
+ [next](#next)
+ [pwd](#pwd)
+ [delete](#delete)
+ [disable et enable](#disable-et-enable)
+ [print ou p](#print-ou-p)
+ [whatis](#whatis)
+ [display](#display)
+ [slash d u f c t o x a](#slash-d-u-f-c-t-o-x-a)
+ [set variable](#set-variable)
+ [rwatch](#rwatch)
+ [watch](#watch)
+ [awatch](#awatch)
+ [show args](#show-args)
+ [show env](#show-env)
+ [show env Path](#show-env-Path)
+ [whatis main](#whatis-main)
+ [where](#where)

Présentation de l'outil GDB et de ses commandes.

Afficher les information de débogage avec `-g`.
```c
#include <stdio.h>

int main(void)
{
    for(int i = 0 ; i < 10 ; i++)
        printf("Variable i vaut %d.\n", i);

    return 0;
}
```
```powershell
function prompt {"> "}
```
```powershell
> gcc -g main.c
> gdb .\a.exe
    #...
    #Copyright (C) 2020 Free Software Foundation, Inc.
    #...
    #Reading symbols from .\a.exe...
(gdb) 
(gdb) q
```
2 moyens pour by-passer les affichages de début.
```powershell
> gdb -silent
(gdb) q
```
```powershell
> gdb -q     
(gdb) q
>
```

## help

Afficher des classes de commandes.
```powershell
> gdb -q a.exe
(gdb) help 
List of classes of commands:  #...
(gdb)
```
```powershell
(gdb) help run
#...
```
```powershell
(gdb) help break
#...
```
Pour la totalité des commandes...
```powershell
(gdb) help all
#...
#...
#...
#...
```

## run ou r

```powershell
(gdb) r         
Starting program: C:\a.exe
[New Thread 2864.0x286c]
Variable i vaut 0.
Variable i vaut 1.
Variable i vaut 2.
Variable i vaut 3.
Variable i vaut 4.
Variable i vaut 5.
Variable i vaut 6.
Variable i vaut 7.
Variable i vaut 8.
Variable i vaut 9.
[Thread 2864.0x1cd0 exited with code 0]
[Inferior 1 (process 2864) exited normally]
(gdb)
```

## break

Point d'arrêt, sur ma fonction main() par exemple.
```powershell
(gdb) break main
Breakpoint 1 at 0x7ff7f6c21821: file main.c, line 5.
(gdb)
```
Maintenant la commande run s'arrête au point d'arrêt.
```powershell
(gdb) run
Starting program: C:\a.exe
[New Thread 10496.0x1f68]

Thread 1 hit Breakpoint 1, main () at main.c:5
5           for(int i = 0 ; i < 10 ; i++)
(gdb)
```

break sur un numéro de ligne.
```powershell
(gdb) break 5
Note: breakpoint 1 also set at pc 0x7ff7f6c21821.
Breakpoint 2 at 0x7ff7f6c21821: file main.c, line 5.
(gdb)
```

break sur un fichier en particulier, et une fonction de ce fichier (attaquer() par exemple).
```powershell
(gdb) break player.c:attaquer
```

break sur une ligne (5) avec une condition sur une variable, admettons si i==2.
```powershell
(gdb) break 5 if i==2
Note: breakpoints 1 and 2 also set at pc 0x7ff7f6c21821.
Breakpoint 3 at 0x7ff7f6c21821: file main.c, line 5.
(gdb)
```
Un point d'arrêt a été placé sur la ligne 5 avec i==2.

## info

Lister les points d'arrêt.
```powershell
(gdb) info break     
Num     Type           Disp Enb Address            What
1       breakpoint     keep y   0x00007ff7f6c21821 in main at main.c:5
        breakpoint already hit 1 time
2       breakpoint     keep y   0x00007ff7f6c21821 in main at main.c:5
3       breakpoint     keep y   0x00007ff7f6c21821 in main at main.c:5
        stop only if i==2
(gdb)
```

## continue ou cont

Sauter d'un point d'arrêt à un autre.

```powershell
> gdb -q .\a.exe
(gdb) info break
    No breakpoints or watchpoints.
(gdb) break main
Breakpoint 1 at 0x140001821: file main.c, line 5.
(gdb) break 6
Breakpoint 2 at 0x14000182a: file main.c, line 6.
(gdb) break main(gdb) info break
Num     Type           Disp Enb Address            What
1       breakpoint     keep y   0x0000000140001821 in main at main.c:5
2       breakpoint     keep y   0x000000014000182a in main at main.c:6
(gdb) run
Starting program: C:\a.exe 
[New Thread 804.0x610]

Thread 1 hit Breakpoint 1, main () at main.c:5
5           for(int i = 0 ; i < 10 ; i++)
(gdb) cont
Continuing.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 0.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 1.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 2.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 3.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 4.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 5.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 6.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 7.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 8.

Thread 1 hit Breakpoint 2, main () at main.c:6
6               printf("Variable i vaut %d.\n", i);
(gdb) cont
Continuing.
Variable i vaut 9.
[Thread 804.0xf0c exited with code 0]
[Inferior 1 (process 804) exited normally]
(gdb) cont
The program is not being run.
(gdb) q
> 
```

C'est intéressant de le faire sur une boucle.

## step

Passer les instructions une à une.

```powershell
> gdb -q .\a.exe
(gdb) info break
No breakpoints or watchpoints.
(gdb) break main
Breakpoint 1 at 0x140001821: file main.c, line 5.
(gdb) step
The program is not being run.
(gdb) r
Starting program: C:\a.exe 
[New Thread 8932.0x1de4]

Thread 1 hit Breakpoint 1, main () at main.c:5
5           for(int i = 0 ; i < 10 ; i++)
(gdb) step
6               printf("Variable i vaut %d.\n", i);
(gdb) step
printf (__format=0x7ff7f6c2a050 "Variable i vaut %d.\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );
(gdb) step
358       __retval = __mingw_vfprintf( stdout, __format, __local_argv );
(gdb) step
Variable i vaut 0.
360       return __retval;
(gdb) step
361     }
(gdb) step
main () at main.c:5
5           for(int i = 0 ; i < 10 ; i++)
(gdb) step
6               printf("Variable i vaut %d.\n", i);
(gdb) step
printf (__format=0x7ff7f6c2a050 "Variable i vaut %d.\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );
(gdb) step
358       __retval = __mingw_vfprintf( stdout, __format, __local_argv );
(gdb) step
Variable i vaut 1.
360       return __retval;
(gdb) step
#...
```

## next

```c
#include <stdio.h>

void hello(void)
{
    printf("Hello\n");
}

int main(void)
{
    printf("La fonction main\n");
    hello();

    return 0;
}
```

Avec step,
```powershell
> gcc -g .\main.c
> gdb -q .\a.exe
(gdb) break main
Breakpoint 1 at 0x14000183c: file .\main.c, line 10.
(gdb) r
Starting program: C:\a.exe 
[New Thread 484.0x1a80]

Thread 1 hit Breakpoint 1, main () at .\main.c:10
10          printf("La fonction main\n");
(gdb) step
printf (__format=0x7ff79ab1a057 "La fonction main\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );     
(gdb) step
358       __retval = __mingw_vfprintf( stdout, __format, __local_argv );
(gdb) step
La fonction main
360       return __retval;
(gdb) step
361     }
(gdb) step
main () at .\main.c:11
11          hello();
(gdb) step
hello () at .\main.c:5
5           printf("Hello\n");
(gdb) step
printf (__format=0x7ff79ab1a050 "Hello\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );
(gdb) step
358       __retval = __mingw_vfprintf( stdout, __format, __local_argv );
(gdb) step
Hello
360       return __retval;
(gdb) step
361     }
(gdb) step
hello () at .\main.c:6
6       }
(gdb) step
main () at .\main.c:13
13          return 0;
(gdb) step
14      }
(gdb) step
0x00007ff79ab1142a in __tmainCRTStartup ()
(gdb) step
Single stepping until exit from function __tmainCRTStartup,
which has no line number information.
[Thread 484.0x1a80 exited with code 0]
[Inferior 1 (process 484) exited normally]
(gdb) step
The program is not being run.
(gdb) step
The program is not being run.
```

Avec next, on ne passe pas par les fonctions utilisateurs donc celles crées en plus de la fonction main() donc automatiquement il montrera la ligne d'instruction de la fonction et c'est tout.
```txt
(gdb) next
La fonction main    
11          hello();
```
```powershell
> gdb -q .\a.exe
(gdb) break main
Breakpoint 1 at 0x14000183c: file .\main.c, line 10.
(gdb) r
Starting program: C:\a.exe     
[New Thread 3220.0xdb4]

Thread 1 hit Breakpoint 1, main () at .\main.c:10
10          printf("La fonction main\n");        
(gdb) next
La fonction main    
11          hello();
(gdb) next
Hello
13          return 0;
(gdb) next
14      }
(gdb) next
0x00007ff79ab1142a in __tmainCRTStartup ()
(gdb) next
Single stepping until exit from function __tmainCRTStartup,
which has no line number information.
[Thread 3220.0xdb4 exited with code 0]
[Inferior 1 (process 3220) exited normally]
(gdb) next
The program is not being run.
(gdb)
```

Voilà avec Next, il ne rentre pas dans la fonction hello() pour la déboger.

On a vu finallement la commande `continue` (ou cont) pour passer d'un point d'arrêt à un autre. La commande `step` qui va suivre toutes les instructions une à une et même en passant par nos fonctions puis la commande `next` qui fait la même chose sauf qu'elle ne passera pas par nos fonctions, elle va juste passer par la fonction main().

## pwd

Retourne le répertoire courant où on travail.

```powershell
(gdb) pwd
Working directory C:.\Aide-mémoires\Hacking\ARCHIVE\cours\004_débogage_langage_C.
(gdb) 
```

## delete

Supprimer tout les points d'arrêt

Par rapport à son numéro.
```powershell
(gdb) break main
Breakpoint 1 at 0x14000183c: file .\main.c, line 10.
(gdb) delete 1
(gdb) info break
No breakpoints or watchpoints.
(gdb) 
```

Par rapport à une fonction (pff, ne fonctionne pas !).
```powershell
(gdb) delete main
```

Par rapport à une ligne (pff, ne fonctionne pas !).
```powershell
(gdb) delete .\main.c:10
```

## disable et enable

Désactiver et activer un point d'arrêt.

```powershell
> gdb -q .\a.exe
(gdb) break main
Breakpoint 1 at 0x14000183c: file .\main.c, line 10.
(gdb) disable 1
(gdb) info break
Num     Type           Disp Enb Address            What
1       breakpoint     keep n   0x000000014000183c in main at .\main.c:10
(gdb) enable 1
(gdb) info break
Num     Type           Disp Enb Address            What
1       breakpoint     keep y   0x000000014000183c in main at .\main.c:10
(gdb) 
```

## print ou p

Afficher une variable de notre programme.

```c
#include <stdio.h>

int main(void)
{
    for(int i = 0 ; i < 10 ; i++)
        printf("Variable i vaut %d.\n", i);
        
    return 0;
}
```
```powershell
> gcc -g .\main.c
> gdb -q .\a.exe
(gdb) break main
Breakpoint 1 at 0x140001821: file .\main.c, line 5.
(gdb) r
Starting program: C:\a.exe 
[New Thread 11148.0x1c0c]

Thread 1 hit Breakpoint 1, main () at .\main.c:5
5           for(int i = 0 ; i < 10 ; i++)       
(gdb) print i
$1 = 0
#...
```
```powershell
#...
(gdb) step
6               printf("Variable i vaut %d.\n", i);
(gdb) step
printf (__format=0x7ff61705a050 "Variable i vaut %d.\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );
(gdb) print i
No symbol "i" in current context.
```

`$1`, `$2`, ... représente le nombre de fois où c'est affiché. 

Afficher l'adresse de i avec `&`.
```powershell
(gdb) p i
$2 = 0
(gdb) p &i
$3 = (int *) 0xcea3bff72c
```

## whatis

Affiche le type de la variable.

```powershell
(gdb) whatis i
type = int
(gdb)
```

## display

Affiche une variable à chaque point d'arrêt.

```powershell
(gdb) display i
1: i = 0
(gdb)
```
```powershell
(gdb) display i
1: i = 0
(gdb) step
6               printf("Variable i vaut %d.\n", i);
1: i = 1
(gdb) step
printf (__format=0x7ff61705a050 "Variable i vaut %d.\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357      
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );
(gdb) step
358       __retval = __mingw_vfprintf( stdout, __format, __local_argv );
(gdb) step
Variable i vaut 1.
360       return __retval;
(gdb) step
361     }
(gdb) step
main () at .\main.c:5
5           for(int i = 0 ; i < 10 ; i++)
1: i = 1
(gdb) step
6               printf("Variable i vaut %d.\n", i);
1: i = 2
(gdb) step
printf (__format=0x7ff61705a050 "Variable i vaut %d.\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );
(gdb) step
358       __retval = __mingw_vfprintf( stdout, __format, __local_argv );
(gdb) step
Variable i vaut 2.
360       return __retval;
(gdb) step
361     }
(gdb) step
main () at .\main.c:5
5           for(int i = 0 ; i < 10 ; i++)
1: i = 2
(gdb) step
6               printf("Variable i vaut %d.\n", i);
1: i = 3
(gdb) step
printf (__format=0x7ff61705a050 "Variable i vaut %d.\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );     
(gdb) step
358       __retval = __mingw_vfprintf( stdout, __format, __local_argv );
(gdb) step
Variable i vaut 3.
360       return __retval;
(gdb) step
361     }
(gdb) step
main () at .\main.c:5
5           for(int i = 0 ; i < 10 ; i++)
1: i = 3
(gdb) step
6               printf("Variable i vaut %d.\n", i);
1: i = 4
#...
```

## slash d u f c t o x a

Change l'affichage de variable en entier signé avec le slash d pour décimale `/d`

+ Un entier signé `/d`,
```powershell
> gdb -q .\a.exe
(gdb) break main
Breakpoint 1 at 0x140001821: file .\main.c, line 5.
(gdb) r
Starting program: C:\a.exe 
[New Thread 1808.0x204c]

Thread 1 hit Breakpoint 1, main () at .\main.c:5
5           for(int i = 0 ; i < 10 ; i++)       
(gdb) p i
$1 = 0
(gdb) step
6               printf("Variable i vaut %d.\n", i);
(gdb) step
printf (__format=0x7ff61705a050 "Variable i vaut %d.\n")
    at c:/mingw64/x86_64-w64-mingw32/include/stdio.h:357
357       __builtin_va_list __local_argv; __builtin_va_start( __local_argv, __format );
(gdb) p i
No symbol "i" in current context.
(gdb) p/d i
$2 = 2
```

Ici ça ne change pas. 

+ En tant qu'entier non signé, `/u`.
```powershell
(gdb) p/u i
$5 = 2
```
Un entier non signé n'est pas plus petit que 0 puisqu'il ne peut pas être négatif.

+ En tant que flottant, `/f`.
```powershell
(gdb) p i 
$3 = 7
(gdb) p/d i
$4 = 7
(gdb) p/u i
$5 = 7
(gdb) p/f i
$6 = 9.80908925e-45
```

Ici on a un entier donc ce n'est pas viable mais si on avait eu un flottant, on aurais pû l'afficher comme ça.

+ En tant de caractère `/c`.
```powershell
(gdb) p/c i
$7 = 7 '\a'
```

+ En tant que binaire `/t`.
```powershell
(gdb) p/t i
$8 = 111
```

+ En tant qu'octale `/o`.
```powershell
(gdb) p/o i
$9 = 07
```

+ En hexadécimale `/x`.
```powershell
(gdb) p/x i
$10 = 0x7
```

+ Afficher sous forme d'adresse `/a`.
```powershell
(gdb) p/a i
$11 = 0x7
```

## set variable

Modifier la valeur d'une variable au cours du débogage.

```powershell
> gcc -g .\main.c
> gdb -q .\a.exe
(gdb) break main
(gdb) r
(gdb) step
    Variable i vaut 1.
(gdb) set variable i=4
(gdb) step
    Variable i vaut 5.
```

On passe à 4 et il s'incrémente directement à 5.

:warning: Si vous avez un programme ne le distribuer pas en mode debug sinon les gens pourrons lire le code source et modifier le comportement du programme, carrément le hacker parce qu'il suffira juste de lancer `gdb`sur l'exécutable pour faire ce qu'ils veulent dessus.

La majorité des programmes que l'on trouve sur internet sont distribués en format release, et non pas en format debug.

Évidemment quand un développeur veut proposer un programme au public, évidemment il va faire une compilation sans l'argument `-g` bien évidemment sinon en donnant les informations de débogage et que quelqu'un veut déboguer l'exécutable, ils pourront faire un petit peu ce qu'il veut.

Évidemment si on utilise gdb sur une version release, on n'aura pas les informations de débogage.

Par exemple,
```c
> gcc .\main.c
> gdb -q .\a.exe
(gdb) r
Starting program: C:\a.exe
[New Thread 10964.0x2e68]
Variable i vaut 0.
Variable i vaut 1.
Variable i vaut 2.
Variable i vaut 3.
Variable i vaut 4.
Variable i vaut 5.
Variable i vaut 6.
Variable i vaut 7.
Variable i vaut 8.
Variable i vaut 9.
[Thread 10964.0x3330 exited with code 0]
[Inferior 1 (process 10964) exited normally]
(gdb) break main
Breakpoint 1 at 0x7ff744fb1821
(gdb) r
Starting program: C:\a.exe
[New Thread 11208.0x30dc]

Thread 1 hit Breakpoint 1, 0x00007ff744fb1821 in main ()
(gdb) step
Single stepping until exit from function main,
which has no line number information.
Variable i vaut 0.
Variable i vaut 1.
Variable i vaut 2.
Variable i vaut 3.
Variable i vaut 4.
Variable i vaut 5.
Variable i vaut 6.
Variable i vaut 7.
Variable i vaut 8.
Variable i vaut 9.
0x00007ff744fb142a in __tmainCRTStartup ()
(gdb)
```

On ne peut plus afficher le code source parcequ'il n'a pas les informations de débogages dans la commande `gcc .\main.c` au lieu de `gcc -g .\main.c`.

## rwatch

Créer un point d'arrêt automatiquement quand une variable va être lue avec r pour read.

`rwatch i` va créer un point d'arrêt à chaque fois qu'il lit la variable i.

```powershell
> gcc -g main.c
> gdb -q .\a.exe
(gdb) break main
Breakpoint 1 at 0x140001821: file main.c, line 5.
(gdb) r
Starting program: C:\Users\sam\OneDrive\Aide-mémoires\Hacking\ARCHIVE\cours\004_débogage_langage_C\a.exe 
[New Thread 9716.0x18ec]

Thread 1 hit Breakpoint 1, main () at main.c:5
5           for(int i = 0 ; i < 10 ; i++)
(gdb) rwatch i
Hardware read watchpoint 2: i
(gdb) step

Thread 1 hit Hardware read watchpoint 2: i

Value = 0
main () at main.c:5
5           for(int i = 0 ; i < 10 ; i++)
(gdb) step

Thread 1 hit Hardware read watchpoint 2: i

Value = 0
0x00007ff60d041843 in main () at main.c:5
5           for(int i = 0 ; i < 10 ; i++)
(gdb) p i  
$1 = 0
```

On voit qu'il a créé deux points d'arrêt.
```powershell
(gdb) info break
Num     Type            Disp Enb Address            What
1       breakpoint      keep y   0x00007ff60d041821 in main at main.c:5
        breakpoint already hit 1 time
2       read watchpoint keep y                      i
        breakpoint already hit 2 times
(gdb) 
```

Il nous met le nombre de fois où il a été rencontré (step ... 1 time ... step ... 2 times).

## watch

Surveiller lorsqu'une variable a changé.

Par exemple, tu surveille la variable i quand elle vaut 5, `watch i==5` ou bien encore `watch i<=5` ou `watch i > 5` et cetera.

```powershell
(gdb) watch i==5
Hardware watchpoint 3: i==5
(gdb)
```

## awatch

Surveiller tout, un point d'arrêt quand la variable est lue ou modifier, vraiment quand il se passe les deux.

Par exemple, tu surveille tout sur la variable i `awatch i`. On crée un point d'arrêt dés que la variable est lu ou modifié.

```powershell
(gdb) awatch i
```

## show args

Affiche les arguments, ce que l'on passe en arguments de la fonction main().

```c
int main(int argc, char *argv[]){}
```
```c
#include <stdio.h>

int main(int argc, char *argv[])
{
    for(int i = 0 ; i < 10 ; i++)
        printf("Variable i vaut %d.\n", i);
        
    return 0;
}
```

A la suite de mon exécutable, je peux mettre deux arguments (123 456) même si bien évidemment ici on verra rien de différent parce que je ne les affiche pas

```c
> gcc -g main.c 
> .\a.exe 123 456
Variable i vaut 0.
Variable i vaut 1.
Variable i vaut 2.
Variable i vaut 3.
Variable i vaut 4.
Variable i vaut 5.
Variable i vaut 6.
Variable i vaut 7.
Variable i vaut 8.
Variable i vaut 9.
> 
```

On va pouvoir les montrer au niveau de gdb.

```powershell
> gdb -q .\a.exe 123 456
(gdb) break main
(gdb) show args
Argument list to give program being debugged when it is started is "".
(gdb)
```

Alors il ne me les affiche pas, je ne fait rien dessus mais on pourrais du coup passer les arguments pour l'exécution donc c'est plutôt intéressant.

## show env

Afficher toutes les variables d'environnement.

```powershell
> gdb -q .\a.exe
(gdb) show env
ALLUSERSPROFILE=C:\ProgramData
APPDATA=C:\Users\%USERNAME%\AppData\Roaming
#...
(gdb)
```

Voilà toutes les variables de notre système d'exploitation.

## show env Path

Afficher une variable d'environnement en particulier.

```powershell
(gdb) show env Path
Path = C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\
#...
(gdb)
```

## whatis main

Afficher le paramètre et le type de retour d'une fonction.

```powershell
> gdb -q .\a.exe
(gdb) break main
Breakpoint 1 at 0x140001828: file main.c, line 5.
(gdb) whatis main 
type = int (int, char **)
(gdb)
```

Voilà on la signature de ce type de fonction `int (int, char **)` avec son type de retour. `char **` equivaut `char *argv[]`.

## where

Il nous affiche la Stack, la Pile

```powershell
(gdb) where
No stack.
(gdb) r
(gdb) where
#0  main (argc=1, argv=0x2a91cc14660) at main.c:5
(gdb)
```

On exécute `run` et il nous met à la première position main() donc ça va être tout simplement la pile d'exécution de notre programme notamment ici au moment où je fait mon débogage.

Alors ici la Pile va accueillir tous les appels à nos fonctions surtout si on fait de la récursivité (voir tuto langage c) Eh bien à chaque fois qu'on va faire un appel de fonction, ça se remplaçait sur la pile.

Notez que la pile n'est pas infinie au niveau de la taille, on peut surcharger une pile et on peut même saturer une pile, et c'est là tout l'intérêt de savoir où se situe la Pile au cours de notre débogage.

On en parlera dans la séance 6, sur le fonctionnement des tailles de la mémoire mais avant on parlera de système de codage (binaire, octale, héxadécimale et de décimale qu'on connaît).

A très bienôt tout le monde