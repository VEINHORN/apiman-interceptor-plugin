#!/usr/bin/env bash

curl -k --request POST -d "xml=<data><name>Markus Right</name><number>1234-5678-9012-3456</number></data>" https://localhost:8443/apiman-gateway/MyOrganization/MyApi/1.04?apikey=7168de13-3906-4d4b-bf18-219fbfef3733
