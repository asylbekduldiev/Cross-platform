# ===================== ЭТАП 1 — Сборка JAR =====================
FROM maven:3.9.9-eclipse-temurin-21 AS builder

# Кешируем зависимости (ускоряет пересборку)
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Копируем код и собираем JAR
COPY src ./src
RUN mvn clean package -DskipTests -B

# ===================== ЭТАП 2 — Запуск =====================
FROM amazoncorretto:21-alpine

WORKDIR /app
# Копируем только готовый JAR из предыдущего этапа
COPY --from=builder /app/target/taskDelat-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

# Запускаем
ENTRYPOINT ["java", "-jar", "app.jar"]