import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaintingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario extends KinectWorld
{
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;
    private GreenfootImage imagenFondo,imagenFondo2;
    private long leftHandUp;
    //private Label leftHandWarning;
     private Shaktimaan shaktimaan;
    
    private GreenfootImage bgImage; // Background Image
    private GreenfootImage bgImage2;
    private GreenfootImage bgImageLevel2;  // Level2 Background Image
    private GreenfootImage bgImageLevel3; // Level3 Background Image
    
    private GreenfootSound bgSound;
    private GreenfootSound bgSound2;
    private GreenfootSound bgSound3;
    private GreenfootSound actualSound;
    
    private Counter cntLife;
    private Counter cntHealth;
    private Counter cntShots;
    private Counter cntEnemies;
    private Counter cntPoints;
    private Counter cntHealthKazaki;
    
    private GamePoints gamePoints;
    
    private int x;          //X-coordinate for the stage.
    private int x2;       
    
    private int numEnemies;
    private int level;
    private int levelCnt; //Counter to the level change.
    
    private boolean lostPlayer;
    
    private Kazaki gb;
    
    long lastAdded = System.currentTimeMillis(); //for delay in adding objects to the factory patternk 
        
    
    
    public Scenario()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
        //SkimagenFondo = imagenFondo2 = new GreenfootImage("escenario1500x600.png");
        final int width = getWidth();
        final int height = getHeight();
        
        
         bgImage = bgImage2 = new GreenfootImage("bg_1.jpg");
        x = 0;
        bgImageLevel2 = new GreenfootImage("bg_2.jpg");
        bgImageLevel3 = new GreenfootImage("bg_3.jpg");
        
        prepare();
        
        bgSound = new GreenfootSound("TN.mp3");
        bgSound2 = new GreenfootSound("EraTheMass.mp3");
        bgSound3 = new GreenfootSound("AcesHigh.mp3");
        
        numEnemies = 54;
        //level=1;vmi
		level=3;
        levelCnt = 0;
        
        lostPlayer = false;
        
        gb = new Kazaki();
        //addObject(new Krish(width, height), width/2, height/2);
        //addObject(new Instructions(), width/2, height/2);
        //addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);

        //Label instr = new Label("Use your right hand to paint, raise left hand to clear.", 20);
        //addObject(instr, instr.getImage().getWidth() / 2, getBackground().getHeight() - (instr.getImage().getHeight() / 2));

        //prepare(); 
    }
    
    public void act()
    {
        super.act();
        if (!isConnected())
            return;
        
        UserData[] us = getTrackedUsers();
        //getBackground().setColor(java.awt.Color.WHITE);
        //getBackground().fill();
        
        //boolean anyLeftHandUp = false;
        this.scroll();
         if(shaktimaan.getLives() > 0)
        {
            if(level == 1 )
            {   
                bgSound.playLoop();
                actualSound = bgSound;
                if(levelCnt == 0)
                {
                    preLevel1();
                    levelCnt++;
                }
                
                if(numEnemies < 54 && levelCnt >= 1)
                {
                    prepareLevel1();                   
                }
                
                if(numEnemies ==27 && levelCnt == 1)
                {
                    prepareLevel1();
                    addObject(new BonusShot(), 300,300);
                    addObject(new BonusShot(), 350,300);
                    addObject(new BonusShot(), 400,350);
                    levelCnt++;
                }
                else if(numEnemies == 0 /*&& contCambioNivel == 2*/)
                {
                    level++;
                    levelCnt=0;
                    if(bgSound.isPlaying())
                        bgSound.stop();
                }
                this.scroll();
            }
            else if(level == 2 /*&& contCambioNivel == 0*/)
            {
                bgSound2.playLoop();
                actualSound = bgSound2;
                if(levelCnt == 0)
                {
                    bgImage = bgImage2 = bgImageLevel2;
                    addObject(new Notice("Level 2", false), getWidth()/2, getHeight()/2);
                    //cntEnemies.setValue(60);
					cntEnemies.setValue(60);
                   // numEnemies = 60;vmi
                   numEnemies = 60;
                    //shaktimaan.setEnergia(100);
                    shaktimaan.setShots();
                    shaktimaan.setHealth(50);
                    prepareLevel2();
                    levelCnt++;
                }
                //vmi
                if(numEnemies > 0 /*&& levelCnt==1*/)
                {
                    prepareLevel2();                
                }
				// if(numEnemies == 3)
				// {
					// levelCnt++;
				// }
                //vmi end
                // if(levelCnt == 2 && numEnemies < 3)
                // {
                    // prepareLevel2();
                    // addObject(new BonusShot(), 400,300);
                    // //levelCnt++;
                // }
                // if(numEnemies == 0 && levelCnt==2)
                // {
                   // levelCnt++;    
                // }
                if(numEnemies == 0 && shaktimaan.getLives() >= 1 /*&& levelCnt == 3*/)
                {
                    levelCnt=0;
                    level++;
                    if(bgSound2.isPlaying())
                        bgSound2.stop();
                }
                
                this.scroll();
            }
            else if(level == 3)
            {
                bgSound3.playLoop();
                actualSound = bgSound3;
                if(levelCnt == 0)
                {
                    prepareLevel3();
                    addObject(new Notice("Final Level", false), getWidth()/2, getHeight()/2);
                    getBackground().drawImage(bgImageLevel3,0,0);
                   // shaktimaan.setEnergia(100);
                    shaktimaan.setNumShots(shaktimaan.getNumShots() + 200); 
                    shaktimaan.setHealth(50);
                    
                    levelCnt++;
                }
                if(gb.getHealth()<=0)
                {
                    //addObject(new Aviso("GANASTE!!!", true), getWidth()/2, getHeight()/2);
                    if(bgSound3.isPlaying())
                        bgSound3.stop();
                }
                cntHealthKazaki.setPrefix("KAAL: " + gb.getHealth() + "/80");
            }
        }
        else if(shaktimaan.getLives() <= 0 && lostPlayer == false) 
        {
            addObject(new Notice("LOST!!!", true), getWidth()/2, getHeight()/2);
            lostPlayer = true;
        }
        this.updateCounters();
    }
    public void scroll()
    {
        getBackground().drawImage(bgImage,x,0);
        x-=10;
        if(x == -500)
            x2 = 1000;
        if(x < -500)
        {
            getBackground().drawImage(bgImage2,x2,0);
            x2-=10;
        }
        if(x == -1500)
            x = 0;
    }
    
    
 
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        shaktimaan = new Shaktimaan();
        addObject(shaktimaan, 93, 249);

        cntLife = new Counter("Hearts = ");
        cntHealth = new Counter("Health = ");
        cntShots= new Counter("Power = ");
        cntEnemies = new Counter();
        cntPoints = new Counter("Points = ");
        gamePoints = new GamePoints(0);

        cntLife.setValue(shaktimaan.getLives());
        cntHealth.setValue(shaktimaan.getHealth());
        cntShots.setValue(shaktimaan.getNumShots());
        cntEnemies.setPrefix("Enemies = " + numEnemies + "/");
        cntEnemies.setValue(54);
        cntPoints.setValue(shaktimaan.getPoints());

        addObject(cntLife,55,15);
        addObject(cntHealth,170,15);
        addObject(cntShots,305,15);
        addObject(cntEnemies, 900, 15);
        addObject(cntPoints, 630, 15);
        shaktimaan.attach(gamePoints);
        addObject(gamePoints,630,15);
        
    }
    
    public GamePoints getGamePoints(){
        return gamePoints;
    }
    
     /**
     * Puts enemies in the world of level 1.
     */
    private void preLevel1()
    {
        EnemyFactory theEnemyFactory = new EnemyFactory();
        Enemy  theEnemy = null;       
        int enemyType = Greenfoot.getRandomNumber(3);  
		if(enemyType >= 0) {
       // if((enemyType >= 0)&& (enemyType != 1)){
            theEnemy = theEnemyFactory.selectEnemyFactory(enemyType);
            addObject(theEnemy, Greenfoot.getRandomNumber(5000), Greenfoot.getRandomNumber(450));
            //prepareLevel3();//for testing purpose
        }
        
        
    }
    
    private void prepareLevel1()
    {
        EnemyFactory theEnemyFactory = new EnemyFactory();
        Enemy  theEnemy = null;
        long curTime  = System.currentTimeMillis();
        int enemyType = Greenfoot.getRandomNumber(3);
		if(enemyType >= 0 &&  curTime >= lastAdded + 1500)
		{
               
            theEnemy = theEnemyFactory.selectEnemyFactory(enemyType);
            addObject(theEnemy, Greenfoot.getRandomNumber(5000), Greenfoot.getRandomNumber(450));
            lastAdded  = curTime;
        }
        
    }
    
    
    /**
     * Puts enemies in the world of level 2.
     */
    private void prepareLevel2()
    {
		EnemyFactory theEnemyFactory = new EnemyFactory();
        Enemy  theEnemy = null;
        long curTime  = System.currentTimeMillis();
        int enemyType = Greenfoot.getRandomNumber(3);
		if(enemyType >= 0 &&  curTime >= lastAdded + 1500)
		{
               
            theEnemy = theEnemyFactory.selectEnemyFactory(enemyType);
            addObject(theEnemy, Greenfoot.getRandomNumber(5000), Greenfoot.getRandomNumber(450));
            lastAdded  = curTime;
        }
        // Fighter kamikase = new Fighter(); //1
        // addObject(kamikase, 2000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase2 = new Fighter();//2
        // addObject(kamikase2, 2600, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase3 = new Fighter();//3
        // addObject(kamikase3, 3000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase4 = new Fighter();//4
        // addObject(kamikase4, 3500, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase5 = new Fighter();//5
        // addObject(kamikase5, 6000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase6 = new Fighter();//6
        // addObject(kamikase6, 6000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase7 = new Fighter();//7
        // addObject(kamikase7, 8000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase8 = new Fighter();//8
        // addObject(kamikase8, 9000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase9 = new Fighter();//9
        // addObject(kamikase9, 10000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase10 = new Fighter();//10
        // addObject(kamikase10, 12000, Greenfoot.getRandomNumber(400)+50);
        // Fighter kamikase11 = new Fighter();//11
        // addObject(kamikase11, 12050, Greenfoot.getRandomNumber(400)+50);
        
        // Captain capitan = new Captain();//1
        // addObject(capitan, 3500, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan2 = new Captain();//2
        // addObject(capitan2, 4000, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan3 = new Captain();//3
        // addObject(capitan3, 4600, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan4 = new Captain();//4
        // addObject(capitan4, 6000, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan5 = new Captain();//5
        // addObject(capitan5, 6000, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan6 = new Captain();//6
        // addObject(capitan6, 7000, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan7 = new Captain();//7
        // addObject(capitan7, 9000, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan8 = new Captain();//8
        // addObject(capitan8, 10500, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan9 = new Captain();//9
        // addObject(capitan9, 13000, 150);
        // Captain capitan10 = new Captain();//10
        // addObject(capitan10, 13100, 200);
        // Captain capitan11 = new Captain();//11
        // addObject(capitan11, 13200, 250);
        // Captain capitan12 = new Captain();//12
        // addObject(capitan12, 13100, 300);
        // Captain capitan13 = new Captain();//13
        // addObject(capitan13, 13000, 350);
        // Captain capitan14 = new Captain();//14
        // addObject(capitan14, 14000, Greenfoot.getRandomNumber(400)+50);
        // Captain capitan15 = new Captain();//15
        // addObject(capitan15, 14000, Greenfoot.getRandomNumber(400)+50);
        
        // Colonel coronel = new Colonel();//1vmi
        // addObject(coronel,9000,Greenfoot.getRandomNumber(400)+50);
        // Colonel coronel2 = new Colonel();//2
        // addObject(coronel2, 11000,Greenfoot.getRandomNumber(400)+50);
        // Colonel coronel3 = new Colonel();//3
        // addObject(coronel3, 14000,Greenfoot.getRandomNumber(400)+50);
        // Colonel coronel4 = new Colonel();//4
        // addObject(coronel4, 14500,Greenfoot.getRandomNumber(400)+50);
    }
    
    /**
     * Puts enemies in the world of level 3.
     */
    public void prepareLevel3()
    {
        
        addObject(gb, getWidth()+gb.getImage().getWidth(), getHeight()/2);
        
        removeObject(cntEnemies);
        
        cntHealthKazaki = new Counter();
        cntHealthKazaki.setPrefix("KAAL: " + gb.getHealth() + "/80");
        addObject(cntHealthKazaki, 925, 485);
    }
    
    
    public Shaktimaan getShaktimaan()
    {
        return shaktimaan;
    }
    
    /**
     * You keep the counters in the world.
     */
    public void updateCounters()
    {
        cntLife.setValue(shaktimaan.getLives());
        cntHealth.setValue(shaktimaan.getHealth());
        cntShots.setValue(shaktimaan.getNumShots());
        cntEnemies.setPrefix("Enemies = " + numEnemies + "/");
        cntPoints.setValue(shaktimaan.getPoints());
       //gamePoints.updatePoints(ironman.getPuntos());
    }
    
    /**
     * Subtract by one the number of enemies
     */
    public void reduceEnemies()
    {
        numEnemies--;
    }
    
    
    public int getLevel()
    {
        return level;
    }
    
    /**
     * .
     */
    public GreenfootSound getActualSound()
    {
        return actualSound;
    }
    
}

