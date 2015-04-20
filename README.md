# REST-kurs

## Oppgave 1
Man må ha en konto på Twitter for å kunne gjøre oppgaven, så hvis man ikke har det, lag en tullekonto, eller sett deg sammen med en som har det.

`TwitterKlient.java` har i dag funksjonalitet for å koble seg til Twitter, og hente en liste med tweets.

### 1.1
Kjør `TwitterKlient` for å hente ut en liste med tweets. Følg instruksjonene på skjermen for å autentisere.

### 1.2
Legg til en metode for å følge en Twitter-bruker.

### 1.3
Legg til en metode for å slutte å følge en Twitter-bruker.

### 1.4
Legg til en metode for å tweete en melding med hashtagen #restFTW med mention til @andersem og @henrikno.
 

## Oppgave 2
`HelloWorldApplication` kjører en enkel REST-server som er bygget på Dropwizard. Den har en ressurs, `HelloWorldResource` som eksponerer en enkel teller.

### 2.1
Kjør main-metoden i `HelloWorldApplication` og gå til http://localhost:8080/hello-world. Se at verdien øker med 1 for hver refresh.

### 2.2
Endre `sayHello` til å øke med 2 for hver gang. Lag en test i `HelloWorldResourceTest` som tester dette.

### 2.3
Legg til en ny ressurs-klasse som heter `NameResource`. Legg også til `NameResourceTest` for å teste `NameResource`.

### 2.4
Legg til et `Map<Integer, String>` i `NameResource` hvor integeren er en id, og stringen er et navn. Lag en REST-metode for å legge til et navn i Mapet med en stigende id. Urlen til REST-metoden skal være `http://localhost:8080/navn`

### 2.5
Lag en REST-metode for å liste ut alle navnene i Mapet. Urlen skal være `http://localhost:8080/navn`

### 2.6
Lag en REST-metode for å liste ut navnet for en gitt id. Urlen skal være `http://localhost:8080/navn/<id>`

### 2.7
Lag en REST-metode for å endre et navn. Urlen skal være `http://localhost:8080/navn/<id>`

### 2.8
Lag en REST-metode for å slette et navn. Urlen skal være `http://localhost:8080/navn/<id>`






