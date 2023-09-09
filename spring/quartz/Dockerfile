# maven 이미지 불러오기
FROM gradle:7.2.0-jdk17

# Docker Container에서 작업이 이루어지는 위치
WORKDIR /root

# 현재 경로에 있는 모든 파일을 Docker Container의 WORKDIR 위치로 모두 복사 (이미지 생성할 때 동작)
COPY ./build ./

# build되어 만들어진 jar파일 실행하기 (컨테이너 실행할 때 동작)
CMD ["java", "-jar", "libs/quartz-0.0.1-SNAPSHOT.jar"]