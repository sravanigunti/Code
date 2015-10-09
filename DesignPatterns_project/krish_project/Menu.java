import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class Menu extends World
{
    private GreenfootSound soundFondo;
    private ButtonPlay buttonPlay;
    private ButtonHelp buttonHelp;
    private PlayCommand playCmd;
    private HelpCommand helpCmd;
    protected GreenfootSound clicSound;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(1171, 550, 1, false); 
        
        soundFondo = new GreenfootSound("shootToThrill.mp3");
        buttonPlay = new ButtonPlay();
        buttonHelp = new ButtonHelp();
        playCmd = new PlayCommand();
        helpCmd = new HelpCommand();
        prepare();
    }
    
    public void act()
    {
    soundFondo.playLoop();
        if(Greenfoot.mouseClicked(buttonPlay) && soundFondo.isPlaying())
            soundFondo.stop();
    }
    
    /**
     * Place the buttons in the world
     */
    public void prepare()
    {
        addObject(buttonPlay, -400, 300);
        addObject(buttonHelp, -200, 200);        
        buttonPlay.setCommand(playCmd);
        buttonHelp.setCommand(helpCmd);

        playCmd.setReceiver(

            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonPlay)){
                        //clicSound.play();
                        Greenfoot.setWorld(new Scenario());
                    }
                }
            });

        helpCmd.setReceiver(
            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonHelp)){
                        //clicSound.play();
                        Help help = buttonHelp.getHelp();
                        addObject(help, getWidth()/2, getHeight()/2);

                        addObject(new Back(help), 
                            help.getX() - help.getImage().getWidth()/2,
                            help.getY() - help.getImage().getHeight()/2);

                    }
                }
            }
        );
    }
}
