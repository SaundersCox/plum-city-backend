# Run the built .jar file
JAR_FILE=$(ls /app/*.jar | head -n 1)
java -jar $JAR_FILE