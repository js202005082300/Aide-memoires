# [19. Classes abstraites](https://www.youtube.com/watch?v=dd0_nYhtaKQ)
	
	Bienvenue sur cette formation en langage Java pour la s�ance 19. 
on va continuer un petit peu sur les notions qu'on avait vu pr�c�demment et l� sur la vid�o, je vous l'avais dit, vous allez avoir pas mal de s�ance sur des notions tr�s li�s mais que j'ai �videmment s�par� les notions par vid�o pour que ce soit plus facile pour vous mais vous allez quand m�me retrouver pas mal de choses qui sont en lien chacune avec les autres qui vont vous permettre comme �a d'avancer un petit peu. 
Pour cette vid�o, nous avons parl� des classes abstraites alors vous savez ce qu'est une classe, vous savez comment construire une classe en Java, comment utiliser des attributs, faire des m�thodes et cetera. 
On a m�me abord� l'h�ritage, notion tr�s tr�s importante de la programmation Et � partir de tout �a on va pouvoir int�grer une autre notion un peu particuli�re mais qui a besoin d'�tre connu et qui concerne des classes abstraites.
*/

//import jachampagne.*�;
//public class App
//{
//	public static void main(String[] args)
//	{
//
//	}
//}

/*
Alors une classe abstraite� Alors on a une classe g�n�rale particuli�re comme on sait le faire habituellement qui est une classe bien pr�cise, une classe concr�te qui repr�sente qui repr�sente en fait quelque chose: une entit�, un concept, une id�e ou n'importe quoi et on sait exactement ce que l'on veut repr�senter. 	
Si on prend un exemple tel qu'on a pu l'aborder dans d'autres vid�os, si on cherchait par exemple une classe pour repr�senter un certain type d'animal comme un chien, on ferait une classe pour le chien Il en aurait comme �a ses diff�rents �tats et son comportement donc ces attributs, ces m�thodes, pas de probl�me par rapport � �a.
Maintenant si au cours de mon projet, un programme que je veux r�aliser, j'ai un peu une certaine id�e g�n�rale de ce que je veux faire intervenir dans le programme et la du coup on va cr�er un exemple pour pouvoir en fait cr�er des esp�ces, des �tres vivants, on peut prendre cet exemple. 


On est d'accord qu'un �tre vivant est une notion tr�s abstraite, qui est tr�s vague. Un �tre vivant finalement �a englobe �norm�ment de choses donc si je disais que l� dans un programme, j'ai besoin de pouvoir cr�er des �tres vivants. C'est tr�s voire m�me trop g�n�ral pour pouvoir faire quelque chose pourtant je veux quand m�me au niveau du code, je veux repr�senter un �tre vivant de mani�re abstraite mais je veux quand m�me en avoir une repr�sentation. 

Pour �a on va cr�er une classe abstraite, la classe abstraite c'est tr�s simple, on va cr�er un fichier de toute fa�on comme on le fait habituellement, on va l'appeler du coup avec le nom de mon esp�ce vivante donc on va l'appeler LivingSpecies. 

LivingSpecies.java

package jachampagne;

On �crit package en changeant le nom mais �a ne change pas grand-chose, c'est pour r�viser l'usage de package en Java. 
Et l� avec une classe qu'on aurait concr�te au d�part, on ferait : 

package jachampagne;

public class LivingSpecies
{

}

Et ensuite � l'int�rieur de public class Livingspecies{}, on aurait notre constructeur, �ventuellement des attributs priv� ou prot�g� si on veut faire de l'h�ritage, des m�thodes et cetera et cetera. 

Le probl�me et on l'avait dit, c'est que pour moi c'est quelque chose de tr�s vague c'est � dire que je n'ai pas envie concr�tement de dire ce que c'est qu'une esp�ce vivante parce que on a dit tout � l'heure c'est quelque chose de tr�s g�n�ral et quelque chose qui englobe tout un tas d'�tre vivant potentiel. Donc je veux que �a reste abstrait et pour �a nous avons le mot-cl� abstract qui va permettre de transformer cette classe de mani�re abstraite : 

package jachampagne;

abstract public class LivingSpecies
{

}

une classe abstraite, alors ce n'est pas forc�ment, il va y avoir des exceptions et c'est vrai que j'avais � quelques exceptions l� dessus, c'est g�n�ralement une classe qui a au moins une de ces m�thodes qui est aussi abstraite. Il y a certains langages qui obligent � rendre votre classe abstraite et vous verrez que dans certains langages vous pourrez compiler m�me si au final vous n'avez aucune m�thode abstraite et que votre classe l'est. Donc faut faire attention des fois, il peut y avoir des petites particularit�s propre langage mais dans l'id�e, dans le principe m�me, une classe est abstraite d�s lors, doit �tre en tout cas indiqu�, pour le d�veloppeur en tout cas c'est un indicateur tr�s important � Abstraite � partir du moment o� l'une de ces m�thodes au minimum est abstraite aussi. 

Alors pourquoi cette importance de savoir �a, tout simplement que cette classe abstraite, on va jamais pouvoir l'instancier, on va jamais en fait pouvoir cr�er des objets d'esp�ces vivantes parce que encore une fois, nous dans l'id�e, on veut avoir quelque chose qui repr�sente �a mais on ne veut pas commencer � cr�er des esp�ces vivante parce que c'est beaucoup trop vague, comment peut-on d�terminer le comportement d'une esp�ce vivante ? Encore une fois c'est trop vague on ne peut pas se repr�senter �a.

Donc en termes de code, on va mettre protected String et le nom mName :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;
}

On va dire qu'on veut quand m�me repr�senter, dans l'id�e que l'on veut se repr�senter nous de l'esp�ce vivante, elle aura un nom. Donc �a il n'y aura pas de probl�me l� dessus, elle aura un nom. 

On va impl�menter une m�thode, on va l'impl�menter comme si on avait une classe normale, une classe concr�te, Une m�thode qui permettra de savoir qui, qui suis-je, qui est cette esp�ce vivante donc on va faire simplement :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{

    }
}


en fait ce sera un genre d'accesseur, une sorte d'accesseur, un getteur sauf qu'on va pas l'appeler get quelque chose mais on va dire simplement public String whoAmI() Et du coup je vais simplement lui dire de faire un return mName :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
    }
}

On fait un return mName pour dire qu'une esp�ce quelconque, on verra plus tard, voudra savoir qui est-elle Eh bien on retournera son nom. C'est le moyen de s'identifier, on consid�re cela comme �a. 

Est � c�t�, ben pour moi une esp�ce vivante �a peut faire pas mal d'autre chose. �a peut par exemple � voil� ici au d�but on va mettre void parce qu'on ne sait pas ce que �a a besoin comme information En termes de code donc pour moi �a ne retourne rien (void), �a ne prendra aucun param�tre et �a va avoir un nom, par exemple manger (eat) : 

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
       }
       public void eat()
}


       une esp�ce vivante dans la repr�sentation que l'on se fait, peux manger mais �a ce n'est pas suffisant parce que si on fait juste public void eat(), on est oblig� d'impl�menter, on est oblig� d'impl�menter notre m�thode :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
       }
       public void eat()
       {
       
       }
}

On est oblig� d'impl�menter mais comme on avait dit une classe est abstraite � partir du moment ou une au minimum de ces m�thodes est abstraite aussi donc on va r�utiliser ce mot-cl� pour une m�thode et alors cette m�thode ici n'a pas besoin d'�tre impl�ment�e, on ne le fait pas et on la laisse tel quel. 

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
	}
	abstract public void eat();
}

Alors on pourrait mettre � la place de void, un type de retour, et des valeurs si on voulait en param�tres ..eat(�) Mais si vous n'�tes pas capable de vous dire tout de suite, concr�tement, ce qu'il y aurait et bien vous mettez rien en param�tre. Vous mettez void et rien entre parenth�ses.
Et on peut �ventuellement �crire d'autres choses, on va pas forc�ment en faire plein parce que par la suite vous allez voir �a va rajouter pas mal de travail. Mais en gros on peut dire speak(), parler :

package jachampagne;
abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
    }
    abstract public void eat();
    abstract public void speak();
}

On peut dire speak pour parler bien que ce soit un peu bizarre mais bon pourquoi pas. Et �a c'est ma classe abstraite, c'est ma repr�sentation tr�s vague tr�s abstraite, c'est le cas de le dire, d'une esp�ce vivante. Une esp�ce vivante qui peut manger. On le voit, on le voit tout de suite, elle peut manger (eat), elle peut parler (speak), elle peut s'identifier (whoAmI) d'une certaine mani�re et la seule information que la mani�re vague c'est un nom (mName). 

Donc �a c'est notre classe et bienvenue �videmment comme c'est abstrait, on ne peut pas, tr�s important, faire ceci (LivingSpecies ls = new LivingSpecies) :

App.java
--------
*/
//import jachampagne.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		LivingSpecies ls = new LivingSpecies();
//	}
//}
/*
Donc on ne peut pas faire "LivingSpecies ls = new LivingSpecies" et dire qu'on cr�e une instance de la classe LivingSpecies, D�j� parce qu'on n'a pas d�fini de constructeur et en plus elle est abstraite donc si vous essayez de cr�er une instance, de toute mani�re et on peut bien �videmment tester pour voir, on va vous dire que : 

	App.java:172: error: LivingSpecies is abstract; cannot be instantiated
                LivingSpecies ls = new LivingSpecies();
				
On va vous dire que LivingSpecies is abstract donc vous ne pouvez pas l'instancier tout simplement Donc �a c'est un moyen de voir qu'elle est abstraite et qu'on ne cr�� pas une instance d'une classe abstraite.

donc du coup vous vous dites peut �tre que si on a une classe qu'on ne peut pas instancier, � quoi nous sert elle ? Parce qu'on a fait une classe qui normalement, on a appris qu'une classe permettait d'avoir un mod�le de construction, de fabrication de quelque chose mais au final si on ne peut pas le construire sur quelque chose Ben elle sert un peu � rien cette classe. 

il ne faut pas voir cela comme quelque chose qui nous ferait gagner du temps On nous apport� des fonctionnalit�s l� au niveau de nos classes mais c'est surtout quand vous allez les utiliser c'est classe que vous allez gagner beaucoup de temps et apporter plein de fonctionnalit�s tr�s int�ressant en terme de code pour l'usage de classe, pas dans le code m�me des classes . Et �a c'est quelque chose qu'on verra dans une s�ance prochaine quand on parlera notamment du polymorphisme. Il faut �galement qu'on parle des interfaces, ces 2 notions. 

Pour la prochaine s�ance, on parlera, je peux vous le dire, des interfaces et la s�ance d'apr�s on abordera le polymorphisme qui est tr�s reli� justement tr�s li� aux classes abstraites, aux interfaces qui sont bien souvent 2 notions qui sont �norm�ment confondues par les d�veloppeurs qui sont en train d'apprendre donc on aura l'occasion de faire le tour de tout �a. 

Donc l� pour pas trop m�langer, pour ne pas en faire trop d'un coup, il faut comprendre que on ne peut pas faire :

	LivingSpecies ls = new LivingSpecies();

On ne peut pas faire �a, c'est une classe abstraite, on ne peut l'instancier. On ne se pose m�me pas la question. 

Maintenant de cette classe abstraite, il faut en avoir quelque chose de concret. C'est-�-dire que � partir de �a maintenant, vous allez pouvoir cr�er des classes concr�tes, des esp�ces vivantes concr�tes qui auront du coup des informations bien concr�tes, elles aussi. Donc �a c'est tr�s important. 

Premi�re chose qu'on va faire, donc je ne vais cr�er qu'une seule classe, je ne vais pas en faire plusieurs des classes concr�tes parce que on ne va pas faire un code qui prend 15 ans. Je vais tout simplement faire un tigre :

	Tiger.java

	package jachampagne;

On ins�re le m�me paquet, on fait un copier coller de LivingSpecies pour gagner un peu de temps. Ici on pourrait faire une classe abstraite qui h�rite d'une autre classe abstraite, on peut tout � fait faire �a, on peut cr�er une hi�rarchie de classes abstraites, il n'y a aucun probl�me mais ici on va vraiment nous, parce qu'on ne va pas faire trop trop de code, faire une classe concr�te directement, donc : 

package jachampagne;
	
public class Tiger extends LivingSpecies
{

}

On fait public class Tiger Qui �tend notre classe abstraite LivingSpecies, je rappelle que cet h�ritage est parfaitement normal, parfaitement logique parce qu'on peut dire qu'un tigre est une sorte d'esp�ces vivantes. On comprend tout de suite qu'il y a une relation d'h�ritage. J'ai fait ma classe abstraite pour �a sinon alors pour le coup servi � rien.

Et maintenant comment �a marche en termes d'objets concrets parce qu'ici on a une classe concr�te ? et Ben d�j� on va pouvoir la construire, on va pouvoir fabriquer des tigres, �a c'est important :

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
       
       }
}

Le tigre, comme il est ici, pr�cis, je ne vais pas lui donner un nom en particulier, je vais simplement dire que le nom de la classe abstraite, rappelez-vous qu'on a fait un attribut prot�g� dans LivingSpecies.java soit "protected String mName", donc on l'a h�rit� bah je vais dire c'est un tigre tout simplement.

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
    }
}

On dira juste que quand on cr�e un tigre, son nom c'est tigre, voil� on ne va pas cherch� plus loin pour le moment. 

Cette m�thode whoAmI (LivingSpecies.java), voyez que comme la class Tiger en h�rite, on va tester et va faire 

	Tiger ti = new Tiger();
	ti.whoAmI();
	
C'est logique parce qu'encore une fois, c'est juste de l'h�ritage comme on l'a vu pr�c�demment (Tiger extends LivingSpecies).
Pas de surprise sauf que l� il y a une petite nouveaut� avec l'abstraction Et l� vous allez voir que ce n'est pas suffisant. 

App.java
--------

*/
//import jachampagne.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		//LivingSpecies ls = new LivingSpecies();
//		Tiger ti = new Tiger();
//		ti.whoAmI();
//	}
//}
/*
LivingSpecies.java
------------------

package jachampagne;

abstract public class LivingSpecies
{
	protected String mName;

	public String whoAmI()
	{
		return mName;
    }
    abstract public void eat();
    abstract public void speak();
}

Tiger.java
----------

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}
}

Et l� vous allez voir que ce n'est pas suffisant, je vais vous la recompiler et l� il me dit que Tiger n'est pas abstrait, n'est pas une classe abstraite Et toi du coup pensez � override c'est-�-dire � �crire, � impl�menter pour le coup, les m�thodes de la classe abstraite.

	error: Tiger is not abstract and does not override abstract method 	speak() in LivingSpecies
	public class Tiger extends LivingSpecies
	       ^

�a veut dire en gros, il y a 2 m�thodes abstraite eat() et speak() dans ma classe abstraite , qui le sont aussi, qui sont non impl�ment� du coup par d�finition. 

Et autant pour une esp�ce vivante comme c'�tait une classe abstraite (LivingSpecies), on n'avait pas besoin De pr�ciser comment un �tre vivant mange et comment il parle parce que �a peut �tre diff�rent celon l'animal en question Ou les �tres vivants en question Parce qu'il n'y a pas que des animaux dans les �tres vivants par contre pour un tigre on va �tre oblig� de l'impl�menter Parce que le tigre il ne va pas manger et parler n'importe comment, communiquer n'importe comment. Nous aurions pu mettre communiquate et au lieu de speak mais peu importe.



� partir du moment o� vous avez des m�thodes ici abstraite dans votre classe abstraite�

    abstract public void eat();
    abstract public void speak();

� d�s que vous avez une classe concr�te concr�te qui en h�rite, vous devez obligatoirement, �a permet en plus de ne pas faire l'erreur parce que vous voyez sinon �a ne compile pas. Donc �a vous force, et �a �vite les oublis, �a vous force � impl�menter les fameuses m�thodes abstraites.

Donc je reprends le code "public void eat()" et je l'impl�mente dans la classe Tiger :

Tiger.java
----------

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void eat()
       {
       	
       }
}

�a peut �ventuellement retourner autre chose que void, Comme �a peut prendre pour le coup des param�tres puisqu'on va pour le coup l'impl�menter on peut changer un petit peu la signature par contre on garde le m�me nom de la m�thode.

On fait pareil avec speak(), on copie public void speak(). On ne fera pas de modification ici �

package jachampagne;

public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void eat()
       {
       	
       }
       
       public void speak()
       {
       
       }
}

Et donc l'impl�mentation est obligatoire. On est dans une classe concr�te, on doit impl�menter absolument toutes les m�thodes abstraites de la classe parente. Je n'ai pas besoin d'autres attributs donc je n'en rajoute pas. On pourrait mettre d'autres choses par exemple comme l'�ge d'un tigre ou n'importe quoi d'autre mais je ne m'emb�te pas.

Alors comment on l'avait dit, une classe abstraite peut h�riter d'une autre classe abstraite. En effet, j'aurais pu aller plus loin En disant je fais une classe concr�te par exemple pour un homme et c�t� je fais une autre classe abstraite qui est un animal. Et ensuite de animal je cr�e des esp�ces d'animaux concrets donc en gros on aurait LivingSpecies, classe abstraite, on aurait en h�ritage, une classe animal et ensuite au aurait plein de classes concr�tes de Animal comme chat, dauphin, lion Et cetera. Et l'homme serait une autre classe mais directement concr�te h�ritant de cette classe abstraite LivingSpecies. 

Voil� on peut faire ce genre de hi�rarchie.

Voil� pour �viter de faire trop de code et pour �viter que ce soit trop long pour la suite, on va se contenter de �a est-ce que le principe sera suffisamment explicite de cette mani�re.

Donc voil� on va impl�menter �a.
M�me si on n'a rien mis dans le code, il consid�re quand m�me que c'est impl�ment�. M�me si �a ne fait rien, de toute mani�re �a ne retourne rien. Pour lui c'est suffisant :

Tiger.java
----------
�
	public void eat()
       {
       	
       }
       
       public void speak()
       {
       
       }
�

L'information, il faut l'afficher avec System.out.println(ti.whoAmI()).

App.java
--------

*/
//import jachampagne.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		//LivingSpecies ls = new LivingSpecies();
//		Tiger ti = new Tiger();
//		//ti.whoAmI();
//		System.out.println(ti.whoAmI());
//	}
//}
/*
On va afficher directement le contenu. 
	javac App.java
	java App
Pas de probl�me au niveau de l'h�ritage, on r�cup�re bien le retour de la m�thode whoAmI() qui a �t� impl�ment�e dans la classe LivingSpecies et donc si je voulais la changer dans tigre, on a d�j� vu comme �a comment red�finir des m�thodes, on pourrait le faire si on veut changer la mani�re dont on s'identifient pour le tigre o� sp�cifiquement pour le tigre. 

Moi vu que je n'ai pas envie que �a change, c'est pour �a que je l'ai mis dans la classe LivingSpecies pour dire peu importe l'esp�ce vivante d�s qu'elle utilisera whoAmI(), elle retournera ce qu'elle doit retourner.
Sergent vous cr�ez une nouvelle classe dans votre programme m�me si c'est 5 mois 6 mois ou un an plus tard dans votre programme et que sp�cialement pour cette classe vous dites non, celle-l� je veux que whoAmI, elle fasse autre chose Eh bien vous pouvez red�finir cette m�thode. Aucun probl�me sp�cifique dans la classe que vous venez de cr�er.

Encore une fois n'oubliez pas, �a va chercher une m�thode dans la classe la plus proche donc l'actuel si elle n'existe pas on va remonter dans les classes parentes jusqu � en trouver une. Et s'il n'y en a vraiment pas du tout, alors l� il y aura il y aura un probl�me lorsque vous essayez d'appeler une m�thode qui n'existe pas mais �a c'est encore autre chose. 

Ensuite on va dire comment le tigre mange mais l� on ne va pas s'emb�ter on va juste mettre un petit texte encore une fois pour simuler �a. On va mettre par exemple � je mange de la viande � Et pour la m�thode speak, on va dire � je rougis � �. 

Tiger.java
----------
�
	public void eat()
       {
       	System.out.println("Je mange de la viande�");
       }
       
       public void speak()
       {
       	System.out.println("Je rugis�");
       }
�

Nb. C'est le lion qui r�git n'est pas le tigre mais je ne sais plus le terme exact en t�te mais ce n'est pas grave. 

Alors l� du coup on peut se repr�senter, parce que voil� un tigre mange d'une certaine mani�re il communique d'une certaine mani�re. Il a un nom bien sp�cifique, c'est quelque chose de concret encore une fois. Encore une fois ce qui est concret, on peut poser des noms des choses dessus. Encore une fois on �tait dans quelque chose d'abstrait, �a ne voulait pas dire grand-chose donc on avait quand m�me besoin d'une repr�sentation. 
Alors tout de suite vous allez peut-�tre vous dire que �a sert � rien qu'on aurait pu directement faire une classe Tiger et terminer mais quand on abordera la vid�o plus tard sur le polymorphisme parce que cette vid�o est une introduction pour ce qu'on abordera concernant le polymorphisme quand vous aurez �galement vu les interfaces. 

Donc c'est pour le moment vous ne voyez pas trop l'int�r�t de se servir de classe abstraite, c'est normal c'est parce que je ne veux pas avoir d�j� les interfaces de toute fa�on est le polymorphisme maintenant. On regardera �a dans la vid�o prochaine. 

C'est parfaitement normal c'est pour l'instant vous n'en voyez pas forc�ment les utilit�s, c'est logique je ne peux pas te voir tout de suite et je ne veux pas voir tout voir tout de suite avec vous.

Donc on a d�j� �a comme comportement :

Tiger.java
----------

package jachampagne;
	
public class Tiger extends LivingSpecies
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void eat()
    {
    	System.out.println("Je mange de la viande�");
    }
    
    public void speak()
    {
    	System.out.println("Je rugis�");
    }
}

Donc on a d�j� �a comme comportement d�j� premier avantage que vous pouvez voir, c'est encore une fois, on part en tant que d�veloppeur d'une repr�sentation. Et ce qui est pratique et qu'il faut penser qu'un jour, et l� il faut penser qu'on n'est pas forc�ment seul ou que votre code peut �tre r�utilis� parce qu'un principe de la programmation objet est la r�utilisation de code. C'est un des arguments important par rapport � ce type de paradigme Eh bien si un jour une personne veut r�utiliser votre code et qu'il veut cr�er une esp�ce vivante et bien ce qu'il va faire, c'est qu'il va cr�er sa petite classe genre par exemple Dog pour cr�er un chien L'automatique mens il essaie de rien mettre ou qu'il fait ses petits trucs � lui, il va vouloir compiler le code et �a lui mettra justement les messages pour dire " et l� il faut que tu nous expliques Comment communique ton chien t comment il mange ? ". Automatiquement il se dira, il saura qui doit impl�menter ces m�thodes l� :

    abstract public void eat();
    abstract public void speak();

Si on n'avait pas d'histoire d'abstractions d�j�, Eh bien il n'y aurait pas forc�ment d'erreur pour beaucoup de choses et �a ne poserait pas de probl�me. Il aurait des animaux, il aurait un chien Qui n'a pas de comportement pour manger communiquer et sauf que si un jour, on dit qu'on a toutes nos esp�ces vivantes et ici on va faire une l�g�re petite intro polymorphisme Et on dit toutes les esp�ces vivantes qu'on a, peu importe Ce qu'elles sont, on veut les faire parler tout de suite et le probl�me est que si le chien qui h�ritent pourtant des esp�ces vivantes. on n'a pas expliqu� comment il est ce qu'il communiquait Eh bien on va avoir tous les animaux qui vont pouvoir communiquer ou qu'ils vont pouvoir manger et le chien quant � lui ne pourra pas manger, ne pourra pas communiquer.

Vous voyez il va manquer quelque chose, il va manquer un comportement et c'est quand m�me assez dommage puisqu'� la base il �tait cens� pouvoir manger communiquer puisque c'est dans la classe abstraite.

Donc l� l'avantage d'une classe abstraite, pour le coup c'est � �a que �a sert, c'est que si on veut cr�er quelque chose de concret automatiquement � la compilation il y aura des erreurs si vous oubliez, si vous ne pensez pas impl�menter les m�thodes abstraites.

Cela force en fait le d�veloppeur ou l'utilisateur de votre code et vous-m�me, �a peut �tre vous-m�me aussi bien s�r en plus monter dans la classe concr�te ce qui �tait abstrait dans la classe parente voil�. il n'y a pas d'oubli comme �a de ce c�t� et �a va bien s�r avoir plein d'avantages concernant le polymorphisme comment on le verra pendant la prochaine s�ance mais celle d'apr�s.

Grosso modo pour les classes abstraites, je pense que je vous expliqu� pas mal de choses par rapport � �a. je regarde sur la note.

Donc les m�thodes abstraites, je vous en ai parl�. L'instanciation on en a parl�. Pour les interfaces on verra plus tard. Ce n'est pas le probl�me par rapport � �a. Donc du coup on a fait tours et c'est tant mieux.

Comme je ne peux pas encore vous donner trop d'�l�ments tout de suite par rapport � �a parce qu'on n'a pas encore parl� des interfaces, on n'a m�me pas encore abord� le polymorphisme, tout �a.

mais en gros c'est l'ultime dans le sens, on peut factoriser du code et �a c'est un �l�ment tr�s important c'est-�-dire que si vous demandez et ben dans quel cas, il faut utiliser une classe abstraite Eh bien dans le cas o� vous avez diff�rentes classes qui peuvent avoir des liens c'est-�-dire que si je cr�e un tigre, si je cr�e un chien, Si je cr�e un dauphin � On est d'accord que c'est des classes qui sont li�es entre elles, elles ont des choses communes c'est classe-la.

On peut dire qu'un dauphin il mange, un tigre il mange, un chien il mange et cetera. On trouve d�j� des comportements communs �ventuellement des propri�t�s des �tats communs aussi, il peut avoir un nom et cetera.

on peut imaginer qu'ils ont un nom, on peut imaginer qu'il y a un �ge, on peut imaginer qu'ils aient un plat pr�f�r�, r�gime alimentaire sp�cifique. Voil� on retrouve plein d'�l�ments communs, c'est pas comme si on avait une voiture et un tigre. L� c'est bizarre de se dire, on va faire une classe abstraite d'accord.

Et de cette classe abstraite, on va �tre dans 2 classes concr�tes en disant qu'on va cr�er des tigres � partir d'esp�ces vivantes et des voitures.

L� pour le coup on se rend compte qu'il n'y a pas vraiment de liens Et du coup �a ne va pas. Donc si vous trouvez qu'il y a des classes comme �a avec des liens, avec des choses communes et que vous pourriez du coup avoir de la r�p�tition de code. 

En gros je n'ai pas forc�ment envie, admettons, on va le faire avec la classe Lion :


Lion.java
----------

package jachampagne;
	
public class Lion extends LivingSpecies
{
	public Lion()
	{
		mName = "Lion";
	}

	public void eat()
    {
    	System.out.println("Je mange de la viande�");
    }
    
    public void speak()
    {
    	System.out.println("Je rugis�");
    }
}

Donc l� c'est un cas un peu particulier mais en gros, ce que l'on peut faire et l� il a fallu que je fasse une classe, par exemple notre classe abstraite. En gros il aurait fallu que je fasse une autre classe abstraite Feline ou un truc comme �a.

On va virer LivingSpecies.java, et le rempla�ait par Feline, qui est avec E justement � la fin. On aurait pu aussi le mettre en fran�ais mais bon Comme j'ai l'habitude d'�crire le code en anglais, le texte en fran�ais mais le code en anglais, on va garder �a comme �a et donc le nom est OK et on ne va pas garder le m�me comportement mais on va dire qu'on va virer la m�thode whoAmI()

LivingSpecies devient Feline.java
---------------------------------

package jachampagne;

abstract public class Feline
{
	protected String mName;

    	abstract public void eat();
    	abstract public void speak()
	{
       	System.out.println("Roaaarr !!");
       }
}

Et on va du coup impl�ment� la m�thode speak() et du coup il fait "Roaaarr !!", juste faire un bruit comme �a par rapport � l'animal. 

En gros on part du principe que tout nos F�lins un comportement commun, C'est-�-dire que pour communiquer Eh bien ils rougissent, ils crient, il pousse un grognement, un truc comme �a, peu importe et on le repr�sente comme �a via du texte "Roaaarr !!".

Il va donc y avoir des changements � faire par rapport au f�lin pour le coup, il va y avoir des petits changements.

Qu'est-ce qui pourrait �tre diff�rent pour le lion ? Parce qu'ils sont tr�s li�s le lion et le tigre, ce n'est peut-�tre pas les meilleurs exemples mais ce n'est pas bien grave. On peut prendre n�anmoins sleep() � la place de eat().

On va dire qu'un lion �a dort beaucoup, on va dire "je dors 16h par jour �" Et on va partir sur le fait que le tigre dort un peu moins qu'un Lion, on va partir l�-dessus :

Lion.java
---------

package jachampagne;
	
public class Lion extends Feline
{
	public Lion()
	{
		mName = "Lion";
	}
	abstract public void sleep()
	{
		System.out.println("Je dors 16h par jour�");
	}
    	abstract public void speak()
	{
       System.out.println("Je rugis�");
       }
}

Tiger.java
----------

package jachampagne;
	
public class Tiger extends Feline
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void sleep()
    {
    	System.out.println("Je dors moins qu'un Lion");
    }
    
    public void speak()
    {
    	System.out.println("Je rugis�");
    }
}

En r�sum� de ce que j'ai fait, j'ai fait une classe f�line pour les f�lins, abstraite, et je dis que j'ai 2 classes concr�tes Lions.java et Tiger.java. Donc une qui repr�sente un lion et une autre qui repr�sente un tigre pour r�sumer un petit peu les petits changements qu'on vient de faire dans la vid�o. 

Donc ils dorment chacun diff�remment, c'est pour �a qu'ici, j'ai vraiment une m�thode abstraite sleep() par rapport � speak(). Alors pour le coup speak() dans Feline.java n'est pas abstraite :

Feline.java
-----------

package jachampagne;

abstract public class Feline
{
	protected String mName;

	//public String whoAmI()
	//{
	//	return mName;
    //}
    //abstract public void eat();
	
	abstract public void sleep();
	
    public void speak()
	{
		System.out.println("Roaaarr !!");
	}
}

Donc la m�thode speak n'est pas abstraite pour le coup donc on fait comme ci-dessus et pour dire simplement, je consid�re simplement que tous les f�lins dormiront absolument diff�remment donc il faut absolument impl�menter �a pour chacun. Bah du coup le lion, concr�tement il dort d'une mani�re bien pr�cise, le tigre il dort aussi � sa mani�re mais de mani�re pr�cise �galement.

Donc une impl�mentation diff�rente par classe concr�te par contre pour moi dans ce cas-ci en tout cas, le lion et le tigre, bien ils rugissent en fait c'est-�-dire que quand je l'ai fait parler, ils rugissent.

Du coup si je voulais produire �a, vous voyez que j'ai une r�p�tition de code entre les 2 classes concr�tes et on sait pour la r�p�tition de code en informatique, faut absolument �viter donc c'est un argument suffisant, c'est une raison un motif suffisant pour dire que ce que j'ai mis l� :

	public void speak()
	{
       System.out.println("Je rugis�");
    }

Pour dire que ce que j'ai mis l�, je le factorise c'est-�-dire que au lieu de le r�p�ter � x endroit parce que l� dites-vous que je n'ai qu'un lion et un tigre mais rien n'emp�che demain de faire une panth�re, un puma, un l�opard, un Jaguar, un gu�pard si je veux tous les faire rugir on va avoir je ne sais combien de m�thodes r�p�t�s.

Feline.java
-----------

package jachampagne;

abstract public class Feline
{
	protected String mName;

	//public String whoAmI()
	//{
	//	return mName;
    //}
    //abstract public void eat();
	
	abstract public void sleep();
	
    //public void speak()
	//{
	//	System.out.println("Roaaarr !!");
	//}
	
	public void speak()
	{
       System.out.println("Je rugis�");
    }
}

Tiger.java
----------

package jachampagne;
	
public class Tiger extends Feline
{
	public Tiger()
	{
		mName = "Tigre";
	}

	public void sleep()
    {
    	System.out.println("Je dors moins qu'un Lion");
    }
    
    //public void speak()
    //{
    //	System.out.println("Je rugis�");
    //}
}

Lion.java
---------

package jachampagne;
	
public class Lion extends Feline
{
	public Lion()
	{
		mName = "Lion";
	}

	public void sleep()
    {
    	System.out.println("Je dors 16h par jour�");
    }
    
    //public void speak()
    //{
    //	System.out.println("Je rugis�");
    //}
}


Et l� il n'y a qu'une ligne dans notre m�thode mais imaginer des m�thodes beaucoup plus longues, la r�p�tition n'est juste pas possible donc on dit simplement que voil� que tous mes f�lins rugissent comme �a.

Et si mon f�lin doit effectivement rugir comme je l'ai marqu� dans Felin.java, on laisse tel quel, parce que c'est impl�ment� dans la classe abstraite "abstract public class Feline" donc pas de probl�me.

On va d'ailleurs faire un Tiger ti et un Lion li.
*/
import jachampagne.*;

public class App
{
	public static void main(String[] args)
	{
		//LivingSpecies ls = new LivingSpecies();
		Tiger ti = new Tiger();
		ti.speak();
		//ti.whoAmI();
		//System.out.println(ti.whoAmI());
		Lion li = new Lion();
		li.speak();
	}
}
/*
Donc voil�, un Tiger ici, on va dire que ti va speak(), je met ti encore une fois comme terme enfin peu importe.
Ensuite Lion li qui va speak aussi.
Je fait �a pour histoire que vous aillez un peu de visuel en terme de code.
	>javac App.java
	>java App
		Je rugis...
		Je rugis...
On voit que les deux rugissent Il a du coup on ne pourrait m�me pas savoir qui est le lion et qui a le tigre juste en regardant le terminal. Ils se comportent de la m�me mani�re pour communiquer, pas de probl�me. 
Pas de r�p�tition de code, l'abstraction ici, la fameuse classe abstraite que je viens de faire (abstract public void class Feline) m'a permis de factoriser du code pour ne pas � avoir � le r�p�ter dans les diff�rentes classes concr�tes.

Et si un moment donn�, je veux cr�er un puma Qui serait une autre classe concr�te mais qu'exceptionnellement celle-l� je ne veux pas qu'elle communique pareil, et bien dans la classe de Puma, je r��crirai "public void speak()" comme je l'ai mis l� et je mettrais autre chose dans l'impl�mentation Et �a fera une red�finition de la m�thode M�me une surcharge pour le coup pour dire : "� que non puisque tu es un Puma, tu ne vas pas rugir, tu ne vas pas speak, communiquer comme un Felin de mani�re abstraite, de mani�re g�n�rale, mais comme toi tu sais faire comme toi t'es un peu particulier, le Puma, donc tu vas rugir autrement, tu vas tu vas communiquer autrement.".

Donc voil� le principe et dans quel cas on utilise une classe abstraite. Une classe abstraite est fait � la base pour factoriser du code par rapport � des classes concr�tes qui sont �troitement li�s. C'est des termes souvent qu'on emploie dans le sens o� elles ont des liens ensemble, elles peuvent avoir des choses communes.

Et �a c'est, il suffit de vous poser la question. Encore une fois c'est dans un jeu vid�o, vous cr�ez un guerrier, un mage, vous cr�ez un voleur ou n'importe quoi. On trouve naturellement, juste en se posant la bonne question Tout un tas de choses qui sont communes � ces entit�s l� pour le coup. 

Donc naturellement, tout de suite on comprend qu'on peut faire une classe abstraite qui repr�senterait par exemple un combattant, un personnage de jeu ou n'importe quoi qui aurait tous les �l�ments communs � cela et si les gens doivent faire certains trucs sp�cifiques comme par exemple leur mani�re de se battre, de se d�fendre, de se soigner, Eh bien on a fait des classes abstraites et chaque classe concr�te devrait impl�menter � sa mani�re son propre comportement et voil� un petit peu l'int�r�t.

il y a plein d'autres int�r�ts, d'autres utilit� de la classe abstraite mais �a on le verra encore une fois lorsqu'on abordera le polymorphisme, cela qu'on terminera sur un dernier point essentiel de �a, et de l'utilit� de se servir des classes abstraites.

s'il n'y avait pas besoin de classe abstraite, des interfaces, Eh bien on ne serait jamais emb�t� � inventer ce genre de chose en programmation objet.

Donc il y a vraiment des avantages � tout �a, dites-vous qu'il y a vraiment des avantages � �a il vous le verrez par la suite en tout cas. 
Voil� nous avons fait le tour, je vous ai tout dit.
Si vous trouvez que je n'ai pas assez d�taill�, il vous manque des �l�ments pour bien comprendre ce concept de classe abstraite, n'h�sitez pas � le faire savoir dans les commentaires. Il ne faut surtout pas h�siter � poser des questions si ce n'est pas assez explicite pour vous.
Voil� on ne peut pas faire une explication parfaite et ce n'est pas �vident � expliquer.
Parce que moi dans ma t�te je sais tr�s bien ce que c'est qu'une classe abstraite. Je connais bien les concepts, il n'y a pas de probl�me, je sais les employer mais apr�s pour l'expliquer avec des mots simples et que �a rentre dans la t�te de tout le monde, ce n'est pas forc�ment aussi facile pour le coup.
�a peut �tre des fois trop abstrait au niveau des explications donc s'il y a besoin d'�tre un peu plus explicite, un peu plus grand concret dans mes explications n'h�sitez pas � le mentionner dans les commentaires.
Partagez likez la vid�o.
Dans la prochaine s�ance nous parlerons des interfaces. C'est une notion tr�s importante comme la classe abstraite mais c'est autre chose et souvent les gens ont tendance � m�langer un petit peu les 2 donc l� je vous r�serve du coup la prochaine s�ance pour parler des interfaces et je vous dis � bient�t pour la prochaine vid�o en Java.

*/
