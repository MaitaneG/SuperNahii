# SUPERNAAAHI

## 1. Zer da ❓
SuperNaaahi enpresak lehiaketa bat antolatu du bere langileen artean. Lehiaketa horren helburua, beraientzako garatutako jokuan puntu gehien lortzea da. Orduan, bere web orria SuperNaaahi deitzen da eta lehiaketa horren informazio guztia agertzen da. Gainera erabiltzaileak inkesta bat bete dezakete eta foroan parte hartu. 

<br/>

## 2. Baliabideak 📝
### Software-a 

##### - Visual Studio: 
ASP .NET web orrialdea garatzeko erabili dugun software-a da. *[Visual Studio-k](https://visualstudio.microsoft.com/es/downloads/)* tresna asko dauzka garapenean laguntzen duena.

![Visual Studio logo](https://user-images.githubusercontent.com/75113982/152648541-f63fcdc5-9aa9-4d0f-abeb-2cbe3303face.png)

##### - Microsoft SQL Server Managment:
*[Microsoft SQL Server Management](https://docs.microsoft.com/es-es/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver15)* erabili dugu Microsoft SQL Server-eko datubasea kudeatzeko. 

![Microsoft sql server management](https://user-images.githubusercontent.com/75113982/152648724-a36b0084-6280-4299-b986-054e1e9c273b.png)

<br/>

### Datubaseak

##### - Microsoft SQL Server:
Datu base hau erabili dugu, web orrialdearen foroaren komentarioak eta erabiltzaileek betetako inkesten informazioa gordetzeko eta gero bistaratzeko. *[Microsoft SQL Server](https://www.microsoft.com/es-es/sql-server/sql-server-downloads)* aukeratu dugu, Visual Studiok datu base hau erabiltzen duelako.

![Microsoft SQL Server](https://user-images.githubusercontent.com/75113982/152648909-a1f6023e-4a30-4d59-87ea-cff2bdac047a.png)

<br/>

## 3. Garapen teknikoa 💻
### Garapena

Visual studio erabili dugu, bere funtzionaltasuna erabilgarria delako gure beharretarako.

Gure Web orriaren  proiektua soluzio batek dituen bi proiektuz osatuta dago.

Web orriaren proiektua SuperNaaahi da. Bertan Controllerrak , Data, Modelsak, Zerbitzuak, Bistaren konponentea eta Bistekin osatua

  - **Controllerrak:** Bi Controller daude, Home karpetan dauden bistak kudeatzen dituen kontrolerra ([HomeController.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Controllers/HomeController.cs)) eta reporteak kudeatzen dituen kontrolerra ([ReportController.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Controllers/ReportController.cs))
  
  - **Data:** SuperNaaahi SQL Serverrera konektatzeko ([SuperNaaahiDbContext.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Data/SuperNaaahiDbContext.cs)).
 
  
  - **Models:** 4 Models daude, Puntuazioak egiteko modela ([PuntuazioaModel.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Models/PuntuazioaModel.cs)), inkesta egiteko modeloa ([Inkesta.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Models/Inkesta.cs)), foroa egiteko modeloa ([Foroa.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Models/Foroa.cs)) eta erroreak bistaratzeko modeloa ([ErrorViewModel.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Models/ErrorViewModel.cs))
  
  - **Services:** 3 interfaze daude, puntuazio interfazeak rest-apitik puntuak jasotzeko funtzioak zehazten ditu ([IPuntuazioaService.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Services/IPuntuazioaService.cs)), inkesta interfazeak inkestaren informazioa kudeatzeko funtzioak zehazten ditu ([IInkestaService.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Services/IInkestaService.cs)), foroa interfazeak foroaren informazioa kudeatzeko funtzioak zehazten ditu ([IForoaService.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Services/IForoaService.cs)). Horrez gain,  3 zerbitzu daude, puntuazio zerbitzuak Rest-Apitik puntuazioak jasotzen ditu ([PuntuazioaService.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Services/PuntuazioaService.cs)), inkesta zerbitzuak inkestaren informazioa kudetzen du ([InkestaService.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Services/InkestaService.cs)) eta foroa zerbitzuak  foroaren informazioa kudeatzen du ([ForoaService.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Services/ForoaService.cs)).
  
  - **ViewComponents:** 4 bista konponente daude, puntuazio guztien view-rako konponenteen view-a kudeatzen du ([PuntuazioakViewComponent.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/ViewComponents/PuntuazioakViewComponent.cs)), puntuazio onenaren  view-rako konponenteen view-a kudeatzen du ([HallOfFameViewComponent.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/ViewComponents/HallOfFameViewComponent.cs)), puntuazio txarrenaren view-rako  konponenteen view-a kudeatzen du ([HallOfShameViewComponent.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/ViewComponents/HallOfShameViewComponent.cs)), foroa view-rako konponenteen view-a kudeatzen du ([ForoaViewComponent.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/ViewComponents/ForoaViewComponent.cs))

  - **Views:** Home karpeta dago eta bertan 7 view, indexean guri buruzko informazioa dago eta inkesta betetzeko link-a ([Index.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Home/Index.cshtml)), ranking orokorra ikusteko partida guztiak ([General.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Home/General.cshtml)), puntuazio onenak dituzten 5 partida ikusiko dira ([HallOfFame.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Home/HallOfFame.cshtml)), puntuazio txarrenak dituzten 5 partida ikusiko dira ([HallOfShame.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Home/HallOfShame.cshtml)), foroan komentarioa betetzeko formularioa agertuko da ([Foroa.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Home/Foroa.cshtml)), inkestan inkesta egiteko formularioa ([Inkesta.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Home/Inkesta.cshtml)) eta pribatutazuna ([Privacy.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Home/Privacy.cshtml)).
  
    Home karpetaz gain, Shared karpeta ere badago eta honen barruan Components karpeta. Components karpetaren barruan konponente bakoitzak bere karpeta dauka. Puntuazioak karpetan ranking orokorraren taula dago ([Puntuazioak/Default.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Shared/Components/Puntuazioak/Default.cshtml)), HallOfFame karpetan puntuazio onenak dituzten 5 partiden taula dago ([HallOfFame/Default.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Shared/Components/HallOfFame/Default.cshtml)), puntuazio txarrenak dituzten 5 partiden taula dago ([HallOfShame/Default.cshtml](https://github.com/MaitaneG/SuperNahii/tree/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Shared/Components/HallOfShame)) eta Foroa karpetan txata dago ([Foroa/Default.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Shared/Components/Foroa/Default.cshtml)).
  
    Shared karpetaren barruan beste karpetak alde batera hutsita, Web orrian edozein orritan elementu berbera jartzeko ([layout.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Shared/_Layout.cshtml)), loegatzeko ([LoginPartial.cshtml](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Views/Shared/_LoginPartial.cshtml))

  - **Beste batzuk:**
      -   SuperNaaahi ConnectionStrings gure SQLServer datu basearekin konexioa egiten dugu. ([appsetting.json](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/appsettings.json))
      -   Gure proiektua modu egoki baten dokumentatzeko ([docfx.json](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/docfx.json))
      -   Depemdentziak injektatzeko, sesioak erabiltzeko ([Startup.cs](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/SuperNaaahi/Startup.cs))

Beste proiektua Reportea da. Bertan bi reporte daude:

  -Ranking orokorra ([SuperNaaahiRankingOrokorReport.rdlc](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/Reportea/SuperNaaahiRankingOrokorReport.rdlc))
  
  -HallOfFame/HallOfShame ([SuperNaaahiReport.rdlc](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/SuperNaaahi/Reportea/SuperNaaahiReport.rdlc))

<br/>

### Usagarritasun irizpideak

- Zutabe bakarra erabili dugu bat baino gehiago erabili beharrean.
- Erabiltzaileentzako foroa egin dugu beraien iritzia emateko.
- Kontrasteak erabili ditugu klikatzen diren objetuentzako
- Formularioetan ahalik eta eremu gutxien jarri ditugu

<br/>

### Funtzionaltasuna


Gure Web orriko index printzipala hau da eta bertan behean inkesta betetzeko linka daukagu.

![Gure Web orriko index printzipala hau da:](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20085355.png)

Inkesta betetzeko logeatu egin behar duzu.

![Login](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20092214.png)
Logeatu eta gero inkesta betetzeko formularioa agertuko da.

Bi aukera daude:

-**Inkesta betetzea**

-**Inkeste beteta badago aldaketak egitea**

![Inkesta](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20094508.png)

Menu bat daukagu bost aukerekin: Ranking orokorra, HallOfFame, HallOfShame, Foroa eta Txotenak.

#### 1. Ranking orokorra:

Ranking orokorrean partida guztiak agertuko dira jokalari izena, puntuak eta datarekin.

![Ranking orokorra](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20091006.png)

#### 2. HallOfFame:

Puntuazio onenak dituzten 5 partida agertuko dira.

![Hall of fame](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20091449.png)

#### 3. HallOfShame:

Puntuazio txarrenak dituzten 5 partida agertuko dira.

![Hall of shame](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20091902.png)

#### 4. Foroa:

Foroa betetzeko derrigorrez logeatu egin behar da. Logeatu eta gero, Foroa agertzen da. Eskubian formulario bat dago foroa egiteko eta ezkerrean berriz, foroa ikusteko formularioa. Guk idazten dugun komentarioa gris ilunez agertuko da eta beste langile batek idatzi duen komentarioa gris argiz.

![Foroa](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20092431.png)

#### 5. Txostena:

Txostenetan bi txosten ditugu bat 5 partida puntuazio onenekin eta 5 partida puntuazio txarrenekin.Bigarren txostena berriz, ranking orokorra.

HallOfFame/HallOfShame Txostena:

![HallOfFame txostena](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20093407.png)

Ranking Orokorraren Txostena:

![Ranking Orokorraren Txostena](https://github.com/MaitaneG/SuperNahii/blob/main/Visual(Interfaze)/Kapturak/Captura%20de%20pantalla%202022-02-07%20093919.png)


<br/>

## 4. Iturriak 📌
  - [Microsoft-eko dokumentazioa](https://docs.microsoft.com/es-es/aspnet/mvc/overview/getting-started/introduction/getting-started)
  
  - [**gavilanch2** YouTube-eko kanaleko kurtso bat](https://www.youtube.com/watch?v=YzC-FYg66xA&list=PL0kIvpOlieSNWR3YPSjh9P2p43SFnNBlB)
