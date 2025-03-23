git advanced
1. git reset
2. git revert
3. git rebase 
4. git flow 
5. git cherry-pick


## Сохранение изменений
git stash
```git
git stash save "WIP: return later"
git stash pop "stash@{1}"
git stash list
```
git diff
```git
git diff d64945 d8f2515
git diff d64945 d8f2515 > diff.patch
git apply --check -allow-empty  diff.patch
```
.gitkeep
.gitignore
```git
HELP.md
target/
*.iws
/nbproject/private/
!**/src/test/**/build/
```

Отмена изменений
git reset
git revert
```
git revert d8f2515
```
drop commit

Переписывание истории
git rebase
отличия git push и git push --force

Синхронизация с удаленным репозиторием
git fetch
git pull

gitflow