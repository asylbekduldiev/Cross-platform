# 1. Базовый образ с JDK 17 slim
FROM amazoncorretto:21

# 2. Метаданные
LABEL authors="Админ"

# 3. Рабочая директория в контейнере
WORKDIR /app

# 4. Копируем JAR-файл
COPY target/taskDelat-0.0.1-SNAPSHOT.jar app.jar

# 5. Открываем порт
EXPOSE 8085

# 6. Команда запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
