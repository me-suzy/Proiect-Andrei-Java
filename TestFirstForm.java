
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.text.*;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

public class TestFirstForm extends JFrame{
    JFormattedTextField txtChar;
    //poate sa contina numere
    JFormattedTextField txtNumberInt;
    //accepta nr. intregi(max 4 cifre)
    JFormattedTextField txtNumberDec;
    JFormattedTextField txtDate;
    JButton btnOK=new JButton("OK");
    JButton btnCancel=new JButton("cancel");
    /** Creates a new instance of TestFirstForm */
    public TestFirstForm() {
        this.txtChar=new JFormattedTextField();
        java.text.DecimalFormat intFormat=new java.text.DecimalFormat();
        intFormat.setMaximumFractionDigits(0);
        intFormat.setMaximumIntegerDigits(4);
        
        this.txtNumberInt=new JFormattedTextField(intFormat);
        java.text.DecimalFormat decFormat=new java.text.DecimalFormat();
        decFormat.applyPattern("#0.00#");
        decFormat.setMaximumFractionDigits(3);
        decFormat.setMaximumIntegerDigits(2);
        
        this.txtNumberDec=new JFormattedTextField(decFormat);
        ((DefaultFormatter)txtNumberDec.getFormatter()).setAllowsInvalid(false);
        java.text.SimpleDateFormat frmData=new java.text.SimpleDateFormat("dd/MM/yyyy");
        frmData.setLenient(false);
        this.txtDate=new JFormattedTextField(frmData);
       
        this.initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    private void initComponents(){
       JPanel formRootPanel=(JPanel)this.getContentPane();
       formRootPanel.setLayout(new BorderLayout());
       JPanel panelCenter=new JPanel();
       panelCenter.setLayout(new GridLayout(4,2));
       panelCenter.add(new JLabel("sir de chars:"));
       panelCenter.add(this.txtChar);
       panelCenter.add(new JLabel("integers(4):"));
       panelCenter.add(this.txtNumberInt);
       panelCenter.add(new JLabel("decimals(2,3):"));
       panelCenter.add(this.txtNumberDec);
       panelCenter.add(new JLabel("Dates"));
       panelCenter.add(this.txtDate);
       
       formRootPanel.add(panelCenter,BorderLayout.CENTER);
       
       JPanel panelSouth=new JPanel(); panelSouth.setLayout(new FlowLayout());
       panelSouth.add(this.btnOK ); panelSouth.add(this.btnCancel);
       
       formRootPanel.add(panelSouth,BorderLayout.SOUTH);
       this.btnOK.addActionListener(new ActionListener(){           // Completare tratare evenimente
        public void actionPerformed(java.awt.event.ActionEvent e) {      
            if(e.getSource()==TestFirstForm.this.btnOK){
                java.util.Date valTxtDate=(java.util.Date)txtDate.getValue();
                JOptionPane.showMessageDialog(TestFirstForm.this,valTxtDate);
            }
        }        
       });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestFirstForm().show();
    }
 }