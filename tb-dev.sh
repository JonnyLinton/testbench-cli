#!/usr/bin/env bash
set -euo pipefail

function stopAppmarket {
    docker stop appdirect-testbench-sample-marketplace > /dev/null
    docker rm appdirect-testbench-sample-marketplace > /dev/null
}

trap "stopAppmarket && echo 'error: Script failed: see failed command above'" ERR

version=1.0-SNAPSHOT

# download & run the sample marketplace
docker run --name appdirect-testbench-sample-marketplace -p 8888:8888 -d docker.appdirectondemand.com/sample-marketplace/sample-marketplace:1.0-SNAPSHOT > /dev/null

java -jar target/testbench-cli-${version}.jar "$@"

stopAppmarket
