#!/bin/bash

./gradlew build --stacktrace
sftp sftp://underscoreopticalrzp.76de6d5f@nyc-u1.humbleservers.com:2022 << EOF
put plugin/build/libs/rpg-1.0-SNAPSHOT.jar plugins/rpg-1.0-SNAPSHOT.jar
exit
EOF