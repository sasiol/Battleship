# **Battleship**

**Ryhmän jäsenet:**

- Josefiina Heikkilä, 516568
- Nina Judén, 524982
- Sini Salmi, 525823
- Vera Hiltunen, 522269

**Kontribuutiot:**

Työstimme projektia suurilta osin kaikki yhdessä koodikerhossa sekä web-kurssin luennoilla ja jatkoimme aina osakohtaista muokkausta kotona.

Kommunikoinnissa käytimme Discordia sekä WhatsAppia.

**Pelin toiminta (ja mikä ei toimi):**

Alkuvalikossa pelaaja voi aloittaa pelin tai poistua sovelluksesta. Pelin lopettamiseen löytyy myös Exit Game -nappi jokaisesta näkymästä, jonka avulla peli keskeytyy.

Kun peli aloitetaan, aukeaa peliasetusten näkymä, jossa syötetään pelaajien nimet, valitaan laudan koko sekä haluttu määrä erilaisia aluksia. Pelissä ei pysty etenemään ennen kuin tarvittavat tiedot on täytetty.

Kun asetukset on valittu, siirrytään laivojen asetteluun. Laivojen raahaus temppuilee. Joskus laiva ei seuraa hiirtä tai laiva saattaa asettua ruutujen väliin, jolloin pelaajan pitää asetella laivat oikeille kohdilleen ylös ja vasemmalle nuolinäppäimillä tai raahaamalla uudelleen. Ensimmäisen pelaajan ollessa valmis, hänen täytyy painaa 1 Ready -nappia ja toisen pelaajan 2 Ready-nappia. Kun molemmat pelaajat ovat asettaneet laivat pelilaudoilleen, siirrytään itse pelinäkymään.

Pelaaja ampuu klikkaamalla ruudukkoa. Jos ruudun takaa paljastuu laiva, sitä pitää klikata uudelleen, jotta osuma lasketaan. Jos pelaaja ampuu ohi, pelaajan täytyy itse klikata 'turn over' -nappia, josta vuoro vaihtuu. Pelaaja voi myös *laittomasti* ampua samaa kohtaa aluksesta, jolloin laivan HP loppuu ja laiva uppoaa, vaikka koko laivaa ei ole paljastettu. Laivaa pystyy myös kääntämään pelin aikana, mikä on sääntöjen vastaista.

Pelaajien vuorojen välissä näkyy väliruutu, josta voi siirtyä eteenpäin seuraavan pelaajan vuoroon.

Kun jommankumman pelaajan laivastosta loppu HP, siirrytään voittoruutuun. Pelissä on myös huijausnappi, insta-win, josta pääsee heti voittonäkymään. Voittonäkymässä pelaajilla on mahdollisuus aloittaa uusi peli tai poistua sovelluksesta.

**Muuta huomioitavaa työstä:**

Emme ehtineet tehdä pelilogiikasta niin toimivaa kuin halusimme. Pelin toimiminen on siis osittain kiinni pelaajien tunnollisuudesta.

**Jälkiviisastelua:**

- Pelin toiminta olisi pitänyt toteuttaa ensin, ja vasta sitten käyttöliittymä
- Projektin alussa tehty suunnitelma olisi pitänyt olla vielä syvällisempi ja tarkempi
- Koodi olisi voinut olla siistimpää (esim. vähemmän toistelua)
- Ryhmätyötä olisi helpottanut koodin tarkempi kommentointi
- Gitin kanssa toimiminen tuotti päänvaivaa:
    - Eclipse tuuttasi branchissa tehdyt muutoksen suoraan masteriin
    - Brancheja olisi kannattanut tehdä ominaisuus kohtaisesti, eikä henkilöittäin
