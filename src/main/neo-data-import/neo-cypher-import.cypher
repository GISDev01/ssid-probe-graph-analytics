// Load SSID APs from CSV (from Postgres)
// Path to the file is relative to the ./neo4j/import directory
LOAD CSV WITH HEADERS FROM 'file:///tmp/security_ssid_ap_1.csv' AS row
MERGE (accessPoint:AccessPoint {accessPointID: row.id})
  ON CREATE SET accessPoint.SSID = row.SSID,
                accessPoint.BSSID = row.BSSID,
                accessPoint.name = row.name,
                accessPoint.firstProbedDate = row.firstprobed_date;

// Load Clients from CSV (from Postgres)
LOAD CSV WITH HEADERS FROM 'file:///tmp/security_ssid_client_1.csv' AS row
MERGE (client:Client {clientID: row.id})
  ON CREATE SET client.mac = row.mac,
                client.manufacturer = row.manufacturer,
                client.name = row.name,
                client.firstSeenDate = row.firstseen_date;


//CREATE INDEX SSID_idx FOR (ap:AccessPoint) ON (ap.SSID);
//CREATE INDEX mac_idx FOR (client:Client) ON (client.mac);

// CREATE CONSTRAINT client_mac_unique ON (client:Client) ASSERT client.mac IS UNIQUE;


// Create relationships between APs and Client
LOAD CSV WITH HEADERS FROM 'file:///tmp/security_ssid_ap_client_1.csv' AS join_row
MATCH (ap:AccessPoint {accessPointID: join_row.ap_id})
MATCH (client:Client {clientID: join_row.client_id})
MERGE (client)-[:PROBED_FOR]->(ap);


MATCH (n)
RETURN n
