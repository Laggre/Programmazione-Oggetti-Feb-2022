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

## Funzionamento
I parametri per effettuare la ricerca vengono inviati tramite il metodo "POST" di rotta "/eventi" sottoforma di file "JSON" in formato "raw"; vengon in seguito eseguiti il filtraggio e la restituzione delle statistiche (minimo, massimo e madia degli eventi nel periodo selezionato) e della lista degli eventi.

## Chiavi e valori
Le coppie "key":"value" che devono essere specificate, cioè i parametri in ingresso da inserire su postman sono:
key | value
---- | ----
"stati" | : ["nome Stato, nome Paese", "...", ..]
"generi" | : ["nome genere", "...", ..]
"periodo" | : ["data iniziale, data finale"]
