# Feet And Bike Routing

Dieser Service erlaubt es zwischen zwei Geokoordinaten eine Fussgänger Routing auf Basis von [graphhopper](https://www.graphhopper.com/) durchzuführen. Die Ergebnisse werden benötigt, um für die Applikation [publicdepartcologne.github.io](https://publicdepartcologne.github.io) eine zuverlässigere Abschätzung der Zeit abgeben zu können, ob eine Haltestelle zum Zeitpunkt der Abfahrt eines Verkehrsmittels erreichbar ist. Darüber hinaus kann hiermit der Weg gezeigt werden, der genommen werden muss, die entsprechende Haltestelle zu erreichen.

# Entwicklungsstand

Dieses Projekt befindet sich in der Entwicklung.

# Verwendete Technologien/ Bibliotheken

- Java 1.7
- [graphhopper](https://www.graphhopper.com/)
- [GeoJson POJOs for Jackson](https://github.com/opendatalab-de/geojson-jackson)

# Schnittstellen

## /feetandbikerouting/service/foot?fromTo={lat,lng,lat,lng}

Beispiel Fussgängerrouting [/feetandbikerouting/service/foot?fromTo={lat,lng,lat,lng}](https://tom.cologne.codefor.de/feetandbikerouting/service/foot?fromTo=50.940214,6.953710,50.940356,6.961413)

## /feetandbikerouting/service/bike?fromTo={lat,lng,lat,lng}

Beispiel Fahrradrouting [/feetandbikerouting/service/bike?fromTo={lat,lng,lat,lng}](https://tom.cologne.codefor.de/feetandbikerouting/service/bike?fromTo=50.940214,6.953710,50.940356,6.961413)

# Download OSM-Data

Die Applikation benötigt einen Extract der OSM Daten für die Graphhopper Engine. Dieser kann über wget heruntergeladen werden. Das Routing gilt nur im Rahmen des Regierungsbezirks Köln.

    wget http://download.geofabrik.de/europe/germany/nordrhein-westfalen/koeln-regbez-latest.osm.pbf
    
Wenn wget nicht zur Verfügung steht, kann auch curl verwendet werden:
    
    curl http://download.geofabrik.de/europe/germany/nordrhein-westfalen/koeln-regbez-latest.osm.pbf --output koeln-regbez-latest.osm.pbf

Der Ort der Datei wird in der config.properties festgelegt. Auf Unix-Systemen bietet sich hierfür das /var/cache - Verzeichnis an:

    /var/cache/publictransport


# Installation

1. Checkout Sources
2. Check Config:
   Die Konfiguration kann vom Template übernommen werden, wenn das Verzeichnis für graphhopper.graphFolder und die OSM-Data für Köln verwendet werden können
3. Download OSM-Data:
   Vor dem build der Applikation ist es notwendig die OSM-Data zu laden. Durch den Test RoutingFacadeTest wird graphhopper vorbereitet. 
4. Build Application
5. Deploy Application

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.
