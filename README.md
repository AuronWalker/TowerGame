# SENG201 Team 25 - Tower Game
Tower Defence style game, where you deliver resources to waves of carts, making sure that every cart has enough resources to make it to the village!

## Authors
- Connor Varney (cva68) and Auron Walker (awa158)

## Prerequisites
- JDK >= 17 [click here to get the latest stable OpenJDK release (as of writing this README)](https://jdk.java.net/18/)
- *(optional)* Gradle [Download](https://gradle.org/releases/) and [Install](https://gradle.org/install/)

## Instructions
### Setup
- Open the game by running Team25-TowerGame.jar
- Enter your name (3-15 characters, alphanunmeric), select the number of rounds you wish to play, and the difficulty.

### Selecting your towers
There are two types of towers to choose from:
- Harvest Towers: These generate resources for your carts. These towers must be placed next to their appropriate resource on the map.
- Upgrade Towers: These upgrade nearby harvest towers to improve their production speed. These either upgrade the harvest towers to the side of the upgrade tower, or above and below the upgrade tower, as shown by the symbols.

These towers have a range of stats:
- Resources per Load: How many resources are transferred to a cart each pass. This is increased by upgrade towers.
- Reload Speed: How long the tower waits before resource transfers. This is increased with tower level.
- Level: The level of the tower. This increases over time, which in turns increases reload speed.
- Cost: The amount of gold the tower costs.

At the start of the game, you can choose three starting towers. Click a tower to preview its stats, click "Add to Loadout", then "Start Game" once your towers are chosen.

These towers can then be placed on the map. Using the buttons down the side, click on a tower type, then click on the map to place it. Click on a placed tower at any time to sell it.

### Playing a round
Click the button to begin a round. You'll be offered to play an easy round, or a hard round which gives more gold. Make sure you have enough towers placed to supply the resources shown!

### Buying more towers
More towers can be purchased at the end of the round through the shop. Keep buying towers to ensure you have enough resources for the carts! You can have a maximum of 5 towers on the board at any time, and 5 towers in your inventory.

## Building from source
1. Open a command line interface inside the project directory and run `./gradlew jar` to create a packaged Jar. The Jar file is located at build/libs/seng201_team0-1.0-SNAPSHOT.jar
2. Navigate to the build/libs/ directory (you can do this with `cd build/libs`)
3. Run the command `java -jar seng201_team25-1.0-SNAPSHOT.jar` to open the application.

## Importing into IntelliJ
1. Clone the project: either download as a zip from the GitLab page and extract, or clone using ```git clone https://eng-git.canterbury.ac.nz/seng201-2024/team-25```
2. In IntelliJ, select File > Open, then select the "team-25" directory.
3. If requested, select "Trust" to open the project without enabling safe mode.
