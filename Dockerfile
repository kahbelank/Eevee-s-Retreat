# # ==== Build Frontend ====
# FROM node:18 AS frontend
# WORKDIR /app
# COPY frontend/Hotel-booking-application/ ./
# RUN npm install && npm run build

# # ==== Build Backend ====
# FROM maven:3.9-eclipse-temurin-17 AS backend
# WORKDIR /app

# # Copy backend code
# COPY backend/HotelBookingApplication ./HotelBookingApplication

# # Copy frontend build output to backend static dir
# COPY --from=frontend /app/dist ./HotelBookingApplication/src/main/resources/static

# # Go into backend folder and run Maven Wrapper to build the jar
# WORKDIR /app/HotelBookingApplication
# RUN chmod +x mvnw
# RUN ./mvnw clean install -DskipTests && ls -la target

# # ==== Final Image ====
# FROM openjdk:17-jdk-slim
# WORKDIR /app

# # Copy the generated JAR
# COPY --from=backend /app/HotelBookingApplication/target/*.jar app.jar

# EXPOSE 80
# ENTRYPOINT ["java", "-jar", "app.jar"]
