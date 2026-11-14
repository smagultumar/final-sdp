# Social Media Feed 
SE-2510

Java console prototype demonstrating nine design patterns in one cohesive social media feed workflow.

## Team
- Yermukan Zamira — Bridge, Facade
- Tumar Smagul — Builder, Abstract Factory, Factory Method
- Kambarbek Zeine — Strategy, Visitor
- Shared integration — Observer, Decorator

## Requirements
- Java 17+
- IntelliJ IDEA or VS Code with Extension Pack for Java

## Run
```bash
javac -d out $(find src/main/java -name '*.java')
java -cp out socialfeed.app.Main
```

## Test
```bash
javac -d out $(find src/main/java src/test/java -name '*.java')
java -cp out socialfeed.SocialFeedTest
```

Expected test result:
`All Social Media Feed tests passed.`

## Patterns
Creational: Builder, Abstract Factory, Factory Method.
Structural: Bridge, Facade, Decorator.
Behavioral: Strategy, Visitor, Observer.

## Project contents
- `src/main/java/socialfeed/` — application source, grouped by pattern (`builder/`, `factory/`, `bridge/`, `facade/`, `decorator/`, `observer/`, `strategy/`, `visitor/`) and `model/` / `app/`
- `src/test/java/socialfeed/` — test source
- `docs/UML.puml` — editable PlantUML class diagram
- `docs/UML_Diagram.png` — rendered UML diagram
- `docs/Application_Screenshot.png` — application output screenshot

