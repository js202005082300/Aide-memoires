   /*
       [[ARCHIVE] Hacking #1 - introduction](https://www.youtube.com/watch?v=IsAIGWJ82tc&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=8)
       
       Formation   : Hacking - introduction
       YouTube     : https://www.youtube.com/watch?v=IsAIGWJ82tc&list=PLrSOXFDHBtfFTu6-vUc7lejdp0ls8loq2
       Auteur      : Jason Champagne
       Compilateur : GCC
       Date        : 15-05-20
       Dernière modification    : 15-05-20
   */

   /**
    * Hacking, qu'est-ce que c'est ?
    ********************************/
   /*
        Vidéo d'introduction pour présenter ce qui sera aborder sur cette chaîne
        ainsi que les prérequis nécessaires.
        Prendre le pdf "hacking-ethique-v4.pdf" pour suivre la formation.
        On lit le sommaine et posons-nous quelques questions :

            Qu'est-ce que cette formation ?
            Qu'est-ce qu'on entend par hacking ?

        Le hacking tel qu'on va le voir, on va voir des méthodes éthiques et non
        éthiques, des méthodes légales avant tout.

        On va voir des méthodes légales pour travailler dans ce qui englobe la 
        sécurité informatique. C'est un domaine très vaste, ça peut concerner la
        sécurité des logiciels, des systèmes, des infrastructures, du réseau, du
        matériel en soi. C'est l'engloblement de toutes ces notions, catégories,
        sur les quelles on va travailler.

        Un hacker c'est quelqu'un qui va détourner le fonctionnement initial d'un
        système, d'un matériel, etc. On peut d'ailleurs retrouver cela ailleurs que
        dans l'informatique. Il peut y avoir des hacker en agriculture ou autres.

        Des personnes qui vont détourner le fonctionnement initial de quelque chose
        pour lui faire produire un comportement qui n'était pas prévu à la base.

        Dans le pdf, on cite l'exemple d'une voiture qui est la base est faite pour
        rouler sur quatre roues. Si on parvient à modifier le comportement, le
        fonctionnement de notre voiture pour qu'elle puisse voler (soyons fou), on
        aurait ainsi hacker notre voiture.

        Le fait qu'une voiture vole, c'est un hack d'une voiture qui initialement serait
        sur 4 roues et se déplacerait sur le sol. C'est un hack.

        On peut retrouver le hacking dans plein de choses, en agriculture, en permaculture,
        en informatique, en cuisine, en travaux manuels, un peu dans tous les domaines.

        C'est un termes qui est très général. Dans notre cas, on va s'intéresser aux hacker,
        aux hacks dans du domaine informatique.

        Groso modo voilà ce qui nous attend. Le but de cette formation est de nous expliquer
        tous les rudiments, en ce qui concerne les systèmes, les infrastructures, les 
        matériaux et l'électronique, le web, etc.

        On va donc se familiariser avec toutes ces notions et un gros baggages de connaissances
        théoriques à avoir qui sera vu et aborder tout au long de cette formation. Il y aura
        beaucoup de mise en pratique aussi. De pouvoir exploiter tout ça, de faire de la 
        recherche, comment s'en prémunir, comment sensibiliser aux menaces, danges que l'on peut
        retrouver sur internet. Tout les dangers que l'on peut retrouver sur des logiciels quand
        ils ne sont pas sécurisés. On parlera de failles, de trous de sécurité, de failles zero-day.

        Voilà en gros comment présenter cette formation.

        Dans le sommaire, on voit :

            Qu'est-ce que le hacking ?
            La définition d'un hacker ?
            Quels sont les acteurs que l'on retrouve en hacking ? parce que il y a peut être
                beaucoup de termes que l'on a déjà entendu. On parle de hacker, de cracker, de
                pirates, de black-hat, de white-hat, etc. Il y a plusieurs termes qu'on utilise
                parfois à tord, de manière abusive, sans les comprendre.

        En ce qui concerne le terme hacker. Il a été changer par les médias, la société, l'actualité
        présente mais à la base le terme hacker est neutre, il n'est ni bon ni mauvais, ni légal ou
        illégal, ça dépend. Il y a des hacker qui font du légal et d'autres de l'illégal.

        Maintenant, on préfère différencier les mots où le hacker, on préferera plutôt désigner 
        quelqu'un qui fait des choses légales et utiles. Et le pirate informatique c'est 
        quelqu'un qui fera des choses plutôt illégales, qui vendera des failles sur le marché
        noir, du traffic d'organes, contourner des systèmes sans autorisations, etc. Là il
        commait véritablement des crimes, on est dans le délit.

        Il n'y avait qu'un seul terme à la base pour définir le hacker ni bon, ni mauvais, ni
        dans l'illégal, ni dans le légal. Il n'y avait pas vraiment d'étiquette pour les définir
        comme des bons ou des mauvais. C'était un terme neutre.
    */

   /**
    * Hacking, ce que dit la Loi française ?
    ****************************************/
   /*
        Détails des lois française qu'il faut respecter.
        On va voir du hacking légal et utile.
        Les méthodes employées autour du hacking sont toutes les choses que peut faire un hacker.
        Ce sont aussi bien des choses légales et des choses illégales.
        C'est bien de le savoir pour savoir ce qui est autorisé et ce qui ne l'es pas..
        Dans cette partie, un rappel sur les différentes concernant l'intrusion dans un système,
        l'utilisation frauduleuse sur la naiveté des gens (le social ingénioring).

        Comme je ne vie pas en France, il faut me renseigner sur les lois de notre pays.
        Les lois sont différentes d'un pays à l'autre. Ce qui est légal ici, ne l'est pas forcément
        en France. Aborder un concept légal en France ne l'est pas forcément dans un autre pays.

        Réponses aux questions les plus courantes.
        ------------------------------------------
        Une petite FAQ, le hacker est-il un pirate ?
        Est-il légal de faire du hacking ? Beaucoup diront que le hacker est forcément illégal
        alors que c'est faux.
        Devenir hacker est-il difficile ?
        Faut t-il connaître l'anglais pour progresser ? ...

        Bref quelques petites questions assez réccurentes.
   */

   /**
    * Hacking, ce que nous allons apprendre ?
    *****************************************/
   /*
        Nous allons voir les prérequis. 
        Ce qu'il faut savoir pour attaquer cette formation.
        Nous allons voir des choses très complexes, très compliqués.
        Il y a des choses même si on essaye de les expliquer au mieux, de les simplifier plus.
        Il faudra rester sur un certain niveau de complexité et rester dans le domaine du hacking,
        ou le domaine de la sécurité informatique. Il faudra un certains nombre de prérequis.

        C'est également interessant, voir indispensable, de connaître des langages comme le C ou
        le Python, tout ce qui va à la programmation, y compris les langages du web. On aura 
        l'occasion de les aborder au cours de la formation.

        Nous verons d'autres notions assez théorique ou matériel. Comment fonctionne un réseaux ?
        Qu'est-ce qu'un réseaux ? Qu'est-ce qu'une IP ? Qu'est-ce que les différentes couches du
        modèle OSI ? Ca ce ne sont pas forcément des prérequis parce que on va les revoir ?

        On ne revera pas entièrement les langages de programmation sur cette chaine. Il y a une 
        formation pour le langage Python, pour le langage C, pour HTML/CSS, PHP et SQL.

        Dans cette formation, on abordera du C et du Python. Il faudra donc se former dessus
        préalablement avant de continuer à progresser sur cette formation.

        La séance 1, c'est l'introduction. Ensuite jusqu'à la séance 6, on va faire des rappels,
        on va surtout faire des introductions. Il n'y aura pas de pratique, il n'y aura que de
        la théorie. Il va y avoir des rappel en programmation. Comment se passe la compilation
        d'un programme ? Comment on fait du déboggage ? Comment fonctionne la mémoire ou les
        système de codage ? Ce sont des grosses bases qui sont necessaire à savoir.

        Dans les premières vidéos, nous allons acquérir toutes ces bases là qui vont nous servir 
        tout au long de la formation, des premières vidéos jusqu'à la séance 7, on va avoir que 
        du théorique mais très utile parce que ca va nous suivre tout au long de la formation.

        On parlera de programmation, de Réseaux et télécomunnications. On parlera de réseaux IT
        et de communications, les matériels, les réseaux, les infrastructures que l'on peut retrouver.

        On parlera des systèmes d'exploitation et notamment de tout ce qui est cryptologie.
        Donc on parlera de cryptographie, de chiffrement, de cryptanalyse, de stéganographie.
        Pas mal de méthodes très utile pour protéger des données ou l'anonymat ou ce genre de chose.
   */


   /**
    * Le petit mot de la fin
    *************************/
   /*
        Dans ce petit mot de la fin, nous sommes absolument responsable de ce que l'on ferra et
        de l'usage des notions que l'on aura abordé dans cette formation. 

        Nous allons recevoir des choses parfaitement légale et éthique mais rien ne dit que les
        intéressé de la formation n'iront pas faire des choses illégales derrière.

        Nous ne sommes pas ici pour faire des choses illégales.

        Il y a suffisament à faire de manière légale pour ne pas tomber dans le cercle vicieux de
        faire des choses illégales. 

        Bien lire le pdf, surtout au niveau des lois. Si on est pas en France, il faut se renseigner 
        sur les lois de notre pays. Selon les pays, on a pas les mêmes choses autorisées et interdites.

        C'est un peu le hacking de manière général en mai 2017. Certaines notions on peut être changé
        depuis. Il faut savoir que le hacking est un peu un phénomène de mode. L'informatique se développe
        de plus en plus. De plus en plus de gens veulent se lancer dans la sécurité informatique, ce 
        genre de choses. Comme dans beaucoup de phénomène de mode, on a tendance à vouloir tout trop
        vite et simplement alors que ce n'est pas quelques chose de simple en soi. 

        Il y a ainsi beaucoup de solutions qui naissent sur internet, beaucoup de chose qui se raconte.
        Il y a un phénomène dont on entend beaucoup parler pour les gens qui sont disposé à utiliser
        la distribution GNU/Linux et surtout KaliLinux est en fait juste une distribution Debian avec
        des logiciels préinstallés, préconfigurés pour faire de la sécurité, de l'analyse, etc.

        C'est donc comme si on avait prit une distribution debian sur lequel, on avait installé
        tout un tas de logiciels liés à la sécurité, au hacking. Comme ci on avait fait un cd installable,
        donc une image pour pouvoir installer ce système tout fait. 

        Ainsi beaucoup de gens s'imagine qu'utiliser Kali Linux, fait de ces gens des hackers alors
        que pour être hacker, il faut utiliser Kali Linux. C'est complètement faux.

        Kali Linux n'est pas forcement un mauvais OS, c'est utilisé pour la sécurité. Le truc c'est qu'il
        y a énormément de logiciels installés, préconfigurés et en tant que débutant, on peut penser avoir
        des notions suffisament avancé mais en fait on fait qu'utiliser des logiciels sans forcement 
        comprendre le fonctionnement. On utilisera qu'une infime partie des logiciels proposé par la 
        distribution et la plupart du temps, on suivra des tutos sans comprendre ce que l'on fait.

        On nous dira de cliquer sur des boutons, de lancer des commandes, etc. Ce qui peut donner l'impression
        d'être un hacker, du faire du hacking mais pas du tout, on arrive à simplement utiliser un logiciel
        sans plus. Il ne faut pas tomber dans ce raccourcis qui pour être un hacker, il suffit d'installer la
        distribution Kali Linux et c'est bon on est un hacker parce que on a suivi 2 ou 3 tutos.

        Dans cette formation, on n'utilisera pas Kali Linux. C'est générallement réservé à un public très avancé.
        C'est une distribution très complète et reservé à un public très comptétent, qui a l'habitude d'utiliser
        tout ces programmes et qui a un certain niveau. C'est surout pas utilisable dans le quotidient..
        C'est une distribution qu'on va transporter sous forme de live CD, sur une clé. Ce n'est pas fait pour
        être installé en dur sur un disque pour être utilisé tout les jours comme un autre système pour
        naviguer sur Internet, faire de la bureautique, regarder des vidéos, etc.

        Kali Linux est utilisé juste quand on a besoin de faire certaines choses en particulier.
        C'est fait pour être démarré, faire quelques tests et voilà, c'est terminé, point.

        Le problème c'est que beaucoup de personnes l'installe pour remplacer leur système et se disent
        ensuite des hackers alors que ce n'est pas ça du tout.

        Ce qui est important ensuite, c'est les compétences acquises et ce que nous savons réellement faire.
        Et le fait d'utiliser Kali Linux ne fait pas de nous un hacker. On peut très bien l'avoir installer 
        sur notre pc et rien comprendre de ce que l'on fait sur ce système.

        On verra au cours de cette formation qu'on peut réellement se passer de Kali Linux et avoir un réel 
        niveau pour tout ce qui concerne la partie théorique en sécurité, en informatique, sur les réseaux,
        sur les failles, les vulnérabilités, les logiciels systèmes, etc mais aussi la programmation.

        On va apprendre à créer nos propres outils, à trouver nos propres failles, à nous protéger, nous
        prémunir de ces différentes failles, faire des correctifs, etc. Mais surtout on le ferra nous même
        , on passera pas par des logiciels tout fait à chaque fois.

        On va apprendre à créer parce que un hacker ce n'est pas seulement quelqu'un qui utilise des programmes 
        déjà fait ou autre, c'est quelqu'un crée aussi lui-même. Un hacker pourrait par exemple ne créer qu'un
        programme juste pour faire un seul hack, ne va fonctionner que pour un hack spécifique. Par exemple,
        ça peut être un système en particulier et ça ne fonctionnera que sur ce système et pas un autre.
        Il peut ainsi créer un programme pour chaque système différent.

        Donc c'est beaucoup de travail, c'est beaucoup de compléxité aussi. On eput tomber très très vite 
        dans des choses très complexes. C'est là tout l'intéret de cette formation, de ce domaine.

        Le hacking en gros est un domaine sérieux qui demande une certaine maturité, qui demande beaucoup de
        patience et si on est pas pationner par l'informatique, la programmation, le codage, etc il faudra 
        alors laisser tomber clairement et simplement. C'est comme si quelqu'un voulait devenir ingénieur 
        et qu'il n'aime pas les maths. En hacking c'est exactement la même chose, si on aime pas l'informatique,
        si on aime pas programmer, qu'on aime pas ce qui est réseaux, etc et qu'on est incapable de passer 4 heures
        sur un programme, ce n'est probablement pas fait pour nous. 

        On a pas tous les même besoins, les mêmes envies, les mêmes loisirs, etc. On se rendera compte par nous même
        si ca nous plait ou non. Dans tout les cas, il ne faut pas tomber dans cette facilité, qu'il faut
        installer un kali Linux pour être hacker. Ou bien qu'il faut utiliser tel logiciel parce que c'est la mode et
        du coup, je deviens hacker. Ce n'est certainnement pas comme ça que ça fonctionne.

        On va apprendre des méthodologies, des techniques et se renseigner sur des failles passées qui ne sont plus
        fonctionnelles maintenant parce qu'elles ont été corrigés depuis.

        On va apprendre à programmer nos propres outils, à faire de l'analyse de nous même et à exploiter
        ce que l'on a analyser nous-même. C'est la définition recommandé d'un hacker. C'est dans ce sens,
        que nous allons apprendre.

        Dans les séance prochaine, on va faire beaucoup de théorie, on va faire des rappels de programmation,
        on va parler de compilation, de déboggage, des systèmes de codage et du fonctionnement de la mémoire.

        Une fois toutes ces théories vues et ils y en a beaucoup a assimilées, on pourra seulement attaquer la
        pratique avec de la théorie tout au long de la formation.

        Si on est débutant et qu'on se forme en C et en Python, en ayant fait ces premières séances, on va avoir
        un sacré paquet de connaissance en plus et on sera paré pour la suite des vidéos de cette formation.
   */