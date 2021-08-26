@echo off
chcp 65001

::@param token Github

set a=1;
set "g=https://github.com/js202005082300/Aide-memoires.git"
set "test=https://js202005082300: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@github.com/js202005082300/Aide-memoires.git"
set d=%date:~0,2%-%date:~3,2%-%date:~6,4%
set t=%time:~0,2%:%time:~3,2%:%time:~6,2%
set t=%t: =%

if not exist ".git" ( 
    git init 
    git config --global user.email "js201910271836@outlook.com"
    git config --global user.name "js"
    git branch -M main
    if not exist "README.md" ( echo # Aide-mémoires>> README.md )
)

if "%~1" NEQ "" ( echo git remote add origin https://js202005082300:%~1@github.com/js202005082300/Aide-memoires.git )

git pull %test%
git add *
git commit -a -m "%d% %t%"
git push %test%

exit