# Java-Postgres-Keycloak
## Setting up locally
###### Install PostgreSQL, MySQL and Keycloak version of 22.0.0
```
docker-compose up -d
```
##### Setting up keycloak
```
- Login admin page http://localhost:8080/auth.
- Regenerate client secret for these clients (because secret is can not be carried with export).
    - sso-idp-client in "sso" realm, then update it that sceret into "stssurvey" realm identity providers.
    - stssurvey-services-client in "stssurvey" for backend connection attempt.
    - stssurvey-login-sso-idp-client in "stssurvey" for front end login.
- Update public key of RS256 (Realm Setting -> keys) in properties file, for some reason keycloak 22 has some problems with jwks_uri.
- Users will be stored in "sso" realm with UI login purpose but for the testing convenience we could use Users in "stssurvey" realm.
- Users will be temporarily locked 1 minute after invalid login 2 times.
```
##### Getting token from keycloak
```
curl --location 'http://localhost:8080/auth/realms/stssurvey/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: OAuth_Token_Request_State=8e9ab695-56cb-4b35-aadf-c57165710be0' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJMRzZJMDNHdVJKcFJUVUk1TTVkdk1SWlk5bjZiOTUxTlcwU0xYeXo4OV9rIn0.eyJleHAiOjE3Mjg4Mjk3MTIsImlhdCI6MTcyODgyNzkxMiwianRpIjoiNjUzNWYyYTYtNGZlYy00OGJlLTkwNDQtNDA3NzllMjUxZWM2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL3N0c3N1cnZleSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJiNzIzYjNhNy02OGFjLTQ1OGQtODYwZC04OTUzZjg4NDA0MWQiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJzdHNzdXJ2ZXktc2VydmljZXMtY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImFmMjczM2U1LTQ0ODYtNGNkYS1iODIzLTY0NzI2Y2ZmOTIxMSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1zdHNzdXJ2ZXkiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsic3Rzc3VydmV5LXNlcnZpY2VzLWNsaWVudCI6eyJyb2xlcyI6WyJwbSJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwic2lkIjoiYWYyNzMzZTUtNDQ4Ni00Y2RhLWI4MjMtNjQ3MjZjZmY5MjExIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJjdW9uZy1zZXJ2aWNlcyIsImdpdmVuX25hbWUiOiIiLCJmYW1pbHlfbmFtZSI6IiJ9.eo-Ih_lggnsht8vUfThrtXDCPE46Y6IlYOgkckqeF-NrZpQ-pNJk9aclzLRdGDaWBq2SQ-hOxpUqttC22dXOvtQ7BMFn0xH2DmVAiwF0QPkKZXYdQMHtat8_8j-CDHRM5L4dpWTf_OLelrHZ7nmBdichLU12WQ81op6_d6-9FGXHCC22fTWQmKKs3WFG347ZUSy4TGd2nKpIi9g_wJN2DDkB6IRY8-nUkGeCOeQpyZHNGyJDOU4LoAHy7gGq5sB4DdNMDlnf2pWXP1bVoIVg_JJMMLqoUv9vjL4OIVUAMQ8ioAqQx2uLIJA8yrSZpohzSv6I5PktiKKsOoeyOKS2sw' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'client_id=stssurvey-services-client' \
--data-urlencode 'client_secret=pMQDxG2XxR7dbbmJLBQptlY6JNF9twIK' \
--data-urlencode 'username=cuong-services' \
--data-urlencode 'password=123123'
```
##### Swagger
http://localhost:8181/api/swagger-ui.html#/
##### Postman
```
documents/sts-survey.postman_collection
```
