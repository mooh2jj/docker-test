# 기본 이미지로 openjdk:11-jdk를 사용합니다.
FROM openjdk:11-jdk

# 환경 변수 SPRING_PROFILE를 "dev"로 설정합니다.
ENV SPRING_PROFILE "dev"

# 현재 디렉토리의 모든 파일을 도커 이미지로 복사합니다.
COPY . .

# Gradle 빌드 스크립트를 실행하기 위한 실행 권한을 부여합니다.
RUN chmod +x ./gradlew

# Gradle로 프로젝트를 빌드합니다.
RUN ./gradlew clean build

# 빌드된 JAR 파일 경로를 ARG로 설정합니다.
ARG JAR_FILE=build/libs/*.jar

# JAR 파일을 도커 이미지 내부로 복사합니다.
COPY ${JAR_FILE} app.jar

# 애플리케이션을 실행합니다.
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILE}", "-jar", "/app.jar"]

