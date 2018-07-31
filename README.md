# JavaHeartbeatServer

## Install Homebrew

You can find more instruction [here](https://brew.sh/)

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

## Install Mongodb
On MAC, run the command
```
brew install mongodb
```

The server will use localhost by default, so there's nothing more to do then compile the code and run it.

```
./gradlew build && java -jar build/libs/Test-Golo-0.1.0.jar
```

## Start a server endpoint

```
http://localhost:8080/server/start?interval=10000&url=https://www.twitter.com
```

## Start a server endpoint

```
http://localhost:8080/server/stop?url=https://www.twitter.com
```

## Get servers statuses endpoint

```
http://localhost:8080/server/status
```
