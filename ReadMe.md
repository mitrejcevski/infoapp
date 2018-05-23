### Running tests

##### UI tests
In order to run the UI tests, run `./gradlew clean connectedMockDebugAndroidTest`

##### Unit tests
In order to run the unit tests, run `./gradlew clean testProdDebug`

### Left out
There is failing unit tests that has to make sure the error response is propagated
back to observers properly. Maybe would have been better to use MockWebService for
this purpose