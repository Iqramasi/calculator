import javax.swing.*;   //swing used for window based applications
import java.awt.*;    // Abstract Window Toolkit...its a lowlevel UI toolkit that swing is bult on top of
import java.awt.event.*;    // import events handling classes


public class calci implements ActionListener {
   JFrame frame;
   JTextField textfield;
   JButton[] numberButtons = new JButton[10];
   JButton[] functionButtons = new JButton[9];
   JButton addButton, subButton, mulButton, divButton;
   JButton equalButton, decimalButton, clearButton, delButton, negButton;
   JPanel panel;

   Font myFont = new Font("Ink Free", Font.BOLD,20);

   double num1 = 0 ;
   double num2 = 0 ;
   double result = 0 ;
   char operator ;
    calci() {
        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,450);
        frame.setLayout(null);
        textfield = new JTextField();
         textfield.setBounds(40, 20, 240, 40);
         textfield.setFont(myFont);
         textfield.setEditable(false);
         addButton = new JButton("+");
         mulButton = new JButton("*");
         divButton = new JButton("/");
         subButton = new JButton("-");
         clearButton = new JButton("clear");
         delButton = new JButton("delete");
         equalButton = new JButton("=");
         decimalButton = new JButton(".");
         negButton = new JButton("(-)");

         functionButtons[0]=addButton;
         functionButtons[1]=subButton;
         functionButtons[2]=mulButton;
         functionButtons[3]=divButton;
         functionButtons[4]=equalButton;
         functionButtons[5]=decimalButton;
         functionButtons[6]=delButton;
         functionButtons[7]=clearButton;
         functionButtons[8]=negButton;

        for(int i =0 ; i<9 ;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
                
            
        }
    
        for(int i =0 ; i<10 ;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }
        negButton.setBounds(30, 350, 90, 40);
        delButton.setBounds(130, 350, 90, 40);//if will keep y as 470 it wont show on the panelkindly make it small
        clearButton.setBounds(230, 350, 90, 40); // do not keep x as 50 for this also 
        //after this i did changement in this as before del was 4o and clear wqqs 180 now it is 30 and 180
        
        panel = new JPanel();
        panel.setBounds(40, 80, 240, 250);
        panel.setLayout(new GridLayout(4,4,10,10));
      // here first i put it as 3 3 and so it didnt workout but now when i did 4 4 it worked well
      panel.setBackground(Color.lightGray);
      // panel.setBackground(new Color(255, 182, 193)); // Light Pink
    
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(equalButton);

// this is to make the layout of the calculator

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clearButton);
         frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        calci calc = new calci();

      
    }

  
    public void actionPerformed(ActionEvent e ){
           for(int i =0 ; i<10 ; i++ ){
            if(e.getSource() == numberButtons[i]){
               textfield.setText(textfield.getText().concat(String.valueOf(i)));

            }
           } 

           if(e.getSource() == decimalButton){
              textfield.setText(textfield.getText().concat("."));

            }

            if(e.getSource() == equalButton){
                num2= Double.parseDouble(textfield.getText());
                 
                 switch(operator){
                    case'+' :
                    result = num1 + num2;
                    break;

                    case'-' :
                    result = num1 - num2;
                    break;

                    case'*' :
                    result = num1 * num2;
                    break;

                    case'/' :
                    result = num1 / num2;
                    break;
                 }
                 textfield.setText(String.valueOf(result));
                 num1 = result;
              }


              if(e.getSource() == addButton){
                num1 = Double.parseDouble(textfield.getText());
                operator = '+';
                textfield.setText("");
  
              }
              if(e.getSource() == subButton){
                num1 = Double.parseDouble(textfield.getText());
                operator = '-';
                textfield.setText("");
  
              }
              if(e.getSource() == divButton){
                num1 = Double.parseDouble(textfield.getText());
                operator = '/';
                textfield.setText("");
  
              }
              if(e.getSource() == mulButton){
                num1 = Double.parseDouble(textfield.getText());
                operator = '*';
                textfield.setText("");
  
              }
              if(e.getSource() == clearButton){
                textfield.setText("");


           } 
           if(e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i =0 ;i<string.length()-1 ; i++){
                textfield.setText(textfield.getText()+ string.charAt(i));

            }}

            if(e.getSource()==negButton){
               double temp = Double.parseDouble(textfield.getText());
               temp*=-1;
               textfield.setText(String.valueOf(temp));

                }


       } 
    }
