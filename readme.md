# 1. Spring Boot 란?

- Spring Framework(스프링 프레임워크)는 Java Virtual Machine(JVM)에서 실행되는 프로덕션급 독립형 애플리케이션을 만들기 위한 인기 있는 엔터프라이즈급 오픈소스 프레임워크이다.
- Spring Boot(Spring Boot)는 추가된 세 가지 핵심 기능을 통해 Spring Framework를 사용하여 더 빠르고 쉽게 웹 애플리케이션과 마이크로서비스를 개발하도록 돕는 프레임워크이다.

<br><br>

## 1-1. Spring Boot에서 추가된 세 가지 핵심 기능

- 자동 구성 : Spring Legacy(스프링 레거시)에서 처럼 수동으로 구성하지 않아도 되는 사전 설정된 종속성 항목으로 Starter(스타터)를 통해 애플리케이션을 쉽게 초기화할 수 있다.
- 독선적 접근 방식 : Spring Boot는 프로젝트의 요구 사항에 따라 초기 설정시에 사용할 라이브러리나 자원인 종속성 항목을 쉽게 추가하고, 구성할 때 독선적 접근 방식(opinionated approach)을 따릅니다. 독선적 접근 방식이란? 라이브러리 종속성 항목을 수동으로 추가하지 않은 경우는 Spring Boot가 알아서 판단하여 기본값을 적용하여 추가 및 설정한다. 만약, Spring Legacy 이었다면, 처음 부터 끝 까지 라이브러리 종속성 추가 및 설정을 모두 개발자가 해야 했었지만, Spring Boot는 기본적인 라이브러리를 제공한다.
- 독립형 애플리케이션 : Spring Legacy에서는 별도의 외부 웹 서버에서 실행해야 하므로, 별도의 톰캣(Tomcat)과 같은 웹 서버나 컨테이너가 있고, 그 곳에 배포를 해야 했다면, Spring Boot는 외부 웹 서버에 의존하지 않고 해당 웹 프로젝트에 서버를 포함시켜 자체적으로 실행되는 독립형 애플리케이션을 만들 수 있습니다.

<br><br>

## 1-2. 빌드 도구의 다양화

- Spring Legacy 에서의 빌드(Build) 도구는 메이븐(Maven) 으로 하게 되지만, Spring Boot는 기존의 메이븐(Maven)과 새롭게 추가된 그레이들(Gradle) 도구가 있습니다.
- 여기에서 빌드(Build)란? 소스코드 파일을 컴퓨터에서 실행할 수 있는 독립적인 형태로 변환하는 과정을 말합니다.
- 빌드 도구(Build Tools) 또는 빌드 방식(Build Method)은 소스코드에서 애플리케이션을 생성하면서 여러가지 외부 라이브러리를 사용하는데, 빌드 도구는 사용자가 관리할 필요 없이 필요한 라이브러리들을 자동으로 관리하고, 종속성이 지정되어 있는 라이브러리를 다운로드한 후 개발자가 작성한 코드를 컴파일하여 하나의 패키지로 묶어 실행가능한 바이너리 코드로 합치는 역할을 하는 도구입니다.

<br>

### 1-2-1. 메이븐(Maven)

- Maven은 Java 전용 프로젝트 관리 도구로, Lifecycle 관리 목적 빌드 도구이고, Apache Ant의 대안으로 만들어 졌으며, 아파치 라이센스로 배포되는 오픈 소스 소프트웨어입니다.
- Maven은 Lifecycle 관리 도구로, 정해진 Lifecycle에 의하여 작업을 수행하며, 전반적인 프로젝트 관리 기능을 포함하고 있습니다.
- Maven은 필요한 라이브러리를 pom.xml에 정의하며, 여기서 POM은 Project Object Model의 약자로, 프로젝트 정보(프로젝트 이름, 라이센스, 빌드 설정(소스, 리소스, 라이프 사이클 별 실행한 plugin 등 빌드 관련 설정), 빌드 환경(사용자 환경 별로 달라질 수 있는 프로필 정보, pom 연관 정보(의존 프로젝트, 모듈, 상위 프로젝트 등)을 담고 있습니다.
- Apache Ant는 비교적 자유도가 높은 편이지만, Maven은 정해진 라이프사이클에 의하여 작업을 수행하며, 전반적인 프로젝트 관리 기능까지 포함하는 차이점이 있습니다.

<br>

#### 1-2-1-1. 라이프 사이클(Life Cycle)
- clean - validate - compile - test - package - verify - install - site - deploy

```comment
(1) clean : 빌드 시 생성되어있었던 파일들을 삭제
(2) validate : 프로젝트가 올바른지 확인하고 필요한 모든 정보를 사용할 수 있는지 확인하는 단계
(3) compile : 프로젝트 소스코드를 컴파일 하는 단계
(4) test : 단위 테스트를 수행하는 단계. 테스트 실패 시 빌드 실패로 처리하며, 스킵이 가능
(5) package : 실제 컴파일된 소스 코드와 리소스들을 jar, war 등의 파일의 배포를 위한 패키지로 만듦
(6) verify : 통합 테스트 결과에 대한 검사를 실행하여 품질 기준을 충족하는지 확인
(7) site : 프로젝트 문서와 사이트 작성, 생성하는 단계
(8) deploy : 만들어진 package를 원격 저장소에 release하는 단계
```

<br>

#### 1-2-1-2. 메이븐(Maven) 명령

| 명령어 | 설명 |
|---------------------|---------------------------------------------|
| compile | 컴파일 수행 |
| test | 컴파일 수행 후 테스트 클래스 수행 |
| package | 컴파일을 수행하고 컴파일한 소스를 packaging 양식(war or jar)에 맞춰 프로젝트 내 지정한 경로(eg.target) 디렉토리에 생성 |
| install | package 한 것에 추가적으로 로컬 repository에 배포 |
| deploy | install 한 것에 추가적으로 원격 repository(nexus)에 배포 |
| clean | maven build 시 생성된 모든 것들을 삭제 |


| 옵션 | 설명 |
|---------------------|---------------------------------------------|
| -am,--also-make | 프로젝트 목록이 지정된 경우 목록에 필요한 프로젝트도 빌드 |
 -amd,--also-make-dependents | 프로젝트 목록이 지정된 경우 목록의 프로젝트에 의존하는 프로젝트도 빌드 |
| -B,--batch-mode | 비 대화식 (일괄 처리) 모드에서 실행 (출력 색상 비활성화) |
| -b,--builder | 사용할 빌드 전략의 ID |
| -C,--strict-checksums | 체크섬이 일치하지 않으면 빌드 실패 |
| -c,--lax-checksums | 체크섬이 일치하지 않으면 경고 |
| -cpu,--check-plugin-updates | 비효율적이며 이전 버전과의 호환성을 위해서만 유지 |
| -D,--define | 시스템 속성 정의 |
| -e,--errors | 실행 오류 메시지 생성 |
| -emp,--encrypt-master-password | 마스터 보안 비밀번호 암호화 |
| -ep,--encrypt-password | 서버 비밀번호 암호화 |
| -f,--file | 대체 POM 파일 (또는 pom.xml이있는 디렉토리)을 사용하도록 합니다. |
| -fae,--fail-at-end | 이후에는 빌드에 실패합니다. 영향을받지 않은 모든 빌드가 계속되도록 허용 |
| -ff,--fail-fast | 원자로 빌드에서 처음 실패시 중지 |
| -fn,--fail-never | 프로젝트 결과에 관계없이 빌드에 실패하지 마십시오. |
| -gs,--global-settings | 글로벌 설정 파일의 대체 경로 |
| -gt,--global-toolchains | 글로벌 툴체인 파일의 대체 경로 |
| -h,--help | 도움말 정보 표시 |
| -l,--log-file | 모든 빌드 출력이 진행되는 로그 파일 (출력 색상 비활성화) |
| -llr,--legacy-local-repository | Maven 2 레거시 로컬 리포지토리 동작, 즉 _remote.repositories를 사용하지 마십시오. -Dmaven.legacyLocalRepo = true를 사용하여 활성화 할 수도 있습니다. |
| -N,--non-recursive | 하위 프로젝트로 재귀하지 마십시오 |
| -npr,--no-plugin-registry | 비효율적이며 이전 버전과의 호환성을 위해서만 유지 |
| -npu,--no-plugin-updates | 비효율적이며 이전 버전과의 호환성을 위해서만 유지 |
| -nsu,--no-snapshot-updates | SNAPSHOT 업데이트 억제 |
| -ntp,--no-transfer-progress | 다운로드 또는 업로드시 전송 진행률을 표시하지 않습니다 |
| -o,--offline | 오프라인으로 작업 |
| -P,--activate-profiles | 활성화 할 쉼표로 구분 된 프로파일 목록 |
| -pl,--projects | 모든 프로젝트 대신 빌드 할 지정된 원자로 프로젝트의 쉼표로 구분 된 목록입니다. [groupId] : artifactId 또는 상대 경로로 프로젝트를 지정할 수 있습니다. |
| -q,--quiet | 조용한 출력-오류 만 표시 |
| -rf,--resume-from | 지정된 프로젝트에서 원자로 재개 |
| -s,--settings | 사용자 설정 파일의 대체 경로 |
| -t,--toolchains | 사용자 툴체인 파일의 대체 경로 |
| -T,--threads | 스레드 수 (예 : C에 코어를 곱한 2.0C) |
| -U,--update-snapshots | 원격 리포지토리에서 누락 된 릴리스 및 업데이트 된 스냅 샷을 검사합니다. |
| -up,--update-plugins | 비효율적이며 이전 버전과의 호환성을 위해서만 유지 |
| -v,--version | 버전 정보 표시 |
| -V,--show-version | 빌드를 중단하지 않고 버전 정보 표시 |
| -X,--debug | 실행 디버그 출력 생성 |

<br>

##### 현재 프로젝트 컴파일

- 현재 프로젝트를 컴파일하여 컴파일 된 결과인 .class를 target/classes에 생성합니다.

```command
mvn compile
```

<br>

##### 현재 프로젝트 테스트

- 테스트 클래스 컴파일한 뒤 테스트 코드를 실행합니다.
- 테스트 클래스들은 target/test-classes 디렉터리에 생성됩니다.
- 테스트 결과 리포트는 target/surefire-reports에 생성됩니다.

```command
mvn test
```

<br>

##### 현재 프로젝트 패키징

- 컴파일, 테스트, 빌드를 한 꺼번에 수행하여 패키지 파일을 생성합니다.
- 프로젝트 이름, 버전, 패키징 옵션에 맞게 파일이 생성됩니다.
- pom에서 아래와 같이 설정하면 결과 파일은 donggov-1.0-SNAPSHOT.war 로 생성된다.

```xml
  <artifactId>donggov</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>
```

```command
mvn package
```

<br>

##### 패키징된 프로젝트를 배포

- 패키징한 파일을 로컬 저장소에 배포

```command
mvn install
```

<br>

##### 원격 저장소에 배포

- 패키징한 파일을 원격 저장소에 배포 (nexus 혹은 maven central 저장소)

```command
mvn deploy
```

<br>

##### 빌드된 프로젝트 제거

- 메이븐 빌드를 통하여 생성된 모든 산출물을 삭제합니다.

```command
mvn clean
```

<br><br>

### 1-2-2. 그레이들(Gradle)

- Maven을 대체할 수 있는 프로젝트 구성 관리 및 범용 빌드 툴이며, Ant Builder와 Groovy script를 기반으로 구축되어 기존 Ant의 역할과 배포 스크립의 기능을 모두 사용가능하며 스프링 부트와 안드로이드에서 사용됩니다.
- 빌드 속도가 Maven에 비해 10~100배 가량 빠르며, Java, C/C++, Python 등을 지원합니다.
- Gradle은 필요한 라이브러리를 build.gradle에 정의하며, Groovy 스크립트 언어로 작성하게 됩니다.

```comment
Groovy는 JVM에서 실행되는 스크립트 언어이다. JVM에서 동작하지만 소스코드를 컴파일할 필요 없다. Java와 호환되며, Java class file들을 Groovy class로 사용 가능하다.
Java 문법과 유사하여 빌드 처리를 관리할 수 있다.
```

<br>

#### 1-2-2-1. 그레이들(Gradle) 장점

(1) 가독성 개선 : 코딩에 의한 간결한 정의가 가능하므로 각 항목을 구분하기 쉽고, 읽기 쉽도록 하였습니다.
(2) 재사용에 용이 : 설정 주입 방식(Configuration Injection)을 사용하므로 재사용에 용이합니다.
(3) 구조적인 장점 : Build Script를 Groovy 기반의 DSL(Domail Specific Language)를 사용하여 코드로서 설정 정보를 구성하므로 구조적인 장점이 있습니다.
(4) 편리함 : Gradle 설치 없이 Gradle wrapper를 이용하여 빌드를 지원합니다.
(5) 멀티 프로젝트 : Gradle은 멀티 프로젝트 빌드를 지원하기 위해 설계된 빌드 관리 도구입니다.
(6) 지원 : Maven을 완전 지원합니다.

<br>

#### 1-2-2-1. 그레이들(Gradle) 라이프 사이클(Life Cycle)

- Initialization(초기화) -> Configuration(설정) -> Execution(실행)

- Initialization(초기화) : 그레이들(Gradle)은 단일 및 멀티 프로젝트 빌드를 지원하며, 초기화 단계에서 그레이들(Gradle)은 참여할 프로젝트를 결정하고 이러한 각 프로젝트들에 대한 Project 인스턴스를 생성합니다.
- Configuration(설정) : 빌드에 참여하게 된 모든 프로젝트의 빌드 스크립트가 실행되며, 필요한 내용을 설정하는 단계로 프로젝트 정보는 settings.gradle에 있으며, 종속성 라이브러리는 build.gradle 에서 설정하며, 실행에 필요한 정보는 application.properties 에서 설정합니다.
- Execution(실행) : 그레이들(Gradle)은 구성 단계에서 생성 및 구성된 태스크의 하위 집합을 결정합니다. 하위 집합은 현재 디렉토리와 gradle 명령어에 넘겨진 인수에 의해 결정됩니다. 그리고 선택된 태스크들을 실행합니다.

<br>

#### 1-2-2-2. 그레이들(Gradle) 명령

##### 그레이들(Gradle) 버전 확인

```command
gradle --version
```

<br>

##### Gradle 프로젝트 생성

- 프로젝트에 필요한 초기 환경을 구성하되, 타입을 주지 않는 경우 아래의 절차대로 진행하며, 타입을 줄 경우 'build script DSL' 절차부터 진행됩니다.

```comment
gradle init [--type 타입명]
```

```command
gradle init --type java-application
```

<br>

##### 그레이들 작업 정보 확인

```command
gradle tasks
```

<br>

##### 현재 프로젝트 빌드

- 현재 프로젝트를 컴파일(빌드) 하되, build.gradle에 apply plugin: 'java'가 추가된 경우 .jar파일로 패키징까지 됩니다.
- 컴파일된 파일들은 'app > build' 폴더 안에 생성되며, .jar파일은 'build > libs'에 패키징됩니다.

```command
gradle build
```

<br>

##### 현재 프로젝트 실행

- 컴파일 후 메인클래스를 실행한다.
- 스프링부트의 경우 gradle bootRun을 통해 앱을 구동할 수 있다.

```command
gradle run
```

<br>

##### 현재 프로젝트 패키징

- 프로그램을 .jar로 패키징하며, 'build > libs'에 생성됩니다.
- apply plugin: 'java'가 추가된 경우 build 명령으로 해결가능합니다.

```command
gradle jar
```

<br>

##### 현재 프로젝트 빌드 정보 지우기

- build 폴더를 제거하여, 빌드 이전 상태로 되돌린다.

```command
gradle clean
```

<br><br>

