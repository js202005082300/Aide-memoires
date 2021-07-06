@echo off
chcp 65001
set a=0;
set "g=https://github.com/js202005082300/Aide-memoires.git"
set d=%date:~0,2%-%date:~3,2%-%date:~6,4%
set t=%time:~0,2%:%time:~3,2%:%time:~6,2%
set t=%t: =%
if not exist ".git" ( git init )
if not exist "README.md" ( echo # Aide-mémoires>> README.md )
if %a%==0 (
    git config --global user.email "js201910271836@outlook.com"
    git config --global user.name "js"
    git remote add origin %g%
    git branch -M main
    git pull %g%
    git add *
    git commit -a -m "%d% %t%"
    git push -u origin main
) else ( 
    git pull %g%
    git add *
    git commit -a -m "%d% %t%"
    git push %g%
)
exit