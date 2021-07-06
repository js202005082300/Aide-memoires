# [16. Flux redirection](https://www.youtube.com/watch?v=8ZfdwUjzxkA)

## flux redirection
Différent types:
- stderr = sortie erreur.
- stdin = entrée clavier.
- stdout = sortie standard.

## >
Opérateur de redirection.
```bash
ls -la > res.txt #rediriger le flux vers un fichier.
cat doc.txt >> res.txt #ajouter à la fin du fichier.
cat dossier.txt 2> res.txt #rediriger le flux d'erreur (2).
cat dossier.txt > ok.txt 2>> errors.log #rediriger le flux 1 ou 2.
cat dossier.txt > res.log 2>&1 #rediriger le flux 1 ou 2.
ls -l > /dev/null #rediriger vers le néant.
cat dossier.txt > res.txt 2> /dev/null #rediriger flux 1 vers un fichier et flux 2 vers le néans.
```

## |
Tube, pype, signifie que la sortie de la 1e commande sert d'entrée pour la 2e.
```bash
ls -l | cat doc.txt | cat dossier.txt > res.txt 2>&1
ls -l | cat doc.txt | cat dossier.txt >> res.txt 2>&1
```

## <
Opérateur de redirection.
```bash
cat < doc.txt #Shell ouvre et envoi ce fichier à la commande cat.
ls -l < doc.txt > res.txt #doc envoyé à la commande ls, et le tout est envoyé à res.
ls -l < doc.txt #doc sert d'entrée à ls.
```

## <<
Opérateur de redirection.
```bash
cat << END
> Bonjour
> tout
> le
> monde
> END
```
```bash
cat > fic.txt << EOF
> Bonjour
> tout
> le
> monde
> EOF
```