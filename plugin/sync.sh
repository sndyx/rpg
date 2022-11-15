#!/bin/bash

sftp sftp://underscoreopticalrzp.76de6d5f@nyc-u1.humbleservers.com:2022 << EOF
put build/libs/plugin-1.0.jar plugins/rpg-1.0.jar
exit
EOF