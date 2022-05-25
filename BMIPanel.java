import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class BMIPanel extends JPanel
{
    private int WIDTH = 300;
    private int HEIGHT = 120;
    private JLabel heightLabel, weightLabel, BMILabel, resultLabel;
    private JTextField height, weight;
    private JButton calculate;
     
    public BMIPanel()
    {
        heightLabel = new JLabel("Your height in inches: ");
        weightLabel = new JLabel("Your weight in pounds: ");
        BMILabel = new JLabel("This is your BMI: ");
        resultLabel = new JLabel("---");
        
        height = new JTextField(5);
        weight = new JTextField(5);
        
        calculate = new JButton("Calculate BMI");
        calculate.addActionListener(new BMIListener());
        
        add(heightLabel);
        add(height);
        add(weightLabel);
        add(weight);
        add(calculate);
        add(BMILabel);
        add(resultLabel);
        
        setPreferredSize(new Dimension(300,40));
        setBackground(Color.cyan);
        
        
        
    
       }

    private class BMIListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String heightText, weightText;
            int heightVal, weightVal;
            double bmi;
            
            DecimalFormat df = new DecimalFormat("0.00");
            
            heightText = height.getText();
            weightText = weight.getText();
            
            heightVal = Integer.parseInt(heightText);
            weightVal = Integer.parseInt(weightText);
            
            df.setRoundingMode(RoundingMode.UP);
            bmi = (double) 703 * weightVal/(heightVal*heightVal);
            resultLabel.setText(df.format(bmi));
        }
     }
}
