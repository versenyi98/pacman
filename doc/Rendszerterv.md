Pacman projekt Rendszerterv
=============================

### 1. A rendszer célja
### 2. Projekt terv
### 3. Üzleti   folyamatok   modellje
### 4. Követelmények
### 5. Funkcionális  terv
### 6. Fizikaikörnyezet
Az applikáció fejlesztése Java nyelven fog történni és működőképes lesz cross-
platform, azaz Linux, Windows és Mac alatt is működni fog.Az applikáció 
fejlesztéséhez a Java alapértelmezett eszközein kívül a JavaFX is szükséges 
lesz.A cég által preferált integrált fejlesztési környezet az Intellij IDEA, 
ami két formában is elérhető, jelen van egy ingyenes és egy fizetős változat
is, a fizetős variáns bár nem feltétlenül szükséges, jelentősen felgyorsítja a 
fejlesztést.
### 7. Absztrakt   domain   modell
### 8. Architekturális terv
### 9. Adatbázis terv
### 10. Implementációs terv
### 11. Tesztterv
Az appliációban elsősorban az üzleti logika kerül tesztelésre, ami a játékos
helyváltoztatásából,a játékos és szellem ütközéséből, az elért pontszámok 
ellenőrzéséből, a szellemek mozgásából és a játék sikeres végállapota eléréséből
áll.A játékos helyváltoztatásának tesztelése akkor jár sikerrel ha a 
felhasználló által beérkezett inputra, a Pacman helyesen mozdult el egy 'mezőt' 
horizontálisan vagy vertikálisan, természetesen a speciális eseteket is 
figyelembe kell venni, például a pálya végének elérése illetve szellemmel való 
ütközés. Pontszámok ellenőrzése triviális, a pályáról felvett pontok értékével 
kibővítjük a pontszám számlalót.A szellemek következő lépésének tesztelése 
kevésbé triviális, figyelembe kell venni a szellem típusát illetve egyes 
szellem típusok mozgatásához kell tudjuk a Pacman jelenlegi helyzetét a pályán. 
### 12. Telepítési terv
### 13. Karbantartási  terv
