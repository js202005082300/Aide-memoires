# [Introspection](https://www.youtube.com/watch?v=JKrpRtHBZRk)

+ [help](#help)
+ [dir](#dir)
+ [__name__](#__name__)
+ [type](#type)
+ [id](#id)
+ [hasattr - getattr - callable - isinstance](#hasattr---getattr---callable---isinstance)
+ [__dict__](#__dict__)
+ [__doc__](#__doc__)

Il faut avoir vu sur le court tout ce qui concerne la programmation objet, la création de classe, les méthodes et notamment la séance des 8 sur les dictionnaires.

Le concept d'introspection est un concept assez vague, mais si on veut pouvoir donner une définition il s'agit en réalité d'examiner un objet sachant qu'en python tout est objet excepté les mots clés, les opérateurs et ce genre de chose, tous les petits détails comme ça mais sinon tout est objet. Par exemple quand vous créez une variable dans lequel vous mettez un nombre, vous créez en réalité un objet de classe int donc vraiment tout est objet au niveau des données qu'on manipule de cette manière.

Du coup il y a un concept qu'on appelle introspection qui va consister en l'analyse, on va analyser ces objets tout simplement pour savoir ce qu'ils représentent et comment ils fonctionnent d'accord qu'est ce qu'ils font tout simplement donc ça peut être leur méthode, leurs attributs, les fonctions et de savoir ce qu'il propose un petit peu comme service et ce qu'elles permettent de faire.

Dans cette vidéo et ça va changer un petit peu de ce que l'on fait en général, je ne vais pas forcément vous expliquer l'utilité de l'introspection parce que suivant votre niveau actuel dans ce langage on n'en aurait pas forcément l'utilité et je préfère que ça vienne de vous, de vos recherches naturellement ainsi vous suivez cette vidéo et par la suite, par curiosité, dans votre apprentissage, dans les tests que vous ferez avec ce langage, vous puissiez naturellement comprendre et trouver des raisons de ce phénomène que l'on appelle introspection qui consiste encore une fois à *analyser des objets*. Plutôt que de vous dire que ça sert à ci ou à ça, je préfère que vous suiviez cette vidéo et puis que vous trouviez vos raisons de l'utiliser par après.

Voilà par exemple une classe Item avec mon constructeur pour l'initialisation de mon objet donc une instance qui va prendre un nom, la catégorie de l'objet, une petite description et sa valeur mais bon voilà ici ce qui compte c'est d'avoir un code sur lequel on peut travailler ça pourrait être le prix d'achat ou la valeur peu importe. Ensuite on a une petite méthode toString() qui va tout simplement afficher toutes les infos de notre objet.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
it1.toString()
```

Dans la partie principale en créer une instance de cette Item donc on crée notre objet et on l'affiche tout simplement avec la fameuse méthode toString() avec la petite méthode personnalisé pour avoir quelque chose d'un peu plus propre.

Par défaut si je teste mon code on a ceci.

```powershell
> python main.py
-------------------------
[Epée en mousse - Arme]
> Magnifique épée au tranchant inexistant
Prix d'achat : 1 po
-------------------------
```

Voilà partir d'essai pas de problème on instancie notre objet et on affiche des informations.

## help

Maintenant je vais vous montrer quelques petites manières de faire de l'introspection en python et on ne verra pas tout parce que encore une fois c'est un domaine très vaste et on ne verra pas tout. L'intérêt c'est que vous ayez l'autonomie de chercher par vous-même.

Si vous avez déjà fait de l'introspection, c'est l'usage de la fonction help(). Voilà c'est tout simplement une fonction qui permet d'avoir des informations sur une donnée.

Par exemple,
```py
#coding:utf-8

age = 14
help(age)
```
```powershell
> python main.py
Help on int object:

class int(object)
 |  int([x]) -> integer
 |  int(x, base=10) -> integer
 |
 |  Convert a number or string to an integer, or return 0 if no arguments
-- Suite  --
```

Voilà il nous retourne la page d'aide d'un *int object* donc d'un objet entier donc voyez que même si on a mis la variable âge, on a en réalité créé une instance de la classe *int*, `class int(object)`.

Alors tout ça c'est de l'introspection c'est-à-dire qu'on se renseigne en fait sur l'objet, qu'est ce qu'il est ? et bien ici on voit que c'est un entier qui a été instancié et comme on peut le voir ici à l'écran on n'a du coup pas mal de méthodes spéciales tel que `__getnewargs__(…)`.

alors concernant les méthodes spéciales il y a déjà un tutoriel qui est publié sur la chaîne donc dans la playlist des tutoriels en python, vous avez une vidéo sur toutes les méthodes spéciales donc on a beaucoup d'informations et du coup des informations qui peuvent être assez intéressantes donc ici comme on a créé un objet on va utiliser cette méthode help() dessus.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
it1.toString()

help(it1)
```
```powershell
> python main.py
-------------------------
[Epée en mousse - Arme]
> Magnifique épée au tranchant inexistant
Prix d'achat : 1 po
-------------------------
Help on Item in module __main__ object:

class Item(builtins.object)
 |  Item(name, category, description, costValue=1)
 |
 |  Classe d�finissait un objet utilisable en jeu
 |
 |  Methods defined here:
 |
 |  __init__(self, name, category, description, costValue=1)
 |      Initialize self.  See help(type(self)) for accurate signature.
 |
-- Suite  --
```

Voilà ici il nous met des informations c'est-à-dire qu'il ne va pas gérer les accents ici déjà dans un premier temps, il me met par contre la classe que j'ai créé ainsi que la DocString donc la petite information que j'ai mis en commentaire ensuite le constructeur et si on va plus loin la méthode toString() donc voyez qu'il y a pas mal d'informations.

Alors ça c'est là-bas c'est à dire que help() est une fonction qui va prendre un objet en paramètre et qui va vous donner toutes ces informations d'accord c'est un peu l'être qui va concerner un objet, une fonction.

On peut même demander à cette fonction d'afficher la liste des modules que l'on a sur notre pc avec cette commande `help("modules")`.

```py
#coding:utf-8

help("modules")
```
```powershell
> python main.py

Please wait a moment while I gather a list of all available modules...

pygame 2.0.1 (SDL 2.0.14, Python 3.9.6)
Hello from the pygame community. https://www.pygame.org/contribute.html
OnClick             _winapi             greenlet            reprlib
PIL                 _xxsubinterpreters  gzip                requests
PyInstaller         _zoneinfo           hashlib             requests_toolbelt
__future__          abc                 heapq               rfc3986
_abc                aifc                hmac                rlcompleter      
_aix_support        altgraph            html                runpy
_ast                antigravity         http                sched
_asyncio            argparse            idlelib             secrets
_bisect             array               idna                select
_blake2             ast                 imaplib             selectors        
_bootlocale         asynchat            imghdr              setuptools       
_bootsubprocess     asyncio             imp                 shelve
_bz2                asyncore            importlib           shlex
_cffi_backend       atexit              importlib_metadata  shutil
_codecs             audioop             inspect             signal
_codecs_cn          auto_py_to_exe      io                  site
_codecs_hk          backports           ipaddress           six
_codecs_iso2022     base64              itertools           smtpd
_codecs_jp          bdb                 json                smtplib
_codecs_kr          binascii            keyring             sndhdr       
_codecs_tw          binhex              keyword             socket       
_collections        bisect              lib2to3             socketserver 
_collections_abc    bleach              libfuturize         sqlite3      
_compat_pickle      bottle              libpasteurize       sre_compile  
_compression        bottle_websocket    linecache           sre_constants
_contextvars        build               locale              sre_parse    
_csv                builtins            logging             ssl
_ctypes             bz2                 lzma                stat
_ctypes_test        cProfile            mailbox             statistics
_datetime           calendar            mailcap             string
_decimal            certifi             main                stringprep
_distutils_hack     cffi                marshal             struct
_elementtree        cgi                 math                subprocess
_functools          cgitb               mimetypes           sunau
_hashlib            charset_normalizer  mmap                symbol
_heapq              chunk               modulefinder        symtable
_imp                click               msilib              sys
_io                 cmath               msvcrt              sysconfig
_json               cmd                 multiprocessing     tabnanny
_locale             code                mysql               tarfile
_lsprof             codecs              mysqlx              telnetlib
_lzma               codeop              netrc               tempfile
_markupbase         collections         nntplib             test
_md5                colorama            nt                  textwrap
_msi                colorsys            ntpath              this
_multibytecodec     compileall          nturl2path          threading
_multiprocessing    concurrent          numbers             time
_mysql_connector    configparser        opcode              timeit
_mysqlxpb           contextlib          operator            tkinter
_opcode             contextvars         optparse            token
_operator           copy                ordlookup           tokenize
_osx_support        copyreg             os                  toml
_overlapped         crypt               packaging           tomli
_peg_parser         csv                 parser              tqdm
_pickle             ctypes              past                trace
_py_abc             curses              pathlib             traceback
_pydecimal          dataclasses         pdb                 tracemalloc
_pyinstaller_hooks_contrib datetime            pefile              tty
_pyio               dbm                 pep517              turtle
_queue              decimal             peutils             turtledemo
_random             difflib             pickle              twine
_sha1               dis                 pickletools         types
_sha256             distlib             pip                 typing
_sha3               distutils           pipes               unicodedata
_sha512             doctest             pkg_resources       unittest
_signal             docutils            pkginfo             urllib
_sitebuiltins       eel                 pkgutil             urllib3
_socket             email               platform            uu
_sqlite3            encodings           platformdirs        uuid
_sre                ensurepip           plistlib            venv
_ssl                enum                poplib              virtualenv
_stat               errno               posixpath           warnings
_statistics         faulthandler        pprint              wave
_string             filecmp             profile             weakref
_strptime           fileinput           pstats              webbrowser
_struct             filelock            pty                 webencodings
_symtable           fnmatch             py_compile          whichcraft
_testbuffer         formatter           pyclbr              win32ctypes
_testcapi           fractions           pycparser           winreg
_testconsole        ftplib              pydoc               winsound
_testimportmultiple functools           pydoc_data          wsgiref
_testinternalcapi   future              pyexpat             xdrlib
_testmultiphase     gc                  pygame              xml
_thread             genericpath         pygments            xmlrpc
_threading_local    getopt              pynput              xxsubtype
_tkinter            getpass             pyparsing           zipapp
_tracemalloc        gettext             queue               zipfile
_uuid               gevent              quopri              zipimport
_warnings           geventwebsocket     random              zipp
_weakref            glob                re                  zlib
_weakrefset         graphlib            readme_renderer     zoneinfo

Enter any module name to get more help.  Or, type "modules spam" to search
for modules whose name or summary contain the string "spam".
```

Voilà pour la liste des modules qui sont installés sur mon PC et on peut voir que python est assez fourni par défaut sachant que l'on a déjà installé en plus tel que pygame sinon il y a tous les modules de base donc c'est vraiment très pratique et c'est la base de l'introspection.

Ainsi la base de l'introspection c'est de savoir se renseigner sur une fonction, un objet, un module en particulier et par exemple si je veux des infos sur le module math je peux faire ceci `help("math")`.

```py
#coding:utf-8

help("math")
```
```powershell
> python main.py
Help on built-in module math:

NAME
    math

DESCRIPTION
    This module provides access to the mathematical functions
    defined by the C standard.

FUNCTIONS
    acos(x, /)
        Return the arc cosine (measured in radians) of x.

        The result is between 0 and pi.

    acosh(x, /)
        Return the inverse hyperbolic cosine of x.

    asin(x, /)
        Return the arc sine (measured in radians) of x.

        The result is between -pi/2 and pi/2.

    asinh(x, /)
        Return the inverse hyperbolic sine of x.

    atan(x, /)
        Return the arc tangent (measured in radians) of x.

        The result is between -pi/2 and pi/2.

    atan2(y, x, /)
-- Suite  --
```

Voilà là vous voyez que j'ai toutes les informations avec la liste des fonctions disponibles bref c'est un vrai Manuel.

Voilà c'est ta Manuel d'aide sur pas mal de choses pour se renseigner sur différentes données en python.

C'est la base c'est certainement des choses qu'on a déjà utilisé sans s'en rendre compte.

Maintenant nous allons aborder un autre point avec un modèle qu'on a probablement déjà abordé que le module `sys`.

`sys` est le module pour le système et on l'importe de cette manière.

```py
import sys
```

Ce module là c'est pareil il a pas mal de fonctions et de propriétés qui peuvent être utilisées dans notre programme pour faire des choses qui sont liées au système, on peut par exemple afficher la version de python et afficher les arguments qu'on utilise en ligne de commande si jamais on veut pouvoir exécuter notre fichier avec des arguments à la suite. Pour ceux qui ont vu le langage c, il y a un tutoriel qui explique les arguments disponibles pour la fonction main avec argc et argv donc c'est le même principe que l'on peut retrouver avec ce module `sys`. On peut également avoir le système d'exploitation sur lequel se retourner et quelques fonctions et méthodes pour pouvoir quitter le programme, voilà ce genre de chose.

C'est pareil si on a la curiosité on peut faire ce genre de commande `help("sys")`.

```py
#coding:utf-8

help("sys")
```
```powershell
> python main.py
Help on built-in module sys:

NAME
    sys

MODULE REFERENCE
    https://docs.python.org/3.9/library/sys

    The following documentation is automatically generated from the Python
    source files.  It may be incomplete, incorrect or include features that
    are considered implementation detail and may vary between Python
    implementations.  When in doubt, consult the module reference at the
    location listed above.

DESCRIPTION
    This module provides access to some objects used or maintained by the
    interpreter and to functions that interact strongly with the interpreter.

    Dynamic objects:

    argv -- command line arguments; argv[0] is the script pathname if known
    path -- module search path; path[0] is the script directory, else ''
    modules -- dictionary of loaded modules

    displayhook -- called to show results in an interactive session
    excepthook -- called to handle any uncaught exception other than SystemExit
      To customize printing in an interactive session or to install a custom
      top-level exception handler, assign other functions to replace these.

    stdin -- standard input file object; used by input()
    stdout -- standard output file object; used by print()
    stderr -- standard error object; used for error messages
-- Suite  --
```

Voilà on retrouve pas mal de petites informations par défaut on retrouve notamment `argv`, `path` et pas mal de choses, `stdin` et cetera.

```powershell
    #...
    platform -- platform identifier
    prefix -- prefix used to find the Python library
    thread_info -- a named tuple with information about the thread implementation.
    version -- the version of this interpreter as a string
    version_info -- version information as a named tuple
    dllhandle -- [Windows only] integer handle of the Python DLL
    winver -- [Windows only] version number of the Python DLL
    #...
```

Par exemple si je tape `version_info` ça va nous retourner un tuple de la version de python donc il y a pas mal de petites choses comme ça qui sont pas mal intéressantes et qui sont à voir et qui peuvent éventuellement nous servir.

Nous n'avons pas parlé dans le cours de l'intérêt qu'il y a à faire de l'introspection mais c'est au cours de notre pratique du python qu'on en aura l'utilité et qu'on verra à quoi ça peut servir d'analyser et d'examiner nos objets.

Voilà pour ce petit module `sys` qui est plutôt intéressant et donc ça vaut la peine de s'intéresser un peu, il pourrait même y avoir un tuto à l'avenir pour présenter ce module.

## dir

Maintenant on va voir la fonction qui s'appelle dir() d'où l'intérêt d'avoir créé notre classe ici (Item)  plutôt d'utiliser une classe native en python. cette fonction va prendre en paramètre un objet, elle va nous retourner un dictionnaire et c'est pour ça qu'on avait au début de la vidéo qu'il fallait avoir vu la vidéo sur le dictionnaire c'est à dire la séance 18. Attention ça renvoie un dictionnaire et non pas une liste, un dictionnaire n'est pas une liste.

On va le faire c'est à dire qu'on va mettre la fonction dir() dans un print() sinon il nous l'affichera pas.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
##it1.toString()

print(dir(it1))
```
```powershell
> python main.py
['__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', 'category', 'costValue', 'description', 'name', 'toString']
```

Voilà là on retrouve tout un tas de méthodes spéciales dont on a fait un tutoriel dans la présente playlist.

On retrouve bien sûr la méthode `category`, `costValue`, `description`, `name` et la fameuse méthode `toString` donc tout ce que j'ai noté en tant que attributs et méthodes personnelles donc personnalisé ici pour l'objet, la classe est définie dans ce dictionnaire et on a pas mal de choses qui sont mis de toute façon par défaut pour tous les objets que vous allez créer en python donc c'est pas vous qui décidez. Et parmi celles par défaut, il y en a qui vont nous servir ici pour faire de l'introspection donc c'est pour ça qu'on a regardé ce dictionnaire là.

Alors la méthode dir() peut fonctionner sur plein d'autres choses même si on ne crée pas notre objet `it1`, on peut sans problème faire un dir() d'une simple variable pour un entier.

```py
#coding:utf-8

age = 24
print(dir(age))
```
```powershell
> python main.py
['__abs__', '__add__', '__and__', '__bool__', '__ceil__', '__class__', '__delattr__', '__dir__', '__divmod__', '__doc__', '__eq__', '__float__', '__floor__', '__floordiv__', '__format__', '__ge__', '__getattribute__', '__getnewargs__', '__gt__', '__hash__', '__index__', '__init__', '__init_subclass__', '__int__', '__invert__', '__le__', '__lshift__', '__lt__', '__mod__', '__mul__', '__ne__', '__neg__', '__new__', '__or__', '__pos__', '__pow__', '__radd__', '__rand__', '__rdivmod__', '__reduce__', '__reduce_ex__', '__repr__', '__rfloordiv__', '__rlshift__', '__rmod__', '__rmul__', '__ror__', '__round__', '__rpow__', '__rrshift__', '__rshift__', '__rsub__', '__rtruediv__', '__rxor__', '__setattr__', '__sizeof__', '__str__', '__sub__', '__subclasshook__', '__truediv__', '__trunc__', '__xor__', 'as_integer_ratio', 'bit_length', 'conjugate', 'denominator', 'from_bytes', 'imag', 'numerator', 'real', 'to_bytes']
```

Ainsi voyez que pour une simple variable qui devient un entier, on a effectivement pas mal de méthodes spéciale, et des attributs et des méthodes donc on peut avoir pas mal de petites choses qui ont comme ça leur utilité donc on peut se renseigner sur un entier et on peut savoir du coup ce qu'il propose et ce qu'il va nous permettre de faire. C'est ce qu'on appelle de l'introspection.

Encore une fois l'introspection ça va nous permettre d'examiner un objet, de l'analyser, de le décortiquer pour voir un petit peu ce qu'il proposait ce qu'il contient, les services qu'il peut nous donner et qu'est ce qu'il est donc c'est à dire son identité parce que c'est quand même une chose qui est importante.

## __name__

Maintenant qu'on a parlé d'identité on va voir un attribut très spécifique pour identifier notre objet et on va faire un print() de cet attribut-là `__name__`.

Suivi et précédé de 2 underscores ainsi on a déjà peu remarqué qu'il y avait des attributs et des méthodes spéciales qui ont toujours un double underscore avant et après, c'est pour qu'on puisse comprendre que ça vient python c'est à dire que c'est une convention pour des choses qui sont réservées en python dans ce cas `__name__` est bien attribut ce n'est pas une méthode.

```py
#coding:utf-8

print(__name__)
```
```powershell
> python main.py
__main__
```

Alors voilà il nous affiche `__main__` parce que nous sommes dans la partie principale de notre fichier (code principal) un c'est tout ce qui est en dehors d'une fonction ou d'une classe se retrouve automatiquement dans la partie main tel qu'on aurait la fonction main() dans un langage comme le c ou le c++. Ainsi on a un attribut qui permet de définir l'endroit, le contexte ou on se trouve et en ce qui concerne le code principal son identité c'est main. Et vous voyez que son nom est particulier encore une fois parce qu'il y a des underscores.

C'est pour ça qu'on pouvait faire le test afin de vérifier si on se trouvait dans la partie main ou pas.

```py
if __name__ == "__main__":
    print("Je suis dans la partie principale")
```
```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
#it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
##it1.toString()

if __name__ == "__main__":
    print("Je suis dans la partie principale")
```
```powershell
> python main.py
Je suis dans la partie principale
```

Voilà ici on est donc bien dans la partie principale.

D'ailleurs si on fait ceci en affichant `__name__` dans une méthode, on va constater qu'on est toujours dans le même fichier donc le print() va retourner `__main__`.

```py
    def toString(self):
        #...
>       print(__name__)
```
```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")
        print(__name__)

# Code principal
#it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
##it1.toString()

if __name__ == "__main__":
    print("Je suis dans la partie principale")
```
```powershell
> python main.py
Je suis dans la partie principale
```

Alors si on avait d'autres fichiers, l'attribut `__name__` contiendrait autre chose que `__main__` et aurais un autre nom en fonction du fichier sur lequel vous partez.

Alors comme le fichier main.py est notre fichier de départ, l'attribut `__name__` possède la valeur `__main__` ce qui représente un moyen d'identifier le fichier principal de lancement de notre programme.

Alors ça ça fait partie de l'introspection aussi cet attribut `__name__` car il permet de savoir l'identité d'une information donc d'une donnée pour le coup d'un autre fichier.

Ce qui est vraiment intéressant à savoir par rapport à ça.

## type

Maintenant on a une autre fonction type() qui nous renvoie le type de données, et ici c'est pareil c'est de l'introspection toujours.

```py
#coding:utf-8

age = 24
print(type(age))
```
```powershell
> python main.py
<class 'int'>
```

Voilà ça permet de connaître le type d'un objet ce qui permet également de faire de l'analyse c'est à dire le fait d'examiner un objet en python, c'est de l'introspection tout simplement et c'est quelque chose qu'on a déjà utilisé beaucoup de fois dans notre code cette petite fonction type() sans savoir comme un épiler en fait de l'introspection.

## id

Alors il y a aussi cette notion d'identifiant unique comme chaque véhicule qui sort d'une usine avec son identifiant, ce véhicule pouvant avoir des spécificités et cetera.

```py
print(id(it1))
```
```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
it1.toString()

print(id(it1))
```
```powershell
> python main.py
-------------------------
[Epée en mousse - Arme]
> Magnifique épée au tranchant inexistant
Prix d'achat : 1 po
-------------------------
2075329400448
```

Voilà on a un numéro à rallonge qui est tout simplement en fait l'identifiant unique de notre objet un session crêpes plusieurs objets il n'y aura jamais 2 fois le même objet.

Voilà par exemple on va créer un 2e Objets et on verra qu'ils ont pas les mêmes identifiants.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
it2 = Item("Arc en bois de hêtre", "Arme", "Magnifique arc des grands Archers")
#it1.toString()

print(id(it1))
print(id(it2))
```
```powershell
> python main.py
1736519469040
1736519469376
```

Voilà on a du coup 2 identifiants qui sont bien évidemment différents parce que même si ces objets sont conçus sur le même modèle, et que même si je les avais appelé à l'identique sans rien pour pouvoir les identifier parce que tout ce qui définit mes objets ce sont ces 4 attributs (name, category, description et costValue) et là pour le coup ils sont exactement pareil, 2 objets identiques et malgré ça on aurait quand même un identifiant différent.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
it2 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
#it1.toString()

print(id(it1))
print(id(it2))
```
```powershell
> python main.py
2152911620080
2152911620416
```

Voilà ça c'est de l'introspection encore une fois parce que ça permet de bien analyser un objet en particulier et de voir que chacun est unique encore une fois.

Chaque objet en python est unique et possède un identifiant unique que l'on peut identifier avec cette fonction id().

## hasattr - getattr - callable - isinstance

```py
# hasattr() | getattr() | callable() | isinstance()
```

hasattr() (pour has attribut) qui va dire simplement s'il y a un attribut en fonction d'un objet en particulier, getattr(), callable(), isinstance(). On peut même avoir issubclass() pour voir les classes filles, celles qui héritent ce genre de chose qui permettent d'analyser un objet.

Par exemple je peux faire ceci.

```py
print(isinstance(it1, Item))
```
```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
it2 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
#it1.toString()

# hasattr() | getattr() | callable() | isinstance()

print(isinstance(it1, Item))
```
```powershell
> python main.py
True
```

Si on veux la signature, on fait ceci.

```py
#coding:utf-8

help(isinstance)
```
```powershell
> python main.py
Help on built-in function isinstance in module builtins:

isinstance(obj, class_or_tuple, /)
    Return whether an object is an instance of a class or of a subclass thereof.

    A tuple, as in ``isinstance(x, (A, B, ...))``, may be given as the target to
    check against. This is equivalent to ``isinstance(x, A) or isinstance(x, B)
    or ...`` etc.
```

Voilà cette fonction isinstance() prends d'abord l'objet et la classe en question, en réalité le prend un tuple de type avant de nous retourner aboulin c'est à dire qu'ici il nous retourne True pour dire que it1 est bien une instance de la classe Item.

Voilà ici un truc tout bête avec la fonction help() on a le Manuel, et on peut retrouver l'ordre comme ça des éléments.

Voilà du coup encore comme ça pas mal de fonctions.

## __dict__

Maintenant on va terminer sur des attributs tels qu'on a vu tout à l'heure avec l'attribut `__name__` et notamment la tribu `__dict__` notamment quand on avait fait la vérification tout à l'heure sur un élément, on avait vu cet attribut un peu spécial qui se nomme dict pour dictionary, et vous allez voir en quoi il consiste.

Voilà on va tester ça et comme c'est un attribut spécial, on va le mettre sur un objet obligatoirement `it1.__dict__`. C'est un attribut spécial que tous les objets possèdent donc pas besoin de l'ajouter nous-mêmes car python le fait tout seul.

Par exemple,

```py
print(it1.__dict__)
```
```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")
#it1.toString()

# hasattr() | getattr() | callable() | isinstance()

print(it1.__dict__)
```
```powershell
> python main.py
{'name': 'Epée en mousse', 'category': 'Arme', 'description': 'Magnifique épée au tranchant inexistant', 'costValue': 1}
```

Voyez qu'il nous retourne directement à dictionnaire avec tous les attributs que l'on a avec leur valeur.

Ensuite cet attribut spécial peut servir à manipuler toutes les informations que nous avons ici et pourquoi est-ce que ça fonctionnerait? Parce qu'il permet tout simplement d'accéder à tous ses attributs.

En temps normal on ferait comme ceci pour afficher un attribut `print(it1.name)` et en temps normal pour faire une modification on ferait ceci `it1.name = "Arc"` où on dirait que l'épée devient un arc.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")

print(it1.name)
it1.name = "Arc"
print(it1.name)
```
```powershell
> python main.py
Epée en mousse
Arc
```

L'attribut name devient un arc, à l'origine c'était une épée en mousse et donc ça devient un arc juste avec une modification. Ici il n'est pas sujet de parler des filtres et des accesseurs pour la modification des attributs, on l'a déjà vu dans le cours donc ici c'est la méthode la plus rapide pour pouvoir modifier un attribut de classe, pour un objet c'est à dire une instance en particulier.

En réalité quand on fait ce genre de manipulation, python va se charger de le faire d'une autre manière et il va utiliser l'attribut spécial `__dict__` et comme c'est un dictionnaire on y accède comme ceci `it1.__dict__["name"] = "Arc"` avec la clé name et du coup on l'appelle Arc.

si je teste on obtient exactement le même code.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")

print(it1.name)
it1.__dict__["name"] = "Arc"
print(it1.name)
```
```powershell
> python main.py
Epée en mousse
Arc
```

Pour obtenir une information, on peut faire simplement ceci `print(it1.__dict__["description"])`.

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")

print(it1.description)
print(it1.__dict__["description"])
```
```powershell
> python main.py
Magnifique épée au tranchant inexistant
Magnifique épée au tranchant inexistant
```

Voilà ça encore une fois c'est de l'introspection.

Petite parenthèse si vous voulez accéder à des attributs d'une instance, ou même les modifier, n'utilisez pas cette syntaxe `it1.__dict__["description"]` même si je vous le montre que ça fonctionne par contre ce n'est pas conseillé, c'est pour ça qu'on a des syntaxes comme ceci `it1.description` qui es tu une manière de procéder pour accéder aux éléments et les modifier.

Utiliser l'attribut `__dict__` est une manière sous-jacente de python et c'est python qui procède de cette manière mais c'est bien de le savoir comme ça on voit qu'avec l'introspection effectivement on peut travailler directement sur des attributs spécifiques que ce soit en lecture ou en écriture pour de la modification.

C'est bien de connaître cet attribut spécial `__dict__` parce qu'on va certainement le croiser de nombreuses fois dans beaucoup de codes.

Par contre dans le développement et l'utilisation d'accesseurs, on ne doit pas procéder de cette manière c'est à dire le nom de l'objet, un point puis le nom de l'attribut égale sa nouvelle valeur et pourquoi pas filtrer tout ça avec des propriétés et des décorateurs pour faire les choses encore plus proprement.

## __doc__

```py
#coding:utf-8

class Item:
    """
    Classe définissant un objet utilisable en jeu
    """
    def __init__(self, name, category, description, costValue=1):
        self.name = name
        self.category = category
        self.description = description
        self.costValue = costValue
    
    def toString(self):
        print("-------------------------")
        print("[{} - {}]\n> {}\nPrix d'achat : {} po".format(self.name, self.category, self.description, self.costValue))
        print("-------------------------")

# Code principal
it1 = Item("Epée en mousse", "Arme", "Magnifique épée au tranchant inexistant")

print(it1.__doc__)
```
```powershell
> python main.py

    Classe définissant un objet utilisable en jeu

```

Voilà c'est plutôt sympa parce que quand vous avez une description pour une classe une méthode ou n'importe quoi, on va pouvoir récupérer comme ça des informations.

Donc doc pour documentation, c'est la DocString pour être plus exact donc c'est tout ce qui s'écrit comme ça entre eux 3 double quote `""" … """` qui permettent de mettre comme ça une description donc un élément en particulier et moi c'est ici la classe que je présente mais j'aurais pu très bien la mettre pour la méthode `__init__()`, pour la méthode `toString()`, bref on peut s'en servir comme ça pour mettre pas mal d'informations.

Donc très pratique comme attribut spécial, on peut d'ailleurs le mettre pour tous les objets, par exemple.

```py
#coding:utf-8

age = 24
print(age.__doc__)
```
```powershell
> python main.py
int([x]) -> integer
int(x, base=10) -> integer

Convert a number or string to an integer, or return 0 if no arguments
are given.  If x is a number, return x.__int__().  For floating point
numbers, this truncates towards zero.

If x is not a number or if base is given, then x must be a string,
bytes, or bytearray instance representing an integer literal in the
given base.  The literal can be preceded by '+' or '-' and be surrounded
by whitespace.  The base defaults to 10.  Valid bases are 0 and 2-36.
Base 0 means to interpret the base from the string as an integer literal.
>>> int('0b100', base=0)
4
```

Vous voyez qu'il y a également une description, une DocString, pour le type natif int, integer qui est défini directement par python et on peut même y lire certaines informations pour faire un cast notamment avec des petits exemples d'utilisation donc c'est assez fourni et c'est évidemment en anglais comme beaucoup de langages de programmation si ce n'est pas tous sauf quelques exceptions.

Nous on peut se servir de cet attribut spécial `__doc__` pour récupérer la DocString d'une information ou autre, une méthode et cetera donc ça peut servir.

Voilà libre à nous plus tard de revenir et de faire de l'introspection, peut être également lire des articles, des études et des recherches parce qu'il y a pas mal de travaux qui ont été faits là-dessus parce que encore une fois c'est un domaine de la programmation à part entière que ce soit en Python, en CSharp, en Java, en C++. Voilà ça existe vraiment partout et il y a beaucoup de choses intéressantes donc libre à vous de vous renseigner là-dessus et d'expérimenter et de voir un petit peu l'utilité que ça peut avoir et quelle utilité ça peut avoir. C'est voir le concept qui se cache derrière tout ça c'est à dire faire de l'introspection.

L'introspection encore une fois pour terminer cette vidéo c'est un concept qui permet de décortiquer un objet, de l'examiner, de l'identifier, de savoir ce qu'il propose est de savoir ce qu'il peut faire tout un tas de choses qui sont réunies dans un ensemble d'attributs, de méthode, et cetera que l'on peut utiliser dans ce langage qui est le langage python.

Ciao