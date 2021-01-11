# tomte_hierarchy
kotlin
https://github.com/Ashkanamirii/tomte_hierarchy/blob/master/src/main/resources/Tomtarnas%20chefs-hierarki.pdf
Inlämningsuppgift 2 - Rekursion
Tomtarna på Nordpolen har en strikt chefs-hierarki:
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter" och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"
Er uppgift har 2 delar:
• Illustrera tomtens chefshierarki i en lämplig datastruktur. Det finns flera tänkbara val här, ett
krav är att varje nisse bara får mappas mot dem som är direkt över- och underordnade i er
datastruktur. Direkta mappningar över flera nivåer är inte tillåtna.
• Skriv en rekursiv funktion där man antingen:
o Anger en nisses namn och får tillbaka en lista av alla denna nisses chefer, på samtliga
nivåer. Exempel: Om man skriver in ”Dammråttan” ska en lista innehållandes
Tomten, Glader, Trötter och Skumtomten returneras
o Anger en nisses namn och får tillbaka en lista på alla dess underordnade, på samtliga
nivåer. Exempel: Om man skriver in ”Räven” får man tillbaka en lista med
Gråsuggan, Myran och Bladlusen.
Inga tomtenamn får vara hårdkodade i den rekursiva loopen (det är ok att hårdkoda i skapandet av
datastrukturen). Du väljer själv om du skriver koden i Java eller Kotlin.
