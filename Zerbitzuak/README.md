# PostgreMongoKonexioak

## 1. Zer da ❓

Aplikazio honek Android-eko SQLite datubasea eta PostgreSQL-eko eta MongoDB-eko datubasea konekatzen du socket batzuk erabiliz informazioa bidaltzeko.

<br/>

## 2. Baliabideak 📝
### Software-a 

##### - Eclipse

Aplikazioa garatzeko erabili dugun software-a da. *[Eclipserekin](https://www.eclipse.org/downloads/)* garatu zen beste aplikazioa ez bezala, aplikazio honekin ez du pluginik erabili.

![Eclipsen](https://user-images.githubusercontent.com/75113982/151692541-db59c8c8-dcf5-4e1b-beb4-beef3deb0cf6.png)

<br/>

##### - MongoDB Compass:

*[MongoDB Compass](https://www.mongodb.com/products/compass)* erabili dugu Mongoko datubasea kudetzeko.

![MongoDB Compass logo](https://user-images.githubusercontent.com/75113982/151692742-415e9507-7019-4d1b-b945-fdf5c0a7fc68.png)

<br/>

##### - DBeaver Community:

*[DBeaver Community](https://dbeaver.io/)* erabili dugu PostgreSQL datubasea kudetzeko.

![DBeaver Community logo](https://user-images.githubusercontent.com/75113982/152296737-716a8112-8469-458c-b6cf-fa07d4598992.png)

<br/>

### Datubaseak

##### - MongoDB:

*[MongoDB](https://docs.mongodb.com/)* datubasea erabili dugu, REST API-ak irakurtzeko. Aplikazio honek SQLiten dagoen informazioa MongoDB-ra igoko du.

![MongoDB logo](https://user-images.githubusercontent.com/75113982/151693035-14ce5dc9-5b22-499e-8531-50bb79425db0.png)

##### - PostgreSQL: 
Odook erabiltzen duen datubasea da. Bertan langileen eta puntuazioen informazioa dago. Aplikazio honekin Postgres-etik erabiltzaileen datuak pasatzen dira SQLite-ra eta gero puntuazioak *[PostgreSQL-ra](https://www.postgresql.org/)* (konexioa dagoenean)

![PostgreSQL logo](https://user-images.githubusercontent.com/75113982/151692026-094271f1-ff91-49c6-a708-dbeeb58b9a14.png)

<br/>

## 3. Garapen teknikoa 💻
### Garapena
Garatu dugun aplikazioa PostgreMongoKonexioak deitzen da eta aplikazio honek egiten duena hau da: Android-eko SQLite datubasea eta PostgreSQL-eko eta MongoDB-eko datubasea konekatzea socket batzuk erabiliz informazioa bidaltzeko.

Aplikazio honek socket bat erabiltzen du informazioa elkar bidaltzeko. Baldin eta zer mezu jasotzen duen aplikazioa, android-eko aplikaziotik, gauza bat edo beste bat egingo du. Bezeroa konektatzen den bakoitzean, hari bat sortuko du eta honek socket bat zabalduko du, egin beharrekoa egiteko. Proiektua horrela dago banatuta: 

  - **com.example.postgremongokonexioak:** Karpeta honetan, Lau klase daude: KonexioakAplication.java, KonexioaMongo.java, KonexioaPostgre.java eta ZerbitzariHaria.java. 

<br/>

### Diagrama

<br/>

### Funtzionaltasuna 

Aplikazio honek Socket bat zabalik edukiko du, eta bezero baten zain egongo da. Behin bezero bat konektatzen denean, bezeroaren mezu baten zain egongo da. Bezeroa konektatzen den bakoitzeko, hari bat sortu eta hasten du. Baldin eta zer mezu jasotzen duen, gauza bat edo beste bat egingo du:

  - **"Erabiltzaileak bidali"**: hau jasotzean, PostgreSQL datubasera konektatzen da eta erabiltzaile guztien informazioa jasotzen du eta android-era bidaltzen dio.
  - **Puntuazioen string-a**: puntuazio bat edo asko jasotzen duenean, string hori banatu egiten du puntuazioetan eta PostgreSQL-ra eta MongoDB-ra igotzen du.

<br/>

## 4. Iturriak 📌
  - *[Klaseko proiektua](https://elearning20.hezkuntza.net/012053/course/view.php?id=220)* --> Socket-ena egiteko
  - *[MongoDB-ren dokumentazioa](https://elearning20.hezkuntza.net/012053/course/view.php?id=220)* --> Mongo-ren konexioak egiteko
  
