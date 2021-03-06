# REST_API_SuperNaaahi

## 1. Zer da ❓

Aplikazioa hau web zerbitzu bat da non MongoDB datubasetik informazioa jasotzen du. 

<br/>

## 2. Baliabideak 📝

### Software-a 

##### - Eclipse

Aplikazioa garatzeko erabili dugun software-a da. Gainera *[Eclipsen](https://www.eclipse.org/downloads/)* 
Spring-eko plugina instalatu dugu

![Eclipsen](https://user-images.githubusercontent.com/75113982/151692541-db59c8c8-dcf5-4e1b-beb4-beef3deb0cf6.png)

<br/>

##### - MongoDB Compass:

*[MongoDB Compass](https://www.mongodb.com/products/compass)* erabili dugu Mongoko datubasea kudetzeko.

![MongoDB Compass logo](https://user-images.githubusercontent.com/75113982/151692742-415e9507-7019-4d1b-b945-fdf5c0a7fc68.png)

<br/>

### Datubaseak 

##### - MongoDB:

*[MongoDB](https://docs.mongodb.com/)* datubasea erabili dugu, REST API-ak irakurtzeko. SQLitetik jasoko du informazio guztia. 

![MongoDB logo](https://user-images.githubusercontent.com/75113982/151693035-14ce5dc9-5b22-499e-8531-50bb79425db0.png)

<br/>

### Framework-ak

##### - Spring:

*[Spring-eko](https://spring.io/)* *[Spring boot](https://spring.io/projects/spring-boot)* erabili dugu web aplikazio bat erabiltzeko.

![Spring logo](https://user-images.githubusercontent.com/75113982/151693228-b6f7f83e-2e3b-4e98-bdda-68ee3626a241.png)

![Spring boot logo](https://user-images.githubusercontent.com/75113982/151693274-c8fc6d55-c44c-43cf-883a-09402ca6d92c.png)

<br/>

### API-ak

##### - Swagger:

*[Swagger](https://swagger.io/tools/swaggerhub/?&utm_medium=ppcg&utm_source=aw&utm_term=swagger&utm_content=511173019641&utm_campaign=SEM_SwaggerHub_PR_EMEA_ENG_EXT_Prospecting&awsearchcpc=1&gclid=Cj0KCQiAi9mPBhCJARIsAHchl1yPtZe1HLLCBcUDyq6WZdyXKC-NQKZkq-ax4C4JFgmrO-_ASH8ZtiEaAkKYEALw_wcB&gclsrc=aw.ds)* erabili dugu gure REST API-aren dokumentazioa eta proba kasuak sortzeko.

![Spring boot logo](https://user-images.githubusercontent.com/75113982/151693411-b6408fb1-a16d-427e-a43d-fbdaaef4c18d.png)

<br/>

## 3. Garapen teknikoa 💻
### Garapena
Spring framework-a erabili dugu, bere funtzionaltasun bat oso erabilgarria delako gure beharretarako: Spring boot. Spring boot-ekin Web zerbitzuak erraz egin dezakegu.

Proiektua hainbat karpetetan banatuta dago:

  - **eus.dam.uni:** hor Aplikazio orokorra ([RestApiApplication.java](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/REST_API_SuperNaaahi/src/main/java/eus/dam/uni/RestApiApplication.java)), Mongoren konexioa ([SpringConfiguration.java](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/REST_API_SuperNaaahi/src/main/java/eus/dam/uni/SpringConfiguration.java)) eta SpringFox-ren konfigurazioa ([SpringFoxConfig.java](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/REST_API_SuperNaaahi/src/main/java/eus/dam/uni/SpringFoxConfig.java)) daude:
    - *RestApiApplication-en* ***@SpringBootApplication*** anotazioa jarri dugu, aplikazioak jakitzeko web zerbitzua exekutatzen duen klasea hori dela. 
    - *SpringConfiguration-en* ***@Configuration*** anotazioa jarri dugu bertan konfigurazioak egiten direlako. Gainera, ***@Bean*** jarri dugu metodo batean Bean objektu bat bueltatzen dio Spring-eko kontenedoreari. 
    - *SpringFoxConfig-en* bi anotazio hauek ditu: ***@Configuration*** ***@EnableSwagger2***. Gainera, ***@Bean*** jarri dugu metodo batean.
  
  - **eus.dam.uni.controller:** bertan REST zerbitzuaren kontroladorea dago. [PuntuazioaController.java-ean](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/REST_API_SuperNaaahi/src/main/java/eus/dam/uni/controller/PuntuazioaController.java) hainbat GET operazio daude. Kontroladorea egiteko anotazio hauek jarri behar dira: ***@RestController*** eta ***@RequestMapping("/")***. Gero GET operazio bakoitzeko ***@GetMapping("")*** jarri behar da.
  
  - **eus.dam.uni.dao:** bertan DAO-a dago. [PuntuazioDAO.java-a](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/REST_API_SuperNaaahi/src/main/java/eus/dam/uni/dao/PuntuazioaDAO.java) datuak kudeatzen duenez, ***@Repository*** anotazioa jarri behar da. Datu guztiak gordetzen duen metodoari ***@PostConstruct*** bat jarri diogu. Bean-a sortu bezain laster datuak kargatzeko. Gainera MongoClient objektua autoinjektatu dugu ***@Autowired*** erabiliz 
  
  - **eus.dam.uni.model:** bertan puntuazioen pojoa dago. [Puntuazioa.java](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/REST_API_SuperNaaahi/src/main/java/eus/dam/uni/model/Puntuazioa.java) klasea hainbat atributu, bi konstruktore  eta getter-ak eta setter-ak daude 
  
###  **Swagerrarekin izan ditugun arazoak:**

**Swagerrarekin izan ditugun arazoak:**
 
Dependentzi hauek jarri 

![Dependentziak](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/Captura%20de%20pantalla%202022-02-08%20093654.png)

Swagger konfigurazioan bi anotazio jarri

![SwaggerControler](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/Captura%20de%20pantalla%202022-02-08%20093505.png)

Baina errore honek irteten zigun

![Errorea](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/Captura%20de%20pantalla%202022-02-08%20092041.png)

**Konpontzeko:**
Application properties-en spring.mvc.pathmatch.matching-strategy=ant-path-matcher jarri.
 
  
<br/>

### Diagramak

#### REST_API_SuperNaaahi
![Diagrama](https://github.com/MaitaneG/SuperNahii/blob/main/Datu%20Atzipena/REST_API_SuperNaaahi_Diagrama.svg)

<br/>

### Funtzionaltasuna
REST API-a MongoDB-tik puntuazioen datuak irakurtzen du. Web zerbitzu hau, hainbat operazio egiten du jasotako informazioarekin: 
  - **/puntuazioak:** puntuazio guztiak bueltatzen du.
  - **/puntuazioak/hallOfFame:** bost puntuazio handienak bueltatzen du.
  - **/puntuazioak/hallOfShame:** bost puntuazio txikienak bueltatzen du.
  - **/puntuazioak/puntuazioKopurua:** puntuazio guztien kopurua bueltatzen du.

Gainera Swagger-a konfiguratu dugu, horrela gure REST API-ak dituen funtzionaltasunak ikusi eta konprobatu daiteke.

<br/>

## 4. Iturriak 📌
- [Openwebinars-eko REST API-ko garapenaren garapena](https://openwebinars.net/cursos/api-rest-spring-boot/)
- [MongoDb dokumentazioa](https://docs.mongodb.com/)
