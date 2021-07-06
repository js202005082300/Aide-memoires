[AIDE - Visual Studio Code](https://www.youtube.com/watch?v=eQUsUq_2AQU&list=PLrSOXFDHBtfEwFMZ1YIXgUqOFODGyo7tB&index=24) - 
[Resource Aide](https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/Aide)

Editeur, Environnement de développement, gratuite, en partie Open Source et multiplateforme.

Installer par défaut, pas besoin de cocher la variable PATH.

Agrandir l'interface

	ctrl +
	
Réduire l'interface

	ctrl -

Chercher "French dans les extensions"

	ctrl+Shift+X

## Install -> Module linguistique français pour VS Code

> French Language Pack for Visual Studio Code

En bas à droite, vérifier:

	UTF-8
	Taille des tabulations:4

Avance

	Tab
	
Recule

	Maj+Tab

Curseur multiple

	Alt

Paramètre

	Ctrl+,
	
Voir,
Modifier dans settings.json
C:\Users\sam\AppData\Roaming\Code\User\settings.json

Thème de couleur

	ctrl+K ctrl+T

## Install -> Tomorrow_Night_Eighties Theme

> Tomorrow_Night_Eighties

Ajouter curseur en dessous ou au-dessus

	ctrl+Alt+flèche

Terminal

	ctrl+Maj+ù

De plus, 

Monter, désecendre une ligne.
	
	Alt+flèche
	
Remplacer,
	
	ctrl+H (valider : ctrl+Alt+Enter)

Commenter

	Ctrl+K ctrl+C
	
Retourne à la fonction en programmation.
	
	Click+F12
	
Emmet, par exemple le code source Html pour un fichier .html

	Tab+!

## Configuration

> C:\Users\sam\AppData\Roaming\Code\User\settings.json

```json
//https://code.visualstudio.com/docs/getstarted/settings

{
    "workbench.welcome.enabled": false,
    "workbench.colorTheme": "Tomorrow_Night_Eighties",
    "files.autoSave": "afterDelay",
    "editor.cursorStyle": "line",
    "editor.tabSize": 4,
    "editor.fontLigatures": false,
    "editor.wordWrap": "on",
    "window.zoomLevel": -1,
    // GIT.
    "git.path": "C:\\Program Files\\Git\\cmd\\git.exe",
    "git.enableSmartCommit": true,
    "git.confirmSync": false,
    "git.allowForcePush": true,
    "git.ignoreMissingGitWarning": true,
}
```