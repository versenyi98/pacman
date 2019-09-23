Pacman projekt Funkcionális Specifikáció
==========================================

### 1. Jelenlegi helyzet
A mai napokban egyre nehezebb a 80-as 90-es évek ikonikus játékait jó minőségű    
formában elérni, pedig az igény ezekre a csodálatos alkotásokra még mindíg     
óriási.Manapság ha rákeresünk egy klasszikus játékra valószínüleg nem az eredeti    
változatát találnánk meg, hanem egy módosított verziót, ami lehet vagy     
lebutított vagy elképesztően nehéz, ami mindkét esetben elveszi úgy a fiatalok    
kedvét mint a már idősebb generációk kedvét a játéktól.Ha pedig mégis     
megtalálnánk egy megfelelő eredeti verziót, nem kapnánk lehetőséget arra, hogy    
online összemérjük a teljesítményünket.Ugyanakkor, manapság a játékok egyre     
több erőforrást vesznek igénybe, ami nagyon költséges tud lenni, főleg a     
technológia robbanószerű fejlődése miatt, nem túlzás azt kijelenteni, hogy a     
legfrissebb játékokat 'teljesen kiélvezni', kis vagyonba kerül, még akkor is    
ha csak 1-2 alkatrészt kell vásárolni.Egyre kevesebb olyan játékot látunk amely    
széleskörű felhasználóbázisnak tud minőségi időtöltési lehetőséget biztosítani    
megengedhető pénzügyi kereteken belül.Mindezek felül, manapság a játéktermek      
mennek ki a divatból és egyre nehezebb egyetlen helyen megtalálni azokat a     
klasszikus játékokat, amiért régen siettunk haza iskolából.
### 2. Vágyalom rendszer
#### Főmenü
A játék megnyitásakor ezzel a menüvel találja magát szembe a felhasználó, ahol a következő elemekre navigálhat tovább:
* Játékaim (könyvtár): tartalmazza az elérhető játékokat, legelőször csak a pacmant.
* Toplisták: a különböző időszakokra és/vagy területekre vonatkozó toplistákat lehet itt elolvasni, az azt elérő játékosok nicknevével és pontszámával.
* Fiókom: a játékos fiókjának beállításait és adatait tartalmazza és kezeli.
* Beállítások: a program konfigurációját kezeli. Ilyenek pl. a képernyőfelbontás, a nehézség, a billentyűvel való irányítás beállításai.
* Barátok: azoknak a más játékosoknak a listáját jeleníti meg és kezeli, kik barátéknt vannak felvéve a jelenlegi játékosnak. Elhelyezhető a legfelső szinten, vagy a `profilom` menüpontban.
* Egyéb menüpontok, melyeknek létjogosultsága még nem tiszta, azonban a játék fejlesztése során felmerül   .

#### Pac-Man
###### Irányítás

* <kbd>&uarr;</kbd> vagy <kbd>W</kbd>: Pac-Man-nel mozgás felfelé, ha lehetséges   
* <kbd>&darr;</kbd> vagy <kbd>S</kbd>: Pac-Man-nel mozgás lefelé, ha lehetséges   
* <kbd>&rarr;</kbd> vagy <kbd>D</kbd>: Pac-Man-nel mozgás jobbra, ha lehetséges    
* <kbd>&larr;</kbd> vagy <kbd>A</kbd>: Pac-Man-nel mozgás balra, ha lehetséges   
* <kbd>R</kbd>: Az aktuális játszma újraindítása. Az újraindítás szándékát meg   
kell erősíteni, a felugró ablakban feltett kérdésre adott megfelelő válasszal.   
* <kbd>ESC</kbd> A játék szünetelése. Szünet közben megjelenő menüben megjelenő   
menüből elérhető öt opció:
  * `Beállítások` A Főmenü "Beállítások" menüpontjával ekvivalens opció.   
  * `Visszajátszás` Az adott játszma eddigi eseményenek visszatekintése.
  * `Toplisták` A Pac-Man játékhoz tartozó ranglisták megjelenítése.   
  * `Kilépés a főmenübe` Az adott játék elhagyása. A főmenübe visszatérés.   
  A felhasználó eldöntheti, hogy a jelenlegi állapotot elmentse-e a rendszer.   
  * `Kilépés az asztalra.` Az adott játék, és keretrendszer elhagyása.   
  A felhasználó eldöntheti, hogy a jelenlegi állapotot elmentse-e a rendszer.   

### 3. Jelenlegi üzleti folyamatok modellje
* A játékosnak kedve van játszani.
* Kikeresi a legközelebbi játékterem címét.
* Magához vesz egy zsák aprópénzt.
* 20-30 perc alatt eljut a játékterembe (jobb esetben).
* Amíg kedve van játszani és maradt még pénze:
  * Pénzt dob a játékgépbe.
  * Játszik.
  * Ha magas pontszámot ért el:
    * Opcionálisan megadja a nevét a toplista miatt.
* 20-30 perc alatt hazaér szegényebben (jobb esetben).
### 4. Igényelt üzleti folyamatok modellje
