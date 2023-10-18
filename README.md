# challenge-kyu

Test framework for api testing.

### Clone project:
```sh
$ git clone https://github.com/mgorosito/challengeKyu.git
```

### Tests package:
```sh
.../src/test/java/
```

### Properties location:
```sh
...src/main/resources/properties
```

### Execution:
```sh
$ mvn clean test -Dgroups=regression -Denvironment=qa -Dbrowser=chrome
```
or you can run test class after passing VM options ... "-Denvironment=qa" through intellij configuration.

### Report location:
```sh
.../reports/challenge-report.html
```