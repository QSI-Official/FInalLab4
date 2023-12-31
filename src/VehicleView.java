import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleView extends JFrame{
    private static int X = 0;
    private static int Y = 0;

    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");


    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove Car");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public VehicleView(String framename, DrawPanel drawPanel, int X, int Y){
        this.drawPanel = drawPanel;
        this.X=X;
        this.Y=Y;
        initComponents(framename);
    }


    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-5,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-5,200));
        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addGasListener(ActionListener actionListener){
        gasButton.addActionListener(actionListener);
    }

    public void addBrakeListener(ActionListener actionListener){
        brakeButton.addActionListener(actionListener);
    }

    public void addTurboOnListener(ActionListener actionListener){
        turboOnButton.addActionListener(actionListener);
    }

    public void addTurboOffListener(ActionListener actionListener){
        turboOffButton.addActionListener(actionListener);
    }

    public void addLiftListener(ActionListener actionListener){
        liftBedButton.addActionListener(actionListener);
    }

    public void addLowerListener(ActionListener actionListener){
        lowerBedButton.addActionListener(actionListener);
    }

    public void addCarListener(ActionListener actionListener){
        addCarButton.addActionListener(actionListener);
    }
    public void addRemoveCarListener(ActionListener actionListener){
        removeCarButton.addActionListener(actionListener);
    }

    public void addStartCarListener(ActionListener actionListener){
        startButton.addActionListener(actionListener);
    }

    public void addStopCarListener(ActionListener actionListener){
        stopButton.addActionListener(actionListener);
    }

    public int getGasAmount(){
        return gasAmount;
    }
}