#!/usr/bin/env bash

curl -k --request POST -d "xml=<data><name>Markus Right</name><number>1234-5678-9012-3456</number></data>" https://localhost:8443/apiman-gateway/MyOrganization/MyApi/1.03?apikey=16f7be8e-b9df-414c-9c3b-14a5019a1a05
