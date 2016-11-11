#!/usr/bin/env bash
set -euo pipefail

sampleMarketplaceVersion=2.0
version=1.0-SNAPSHOT

# TODO: have a consistent URL for the jar file! (updates with version changes)
function downloadSampleMarketplaceIfNeeded() {
	if [ ! -e ~/appdirect-testbench/samplemarketplace${sampleMarketplaceVersion} ]; then
    	mkdir -p ~/appdirect-testbench && curl -o ~/appdirect-testbench/samplemarketplace${sampleMarketplaceVersion} file:///Users/jonathan.linton/sample-marketplace/target/sample-marketplace-2.0-SNAPSHOT.jar;
    fi
}

function stopSampleMarketplaceIfRunning() {
	pid=$(lsof -Pi :8888 -sTCP:LISTEN -t)
	if lsof -Pi :8888 -sTCP:LISTEN -t >/dev/null; then
        # Sample Marketplace is still running - must kill it now.
        echo "Some Error Occurred! Attempting to stop the Sample Marketplace, with PID = ${pid}" & kill $(lsof -Pi :8888 -sTCP:LISTEN -t)
    fi
}

trap "stopSampleMarketplaceIfRunning && echo 'error: Script failed: see failed command above'" ERR

downloadSampleMarketplaceIfNeeded

# Start the Sample Marketplace
java -jar ~/appdirect-testbench/samplemarketplace${sampleMarketplaceVersion} & PID=$!
./wait-for-it.sh localhost:8888 -t 0 --strict -- echo "Mock Marketplace is up with processId = $PID"

# Start the testbench
java -jar target/testbench-cli-${version}.jar "$@"

# Stop the sample marketplace jar (process id)
kill $PID
