import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductCalculations extends JFrame {


        private JTextField txtCustomerName;
        //COMBO BOX creates drop down list
        private JComboBox<String> cmbProduct;
        private JTextField txtProductPrice;
        double Vat = 0.15;
        double Com = 0.05;

    //TEXT AREA creates a larger area to display report
    private JTextArea txtReport;

        //Business logic class
        private final IProductCalculations estateAgent = new Productp();


        public ProductCalculations() {

            // Set up frame
            setTitle("Product App");


            //WINDOW MORE SPACE
            setSize(500, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);
            JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
            mainPanel.setBorder(
                    BorderFactory.createEmptyBorder(15, 20, 15, 20)
            );


            JPanel formPanel = new JPanel(
                    new GridLayout(4, 2, 8, 10)
            );
            // creates a panel to hold student information

            txtCustomerName = new JTextField();
            txtProductPrice = new JTextField();


            //CREATE AND POPULATE COMBO BOX
            cmbProduct = new JComboBox<>();

            cmbProduct.addItem("Cozy Nights Monarch");
            cmbProduct.addItem("Restonic Barbados");
            cmbProduct.addItem("Sealy Phuket");

            //ADD COMBO BOX TO THE FORM
            formPanel.add(new JLabel("Select Product:"));
            formPanel.add(cmbProduct);

            addFormRow(formPanel, "Customer Name:", txtCustomerName);
            addFormRow(formPanel, "Enter Price:", txtProductPrice);



            mainPanel.add(formPanel, BorderLayout.NORTH);


            JMenuBar menuBar = new JMenuBar();
            //CREATE MENUS
            JMenu fileMenu = new JMenu("File");
            JMenu EditMenu = new JMenu("Edit");

            JMenuItem exitItem = new JMenuItem("Exit");
            JMenuItem processItem = new JMenuItem("Process");
            JMenuItem clearItem = new JMenuItem("Clear");


            fileMenu.add(exitItem);
            EditMenu.add(processItem);
            EditMenu.add(clearItem);

            menuBar.add(fileMenu);
            menuBar.add(EditMenu);
            //DISPLAY MENU BAR
            setJMenuBar(menuBar);

            // ADD ACTIONS TO MENU ITEMS
            exitItem.addActionListener(e -> System.exit(0));
            processItem.addActionListener(e -> processReport());
            clearItem.addActionListener(e -> clearFields());

            add(mainPanel);
            setVisible(true);

        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(ProductCalculations::new);
        }

        private void addFormRow(
                JPanel panel, String label, JTextField textField) {
            panel.add(new JLabel(label));
            panel.add(textField);
        }


        private void processReport() {
            String Product = cmbProduct.getSelectedItem().toString();
            String name = txtCustomerName.getText().trim();
            String price = txtProductPrice.getText().trim();

            //only valid data is allowed
            Data data = new Data(name, Product, price);
            if (!Productp.ValidateData(data)) {
                JOptionPane.showMessageDialog(
                        this, "Please enter a name, product and price.",
                        "Invalid Data",
                        JOptionPane.WARNING_MESSAGE

                );
                return;
            }
            int Total= 0;
            double commission = Productp.CalculateCommission(price, Com);
            double VAT = Productp.CalculateVAT(price , Vat);

            String report = "Customer Name: " + name + "\n"
                    + "Product: " + Product + "\n"
                    + "VAT: R " + Double.parseDouble(Vat) + "\n"
                    + "COMMISSION PERCENTAGE: " + Double.parseDouble(Com) + "%\n"
                    + "TOTAL: R " + Total + "\n";


        }

        //reset fields and the report area to defauly state
        private void clearFields() {

            txtCustomerName.setText("");
            cmbProduct.setSelectedIndex(0);
            txtProductPrice.setText("");

        }

//save the report to report.txt

        private void saveReport() {

            if (txtReport.getText().isEmpty()) {

                //Displays warning message and validates that all required detaials have been entered.
                JOptionPane.showMessageDialog(
                        this,
                        "Please process a report first",
                        "Nothing to save",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }


            //  try with resources closes the writer automatically
            try (FileWriter writer = new FileWriter("report.txt")) {
                writer.write("DATA LOG\n");
                String line = "****************************************************";
                writer.write(line + "\n");
                writer.write(txtReport.getText());
                writer.write(line + "\n");
                JOptionPane.showMessageDialog(this, "Report saved successfully!");


            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Error saving report: " + ex.getMessage(),
                        "Save Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        }















}
