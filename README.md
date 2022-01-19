# PavicSasuProgettoJava
## Indice
- [Introduzione](#introduzione)
- [Come usare l'applicazione](#come-usare-lapplicazione)
- [Rotte](#rotte)
   - [localhost:80/citiesWeather](#localhost80citiesWeather)
   - [localhost:80/citiesForecast](#localhost80citiesForecast)
- [Strumenti utilizzati](#strumenti-utilizzati)
- [Autori](#autori)

## Introduzione
Questo progetto si pone l'obiettivo di creare una applicazione Java che, tramite un Client come Postman, permetta all’utente di selezionare più città e confrontare in contemporanea le informazioni metereologiche. Nello specifico dati relativi a temperatura, pressione, umidità, visibilità e nuvolosità.
L’utente potrà visualizzare le previsioni attuali e future delle città, avendo la possibilità di integrare dei filtri, per selezionare fascie orarie specifiche o avere statistiche riguardanti i valori minimi, massimi, media e varianza delle varie misurazioni. 

## Come usare l'applicazione
Per utilizzare questa applicazione si deve procedere clonando questa [repository](https://github.com/giorgiapavic/PavicSasuProgettoJava.git) sul pc e importando nell’IDE Eclipse il progetto PavicSasuProgettoJava. Una volta aperto Eclipse, per avviare il programma, basta selezionare PavicSasuProgettoJava nel proprio package explorer e dare il comando Run as -> Spring Boot App (all’avvio comparirà il logo di Spring). L’applicativo permetterà di visualizzare le varie informazioni metereologiche collegandosi alle rotte (elencate successivamente) sulla rete interna all’indirizzo localhost, sulla porta 80.

## Rotte
