# Java Image 22
FROM openjdk:22-slim

# Workdir
WORKDIR /app

# Copy java source into container
COPY src/Todolist.java /app/

# Compile
RUN javac Todolist.java

# Run
CMD ["java", "Todolist"]