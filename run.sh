#!/bin/bash

echo "running database project"

# compile and run java
initiate_backend () {
  echo "initiating backend"
  # mvn package
  # java -jar target/demo-0.0.1-SNAPSHOT.jar
  osascript -e "
  tell application \"Terminal\"
    set currentTab to do script \"cd /Users/macintosh/Documents/GitHub/databasesProject/\"
    delay 2
    do script \"mvn package\" in currentTab
    delay 5
    do script \"java -jar target/demo-0.0.1-SNAPSHOT.jar\" in currentTab
  end tell"
}

# run javascript
initiate_frontend () {
  echo "initiating frontend"
  # cd "./src/frontend/"
  # npm install
  # npm start
  osascript -e "
  tell application \"Terminal\"
    set currentTab to do script \"cd /Users/macintosh/Documents/GitHub/databasesProject/src/frontend/\"
    delay 2
    do script \"npm install\" in currentTab
    delay 5
    do script \"npm start\" in currentTab
  end tell"
}

initiate_backend &
initiate_frontend &

wait
echo "finished"
