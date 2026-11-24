# Tervezési döntések

## 1. Objektumorientált felépítés

A projekt tervezésekor fontos szempont volt, hogy a különböző lótípusok közös tulajdonságai ne legyenek többször megvalósítva.

Ezért egy absztrakt `Lo` ősosztályt alkalmazunk, amely a lovak közös adatait és működését tartalmazza.

Az `Iskolalo` és a `Berlo` osztály ebből származik, így mindkét típus rendelkezik a közös tulajdonságokkal, ugyanakkor saját, típusfüggő adatokkal is kiegészül.

A megoldás előnye:
- csökkenti a kódismétlést;
- lehetővé teszi a közös kezelésüket;
- új lótípusok bevezetését is megkönnyíti.

## 2. Adatvédelem és validáció

Az osztályok mezői private láthatóságúak. Az adatok elérését getter és setter metódusok biztosítják.

A konstruktorok és a módosító metódusok ellenőrzik a megadott értékeket. Ezzel elkerülhető, hogy érvénytelen adatok kerüljenek a nyilvántartásba.

A már létező lóazonosító kezelésére saját kivételosztályt alkalmazunk.

## 3. Factory Method tervezési minta választása

A különböző lótípusok létrehozása eltérő adatokat igényel. Az iskolalónál például napi óraszámkorlátot, a bérlónál pedig óradíjat kell megadni.

A közvetlen példányosítás helyett a Factory Method mintát választottuk, hogy a létrehozási folyamat elkülönüljön a konzolos menü működésétől.

A minta résztvevői:

| Szerep | Osztály |
|---|---|
| Absztrakt létrehozó | `LoLetrehozo` |
| Konkrét létrehozó | `IskolaloLetrehozo` |
| Konkrét létrehozó | `BerloLetrehozo` |
| Absztrakt termék | `Lo` |
| Konkrét termék | `Iskolalo` |
| Konkrét termék | `Berlo` |

A megoldás előnye, hogy az egyes lótípusok létrehozásáért külön osztályok felelnek. Új típus bevezetésekor nem szükséges a teljes létrehozási logikát a konzolos menübe beépíteni.

## 4. Fájlalapú adattárolás

A projektben adatbázis helyett fájlalapú tárolást választottunk.

Ennek oka, hogy az alkalmazás egy egyszerű, önálló nyilvántartási rendszer, amelyhez nem szükséges külön adatbázis-kezelő rendszer.

A Java szerializáció lehetővé teszi a lóobjektumok listájának mentését és visszatöltését.

A fájlműveleteknél try-with-resources szerkezetet alkalmazunk, így az adatfolyamok használat után automatikusan lezáródnak.

## 5. Maven és JUnit használata

A Maven alkalmazása megkönnyíti a függőségek kezelését, valamint a projekt egységes fordítását és csomagolását.

A JUnit 5 használatával automatizált teszteket készítettünk a fontosabb működések ellenőrzésére.

A tesztelés külön foglalkozik:
- a lómodellek validációjával;
- a nyilvántartási műveletekkel;
- a Factory Method létrehozó osztályaival;
- az adatok mentésével és visszatöltésével.

## 6. A konzolos felület választása

A projekt konzolos felületet használ grafikus felhasználói felület helyett.

Ez egyszerűbb megvalósítást tesz lehetővé, és a fejlesztés során elsősorban az objektumorientált programozásra, az üzleti logikára és az adatok kezelésére koncentrálhatunk.

## 7. Korlátozások és továbbfejlesztési lehetőségek

A jelenlegi megvalósítás egy alapvető lovardai nyilvántartás kezelésére alkalmas.

Lehetséges továbbfejlesztési irányok:
- grafikus felhasználói felület kialakítása;
- adatbázis használata;
- több felhasználó támogatása;
- további lótípusok bevezetése;
- részletesebb statisztikai és keresési lehetőségek.

## 8. Összegzés

A tervezési döntések során az egyszerűség, az átláthatóság, a bővíthetőség és a karbantarthatóság voltak a fő szempontok.

Az objektumorientált felépítés és a Factory Method minta segíti a felelősségi körök elkülönítését, míg a Maven és a JUnit támogatja a projekt fejlesztését és ellenőrzését.