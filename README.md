<H1 align="center">Ticket Master Event Analyzer</H2>
<H4 align="center">Progetto programmazione ad Oggetti febbraio 2022</H4>

## Introduzione:
La nostra applicazione sfrutta le API della pagina TM Developer, del software "TicketMaster", fornite nell'apposita pagina "The Ticketmaster Developer Portal" per realizzare un filtro specifico di eventi. In particolare il programma può essere utilizzato solamente per  eventi in alcuni paesi degli Stati Uniti.
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

## Rotte
Per comunicare con il software l'utende deve utilizzare il servizio di Postman, all'indirizzo: "localhost:8080"; doveè necessario specificare il metodo di trasferimento dati e la rotta.

## Filtri e Stats Richiesti
Per l'invio dei parametri e quindi del filtraggio degli eventi ci è necessario solamente una rotta, cioè:
Metodo | Rotta | Descrizione
---- | ---- | ----
POST | /eventi | restituisce un JSONArray contenente: statistiche (minimo, massimo e madia degli eventi nel periodo selezionato) e lista degli eventi di uno stato o paese.

## Funzionamento
I parametri per effettuare la ricerca vengono inviati tramite il metodo "POST" di rotta "/eventi" sottoforma di file "JSON" in formato "raw"; vengon in seguito eseguiti il filtraggio e la restituzione delle statistiche (minimo, massimo e madia degli eventi nel periodo selezionato) e della lista degli eventi.

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
"stati" | New South Wales, AU; Queensland, AU; South Australia, AU; Tasmania, AU; Victoria, AU; Western Australia, AU;  New Zealand, NZ;
"generi" | Accounting/General, Action/Adventure, Actor, Added Value Vouchers, Alternative, Amusement Park, Animation, Aquarium, Aquatic Park, Aquatics, Arthouse, Artist, Athlete, Athletic Races, Audio Tour, Audio/Visual, Award Show, Badminton, Ballads/Romantic, Band, Bandy, Baseball, Basketball, Biathlon, Blues, Body Building, Boxing, CD, Campsite, Casino/Gaming, Ceremony, Chanson Francaise, Character, Charity/Benefit, Children's Festival, Children's Music, Children's Theatre, Choir, Choreographer, Chorus, Circus & Specialty Acts, Classical, Clothing, Club, Club Access, Comedian, Comedy, Community/Civic, Community/Cultural, Competition, Concert, Concession Voucher, Conductor, Convention, Country, Cricket, Cruise, Cultural, Curling, Cycling, Dance, Dance/Electronic, Dancer, Demo, Designer, Dinner Packages, Director, Documentary, Donation, Drama, Driver, Ensemble, Equestrian, Especiales, Espectaculo, Exchange, Exhibit, Expo, Extreme, Fairs & Festivals, Family, Fan Experiences, Fashion, FastLane Access, Festival, Field Hockey, Fine Art, Fitness, Floorball, Folk, Food & Drink, Football, Foreign, Gift Card, Gift Certificate, Golf, Graduation/Commencement, Group, Guide, Gymnastics, Handball, Health/Wellness, Hip-Hop/Rap, Hobby/Special Interest Expos, Hockey, Holiday, Horror, Hotel Package, Ice Rink, Ice Shows, Ice Skating, In-Store Pickup, Individual, Indoor Soccer, International Online Order, Jazz, Lacrosse, Latin, Lawn Chair Rental, League, Lecture/Seminar, Lockers, Magazine Mail Merchandise, Magic & Illusion, Magician, Martial Arts, Meal Package, Medieval/Renaissance, Membership, Merch 3rd Party Delivered, Merchandise, Merchandise Voucher, Metal, Miscellaneous, Miscellaneous Theatre, Motorsports/Racing, Mucisian, Multimedia, Museum, Music, Netball, New Age, Nonticket, Opera, Orchestra, Other, Other (inc. RV, oversized), Parade, Parking, Party/Gala, Performance Art, Performer, Pop, Premier, Priority Mail, Psychics/Mediums/Hypnotists, Puppetry, Quartet, RB, Race, Reggae, Religious, Reserved Lawn Access, Rock, Rodeo, Roller Derby, Roller Hockey, Room Package, Rugby, Science Fiction, Sightseeing/Facility, Singer/Vocalist, Ski Jumping, Skiing, Soccer, Softball, Speaker, Special Entry, Special Interest/Hobby, Spectacular, Squash, Student Festival, Subscription, Surfing, Swap Meet/Market, Swimming, TM Gift Card, TM Gift Certificate, TVN, Table Tennis, Team, Tennis, Test Event, Theatre, Ticketfast Order, Toros, Tour, Touring Show/Production, Track & Field, Transportation, Tribute Band, Troupe, UPS, Undefined, Upsell, Urban, VIP Club Access, Variety, Virtual, Volleyball, Voucher, Waterpolo, World, Wrestling, Writer, Zoo, eSports, iTunes Download
periodo | ogni periodo di tempo desiderato

## Eccezioni e Bad-Values

## JUnit Test
Per effettuare il test in JUnit sono stati utilizzati i seguenti metodi nella per ogni sua specifica classe

### Test Metodi Della Classe MinMaxAverageFilter.java
Per il testing dei metodi della classe MinMaxAverageFilter.java sono stati implementati i seguenti JUnit Test Case:

**1) dateConverterTest**

La JUnit Test Case 'dateConverterTest' contiene due test methods che verificano il corretto funzionamento del metodo dateConverter() dedito alla conversione di una stringa di testo in un oggetto della classe localDate;
in particolare:
* **testDateConverter():** Metodo per testing del metodo dateConverter(); che invoca il metodo assertEquals(), i cui parametri sono il risultato della conversione tramite il metodo dateConverter e l'oggetto di tipo LocalDate ante introdotto.
* **testDateConverterException():** Metodo per testing del metodo dateConverter(); che invoca il metodo assertThrows(), i cui parametri sono il risultato della conversione tramite il metodo dateConverter e la classe "DateTimeParseException.class" della libreria "java.time.format".

**2) MaxRipetizioneDelPeriodoTest**
La JUnit Test Case 'MaxRipetizioneDelPeriodoTest' contiene un unico test method, che verifica il corretto funzionamento del metodo maxRipetizioneDelPeriodo() che, a sua volta, è dedito al calcolo del numero di volte in cui il periodo personalizzato inserito dall'utente può essere ripetuto nell'arco di un anno;
in particolare:
* **maxRipetizioneDelPeriodoTest()** Metodo per testing del metodo maxRipetizioneDelPeriodo; che invoca il metodo assertEquals(), i cui parametri sono il risultato del metodo maxRipetizioneDelPeriodo() ed il numero di volte in cui, effettivamente, il periodo personalizzato si ripete nel corso di un anno.

**3) MinMaxAverageFilterFunctionTest**
La JUnit Test Case 'MinMaxAverageFilterFunctionTest' contiene un unico test method, che verifica il corretto funzionamento del metodo minMaxAverageFilterFunction() che, a sua volta, è dedito al calcolo del numero totale di eventi, relativi ad uno specifico Stato, che si svolgono in una specifica ripetizione del periodo di tempo personalizzato scelto dall'utente;
in particolare:
* **testMinMaxAerageFilterFunction()** Metodo per testing del metodo minMaxAverageFilterFunction che invoca il metodo assertEquals(), i cui parametri sono il risultato del metodo minMaxAverageFilterFunction() ed il corretto raggruppamento di eventi-periodo.

### Test Metodi Della Classe DatesStatistics.java
Per il testing dei metodi della classe DatesStatistics.java è stato implementato il seguente JUnit Test Case:

**1) DatesStatisticsTest**
La JUnit Test Case 'DatesStatisticsTest' contiene due test methods, che verificano il corretto funzionamento del metodo numeroEventi() che, a sua volta, è dedito al calcolo del numero totale di eventi, relativi ad uno specifico Stato, che si svolgono in uno specifico mese;
in particolare:

* **datesStatisticsTest():** Metodo per testing del metodo numeroEventi() che invoca il metodo assertEquals(), i cui parametri sono il risultato del metodo numeroEventi() ed il corretto raggruppamento di eventi-mese.
* **datesStatisticsTestNotNull():** Metodo che accerta che il vettore contenente gli eventi da raggruppare mensilmente non sia sia vuoto, invoca il metodo assertNotNull(), il cui unico parametro è il vettore di eventi da analizzare.

### Test Metodi Della Classe MinMaxAverage.java
Per il testing dei metodi della classe MinMaxAverage.java è stato implementato il seguente JUnit Test Case:

**1) SortSelectedEventsTest**
La JUnit Test Case 'SortSelectedEventsTest' contiene un'unico test Method, che verifica il corretto funzionamento del metodo sortSelectedEvents() che, a sua volta, è dedito all'ordinamento dell'array contenente il numero di eventi di uno Stato, svoltisi in un determinato mese, disponendoli dal più piccolo al più grande;
in particolare:

* **sortSelectedEventsTest():** Metodo per testing del metodo sortSelectedEvents, invoca il metodo assertEquals(), i cui parametri sono il risultato del metodo sortSelectedEvents ed un array ordinato nel modo corretto.

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
