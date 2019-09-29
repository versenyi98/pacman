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
    * Fő terület: Pac-Man irányítása az állapottérreprezentáció
    és a felhasználói bemenet által
    * A szellemek mesterséges intelligenciájának implementálása
    * Grafikus felhasználói interfész (GUI) fejlesztése
    * adatbázis fejlesztése, tesztelése, és optimalizálása
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
### 6. Fizikai környezet
Az applikáció fejlesztése Java nyelven fog történni és működőképes lesz cross-   
platform, azaz Linux, Windows és Mac alatt is működni fog. Az applikáció    
fejlesztéséhez a Java alapértelmezett eszközein kívül a JavaFX is szükséges    
lesz.A cég által preferált integrált fejlesztési környezet az Intellij IDEA,    
ami két formában is elérhető, jelen van egy ingyenes és egy fizetős változat   
is, a fizetős variáns bár nem feltétlenül szükséges, jelentősen felgyorsítja a    
fejlesztést.A termék verziókezeléséhez a Git lesz használva, pontosabban egy    
privát repóra lesz majd szükség, mivel a projekten dolgozó fejlesztők száma    
meghaladja az ingyenes keretekben biztosított számot.
### 7. Absztrakt   domain   modell
### 8. Architekturális terv
A rendszerben található játékokat az MVC(Model - View - Controller) tervezési   
minta segítségével valósítjuk meg. Az alkalmazás úgy lesz előállítva, hogy     
skálázható legyen, de ugyanakkor a kezdeti erőforrások is kielégítő tapasztalatot    
biztosítsanak a felhasználónak. Elősször tekintsünk egy kimondottan kis méretű   
adatbázist, ami csak 100 felhasználó elért eredményét képes tárolni, ebben az    
esetben az egyetlen szélsőséges eset az, amikor több felhasználónak ugyanolyan    
eredménye van, de már nincs tárhely az adatbázisban. Ebben az esetben, annak a   
felhasználónak az eredménye kerül be az adatbázisba, amelyik hamarabb elérte az   
adott pontszámot.A változások kezelésénél két esetet különböztetünk meg: amikor   
az adatbázis kapacitása nő ,illetve amikor az adatbázis kapacitása csökken. A csökkent    
kapacitás esetén töröljük azokat a tárolt eredményeket, ameyek a jelenlegi toplista    
alján vannak. A növelt kapacitás esetén, hasonlóképpen kezeljük a bejövő eredményeket,   
mint az eredeti kapacitáskor, annyi különbséggel, hogy megnő a toplistában feltüntetett    
eredmények száma.  
### 9. Adatbázis terv
Az applikáció egy fontos funkciója igényli a háttérbeli adatbázis használatát. Ez minden valószínűséggel egy általunk üzemeltetett linux szerveren futó MySQL adatbázis lesz.

Ez a funkció a toplista, mely a legjobb eredményeket elért játékosok pontjait tárolja örök, havi, heti, és napi lebontásban. Ehhez szükséges lesz egy táblára, mely eltárolja a pontot elért játékosok nicknevét, pontszámát, és annak elérésének dátumát és idejét. A táblából érdemes lesz napi rendszerességgel kiszórni azokat az eredményeket, melyek egyik toplistára sem kerülhetnek fel pontszámuk alapján. Ez segíteni fog elkerülni az adatbázis méretének akár exponenciális növekedését.

Az applikáció és az adatbázis kommunikációja php fájlok felé intézett GET és POST kéréseken keresztül valósul meg. Minimálisan szükség lesz 2 PHP fájlra:
* az újonnan szerzett pontok beillesztéséhez
* a toplisták lekéréséhez (mely megkaphatja paraméterként, melyik listára van szükség)

Ezeken kívül felmerülhet a szükség kiegészítő/segítő fájlok és funkciók iránt, melyek egyszerűsítik majd az adatok lekérésére szolgáló kód szerkezetét.
### 10. Implementációs terv
### 11. Tesztterv
| A teszt tárgya | Tesztadat | elvárt visszatérési érték illetve viselkedés | Kilépési feltétel |
|----------|:-------------:|------:| ------: |
| A játékos név adása | Üres string | Üzenet a felhasználónak, hogy szükséges nevet adni | Sikeres teszt |
| A játék indítása | Kattintás | A játék elindul | Elindul a játek|
| A játék ablak | Ablak fókusz elvesztése | A játék folytatódik a háttérben | A játék nem áll meg |
| A játék bezárása | Applikációból való kilépés bármilyen módon | A játék vége, foglalt erőforrások visszaszolgáltatása | Az applikáció leáll |
| Pontrendszer | A játékos felvesz egy pontot | A jelenlegi eredmény növelése adott mennyiséggel | Sikeres teszt |
| A játékos mozgása | <kbd>A</kbd> | A játékos 1 mezővel balrább kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | <kbd>D</kbd> | A játékos 1 mezővel jobrább kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | <kbd>W</kbd> | A játékos 1 mezővel feljebb kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | <kbd>S</kbd> | A játékos 1 mezővel lejjebb kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | <kbd>&larr;</kbd> | A játékos 1 mezővel balrább kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | <kbd>&rarr;</kbd> | A játékos 1 mezővel jobrább kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | <kbd>&uarr;</kbd> | A játékos 1 mezővel feljebb kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | <kbd>&darr;</kbd> | A játékos 1 mezővel lejjebb kerül, amennyiben lehetséges | Sikeres teszt |
| A játékos mozgása | érvényes input (lásd feljebb) | A játékos helyzete nem változik, amennyiben olyan mezőre lépne ahol fal van | Sikeres teszt |
| Érvénytelen input | Bármilyen billentyű vagy egér input aminek nincs beállított funkcionalitása | Semmi | Sikeres teszt |
| A játék vége | A szellem és a játékos találkoznak | A játék befekeződik | Sikeres teszt |
| A játék vége | A játékos összegyüjtötte az összes pontot | A játék befekeződik | Sikeres teszt |




### 12. Telepítési terv
### 13. Karbantartási  terv
