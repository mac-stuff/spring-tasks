#!/usr/bin/env bash

chmod 777 runcrud.sh
./runcrud.sh

google-chrome http://localhost:8080/crud/v1/task/getTasks

