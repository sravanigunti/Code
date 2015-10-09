// import greenfoot.*;
// 
// public class Krish extends Actor
// {
//      private GreenfootImage krish2;
// 	 
//     public Krish(int width, int height)
//     {
// 	    
//         //getImage().setColor(java.awt.Color.GREEN);		
// 		krish2 = new GreenfootImage("Krishimg.png");		
//         setImage(krish2);
//     }
// 
//     public void act() 
//     {
//         
//         this.mover();
//         this.attack();
// }
// 
//     public void mover()
//     {
//         Scenario world = (Scenario)getWorld();
//         UserData[] users = world.getTrackedUsers();
//         for (UserData user : users)
//         {
//             Joint rightHand = user.getJoint(Joint.RIGHT_HAND);
//             //getImage().fillOval(rightHand.getX(), rightHand.getY(), 20, 20);
// 			setLocation(rightHand.getX(), rightHand.getY());
//             //System.out.println("brushing");
// 
//              // if (user.getJoint(Joint.LEFT_HAND).getY() > user.getJoint(Joint.HEAD).getY())
//              // {
//                 // // getImage().clear();
// 				// setLocation(rightHand.getX()()+10,rightHand.getY());
//              // }
//         }
//     }
//     
//     /**
//      * When the player presses the spacebar, "Shaktimaan" will launch a shot. 
//      * Each shot has a delay of 250 milliseconds.
//      * When you press the letter z launches three rays.
//      */
//     public void attack()
//     {
//         
//         ///if(shotTimer.millisElapsed() > 250){
//             if(Greenfoot.isKeyDown("space")){
//                // shotPlayerSound.play();
//               getWorld().addObject(new Attack(), this.getX()+getImage().getWidth()/2, this.getY());
//              //   currState.attackEnemy();
//             }
//       // }
//         
//     }
// }