import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    private final int panelHorizontal = 600;
    private final int panelVertical = 600;
    private final int unitSize = 25;
    private final int unitCount = (panelHorizontal* panelVertical)/unitSize;

    //Snack body related fields
    private int bodyParts= 6;
    private int[] snakePartX = new int[unitCount];
    private int[] snakePartY = new int[unitCount];
    private int eatenApples =0;

    //Movement related
    private char direction = 'R';
    private boolean isRunning =true;

    //Apple related fields
    private int appleX;
    private int appleY;

    private final int delay = 75;     //use for game to start in delay time
    //set up for game loop
    Timer timer ;   //this for game loop
    Random random;

    GamePanel(){
        random = new Random();
        this.addKeyListener(new KeyController());
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(panelVertical,panelHorizontal));
        this.setBackground(Color.LIGHT_GRAY);
        gameStart();
    }

    private void gameStart() {
        timer = new Timer(delay, this);
        timer.start();
        appleCorrdiant();
    }

    private void appleCorrdiant() {
        appleX = random.nextInt((int)(panelHorizontal/unitSize)) * unitSize;
        appleY = random.nextInt((int)(panelVertical/unitSize)) * unitSize;

    }

    private void moving(){
        for(int i = bodyParts; i>0; i--){
            snakePartX[i] = snakePartX[i-1];
            snakePartY[i] = snakePartY[i-1];
        }
        switch (direction){
            case 'U':
                snakePartY[0] -= unitSize ;
                break;
            case 'D':
                snakePartY[0] += unitSize;
                break;
            case 'L':
                snakePartX[0] -=unitSize;
                break;
            case 'R':
                snakePartX[0] += unitSize;
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        if(isRunning){
            //Draw horizontal indication lines
            for(int i =0; i <panelHorizontal/unitSize; i++){
                g.setColor(new Color(163, 163, 163));
                g.drawLine(i*unitSize,0,i*unitSize,panelVertical );
            }
            //Draw vertical indication lines
            for(int i=0; i<panelVertical/unitSize; i++){
                g.setColor(new Color(143, 143, 143));
                g.drawLine(0,i*unitSize,panelHorizontal,i*unitSize);
            }

            //drawing the apple
            g.setColor(new Color(255, 87, 51));
            g.fillOval(appleX, appleY, unitSize , unitSize);

            //drawing the snake
            for(int i=0; i<bodyParts; i++){
                if(i==0){
                    g.setColor(new Color(138, 154, 91));
                    g.fillRect(snakePartX[i],snakePartY[i],unitSize,unitSize);
                }
                else {
                    g.setColor(new Color(128, 128, 0));
                    g.fillRect(snakePartX[i],snakePartY[i],unitSize,unitSize);
                }
                g.setColor(new Color(151, 29, 29));
                g.setFont(new Font("Arial",Font.BOLD,20));
                g.drawString("Score : "+String.valueOf(eatenApples),75,50);

            }
        }
        else
            gameOver(g);
    }

    private void gameOver(Graphics g) {
        g.setColor(new Color(151, 29, 29));
        g.setFont(new Font("Arial",Font.BOLD,75));
        g.drawString("GAME OVER",75,250);

        g.setColor(new Color(151, 29, 29));
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("Score : "+String.valueOf(eatenApples),200,315);
    }

    public void checkCollision(){
        for(int i =bodyParts ; i>0; i--){
            //check for head hitting the body
            if(snakePartX[0] == snakePartX[i] && snakePartY[0] == snakePartY[i])
                isRunning = false;
        }
        if(snakePartX[0] > panelVertical || snakePartX[0]<0)
            isRunning = false;
        if(snakePartY[0]> panelHorizontal|| snakePartY[0]<0)
            isRunning = false;

        //if collision occurs
        if(!isRunning){
            timer.stop();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(isRunning){
            moving();
            checkCollision();
            checkAppleEatten();
        }
        repaint();
    }

    private void checkAppleEatten() {
        if(snakePartX[0]==appleX && snakePartY[0] == appleY){
            eatenApples++;
            bodyParts++;
            appleCorrdiant();
        }
    }

    public class KeyController extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_A :
                    if(direction !='R')
                        direction ='L';
                    break;
                case KeyEvent.VK_D:
                    if(direction !='L')
                        direction ='R';
                    break;
                case KeyEvent.VK_W:
                    if(direction != 'D')
                        direction ='U';
                    break;
                case KeyEvent.VK_S:
                    if(direction != 'U')
                        direction ='D';
                    break;
            }
        }
    }

}
