[AIDE - Visual Studio Code](https://www.youtube.com/watch?v=eQUsUq_2AQU&list=PLrSOXFDHBtfEwFMZ1YIXgUqOFODGyo7tB&index=24) - 
[Resource Aide](https://github.com/jasonchampagne/FormationVideo/tree/master/Ressources/Aide)

Editeur, Environnement de développement, gratuite, en partie Open Source et multiplateforme.

Installer par défaut, pas besoin de cocher la variable PATH.

`ctrl +` Agrandir l'interface
	
`ctrl -` Réduire l'interface

`ctrl+Shift+X` Chercher "French dans les extensions"
> French Language Pack for Visual Studio Code

En bas à droite, vérifier:

	UTF-8
	Taille des tabulations:4

`Tab` Avance
	
`Maj+Tab` Recule

`Alt` Curseur multiple

`Ctrl+,` Paramètre
	
Voir,
Modifier dans settings.json : 
`C:\Users\sam\AppData\Roaming\Code\User\settings.json`

`ctrl+K ctrl+T` : Thème de couleur

`ctrl+Alt+flèche` Ajouter curseur en dessous ou au-dessus

`ctrl+Maj+ù` Terminal

De plus, 

Monter, désecendre une ligne : `Alt+flèche`
	
Remplacer, `ctrl+H` (valider : ctrl+Alt+Enter)

`Ctrl+K ctrl+C` Commenter
	
`Click+F12` : retourne à la fonction en programmation.
	
Emmet, par exemple le code source Html pour un fichier .html

	Tab+!

## Configuration

> C:\Users\sam\AppData\Roaming\Code\User\settings.json

```json
//https://code.visualstudio.com/docs/getstarted/settings

{
    "workbench.welcome.enabled": true,
    "workbench.colorTheme": "Tomorrow_Night_Eighties",
    "files.autoSave": "afterDelay",
    "editor.cursorStyle": "line",
    "editor.tabSize": 4,
    "editor.fontLigatures": false,
    "editor.wordWrap": "on",
    "editor.bracketPairColorization.enabled": true,
    "window.zoomLevel": -2,
    // GIT.
    "git.path": "C:\\Program Files\\Git\\cmd\\git.exe",
    "git.enableSmartCommit": true,
    "git.confirmSync": false,
    "git.allowForcePush": true,
    "git.ignoreMissingGitWarning": true,
}
```

## Modules

+ Microsoft Edge Tools for VS Code
+ Tomorrow_Night_Eighties Theme
+ French Language Pack for Visual Studio Code