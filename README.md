# **Battleship**

**Ryhmän jäsenet:**

- Josefiina Heikkilä, 516568
- Nina Judén, 524982
- Sini Salmi, 525823
- Vera Hiltunen, 522269

**Kontribuutiot:**

Työstimme projektia suurilta osin kaikki yhdessä koodikerhossa sekä web-kurssin luennoilla ja jatkoimme aina osakohtaista muokkausta kotona.

Kommunikoinnissa käytimme Discordia sekä WhatsAppia.

**Pelin toiminta:**

Alku menussa pelaaja voi aloittaa pelin tai poistua sovelluksesta.

Kun peli aloitetaan, aukeaa peliasetusten näkymä, jossa syötetään pelaajien nimet, valitaan laudan koko sekä haluttu määrä erilaisia aluksia.

Kun asetuksen on valittu, siirrytään laivojen asetteluun. Laivojen raahaus saattaa asettaa laivat ruutujen väliin, jolloin pelaajan pitää asetella laivat oikeille kohdilleen ylös ja vasemmalle nuolinäppäimillä tai raahaamalla uudelleen.

Kun molemmat pelaajat ovat asettaneet laivat pelilaudoilleen, siirrytään itse pelinäkymään.

Jos pelaaja ampuu ohi, pelaajan täytyy itse klikata 'turn over' -nappia, josta vuoro vaihtuu. Pelaaja voi myös *laittomasti* klikata samaa kohtaa aluksesta, jolloin laiva uppoaa, vaikka koko laivaa ei ole paljastettu. Laivaa pystyy myös kääntämään pelin aikana, mikä on myös sääntöjen vastaista.

Pelaajien vuorojen välissä näkyy väliruutu, josta voi siirtyä eteenpäin seuraavan pelaajan vuoroon.

Kun jompikumpi pelaaja on ampunut kaikki toisen pelaajan laivat, siirrytään voittoruutuun. Pelaajat voivat aloittaa uuden pelin tai poistua sovelluksesta.

**Muuta huomioitavaa työstä:**

Emme ehtineet toteuttamaan pelilogiikkaa kokonaan. Pelin toimiminen on siis osittain kiinni pelaajien tunnollisuudesta.

**Jälkiviisastelua:**

- Pelin toiminta olisi pitänyt toteuttaa ensin, ja vasta sitten käyttöliittymä
- Projektin alussa tehty suunnitelma olisi pitänyt olla vielä syvällisempi ja tarkempi
- Koodi olisi voinut olla siistimpää (esim. vähemmän toistelua)
- Ryhmätyötä olisi helpottanut koodin tarkempi kommentointi
- Gitin kanssa toimiminen tuotti päänvaivaa:
    - Eclipse tuuttasi branchissa tehdyt muutoksen suoraan masteriin
    - Brancheja olisi kannattanut tehdä ominaisuus kohtaisesti, eikä henkilöittäin
