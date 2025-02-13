```git
git status
git add . 
```
```git
git commit -m "message"
git push origin master
```
```bash
ssh-keygen -t rsa
cat /c/Users/<Пользователь>/.ssh/id_rsa.pub
```
```git
git remote add <название> <url>
```
```git
usage: git remote [-v | --verbose]
   or: git remote add [-t <branch>] [-m <master>] [-f] [--tags | --no-tags] [--mirror=<fetch|push>] <name> <url>
   or: git remote rename [--[no-]progress] <old> <new>
   or: git remote remove <name>
   or: git remote set-head <name> (-a | --auto | -d | --delete | <branch>)
   or: git remote [-v | --verbose] show [-n] <name>
   or: git remote prune [-n | --dry-run] <name>
   or: git remote [-v | --verbose] update [-p | --prune] [(<group> | <remote>)...]
   or: git remote set-branches [--add] <name> <branch>...
   or: git remote get-url [--push] [--all] <name>
   or: git remote set-url [--push] <name> <newurl> [<oldurl>]
   or: git remote set-url --add <name> <newurl>
   or: git remote set-url --delete <name> <url>
```
```git
git clone <url>
git clone <url> <name>
```
```git
git config --global user.name "<имя>"
git config --global user.email "<почта>"
```
```git
git log
```
```git
git pull origin master
```

```git
git checkout <hash_коммита>
```

```git
git reset <флаг> <hash-коммита>
```

```git
git branch
git merge <название_ветки_для_вливания> 
git checkout –b <название_ветки>
```

```git
git rebase <base>
```
