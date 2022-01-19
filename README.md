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
Il programma è in grado di definire le seguenti rotte:
| Metodo | Rotta | Descrizione |
|:--------------|:-------------:|:--------------|
| POST | /citiesWeather | Ottiene la previsione attuale di tutte le città scelte|
| POST | /citiesForecast | Ottiene la previsione futura delle città scelte con la possibilità di integrare filtri e statistiche |

### localhost:80/citiesWeather
Questa rotta restituisce un JSONArray contenete i JSONObject che riportano le infomazioni di previsione attuale (la data, la temperatura, la pressione, l'umidità, la visibilità e la nuvolosità)
L’API deve essere richiamata con il metodo HTTP POST e il body deve avere un oggetto JSON di questo tipo:
```json
{
    "cities" : ["Rome,IT" , "Berlin,DE"]
}
```
NOTA:
1. Nell'esempio sono state scelte due città ma è possibile selezionarne a piacimento
2. Quando si sceglie una città è necessario inserire la sigla del Paese corrispondente

Cliccando su "SEND" in alto a destra, il programma verrà lanciato e verrà fornito all'utente il seguente JSON:
```json
{
    "Rome,IT": [
        {
            "date": "2022-01-19T10:16:16.000+00:00",
            "cloud": 40.0,
            "visibility": 10000.0,
            "temperature": 9.63,
            "humidity": 69.0,
            "pressure": 1031.0
        }
    ],
    "Berlin,DE": [
        {
            "date": "2022-01-19T10:08:52.000+00:00",
            "cloud": 40.0,
            "visibility": 10000.0,
            "temperature": 4.49,
            "humidity": 83.0,
            "pressure": 1020.0
        }
    ]
}
```
### localhost:80/citiesForecast
Questa rotta restituisce un JSONArray contenete i JSONObject che riportano le infomazioni di previsione futura con possibilità di inserire filtri e statistiche.
L’API deve essere richiamata con il metodo HTTP POST e il body deve avere un oggetto JSON di questo tipo:
```json
{
    "cities" :["Rome,IT" , "Berlin,DE"] ,
    "days" : 2 ,
    "interval" : "13:00->18:00" ,
    "stats" : true
}
```
Cliccando su "SEND" in alto a destra, il programma verrà lanciato e verrà fornito all'utente il seguente JSON: 
```json
{
    "cities": [
        {
            "city": "Rome",
            "stats": [
                {
                    "min": {
                        "cloud": 0.0,
                        "temperature": 10.99,
                        "humidity": 60.0,
                        "pressure": 1019.0
                    },
                    "max": {
                        "cloud": 94.0,
                        "temperature": 11.81,
                        "humidity": 73.0,
                        "pressure": 1031.0
                    },
                    "var": {
                        "cloud": 1798.1875,
                        "temperature": 0.08736875000000008,
                        "humidity": 27.5,
                        "pressure": 26.0
                    },
                    "medie": {
                        "cloud": 41.75,
                        "temperature": 11.3575,
                        "humidity": 67.0,
                        "pressure": 1025.0
                    }
                }
            ],
            "list": [
                {
                    "date": "Wed Jan 19 13:00:00 CET 2022",
                    "cloud": 0.0,
                    "visibility": 10000.0,
                    "temperature": 10.99,
                    "humidity": 60.0,
                    "pressure": 1031.0
                },
                {
                    "date": "Wed Jan 19 16:00:00 CET 2022",
                    "cloud": 0.0,
                    "visibility": 10000.0,
                    "temperature": 11.37,
                    "humidity": 64.0,
                    "pressure": 1029.0
                },
                {
                    "date": "Thu Jan 20 13:00:00 CET 2022",
                    "cloud": 94.0,
                    "visibility": 10000.0,
                    "temperature": 11.81,
                    "humidity": 71.0,
                    "pressure": 1021.0
                },
                {
                    "date": "Thu Jan 20 16:00:00 CET 2022",
                    "cloud": 73.0,
                    "visibility": 10000.0,
                    "temperature": 11.26,
                    "humidity": 73.0,
                    "pressure": 1019.0
                }
            ]
        },
        {
            "city": "Berlin",
            "stats": [
                {
                    "min": {
                        "cloud": 43.0,
                        "temperature": 0.49,
                        "humidity": 54.0,
                        "pressure": 1015.0
                    },
                    "max": {
                        "cloud": 80.0,
                        "temperature": 4.71,
                        "humidity": 79.0,
                        "pressure": 1020.0
                    },
                    "var": {
                        "cloud": 213.5,
                        "temperature": 3.4802187499999997,
                        "humidity": 144.25,
                        "pressure": 3.6875
                    },
                    "medie": {
                        "cloud": 64.0,
                        "temperature": 2.8125,
                        "humidity": 66.5,
                        "pressure": 1017.25
                    }
                }
            ],
            "list": [
                {
                    "date": "Wed Jan 19 13:00:00 CET 2022",
                    "cloud": 58.0,
                    "visibility": 10000.0,
                    "temperature": 4.71,
                    "humidity": 79.0,
                    "pressure": 1020.0
                },
                {
                    "date": "Wed Jan 19 16:00:00 CET 2022",
                    "cloud": 80.0,
                    "visibility": 10000.0,
                    "temperature": 4.58,
                    "humidity": 78.0,
                    "pressure": 1018.0
                },
                {
                    "date": "Thu Jan 20 13:00:00 CET 2022",
                    "cloud": 43.0,
                    "visibility": 10000.0,
                    "temperature": 1.47,
                    "humidity": 55.0,
                    "pressure": 1015.0
                },
                {
                    "date": "Thu Jan 20 16:00:00 CET 2022",
                    "cloud": 75.0,
                    "visibility": 10000.0,
                    "temperature": 0.49,
                    "humidity": 54.0,
                    "pressure": 1016.0
                }
            ]
        }
    ]
}
```
NOTA:
- ```“days”``` è un filtro che può essere inserito per selenzionare di quanti giorni futuri avere il forecast

- ```“interval”``` è un filtro che può essere inserito per selezionare una fascia oraria (con previsioni ogni 3 ore)

- ```“stats”``` può essere inserito se si voglioni visualizzare le statistiche di minimi,massimi,media,varianza delle varie misurazioni


