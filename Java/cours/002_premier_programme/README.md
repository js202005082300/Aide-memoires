# Java #2 - premier programme

## Erreurs rencontrées
+ problème d'encodage (UTF-8 BOM -> UTF-8)
```
PS C:\Users\js201\OneDrive\Formations\Programmation\FormationVideo\Ressources\Java\002_premier_programme> javac MainApp.java
MainApp.java:1: error: illegal character: '\u00bb'
´╗┐class MainApp
 ^
```
+ le même nom de classe n'est pas autorisé
```
MainApp.java:74: error: duplicate class: MainApp
class MainApp
^
```