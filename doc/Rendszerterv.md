Pacman projekt Rendszerterv
=============================

### 1. A rendszer célja
A rendszerünk célja, hogy egy egységes platformot teremtsünk a mai játékok   
őseinek számára. Egyszerűvé tenni a régi játékokat kedvelők számára a   
szenvedélyük gyakorlását. Manapság egész nehéz hozzájutni az huszadik   
századi játékokhoz eredeti formájukban, később pedig egyenesen lehetetlen lesz,   
ez volt a motiváció a rendszer fejlesztése mögött. A játékosok játszhatnak csak   
szórakozásból, kitüntetéseket szerezhetnek bizonyos mérföldkövek elérése után,   
illetve versenyezhetnek, megmérkőzhetnek egymással.   
   
Elsőnek a rendszer előzetes verziójába még csak a Pac-Man névre hallgató   
ikonikus játék kerül be. A játékban egy sárga figurával, Pac-Man-nel kell   
pontokat szerezni, de ezt négy szellem, Pinky, Inky, Blinky és Clyde próbálja   
megakadályozni. A cél az, hogy a pályán elérhető összes pontot megszerezzük   
Pac-Mannel, úgy, hogy a szellemekkel nem érintkezünk. A játék fejleszti a   
játékosok problémamegoldó képességét, mivel a négy szellem különböző módon   
próbálja meg Pac-Mant csapdába ejteni. Mind a négy szellem stratégiáját   
ki kell számolni, és el kell kerülni őket.
### 2. Projekt terv
A projektre összesen két hétnyi idő áll rendelkezésre. A feladaton négy   
egyetemi hallgató dolgozik másodállásban. Az időbeosztás a következő:   
 * 2019 szeptember 16. - 2019. szeptember 22.:
     * Ötletelés
     * Dokumentáció létrehozása
     * Feladatokra bontás
     * Szerepkörök felosztása
 * 2019 szeptember 23 - 2019. szeptember 29.:
     * Dokumentáció véglegesítése
     * Projekt implementálása
 * 2019 szeptember 30 - :
      * Karbantartás

A szerepkörök a következőképp oszlanak meg:
* Ádám Szilárd: 
    * Fő terület: Pac-Man irányítása az állapottérreprezentációnak
    és a felhasználói bemenet által
    * A szellemek mesterséges intelligenciájának implementálása
    * Grafikus felhasználói interfész (GUI) fejlesztése
* Dimény Áron: 
     * Fő terület: Grafikus felhasználói interfész (GUI) fejlesztése
     * Pac-Man irányítása az állapottérreprezentációnak
    és a felhasználói bemenet által
     * A szellemek mesterséges intelligenciájának implementálása
     * Pac-Man irányítása az állapottérreprezentációnak
    és a felhasználói bemenet által
* Varga Erik Szilveszter: 
    * Fő terület: A szellemek mesterséges intelligenciájának implementálása
    * Pac-Man irányítása az állapottérreprezentációnak
    és a felhasználói bemenet által
    * Grafikus felhasználói interfész (GUI) fejlesztése
    * Pac-Man irányítása az állapottérreprezentációnak
    * A játék állapottérreprezentációjának implementálása
    és a felhasználói bemenet által
* Versényi Péter
    * Fő terület: A játék állapottérreprezentációjának implementálása
    * Pac-Man irányítása az állapottérreprezentációnak
    és a felhasználói bemenet által
    * Grafikus felhasználói interfész (GUI) fejlesztése
    * Pac-Man irányítása az állapottérreprezentációnak

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
fejlesztést.A termék verziókezeléséhez a Git lesz használva, pontosabban egy    
privát repóra lesz majd szükség, mivel a projekten dolgozó fejlesztők száma    
meghaladja az ingyenes keretekben biztosított számot.
### 7. Absztrakt   domain   modell
### 8. Architekturális terv
### 9. Adatbázis terv
### 10. Implementációs terv
### 11. Tesztterv
Az appliációban elsősorban az üzleti logika kerül tesztelésre, ami a játékos   
helyváltoztatásából,a játékos és szellem ütközéséből,a játék állapotának     
lementéséből, az elért pontszámok ellenőrzéséből, a szellemek mozgásából és a     
játék sikeres végállapota eléréséből áll.A játékos helyváltoztatásának     
tesztelése akkor jár sikerrel ha a felhasználló által beérkezett inputra, a    
Pacman helyesen mozdult el egy 'mezőt' horizontálisan vagy vertikálisan,    
természetesen a speciális eseteket is figyelembe kell venni, például a pálya     
végének elérése illetve szellemmel való ütközés. Pontszámok ellenőrzése     
triviális, a pályáról felvett pontok értékével kibővítjük a pontszám számlalót.    
A szellemek következő lépésének tesztelése kevésbé triviális, figyelembe kell    
venni a szellem típusát illetve egyes szellem típusok mozgatásához kell tudjuk    
a Pacman jelenlegi helyzetét a pályán.A szellemek lehetnek: piros, rózsaszín,    
világoskék, narancssárga típusúak/színűek, mindegyik egyéni módon járkál a    
pályán, a piros szellem szorosan követi a játékost, a rózsaszín szellem próbál    
mindíg a játékos elé állni, a világoskék szellem őrködik egy terület zónán     
amit folyamtosan oda-vissza bejár illetve a narancssárga szellem véletlenszerűen    
mozog.A játék végállapota kétféle lehet sikeres vagy sikertelen, amit rendre    
úgy érhetünk el, hogy sikeresen felszedjük a pályán található összes pontot    
anélkül, hogy a szellemek elkapjanak, a sikertelen játék véget pedig úgy lehet    
elérni, hogy a játékos kifogy életekből.A játék állapotának lementése a kijelölt    
billentyűzet gomb lenyomásakor kell majd megtörténnie, a játék állapotának
lementése több kicsi más feladattal is jár amit ugyanúgy tesztelnünk kell,    
például a játék állapotot képesek kell legyünk be is tölteni.A játékos szellem-    
mel való ütközésének eredményét is kellőképpen kell ellenőrizni, nagyon fontos    
hogy ennek az interakciónak a hatását a felhasználó azonnal érzékelje különben    
kellemetlen játék szituációk állhatnak elő, illetve a rendszeren belül is     
kritikus jellegű hibákat észlelhetnénk.Az üzleti logikán kívül az alkalmazás    
rezponzívitását is kellőképpen tesztelnünk kell, pontosabban azt, hogy minden     
kliens oldalról érkező bemenet a helyes funkciót eredményezze és akadálymentesen    
dolgozza fel a program, azért hogy a termék megőrizhesse felhasználóbarát     
tulajdonságát.Végső sorban szükség van az adatbázis és program közötti,     
adatátmenet ellenőrzésére, ebben az esetben az számít helyes eredménynek a     
tesztelésnél, ha az applikáció által előállított adatok és az adatbázisban     
tárolt adatok, megegyeznek. 
### 12. Telepítési terv
### 13. Karbantartási  terv
