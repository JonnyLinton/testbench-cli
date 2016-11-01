#!/usr/bin/env bash
set -euo pipefail

sampleMarketplaceVersion=1.0
version=1.0-SNAPSHOT

# TODO: downloadIfNeeded() -- checks if mockmarketplace file exists, if not - download jar
# TODO: add sampleMarketplaceVersion variable to URL
# make a folder, then download the jar
mkdir -p ~/appdirect-testbench
curl -o ~/appdirect-testbench/samplemarketplace 'https://artifactory.appdirectondemand.com/artifactory/libs-release-local/com/appdirect/sample-marketplace/1.0/sample-marketplace-1.0.jar'

# TODO: "trap" - check if PID isset - if it is -> err (for the case where the marketplace process was not killed)
# trap "stopAppmarket && echo 'error: Script failed: see failed command above'" ERR
# Start the Sample Marketplace
java -jar ~/appdirect-testbench/samplemarketplace & PID=$!
./wait-for-it.sh localhost:8888 -t 0 --strict -- echo "Mock Marketplace is up with processId = $PID"

# Start the testbench
java -jar target/testbench-cli-${version}.jar "$@"

# Stop the sample marketplace jar (process id)
kill $PID
