* 소스코드 관련 설명 → <a href='https://jforj.tistory.com/355'>[SpringBoot] SpringBatch 사용하기 (3) - Quartz로 배치 만들기</a>
* 소스코드 관련 설명 → <a href='https://jforj.tistory.com/356'>[SpringBoot] SpringBatch 사용하기 (4) - Quartz로 클러스터링 처리하기</a>

* Docker 설정
```
docker build -t quartz-img .
docker run --name quartz-con1 -p 8088:8080 -d quartz-img
docker run --name quartz-con2 -p 8089:8080 -d quartz-img
```