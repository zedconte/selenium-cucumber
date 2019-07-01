# README.md
Sample code for Automate Amazon Search using Selenium

## Steps
- Goto Amazon.com home page
- Search "Fire Tv" and sort results from highest price to slowest.
- Select second product and click it for details.
- From details check (verify with assert) that product topic contains text “Fire TV Cube, hands-free with Alexa and 4K Ultra HD, streaming media player”

## Implementation

This project uses archetype ru.stqa.selenium as starting point.

Maven is the tool for dependency management and project build.

### Debugging

In Visual Studio Code:

Run: mvn -Dtest=com.sits.amz.test.TestProductSearch -Dmaven.surefire.debug test

Click Debug -> Start Debugging

## Maven Targets

mvn test install - Run dependency resolve and tests
mvn verify - Run tests only

