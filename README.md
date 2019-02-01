# talks
Hacking
[![Build Status](https://travis-ci.org/arturopst/talks.svg?branch=master)](https://travis-ci.org/arturopst/talks)
[![Maintainability](https://api.codeclimate.com/v1/badges/e38db4c2d90bd74458e2/maintainability)](https://codeclimate.com/github/arturopst/talks/maintainability)

Docker

docker build -f Dockerfile -t talks:latest --build-arg APP_VERSION=1 .

docker run -d -p 8090:8080 talks:latest
