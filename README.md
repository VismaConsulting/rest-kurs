# REST-kurs

## Oppsett

### Nedlasting
Last ned dette repositoriet til din PC. Det kan du gjøre på noen forskjellige måter. I alle tilfeller må du legge prosjektmappen i workspacet til IDEen din.

1. Laste ned zip-filen, og pakk den ut i en mappe som Eclipse eller IntelliJ kan finne.
1. Klone med git. `git clone https://github.com/VismaConsulting/rest-kurs.git` eller `git clone git@github.com:VismaConsulting/rest-kurs.git`
1. Sjekke ut med subversion: `svn co https://github.com/VismaConsulting/rest-kurs`

### Importer
Nå har du kildekoden på maskinen din, og da må du bare importere den til din IDE.

#### Eclipse
Kjør `mvn eclipse:eclipse` og importer inn i Eclipse.

#### IntelliJ Idea
1. Åpne IntelliJ. Velg File -> Open, og velg `pom.xml` i rest-kurs-mappen.

### Bygg
Kjør `mvn clean install` for å laste ned avhengigheter, bygge prosjektet og kjøre alle testene.

## Oppgave 1: Bruke et API
Man må ha en konto på Twitter for å kunne gjøre oppgaven, så hvis man ikke har det, lag en tullekonto, eller sett deg sammen med en som har det.

`TwitterKlient.java` har i dag funksjonalitet for å koble seg til Twitter, og hente en liste med tweets.

### 1.1
Kjør `TwitterKlient` for å hente ut en liste med tweets. Følg instruksjonene på skjermen for å autentisere.

### 1.2
Legg til en metode for å følge en Twitter-bruker.

### 1.3
Legg til en metode for å slutte å følge en Twitter-bruker.

### 1.4
Legg til en metode for å tweete en melding med hashtagen #restFTW med mention til `@andersem` og `@alfsimen`.


## Oppgave 2: Lage et eget API
`HelloWorldApplication` kjører en enkel REST-server som er bygget på Dropwizard. Den har en ressurs, `HelloWorldResource` som eksponerer en enkel teller.

### 2.1
Kjør main-metoden i `HelloWorldApplication` og gå til http://localhost:8080/hello-world. Se at verdien øker med 1 for hver refresh.

### 2.2
Endre `sayHello` til å øke med 2 for hver gang. Lag en test i `HelloWorldResourceTest` som tester dette.

### 2.3
Legg til en ny klasse `ColourResource` i samme mappe som `HelloWorldResource`. Legg `ColourResource` til i `HelloWorldApplication.run()` for at applikasjonen skal eksponere ressursen.
Legg også til `ColourResourceTest` i samme mappe som `HelloWorldResourceTest` for å teste `ColourResource`.

### 2.4
Legg til et `Map<Integer, String>` i `ColourResource` hvor integeren er en id, og stringen er en farge.
Lag en POST REST-metode for å legge til en farge i Mapet med en stigende id. Urlen til REST-metoden skal være `http://localhost:8080/farge`
Lag en test for denne metoden i `ColourResourceTest`.

### 2.5
Lag en GET REST-metode for å liste ut alle fargene i Mapet. Urlen skal være `http://localhost:8080/farge`.
Lag en test for denne metoden i `ColourResourceTest`.

### 2.6
Lag en GET REST-metode for å liste ut fargen for en gitt id. Urlen skal være `http://localhost:8080/farge/<id>`
Lag en test for denne metoden i `ColourResourceTest`.

### 2.7
Lag en PUT REST-metode for å endre en farge. Urlen skal være `http://localhost:8080/farge/<id>`
Lag en test for denne metoden i `ColourResourceTest`.

### 2.8
Lag en DELETE REST-metode for å slette en farge. Urlen skal være `http://localhost:8080/farge/<id>`
Lag en test for denne metoden i `ColourResourceTest`.

## Oppgave 3: Kall mot en tesla
Tesla sitt API gir tilgang til en del informasjon om de kjøretøyene man eier og lar deg utføre noen fysiske ting med bilen.
API-url'er finnes på http://docs.timdorr.apiary.io/

### 3.1
Legg til en metode for å hente ut en liste over alle kjøretøy som hører til eieren.

### 3.2
Legg til en metode for å hente ut statusen (vehicle_state) til bilen.

### 3.3
Legg til en metode for å blinke lysene.

### 3.4
Legg til en metode som åpner bagasjerommet.

## Oppgave 4: Lys opp i klasserommet
Her skal du bruke HueKlient til å styre lyspærene vi har satt opp.
Les om APIene på http://www.developers.meethue.com/philips-hue-api (Du må registrere deg for å se URLene du kan bruke)
Lær av toggleAllLights for å kunne sette state på pærene.

### 4.1
Få en av lyspærene til å lyse i en valgfri farge.

### 4.2
Få alle tre lyspærene til å lyse i forskjellige farger.

### 4.3
Få en lyspære til å forandre farge fra blå til rød til grønn.

### 4.4
Gjør andre kule ting med lyspærene.

## Oppgave 5: Post MEME på Twitter

Ta utgangspunkt i MemeKlient for å løse følgende oppgaver.

### 5.1
Bruk [memegenerator.net](http://version1.api.memegenerator.net/) sitt API til å lage et bilde med en morsom tekst.

### 5.2
Lag en ny metode i TwitterKlient for å poste bildet fra 5.1
