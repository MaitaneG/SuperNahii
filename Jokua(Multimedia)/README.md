# SuperNaaahiGame

## 1. Zer da ❓

Aplikazioa hau android-eko joku bat da. Android Studiorekin garatuta, java lenguaian.

<br/>

## 2. Baliabideak 📝

### Software-a 

##### - Android Studio: 
Aplikazio hau erabiltzen da android-eko aplikazioak garatzeko. *[Android Studio](https://www.sqlite.org/index.html)* gauza asko eskaintzen ditu garatzaileari eta aurrerago azalduko dugu nola garatu dugun.

![Android logo](https://mir-s3-cdn-cf.behance.net/project_modules/disp/a9326d72465217.5be8ae1c0a8a7.png)

##### - Pixelart web orria: 
Web orri hau erabili dugu, jokuaren grafikoak diseinatzeko. *[Pixelart-en](https://www.pixilart.com/)* pixelez-pixelez margotzen duzu marrazkiak.

<br/>

![Pixel art logo](https://www.pixilart.com/images/public/logo_pixilart_simple_black.png?Ver=1.1)

<br/>

### Datubaseak
##### - SQLite: 
*[SQLite](https://www.sqlite.org/index.html)* datubasea erabili dugu datuak lokalean gordetzeko. Hau da, puntuazioak eta jastotako erabiltzaileen informazioa hor gordeko da, eta konexioa dagoenean, puntuazioak igoko dira eta datu basean dagoen informazioa ezabatuko da.

![SQLite logo](https://user-images.githubusercontent.com/75113982/151691713-92c56147-1c92-47f5-9540-f6220007296b.png)

##### - PostgreSQL: 
Odook erabiltzen duen datubasea da. Bertan langileen eta puntuazioen informazioa dago. Guk garatutako beste aplikazio batekin Postgres-etik erabiltzaileen datuak pasatzen dira SQLite-ra eta gero puntuazioak *[PostgreSQL-ra](https://www.postgresql.org/)* (konexioa dagoenean)

![PostgreSQL logo](https://user-images.githubusercontent.com/75113982/151692026-094271f1-ff91-49c6-a708-dbeeb58b9a14.png)

<br/>

## 3. Garapen teknikoa 💻
### Garapena

<br/>

### Diagrama

Lehenengoz, jokoaren mekanika egin genuen: Pertsonaiak diseinatu eta dagokion klaseak sortu, erabiltzailea erabili egingo zuen pertsonaiaren saltoa eta makurketa, fondoaren argazkia, errepikapena eta abiadura, azkenengoz, beste pertsonaien irteera ausazkoa egitea. 

Jokuaren basea egin ondoren, hau hobetzea eta falta ziren elementuak egitea jarraitu genuen: Puntuazioa, pertsonaiaren saltoa eta makurketa jolasaren azkartasunarekin bat egitea eta game-over zatia.

Jokuaren ideia sortu eta gero, datu basearen konexioa, erabiltzaileak hartu, hauen loginaren funtzionalitatea, erabiltzailea ateratako puntuazioa gordetzea eta datu basera konexio berri bat bidaltzea egin genuen.

SuperNaaahiGame hiru karpetatan banatuta dago:

1-Konexioa:
Karpeta hau, klase bakar bat du, eta bere izenak dioen bezala, Konexio klasea, konexioaz arduratzen den klasea da. Lehenengoz, Ip-a eta portua deklaratzen du. Honen bidez, datu basearekin konexioa egiten du eta erabiltzaileak hartzen ditu logina egiteko.

2-Model:
Model karpeta, jokoaren barruan egiten duen metodoak eta objetuak daude. Honen barruan, Background, Demonico, JimCarrey, Puntuazioa, Rodolfo eta User klaseak daude. Objetu eta metodo hauek, gero Game View klasean erabiliko dira jokuaren funtzionaltasuna osatzeko.

3-View:
Azkenengoz, view karpetan, GameActivity, GameView, Logina, Main Activity eta PerdisteActivity klaseak daude. Lehenengoz, logina daukagu, non erabiltzailea bere korreo eta pasahitza jarri behar du logeatzeko eta menu printzipalan sartzeko. Gero, Main Activity-a menu printzipalaz arduratzen da, hau da jolasa martxan jartzen duen activity-a. Jolasa GameActivity-an exekutatzen da, honek jolasaren puntuak eta mugikorraren erresoluzioa hartzen du. GameActivity-aren barruan, GameView klasea irudikatzen da, non jolasaren exekuzio guztia gertatzen da. Partida bat jokatu ondoren, PerdisteActivity-ra bidaltzen du, hemen, erabiltzaileak partidaren puntuazioa ikusi ahal du eta partida berri bat jolasteko aukera du edo menu printzipalera bidali bere datuak gordetzen prosezu honetan.

<br/>

### Funtzionaltasuna
Joku hau jolasteko SuperNaaahi enpresaren langile bat izan behar zara. Horregatik, jokua zabaltzen duzunean, zure korreoa eta pasahitza sartu behar duzu, jakitzeko enpresaren langilea zaren edo ez. Login-eko pantailan zaudenean eta konexioa dagoenean, erabiltzaile guztiak gordeko dira SQLiten eta SQiten dauden puntuazioak igoko dira PostgreSQL-ra eta MongoDB-ra.

Behin zure korreoarekin sartzen zarenean, kargatzeko pantaila agertuko da. Bertan musika kentzeko edo jartzeko botoia agertuko da, eta gainera jokua hasteko botoia.

Jokuaren pertsonai nagusia orein bat da eta hainbat etsai agertuko dira eta sahiestu behar dira, salto egiten eta makurtzen. Etsaiak Grinch-ak eta deabruak dira. Behin, oreinak Grinch-a edo deabrua ikutzen duenean jolasa bukatzen da, eta Game Over pantailara joango da.

Game Over pantailan puntuazioak igoko dira zerbitzarira konexioa badago, eta ez badago SQLiten gordeko dira, konexioa dagoenean igotzeko. Pantaila honetan bi aukera izango dituzu: berriro jolastea edo login pantailara joatea.

<br/>

## 4. Iturriak 📌
- [Android-eko dokumentazioa](https://developer.android.com/docs)

- [Hey Let's go-ren bideoak](https://www.youtube.com/playlist?list=PLsOU6EOcj51e7YesVnTrEtvJDD016p9oS)
