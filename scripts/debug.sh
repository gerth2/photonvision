#!/bin/bash

if [ "$(id -u)" != "0" ]; then
   echo "This script must be run as root" 1>&2
   exit 1
fi


systemctl stop photonvision.service
echo "Starting PhotonVision and waiting for external debugger connection..."
/usr/bin/java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=*:8000 -jar /opt/photonvision/photonvision.jar --debug
