# ssid-probe-graph-analytics
Based on data from security-ssid-abi, store that data in a graph DB and run graph analytics on the data to find patterns of interest

Run a neo4j instance in Docker (these credentials match the default in application.properties)
```
docker run \
    --name neo4j404 \
    -p7474:7474 -p7687:7687 \
    -d \
    -v $HOME/neo4j/logs:/logs \
    -v $HOME/neo4j/import:/var/lib/neo4j/import \
    --env NEO4J_AUTH=neo4j/gisdev01 \
    neo4j:4.0.4
```

Optionally with mounted volumes:
```
docker run \
    --name neo4j404 \
    -p7474:7474 -p7687:7687 \
    -d \
    -v $HOME/neo4j/data:/data \
    -v $HOME/neo4j/logs:/logs \
    -v $HOME/neo4j/import:/var/lib/neo4j/import \
    -v $HOME/neo4j/plugins:/plugins \
    --env NEO4J_AUTH=neo4j/gisdev01 \
    neo4j:4.0.4
```
