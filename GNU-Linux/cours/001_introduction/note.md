# [Introduction](https://www.youtube.com/watch?v=py1E14pXfAM)  

## DANS CETTE FORMATION, VOUS ALLEZ DECOUVRIR…

Nous allons découvrir le type de système d'exploitation de GNU/Linux. Il en existe plusieurs, elles sont appelées des distributions qui s'articulent autour du même système d'exploitation, du même OS mais peuvent proposer différentes choses selon la version utilisée.

Voir Introduction.pdf, disponible dans la description.

## GNU/LINUX : SES ORIGINES

### A la base 2 projets :

A la base, GNU/Linux est un projet qui date des années 80-90. A la base, on a 2 projets :

#### GNU (Richard STALLMAN, 1983)

![1](1.png)

GNU est un projet fondé par Richard STALLMAN, ou Richard Matthew STALLMAN dont le diminutif est RMS. Ce projet est représenté par un logo de gnou. Ca se prononce GNOU et non G.N.U. GNU etait un ensemble de logiciels, programmes qui permettaient de faire pas mal de chose. Par exemple, le compilateur GCC fait partie de ce projet GNU et des ensembles de programmes. Monsieur STALLMAN s'est chargé du développement de la conception de GCC qui as bien sûr été rejoint par d'autres personnes parce que on ne peut pas faire ce projet tout seul.

Le problème est que tout ces petits programmes est bien mais il fallait avoir un support pour proposer tout ça et le faire développer.

#### Linux (Linus TORVALDS, 1991)

![2](2.png)

C'est à ce moment-là qu'est intervenu un autre Monsieur issu d'une université, Linus TORVALDS qui a fondé le fameux noyau Linux dont tout le monde entend parler un peu partout. Même si c'est devenu un terme global pour parler des systèmes GNU/Linux. Linux par abus de langage. Il y a des gens qui évite de dire GNU/Linux.

Il est recommandé de l'appeler GNU/Linux. Si on dit Linux tout court, ce n'est pas grave. Si on dit GNU/Linux, c'est plus un critère historique ou d'antériorité parce que GNU est arrivé avant avec des développements en 1983 et 1986 et c'est à partir de 1991 que Linux, c'est popularisé et a été proposé.

Au départ, c'est un projet d'université à la base. Linus TORVALDS avait fait cela pendant ses études et qui a découvert par la suite que ça pouvait avoir un engouement et suscité un intérêt auprès des gens et ça été par la suite distribué, déployé auprès des gens, du grand public.

GNU/Linux, il faut savoir que c'est d'un coté GNU par Richard STALLMAN et de l'autre côté, un noyau Linux fait Linus TORVALDS dont le nom est repris de son prénom. Et c'est la fusion de ces deux là qui formé la base des systèmes GNU/Linux connu aujourd'hui. Ou du système Linux si on veut simplifier le nommage de ce type de système.

## GNU/LINUX : SON CONCEPT

### GNU/Linux en principe :

On connaît Windows, peut être MacOS, Andoid, IOS, Solaris 'pour les anciennes génération) mais qu'est-ce que GNU/Linux en principe ?

#### Un modèle de liberté (reposant sur 4 règles)

En principe GNU/Linux, une grande partie, suivent un modèle de liberté c’est-à-dire ce que l'on appelle la License libre. C'est plus une philosophie, c'est une manière de s'accorder sur plusieurs règles. Notamment 4 libertés fondamentales qui font qu'un logiciel, un programme est dit libre qui sont les suivantes :

- Liberté 0

En informatique, quand on programme, on commence toujours par zéro.

Ça nous donne le droit de pouvoir exécuter un programme et de l'utiliser peu importe l'usage. On se fiche de l'usage que l'on va en avoir. On a cette liberté de pouvoir l'utilisé pour n'importe quel usage possible. Et bien évidemment le droit d'exécuter les programmes avec ce degré de liberté.

- Liberté 1
	
C'est la possibilité, la liberté de pouvoir regarder, analyser, étudier le code. Et pourquoi pas l'adapter à nos besoins si on est programmeur, développeur. Si on a un logiciel libre et qu'une fonctionnalité est manquante ou bien qu'on voudrait changer quelque chose tel que le design ou autre, on pourra le faire et accéder au code source, l'analyser, l'étudier et également le modifier pour pouvoir l'améliorer.

- Liberté 2

Elle consiste à pouvoir redistribuer ce programme. Un programme qui est libre pourra être redistribué sous forme de copie. La philosophie du libre se fiche de savoir si quelque chose est gratuit ou pas. On pourrait très bien reprendre un programme libre et redistribué des copies payantes. C'est tout à fait possible, cela peut fonctionner à usage commerciale. Que ce soit gratuit ou payant, on peut redistribuer des versions modifiées de notre programme qui rejoint la dernière liberté.

- Liberté 3

C'est le droit de pouvoir améliorer un programme. Ce n'est pas parce que c'est un autre développeur que nous n'avons pas le droit d'y toucher ou de l'améliorer. Au contraire, si on veut l'améliorer et qu'on a des idées d'améliorations, elles sont parfaitement bien venues. Nous avons alors cette liberté de pouvoir redistribuer nos modifications, nos améliorations au grand public. Le but c'est de pouvoir redistribuer auprès de tout le monde, que ça profite à tout le monde et pas seulement à nous qui avons modifié ou adapté le logiciel.

Ce sont les 4 règles qui reposent sur la philosophie du libre et GNU/Linux se base là-dessus parce que c'est un peu dans leur intérêt, de suivre et de respecter ce modèle de liberté.

**L'open source**
	
C'était à la base le même principe qui permettait aux gens d'accéder aux codes sources des programmes. L'open source n'est pas égale au libre, ça n'a rien à voir. Quelque chose de libre peut être open source mais l'open source n'est pas forcément libre. L'open source c'est surtout une méthodologie de développement quand on parle en termes technique ou codage. Un développeur qui va créer un logiciel s'il veut que son code soit disponible, on va parler d'open source.

Le libre est plus une philosophie, ce n'est pas quelque chose de technique. On pourrait d'ailleurs appliquer cette notion de liberté à d'autres choses que de l'informatique alors que l'open source on ne pourrait pas l'appliquer à autre chose que de l'informatique, ce ne serrait pas logique. On parle vraiment en termes technique, codage alors que la liberté, le libre ça peut être appliqué un peu partout, on pourrait avoir ça en jardinage, en cuisine, un peu n'importe quoi, ça pourrait parfaitement s'adapter.

Voilà pour le premier principe, voyons le second…

#### Assure l'interopérabilité (formats ouvert, respect des normes)

Un second principe est le fait de pouvoir assurer l'interopérabilité qui veut dire que l'on s'assure que d'une personne à l'autre, peu importe l'ordinateur que l'on a, on s'assure d'avoir les mêmes choses.

Le premier, le plus important, ce sont les formats ouverts qui suivant qu'on utilise certains logiciels de traitement de texte, logiciels de bureautique, on a des formats que l'on appelle l'Open document. L'open document ça assure en fait que par exemple si on écrit un programme, un traitement de texte sur le pc et que l'envoie par mail à un collègue sur son pc s'il peut bien évidement travailler avec ce même format ouvert quand il va ouvrir le fichier, il aura exactement l'identique. Il n'y aura pas deux choses différentes au niveau de l'affichage, etc.

C'est ça tout l'avantage des formats ouverts, c'est permettre déjà de ne pas devoir avoir un système de droit obligatoire ou même de devoir payer des formats, formats en général qui sont gratuits et aussi de pouvoir assure la compatibilité peu importe la personne qui va lire le fameux fichier. On retrouve ça sur les fichiers de traitement de texte, sur les tableurs si on utilise un format ouvert. On peut retrouvez ça dans d'autres formats également, des formats d'encodages, etc qui sont ouvert, des formats pour les médias, des formats pour le web.

**Respect des normes**
	
Un autre principe important est le fameux respect des normes qui rejoint surtout le web avec notamment le navigateur Firefox et la fondation Mozilla qui se charge de respecter es normes du W3C (World wide web consortium), leur but est de bien respecter les normes qui ont été établies pour s'assurer qu'un site qui va être développer et afficher sur Firefox respecte ces fameux standards. Chose que d'autres type de logiciels ne ferait pas forcément.

Après Firefox n'est pas forcément un GNU/Linux. Firefox est un logiciel que vous pouvez d'ailleurs installer sur Windows MacOS, voilà mais c'est surtout pour comprendre que GNU/Linux en principe ils favorisent et il encourage l'usage de logiciels qui respectent les normes et qui utilisent des formats ouverts. Ils assurent l'interopérabilité. On peut dire également qu'ils encouragent l'interopérabilité. C'est tout à fait pareil. L'utilisation de formats ouverts et le fait de bien respecter les normes ou évidemment des conditions qui ont été spécifiées.

Voilà le deuxième point qu'on voulait aborder et ça rejoint très rapidement le troisième point qui est, notamment par rapport à la liberté, de viser le partage et l'échange.

#### Vise le partage et l'échange

Comme il y a surtout beaucoup de distribution possible de Linux et beaucoup de gens du coup qui peuvent travailler sur des codes, des logiciels, tout ça. Vous allez avoir beaucoup de communautés qui vont se développer, des espaces des changes des forums, des salons IRC, etc. Ça incite les gens un petit peu à s'y mettre. Des gens à la base qui n'était que utilisateurs d'un système GNU/linux et qu'ils deviennent petit à petit contributeur ou développer, qui interviennent en fait comme acteurs sur cette espèce d'univers. On peut appeler ça un univers, l'univers GNU/Linux.

Donc c'est plutôt sympa. Ça encourage vraiment le partage et ça incite les gens à partager, à échanger entre eux. A discuter entre eux aussi. C'est un des principes de ce système d'exploitation. Donc vraiment, il y a beaucoup de discussions qui se font autour de ces systèmes là et je trouve que c'est important ce que c'est bien de discuter, d'échanger, de débattre.

#### Propose une meilleure sécurité

En principe donc GNU/Linux propose une meilleure sécurité (on ne parle pas des virus ou des menaces possible ou impossible sur la séance) mais en principe Linux propose une meilleure sécurité sur un système GNU/Linux par rapport à un système par exemple Windows ou MacOS, tout simplement parce que ce sont des systèmes qui ont été conçu à la base de manière à bien séparer les privilèges. Les privilèges tout simplement un système de droit qui vous permet de faire certaines choses au nom sur un système.

Par exemple, "lancer un logiciel" on va dire que ça va être un privilège tout à fait normal pour un utilisateur lambda. Cependant "installer un logiciel", ça demande justement sur GNU/Linux des privilèges supplémentaires. C'est un droit en plus que n'importe quel utilisateur ne peut pas faire. "Désinstaller" pareil, c'est même encore pire "pouvoir supprimer des fichiers systèmes" ou autre, ça demande des privilèges particuliers.

Ce qui peut corrompre ou venir entacher la sécurité d'un système GNU/Linux c'est une faille dans un logiciel, un programme, un protocole ou autre qui permettrait une ce qu'on appelle une élévation de privilèges. C'est à dire que vous allez pirater par exemple un système ou autre, exploiter une faille pour "hacker" en fait, pour permettre d'obtenir les privilèges qui sont demandés. C'est un peu comme si par exemple vous aviez une salle secrète fermée, verrouillée par carte et que le seul moyen de pouvoir y rentrer si vous êtes d'accord c'est bien évidemment de pouvoir soit pirater le système bien évidemment donc trouver une faille dedans ou alors de voler la carte de la personne qui a accès à cet endroit-là. Et évidemment à partir du moment où vous avez l'accès vous pouvez faire tout n'importe quoi et la sécurité est dite corrompue mais d'une manière générale comme il y a effectivement une bonne distinction des privilèges et des droits de chacun. C'est à dire qu'un utilisateur 'A' n'aura pas forcément les mêmes droits qu'un utilisateur 'B'.

Chose qu'on va retrouver de manière plus courante sur Windows et MacOS. Pour Windows et MacOS, vous installez le système par défaut, vous êtes administrateur.

Donc si vous allez dans le dossier system32, vous le virez, votre Windows il ne marche plus, vous devrez restaurer tout votre système. Sur Linux, ça n'est pas possible. Sur Linux, si vous allez dans les fichiers du système vous essayez de les supprimer en faisant un clic droit supprimer ça ne marchera pas on vous dira que vous n'avez pas le droit de faire ça pourtant c'est votre système vous l'avez installé.

Il faudra passer en mode super utilisateur ou en administrateur ou à voir si vous êtes dans une école ou autre, les privilèges adéquates pour pouvoir le faire. Donc il y a une meilleure sécurité dans ce sens-là.

On ne laisse pas l'utilisateur de base faire tout et n'importe quoi sur ce genre de système et du coup bien évidemment ça propose une meilleure sécurité et on va dire en conséquence aussi, une meilleure stabilité. On a quelque chose de plus stable puisque ça évite de faire un petit peu tout et n'importe quoi.

On reviendra plutard l'aspect sécurité autour de Linux parce qu'il y a beaucoup de débat là-dessus. Il y a plein de gens qui vous disent mais non ce n'est pas sécurisé Linux.

#### Peut se déployer partout (serveurs, [super]ordinateurs, embarqué)

Un principe de GNU/Linux est qu'il peut se déployer du coup partout nous avons du Linux sur les serveurs vous avez du Linux, sur vos ordinateurs, ou sur des super ordinateurs, ou des calculateurs. On a du Linux également en robotique en domotique. Sur tout ce qui est systèmes embarqués les consoles de jeu ect.

Par exemple : un Rasberry PI (une espèce de micro-pc), un quadricoptère (manipulation des hélices, d'un système de caméra), les décodeurs, la domotique dans les maisons (sur les frigos), sur les serveurs, etc.

C'est vraiment ça l'intérêt aussi de GNU/Linux c'est que du coup il peut être disponible un peu partout.

Donc ça c'était le concept de ce que je voulais montrer sur le concept de GNU/Linux. Ce qui s'articule en fait autour de tout ce type de système d'exploitation et du coup j'en viens à des questions intéressantes et surtout pour l'utilisateur lambda. C'est à dire l'utilisateur... qui débarque comme ça sur GNU/Linux et qui ne sait pas trop à quoi s'attendre. Pour qui ça peut être utile d'utiliser ça ? Et pourquoi surtout utiliser GNU/Linux ? C'est la question la plus importante.

Avant de vous parler de sécurité, de stabilité, tout ça. Le plus important c'est vous dire, à quoi ça va servir de l'utiliser ? Je suis peut-être déjà sur Windows ou MacOS quel intérêt en plus ?

### Pourquoi utiliser GNU/Linux ?

- La gratuité (mais pas toujours ! Certaines licences sont payantes).

Le premier point le plus important, c'est la gratuité mais attention pas toujours. C'est-à-dire qu'il y a des systèmes GNU/Linux, en majorité, ils sont gratuits. C'est quand même un gros avantage : vous pouvez installer un OS sur votre pc sans rien payer. Il n'y a pas de licences à payer, etc. Cependant il existe des distributions GNU/Linux qui sont payantes. Donc attention ... qui dit GNU/Linux ne veut pas forcément dire gratuit mais c'est quand même un point, pour l'utilisateur tiers, qui est important pour lui. Il y a beaucoup de gens qui vont s’intéresser à GNU/Linux parce qu'il est gratuit, parce qu'ils n'ont peut-être pas les moyens de payer une licence Windows ou MacOS. C'est l'argument qui est le plus demandé en fait pour les gens qui s'intéressent à Linux. C'est le fait de se dire c'est gratuit donc ça se dire c'est gratuit du coup moi ça m'arrange, voilà ! donc c'est premier point mais attention pas toujours. Il y a des exceptions.

- Besoin (Si Windows ou Ios suffisent, pas besoin d'installer Linux).

Le deuxième point qui est le plus important et qui devrait être vraiment respecté, c'est le besoin. C'est-à-dire que si vous avez absolument tout ce qu'il vous faut sur Windows, MacOS ou un autre système quelconque… honnêtement, ça ne sert à rien d'essayer Linux. Après vous pouvez vous y intéresser par simple curiosité, pour voilà pour la culture générale mais inutile de vous mettre sur Linux si vous avez déjà tout sur votre système actuel. Si votre Windows, votre MacOS rempli satisfait absolument tous vos besoins ça ne sert à rien de vouloir changer pour dire je change ou alors je fais comme tout le monde.

En premier point, Il faut vraiment que l'intérêt dont je vous dis en premier soit la gratuité ... voilà si pour vous c'est important que ce soit gratuit ... et du coup ça vous évite, voilà, de devoir payer.

Et le deuxième point important, c'est le besoin. Par exemple vous êtes sur un système mais il vous manque certaines choses, des choses qui vous dérange sur Windows où il y a des choses qui vous dérange sur MacOS et du coup vous vous dites peut-être que sur Linux bah voilà les derniers besoins qu'il me manquent vont être comblés donc à ce moment-là ça peut être un point important, qui donne, du coup, de l'intérêt à utiliser un système de GNU/LInux en deuxième point.

- Nouveauté (Ras le bol d'un système, de bugs, etc.).

En troisième, c'est tout simplement la nouveauté. Il y a des gens qui en ont peut-être marre. Ça fait peut-être vingt ans que vous êtes sur Windows pour certains peut-être même plus si vous avez connu les débuts de Windows.

Il y en a peut-être qui sont sur MacOS mais qui en ont toujours marre, qui supportent plus l'interface. Vous avez besoin de changement simplement. C'est la routine toujours le même système ou alors ça n'arrête pas de buguer chez vous où vous en avez marre !

On va dire l'évolution des systèmes ne vous convient plus et ça ne répond plus à vos besoins justement ça rejoint le point précédent et vous avez besoin de nouveau donc ça peut être simplement ça. Il y a des gens peut-être qui se disent tiens Linux je ne connais pas. Ils ne connaissent pas du coup, ils sont intéressés par ça, c'est tout ! Donc la nouveauté c'est un point qui revient souvent c'est pour ça que je l'ai mis en troisième.

- Sécurité et stabilité (le critère revient moins souvent que le critère de prix).

En quatrième, on a la sécurité la stabilité des gens qui sera un petit peu renseigné seront qu'effectivement vous aurez une meilleure sécurité sur Linux que sur en Windows ou MacOS et pour certaines personnes et vous voyez que c'est seulement en quatrième point.

Ça peut en intéresser certains. Pourquoi je l'ai mis en quatrième ? alors que les gens en général l'aurez mis tout de suite en premier ! Tout simplement parce que madame Michu donc ce qu'on appelle encore une fois l'utilisateur lambda, la personne d'une manière générale... à la rigueur s'en fiche que son système soit sécurisé ou stables. Tout ce qu'il veut c'est d'utiliser un système et de pouvoir aller sur Facebook, je vous le dis honnêtement ..., lire, regarder des films, écouter de la musique, faire du traitement de texte pour ceux qui travaillent notamment, ceux qui font des études par exemple qui ont besoin d'écrire des rapports aux autres et c'est tout.

La majorité des gens et ça il faut le comprendre, c'est super important. Tout ce qu'ils veulent faire sur leur pc... Tout ce qu'ils font sur leur pc : il y en a qui jouent aux jeux vidéo aussi mais ça c'est encore un autre point mais voilà donc il n'y a qu'une minorité de gens vraiment qui se disent : "moi je veux me voilà moi ce qui m'intéresse vraiment c'est la sécurité, la stabilité".

C'est pour ça que je l'ai mis en quatrième point parce que je trouve qu'il y a beaucoup plus de gens qui recherchent du gratuit ou de répondre à leurs besoins ou la nouveauté avant la sécurité, la stabilité c'est pour ça que je le mets seulement ici au niveau importance selon les gens et les retours comme je vous ai dit que j'ai eu.

- Liberté (l'envie d'utiliser des logiciels libres).

En cinquième point, il y à la liberté tout simplement, voilà donc que ce que j'ai a évoqué tout à l'heure avec la fameuse philosophie du libre. Il y a des gens pour qui effectivement ça un intérêt d'utiliser des logiciels libres ou de se mêler un petit peu à cette philosophie-là.

Après, pareil, je l'ai mise seulement ici parce qu'il y a des gens, franchement, honnêtement, ils s'en foutent de savoir par exemple que Mozilla Firefox c'est un logiciel libre... Il n'en a absolument rien à faire. Tout ce qu'ils veulent c'est un navigateur pour aller sur Facebook, pour consulter leurs mails, regarder des vidéos en streaming et c'est tout ou aller sur YouTube, etc.

Ils s'en fichent de savoir après derrière comment le logiciel a été conçu ? par qui ? comment ? etc. Voilà tout ce qu'ils savent c'est qu'ils ont installé Firefox, que ça ne leur a rien coûté et c'est tout, point. Donc c'est vraiment une minorité de gens qui vont effectivement s'intéresser à la liberté d'un logiciel (le fait qu'un logiciel soit libre). Moi, par exemple, j'en fais partie ça m'intéresse aussi mais je peux être tout à fait conscient qu'il y a une majorité de gens pour qui voilà ça n'a aucune importance ou alors vraiment très minime. C'est pour ça que je le place ici.

### Exemples de distributions GNU/Linux :

Maintenant qu'on a vu un petit peu tout ça, pourquoi en fait les raisons d'utiliser GNU/Linux ? je pense qu'on a fait un peu le tour. Voici quelques noms mais nous verrons ça pour la séance suivante de distribution GNU/Linux. Alors on a des distributions qui sont les bases en fait d'accord, ce sont des grosses distributions, on les appelle même des méta-distributions :

**Bases :**

On a ArchLinux, Debian, Gentoo, Red Hat, Slackware donc c'est des noms comme ça qui ne vous diront certainement rien pour une partie d'entre vous et pour d'autres aussi mais c'est juste à savoir c'est des petits noms comme ça en exemple.

**Dérivées :**

Et on a beaucoup de distributions qui sont des dérivés de ces grosses distributions là ou alors de d'autres comme eOS (Elementary OS), Fedora, Hardy Linux, Mangaia, Manjaro, Mint, OpenSUSE, qui lui-même hérite de SUSE, la version non libre et non gratuite, qui elle-même à la base hérite de Slackware par exemple. Trisquel, Ubuntu, ect. Ubuntu qui est très connu, très rependu. Vous en avez peut-être entendu parler d'ailleurs.

### Exemples de logiciels 

1. Libres qui respectent les 4 règles

Trisquel, Firefox, VLC, Python (on peut récupérer le code source et le modifier), LibreOffice.

Voilà quelques exemples de logiciels libres. C'est dire qui respecte bien les quatre règles évoquées tout à l'heure. Vous avez par exemple Trisquel qui est une distribution Linux qui reposait exclusivement sur des logiciels libres. On a le fameux Firefox (on est beaucoup à utiliser ce navigateur). vlc le fameux lecteur audio et vidéo et donc le lecteur média pareil qui est très utilisé un peu partout même sur Windows. Python pour ceux qui suivent la formation Python. Sachez que python est libre. Vous pourriez si vous voulez récupérer le code source de Python, le modifier et faire votre propre version. Python c'est tout à fait possible, c'est autorisé, puisqu'il respecte effectivement les quatre règles qu'on a et LibreOffice qui est un logiciel de traitement de texte un peu l'équivalent libre de Microsoft Office tout simplement où la suite qu'on a sur MacOS.

1. Privateurs (on a pas le code source pour le modifier)

Windows, Excel, Photoshop, Vegas Pro, Steam.

On a d'autres logiciels mais vous connaissez aussi, les logiciels dits privateurs donc c'est l'inverse en fait, on n'a pas le code source. Enfin voilà, il y a pas mal de choses qu'on ne peut pas faire, on ne peut pas le modifier tel Windows par exemple. Vous ne pouvez pas au code source de Windows, le modifier puis le redistribuer en le revendant ou autre. Excel qui rejoint la suite Microsoft Office. On a Photoshop d'Adobe, on a Vegas pro de Sony, on a Steam pour ceux qui font du jeu vidéo voilà donc Steam est gratuit mais cependant il est privateurs. Vous ne pouvez pas avoir le code source de Steam et certainement pas le modifier pour faire votre propre version de Steam à vous, ce n'est pas possible.

### Ce qu'il faut retenir :

Donc ça c'était grosso modo mais voilà pour répondre à quelques questions pour qui ? pour quoi ? les raisons d'utiliser GNU/Linux. Ce qu'il faut retenir :

- D'autres systèmes que Windows ou MacOS existent.

Ce qu'on voit chez des gens souvent : ils ont passé tellement d'années sur Windows qu'ils pensent qu'il y a que ça qui existe ou alors qu'ils connaissent quand même Mac (connaissez-vous les pc mac ?) et du coup connaissent vous MacOS et il y a plein de gens, GNU/Linux, ne savent même pas que ça existe en fait pour eux c'est un pc c'est forcément sur Windows. Et un mac qui est je le rappelle est un pc. Mac est un pc aussi. Ne faut pas croire pc c'est quelque chose et Mac est autre chose. Un mac est un pc aussi. Du coup ces gens-là sont sur MacOS et pense que voilà il y a que ça, il y a Windows et il n'y a rien d'autre mais non donc c'est bien de savoir qu'il y a autre chose et c'est pour ça que je pense que c'est bien à retenir qu'il y a autre chose que ces systèmes là et que sur téléphone et même autre chose qu'Android et IOS.

- Les systèmes GNU/Linux sont parfaitement accessibles.

A savoir aussi que les systèmes GNU/Linux sont parfaitement accessibles même si certaines personnes vous diront, c'est trop compliqué pour un débutant, plus compliqué que Windows, plus compliqué que MacOS. Dans cette formation, on voit que ce n'est pas plus compliqué que ça. C'est juste une question d'habitude et d'adaptation.

Si on a été baigné dans Windows ou MacOS dès le plus jeune âge, passer à Linux va demander un temps d'adaptation. Mais inversement si on met un enfant de 4 ans sur Linux dès le début, le jour où il va vouloir passer sur Windows 10 ou 15 ans après, il sera complètement perdu.

Windows, Linux ou MacOS, ils sont tous les trois intuitifs.

On peut les découvrir à n'importe age peu importe nos antécédant, notre expérience en informatique ou non, etc. C'est parfaitement accessible autant que Windows et MacOS.

- Ils entendent respecter certains principes (Open Source, libre).

Le troisième point à retenir, c'est qu'ils entendent respecter certains principes. C’est-à-dire l'open source, le libre, l'interopérabilité, l'aspect communautaire, etc. Ce sont certains principes qu'on essaye de respecter dans cette univers GNU/Linux qui sont à retenir par rapport à ce qui a été dit précédemment.

- Ils doivent répondre à des besoins d’utilisateurs et rien d'autre.

C'est très important. Le système, le monde du libre, de l'open source, tout ce qui est GNU/Linux doivent répondre a des besoins utilisateurs et rien d'autre. Le but n'est pas de prêcher le parfait comme si GNU/Linux était un monde parfait et que Windows et MacOS sont le mal.

Ainsi avant même de parler logiciel et OS, on devrait parler besoin utilisateur. Si l'utilisateur veut aller sur Internet, il a besoin de savoir qu'il va pouvoir le faire qu'il soit sur Windows, Linux ou MacOS. S'il a besoin de jouer à des jeux vidéo, il doit savoir qu'il peut faire sur Windows, sur MacOS, ce n'est pas tellement rependu. Sur GNU/Linux, il y a des jeux mais ce n'est pas comme sur Windows. Si c'est un pro gamer, il ne faut surtout pas qu'ils aillent sur Windows ou MacOS. Ça doit répondre avant tout à des besoins utilisateur.

Les gens devront comprendre ces besoins, surtout les défenseurs du libre et tout ceux du l'univers GNU/Linux devront comprendre que c'est l'utilisateur qui doit être satisfait, pour lequel on doit apporter et répondre à des besoins. Quand cela sera compris, ça se passera beaucoup mieux dans l'univers du libre.

- L'univers GNU/LINUX est loin d’être parfait.

Il faut savoir que GNU/Linux est loin d'être parfait (rejoint le point précédent). Il y a aussi un cours sur Windows et rien n'est parfait, il y a des défauts partout. Pour certains Linux ne conviendra peut-être pas du tout et c'est peut-être le cas pour certains sur Windows. Il faut se sortir de la tête que Linux c'est le bien et que les autres c'est le mal. Linux répond à des besoins que Windows ne répond pas forcément et inversement. Chacun ses qualités, chacun ses défauts. A nous de trouver celui qui nous convient…

- Faire cohabiter le monde du libre avec le monde privateur est possible (possibilité de faire cohabiter Windows avec Linux.).

D'ailleurs rien nous empêche de faire cohabiter le monde du libre avec le monde privateurs. Ce qui veut dire qu'on peut utiliser Linux quotidiennement et de temps en temps à Windows pour utiliser PhotoShop. On peut être streamer et jouer à pleins de jeux vidéo et de travailler ou regarder des vidéos depuis un Linux.

Il n'y a pas de raison que si on se met à Linux, de s'interdire d'être sur Windows et inversement.

La guerre qui oppose les gens qui utilisent Windows, les gens qui utilisent Linux, les gens qui sont pro-Android, pro-IOS, pro-Apple, pro-Google n'ont aucune raison d'être, c'est ridicule, des combats de cours de récrée de gamin de cp.

On peut faire sans problème cohabiter le monde du libre et l'open source. On prend conscience que le monde du libre sans Windows, il y a beaucoup de choses que l'on ne pourrait pas faire. C'est dommage de dire que l'un est bien et l'autre n'est pas bien.

On peut également installer deux systèmes d'exploitation sur un même disque dur, sur un même pc. Et qu'au démarrage de notre pc, on pourra choisir sur quel système démarrer. 
On a le droit d'utiliser des logiciels gratuits d'un côté et payant d'un autre côté.

## Quelques ressources intéressantes : 

- Framasoft → https://framasoft.org

Association avec des éléments assez sympa.

- Distrowatch → https://distrowatch.com

Site qui ressence une très grande quantité de distributions GNU/Linux. Il y a même des distributions BSD mais ça c'est autre chose.

- LinuxFR → http://linuxfr.org

Elément de référence dans le monde de Linux avec d'excéllent articles, etc. C'est un petit site au sujet de l'actu du libre, de l'open-source et du monde de Linux. Quand on cherche des logiciels, petits jeux, moteurs, etc. Il y a beaucoup de chose qualité à aller voir.

- Documentation Ubuntu → https://doc.ubuntu-fr.org

La documentation Ubuntu. C'est un peu la bible pour ceux qui se mettent sur Linux.

## A suivre

Dans la prochaine vidéo, on installe notre système. On verra plusieurs distributions disponibles, en quoi elles consistent et ce que l'on pourra trouver de différents entre ces distributions. Si'il y en a des centaines, des milliers, c'est qu'il y a un intérêt d'en avoir autant. 
Nous verrons comment installer notre système pour ensuite commencer à l'utiliser dans la séance d'après. 

> Quelques commandes :

Lister un répertoire
```bash
ls
```
Lister les périphériques PCI
```bash
lspci
```
Lister les périphériques en lien avec ma partie internet (filtrage)
```bash
lspci | grep ethernet
```
Lister les périphériques usb
```bash
lsusb
```
Lister les périphériques PCI avec des précisions (mode verbeux)
```bash
lspci -v
```
Lister les périphériques PCI avec beaucoup de précisions (double mode verbeux)
```bash
lspci -vv
```
Lister les périphériques avec beaucoup de détails (triple mode verbeux) exporté dans un fichier texte
```bash
Lspci -vvv > out.txt
```
Ouvrir le fichier .txt situé dans le répertoire courant
```bash
gedit out.txt
```
Replace la ligne de commande en haut de l'écran
```bash
clear
```
shell par défaut
```bash
bash	
```
shell plus ancien	
```bash
sh
```
Retourne le 'path'
```bash
whereis bash
```
Redémarrer la machine
```bash
Reboot
```
idem en passant par la commande associée au runlevel
```bash		
Init 6
```
Redémarrer la machine
```bash
shutdown -r now
```
Redémarrer dans une minute
```bash
shutdown -r 1
```
Redémarrer à une heure précise, exemple 23h
```bash
shutdown -r 23:00
```
Annuler un redémarrage
```bash
shutdown -c
```
Passer root
```bash
sudo su
```
Quitter les pouvoirs root
```bash
exit
```