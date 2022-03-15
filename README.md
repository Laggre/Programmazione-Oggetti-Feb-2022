<H1 align="center">Ticket Master Event Analyzer</H2>
<H4 align="center">Progetto programmazione ad Oggetti febbraio 2022</H4>

## Introduzione:
La nostra applicazione sfrutta le API della pagina TM Developer, del software "TicketMaster", fornite nell'apposita pagina "The Ticketmaster Developer Portal" per realizzare un filtro specifico di eventi. In particolare il programma può essere utilizzato solamente per  eventi in alcuni paesi degli Stati Uniti e del Canada che saranno specificati in seguito nei "key-value" degli stati.
Il programma genera statistiche in base alla ricerca degli eventi ed ha le seguenti funzioni:
* filtraggio degli eventi selezionando almeno uno Stato e generazione di statistiche relative.
* filtraggio degli eventi selezionando almeno un genere e generazione di statistiche relative.
* funzione di auto filtro degli stati che semplifica l'utente l'inserimento dello stati che si presume stia cercando.
* filtraggio avanzato indicando un intervallo di tempo iniziale e finale, dove verrà effettuata la raccolta delle stastistiche.

genera in seguito le statistiche:
* numero di eventi in ogni Stato
* numero di eventi con raggruppamento per genere in ogni Stato
* numero minimo, massimo e media degli eventi mensili in ogni Stato

## Informazioni importanti al fine dell'avviamento:
Per poter utilizzare l'applicazione è necessario modificare il file "APIKey.txt", riconducibile dal percorso file: OPPproject > resources; con la propria APIKey ottenuta semplicemente registrandosi al sito TM Developers (https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/).
Eseguito questo passaaggio basta semplicemente aprire il progetto da Eclipse e aggiornare la cartella OOPproject.

## Installazione
* Installare il pacchetto Spring Boot Tool 4 dal MarketPlace di Eclipse
* Avviare il debug del progetto da Eclipse come "Spring Boot application"
* Lanciare da Postman ed utilizzare le rotte che descriveremo in seguito

## Rotte
Per comunicare con il software l'utende deve utilizzare il servizio di Postman, all'indirizzo: "localhost:8080"; dove è necessario specificare il metodo di trasferimento dati e la rotta.

### Body della rotta e risposta JSON
I parametri su cui effettuare il filtraggio e le statistiche vengono dati a Spring tramite la rotta "localhost8080/eventi" in JSON, formato "raw", contenente le coppie di "key-value"; come segue in esempio:
```json
{
    "stati": ["California, US"],
    "generi": [],
    "periodo": ["2022-03-01","2022-05-01"]
}
```
Il file JSON prodotto in uscita è il seguente:
```json
{
    "statistiche periodiche di eventi": {
        "in California": {
            "minimo": 0,
            "massimo": 2,
            "media": 0.8
        }
    },
    "eventi": [
        {
            "nome": "Golden State Warriors vs. Phoenix Suns",
            "url": "https://www.ticketmaster.com/golden-state-warriors-vs-phoenix-suns-san-francisco-california-03-30-2022/event/1C005B12A59E3CBB",
            "citta": "San Francisco",
            "stato": "California",
            "paese": "United States Of America",
            "data": "2022-03-30",
            "ora": "19:00:00",
            "genere": "Basketball",
            "categoria": "NBA"
        },
        {
            "nome": "Sacramento Kings vs. Phoenix Suns",
            "url": "https://www.ticketmaster.com/sacramento-kings-vs-phoenix-suns-sacramento-california-03-20-2022/event/1C005B12BBE44813",
            "citta": "Sacramento",
            "stato": "California",
            "paese": "United States Of America",
            "data": "2022-03-20",
            "ora": "15:00:00",
            "genere": "Basketball",
            "categoria": "NBA"
        },
        {
            "nome": "PAUL McCARTNEY GOT BACK",
            "url": "https://www.ticketmaster.com/paul-mccartney-got-back-inglewood-california-05-13-2022/event/0A005C49D9E42D60",
            "citta": "Inglewood",
            "stato": "California",
            "paese": "United States Of America",
            "data": "2022-05-13",
            "ora": "19:30:00",
            "genere": "Rock",
            "categoria": "Pop"
        },
        {
            "nome": "PAUL McCARTNEY GOT BACK",
            "url": "https://www.ticketmaster.com/paul-mccartney-got-back-oakland-california-05-06-2022/event/1C005C2AB92C45B0",
            "citta": "Oakland",
            "stato": "California",
            "paese": "United States Of America",
            "data": "2022-05-06",
            "ora": "20:00:00",
            "genere": "Rock",
            "categoria": "Pop"
        }
    ],
    "n totale eventi": {
        "in California": 4
    },
    "n eventi per genere": {
        "Rock": 2,
        "Basketball": 2
    }
}
```

### Rotta /stati e risposta JSON
Tramite il metodo GET, la rotta http://localhost:8080/stati restituisce la lista JSON degli stati:

[
    "California",
    "Arizona",
    "Tennessee",
    "New York",
    "Alberta",
]

Ovvero, otteniamo un JSONArray composto da tutti i possibili Stati degli Stati Uniti e del Canada, per il filtraggio degli eventi e per il calcolo delle statistiche.

### Rotta /generi e risposta JSON
Tramite il metodo GET, la rotta http://localhost:8080/generi restituisce la lista JSON dei generi:

[
    "Accounting/General",
    "Action/Adventure",
    "Actor",
    "Added Value Vouchers",
    "Alternative",
    "Amusement Park",
    "Animation",
    "Aquarium",
    "Aquatic Park",
    "Aquatics",
    "Arthouse",
    "Artist",
    "Athlete",
    "Athletic Races",
    "..."
]

Ovvero, otteniamo un JSONArray composto da tutti i possibili generi utilizzabili per il filtraggio degli eventi.

## Filtri e Stats Richiesti
Per l'invio dei parametri e quindi del filtraggio degli eventi ci è necessario solamente una rotta, cioè:
Metodo | Rotta | Descrizione
---- | ---- | ----
POST | /eventi | restituisce un JSONArray contenente: statistiche (minimo, massimo e madia degli eventi nel periodo selezionato) e lista degli eventi di uno stato o paese.

## Chiavi e valori
Le coppie di chiavi e valori che devono essere specificate, cioè i parametri in ingresso da inserire su postman sono:
key | value
---- | ----
"stati" | : ["nome Stato, nome Paese", "...", ..]
"generi" | : ["nome genere", "...", ..]
"periodo" | : ["data iniziale, data finale"]

Valori accettabili per ogni key
key | valori accettabili
---- | ----
"stati" | California, US; Arizona, US; Tennessee, US; New York, US; Alberta, CA
"generi" | Accounting/General, Action/Adventure, Actor, Added Value Vouchers, Alternative, Amusement Park, Animation, Aquarium, Aquatic Park, Aquatics, Arthouse, Artist, Athlete, Athletic Races, Audio Tour, Audio/Visual, Award Show, Badminton, Ballads/Romantic, Band, Bandy, Baseball, Basketball, Biathlon, Blues, Body Building, Boxing, CD, Campsite, Casino/Gaming, Ceremony, Chanson Francaise, Character, Charity/Benefit, Children's Festival, Children's Music, Children's Theatre, Choir, Choreographer, Chorus, Circus & Specialty Acts, Classical, Clothing, Club, Club Access, Comedian, Comedy, Community/Civic, Community/Cultural, Competition, Concert, Concession Voucher, Conductor, Convention, Country, Cricket, Cruise, Cultural, Curling, Cycling, Dance, Dance/Electronic, Dancer, Demo, Designer, Dinner Packages, Director, Documentary, Donation, Drama, Driver, Ensemble, Equestrian, Especiales, Espectaculo, Exchange, Exhibit, Expo, Extreme, Fairs & Festivals, Family, Fan Experiences, Fashion, FastLane Access, Festival, Field Hockey, Fine Art, Fitness, Floorball, Folk, Food & Drink, Football, Foreign, Gift Card, Gift Certificate, Golf, Graduation/Commencement, Group, Guide, Gymnastics, Handball, Health/Wellness, Hip-Hop/Rap, Hobby/Special Interest Expos, Hockey, Holiday, Horror, Hotel Package, Ice Rink, Ice Shows, Ice Skating, In-Store Pickup, Individual, Indoor Soccer, International Online Order, Jazz, Lacrosse, Latin, Lawn Chair Rental, League, Lecture/Seminar, Lockers, Magazine Mail Merchandise, Magic & Illusion, Magician, Martial Arts, Meal Package, Medieval/Renaissance, Membership, Merch 3rd Party Delivered, Merchandise, Merchandise Voucher, Metal, Miscellaneous, Miscellaneous Theatre, Motorsports/Racing, Mucisian, Multimedia, Museum, Music, Netball, New Age, Nonticket, Opera, Orchestra, Other, Other (inc. RV, oversized), Parade, Parking, Party/Gala, Performance Art, Performer, Pop, Premier, Priority Mail, Psychics/Mediums/Hypnotists, Puppetry, Quartet, RB, Race, Reggae, Religious, Reserved Lawn Access, Rock, Rodeo, Roller Derby, Roller Hockey, Room Package, Rugby, Science Fiction, Sightseeing/Facility, Singer/Vocalist, Ski Jumping, Skiing, Soccer, Softball, Speaker, Special Entry, Special Interest/Hobby, Spectacular, Squash, Student Festival, Subscription, Surfing, Swap Meet/Market, Swimming, TM Gift Card, TM Gift Certificate, TVN, Table Tennis, Team, Tennis, Test Event, Theatre, Ticketfast Order, Toros, Tour, Touring Show/Production, Track & Field, Transportation, Tribute Band, Troupe, UPS, Undefined, Upsell, Urban, VIP Club Access, Variety, Virtual, Volleyball, Voucher, Waterpolo, World, Wrestling, Writer, Zoo, eSports, iTunes Download
periodo | ogni periodo di tempo desiderato

## Eccezioni e Bad-Values

I vari errori e quindi eccezioni che si possono ottenere quando si specificano i parametri a spring sono:
Key | Bad-value | Eccezione | Risposta dell'applicazione 
---- | ---- | ---- | ----
"stati" | :[] | EventiException |  "Attenzione": Non è stato inserito nessuno stato. Lista stati: [California, Arizona, Tennessee, New York, Alberta]
"stati" | :["Ney Work, US"] | EventiException | Nessun evento disponibie
"periodo" | :["2022-03-01","2022-05-01", "2022-05-03"] | EventiException | Inserire solo la data di inizio e la data di fine evento

## JUnit Test
Per il testing dei metodi della classe DatesStats.java è stato implementato il seguente JUnit Test Case:

**StatsDataTest**
La JUnit Test Case 'StatsDataTest' contiene due test methods, che verificano il corretto funzionamento del metodo numEventi() che, a sua volta, è dedito al calcolo del numero totale di eventi, relativi ad uno specifico Stato, che si svolgono in uno specifico mese;
in particolare:

* **dateStatsTest():** Metodo per testing del metodo numEventi() che invoca il metodo assertEquals(), i cui parametri sono il risultato del metodo numeroEventi() ed il corretto raggruppamento di eventi-mese.
* **dateStatsTestNN():** Metodo che accerta che il vettore contenente gli eventi da raggruppare mensilmente non sia sia vuoto, invoca il metodo assertNotNull(), il cui unico parametro è il vettore di eventi da analizzare.

## Documentazione JavaDoc

## Software Utilizzati
* L'IDE Eclipse
* Il tool Postman
* La piattaforma GitHub
* Il framework JUnit 5
* L'applicativo Javadoc
* L'applicazione Discord
* La piattaforma Stack Overflow
* Il tool Spring Inizializr
* Il toolkit JSON.simple
* il sito JSON.souceforge
* Il framework Spring
* Il progetto Spring Boot
* L'IDE Spring Tool Suite 4
* Il tool Spring Web
* Il tool Apache Maven
* Il web server locale Apache Tomcat

### Autori
Scortichini Lorenzo, Pieralisi Nicola
