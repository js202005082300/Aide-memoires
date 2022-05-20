# Assembleur #3 - structure d'un programme
@https://www.youtube.com/watch?v=sS_1SyDqVV8  
13-01-2021

Bonjour et bienvenue sur le cours en langage assembleur pour cette séance 3 nous allons parler de la structure du programme c'est à dire comment nous allons en fait organiser notre code dans nos fichiers avec l'assembleur nasm parce que c'est l'assembleur que j'ai choisi pour vous présenter en fait ce cours tout simplement.

Après bien sûr comme je vous l'ai rappelé précédemment, vous pourrez sans problème partir sur un autre assembleur, tester d'autres assemblereurs voilà varier en fonction pour essayer d'autres outils parce qu'il y en a plusieurs et qui proposent chacun un petit peu leur fonctionnalité mais ici on va se concentrer sur nasm et on va regarder un petit peu comment se structure un programme avec pour exemple un des codes précédent qu'on a vu dans la séance précédente comme ça on va pouvoir partir de ce dernier en tout cas pour commencer un petit peu à rentrer plus dans le détail sur les différentes choses que j'ai pu écrire, que j'ai pu noter la dernière fois et vous puissiez commence à comprendre un petit peu là toutes ces lignes en fait de code qu'on avait dans nos fichiers.

On va passer directement sur cet exemple.

a64.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global main
		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Je suis sur windows et j'ai repris le code source pour l'exemple fait pour une architecture en 64 bits tout simplement et je vais pouvoir comme ça vous détailler un petit peu à l'ensemble de ce code.

Evidemment au terme de cette vidéo ça ne veut pas dire que vous comprendrez absolument tout ce que fait ce code enfin maintenant vous comprenez parce que je vous ai expliqué la dernière fois ce qu'il permettait de faire mais pour autant vous n'avez pas voilà dans le bétail chacune des instructions ce qu'elles font précisément c'est encore un peu tôt mais pour autant on va voir un petit peu comment s'organise ce code d'accord tout est organisé une certaine manière.

Ce n'est pas n'importe comment au hasard et il faut prendre tout cela en compte parce que c'est ce qui vous permettra par la suite décrire vos propres codes et c'est tout justement le but de ce genre de formation.

Alors première chose que nous allons voir ensemble et qui est assez important alors c'est d'ailleurs parce qu'on voit un petit peu ici on remarque qu'il y a tout un ensemble d'information que j'avais utilisé par exemple ici 'bits 64' que j'avais utilisé et j'avais précisé que l'on va faire du code pour une architecture 64 bits.

```asm
	bits 64
```

On avait ici utiliser des fonctions de l'api windows donc ça je vous en ai parlé brièvement donc même si vous ne les connaissiez pas tout simplement je vous ai commenté ça la dernière fois dans la séance 2.

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

Et après on a tout un ensemble ici on remarque qu'il y quelques blocs qui sont facilement visible pour vous puisque visuellement vous voyez que ici voilà une partie une section.

	section .data
		...

	section .bss
		...

	section .text
		...

Ensuite ici on a une tabulation avant son contenu, d'autres sections, une tabulation aussi et pareil une dernière section où tout est voilà dans une tabulation donc fait partie de cet ensemble.

On observe facilement des blocs et on peut comme ça identifier déjà tout un tas de partie d'accord donc de sections d'où le terme ici au niveau de ce programme.

Donc en premier lieu ce qu'on va retrouver principalement en tout cas pour la partie on va dire minimal ce n'est pas tellement ce que vous avez dit dans ces premières lignes ça c'est déjà des cas à part mais ce sont notamment toutes ces lignes que nous avons ici.

je prends cet exemple là.

		section .data
	>		message db 'Hello World !', 10

Je prends cet exemple là.

```asm
	section .bss
>		written resq 1

	section .text
		global main
		main:
>			mov rcx, -11
>			call GetStdHandle
>			
>			sub rsp, 32
>			sub rsp, 8
>			
>			mov rcx, rax
>			mov rdx, message
>			mov r8, 13
>			mov r9,	written
>			mov qword [rsp+32], 0
>			call WriteConsoleA
		
>			add rsp, 32+8
		
>			xor ecx, ecx
>			call ExitProcess
```

Et plus exactement je prends ce que j'avais mis ici voilà toutes ces choses en fait au niveau de mon éditeur donc se sera peut-être différent bien sûr selon le votre puisque ce n'est qu'un jeu de couleurs, un thème de couleur donc ça ne dépend pas on va dire du langage en lui même mais c'est plus du logiciel que vous utilisez, ce sont tous ces termes en fait qui sont ici moi en bleu en bleu clair bleu ciel d'accord tout ce que j'ai ici, tout simplement toutes ces parties là.

			mov 
			call

			sub 
			sub 

			mov 
			mov 
			mov 
			mov 
			mov 
			call

			add 

			xor 
			call

Et on va retrouver grosso modo un peu le même format si vous regardez un petit peu, on a ici à chaque fois un terme qui est employé (mov, sub ...) et après on va retrouver un ensemble d'autres termes qui suivent soit un terme qui est isolé qui est seul comme celui là (GetStdHandle ...) par exemple et sinon on retrouve un petit peu le même schéma ici (mov rcx, -11 ...) c'est à dire d'avoir un premier terme (rcx ...) une virgule et un second terme (-11 ...). On le revoit très souvent, c'est le cas pour toutes ces lignes là.

			mov rcx, -11
			sub rsp, 32
			sub rsp, 8
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			add rsp, 32+8
			xor ecx, ecx

On remarque de toute façon même sans rien connaître au langage assembleur que par rapport aux thermes, on comprend pas que dès que ça commence par un call à priori ici on n'a qu'une seule valeur qui est passé derrière.

			call GetStdHandle
			call WriteConsoleA
			call ExitProcess

Dans le cas d'un mov on voit qu'on a des cas différents.

			mov rcx, -11
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0


Tout ça on le verra bien sûr par la suite ce sera détaillé.

Donc ceci se sont tout simplement nos instructions d'accord on va avoir un ensemble d'instructions et c'est finalement on va dire l'écriture la plus minimaliste qu'on va retrouver dans un code en langage d'assembleur.

On va tout simplement indiqué une instruction par ligne comme vous voyez ici, une instruction qui possède bien sûr un nom mais ça on verra par la suite un petit peu ce qui se cache derrière d'accord en termes de code et même en terme de langage machine vous verrez que c'est très très proche puisqu'il s'agit de la transcription direct d'accord du langage machine comme je vous l'avais dit en introduction, ça je vous en avais parlé au niveau du langage assembleur et à partir de là on indique des éléments qui permettent évidemment de dire ce que nous faisons avec cette instruction.

Voilà donc ici nous avons une instruction (mov ...) et ici nous avons ce qu'on appelle des opérandes (... rcx, -11) d'ailleurs on peut très bien avoir un opérande qui est isolé ici (... GetStdHandle) voilà donc ça suit une certaine syntaxe d'accord qu'on retrouve là.

Je vous en avais parlé d'ailleurs en intro rappelez vous des syntaxes intel, syntaxe Eti c'est ce que je vous avais expliqué un petit peu ce cas là et en gros même si on verra de toute façon sur les instructions bien dans le détail par la suite c'est encore un petit peu tôt maintenant.

On trouvera en gros ce format je vous donnerais un petit peu comment ça se présente et on verra de toute façon en détail par la suite donc on a notre instruction ici (rcx ... ) on a en fait une valeur de destination d'accord il faut fonctionner en fait et voir les choses à l'envers d'accord (rcx, rsp ...) c'est la destination de ce que va faire cette instruction et ça (-11 ...) c'est la source d'accord c'est inversé.

Voilà alors dans d'autres syntaxe, on peut avoir un autre cas, on ne va pas forcément gérer dans cet ordre là mais nous comme on travail avec la syntaxe Intel ici et on abordera de toute façon d'autres syntaxes, il n'y a pas de problème car on regardera d'autres codes donc on aura très certainement à faire à d'autres syntaxe aussi mais comprenez pour celle ci puisque on va se contenter en tout cas uniformiser un maximum ce que je vais vous montrer dans le cours d'accord pour que vous ne soyez pas perdu avec différentes syntaxe différentes, ça vous prendrez le temps si voulez vous amuser avec quand vous aurez un petit peu plus d'expérience mais en gros nous avons notre instruction (mov ...), une valeur de destination (... rcx ...), une valeur source (... -11) ou alors comme dans le cas de cette instruction ici (call GetStdHandle) on a simplement une seule aux opérande d'accord tout simplement d'ailleurs je crois qu'on dit un opérande.

Donc un operande ici 'call GetStdHandle' et là 'mov rcx, -11' on en a deux.

On observe à chaque fois ce schéma.

mov qword [rsp+32], 0 alors là on a un cas un peu particulier mais au final on a 2 opérandes là.

Tout ça on reviendra puisque ces instructions c'est un petit peu tout ce que vous allez apprendre en grande partie sur ce cours mais bien évidemment on reviendra dans le détail sur cette instruction mov, qu'est ce que c'est que ce call, qu'est ce que c'est que ce sub et ce add et cetera, c'est déjà pas mal.

Tout ce que je voulais que vous compreniez en tout cas pour cette séance là c'est de voir un petit peu le format que ça suit par rapport à ça d'accord on a un ensemble d'instructions.

Ce n'est pas tout, ces instructions si vous regardez un petit peu plus aussi dans le détail on voit que cette ensemble d'instructions est précédé d'un symbole qui est 'main' qui était en fait utilisés par la suite pour l'édition de liens.

		section .text
	>		global main
	>		main:

En fait nous avons ce qu'on appelle ici une étiquette ou label en anglais pour définir tout simplement une portée c'est à dire qu'on a une partie de notre code qui est définie dans ce symbole donc dans cette étiquette là, main.

		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
		
			add rsp, 32+8
		
			xor ecx, ecx
			call ExitProcess

Et d'ailleurs ici on aura ce qu'on appelle une directive 'global main' mais on en parle un petit peu après et de toute façon on verra ça dans le détail aussi qui nous permet ensuite de trouver d'accord càd on va faire une portée extérieure qui va être trouvée par notre lieur ld, GoLink etc pour pouvoir ensuite faire l'édition des liens une fois qu'on a assemblé notre programme voilà donc en gros si on veut reprendre un schéma on va avoir une étiquette qu'on va noter sous cette forme là entre chevrons d'accord.

	<étiquette>:

On remarque l'étiquette dans bien des cas ici c'est suivi par deux points d'accord et après avoir par exemple ça peut être à la ligne ou autre parce que vous verrez qu'en fait il n'y a pas de problème au niveau du formatage d'accord je pourrais très bien mettre les lignes là d'accord.

		section .text
			global main
	>		main: mov rcx, -11
				call GetStdHandle
				...

Je préfère ça et ça ne poserait pas de problème après c'est à vous bien sûr de présenter votre code de la manière la plus lisible pour vous donc ça c'est à vous de voir, je ne veux pas vous donner de règles en particulière à suivre, il y a des règles par exemple où les gens mettent les étiquettes ici.

		section .text
			global main
	>	main:
				mov rcx, -11
				call GetStdHandle

Donc après à voir, il y en a qui mettent leurs étiquettes au même niveau que section là et même les sections il les mettent plutôt là.

	>		section .text
			global main
		main:
				mov rcx, -11
				call GetStdHandle

Donc ça franchement c'est selon vos préférences c'est vous qui voyez, moi j'ai toujours pris l'habitude de faire ça comme ça donc ce n'est pas un problème.

On va voir ensuite des instructions enfin une instruction en l'occurrence ici et après on va voir un ou des opérandes comme ça.

	<étiquette>: <instruction> <opérande(s)>

Et voilà un petit peu le format qu'on peut avoir et que vous allez retrouver très souvent d'accord.

Alors l'étiquette c'est un cas a part d'accord donc dans ce cas là 'main' c'est notre étiquette et ensuite voilà on retrouve un peu ce format là si on veut.

	<étiquette>:
		<instruction> <opérande(s)>

Et ça ça va se répéter un certain nombre de fois dans cette étiquette là.

	<étiquette>:
		<instruction> <opérande(s)>
		<instruction> <opérande(s)>
		<instruction> <opérande(s)>

Voilà un petit peu ce qu'on retrouve ici donc ça c'est quelque chose que vous allez retrouver très souvent dans ces programmes et on le remarque un petit peu partout d'ailleurs ces exemples là (message, written ...).

Par contre les deux points ici ne sont pas obligatoire d'accord.

	main:

C'est un élément un caractère facultatif.

On a pourtant beaucoup l'habitude de s'en servir ici autant on s'en sert beaucoup moins là (message, written, ...).

		section .data
	>		message db 'Hello World !', 10

		section .bss
	>		written resq 1

pour indiquer que l'étiquette c'est message et ensuite on a un certain nombre d'instructions (... db 'Hello World !', 10) alors on verra pas parce que ça ce sont des cas particuliers en tout cas celui-là '... db 'Hello World !', 10' est un cas particulier mais après on va voir comme ça des instructions, des opérandes et cetera et cetera avec plusieurs éléments sur lesquels nous allons pouvoir travailler.

Donc ça c'est très important encore une fois, c'est pour ça que ce genre de détails arrive au début du cours parce que c'est important de savoir sur quoi on travaille et comment on écrit les choses avant même d'entrer dans le détail de comment ça fonctionne et d'apprendre simplement après les différentes instructions et autres parce qu'il a beaucoup beaucoup de choses à voir au niveau de ce cours.

Voilà donc vous avez comme ça déjà un premier élément qui est assez important et qui est à connaître, GetStdHandle.

	extern GetStdHandle

Alors ça au niveau d'un nombre par exemple d'étiquettes on va avoir des règles, c'est assez similaire à d'autres règles que vous avez en programmation généralement.

Il ne faut pas que ça commence par exemple par un chiffre qu'on retrouve très souvent et vous pourrez utiliser des caractères donc caractères, lettres majuscules, lettres minuscules, des nombre d'accord et on a aussi des caractères un peu particulier.

	$ ? _ . #

Voilà c'est des cas à part, on a un petit peu là pour le coup des caractères qui changent d'autres langages de programmation mais qu'on peut utiliser pour une étiquette et après si on veut comme suffixe, on rajoute le fameux : que je vous ai montré ici.

	:

Vous avez dû remarquer aussi rappelez vous on l'a fait notamment le lieur ld sur gnu-linux où on faisait carrément précéder tout simplement notre étiquette par underscore.

	_

On peut parfaitement le faire précéder avec cela.

On verra qu'il y a des cas aussi ou on peut faire précéder de ça.

	$

Notamment quand on veut utiliser un mot réservés.

Là pareil vous ne connaissez pas actuellement sauf bien sûr ceux qui ont déjà programmé dans ce langage mais vous ne savez pas dans le détail ce que font ces lignes mais vous comprenez que ça 'mov' à priori c'est un mot réservé au niveau du langage assembleur et on a des termes aussi (rcx, rdx, r8, r9) qui ont l'air de l'être en tout cas.

S'il vous venais l'idée ce qui serait très bizarre par exemple d'utiliser ce nom 'rcx' là comme étiquette d'accord pour ne pas le confondre avec ce qu'on verra plus tard ici, c'est un nom de registre d'accord donc c'est un nom de registre, une étiquette en fait qui représe un registre.

eh bien on pourrait tout à fait faire ceci, $rcx.

```asm
	section .text						section .text
		global main							global $rcx
		main: 									$rcx:
			mov rcx, -11							mov rcx, -11
			call GetStdHandle						call GetStdHandle
			...										...
```

Et en faisant précéder d'un dollar on indique explicitement qu'il s'agit d'une étiquette et non pas du registre en question.

main.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global $acx
		$acx:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Donc là si je fais là si je fait l'assemblage d'ailleurs peut-être assembler pour voir ce que ça donne et on va pouvoir assembler le programme sans problème.

	>nasm -f win64 main.asm -o main.obj

Et ensuite un petit GoLink et donc on va lui passer le fichier objet et /entry cette fois ci ce n'est pas main d'accord c'est $rcx donc ici au niveau du lieur on va changer par rapport à ça. Et ensuite /console kernell32.dll parce que c'est la ibliothèque qu'on utilise.

	>golink.exe main.obj /entry rcx /console kernel32.dll
	>main.exe
	Hello World !

Et là on utilise ici pour le coup comme nom d'étiquette $rcx bien sûr dans un cas évitez de faire ça bien sûr c'est pour montrer un petit peu comment fonctionne ce genre de caractère sur une étiquette c'est tout à fait valide en termes de code après est-ce que c'est propre ? ça c'est un autre débat.

Ok on va mettre ça comme ça et maintenant vous savez un petit peu comment ça se présente.

main.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global main
		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Alors là c'est à vous de voir au niveau des étiquettes, est-ce que vous voulez mettre des étiquettes ou pas, généralement dans ces sections-là, ces segments parce qu'on va en parler un petit peu, on ne les met pas toujours encore une fois j'ai plus souvent vu des gens ne pas les mettre que de les trouver dans des codes.

Par contre après quand on travaille sur .text, on les retrouve quand même assez souvent donc je peux très bien faire ça comme ça (main: -> main).

```asm
	section .text						section .text
		global main							global main
>		main: 									main
			mov rcx, -11							mov rcx, -11
			call GetStdHandle						call GetStdHandle
			...										...
```

Donc il n'y a pas de problème c'est vous qui voyez, je ne suis pas là pour vous imposer une écriture en particulier le but est comme je le dis dans d'autres cours c'est d'être cohérent du début à la fin.

Si vous adoptez une certaine syntaxe dans votre code alors ne changez pas en cours de route ou surtout ne changez pas en plein milieu du même code d'accord dans le même code d'avoir un coup les deux points, un coup pas les deux points en tout cas en fonction de l'endroit bien sûr où vous voulez le faire.

Ca c'est à vous de voir après comment vous gérez à ce niveau là donc vous vous organisez là dessus, c'est vous qui voyez c'est pas un problème.

Voilà au niveau des étiquettes comment ça va se passer d'accord, on va pouvoir comme ça gérer un petit peu tout ces noms.

Les instructions je reviendrai dessus parce que je dis c'est toute la grosse partie, on va parler de ça dans le cours.

Vous allez apprendre ce que font ces instructions ce qu'elles font et cetera et puisque c'est justement tout l'essence même du langage assembleur donc c'est des choses qu'on verra bien plus tard mais qu'on va voir de toute façon de manière étalée sur l'ensemble du cours donc pas de problème à ce niveau là.

Un petit peu avant je vous ai parlé de ces parties là.

	section .data
		message db 'Hello World !', 10

Je vous ai dit qu'on voyait visuellement, très facilement justement un groupe de blocs d'accord on retrouve ici un bloc qui d'ailleurs porte un nom qui s'appelle .data, on un bloc qui s'appelle .bss et un bloc qui s'appelle .text ça c'est pareil on reviendra dessus plus tard puisque cela concerne notamment les parties en mémoire et bien sûr il y aura une vidéo dédiée là dessus parce qu'il y a beaucoup à dire et d'ailleurs pour ceux qui au moment où je fais cette vidéo avait vu les premières vidéos du cours de hacking, j'avais déjà commencé un petit pas à parler justement de ces différents emplacements.

Donc vous allez retrouver un petit peu tout ça sur la chaîne sur une autre vidéo mais on reviendra bien sûr en détail sur toutes ces informations là plus tard.

Voilà donc pour le moment on ne va pas en parler, on va passer à côté.

Ce qui nous intéresse en tout cas c'est ceci, nous avons donc outre ces étiquettes c'est à dire ici est une étiquette (message..), une autre (written ...), une autre (main ...) et des instructions avec leurs opérandes d'accord ce qu'on observe ici.

		mov rcx, -11
		call GetStdHandle
		
		sub rsp, 32
		sub rsp, 8
		
		mov rcx, rax
		mov rdx, message
		mov r8, 13
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		
		add rsp, 32+8
		
		xor ecx, ecx
		call ExitProcess
		...

Nous avons également ce qu'on appelle des directives.

Directive on a celle ci.

	bits 64

externe c'est une directive.

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

section c'est une directive.

	section .data
		...
	section .bss
		...
	section .text

Et global c'est une directive aussi d'accord.

	global main
	main:
		...

On va en retrouver plusieurs. On va pouvoir commencer à vous les présenter les différents puisque c'est aussi le but là maintenant.

Bon vous savez qu'est ce que ce qui est une directive, on en a parlé mais maintenant il faut indiquer un petit peu à quoi elles servent.

Celle ci 'bits 64' bon je vous en avais déjà parlé d'accord à quoi elle servait.

Moi je part du principe plus il est explicite et moins il laisse de place on va dire au doute et mieux c'est d'accord c'est à dire que cette directive en soit elle n'est pas obligatoire.

	bits 64

D'accord moi par exemple je suis sur une architecture en 64 bits, le système d'exploitation est en 64 bits donc si j'assemble mon programme en ne mettant rien du tout il va être assemblés pour du 64 bits.

main.asm
```asm
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10
```
Par contre ce n'est pas explicite et rien m'interdit sur un système 64 bits comme je vous l'ai dis d'assembler pour du 32 bits (bits 32).

main.asm
```asm
	bits 32
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10
```

Donc ce genre de directives exige justement plus explicitement soit indiquer effectivement l'architecture qu'on a c'est toujours pas plus mal comme ça l'avantage c'est qu'on a même pas besoin d'aller regarder le code on comprend que dès cette première ligne c'est du code pour une architecture 64 bits.

main.asm
```asm
	bits 64
	
	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10
```

Voilà on s'embête même pas avec ça donc c'est explicite ça ne laisse pas de place au doute et on peut bien sûr revoir à la baisse si on veut travailler sur des architectures inférieur d'accord éventuellement donc cette instruction exit bien pratique.

	bits 64

Moi je la mets habituellement aussi comme ça encore une fois pas de problème on sait sur quoi nous travaillons il n'y a pas de souci de ce côté-là.

externe j'en ai déjà parlé assez rapidement, je crois qu'on en avait parlé un petit peu oui précédemment, je vous avait dit qu'en fait c'était une directive qui va nous permettre d'aller récupérer un symbole donc on appel ça un symbole (GetStdHandle, WriteConsoleA, ExitProcess, ...) donc on appelle ça un symbole et on verra un petit peu plus tard pourquoi et on verra aussi en quoi ça consiste alors que je vous avais expliqué que c'étaient des fonctions de l'api windows dans ce cas précis.

Mais ces symboles n'appartiennent pas au langage assembleur directement et encore moins donc à l'assembleur nasm d'accord c'est propre au système d'exploitation windows donc c'est vraiment quelque chose qui est extérieur ici à l'assembleur ou au langage assembleur donc comme on a besoin de ces fonctions puisque après on fait à priori des appels à ces fonctions, si vous avez surtout déjà fait un peu de programmation bon c'est pas quelque chose qui est nouveau pour vous.

Donc ça 'call GetStdHandle' vous comprenez que ça fait appel à la fonction GetStdHandle de l'api windows, je pense que maintenant c'est plus trop un mystère pour vous.

Vous avez déjà programmé au moins un jour donc pas de problème à ce niveau là donc on va demander à les récupérer depuis l'extérieur d'accord sur une portée qui est extérieur.

On va récupérer en fait ces symboles en les déclarant d'accord on déclare en fait un symbole qui est extérieur, externe à notre programme via ce genre de directives-là.

Plus tard d'ailleurs on verra alors je ne sais pas est-ce que je vous le présenterai dans le cours ? est-ce que je vais présenter sous forme de tutos ? vous verrez de toute de façon si ça faisait partie des séances du cours ou si c'est en annexe dans les tutos.

On verra ce qu'on pourra aussi utiliser admettons et ça ça concerne les gens qui ont déjà programmé par exemple en c de faire ceci.

	extern _printf

Et récupérer par exemple la fonction printf() qu'on a en langage c et vous pourriez parfaitement faire un appel a printf() peut-être dans un langage, dans un programme en langage assembleur ça fonctionnerait tout à fait aussi.

Voilà on peut faire ce genre de choses donc c'est une directive bien pratique vous avez vu que sur windows on l'a utilisé quand même dès le départ pour pouvoir travailler avec l'api windows puisque c'est quelque chose justement qui est externe donc c'était important de pouvoir le faire.

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

Voilà au niveau de ce terme-là.

Qu'est ce qu'on a d'autres aussi ? on a ce petit global alors ça j'en ai parlé aussi précédemment, je vous avait dit qu'en gros c'était simplement pour pouvoir en fait exporter le symbole donc cette étiquette main.

	main

Donc l'exporter pour pouvoir en fait la rendre accessible d'accord au niveau de sa portée à l'extérieur et c'est grâce à cela justement qu'on peut ici faire l'édition de liens avec GoLink.

	golink.exe main.obj /entry rcx /console kernel32.dll

Sans cette export finalement de notre étiquette, on ne pourraient tout simplement ...

Si on change le code, il ne faut pas oublier de réassembler le programme, sinon warning.

	>nasm -f win64 main.asm -o main.obj
	>golink.exe main.obj /entry rcx /console kernel32.dll
	>main.exe

Voilà c'est grâce à cela que nous pouvons passer par l'édition des liens d'accord on a exporté depuis notre code cette rentrée-là ce symbole là 'main' et automatiquement il peut-être trouvé par notre éditeur de liens et on peut parfaitement faire l'édition de lien pour obtenir notre programme final d'accord.

	golink.exe main.obj /entry rcx /console kernel32.dll

global, petit directive mine de rien qui est très utile et qu'on utilise aussi dès le départ et assez rapidement dans un programme.

Et enfin on va terminer pour une partie très importante, ce sont ces différentes sections d'accord et ses sections auraient pu également être appelés segment donc c'est deux valeurs d'accord.

```asm
>	section .data							segment .data
		message db 'Hello World !', 10			message db 'Hello World !', 10
		...										...
```

C'est un synonyme, segment de section mais peu importe.

Là pareil bon et essayez d'éviter de mélanger les deux un coup segment et un coup section.

Essayer de choisir l'un ou l'autre et garder toujours le même nom, même nommage donc ça c'est pour avoir quelque chose de cohérent au maximum même si bon là vous voyez que l'éditeur le met en bleu puis ça il le met pas en bleu donc il ne sait pas trop mais c'est parce qu'il galère un petit peu. On a vu d'ailleurs sur linux avec les mêmes paramètres, le même éditeur on n'avait pas la collaration syntaxique bon bref peu importe c'est pas le plus important.

Tout ça pour dire que nous avons ici des directives pour avoir nos différentes sections.

	>	section .data						
			message db 'Hello World !', 10	
			...								 

Donc là je ne peux pas vous en dire davantage puisque il faudra que je vous explique plus tard quand vous allez apprendre ce qu'est .data, à quoi correspondent .bss, à quoi correspond .text mais déjà d'un rapide coup d'oeil sans même encore une fois savoir dans le détail ce que ça fait, vous avez remarqué que très certainement une chose c'est qu'ici on avait donc nos instructions principales de notre programme qui était dans cette section .text donc a priori elles jouent un rôle bien particulier.

On voit que celle ci ' message db 'Hello World !', 10 ' nous avons une donnée qu'on a directement écrite càd qu'on a ici une chaîne de caractères or on a une constante.

Et là on voit qu'on a une donnée si vous voulez qui est réservé 'written resq 1' d'accord on a réservé en fait une place, un emplacement en mémoire sans pour autant dire voilà qu'on veut une chaîne, un caractère précis ou autres donc on va avoir comme ça des choses en fait entre données initialisées, données qui ne sont pas initialisées alors s'il y en a qui font du c ou autre, vous avez par exemple voilà les données initialisées, vous avez des pointeurs d'accord qui ne sont pas forcément des données au départ qui pointe sur quelque chose ou en tout cas qui sont directement constant ou autre d'accord qui peuvent être parfaitement changées.

Donc on va avoir comme ça voilà des données constantes, des données variables et forcément on va avoir différentes partie en mémoire pour pouvoir gérer tout ces types d'informations mais on en parlera aussi plus tard c'est encore tôt pour aborder ça dans le détail pour le moment donc on va y aller étape par étape de toute façon il n'y a rien qui presse à ce niveau là.

Voilà pour cette partie.

Place maintenant à quelque petites autres choses pour terminer cette séance, je pense qu'on a fait de façon un peu le tour.

Alors ce sont les commentaires.

Les commentaires on retrouve ça dans tous les langages de programmation c'est une partie en fait au niveau de votre code qui ne sera tout simplement pas prises en compte.

Le commentaire il sert tout simplement aux développeurs et en langage assembleur vous allez très certainement l'utiliser beaucoup.

Là ou sur d'autres langages de programmation je vous disais et je vous donnais le conseil d'auto documenter votre code c'est à dire que par exemple plutôt de dire ok je déclare une variable de type int en langage c et puis je mets un commentaire pour dire que bah ça correspond je sais pas moi à l'âge de l'utilisateur d'accord.

	int data;//Age de l'utilisateur

Ce qui serait là pour le coup une très mauvaise conception. Voilà on peut parfaitement faire ça comme ça et si on aime bien mettre du français dans son code, on peut faire ça comme ça bref peu importe le terme que vous utilisez d'accord.

	int data;//Age de l'utilisateur
	int user_age;
	int age_utilisateur;
	int ageUtilisateur;

Voilà on auto documentes son code et ça évite d'avoir un commentaire ici pour le coup qui aurait pu être implicite rien qu'avec le nom en fait choisi pour notre variable d'accord.

Le problème avec le langage assembleur et il est conçu comme ça forcément sans que vous ayez forcément plein d'informations vous comprenez que on a quand même des notations qui sont très raccourcie d'accord sans même que vous sachiez ce qu'est une instruction, ce qu'elles font.

On a quand même des mots en 3 lettres, en 4 lettres donc forcément on a ça 'mov rcx, rax' et puis ça si vous demandez qu'est ce que ça veut dire en français et bien en tout cas si on ne commente pas ça un minimum voilà alors forcément à force de pratique vous serez automatiquement en voyant ce genre ligne vous serez dire ah oui je sais ce que ça fait en réalité mais parce que vous avez appris d'accord parce vous savez ce que ça fait.

Pour autant si vous revenez après plus tard sur un code si en plus vous travaillez sur plusieurs architectures différentes ou sur plusieurs supports donc microprocesseurs, microcontrôleurs différents forcément passer d'un code à l'autre des fois même si en soit la théorie on l'a, on est bien content d'avoir commenté notre code pour se dire ah oui en fait cette partie du code c'est pour faire telle chose parce que peut-être que sur le moment on le sait mais pas dit que 6 mois plus tard pas dit qu'on s'en souvienne et surtout dans le détail d'accord.

Comme là 'mov r8, 13' par exemple parce que c'était pour l'exemple mais ce 13 au final mis comme ça bon on ne sait pas du tout à quoi correspond le 13 d'accord sur le coup je pourrais très bien reprendre ce code dans un an et me dire mais pourquoi j'ai mis un 13 ici et après forcément en lisant en voyant que c'est des paramètres pour mon appel mais on se dira ah oui c'était pour la longueur de la chaîne.

	mov r8, 13 ; 13, longueur de la chaîne

D'accord mais c'est quand même pas évident d'accord d'un coup d'oeil c'est pas évident de le savoir.

Pour cela on peut utiliser des commentaires et les commentaires en langage assembleur commence par un point virgule d'accord or il y a moyen de bricoler pour avoir des commentaires écrits sur plusieurs lignes mais ce n'est pas l'idéal donc je vous conseillerais au maximum de privilégier ces commentaires là.

Donc oui si vous devez commenter par exemple ces trois lignes et bien il faudra le faire cette manière. Et si vous voulez faire ça proprement vous pouvez aligner ça pareil voilà et là c'est magnifique.

	extern GetStdHandle		;
	extern WriteConsoleA 	;
	extern ExitProcess		;

Et là par exemple on peut dire ceci.

	extern GetStdHandle		; Gestionnaire de périphérique
	extern WriteConsoleA 	; Ecriture en mode console
	extern ExitProcess		; Arrêt du processus

Voilà comme ça vous pouvez commenter votre code bon là les commentaires ne sont pas spécialement utile à ce niveau là mais pourquoi pas.

Simplement par exemple de se dire finalement de quel parti, de quelle bibliothèque de windows appartient cette fonction GetStdHandle par exemple pour pouvoir ensuite au niveau l'édition de liens, ajouter les bonnes bibliothèques qu'il faut parce que là on n'avait que kernel32.dll mais on a aussi user32.dll et on a gdi32.dll qui sont les trois principales que nous avons pour l'api windows.

Ca bon des fois ça on n'a pas forcément tout en tête, il y a des moments où vous allez utiliser des fonctions qu'une seule fois un jour dans votre code et vous aurez besoin voilà des fois de mettre un commentaire pour dire que bon bah ça en fait ça vient de kernel32.

	extern GetStdHandle		; kernel32
	extern WriteConsoleA 	;
	extern ExitProcess		;

Comme ça automatiquement avec votre éditeur de lien, vous serez que ah oui il faut que j'ajoute cette bibliothèque sinon l'édition de lien ne risque pas de fonctionner à ce niveau là.

Donc très pratique les commentaires et autant sur un langage généralement bien conçu dans un autre langage de programmation, on ne va pas s'amuser forcément a commenter ligne par ligne par contre en langage assembleur si un jour vous regardez d'autres codes etc ne soyez pas étonnés de voir limite un commentaire sur chacune des lignes du programme.

Voilà ce n'est pas du tout un problème à ce niveau là alors est-ce que c'est utile de mettre forcément un commentaire ici.

	bits 64 ;

Bon quand on est en train d'apprendre si par exemple vous êtes en train de prendre des notes, que vous avez recopier le code plus ou moins déjà de votre côté et que vous voulez le commenter pour vous souvenir de ce que ça parce que vous êtes en train d'apprendre, c'est logique.

Par contre donc quand on a voilà un minimum d'expérienc, qu'on a l'habitude de programmer en langage assembleur, je vous avouerai que commenter ça.

	bits 64 ;

Voilà d'accord il n'y a pas tellement besoin par contre même quand on a l'expérience et cetera, commenter ça, c'est pas mal.

		mov rcx, rax
		mov rdx, message
		mov r8, 13
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		...

Parce que pareil en fonction de l'architecture, en fonction de ce qui est utilisé au niveau du système on va avoir par exemple un ordre quand on va faire appel à des fonctions qui ne va pas être le même. Un coup on va prendre les paramètres à l'inverse c'est à dire du dernier au premier, et dans certains cas ça va être du premier au dernier.

Et bien comme l'erreur est humaine et que l'humain n'est pas un infaillible, on peut très bien à un moment donné se demander bon alors est-ce que ici 'mov rcx, rax en fait ça correspond au dernier paramètre ou au premier.

	>	mov rcx, rax
		mov rdx, message
		mov r8, 13
		mov r9,	written
		mov qword [rsp+32], 0
		call WriteConsoleA
		...

On peut avoir un doute donc à l'usage dés le départs en tout cas le fait de l'écrire, de commenter ça permet en fait de ne pas se tromper et d'être sûr.

Voilà on peut parfaitement commenter son code donc sans problème on peut commenter un peu n'importe où évidemment et vous faites un code par ligne, un point virgule et vous pouvez comme ça écrire vos commentaires donc ça bien sûr n'hésitez pas à vous en servir.

Tout de suite forcément vous n'allez pas beaucoup vous en servir puisqu'on va commencer doucement parce qu'il faut savoir qu'en langage assembleur il y a quand même une grosse partie théorique à aborder avant même que commencer à créer vos programmes.

C'est pour ça que je commence par vous détailler pas mal de choses et on va pas beaucoup programmer tout de suite, c'est pour ça que je vous avais d'ailleurs présenté tous ces petits programmes dès le début de la formation pour que vous ayez quand même matière sur lesquels on va faire de l'analyse, faire du repérage sur lesquels travailler un minimum.

Vous n'allez pas forcément programmer à moins peut-être de modifier un peu des points, ça je pense qu'il y en a certains qui à ce stade sont déjà capables de le faire par exemple de changer ce message là 'Hello World' et se dire bon comme je vous l'expliquais que plutôt ça.

	message db 'Hello World !', 10
	...
		mov r8, 13

On faisais correspondre la taille, un nombre de caractères ici bon je pense qu'à ce stade n'importe qui si je vous demande d'afficher un autre message même si vous comprenez pas tout ce code vous êtes largement capable de le modifier pour afficher n'importe quel message.

Il vous suffira de changer la chaîne là 'Hello World !' en conséquence de changer la longueur 'mov r8, 13' que vous avez indiqué ici et voilà.

Après il y aura peut-être d'autres erreurs qui pourraient survenir mais en tout cas de manière on va dire naïve ou une maniére débutante c'est comme ça qu'on ferait et ça il n'y a pas de problème vous pouvez déjà le faire.

Voilà donc il y a beaucoup beaucoup de choses à voir et de toute façon on va détailler tout ça par la suite.

Les commentaires encore une fois très pratique à ce niveau là.

Il existe également une autre directive or ça c'est un cas particulier je la présente parce que peut-être peut-être qu'on l'utilisera c'est par exemple quand on veut travailler avec un jeu d'instructions en particulier mais comme je vous ai pas encore parlé de ce qu'était les instructions donc je vais vous présenter très rapidement en fait en résumant ça pour le moment comme étant en fait une liste si vous voulez ... Les instructions ce sont tous ces termes que vous voyez ici.

			mov 
			call

			sub 
			sub 

			mov 
			mov 
			mov 
			mov 
			mov 
			call

			add 

			xor 
			call

Donc comprenez ça en fait comme une liste de fonctionnalités même si ce n'est pas forcément exact dit comme ça mais je reste assez simple pour le moment qui sont disponibles par rapport en fait aux processeurs par exemple que vous avez d'accord au processeur.

	cpu...

Et on peut donc par des fois en tout cas votre programme, il a accès à l'intégralité en fait des instructions même si par exemple vous avez un processeur actuelle vous pouvez utiliser des instructions d'anciens modèles de processeurs à condition bien sûr qu'elles soient compatibles mais tout ce qui est compatible en gros avec votre processeur vous pouvez l'utiliser comme instruction.

Mais on peut parfaitement si on veut manuellement un petit peu comme on le fait ici avec cette directive bits indiquer d'utiliser en fait un jeu d'instructions ou d'un processeur précis, par exemple le intel 8086, on peut parfaitement indiquée comme ceci de n'avoir que de disponible les instructions de ce processeur-là.

		bits 64
	>	cpu 8086

		extern GetStdHandle
		extern WriteConsoleA
		extern ExitProcess
		...

Donc ça c'est pas des numéros que je sors au pif non plus ça correspond en fait à des modèles de processeurs voilà vous pouvez chercher les processeurs intel, les processeur AMD voilà on a le 8086, on a plein de modèles comme ça en fonction de leur date de sortie ou autres, qui ont donc un numéro qui correspond et on peut parfaitement restreindre d'accord la disponibilité des instructions disponibles au niveau de notre programme donc ça c'est une directive qu'on peut avoir à utiliser ça peut être sympa temps en temps quand on veut se restreindre en fait à certaines parties que je voulais vous montrer pour cette séance.

		bits 64
	>	cpu 8086

		extern GetStdHandle
		extern WriteConsoleA
		extern ExitProcess
		...

Qu'est ce que je peux également terminer ? on va peut-être terminer sur tout ce qui est macro.

Alors les macro et ça c'est pareil si vous avez déjà programmés dans d'autres langages, on en a fait en c. On en a parlé un peu bon forcément en c++ ça c'est assez logique. On en a surtout parlé en langage c, c'est tout ce qui est partie préprocesseur donc là encore une fois ça concerne NASM à ce niveau là parce que je vous ai dit que chaque assembleur propose sa syntaxe d'accord et a aussi ces propres fonctionnalités c'est à dire qu'au niveau de la syntaxe même si bon le système d'instruction que vous aller retrouver sur n'importe quel assembleur, il y a certaines directives d'accord qui vont être propre par exemple à certains assembleur.

Alors il y en a qui s'accordent sur les mêmes termes mais attention il est possible qu'un jour où vous travaillez sur un autre assembleur où les noms de directives ne sont pas du tout les mêmes d'accord donc attention ce n'est pas portable et ce n'est pas 100% compatible avec tous les assembleurs qui existe.

N'oubliez pas que des assembleurs sont des programmes qui sont faits pour faire de l'assemblage et forcément chacun propose un petit peu ses fonctionnalités, ses fonctions tout simplement, ces raccourcis et nous avons notamment donc toute la partie préprocesseur c'est à dire ce qui va être fait avant l'assemblage qui permet de faire tout un tas aussi d'opérations au niveau de notre programme.

Sur nasm, c'est macro donc on va surtout parler de macro ici de pré processeur et le pré processeur on en parlera dans le détail, j'en ai parlé un petit peu sur la chaîne mais si vous ne savez pas trop en détails de toute façon on aura bien l'occasion de reparler de tout ça dans le détail par la suite.

On va les distinguer avec le caractère %.

	%

En macro j'ai envie de dire la plus simple qu'on pourrait faire c'est de créer en fait une macro de remplacement.

Généralement quand on parle de macro en informatique on parle tout simplement de définir un terme qui sera remplacé où toutes les occurrences de ce terme seront remplacés par un autre et cela s'opère non pas au moment de l'assemblage ici ou dans d'autres langages de programmation par exemple au moment de la compilation mais avant d'accord.

Donc si je décide via une macro qui s'appelle ici define d'accord.

	%define

Si je décide de changer de mettre par exemple hello.

	%define hello

Voyez j'utilise ici un terme, une étiquette en gros par ça 'Hello World !' et je pourrais à ce moment là utiliser cette macro.

	%define hello 'Hello World !'

Là pareil certaines macro dans certains langages de programmation on a l'habitude de les mettre en majuscule, en langage d'assembleur vous voyez.

	%define HELLO 'Hello World !'
	%define hello 'Hello World !'

Il n'y a pas d'obligation non plus et il n'y a pas de norme, c'est chacun voit comme il veut mais en faisant comme ceci et bien en fait on a directement utiliser cette macro 'define' d'accord.

main.asm
```asm
	bits 64
	
>	%define hello 'Hello World !'

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
>		message db hello, 10

	section .bss
		written resq 1

	section .text
		global main
		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Utiliser directement cette macro qui est définie avec cette instruction en fait define, cette directive define qui est une macro.

On dit qu'à chaque endroit où on va rencontrer ce terme là, hello on va le remplacer par 'Hello World !' d'accord donc c'est très important donc la pareil si je recompile parce que des fois quand on enregistre on peut dire des bêtises qu'on fait pas d'inattention.

	nasm -f win64 main.asm -o main.obj
	golink.exe main.obj /entry main /console kernel32.dll
	main.exe
	
	Hello World !

J'ai pas fait d'erreurs donc c'est bon et on va automatiquement avoir le remplacement qui est effectué alors il faut pas en abuser non plus mais ça peut être pas mal pratique quand vous allez avoir par exemple quelque chose qui se répète, notamment une valeur ici d'accord.

	mov r8, 13

Je pourrait me dire bah que passer ça, 13 c'est quand même pas pratique donc moi je vais faire une macro define de par exemple message_length.

	%define message_length 13

Alors je mets un nom assez long mais comme ça au moins je sais à quoi ça correspond et je remplace ça par 13 et le remplacer dans l'instruction.

main.asm
```asm
	bits 64
	
>	%define message_length 13

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db hello, 10

	section .bss
		written resq 1

	section .text
		global main
		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, message_length
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Je n'ai plus qu'à faire ça donc la mine de rien on rajoute de la visibilité au niveau de notre code d'accord plutôt d'avoir un 13 qui traîne en plein milieu, on a déjà en ayant ça, on comprend un peu plus que nous avons donc c'est une possibilité on peut faire comme ça des macros ici ça nous permet d'ailleurs de faire une constante à ce niveau là d'accord on a un remplacement qui est fait avant même que le programme soit assemblé.

Ca veut dire qu'il ne s'agit pas de faire des conversions bizarre c'est juste du remplacement d'accord c'est que le pré processeur de nasm ici eh bien il va rencontrer ça message_length donc ce qu'il va faire, il va le remplacer par 13.

Donc le code qui va être assemblés en réalité ce sera bien celui-là.

main.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10

	section .bss
		written resq 1

	section .text
		global main
		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, 13
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Donc ça il n'y aura plus tout ce qui est directive préprocesseur elles ne seront plus dans le code et quand il va faire l'assemblage il va assembler ça d'accord il n'y aura plus l'existence de message_length d'accord elle aura disparue cette macro il aura déjà effectué le remplacement.

Voilà c'est juste encore une fois pour le développeur ça peut avoir un côté pratique d'accord.

On peut éventuellement créer des macros aussi avec l'autre symbole qui est %assign, on s'en sert aussi pour faire des constantes d'accord je pourrais très bien remplacer ça part ça et pareil on verra un petit peu les différences d'usage plus tard encore c'est pas forcément très très pertinent tout de suite mais on pourrait parfaitement faire ce genre de choses-là.

	bits 64
	
	%assign message_length 13

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess
	...

Et ce qu'on va retrouver plus souvent, je vais juste vous montrer parce que c'est pareil il faudra que je vous explique plus tard aussi comment ça fonctionne derrière parce qu'il n'y a rien de magique mais d'avoir en fait une autre façon si on veut d'avoir une constante.

Une constante pour ceux qui ne savent pas c'est une valeur, une information qui ne va pas pouvoir changer d'accord de valeur et ici à priori tout au long de l'exécution de ce programme, il n'y a aucune raison que ce terme là 'Hello world !' càd que je défini un texte qui va pas changer d'accord ce sera toujours ça ce texte.

		section .data
	>		message db 'Hello World !', 10

Il n'y a pas de raison qu'un coup ce texte au départ fasse 13 caractères et puis que plus tard il en fasse plus que 10 par exemple.

On est d'accord que tant que vous ne changez pas ici vous ne changez pas la chaîne, sa longueur ne va pas changer non plus d'accord ce sera quelque chose de constant donc on pourrait parfaitement ici crée donc via une éthiquette et donc pareil vous pouvez mettre les points si on voulez c'est vous qui voyez.

		bits 64

		extern GetStdHandle
		extern WriteConsoleA
		extern ExitProcess

		section .data
			message db 'Hello World !', 10
	>		message_length ...
		...

Et ici on va utiliser un cas particulier qui est le equal (equ) je serai obligé de revenir en détail sur ce que c'est comme au moment où je vous expliquerai à quoi correspond ce 'db' et cetera donc je vous donne juste le terme sans vous expliquer forcément en détail ce que ça fait parce qu'on verra ça plus tard.

		bits 64

		extern GetStdHandle
		extern WriteConsoleA
		extern ExitProcess

		section .data
			message db 'Hello World !', 10
	>		message_length equ $-
		...

Et on peut ensuite indiquer via un préfixe assez particulier qu'on retrouve à nouveau qui est le dollar et un tiret, pareil on peut tout coller, on peut mettre des espaces parce que vous savez qu'au niveau du langage assembleur vous avez vu que les espaces, les tabulations c'est pas un problème.

Encore une fois si je veux faire ça comme ça.

```asm
section .text				section .text
	global main					global main
	main:							main:mov rcx, -11
		mov rcx, -11					call GetStdHandle
		call GetStdHandle				...
		...
```

C'est mal présentés (droite) mais on peut le faire, ça marchera, ça ne posera pas de problème donc après bien sûr faite l'effort quand même de présenter votre code proprement, ne pas tout mettre n'importe comment sur une ligne.

Voilà faites un minimum d'effort et ici c'est en fait ma longueur de ça.

		bits 64

		extern GetStdHandle
		extern WriteConsoleA
		extern ExitProcess

		section .data
			message db 'Hello World !', 10
	>		message_length equ $-message
		...
	>			mov r8, message_length

Ainsi je crée une constante, message_length, qui est égal 'equ' en fait au nombre de caractères qu'on a ici 'Hello World !' donc c'est un cas un peu particuliers qui qu'après on peut à nouveau faire ça.

main.asm
```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Hello World !', 10
		message_length equ $-message

	section .bss
		written resq 1

	section .text
		global main
		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
>			mov r8, message_length
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

D'accord là pareil pour être sûr de ne pas vous avoir dit des bêtises, voilà on a le programme qui s'exécute.

	nasm -f win64 main.asm -o main.obj
	golink.exe main.obj /entry main /console kernel32.dll
	main.exe
	
	Hello World !

Voilà on a le programme qui s'exécute aussi, on est passé cette fois par une constante pour l'appel ok.

message_length, cette constante est calculée en fonction de ce que nous avons là 'Hello World !' càd qu'à tout moment si je fais ça.

```asm
	bits 64

	extern GetStdHandle
	extern WriteConsoleA
	extern ExitProcess

	section .data
		message db 'Bonjour tout le monde', 10
		message_length equ $-message

	section .bss
		written resq 1

	section .text
		global main
		main:
			mov rcx, -11
			call GetStdHandle
			
			sub rsp, 32
			sub rsp, 8
			
			mov rcx, rax
			mov rdx, message
			mov r8, message_length
			mov r9,	written
			mov qword [rsp+32], 0
			call WriteConsoleA
			
			add rsp, 32+8
			
			xor ecx, ecx
			call ExitProcess
```

Voyez je ne suis plus obligé de compter le nombre de caractères puisqu'elle va être calculée en fonction de celle-ci par contre une fois que cette constante est définie, est déclarée, c'est terminé sa taille ne va plus ne changera plus, ce sont des constantes.

		section .data
			message db 'Bonjour tout le monde', 10
	>		message_length equ $-message
		...

Et là pareil, on ré assemble, on édite, on ré exécute le programme et ça fonctionne sans problème d'accord.

	nasm -f win64 main.asm -o main.obj
	golink.exe main.obj /entry main /console kernel32.dll
	main.exe
	
	Bonjour tout le monde

C'est déjà un peu plus dynamiques par rapport à la séance précédente où on mettait la valeur en dur là 13 caractères par rapport à ça.

Là on a plusieurs manières de faire.

Alors pour tout ce qui était macro d'accord ça et les valeurs qui commence par % c'est comme en langage c par exemple pour ceux qui en ont fait, on a très vite possibilité de faire tout et n'importe quoi donc généralement et vous l'avez vu en c, on n'a pas abordé ce genre de chose au tout début du cours.

J'ai laissé pas mal de séances, on a abordé énormément de choses avant d'avoir une vidéo sur le pré processeur et encore je restais sur des choses assez on va dire standard, assez simple parce qu'encore une fois c'est tout un monde le pre-processing c'est tout une grosse grosse grosse partie qu'on peut retrouver ici en programmation et généralement les novices et tout ça on tendance à faire un peu n'importe quoi avec ça parce qu'ils ne savent pas forcément l'utilité que ça a donc faut pas faire n'importe quoi non plus avec ça et il faut au maximum en tout cas quand on peut s'en passer, il faut s'en passer d'autant que dans ce cas là ça concerne je vous dit cet assembleur nasm donc ça veut dire que ce n'est pas forcément compatible et portable et en tout cas reconnu par les autres assembleur là où par contre quand on travaille avec des instructions particulières forcément on va avoir une certaine compatibilité avec d'autres outils d'accord donc pour les macros on verra.

Alors on verra également comment créer nos propres macro, on verra éventuellement comment faire de la macro en fait qui est conditionnel donc ça on aura peut-être besoin de s'en servir dans certains cas on verra, il y aura sûrement des exemples où j'aurai l'utilité de vous montrer comment on peut faire ça et on verra aussi comment travailler avec plusieurs fichiers et dans ce cas-là on utilisera une petite macro ici une petite directive  qui est %include.

	%include 'other.asm'

Et on pourra par exemple ajouter un autre fichier en langage assembleur si on veut d'accord ça bah si vous programmez dans d'autres langages généralement vous ne travaillez pas forcément qu'avec un seul fichier surtout quand vous commencez à avoir un programme conséquent mais bien sûr le langage assembleur ne fait pas exception à la règle.

Voilà donc je pense que je m'arrêter là parce qu'on pourrait évidemment continuer à aborder pas mal de choses mais le but de cette séance encore une fois c'était de vous détailler un petit peu ça càd qu'au départ je vous ai présenté différents codes que j'ai commenté forcément c'était tout nouveau pour la grande majorité d'entre vous et petit à petit on commence à expliquer alors cette ligne 'bits 64' qui a été ajoutée en fait.

Voilà 'bits  ...' c'est une directive et cetera et pour certaines parties comme ce .data, .bss, .txt puis mov, call et cetera on abordera tout ça dans le détail plus tard aussi parce que il y a beaucoup beaucoup à en dire et les prochaines séances vont faire un peu le tour de tout ça.

Voilà je pense que j'ai fait le tour de tout ce que je voulais vous montrer ici donc on va en rester là et bien sûr si vous avez des questions et je pense qu'il en aura pas mal aussi n'hésitez pas pour cette partie là on devrait avoir comme ça pas mal de vidéos mine de rien, on va faire un peu le tour sur des notions théoriques qui sont très importantes et qui sont très très souvent malheureusement négligé surtout sur un langage comme celui là.

Et le problème c'est qu'après quand on n'a pas la théorie et qu'il faut commencer à faire ses programmes et bien on pâtauge et on fait des trucs un petit peu au pif sans savoir vraiment ce qu'on fait ou alors on copie des tutoz sur internet ou des codes prit sur internet, sur des forums et c'est pas comme ça en tout cas pour moi qu'on apprend les choses et c'est pas comme ça que je compte vous enseigner les choses et je ne n'ai jamais comptez vous enseigner les choses de cette manière.

Donc le but c'est de comprendre ce que vous faites et si vous ne comprenez pas il faut avoir la partie théorique qui vous aidera à comprendre pour pouvoir en fait assimiler ce qu'il vous manque et c'est comme ça qu'on progresse et qu'on avance un petit peu là dedans voilà je vous laisse avec eux cette fin de vidéo, de fin de séance.

S'il ya des questions n'hésitez pas on se retrouve la prochaine fois pour d'autres choses.

Encore une fois ce sont pas forcément les vidéos où on va beaucoup pratiquer, beaucoup faire du code et tout ça mais c'est super important il faut surtout pas négliger et passer en diagonale ces vidéos c'est très important pour la suite et ça vous servira énormément ça vous fera gagner un temps monstrueux pour la suite aussi.

Et ça je sais que ça fait plaisir à beaucoup de gens donc on n'y pense et surtout on néglige pas toute cette partie là.

A bientôt pour la suite de cette formation au langage l'assembleur.

Ciao