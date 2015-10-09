import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Shaktimaan extends Character implements Subject
{
    private GreenfootImage[] arrImages; 
    private int lives; // Life of Players
    private int health; // Number of player health.
    private int points;
    
    private int numShots; //Number of shots that can make the player.
    private ShaktimaanState hasShotState;
    private ShaktimaanState outOfShotState;
    private ShaktimaanState currState = outOfShotState;
    
    private GreenfootSound explosionSound;
    private GreenfootSound shotPlayerSound;
    
    private PointsObserver obs;
    
    /**
     * Shaktimaan builder class. Shaktimaan images are loaded, variable life, health, and points are initialized. Attacks sounds are loaded.
     */
    public Shaktimaan()
    {
        arrImages = new GreenfootImage [3];
        arrImages[0] = new GreenfootImage("Shaktimaan.png");
        arrImages[1] = new GreenfootImage("Shaktimaan.png");
        arrImages[2] = new GreenfootImage("Shaktimaan.png");
        //lives = 3;vmi
		lives = 30;
        health = 50;
        this.setImage(arrImages[0]);
        numShots = 30;
        points=0;
        
        
        explosionSound = new GreenfootSound("explosionNave.wav");
        shotPlayerSound = new GreenfootSound("shotPlayer.wav");
       
        
        
        hasShotState = new HasShotState(this,shotTimer);
        outOfShotState = new OutOfShotState(this);
        if(numShots > 0){
            this.currState = hasShotState;
        }
        
        
    }
    
    /**
     * Act - do whatever the Shaktimaan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.mover();
        this.attack();
        this.isTouchingEnemy();        
        this.generateBonus();
        
    }    
    
      
        public void mover()
        {
                //   KinectWorld world = (KinectWorld)getWorld();
 Scenario world = (Scenario)getWorld();
        UserData[] users = world.getTrackedUsers();
       // System.out.println("inside"+users.length); 
//         if(Greenfoot.isKeyDown("right"))
//         {
//             this.setImage(arrImages[0]);
//             if(this.getX()+this.getImage().getWidth()/2 < getWorld().getWidth())
//                 this.setLocation(this.getX() + 5,this.getY());
//         }
//         else if(Greenfoot.isKeyDown("left"))
//         {
//             this.setImage(arrImages[0]);
//             if(this.getX()-this.getImage().getWidth()/2 > 0)
//                 this.setLocation(this.getX() - 5, this.getY());
//         }
//         else if(Greenfoot.isKeyDown("up"))
//         {
//             this.setImage(arrImages[1]);
//             if(this.getY()-this.getImage().getHeight()/2 > 0)
//                 this.setLocation(this.getX(), this.getY() - 5);
//         }
//         else if(Greenfoot.isKeyDown("down"))
//         {
//             this.setImage(arrImages[2]);
//             if(this.getY()+this.getImage().getHeight()/2 < getWorld().getHeight())
//                 this.setLocation(this.getX(), this.getY() + 5);
//         }
        for (UserData user : users)
        {
            Joint rightHand = user.getJoint(Joint.RIGHT_HAND);
            this.setLocation(rightHand.getX(), rightHand.getY());
            //getImage().fillOval(rightHand.getX(), rightHand.getY(), 20, 20);
            //System.out.println("Right hand coordinates"+rightHand.getX()+"          "+ rightHand.getY());

            if ((shotTimer.millisElapsed() > 500)&&(user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY()))
            {
                
                shotPlayerSound.play();
                currState.attackEnemy();
            }
        }
    }
    
    /**
     * When the player presses the spacebar, "Shaktimaan" will launch a shot. 
     * Each shot has a delay of 250 milliseconds.
     * When you press the letter z launches three rays.
     */
    public void attack()
    {
        
        if(shotTimer.millisElapsed() > 250){
          //  if(Greenfoot.isKeyDown("space")){
              
//                 shotPlayerSound.play();
//                 currState.attackEnemy();
            //}
        }
        
    }
    
    /**
     * Subtraction method 's' Player health.
     * And if health reaches 0 you subtract one life and restores 50 health.
     */
    public void reduceHealth(int s)
    {
        
        if(health > 0){
            health-=s;
            if(health <= 0){
                 lives--;
                 health = 50;
                 if(lives==0)
                    health=0;
            }
        }
        else if(health <= 0)
        {
            lives--;
            health = 50;
            if(lives==0)
                health=0;
        }
    }
    
    /**
     * Check if Shaktimaan touch an enemy and destroys it.
     */
    public void isTouchingEnemy()
    {
        Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
        Kazaki g = (Kazaki)getOneIntersectingObject(Kazaki.class);
        if(e!=null)
        {
            Scenario es = (Scenario)getWorld();
            es.reduceEnemies();
            explosionSound.play();
            getWorld().addObject(new Explosion(1), e.getX(), e.getY());
            getWorld().removeObject(e);
            this.reduceHealth(5);
        }
        else if(g!=null)
        {
            if(g.getHealth() > 0)
            {
                this.reduceHealth(1);
                getWorld().addObject(new Explosion(3), getX()+getImage().getWidth()/2, getY());
            }
        }
    }
    
  
    public int getLives()
    {
        return lives;
    }
    
   
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Returns the number of shots the player.
     */
    public int getNumShots()
    {
        return numShots;
    }
    
    
   
    public int getPoints()
    {
        return points;
    }
    
    
    /**
     * Assigns a number of shots
     */
    public void setNumShots(int d)
    {
        numShots = d;
    }
    
   
    public void setShots()
    {
        numShots = 100;
    }
    
    
    public void setHealth(int s)
    {
        health = s;
    }
    
    public void attach(PointsObserver points){
         Scenario scenario = (Scenario) getWorld();
         obs = scenario.getGamePoints();
    }
    
    /**
     * Assign a value to the points..
     */
    public void setPoints(int p)
    {
        points += p;
        notifyObservers();
    }
    
    public void notifyObservers(){
       
        obs.updatePoints(points); 
    }
    
    /**
     * Increase Life
     */
    public void increaseLife()
    {
        lives++;
    }
    
    /**
     * Randomly generated bonus throughout the game.
     */
    public void generateBonus()
    {
        if(numShots < 15)
        {
            if(Greenfoot.getRandomNumber(5000) < 20)
            {
                getWorld().addObject( new BonusShot(),
                Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
            }
        }
        
        if(Greenfoot.getRandomNumber(18000) < 5 && lives<5)
        {
            getWorld().addObject( new BonusLife(), 
            Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
        }
        
    }
    
   
    
    public void setCurrState(ShaktimaanState state) {
        this.currState = state;
    }
    
    public ShaktimaanState getOutOfShotState(){
        return this.outOfShotState;
    }
    
    public ShaktimaanState getHasShotState(){
        return this.hasShotState;
    }
}
