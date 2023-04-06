import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BlackjackGUI extends JPanel {
    JPanel topPanel = new JPanel();
    JPanel dcardPanel = new JPanel();
    JPanel pcardPanel = new JPanel();
    JTextPane winlosebox = new JTextPane();
    JButton hitbutton = new JButton();
    JButton dealbutton = new JButton();
    JButton staybutton = new JButton();
    JButton playagainbutton = new JButton();
    JLabel dealerlabel = new JLabel();
    JLabel playerlabel = new JLabel();

    //TODO: remove java docs bcuz they're trash
    Hand dealer = new Hand();    //to hold the dealer's cards
    Hand player = new Hand();    //to hold the player's cards
    Blackjack game = new Blackjack(dealer,player);
    JLabel playercard1;
    JLabel playercard2;
    JLabel playercardhit;
    JLabel dealercard0;
    JLabel dealercard2;
    JLabel dealercard1;
    JLabel dealercardhit;



    public class EscapeAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e){
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        String[] possibilities = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace"};
                        JPanel jPanel = new JPanel(new GridBagLayout());
                        JComboBox comboBox = new JComboBox(possibilities);
                        int input = JOptionPane.showConfirmDialog(null, comboBox, "Choose a piece to promote to: ", JOptionPane.DEFAULT_OPTION);
                        jPanel.add(comboBox);

                        if(input == JOptionPane.OK_OPTION) {
                            String s = (String) comboBox.getSelectedItem();
                            switch(s){
                                case "1":
                                    ImageIcon q = new ImageIcon("src/imgs/aces.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(q, 1 ,"Spade", "Ace"));
                                case "2":
                                    ImageIcon w = new ImageIcon("src/imgs/2s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(w, 2 ,"Spade", "Two"));
                                case "3":
                                    ImageIcon e2 = new ImageIcon("src/imgs/3s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(e2, 3 ,"Spade", "Three"));
                                case "4":
                                    ImageIcon r = new ImageIcon("src/imgs/4s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(r, 4,"Spade", "Four"));
                                case "5":
                                    ImageIcon t = new ImageIcon("src/imgs/5s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(t, 5,"Spade", "Five"));
                                case "6":
                                    ImageIcon y = new ImageIcon("src/imgs/6s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(y, 6 ,"Spade", "Six"));
                                case "7":
                                    ImageIcon u = new ImageIcon("src/imgs/7s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(u, 7 ,"Spade", "Seven"));
                                case "8":
                                    ImageIcon i = new ImageIcon("src/imgs/8s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(i, 8 ,"Spade", "Eight"));
                                case "9":
                                    ImageIcon o = new ImageIcon("src/imgs/9s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(o, 9 ,"Spade", "Nine"));
                                case "10":
                                    ImageIcon p = new ImageIcon("src/imgs/10s.jpg");
                                    Blackjack.getPlayer().inHand.add(new Card(p, 10 ,"Spade", "Ten"));
                            }
                        }
                    }
                }
            });
        }
    }




    public BlackjackGUI() {
        topPanel.setBackground(new Color(0, 122, 0));
        dcardPanel.setBackground(new Color(0, 122, 0));
        pcardPanel.setBackground(new Color(0, 122, 0));
        topPanel.setLayout(new FlowLayout());
        winlosebox.setText("Blackjack");
        winlosebox.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
        winlosebox.setEditable(false);
        winlosebox.setVisible(false);
        dealbutton.setText("Deal");
        dealbutton.addActionListener(new dealbutton());
        hitbutton.setText("Hit");
        hitbutton.addActionListener(new hitbutton());
        hitbutton.setEnabled(false);
        staybutton.setText("Stay");
        staybutton.addActionListener(new staybutton());
        staybutton.setEnabled(false);
        playagainbutton.setText("Play Again");
        playagainbutton.addActionListener(new playagainbutton());
        playagainbutton.setEnabled(false);
        dealerlabel.setText("  Dealer:  ");
        playerlabel.setText("  Player:  ");
        topPanel.add(winlosebox);
        topPanel.add(dealbutton);
        topPanel.add(hitbutton);
        topPanel.add(staybutton);
        topPanel.add(playagainbutton);
        pcardPanel.add(playerlabel);
        dcardPanel.add(dealerlabel);
        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(dcardPanel,BorderLayout.CENTER);
        add(pcardPanel,BorderLayout.SOUTH);

    }
    public void display() {
        JFrame myFrame = new JFrame("BlackJack");
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(700,550));
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setAlwaysOnTop(true);



    }
    class dealbutton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            dcardPanel.add(dealerlabel);
            pcardPanel.add(playerlabel);
            dealercard0 = new JLabel(new ImageIcon("imgs/back.jpg"));
            game.dealInitialCards();
            Card dcard=null;
            Iterator<Card> dscan = (dealer.inHand).iterator();
            int count = 0;
            while (dscan.hasNext()) {
                dcard = dscan.next();
                if(count==0)
                    dealercard1 = new JLabel(dcard.getimage());
                else
                    dealercard2 = new JLabel(dcard.getimage());
                count++;
            }
            Iterator<Card> pscan = (player.inHand).iterator();
            count = 0;
            while (pscan.hasNext()) {
                Card pcard = pscan.next();
                if(count==0)
                    playercard1 = new JLabel(pcard.getimage());
                else
                    playercard2 = new JLabel(pcard.getimage());

                count++;
            }
            dcardPanel.add(dealercard0);
            dcardPanel.add(dealercard2);
            pcardPanel.add(playercard1);
            pcardPanel.add(playercard2);

            dealerlabel.setText("  Dealer:  "+ dcard.getvalue());
            playerlabel.setText("  Player:  " + game.handValue(player));
            hitbutton.setEnabled(true);
            staybutton.setEnabled(true);
            dealbutton.setEnabled(false);

            if(game.blackj()) {
                hitbutton.setEnabled(false);
                staybutton.setEnabled(false);
                dealbutton.setEnabled(false);
                playagainbutton.setEnabled(true);
                winlosebox.setText("BlackJack");
            }

            add(dcardPanel,BorderLayout.CENTER);
            add(pcardPanel,BorderLayout.SOUTH);

        }
    }//end dealbutton

    class hitbutton implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            Card hitcard = game.hit(player);
            playercardhit = new JLabel(hitcard.getimage());
            pcardPanel.add(playercardhit);
            pcardPanel.repaint();

            if(game.bust(player)) {
                winlosebox.setVisible(true);
                winlosebox.setText("Bust");
                winlosebox.setEditable(false);
                hitbutton.setEnabled(false);
                dealbutton.setEnabled(false);
                staybutton.setEnabled(false);
                playagainbutton.setEnabled(true);
            }

            playerlabel.setText("  Player:   " + game.handValue(player));

        }
    }//end hitbutton

    class staybutton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            dcardPanel.remove(dealercard0);
            dcardPanel.add(dealercard1);

            dealer = game.dealerPlays();
            dcardPanel.removeAll();
            dcardPanel.add(dealerlabel);
            dealerlabel.setText(" " + dealerlabel.getText());

            //iterate through cards and re-display
            Card dhitcard = null;
            Iterator<Card> scan = (dealer.inHand).iterator();
            while (scan.hasNext()) {
                dhitcard = scan.next();
                dealercardhit = new JLabel(dhitcard.getimage());
                dcardPanel.add(dealercardhit);
            }

            dealerlabel.setText("Dealer: " + game.handValue(dealer));
            playerlabel.setText("Player: " + game.handValue(player));

            winlosebox.setVisible(true);
            winlosebox.setText(game.winner());
            hitbutton.setEnabled(false);
            staybutton.setEnabled(false);

            playagainbutton.setEnabled(true);

        }
    }//end staybutton

    class playagainbutton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            dealerlabel.setText("Dealer: ");
            playerlabel.setText("Player: ");
            winlosebox.setVisible(false);
            winlosebox.setText("Blackjack");
            dealer = new Hand();
            player = new Hand();
            game=new Blackjack(dealer, player);

            dcardPanel.removeAll();
            pcardPanel.removeAll();

            hitbutton.setEnabled(false);
            staybutton.setEnabled(false);
            playagainbutton.setEnabled(false);
            dealbutton.setEnabled(true);

        }
    }//end playagainbutton


}//end BlackjackGUI