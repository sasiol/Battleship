## JavaFX Hello world

### Eclipsellä

* Asenna Java (mielellään versio 11, mutta versiot 10 tai 8 voivat myös toimia)
  * Versio 8 on vielä tuettu
  * Versioden 1-7 ja 9-10 tuki on virallisesti loppunut

* Asenna Eclipse
  * versio: Eclipse IDE for Java Developers 
  * testattu versiolla 4.10 / 2018-12

* Varmista että Eclipseen on asennettu Eclipse Egit (git-tuki) ja Eclipse m2e (Maven-tuki).    
  * Jos jompi kumpi puuttuu, etsi netistä ohjeet näiden asentamiseksi
  * pluginien pitäisi olla 2018-12 Java-versiossa 

* Käynnistä Eclipse
  * Valitse ylävalikosta File
  * -> Import
  * -> Git -> Projects from Git -> Next -> Clone URI -> Next
  * kohtaan URI syötä: https://gitlab.utu.fi/jmjmak/fxhello
  * voit tallentaa utu-tunnukset user/password -kohtiin alle, jos haluat myöhemmin säästää kirjoitusvaivaa, mutta jos epäilet Eclipsen/koneen tietoturvaa, jätä tallentamatta
  * valitse Next -> Next -> Next (tämä kolmas Next ei toimi, jos olet jo hakenut projektin - poista ensin vanha, vinkki: hakemisto lukee Directory-kohdassa)
  * valitse Next -> Finnish

* Projektin nimi on nyt 'hellofx'.

* Valitse ylävalikosta Run -> Run -> Maven build -> OK

* Myöhemmillä käyttökerroilla riittää valita vain Run -> Run -> ...

### Komentoriviltä

* Asenna Java (mielellään versio 11, mutta versiot 10 tai 8 voivat myös toimia)
  * Versio 8 on vielä tuettu
  * Versioden 1-7 ja 9-10 tuki on virallisesti loppunut
  * Tarkasta että käskyt java ja javac toimivat (PATH-ympäristömuuttuja)

* Asenna Maven. Tarkasta että käsky mvn toimii (PATH-ympäristömuuttuja)

* Asenna Git. Tarkasta että käsky git toimii (PATH-ympäristömuuttuja

* git clone https://gitlab.utu.fi/jmjmak/fxhello
* mvn compile exec:java

### Problems

Jos ohje ei toimi, yritä seuraavia 
 * https://github.com/openjfx/samples
