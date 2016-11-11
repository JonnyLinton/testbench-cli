# testbench-cli [![Build Status](https://travis-ci.org/JonnyLinton/testbench-cli.svg?branch=master)](https://travis-ci.org/JonnyLinton/testbench-cli) [![Coverage Status](https://coveralls.io/repos/github/JonnyLinton/testbench-cli/badge.svg?branch=master)](https://coveralls.io/github/JonnyLinton/testbench-cli?branch=master)
TestBench used for System Integrators (SI)

## Requirements:
* Java 8

## How to Run:
`mvn package`
THEN:
`./tb-dev.sh` AND: <br/>
* `-send .` Sends an subscription ORDER event <br/>
* `-cancel <accountIdentifier>` Sends a CANCEL event for a chatroom subsciption <br/>
* `-oco .` "ORDER-CANCEL-ORDER" Sends all three in sequence, all for the same account
