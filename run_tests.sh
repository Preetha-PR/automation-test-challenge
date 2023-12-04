#!/bin/bash

# Check if Java is installed
if ! type -p java &> /dev/null; then
    echo "Java is not installed."
    exit 1
elif [[ -z "$JAVA_HOME" ]] && ! [[ -x "$JAVA_HOME/bin/java" ]]; then
    echo "JAVA_HOME is not set properly or Java is not executable"
    exit 1
fi

 # Get Java version
    java_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
   
    # Extract major version number
    if [[ $java_version =~ ^1\. ]]; then
        major_version=$(echo $java_version | awk -F '.' '{print $2}')
    else
        major_version=$(echo $java_version | awk -F '.' '{print $1}')
    fi

    # Check if version is 11 or higher
    if ! [[ $major_version -ge 11 ]]; then
       echo "Java version is lower than 11."
       echo "Java version $java_version detected."
        exit 1
    fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null
then
    echo "Maven could not be found. Please install Maven and add it to your PATH."
    exit 1
fi


# Execute Maven to run tests
mvn clean test