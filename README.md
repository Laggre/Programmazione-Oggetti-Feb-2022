<H1 align="center">Ticket Master Event Analyzer</H2>
<H4 align="center">Progetto programmazione ad Oggetti febbraio 2022</H4>

## Introduzione:
La nostra applicazione sfrutta le API della pagina TM Developer, del software "TicketMaster", fornite nell'apposita pagina "The Ticketmaster Developer Portal" per realizzare un filtro specifico di eventi. In particolare il programma può essere utilizzato solamente per eventi in Australia e Nuova Zelanda.
Il programma genera statistiche in base alla ricerca degli eventi ed ha le seguenti funzioni:
* filtraggio degli eventi selezionando almeno uno Stato e generazione di statistiche relative.
* filtraggio degli eventi selezionando almeno un genere e generazione di statistiche relative.
* funzione di auto filtro degli stati che semplifica l'utente l'inserimento dello stati che si presume stia cercando.
* funzione di filtraggio avanzata delle statistiche, che prevede l’introduzione di un periodo ti tempo personalizzato, costituito da una data iniziale e da una data finale, entrambe nel formato yyyy-mm-dd, su cui effettuare il calcolo delle statistiche relative ad uno o più Stati selezionati.
In particolare, una volta scelto il periodo personalizzato, esso verrà ripetuto tante volte quanto è contenuto in un anno a partire dalla data iniziale scelta;
ad esempio, se il periodo è di 182 giorni (ovvero metà anno), allora esso può essere ripetuto solo due volte a partire dalla data iniziale scelta, mentre se il periodo è di 121 giorni (ovvero ⅓ di anno), allora esso può essere ripetuto tre volte a partire dalla data iniziale scelta, ecc; !!!!!!

genera in seguito le statistiche:
* numero di eventi in ogni Stato
* numero di eventi con raggruppamento per genere in ogni Stato
* numero minimo, massimo e media degli eventi mensili in ogni Stato
