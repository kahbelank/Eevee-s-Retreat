# ==== Build Frontend ====
FROM node:18 AS frontend
WORKDIR /app
COPY ./frontend ./
RUN npm install && npm run build

# ==== Build Backend ====
FROM maven:3.9-eclipse-temurin-17 AS backend
WORKDIR /app
COPY backend/HotelBookingApplication ./HotelBookingApplication

# Copy built frontend into Spring Boot static resources
COPY --from=frontend /app/dist ./HotelBookingApplication/src/main/resources/static

WORKDIR /app/HotelBookingApplication
RUN mvn clean package -DskipTests && ls -la target

# ==== Final Image ====
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=backend /app/HotelBookingApplication/target/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]
