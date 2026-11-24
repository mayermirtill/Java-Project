# Lovarda Nyilvántartó Rendszer

## 1. A projekt bemutatása

A projekt egy Java nyelven készített, konzolos lovarda-nyilvántartó alkalmazás. Célja a lovarda lovainak egyszerű és átlátható kezelése.

A program lehetővé teszi a lovak nyilvántartását, keresését, módosítását, törlését és rendezését, valamint az adatok fájlba mentését és későbbi visszatöltését.

## 2. Főbb funkciók

- Új ló felvétele.
- A nyilvántartott lovak listázása.
- Ló keresése azonosító vagy név alapján.
- Ló adatainak módosítása.
- Ló törlése.
- Lovak rendezése név vagy életkor szerint.
- A ló állapotának kezelése.
- Statisztikai adatok megjelenítése.
- Adatok mentése fájlba.
- Korábban mentett adatok visszatöltése.

## 3. A nyilvántartott lótípusok

A program két konkrét lótípust különböztet meg:

- **Iskolaló:** napi óraszámkorláttal rendelkezik.
- **Bérló:** óradíj tartozik hozzá.

A két típus közös absztrakt ősosztálya a `Lo`.

## 4. Alkalmazott technológiák

- Java 21
- Apache Maven
- JUnit 5
- IntelliJ IDEA
- Git és GitHub

## 5. A projekt felépítése

A projekt a Maven által meghatározott mappastruktúrát követi.

A főbb csomagok:

| Csomag | Feladat |
|---|---|
| `interfesz` | Interfészek |
| `kivetel` | Saját kivételosztályok |
| `letrehozo` | A Factory Method minta létrehozó osztályai |
| `megjelenites` | Konzolos felület és programindítás |
| `modell` | A lómodell és a kapcsolódó típusok |
| `szolgaltatas` | Üzleti logika |
| `tarolas` | Adatok kezelése és fájlba mentése |

A tesztek a `src/test/java` mappában találhatók.

A `docs` mappa tartalmazza az UML osztálydiagramot, annak szerkeszthető forrását, a tervezési döntéseket és a felhasználói történeteket.

## 6. Tervezési minta – Factory Method

A projekt a Factory Method tervezési mintát alkalmazza a különböző lótípusok létrehozására.

A minta célja, hogy az objektumok létrehozása elkülönüljön a konzolos menü működésétől.

A megvalósítás résztvevői:

- `LoLetrehozo` – absztrakt létrehozó osztály.
- `IskolaloLetrehozo` – iskolaló létrehozása.
- `BerloLetrehozo` – bérló létrehozása.
- `Lo` – közös absztrakt termékosztály.
- `Iskolalo` és `Berlo` – konkrét termékosztályok.

A megoldás előnye, hogy új lótípus bevezetésekor a létrehozási logika bővíthető anélkül, hogy a teljes konzolos menüt át kellene alakítani.

## 7. Adatok mentése és visszatöltése

A program az adatokat Java szerializáció segítségével menti el.

A mentést és betöltést az `AdatKezelo` osztály végzi.

Az adatok tárolási helye:

`adatok/lovak.dat`

A fájl hiányában a program üres nyilvántartással indul.

## 8. Tesztelés

A projekt JUnit 5 segítségével automatizált egységteszteket tartalmaz.

A tesztelt területek:

- `LoTeszt` – a lómodell működése és validációja.
- `LoTaroloTeszt` – a lovak nyilvántartásának műveletei.
- `LoLetrehozoTeszt` – a Factory Method létrehozó osztályai.
- `AdatKezeloTeszt` – mentés és visszatöltés.

A tesztek futtatása Maven segítségével:

```bash
mvn test
```

A projekt teljes tiszta fordítása és csomagolása:

```bash
mvn clean package
```

A tesztek legutóbbi futtatásakor **26 teszt sikeresen lefutott, hiba nélkül**.

## 9. A program futtatása

### Előfeltételek

- Java Development Kit (JDK) 21 vagy újabb.
- Apache Maven.

### A projekt letöltése

```bash
git clone https://github.com/mayermirtill/Java-Project.git
```

A projekt mappájába lépés:

```bash
cd Java-Project
```

Fordítás és csomagolás:

```bash
mvn clean package
```

A program indítható IntelliJ IDEA-ból a `megjelenites.Main` osztály futtatásával.

A program parancssorból is elindítható a fordítás után:

```bash
java -cp target/classes megjelenites.Main
```

## 10. Korlátozások

- Az alkalmazás konzolos felülettel rendelkezik.
- Az adatok helyi fájlban kerülnek tárolásra.
- Az alkalmazás nem használ adatbázist.
- A program egyetlen helyi nyilvántartás kezelésére készült.

## 11. Készítő

**Mayer Mirtill Panna**

Egyéni egyetemi projekt – Programozás 2.

Pécsi Tudományegyetem – Mérnökinformatikus BSc.