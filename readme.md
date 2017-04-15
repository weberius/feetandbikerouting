# Feet And Bike Routing

Dieser Service erlaubt es zwischen zwei Geokoordinaten eine Fussgänger Routing auf Basis von [graphhopper]((https://www.graphhopper.com/) durchzuführen. Die Ergebnisse werden benötigt, um für die Applikation [publicdepartcologne.github.io](https://publicdepartcologne.github.io) eine zuverlässigere Abschätzung der Zeit abgeben zu können, ob eine Haltestelle zum Zeitpunkt der Abfahrt eines Verkehrsmittels erreichbar ist. Darüber hinaus kann hiermit der Weg gezeigt werden, der genommen werden muss, die entsprechende Haltestelle zu erreichen.

# Entwicklungsstand

Dieses Projekt befindet sich in der Entwicklung.

# Verwendete Technologien/ Bibliotheken

- Java 1.7
- [graphhopper](https://www.graphhopper.com/)
- [GeoJson POJOs for Jackson](https://github.com/opendatalab-de/geojson-jackson)

# Schnittstellen

## /publicTransportRouing/service/foot?latlnglatlng={lat,lng,lat,lng}

# Download OSM-Data

Die Applikation benötigt einen Extract der OSM Daten für die Graphhopper Engine. Dieser kann über wget heruntergeladen werden. Das Routing gilt nur im Rahmen des Regierungsbezirks Köln.

    wget http://download.geofabrik.de/europe/germany/nordrhein-westfalen/koeln-regbez-latest.osm.pbf

Der Ort der Datei wird in der config.properties festgelegt. Auf Unix-Systemen bietet sich hierfür das /var/cache - Verzeichnis an:

    /var/cache/publictransport


# Installation

1. Checkout Sources
2. Build Application
3. Check Config
4. Download OSM-Data
5. Deploy Application

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.
