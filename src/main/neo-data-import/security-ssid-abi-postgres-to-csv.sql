COPY (SELECT *
      FROM public.security_ssid_ap) TO '/tmp/security_ssid_ap_1.csv' WITH CSV header;
COPY (SELECT *
      FROM public.security_ssid_client) TO '/tmp/security_ssid_client_1.csv' WITH CSV header;

-- One-to-many join table of IDs from AP->Client
COPY (SELECT *
      FROM public.security_ssid_ap_client) TO '/tmp/security_ssid_ap_client_1.csv' WITH CSV header;

-- docker cp <containerId>:/tmp/filename /host/path/dir
-- docker cp c386df595c73:/tmp/ ~/neo4j/import
