# probedock-demo-itf

> Demo of integration with [Probe Dock](https://github.com/probedock/probedock) and [Probe Dock RT](https://github.com/probedock/probedock-rt) for [Java EE Integration Test Framework](https://github.com/probedock/jee-itf).

## Requirements

* Java 7+
* Maven 3.1
* Node.js 0.12+
* NPM 2.12+

## Usage

1. If not done, install [Probe Dock RT](https://github.com/probedock/probedock-rt#installation).

2. Clone this repository.

3. Be sure you have prepared the Probe Dock RT configuration in step 1. To start Probe Dock RT, you have to run the command `probedock-rt` as describe in the [usage](https://github.com/probedock/probedock-rt#installation#usage) section of Probe Dock RT.

4. Run the test via maven with `mvn clean install` on the root pom project. This will start the embedded Glassfish Server. 

5. Do a `POST` request with `{}` on `http://localhost:8282/itf-demo-test/itf/start`. Actually, it will run the integration tests. At this stage, you will see various result in the user interface of Probe Dock RT.

6. Now you can continue to the Probe Dock setup. If already registered, skip this step. Do the [registration](http://) on the demo server and create your account. You will receive an email confirmation with a link. 

7. Create the project in your organization on Probe Dock. First, access the projects' page and click on the `Add a new project` button. You can use the name `itf-sandbox` for example for both name and display name. You can leave the description empty for the demo.

8. Once the project is created, you should follow the `Getting started` guide to setup your project. The guide will invite you to setup your main configuration file and the project configuration file. For this project, you must place the file `probedock.yml` in `<projectRootFolder>/probedock-demo-itf-test-ejb/src/main/resources/`. 

9. You should stop the Glassfish Server by `Ctrl + C` and run again `mvn clean install`. Once the app is up and running, you can do a new `POST` request with `{}` on `http://localhost:8282/itf-demo-test/itf/start`. In addition of the test results shown in Probe Dock RT, you will also see results on Probe Dock on the dashboard. You are able to see the result details by clicking on the report line. 

9. Now you can play a bit with the tests. Break some tests and see the results on both interfaces. Play with the `@ProbeTest` and `@ProbeTestClass` annotations. You can also read the documentation of [Probe Dock ITF](https://github.com/probedock/probedock-itf) and [Probe Dock RT ITF](https://github.com/probedock/probedock-rt-itf) for more details about the probes used to send the test results. You have also several information on the [library](https://github.com/probedock/probedock-java) used by both probes. Finally, you will find the list of probes and libraries on these pages: [Probe Dock Probes](https://github.com/probedock/probedock-probes) and [Probe Dock RT Probes](https://github.com/probedock/probedock-rt-probes).

## Contributing

* [Fork](https://help.github.com/articles/fork-a-repo)
* Create a topic branch - `git checkout -b feature`
* Push to your branch - `git push origin feature`
* Create a [pull request](http://help.github.com/pull-requests/) from your branch

Please add a changelog entry with your name for new features and bug fixes.

## License

**probedock-demo-itf** is licensed under the [MIT License](http://opensource.org/licenses/MIT).
See [LICENSE.txt](LICENSE.txt) for the full text.
