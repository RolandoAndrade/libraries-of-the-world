# libraries-of-the-world

## Download the project

1. Download the target file form [releases](https://github.com/RolandoAndrade/libraries-of-the-world/releases)

2. Extract the folder

```bash
    tar -xzvf target.tar.gz
```

## Run the server


```bash
    java -cp target/libraries-of-the-world-1.0-SNAPSHOT.jar server.infrastructure.<Server Main> port_number file_repository_path
```

### Example

```bash
    java -cp target/libraries-of-the-world-1.0-SNAPSHOT.jar server.infrastructure.ServerLibraryA 3000 target/classes/templates/library-template.xml
```

## Run the client

First you should define the libraries at libraries.json in the directory where you are running the app
```json
  {
    "currentLibrary": {
      "name": "Librería B",
      "address": {
        "url": "192.168.1.97",
        "port": 3000
      }
    },
    "libraries": [
      {
        "name": "Librería A",
        "address": {
          "url": "192.168.1.100",
          "port": 3000
        }
      },
      {
        "name": "Librería B",
        "address": {
          "url": "192.168.1.97",
          "port": 3000
        }
      },
      {
        "name": "Librería C",
        "address": {
          "url": "192.168.1.200",
          "port": 3000
        }
      }
    ]
  }
```

Then you can run the client with

```bash
    java -cp target/libraries-of-the-world-1.0-SNAPSHOT-jar-with-dependencies.jar application.Main file_repository_path
```

###Example

```bash
    java -cp target/libraries-of-the-world-1.0-SNAPSHOT-jar-with-dependencies.jar application.Main target/classes/templates/library-template.xml
```