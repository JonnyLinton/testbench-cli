#!/usr/bin/env bash
set -euo pipefail
trap "echo 'error: Script failed: see failed command above'" ERR

version=1.0-SNAPSHOT

java -jar target/testbench-cli-${version}.jar "$@"
