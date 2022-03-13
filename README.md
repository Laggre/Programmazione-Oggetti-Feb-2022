<H1 align="center">Ticket Master Event Analyzer</H2>
<H4 align="center">Progetto programmazione ad Oggetti febbraio 2022</H4>

## Introduzione:
La nostra applicazione sfrutta le API della pagina TM Developer, del software "TicketMaster", fornite nell'apposita pagina "The Ticketmaster Developer Portal" per realizzare un filtro specifico di eventi. In particolare il programma può essere utilizzato solamente per eventi in Australia e Nuova Zelanda.
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

### Test Metodi Della Classe DatesStatistics.java

### Test Metodi Della Classe MinMaxAverage.java

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
