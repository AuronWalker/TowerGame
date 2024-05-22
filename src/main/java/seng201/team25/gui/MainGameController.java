package seng201.team25.gui;
import javafx.event.Event;
import javafx.scene.control.TabPane;
import seng201.team25.models.Tower;
import seng201.team25.models.Round;
import seng201.team25.models.Tile;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import seng201.team25.services.AvailableTowerManager;
import seng201.team25.services.GameOverManager;
import seng201.team25.services.GoldManager;
import seng201.team25.services.RoundManager;
import seng201.team25.services.WindowManager;

public class MainGameController {
    @FXML private ImageView roadTile;
    @FXML private ImageView roadTile1;
    @FXML private ImageView roadTile2;
    @FXML private ImageView roadTile3;
    @FXML private ImageView roadTile4;
    @FXML private ImageView roadTile5;
    @FXML private ImageView roadTile6;
    @FXML private ImageView roadTile7;
    @FXML private ImageView placeTile;
    @FXML private ImageView placeTile1;
    @FXML private ImageView placeTile2;
    @FXML private ImageView placeTile3;
    @FXML private ImageView placeTile4;
    @FXML private ImageView placeTile5;
    @FXML private ImageView placeTile6;
    @FXML private ImageView placeTile7;
    @FXML private ImageView placeTile8;
    @FXML private ImageView placeTile9;
    @FXML private ImageView placeTile10;
    @FXML private ImageView placeTile11;
    @FXML private ImageView placeTile12;
    @FXML private ImageView placeTile13;
    @FXML private ImageView placeTile14;
    @FXML private ImageView placeTile15;
    @FXML private ImageView displayTile;
    @FXML private ImageView displayTile1;
    @FXML private ImageView displayTile2;
    @FXML private ImageView displayTile3;
    @FXML private ImageView displayTile4;
    @FXML private ImageView displayTile5;
    @FXML private ImageView displayTile6;
    @FXML private ImageView displayTile7;
    @FXML private ImageView displayTile8;
    @FXML private ImageView displayTile9;
    @FXML private ImageView displayTile10;
    @FXML private ImageView displayTile11;
    @FXML private ImageView displayTile12;
    @FXML private ImageView displayTile13;
    @FXML private ImageView displayTile14;
    @FXML private ImageView displayTile15;

    @FXML private Button woodTowerButton;
    @FXML private Button stoneTowerButton;
    @FXML private Button fruitTowerButton;
    @FXML private Button verticalTowerButton;
    @FXML private Button horizontalTowerButton;
    @FXML private Button startButton;
    @FXML private Button shopButton;
    @FXML private Button restartButton;
    @FXML private Button quitButton;
    @FXML private Button easyRoundButton;
    @FXML private Button hardRoundButton;

    @FXML private Label goldLabel;
    @FXML private Label roundLabel;
    @FXML private Label info;

    // Shop elements
    @FXML ImageView imgTower0;
    @FXML ImageView imgTowerSelected;
    @FXML Label lblTowerName;
    @FXML Label txtStatus;
    @FXML Label lblBalance;
    @FXML Label lblResources;
    @FXML Label lblReloadSpeed;
    @FXML Label lblLevel;
    @FXML Label lblCost;
    

    private int recurrentPurchaseCounter = 1;


    // Tower data
    private final Tower[] towersToBuy = AvailableTowerManager.getTowersToBuy();
    private Tower selectedTower = towersToBuy[0];
    private ImageView selectedTowerElement;

    @FXML
    TabPane gameTabs;

    private Image roadTileSprite = new Image(getClass().getResourceAsStream("/assets/roadTiles/road1.png"));
    private Image roadTileSprite1 = new Image(getClass().getResourceAsStream("/assets/roadTiles/road2.png"));
    private Image roadTileSprite2 = new Image(getClass().getResourceAsStream("/assets/roadTiles/road3.png"));
    private Image roadTileSprite3 = new Image(getClass().getResourceAsStream("/assets/roadTiles/road4.png"));
    private Image roadTileSprite4 = new Image(getClass().getResourceAsStream("/assets/roadTiles/road5.png"));

    private Image grassTileLeftSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/leftTiles/grassTile1.png"));
    private Image grassTileLeftSprite1 = new Image(getClass().getResourceAsStream("/assets/mainTiles/leftTiles/grassTile2.png"));
    private Image grassTileLeftSprite2 = new Image(getClass().getResourceAsStream("/assets/mainTiles/leftTiles/grassTile3.png"));
    private Image grassTileLeftSprite3 = new Image(getClass().getResourceAsStream("/assets/mainTiles/leftTiles/grassTile4.png"));

    private Image rockTileLeftSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/leftTiles/rockTile.png"));
    private Image treeTileLeftSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/leftTiles/treeTile.png"));
    private Image fruitTileLeftSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/leftTiles/fruitTile.png"));

    private Image grassTileRightSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/rightTiles/grassTile1.png"));
    private Image grassTileRightSprite1 = new Image(getClass().getResourceAsStream("/assets/mainTiles/rightTiles/grassTile2.png"));
    private Image grassTileRightSprite2 = new Image(getClass().getResourceAsStream("/assets/mainTiles/rightTiles/grassTile3.png"));
    private Image grassTileRightSprite3 = new Image(getClass().getResourceAsStream("/assets/mainTiles/rightTiles/grassTile4.png"));

    private Image rockTileRightSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/rightTiles/rockTile.png"));
    private Image treeTileRightSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/rightTiles/treeTile.png"));
    private Image fruitTileRightSprite = new Image(getClass().getResourceAsStream("/assets/mainTiles/rightTiles/fruitTile.png"));

    private Image emptyDisply = new Image(getClass().getResourceAsStream("/assets/displayTiles/empty.png"));

    @FXML private AnchorPane anchorPane;

    private List<ImageView> displayTiles;
    private List<Tower> activeTowers;
    private List<Integer> tileResources;
    private List<Integer> amountOfTowers;
    private List<Tile> allTiles;
    private List<Button> selectButtons;
    private int placement = 0;

    //0 = wood, 1 = stone, 2 = fruit
    private int currentSelectedButton = -1;

    private WindowManager windowManager;
    private RoundManager rm;

    /**
    * Added to allow calling of new windows (i.e shop) from the main game
    * Would use windowManager.toShopWindow(), although not yet implemented
    * @param newWindowManager games class for loading different classes
    **/
    public MainGameController(WindowManager newWindowManager) {
        this.windowManager = newWindowManager;
    }

    public MainGameController() {}

    public void initialize() {
        rm = new RoundManager(roundLabel);
        GameOverManager.gameOver = false;

        //Hiding all buttons till needed
        restartButton.setVisible(false);
        quitButton.setVisible(false);
        hideRoundInfo();

        restartButton.setOnAction(event -> {
            windowManager.toTowerScreen();
        });

        quitButton.setOnAction(event -> {
            Stage stage = (Stage) restartButton.getScene().getWindow();
            stage.close();
        });

        activeTowers = new ArrayList<Tower>();
        tileResources = new ArrayList<Integer>();
        allTiles = new ArrayList<Tile>();
        generateLevel();
        setRoundButton();

        goldLabel.setText("Gold: " + GoldManager.getGoldBalance());
        roundLabel.setText(rm.getCurrentRound() + "/" + rm.getMaxRounds());

        lblBalance.setText(String.valueOf(GoldManager.getGoldBalance()));
        selectedTowerElement = imgTower0;
    }

    /**
    * Called by game over manager to show restart and quit buttons.
    * Turning off visible rathering than removing to avoid werid error.
    **/
    public void displayButtons(){
        restartButton.setVisible(true);
        quitButton.setVisible(true);
        System.out.println();
    }

    /**
    * Shop button logic that takes you to shop.
    **/
    public void openShop(){
        gameTabs.getSelectionModel().select(1);
    }
    public void closeShop(){
        setupSelectButtons(selectButtons);
        gameTabs.getSelectionModel().select(0);
    }

    /**
    * Start round button logic the creates a new round and hides the button so multiple rounds cant be running at once.
    **/
    private void setRoundButton(){
        startButton.setOnAction(event -> {
            //Code takes u into the next round.
            info.setVisible(true);
            startButton.setVisible(false);
            shopButton.setVisible(false);
            rm.displayRoundButton(easyRoundButton, true, activeTowers, anchorPane, startButton, shopButton, this, rm);
            rm.displayRoundButton(hardRoundButton, false, activeTowers, anchorPane, startButton, shopButton, this, rm);
        });
    }    

    /**
    * Hides round select info so multiple rounds cant be called.
    **/
    public void hideRoundInfo(){
        easyRoundButton.setVisible(false);
        hardRoundButton.setVisible(false);
        info.setVisible(false);
    }

    /**
    * Generates the level layout for the game.
    * Loops through each side of the road setting tiles to random resources
    **/
    private void generateLevel(){
        List<ImageView> roadTiles = List.of(roadTile, roadTile1, roadTile2, roadTile3, roadTile4, roadTile5, roadTile6, roadTile7);
        List<ImageView> leftTiles = List.of(placeTile, placeTile1, placeTile2, placeTile3, placeTile4, placeTile5, placeTile6, placeTile7);
        List<ImageView> rightTiles = List.of(placeTile8, placeTile9, placeTile10, placeTile11, placeTile12, placeTile13, placeTile14, placeTile15);
        displayTiles = List.of(displayTile, displayTile1, displayTile2, displayTile3, displayTile4, displayTile5, displayTile6, displayTile7, displayTile8, displayTile9, displayTile10, displayTile11, displayTile12, displayTile13, displayTile14, displayTile15);

        List<Image> roadTileSprites = List.of(roadTileSprite, roadTileSprite1, roadTileSprite2, roadTileSprite3, roadTileSprite4);
        List<Image> leftGrassTileSprites = List.of(grassTileLeftSprite, grassTileLeftSprite1, grassTileLeftSprite2, grassTileLeftSprite3);
        List<Image> rightGrassTileSprites = List.of(grassTileRightSprite, grassTileRightSprite1, grassTileRightSprite2, grassTileRightSprite3);

        selectButtons = List.of(woodTowerButton, stoneTowerButton, fruitTowerButton, verticalTowerButton, horizontalTowerButton);
        setupSelectButtons(selectButtons);

        Random rng = new Random();

        //Road Generation
        for (ImageView roadTile : roadTiles) {
            int randomInt = rng.nextInt(roadTileSprites.size());
            roadTile.setImage(roadTileSprites.get(randomInt));
        }

        //Set display Tiles
        for (ImageView displayTile : displayTiles) {
            displayTile.setImage(emptyDisply);
        }

        //Left side Generation
        generateTile(leftTiles, leftGrassTileSprites, true, rng);
        //Right side Generation
        generateTile(rightTiles, rightGrassTileSprites, false, rng);
    }

    /**
    * Loops through the buttons for placing towers setting it to active if clicked
    * The resource for towers is indicated with the index to allow for easier scaling when adding buttons
    * @param selectButtons buttons used to place towers
    **/
    private void setupSelectButtons(List<Button> selectButtons){
        this.amountOfTowers = new ArrayList<Integer>();
        for (int i = 0; i < selectButtons.size(); i++) {
            int finalI = i; // variables used within lambdas must be final
            int amountOfTower = AvailableTowerManager.numberOfTowers(i);
            amountOfTowers.add(amountOfTower);
            Button currentButton = selectButtons.get(i);
            String startingString = currentButton.getText();
            startingString = startingString.split("x")[0];
            currentButton.setText(startingString + "x" + amountOfTower);

            currentButton.setOnAction(event -> {
                currentSelectedButton = finalI;
                selectButtons.forEach(button -> {
                    if (button == selectButtons.get(finalI)) {
                        button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                    } else {
                        button.setStyle("");
                    }
                });
            });
        }
    }

    /**
    * Assigns a resource to each tile and assigns event to empty tile.
    * @param tiles list of tiles to give resource to.
    * @param tileImages list of random grass sprites that are assigned randomly to empty tile.
    * @param directionLeft the direction of the list of tiles
    * @param rng Random class to generate random nums
    **/
    private void generateTile(List<ImageView> tiles, List<Image> tileImages, boolean directionLeft, Random rng){
        boolean notGrass = false;
        int currentTile = -1;
        for (ImageView tile : tiles) {
            int tileType = rng.nextInt(5);
            int randomInt = rng.nextInt(tileImages.size());
            Image grassImage = tileImages.get(randomInt);
            Tile newTile = new Tile();
            allTiles.add(newTile);
            currentTile += 1;

            //Making so all resources are on the map at least once.
            if(currentTile == tiles.size()-1) {
                tileType = 3;
                notGrass = false;
            }else if(currentTile == 0 && !directionLeft) {
                tileType = 1;
                notGrass = false;
            }else if(currentTile == 0 && directionLeft) {
                tileType = 4;
                notGrass = false;
            }
            else if(currentTile == tiles.size()-2) notGrass = true;

            //Makes sure to trees/rocks wont spawn beside each other
            if(notGrass == true){
                tile.setImage(grassImage);
                tile = placeTowerEvent(tile, directionLeft, placement, newTile, grassImage);
                tileResources.add(-1);
                notGrass = false;
                placement += 1;
                continue;
            }

            //Selecting of resource.
            if(tileType == 0 ){
                tile.setImage(grassImage);
                tile = placeTowerEvent(tile, directionLeft, placement, newTile, grassImage);
                tileResources.add(-1);
            }else if(tileType == 1){
                setTile(directionLeft, tile, rockTileLeftSprite, rockTileRightSprite, 1);
                notGrass = true;
            }else if(tileType == 2 || tileType == 3) {
                setTile(directionLeft, tile, treeTileLeftSprite, treeTileRightSprite, 0);
                notGrass = true;
            }else if(tileType == 4) {
                setTile(directionLeft, tile, fruitTileLeftSprite, fruitTileRightSprite, 2);
                notGrass = true;
            }
            placement += 1;
        }
    }

    /**
    * Set sprite of tile to specific sprite based on direction.
    * @param directionLeft the direction of the list of tiles.
    * @param tile Image view to set sprite of.
    * @param tileLeftSprite Image of sprite facing left.
    * @param tileRightSprite Image of sprite facing right.
    * @param resourceType The type of resource to set tile to.
    **/
    private void setTile(boolean directionLeft, ImageView tile, Image tileLeftSprite, Image tileRightSprite, int resourceType){
        if(directionLeft) tile.setImage(tileLeftSprite);
        else tile.setImage(tileRightSprite);
        tileResources.add(resourceType);
    }
    
    /**
    * Places a tower when clicking on a empty tile.
    * Sells tower when clicking on a tower.
    * @param emptyTile Image view that is being clicked.
    * @param directionLeft the direction of the tile.
    * @param placement Int that shows the index in tiles.
    * @param tileObj Tile object that was clicked.
    * @param grassImage Empty tile sprite that was assgined to tile
    **/
    private ImageView placeTowerEvent(ImageView emptyTile, boolean directionLeft, int placement, Tile tileObj, Image grassImage){
        emptyTile.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("You clicked");
            int numOfTower = amountOfTowers.get(currentSelectedButton);

            //Selling a tower if it is placed on the tile
            displayTile = displayTiles.get(placement);
            if(allTiles.get(placement).hasTower()){
                Tower currentTower = allTiles.get(placement).getTower();
                activeTowers.remove(currentTower);

                allTiles.get(placement).sellTower();
                updateGoldLabels();
                
                emptyTile.setImage(grassImage);
                displayTile.setImage(emptyDisply);
                return;
            }

            if(currentSelectedButton == -1) return;
            if(numOfTower == 0) return;
            if(activeTowers.size() > 5) return; // ADD A MESSAGE HERE - untested
            if(tileResources.get(placement-1) != currentSelectedButton && tileResources.get(placement+1) != currentSelectedButton && currentSelectedButton <= 2) return;

            
            Tower newTower = new Tower(currentSelectedButton, emptyTile, displayTile, directionLeft);
            AvailableTowerManager.removeTowerOfType(currentSelectedButton);
            tileObj.setTower(newTower);
            activeTowers.add(newTower);

            List<Image> towerSprites = newTower.getTileImage();
            emptyTile.setImage(towerSprites.get(0));
            displayTile.setImage(towerSprites.get(1));

            //Logic for upgrade towers
            if ( currentSelectedButton == 3 ){
                if(allTiles.get(placement + 1).hasTower()) allTiles.get(placement + 1).getTower().increaseLevel();
                if(allTiles.get(placement - 1).hasTower()) allTiles.get(placement -1).getTower().increaseLevel();
            } else if ( currentSelectedButton == 4 ){
                if(placement <= 7){
                    if(!allTiles.get(placement + 8).hasTower()) return;
                    allTiles.get(placement + 8).getTower().increaseLevel();
                }else{
                    if(!allTiles.get(placement - 8).hasTower()) return;
                    allTiles.get(placement - 8).getTower().increaseLevel();
                }         
            }

            //Removing the number of placed tower by one and displaying that in the button
            amountOfTowers.set(currentSelectedButton, numOfTower-=1);
            Button currentButton = selectButtons.get(currentSelectedButton);
            String buttonText = currentButton.getText();
            currentButton.setText(buttonText.substring(0, buttonText.length()-1) + numOfTower);

            event.consume();
        });
        return emptyTile;
    }

    public void towerSelected(Event event) {
        txtStatus.setVisible(false);
        ImageView pressedTower = (ImageView) event.getSource();
        if ( pressedTower == selectedTowerElement ) { return; }

        // Get Resource ID, Tower model and resource string for selected tower
        int selectedTowerResourceID = Integer.parseInt(pressedTower.getId().substring(pressedTower.getId().length() - 1));
        selectedTower = Arrays.stream(towersToBuy)
                .filter(tower -> (tower.getResourceType() == selectedTowerResourceID))
                .findFirst()
                .orElse(null);

        String resourceString = AvailableTowerManager.getResourceTypeString(selectedTowerResourceID);
        lblTowerName.setText(String.format("%s Tower", resourceString));

        pressedTower.setOpacity(1);

        selectedTowerElement.setOpacity(0.4);
        selectedTowerElement = pressedTower;

        imgTowerSelected.setImage(selectedTowerElement.getImage());
        lblResources.setText(String.valueOf(selectedTower.getResourceAmount()));
        if ( selectedTower.getReloadSpeed() < 0 ) lblReloadSpeed.setText("x" + String.valueOf(-1 * selectedTower.getReloadSpeed()));
        else lblReloadSpeed.setText(String.valueOf(selectedTower.getReloadSpeed()));
        lblLevel.setText(String.valueOf(selectedTower.getLevel()));
        lblCost.setText(String.valueOf(selectedTower.getCost()));
    }

    public void buySelectedTower() {
        int newGoldBalance = GoldManager.decreaseGoldBalance(selectedTower.getCost());
        if (newGoldBalance == -1) {
            txtStatus.setText("Insufficient Gold!");
            txtStatus.setVisible(true);
        } else if (AvailableTowerManager.numberOfTowers() >= 5) {
            txtStatus.setText("Inventory Full!");
            txtStatus.setVisible(true);
        } else {
            updateGoldLabels();
            String resourceString = AvailableTowerManager.getResourceTypeString(selectedTower.getResourceType());
            if ( txtStatus.isVisible() ) {
                recurrentPurchaseCounter += 1;
                txtStatus.setText(String.format("Purchased %d %s towers!", recurrentPurchaseCounter, resourceString));
            } else {
                recurrentPurchaseCounter = 1;
                txtStatus.setText(String.format("Purchased 1 %s tower!", resourceString));
            }

            txtStatus.setVisible(true);
            AvailableTowerManager.addAvailableTower(new Tower(selectedTower.getResourceType()));
        }
    }

    public void updateGoldLabels(){
        goldLabel.setText("Gold: " + GoldManager.getGoldBalance());
        lblBalance.setText(""+GoldManager.getGoldBalance());
    }
}