/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.HistorialMantenimiento;
import Modelo.HistorialMantenimientoDAO;
import Modelo.HistorialVenta;
import Modelo.HistorialVentaDAO;
import Modelo.HistorialRenta;
import Modelo.HistorialRentaDAO;
import Modelo.Mantenimiento;
import Modelo.MantenimientoDAO;
import Modelo.Vehiculo;
import Modelo.VehiculoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Reportes.Excel;
import java.util.Date;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Jorge
 */
public class Pagina_Principal extends javax.swing.JFrame {

    Cliente cl = new Cliente();
    ClienteDAO client = new ClienteDAO();
    Empleado em = new Empleado();
    EmpleadoDAO emple = new EmpleadoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    Vehiculo v = new Vehiculo();
    VehiculoDAO vDAO = new VehiculoDAO();
    HistorialVenta hv = new HistorialVenta();
    HistorialVentaDAO hive = new HistorialVentaDAO();
    HistorialRenta hr = new HistorialRenta();
    HistorialRentaDAO hire = new HistorialRentaDAO();
    HistorialMantenimiento hm = new HistorialMantenimiento();
    HistorialMantenimientoDAO hima = new HistorialMantenimientoDAO();
    Venta ve = new Venta();
    VentaDAO veDAo = new VentaDAO();
    int item;
    double Totalpagar = 0.00;
    public Pagina_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        AutoCompleteDecorator.decorate(comboseguro);
        vDAO.consultarSeguro(comboseguro);
        AutoCompleteDecorator.decorate(combompago);
        vDAO.consultarmpago(combompago);
    }

    public void ListarCliente() {
        List<Cliente> ListarCl = client.ListarCliente();
        modelo = (DefaultTableModel) TablaClientes.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getIdCliente();
            ob[1] = ListarCl.get(i).getPnombre();
            ob[2] = ListarCl.get(i).getSnombre();
            ob[3] = ListarCl.get(i).getPapellido();
            ob[4] = ListarCl.get(i).getSapellido();
            ob[5] = ListarCl.get(i).getTelefono();
            ob[6] = ListarCl.get(i).getCorreo();
            ob[7] = ListarCl.get(i).getDireccion();
            modelo.addRow(ob);
        }
        TablaClientes.setModel(modelo);
    }

    
    public void ListarVehiculo() {
        List<Vehiculo> Listav = vDAO.ListarVehiculo();
        modelo = (DefaultTableModel) Tablavehiculos.getModel();
        Object[] ob = new Object[12];
        for (int i = 0; i < Listav.size(); i++) {
            ob[0] = Listav.get(i).getIdVehiculo();
            ob[1] = Listav.get(i).getVIN();
            ob[2] = Listav.get(i).getMarca();
            ob[3] = Listav.get(i).getModelo();
            ob[4] = Listav.get(i).getColor();
            ob[5] = Listav.get(i).getAño();
            ob[6] = Listav.get(i).getTipo();
            ob[7] = Listav.get(i).getCosto_venta();
            ob[8] = Listav.get(i).getCosto_renta();
            ob[9] = Listav.get(i).getBodega();
            ob[10] = Listav.get(i).getProveedor();
            ob[11] = Listav.get(i).getEstado();
            modelo.addRow(ob);
        }
        TablaClientes.setModel(modelo);
    }

    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    public void ListarVentas(){
        List<HistorialVenta>ListaV = hive.ListarVentas();
        modelo = (DefaultTableModel) Tablahistorialventa.getModel();
        Object[] ob = new Object[10];
        for(int i = 0; i < ListaV.size(); i++){
            ob[0] = ListaV.get(i).getIdHistorial();
            ob[1] = ListaV.get(i).getSucursal();
            ob[2] = ListaV.get(i).getIdfactura_venta();
            ob[3] = ListaV.get(i).getEmpleado_idempleado();
            ob[4] = ListaV.get(i).getCliente_idcliente();
            ob[5] = ListaV.get(i).getVehiculo_idVehiculo();
            ob[6] = ListaV.get(i).getFechaventa();
            ob[7] = ListaV.get(i).getDescripcion();
            ob[8] = ListaV.get(i).getCosto();
            ob[9] = ListaV.get(i).getMpago();
            modelo.addRow(ob);
        
        }
        Tablahistorialventa.setModel(modelo);
    }
    
    public void ListarRentas(){
        List<HistorialRenta>ListaR = hire.ListarRentas();
        modelo = (DefaultTableModel) Tablahistorialrenta.getModel();
        Object[] ob = new Object[11];
        for(int i = 0; i < ListaR.size(); i++){
            ob[0] = ListaR.get(i).getIdHistorial();
            ob[1] = ListaR.get(i).getSucursal();
            ob[2] = ListaR.get(i).getIdfactura_renta();
            ob[3] = ListaR.get(i).getEmpleado();
            ob[4] = ListaR.get(i).getCliente();
            ob[5] = ListaR.get(i).getVehiculo();
            ob[6] = ListaR.get(i).getAval();
            ob[7] = ListaR.get(i).getFechainicio();
            ob[8] = ListaR.get(i).getFechafin();
            ob[9] = ListaR.get(i).getCostototal();
            ob[10] = ListaR.get(i).getMpago();
            modelo.addRow(ob);
        
        }
        Tablahistorialrenta.setModel(modelo);
    }
    
    public void ListarMantenimientos(){
        List<HistorialMantenimiento>ListaM = hima.ListarMantenimientos();
        modelo = (DefaultTableModel) Tablahistorialmantenimientos.getModel();
        Object[] ob = new Object[10];
        for(int i = 0; i < ListaM.size(); i++){
            ob[0] = ListaM.get(i).getIdHistorial();
            ob[1] = ListaM.get(i).getSucursal();
            ob[2] = ListaM.get(i).getIdfactura_mantenimiento();
            ob[3] = ListaM.get(i).getEmpleado();
            ob[4] = ListaM.get(i).getCliente();
            ob[5] = ListaM.get(i).getVehiculo();
            ob[6] = ListaM.get(i).getFechaMantenimiento();
            ob[7] = ListaM.get(i).getDescripcion();
            ob[8] = ListaM.get(i).getCosto();
            ob[9] = ListaM.get(i).getMpago();
            
            modelo.addRow(ob);
        
        }
        Tablahistorialmantenimientos.setModel(modelo);
    }

    // }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnnuevaventaNV = new javax.swing.JButton();
        btnnuevarentaNV = new javax.swing.JButton();
        btnnuevomantenimientoNV = new javax.swing.JButton();
        btnvehiculosNV = new javax.swing.JButton();
        btncerrarsesionNV = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnserviciosNV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtidvehiculoNV = new javax.swing.JTextField();
        txtVINNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtfechaNuevaV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNV = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        txtIDclienteNV = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtnombreclienteNV = new javax.swing.JTextField();
        LabelTotal = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtempleadoNV = new javax.swing.JTextField();
        txtidempleadoNV = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtestadoNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtcosto_ventaNV = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtbodegaNV = new javax.swing.JTextField();
        btneliminarventa = new javax.swing.JButton();
        txttelefonoNV = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        txtdireccionNV = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        comboseguro = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        combompago = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaNR = new javax.swing.JTable();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtVINNR = new javax.swing.JTextField();
        txtfechafin = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtfechafinNR = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtidvehiculoNR = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtidclienteNR = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtnombreclienteNR = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtfechainicioNR = new javax.swing.JTextField();
        comboboxseguroNR = new javax.swing.JComboBox<>();
        txtprecioNR = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtnombreempleadoNR = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtidempleadoNR = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txttelefonoNR = new javax.swing.JTextField();
        txtdireccionNR = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtestadoNR = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        txtpnombreC = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtsnombreC = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txttelefonoC = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtpapellidoC = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtsapellidoC = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtdireccionC = new javax.swing.JTextField();
        btnguardarC = new javax.swing.JButton();
        btnactualizarC = new javax.swing.JButton();
        btneliminarC = new javax.swing.JButton();
        btnnuevoC = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtcorreoC = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtmarcaV = new javax.swing.JTextField();
        txtmodeloV = new javax.swing.JTextField();
        txtañoV = new javax.swing.JTextField();
        txtVINV = new javax.swing.JTextField();
        txtcosto_rentaV = new javax.swing.JTextField();
        btnguardarV = new javax.swing.JButton();
        btnactualizarV = new javax.swing.JButton();
        btneliminarV = new javax.swing.JButton();
        btnnuevoV = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tablavehiculos = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtidvehiculoV = new javax.swing.JTextField();
        txtcosto_ventaV = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtcolorV = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txttipoV = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtbodegaV = new javax.swing.JTextField();
        txtestadoV = new javax.swing.JTextField();
        txtproveedorV = new javax.swing.JTextField();
        btnnuevoV1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnactualizarP = new javax.swing.JButton();
        btnguardarP = new javax.swing.JButton();
        btneliminarP = new javax.swing.JButton();
        btnnuevoP = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaClientes2 = new javax.swing.JTable();
        jLabel76 = new javax.swing.JLabel();
        txtidmantenimiento = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        txtfechainiciom = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtfechafacturam = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtidclientem = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtnombreclientem = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txtidempleadom = new javax.swing.JTextField();
        txtempleadoNV1 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        LabelTotal1 = new javax.swing.JLabel();
        txtTPNV1 = new javax.swing.JTextField();
        txtmpago = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtfechafinm = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnSV = new javax.swing.JButton();
        btnSM = new javax.swing.JButton();
        btnSR = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tablahistorialventa = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Tablahistorialrenta = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Tablahistorialmantenimientos = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Labelsucursal = new javax.swing.JLabel();
        btnclientesNV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Nueva venta"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btnnuevaventaNV.setBackground(new java.awt.Color(255, 204, 204));
        btnnuevaventaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnnuevaventaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 4.png"))); // NOI18N
        btnnuevaventaNV.setText("NUEVA VENTA");
        btnnuevaventaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnnuevaventaNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnuevaventaNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnuevaventaNVMouseExited(evt);
            }
        });
        btnnuevaventaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevaventaNVActionPerformed(evt);
            }
        });

        btnnuevarentaNV.setBackground(new java.awt.Color(255, 204, 204));
        btnnuevarentaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnnuevarentaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 3.png"))); // NOI18N
        btnnuevarentaNV.setText("NUEVA RENTA");
        btnnuevarentaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnuevarentaNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnuevarentaNVMouseExited(evt);
            }
        });
        btnnuevarentaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevarentaNVActionPerformed(evt);
            }
        });

        btnnuevomantenimientoNV.setBackground(new java.awt.Color(255, 204, 204));
        btnnuevomantenimientoNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnnuevomantenimientoNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 12 (1).png"))); // NOI18N
        btnnuevomantenimientoNV.setText("NUEVO MANTENIMIENTO");
        btnnuevomantenimientoNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnuevomantenimientoNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnuevomantenimientoNVMouseExited(evt);
            }
        });
        btnnuevomantenimientoNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevomantenimientoNVActionPerformed(evt);
            }
        });

        btnvehiculosNV.setBackground(new java.awt.Color(255, 204, 204));
        btnvehiculosNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnvehiculosNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 6.png"))); // NOI18N
        btnvehiculosNV.setText("VEHICULOS");
        btnvehiculosNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnvehiculosNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnvehiculosNVMouseExited(evt);
            }
        });
        btnvehiculosNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvehiculosNVActionPerformed(evt);
            }
        });

        btncerrarsesionNV.setBackground(new java.awt.Color(0, 0, 0));
        btncerrarsesionNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncerrarsesionNV.setForeground(new java.awt.Color(255, 255, 255));
        btncerrarsesionNV.setText("CERRAR SESION");
        btncerrarsesionNV.setBorder(null);
        btncerrarsesionNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarsesionNVActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GESTOR DE VENTAS");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Vector 2.png"))); // NOI18N

        btnserviciosNV.setBackground(new java.awt.Color(255, 204, 204));
        btnserviciosNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnserviciosNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 7.png"))); // NOI18N
        btnserviciosNV.setText("SERVICIOS");
        btnserviciosNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnserviciosNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnserviciosNVMouseExited(evt);
            }
        });
        btnserviciosNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnserviciosNVActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo (1).png"))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("IdVehiculo");

        jLabel5.setText("VIN");

        txtidvehiculoNV.setBackground(new java.awt.Color(204, 204, 204));
        txtidvehiculoNV.setBorder(null);
        txtidvehiculoNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidvehiculoNVActionPerformed(evt);
            }
        });
        txtidvehiculoNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidvehiculoNVKeyPressed(evt);
            }
        });

        txtVINNV.setBackground(new java.awt.Color(204, 204, 204));
        txtVINNV.setText("\n");
        txtVINNV.setBorder(null);

        jLabel9.setText("Seleccione una fecha:");

        txtfechaNuevaV.setText("       dd/mm/yy");
        txtfechaNuevaV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfechaNuevaVKeyPressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 10.png"))); // NOI18N

        TablaNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdVehiculo", "Precio", "Estado", "Seguro", "Bodega", "Fecha"
            }
        ));
        TablaNV.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(TablaNV);

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 11.png"))); // NOI18N
        jLabel45.setText("ID Cliente:");

        txtIDclienteNV.setBackground(new java.awt.Color(204, 204, 204));
        txtIDclienteNV.setBorder(null);
        txtIDclienteNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDclienteNVKeyPressed(evt);
            }
        });

        jLabel46.setText("Nombre del cliente:");

        txtnombreclienteNV.setBackground(new java.awt.Color(204, 204, 204));
        txtnombreclienteNV.setBorder(null);

        LabelTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 9.png"))); // NOI18N
        LabelTotal.setText("Total a pagar");

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 11.png"))); // NOI18N
        jLabel74.setText("ID Empleado:");

        jLabel75.setText("Nombre del empleado:");

        txtempleadoNV.setBackground(new java.awt.Color(204, 204, 204));
        txtempleadoNV.setBorder(null);

        txtidempleadoNV.setBackground(new java.awt.Color(204, 204, 204));
        txtidempleadoNV.setBorder(null);
        txtidempleadoNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidempleadoNVKeyPressed(evt);
            }
        });

        jLabel22.setText("Precio");

        txtestadoNV.setBackground(new java.awt.Color(204, 204, 204));
        txtestadoNV.setBorder(null);
        txtestadoNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtestadoNVKeyPressed(evt);
            }
        });

        jLabel6.setText("Seguro");

        jLabel23.setText("Estado");

        txtcosto_ventaNV.setBackground(new java.awt.Color(204, 204, 204));
        txtcosto_ventaNV.setToolTipText("");
        txtcosto_ventaNV.setBorder(null);
        txtcosto_ventaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcosto_ventaNVKeyPressed(evt);
            }
        });

        jLabel24.setText("Bodega");

        txtbodegaNV.setBackground(new java.awt.Color(204, 204, 204));
        txtbodegaNV.setBorder(null);
        txtbodegaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbodegaNVKeyPressed(evt);
            }
        });

        btneliminarventa.setBackground(new java.awt.Color(153, 153, 153));
        btneliminarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        btneliminarventa.setBorder(null);
        btneliminarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarventaActionPerformed(evt);
            }
        });

        txttelefonoNV.setBackground(new java.awt.Color(204, 204, 204));
        txttelefonoNV.setBorder(null);

        jLabel71.setText("Telefono");

        txtdireccionNV.setBackground(new java.awt.Color(204, 204, 204));
        txtdireccionNV.setBorder(null);

        jLabel72.setText("Direccion");

        comboseguro.setEditable(true);
        comboseguro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboseguroKeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("GENERAR FACTURA 2 ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        combompago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Método de pago" }));
        combompago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combompagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtidvehiculoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtVINNV, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(comboseguro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcosto_ventaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtestadoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbodegaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtfechaNuevaV, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtIDclienteNV, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel46)
                                            .addComponent(txtnombreclienteNV, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addComponent(btneliminarventa)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtidempleadoNV, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtempleadoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel75))
                                            .addComponent(jButton2)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel71)
                                            .addComponent(txttelefonoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel72)
                                            .addComponent(txtdireccionNV, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(combompago, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel22)
                            .addComponent(jLabel6)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVINNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidvehiculoNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboseguro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfechaNuevaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtestadoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcosto_ventaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtbodegaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIDclienteNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombreclienteNV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel74)
                                    .addComponent(jLabel75))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtidempleadoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtempleadoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btneliminarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefonoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdireccionNV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combompago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(8, 8, 8))
                    .addComponent(LabelTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel5);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        TablaNR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ));
        TablaNR.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(TablaNR);
        if (TablaNR.getColumnModel().getColumnCount() > 0) {
            TablaNR.getColumnModel().getColumn(0).setPreferredWidth(30);
            TablaNR.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaNR.getColumnModel().getColumn(2).setPreferredWidth(30);
            TablaNR.getColumnModel().getColumn(3).setPreferredWidth(30);
            TablaNR.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jLabel48.setText("idVehiculo");

        jLabel49.setText("VIN");

        jLabel51.setText("Precio");

        txtVINNR.setBackground(new java.awt.Color(204, 204, 204));
        txtVINNR.setBorder(null);

        txtfechafin.setBackground(new java.awt.Color(204, 204, 204));
        txtfechafin.setBorder(null);

        jLabel53.setText("Fecha inicio");

        txtfechafinNR.setText("       dd/mm/yy");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 10.png"))); // NOI18N

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 11.png"))); // NOI18N
        jLabel55.setText("ID empleado:");

        jLabel56.setText("Seguro");

        txtidvehiculoNR.setBackground(new java.awt.Color(204, 204, 204));
        txtidvehiculoNR.setBorder(null);
        txtidvehiculoNR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidvehiculoNRActionPerformed(evt);
            }
        });

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 9.png"))); // NOI18N
        jLabel57.setText("Total a pagar");

        txtidclienteNR.setBackground(new java.awt.Color(204, 204, 204));
        txtidclienteNR.setBorder(null);

        jLabel50.setText("Nombre del cliente:");

        txtnombreclienteNR.setBackground(new java.awt.Color(204, 204, 204));
        txtnombreclienteNR.setBorder(null);

        jLabel12.setText("Fecha emision:");

        txtfechainicioNR.setText("       dd/mm/yy");

        comboboxseguroNR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxseguroNR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxseguroNRActionPerformed(evt);
            }
        });

        txtprecioNR.setBackground(new java.awt.Color(204, 204, 204));

        jLabel26.setText("Fecha fin");

        jLabel27.setText("Nombre del empleado:");

        txtnombreempleadoNR.setBackground(new java.awt.Color(204, 204, 204));
        txtnombreempleadoNR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreempleadoNRActionPerformed(evt);
            }
        });

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 11.png"))); // NOI18N
        jLabel77.setText("ID Cliente:");

        txtidempleadoNR.setBackground(new java.awt.Color(204, 204, 204));

        jLabel28.setText("Telefono");

        jLabel29.setText("Direccion");

        txttelefonoNR.setBackground(new java.awt.Color(204, 204, 204));

        txtdireccionNR.setBackground(new java.awt.Color(204, 204, 204));

        jLabel30.setText("Estado");

        txtestadoNR.setBackground(new java.awt.Color(204, 204, 204));

        jLabel31.setText("Bodega");

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txttelefonoNR, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtdireccionNR, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidclienteNR, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel50)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel55))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtnombreclienteNR, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtidempleadoNR)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnombreempleadoNR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel54))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfechainicioNR, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(146, 146, 146))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtfechafinNR, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addComponent(jLabel57))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48)
                                    .addComponent(txtidvehiculoNR, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel49))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtVINNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addComponent(comboboxseguroNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprecioNR, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtestadoNR, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfechafin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(115, 115, 115)))
                        .addGap(35, 35, 35))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addComponent(jLabel51)
                    .addComponent(jLabel56)
                    .addComponent(jLabel12)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidvehiculoNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVINNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxseguroNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecioNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtestadoNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel55)
                                .addComponent(jLabel50)
                                .addComponent(jLabel27)
                                .addComponent(jLabel77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel26)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtidclienteNR, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombreclienteNR, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombreempleadoNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidempleadoNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttelefonoNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdireccionNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(224, 224, 224))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfechafinNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfechainicioNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel54)
                        .addGap(271, 271, 271))))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        jLabel58.setText("Primer Nombre");

        txtpnombreC.setBackground(new java.awt.Color(204, 204, 204));
        txtpnombreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpnombreCActionPerformed(evt);
            }
        });

        jLabel59.setText("Segundo Nombre");

        txtsnombreC.setBackground(new java.awt.Color(204, 204, 204));

        jLabel60.setText("Primer Apellido");

        txttelefonoC.setBackground(new java.awt.Color(204, 204, 204));
        txttelefonoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoCActionPerformed(evt);
            }
        });

        jLabel61.setText("Segundo Apellido");

        txtpapellidoC.setBackground(new java.awt.Color(204, 204, 204));
        txtpapellidoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpapellidoCActionPerformed(evt);
            }
        });

        jLabel62.setText("Telefono");

        txtsapellidoC.setBackground(new java.awt.Color(204, 204, 204));
        txtsapellidoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsapellidoCActionPerformed(evt);
            }
        });

        jLabel63.setText("Dirección");

        txtdireccionC.setBackground(new java.awt.Color(204, 204, 204));
        txtdireccionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionCActionPerformed(evt);
            }
        });

        btnguardarC.setBackground(new java.awt.Color(153, 153, 153));
        btnguardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnguardarC.setBorder(null);
        btnguardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarCActionPerformed(evt);
            }
        });

        btnactualizarC.setBackground(new java.awt.Color(153, 153, 153));
        btnactualizarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        btnactualizarC.setBorder(null);
        btnactualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarCActionPerformed(evt);
            }
        });

        btneliminarC.setBackground(new java.awt.Color(153, 153, 153));
        btneliminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        btneliminarC.setBorder(null);
        btneliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarCActionPerformed(evt);
            }
        });

        btnnuevoC.setBackground(new java.awt.Color(153, 153, 153));
        btnnuevoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        btnnuevoC.setBorder(null);
        btnnuevoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoCActionPerformed(evt);
            }
        });

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "P.Nombre", "S.Nombre", "P.Apellido", "S.Apellido", "Telefono", "Correo", "Direccion"
            }
        ));
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaClientes);

        jLabel13.setText("IdCliente");

        txtidcliente.setBackground(new java.awt.Color(204, 204, 204));

        jLabel73.setText("Correo");

        txtcorreoC.setBackground(new java.awt.Color(204, 204, 204));
        txtcorreoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel58)
                            .addComponent(txtpnombreC, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jLabel59)
                            .addComponent(txtsnombreC, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jLabel60)
                            .addComponent(txttelefonoC, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txtsapellidoC, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jLabel13)
                            .addComponent(txtidcliente))
                        .addComponent(txtpapellidoC, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel73)
                    .addComponent(txtcorreoC, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(txtdireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnguardarC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnactualizarC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btneliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnuevoC)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpnombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsnombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpapellidoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsapellidoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcorreoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardarC)
                    .addComponent(btnactualizarC)
                    .addComponent(btneliminarC)
                    .addComponent(btnnuevoC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel8);

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));

        jLabel64.setText("Marca");

        jLabel65.setText("Modelo");

        jLabel66.setText("Año");

        jLabel67.setText("VIN");

        jLabel68.setText("Costo_Venta");

        jLabel69.setText("Costo_Renta");

        txtmarcaV.setBackground(new java.awt.Color(204, 204, 204));
        txtmarcaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmarcaVActionPerformed(evt);
            }
        });

        txtmodeloV.setBackground(new java.awt.Color(204, 204, 204));
        txtmodeloV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodeloVActionPerformed(evt);
            }
        });

        txtañoV.setBackground(new java.awt.Color(204, 204, 204));
        txtañoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtañoVActionPerformed(evt);
            }
        });

        txtVINV.setBackground(new java.awt.Color(204, 204, 204));
        txtVINV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVINVActionPerformed(evt);
            }
        });

        txtcosto_rentaV.setBackground(new java.awt.Color(204, 204, 204));
        txtcosto_rentaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcosto_rentaVActionPerformed(evt);
            }
        });

        btnguardarV.setBackground(new java.awt.Color(153, 153, 153));
        btnguardarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnguardarV.setBorder(null);
        btnguardarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarVActionPerformed(evt);
            }
        });

        btnactualizarV.setBackground(new java.awt.Color(153, 153, 153));
        btnactualizarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        btnactualizarV.setBorder(null);
        btnactualizarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarVActionPerformed(evt);
            }
        });

        btneliminarV.setBackground(new java.awt.Color(153, 153, 153));
        btneliminarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        btneliminarV.setBorder(null);
        btneliminarV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneliminarVMouseClicked(evt);
            }
        });
        btneliminarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarVActionPerformed(evt);
            }
        });

        btnnuevoV.setBackground(new java.awt.Color(153, 153, 153));
        btnnuevoV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        btnnuevoV.setBorder(null);
        btnnuevoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoVActionPerformed(evt);
            }
        });

        Tablavehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "VIN", "Marca", "Modelo", "Color", "Año", "Tipo", "Venta", "Renta", "Bodega", "Proveedor", "Estado"
            }
        ));
        Tablavehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablavehiculosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tablavehiculos);
        if (Tablavehiculos.getColumnModel().getColumnCount() > 0) {
            Tablavehiculos.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tablavehiculos.getColumnModel().getColumn(2).setPreferredWidth(30);
            Tablavehiculos.getColumnModel().getColumn(3).setPreferredWidth(30);
            Tablavehiculos.getColumnModel().getColumn(5).setPreferredWidth(30);
            Tablavehiculos.getColumnModel().getColumn(7).setPreferredWidth(30);
            Tablavehiculos.getColumnModel().getColumn(8).setPreferredWidth(30);
        }

        jLabel14.setText("idVehiculo");

        txtidvehiculoV.setBackground(new java.awt.Color(204, 204, 204));

        txtcosto_ventaV.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setText("Color");

        txtcolorV.setBackground(new java.awt.Color(204, 204, 204));
        txtcolorV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolorVActionPerformed(evt);
            }
        });

        jLabel16.setText("Tipo");

        txttipoV.setBackground(new java.awt.Color(204, 204, 204));
        txttipoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttipoVActionPerformed(evt);
            }
        });

        jLabel17.setText("Bodega");

        jLabel18.setText("Proveedor");

        jLabel19.setText("Estado");

        txtbodegaV.setBackground(new java.awt.Color(204, 204, 204));
        txtbodegaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbodegaVActionPerformed(evt);
            }
        });

        txtestadoV.setBackground(new java.awt.Color(204, 204, 204));
        txtestadoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestadoVActionPerformed(evt);
            }
        });

        txtproveedorV.setBackground(new java.awt.Color(204, 204, 204));
        txtproveedorV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedorVActionPerformed(evt);
            }
        });

        btnnuevoV1.setBackground(new java.awt.Color(153, 153, 153));
        btnnuevoV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excellogo (1).png"))); // NOI18N
        btnnuevoV1.setBorder(null);
        btnnuevoV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoV1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtidvehiculoV, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(jLabel64)
                                .addComponent(txtcolorV)
                                .addComponent(txtmarcaV))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmodeloV, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtVINV)
                            .addComponent(txtañoV)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel65))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel69)
                    .addComponent(txtcosto_rentaV, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbodegaV, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtproveedorV, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txttipoV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addComponent(txtcosto_ventaV, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(btnguardarV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnactualizarV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btneliminarV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnnuevoV)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnnuevoV1))
                        .addComponent(txtestadoV, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidvehiculoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVINV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmarcaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmodeloV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcolorV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtañoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttipoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcosto_ventaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcosto_rentaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbodegaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtproveedorV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtestadoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnactualizarV)
                    .addComponent(btnguardarV)
                    .addComponent(btneliminarV)
                    .addComponent(btnnuevoV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnuevoV1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 182, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel9);

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));

        btnactualizarP.setBackground(new java.awt.Color(153, 153, 153));
        btnactualizarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        btnactualizarP.setBorder(null);

        btnguardarP.setBackground(new java.awt.Color(153, 153, 153));
        btnguardarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnguardarP.setBorder(null);
        btnguardarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarPActionPerformed(evt);
            }
        });

        btneliminarP.setBackground(new java.awt.Color(153, 153, 153));
        btneliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        btneliminarP.setBorder(null);

        btnnuevoP.setBackground(new java.awt.Color(153, 153, 153));
        btnnuevoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        btnnuevoP.setBorder(null);

        TablaClientes2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Vehiculo", "Total"
            }
        ));
        jScrollPane5.setViewportView(TablaClientes2);
        if (TablaClientes2.getColumnModel().getColumnCount() > 0) {
            TablaClientes2.getColumnModel().getColumn(0).setPreferredWidth(30);
            TablaClientes2.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        jLabel76.setText("IdMantenimiento");

        txtidmantenimiento.setBackground(new java.awt.Color(204, 204, 204));
        txtidmantenimiento.setBorder(null);
        txtidmantenimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidmantenimientoKeyPressed(evt);
            }
        });

        jLabel78.setText("Total");

        jLabel79.setText("Medio de pago");

        jLabel81.setText("Fecha factura");

        txtfechainiciom.setText("       dd/mm/yy");

        jLabel20.setText("Fecha inicio");

        txtfechafacturam.setText("       dd/mm/yy");

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 11.png"))); // NOI18N
        jLabel47.setText("ID Cliente:");

        txtidclientem.setBackground(new java.awt.Color(204, 204, 204));
        txtidclientem.setBorder(null);

        jLabel70.setText("Nombre del cliente:");

        txtnombreclientem.setBackground(new java.awt.Color(204, 204, 204));
        txtnombreclientem.setBorder(null);

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 11.png"))); // NOI18N
        jLabel82.setText("ID Empleado:");

        txtidempleadom.setBackground(new java.awt.Color(204, 204, 204));
        txtidempleadom.setBorder(null);

        txtempleadoNV1.setBackground(new java.awt.Color(204, 204, 204));
        txtempleadoNV1.setBorder(null);

        jLabel83.setText("Nombre del empleado:");

        LabelTotal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 9.png"))); // NOI18N
        LabelTotal1.setText("Total a pagar:");

        txtTPNV1.setBackground(new java.awt.Color(204, 204, 204));
        txtTPNV1.setBorder(null);

        txtmpago.setBackground(new java.awt.Color(204, 204, 204));

        txttotal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setText("Fecha fin");

        txtfechafinm.setText("       dd/mm/yy");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnguardarP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizarP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnuevoP))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtidclientem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombreclientem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtidempleadom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtempleadoNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83))
                        .addGap(31, 31, 31)
                        .addComponent(LabelTotal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTPNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtidmantenimiento))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addComponent(txtmpago, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel81))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(txtfechafacturam, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfechainiciom, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel20)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txtfechafinm, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 190, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel81)
                    .addComponent(jLabel78)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmpago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfechafacturam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfechainiciom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfechafinm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidmantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtidclientem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombreclientem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtidempleadom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtempleadoNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelTotal1)
                        .addComponent(txtTPNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnnuevoP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminarP)
                    .addComponent(btnactualizarP)
                    .addComponent(btnguardarP))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel10);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));

        btnSV.setBackground(new java.awt.Color(255, 204, 204));
        btnSV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 4.png"))); // NOI18N
        btnSV.setText("VENTAS");
        btnSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSVMouseExited(evt);
            }
        });
        btnSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSVActionPerformed(evt);
            }
        });

        btnSM.setBackground(new java.awt.Color(255, 204, 204));
        btnSM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 12.png"))); // NOI18N
        btnSM.setText("MANTENIMIENTOS");
        btnSM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSMMouseExited(evt);
            }
        });
        btnSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSMActionPerformed(evt);
            }
        });

        btnSR.setBackground(new java.awt.Color(255, 204, 204));
        btnSR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 13.png"))); // NOI18N
        btnSR.setText("RENTAS");
        btnSR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSRMouseExited(evt);
            }
        });
        btnSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnSV, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnSR, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(371, 531, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSM)
                .addGap(100, 100, 100))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnSV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnSR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnSM)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", jPanel11);

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));

        Tablahistorialventa.setBackground(new java.awt.Color(204, 204, 204));
        Tablahistorialventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Sucursal", "ID_facturaventa", "ID_Empleado", "id_cliente", "idVehiculo", "Fecha_venta", "Descripcion", "Costo", "mpago"
            }
        ));
        jScrollPane6.setViewportView(Tablahistorialventa);
        if (Tablahistorialventa.getColumnModel().getColumnCount() > 0) {
            Tablahistorialventa.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tablahistorialventa.getColumnModel().getColumn(1).setPreferredWidth(30);
            Tablahistorialventa.getColumnModel().getColumn(2).setPreferredWidth(30);
            Tablahistorialventa.getColumnModel().getColumn(3).setPreferredWidth(30);
            Tablahistorialventa.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tablahistorialventa.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Historial de Ventas");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel7)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab7", jPanel12);

        jPanel13.setBackground(new java.awt.Color(153, 153, 153));

        Tablahistorialrenta.setBackground(new java.awt.Color(204, 204, 204));
        Tablahistorialrenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sucursal", "ID_factura_renta", "ID_Empleado", "ID_cliente", "Id_vehiculo", "Id_Aval", "Fecha_inicio", "Fecha_fin", "costoTotal", "mpago"
            }
        ));
        jScrollPane7.setViewportView(Tablahistorialrenta);
        if (Tablahistorialrenta.getColumnModel().getColumnCount() > 0) {
            Tablahistorialrenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tablahistorialrenta.getColumnModel().getColumn(1).setPreferredWidth(30);
            Tablahistorialrenta.getColumnModel().getColumn(2).setPreferredWidth(30);
            Tablahistorialrenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            Tablahistorialrenta.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tablahistorialrenta.getColumnModel().getColumn(5).setPreferredWidth(30);
            Tablahistorialrenta.getColumnModel().getColumn(6).setPreferredWidth(30);
            Tablahistorialrenta.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Historial de Rentas");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel8)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab8", jPanel13);

        jPanel14.setBackground(new java.awt.Color(153, 153, 153));

        Tablahistorialmantenimientos.setBackground(new java.awt.Color(204, 204, 204));
        Tablahistorialmantenimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Sucursal", "ID_factura_mantenimiento", "ID_Empleado", "ID_Cliente", "ID_Vehiculo", "Fecha_Mantenimiento", "Descripcion", "Costo", "Mpago"
            }
        ));
        jScrollPane8.setViewportView(Tablahistorialmantenimientos);
        if (Tablahistorialmantenimientos.getColumnModel().getColumnCount() > 0) {
            Tablahistorialmantenimientos.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tablahistorialmantenimientos.getColumnModel().getColumn(3).setPreferredWidth(30);
            Tablahistorialmantenimientos.getColumnModel().getColumn(4).setPreferredWidth(30);
            Tablahistorialmantenimientos.getColumnModel().getColumn(5).setPreferredWidth(30);
            Tablahistorialmantenimientos.getColumnModel().getColumn(6).setPreferredWidth(100);
            Tablahistorialmantenimientos.getColumnModel().getColumn(7).setPreferredWidth(30);
            Tablahistorialmantenimientos.getColumnModel().getColumn(8).setPreferredWidth(30);
        }

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText("Historial de Mantenimientos");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel25)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", jPanel14);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ayuda");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("???");

        Labelsucursal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Labelsucursal.setForeground(new java.awt.Color(255, 255, 255));
        Labelsucursal.setText("SUCURSAL");

        btnclientesNV.setBackground(new java.awt.Color(255, 204, 204));
        btnclientesNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclientesNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image 5.png"))); // NOI18N
        btnclientesNV.setText("CLIENTES");
        btnclientesNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnclientesNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnclientesNVMouseExited(evt);
            }
        });
        btnclientesNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(Labelsucursal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnserviciosNV, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnnuevomantenimientoNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btncerrarsesionNV, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14))
                                .addComponent(btnnuevarentaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnnuevaventaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnvehiculosNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnclientesNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jButton1))
                                .addGap(42, 42, 42)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Labelsucursal)
                        .addGap(22, 22, 22)
                        .addComponent(btnnuevaventaNV)
                        .addGap(17, 17, 17)
                        .addComponent(btnnuevarentaNV)
                        .addGap(18, 18, 18)
                        .addComponent(btnnuevomantenimientoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnvehiculosNV)
                        .addGap(18, 18, 18)
                        .addComponent(btnclientesNV)
                        .addGap(24, 24, 24)
                        .addComponent(btnserviciosNV)
                        .addGap(18, 18, 18)
                        .addComponent(btncerrarsesionNV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarRentas();
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnSRActionPerformed

    private void btnSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSMActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarMantenimientos();
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnSMActionPerformed

    private void btnSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSVActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarVentas();
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnSVActionPerformed

    private void txtdireccionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionCActionPerformed

    private void txtsapellidoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsapellidoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsapellidoCActionPerformed

    private void txtpapellidoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpapellidoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpapellidoCActionPerformed

    private void txttelefonoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoCActionPerformed

    private void txtpnombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpnombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpnombreCActionPerformed

    private void btnnuevarentaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevarentaNVActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnnuevarentaNVActionPerformed

    private void btnnuevaventaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevaventaNVActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_btnnuevaventaNVActionPerformed

    private void btnguardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarCActionPerformed
        if (!"".equals(txtidcliente.getText()) || !"".equals(txtpnombreC.getText()) || !"".equals(txtsnombreC.getText()) || !"".equals(txtpapellidoC.getText()) || !"".equals(txtsapellidoC.getText()) || !"".equals(txttelefonoC.getText()) || !"".equals(txtcorreoC.getText()) || !"".equals(txtdireccionC.getText())) {
            cl.setIdPersona(Integer.parseInt(txtidcliente.getText()));
            cl.setPnombre(txtpnombreC.getText());
            cl.setSnombre(txtsnombreC.getText());
            cl.setPapellido(txtpapellidoC.getText());
            cl.setSapellido(txtsapellidoC.getText());
            cl.setTelefono((txttelefonoC.getText()));
            cl.setCorreo(txtcorreoC.getText());
            cl.setDireccion(txtdireccionC.getText());
            client.RegistrarCliente(cl);
            LimpiarTabla();
            LimpiarCliente();
            ListarCliente();
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnguardarCActionPerformed


    private void btnclientesNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesNVActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarCliente();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnclientesNVActionPerformed

    private void txtcorreoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoCActionPerformed

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked
        // TODO add your handling code here:
        int fila = TablaClientes.rowAtPoint(evt.getPoint());
        txtidcliente.setText(TablaClientes.getValueAt(fila, 0).toString());
        txtpnombreC.setText(TablaClientes.getValueAt(fila, 1).toString());
        txtsnombreC.setText(TablaClientes.getValueAt(fila, 2).toString());
        txtpapellidoC.setText(TablaClientes.getValueAt(fila, 3).toString());
        txtsapellidoC.setText(TablaClientes.getValueAt(fila, 4).toString());
        txttelefonoC.setText(TablaClientes.getValueAt(fila, 5).toString());
        txtcorreoC.setText(TablaClientes.getValueAt(fila, 6).toString());
        txtdireccionC.setText(TablaClientes.getValueAt(fila, 7).toString());

    }//GEN-LAST:event_TablaClientesMouseClicked

    private void btneliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarCActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtidcliente.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar?");
            if (pregunta == 0) {
                int idPersona = Integer.parseInt(txtidcliente.getText());
                client.EliminarCliente(idPersona);
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();

            }
        }
    }//GEN-LAST:event_btneliminarCActionPerformed

    private void btnactualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarCActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtidcliente.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtpnombreC.getText()) || !"".equals(txtsnombreC.getText()) || !"".equals(txtpapellidoC.getText()) || !"".equals(txtsapellidoC.getText()) || !"".equals(txttelefonoC.getText()) || !"".equals(txtcorreoC.getText()) || !"".equals(txtdireccionC.getText()) || !"".equals(txtidcliente.getText())) {
                cl.setPnombre(txtpnombreC.getText());
                cl.setSnombre(txtsnombreC.getText());
                cl.setPapellido(txtpapellidoC.getText());
                cl.setSapellido(txtsapellidoC.getText());
                cl.setTelefono((txttelefonoC.getText()));
                cl.setCorreo(txtcorreoC.getText());
                cl.setDireccion(txtdireccionC.getText());
                cl.setIdPersona(Integer.parseInt(txtidcliente.getText()));
                client.ModificarCliente(cl);
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnactualizarCActionPerformed

    private void btnnuevoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoCActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtidcliente.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");

        } else {
            cl.setPnombre(txtpnombreC.getText());
            cl.setSnombre(txtsnombreC.getText());
            cl.setPapellido(txtpapellidoC.getText());
            cl.setSapellido(txtsapellidoC.getText());
            cl.setTelefono(txttelefonoC.getText());
            cl.setCorreo(txtcorreoC.getText());
            cl.setDireccion(txtdireccionC.getText());
        }
        LimpiarCliente();
    }//GEN-LAST:event_btnnuevoCActionPerformed

    private void btnvehiculosNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvehiculosNVActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarVehiculo();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnvehiculosNVActionPerformed

    private void txtproveedorVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorVActionPerformed

    private void txtestadoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestadoVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestadoVActionPerformed

    private void txtbodegaVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbodegaVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbodegaVActionPerformed

    private void txttipoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttipoVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttipoVActionPerformed

    private void txtcolorVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolorVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcolorVActionPerformed

    private void TablavehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablavehiculosMouseClicked
        // TODO add your handling code here:
        int fila = Tablavehiculos.rowAtPoint(evt.getPoint());
        txtidvehiculoV.setText(Tablavehiculos.getValueAt(fila, 0).toString());
        txtVINV.setText(Tablavehiculos.getValueAt(fila, 1).toString());
        txtmarcaV.setText(Tablavehiculos.getValueAt(fila, 2).toString());
        txtmodeloV.setText(Tablavehiculos.getValueAt(fila, 3).toString());
        txtcolorV.setText(Tablavehiculos.getValueAt(fila, 4).toString());
        txtañoV.setText(Tablavehiculos.getValueAt(fila, 5).toString());
        txttipoV.setText(Tablavehiculos.getValueAt(fila, 6).toString());
        txtcosto_ventaV.setText(Tablavehiculos.getValueAt(fila, 7).toString());
        txtcosto_rentaV.setText(Tablavehiculos.getValueAt(fila, 8).toString());
        txtbodegaV.setText(Tablavehiculos.getValueAt(fila, 9).toString());
        txtproveedorV.setText(Tablavehiculos.getValueAt(fila, 10).toString());
        txtestadoV.setText(Tablavehiculos.getValueAt(fila, 11).toString());

    }//GEN-LAST:event_TablavehiculosMouseClicked

    private void btnnuevoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoVActionPerformed
        // TODO add your handling code here:
        LimpiarVehiculo();
    }//GEN-LAST:event_btnnuevoVActionPerformed

    private void btneliminarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarVActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtidvehiculoV.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtidvehiculoV.getText());
                vDAO.EliminarVehiculo(id);
                LimpiarTabla();
                ListarVehiculo();
                LimpiarVehiculo();
                JOptionPane.showMessageDialog(null, "Fila eliminada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btneliminarVActionPerformed

    private void btneliminarVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarVMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarVMouseClicked

    private void btnactualizarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarVActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtidvehiculoV.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtidvehiculoV.getText()) || !"".equals(txtVINV.getText()) || !"".equals(txtmarcaV.getText()) || !"".equals(txtmodeloV.getText()) || !"".equals(txtcolorV.getText()) || !"".equals(txtañoV.getText()) || !"".equals(txttipoV.getText()) || !"".equals(txtcosto_ventaV.getText()) || !"".equals(txtcosto_rentaV.getText()) || !"".equals(txtbodegaV.getText()) || !"".equals(txtproveedorV.getText()) || !"".equals(txtestadoV.getText())) {
                v.setIdVehiculo(Integer.parseInt(txtidvehiculoV.getText()));
                v.setVIN(txtVINV.getText());
                v.setMarca(txtmarcaV.getText());
                v.setModelo(txtmodeloV.getText());
                v.setColor(txtcolorV.getText());
                v.setAño(txtañoV.getText());
                v.setTipo(txttipoV.getText());
                v.setCosto_venta(Double.parseDouble(txtcosto_ventaV.getText()));
                v.setCosto_renta(Double.parseDouble(txtcosto_rentaV.getText()));
                v.setBodega(txtbodegaV.getText());
                v.setProveedor(txtproveedorV.getText());
                v.setEstado(txtestadoV.getText());
                vDAO.ModificarVehiculo(v);
                LimpiarTabla();
                ListarVehiculo();
                LimpiarVehiculo();
            }
        }

    }//GEN-LAST:event_btnactualizarVActionPerformed

    private void btnguardarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarVActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtidvehiculoV.getText()) || !"".equals(txtVINV.getText()) || !"".equals(txtmarcaV.getText()) || !"".equals(txtmodeloV.getText()) || !"".equals(txtcolorV.getText()) || !"".equals(txtañoV.getText()) || !"".equals(txttipoV.getText()) || !"".equals(txtcosto_ventaV.getText()) || !"".equals(txtcosto_rentaV.getText()) || !"".equals(txtbodegaV.getText()) || !"".equals(txtproveedorV.getText()) || !"".equals(txtestadoV.getText())) {
            v.setIdVehiculo(Integer.parseInt(txtidvehiculoV.getText()));
            v.setVIN(txtVINV.getText());
            v.setMarca(txtmarcaV.getText());
            v.setModelo(txtmodeloV.getText());
            v.setColor(txtcolorV.getText());
            v.setAño(txtañoV.getText());
            v.setTipo(txttipoV.getText());
            v.setCosto_venta(Double.parseDouble(txtcosto_ventaV.getText()));
            v.setCosto_renta(Double.parseDouble(txtcosto_rentaV.getText()));
            v.setBodega(txtbodegaV.getText());
            v.setProveedor(txtproveedorV.getText());
            v.setEstado(txtestadoV.getText());
            vDAO.RegistrarVehiculo(v);
            LimpiarTabla();
            ListarVehiculo();
            LimpiarVehiculo();
            JOptionPane.showMessageDialog(null, "Vehiculo Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }

    }//GEN-LAST:event_btnguardarVActionPerformed

    private void txtcosto_rentaVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcosto_rentaVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcosto_rentaVActionPerformed

    private void txtVINVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVINVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVINVActionPerformed

    private void txtañoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtañoVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtañoVActionPerformed

    private void txtmodeloVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodeloVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodeloVActionPerformed

    private void txtmarcaVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmarcaVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmarcaVActionPerformed

    private void btnnuevomantenimientoNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevomantenimientoNVActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnnuevomantenimientoNVActionPerformed

    private void btnserviciosNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnserviciosNVActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnserviciosNVActionPerformed

    private void txtidvehiculoNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidvehiculoNVKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtidvehiculoNV.getText())) {
                int idVehiculo = Integer.parseInt(txtidvehiculoNV.getText());
                v = vDAO.BuscarVehiculo(idVehiculo);
                if (v.getVIN() != null) {
                    txtVINNV.setText("" + v.getVIN());
                    txtcosto_ventaNV.setText("" + v.getCosto_venta());
                    txtestadoNV.setText("" + v.getEstado());
                    txtbodegaNV.setText("" + v.getBodega());
                    txtfechaNuevaV.requestFocus();
                } else {
                    txtVINNV.setText("");
                    txtcosto_ventaNV.setText("");
                    txtestadoNV.setText("");
                    txtbodegaNV.setText("");
                    txtfechaNuevaV.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el id del vehiculo.");
                txtidvehiculoNV.requestFocus();
            }

        }
    }//GEN-LAST:event_txtidvehiculoNVKeyPressed

    private void txtcosto_ventaNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcosto_ventaNVKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcosto_ventaNVKeyPressed

    private void txtfechaNuevaVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaNuevaVKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtfechaNuevaV.getText())){
                String idVehiculo = txtidvehiculoNV.getText();
                Double precio = Double.valueOf(txtcosto_ventaNV.getText());
                String estado = txtestadoNV.getText();
                //String seguro = txtseguroNV.getText();
                String seguro = comboseguro.getSelectedItem().toString();
                String bodega = txtbodegaNV.getText();
                String fecha = txtfechaNuevaV.getText();
                 if(!"Vendido".equals(estado) && !"Rentado".equals(estado)) {
                modelo = (DefaultTableModel) TablaNV.getModel();
                for (int i = 0; i < TablaNV.getRowCount(); i++ ){
                    if(TablaNV.getValueAt(i, 1).equals(txtidvehiculoNV.getText())){
                       JOptionPane.showMessageDialog(null,"El vehiculo ya esta registrado");
                       return;
                    }
                }
                ArrayList<Object> lista = new ArrayList<>();
                lista.add(item);
                lista.add(idVehiculo);
                lista.add(precio);
                lista.add(estado);
                lista.add(seguro);
                lista.add(bodega);
                lista.add(fecha);

                Object[] o = new Object[7];
                o[0] = lista.get(1);  
                o[1] = lista.get(2); 
                o[2] = lista.get(3); 
                o[3] = lista.get(4);
                o[4] = lista.get(5);
                o[5] = lista.get(6);

                modelo.addRow(o);
                TablaNV.setModel(modelo);
                TotalPagar();
                 }else{
                     LimpiarVenta();
                     JOptionPane.showMessageDialog(null,"Vehiculo no disponible");
                 }
                
            }else{
                JOptionPane.showMessageDialog(null,"Ingrese la fecha");
            }
        
        }
        
        
        
    }//GEN-LAST:event_txtfechaNuevaVKeyPressed

    private void txtestadoNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtestadoNVKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtestadoNVKeyPressed

    private void txtbodegaNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbodegaNVKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbodegaNVKeyPressed

    private void btnguardarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarPActionPerformed

    private void txtidmantenimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidmantenimientoKeyPressed
        // TODO add your handling code here:
 //       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
  //          if(!"".equals(txtidmantenimiento.getText())){
   //             int idfm = Integer.parseInt(txtidmantenimiento.getText());
     //           Mantenimiento = MantenimientoDAO.BuscarMantenimiento(idfm);
                
        
   //     }
    }//GEN-LAST:event_txtidmantenimientoKeyPressed

    private void btnnuevaventaNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevaventaNVMouseEntered
        // TODO add your handling code here:
        btnnuevaventaNV.setBackground(Color.RED);
    }//GEN-LAST:event_btnnuevaventaNVMouseEntered

    private void btnnuevaventaNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevaventaNVMouseExited
        // TODO add your handling code here:
        btnnuevaventaNV.setBackground(Color.PINK);
    }//GEN-LAST:event_btnnuevaventaNVMouseExited

    private void btnnuevaventaNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevaventaNVMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnnuevaventaNVMouseClicked

    private void btncerrarsesionNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionNVActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Login l = new Login();
        l.setVisible(true);
        
    }//GEN-LAST:event_btncerrarsesionNVActionPerformed

    private void btnnuevarentaNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevarentaNVMouseEntered
        // TODO add your handling code here:
        btnnuevarentaNV.setBackground(Color.RED);
    }//GEN-LAST:event_btnnuevarentaNVMouseEntered

    private void btnnuevomantenimientoNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevomantenimientoNVMouseEntered
        // TODO add your handling code here:
        btnnuevomantenimientoNV.setBackground(Color.RED);
    }//GEN-LAST:event_btnnuevomantenimientoNVMouseEntered

    private void btnvehiculosNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvehiculosNVMouseExited
        // TODO add your handling code here:
        btnvehiculosNV.setBackground(Color.PINK);
    }//GEN-LAST:event_btnvehiculosNVMouseExited

    private void btnvehiculosNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvehiculosNVMouseEntered
        // TODO add your handling code here:
        btnvehiculosNV.setBackground(Color.RED);
    }//GEN-LAST:event_btnvehiculosNVMouseEntered

    private void btnclientesNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientesNVMouseEntered
        // TODO add your handling code here:
        btnclientesNV.setBackground(Color.RED);
    }//GEN-LAST:event_btnclientesNVMouseEntered

    private void btnserviciosNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnserviciosNVMouseEntered
        // TODO add your handling code here:
        btnserviciosNV.setBackground(Color.RED);
    }//GEN-LAST:event_btnserviciosNVMouseEntered

    private void btnnuevarentaNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevarentaNVMouseExited
        // TODO add your handling code here:
        btnnuevarentaNV.setBackground(Color.PINK);
    }//GEN-LAST:event_btnnuevarentaNVMouseExited

    private void btnnuevomantenimientoNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnuevomantenimientoNVMouseExited
        // TODO add your handling code here:
        btnnuevomantenimientoNV.setBackground(Color.PINK);
    }//GEN-LAST:event_btnnuevomantenimientoNVMouseExited

    private void btnclientesNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientesNVMouseExited
        // TODO add your handling code here:
        btnclientesNV.setBackground(Color.PINK);
    }//GEN-LAST:event_btnclientesNVMouseExited

    private void btnserviciosNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnserviciosNVMouseExited
        // TODO add your handling code here:
        btnserviciosNV.setBackground(Color.PINK);
    }//GEN-LAST:event_btnserviciosNVMouseExited

    private void btnSVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSVMouseEntered
        // TODO add your handling code here:
        btnSV.setBackground(Color.RED);
    }//GEN-LAST:event_btnSVMouseEntered

    private void btnSVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSVMouseExited
        // TODO add your handling code here:
        btnSV.setBackground(Color.PINK);
    }//GEN-LAST:event_btnSVMouseExited

    private void btnSRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSRMouseEntered
        // TODO add your handling code here:
        btnSR.setBackground(Color.RED);
    }//GEN-LAST:event_btnSRMouseEntered

    private void btnSRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSRMouseExited
        // TODO add your handling code here:
        btnSR.setBackground(Color.PINK);
    }//GEN-LAST:event_btnSRMouseExited

    private void btnSMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMMouseEntered
        // TODO add your handling code here:
        btnSM.setBackground(Color.RED);
    }//GEN-LAST:event_btnSMMouseEntered

    private void btnSMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMMouseExited
        // TODO add your handling code here:
        btnSM.setBackground(Color.PINK);
    }//GEN-LAST:event_btnSMMouseExited

    private void btnnuevoV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoV1ActionPerformed
        // TODO add your handling code here:
        Excel.reporte();
    }//GEN-LAST:event_btnnuevoV1ActionPerformed

    private void txtidvehiculoNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidvehiculoNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidvehiculoNVActionPerformed

    private void btneliminarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarventaActionPerformed
        // TODO add your handling code here:
        int selectedRow = TablaNV.getSelectedRow();
    if (selectedRow >= 0) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta fila?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            modelo = (DefaultTableModel) TablaNV.getModel();
            modelo.removeRow(selectedRow);
            TotalPagar();
            txtidvehiculoNV.requestFocus();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
    }
    }//GEN-LAST:event_btneliminarventaActionPerformed

    private void txtIDclienteNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDclienteNVKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtIDclienteNV.getText())){
                int idcliente = Integer.parseInt(txtIDclienteNV.getText());
                cl = client.Buscarcliente(idcliente);
                if(cl.getPnombre() != null){
                    txtnombreclienteNV.setText(""+cl.getPnombre());
                    txttelefonoNV.setText(""+cl.getTelefono());
                    txtdireccionNV.setText(""+cl.getDireccion());
                }else{
                    txtIDclienteNV.setText("");
                    JOptionPane.showMessageDialog(null,"El cliente no existe");
            }
            }
            
        }
    }//GEN-LAST:event_txtIDclienteNVKeyPressed

    private void txtidempleadoNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidempleadoNVKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtidempleadoNV.getText())){
                int idempleado = Integer.parseInt(txtidempleadoNV.getText());
                em = emple.BuscarEmpleado(idempleado);
                if(em.getPnombre() != null){
                    txtempleadoNV.setText(""+em.getPnombre());
                
                }else{
                    txtidempleadoNV.setText("");
                    JOptionPane.showMessageDialog(null,"El empleado no existe");
                }
            }
        
        }
    }//GEN-LAST:event_txtidempleadoNVKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RegistrarVenta();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void comboseguroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboseguroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboseguroKeyPressed

    private void txtidvehiculoNRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidvehiculoNRActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtidvehiculoNRActionPerformed

    private void comboboxseguroNRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxseguroNRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxseguroNRActionPerformed

    private void txtnombreempleadoNRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreempleadoNRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreempleadoNRActionPerformed

    private void combompagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combompagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combompagoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pagina_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagina_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagina_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagina_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagina_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelTotal1;
    private javax.swing.JLabel Labelsucursal;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JTable TablaClientes2;
    private javax.swing.JTable TablaNR;
    private javax.swing.JTable TablaNV;
    private javax.swing.JTable Tablahistorialmantenimientos;
    private javax.swing.JTable Tablahistorialrenta;
    private javax.swing.JTable Tablahistorialventa;
    private javax.swing.JTable Tablavehiculos;
    private javax.swing.JButton btnSM;
    private javax.swing.JButton btnSR;
    private javax.swing.JButton btnSV;
    private javax.swing.JButton btnactualizarC;
    private javax.swing.JButton btnactualizarP;
    private javax.swing.JButton btnactualizarV;
    private javax.swing.JButton btncerrarsesionNV;
    private javax.swing.JButton btnclientesNV;
    private javax.swing.JButton btneliminarC;
    private javax.swing.JButton btneliminarP;
    private javax.swing.JButton btneliminarV;
    private javax.swing.JButton btneliminarventa;
    private javax.swing.JButton btnguardarC;
    private javax.swing.JButton btnguardarP;
    private javax.swing.JButton btnguardarV;
    private javax.swing.JButton btnnuevarentaNV;
    private javax.swing.JButton btnnuevaventaNV;
    private javax.swing.JButton btnnuevoC;
    private javax.swing.JButton btnnuevoP;
    private javax.swing.JButton btnnuevoV;
    private javax.swing.JButton btnnuevoV1;
    private javax.swing.JButton btnnuevomantenimientoNV;
    private javax.swing.JButton btnserviciosNV;
    private javax.swing.JButton btnvehiculosNV;
    private javax.swing.JComboBox<String> comboboxseguroNR;
    private javax.swing.JComboBox<String> combompago;
    private javax.swing.JComboBox<String> comboseguro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtIDclienteNV;
    private javax.swing.JTextField txtTPNV1;
    private javax.swing.JTextField txtVINNR;
    private javax.swing.JTextField txtVINNV;
    private javax.swing.JTextField txtVINV;
    private javax.swing.JTextField txtañoV;
    private javax.swing.JTextField txtbodegaNV;
    private javax.swing.JTextField txtbodegaV;
    private javax.swing.JTextField txtcolorV;
    private javax.swing.JTextField txtcorreoC;
    private javax.swing.JTextField txtcosto_rentaV;
    private javax.swing.JTextField txtcosto_ventaNV;
    private javax.swing.JTextField txtcosto_ventaV;
    private javax.swing.JTextField txtdireccionC;
    private javax.swing.JTextField txtdireccionNR;
    private javax.swing.JTextField txtdireccionNV;
    private javax.swing.JTextField txtempleadoNV;
    private javax.swing.JTextField txtempleadoNV1;
    private javax.swing.JTextField txtestadoNR;
    private javax.swing.JTextField txtestadoNV;
    private javax.swing.JTextField txtestadoV;
    private javax.swing.JTextField txtfechaNuevaV;
    private javax.swing.JTextField txtfechafacturam;
    private javax.swing.JTextField txtfechafin;
    private javax.swing.JTextField txtfechafinNR;
    private javax.swing.JTextField txtfechafinm;
    private javax.swing.JTextField txtfechainicioNR;
    private javax.swing.JTextField txtfechainiciom;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtidclienteNR;
    private javax.swing.JTextField txtidclientem;
    private javax.swing.JTextField txtidempleadoNR;
    private javax.swing.JTextField txtidempleadoNV;
    private javax.swing.JTextField txtidempleadom;
    private javax.swing.JTextField txtidmantenimiento;
    private javax.swing.JTextField txtidvehiculoNR;
    private javax.swing.JTextField txtidvehiculoNV;
    private javax.swing.JTextField txtidvehiculoV;
    private javax.swing.JTextField txtmarcaV;
    private javax.swing.JTextField txtmodeloV;
    private javax.swing.JTextField txtmpago;
    private javax.swing.JTextField txtnombreclienteNR;
    private javax.swing.JTextField txtnombreclienteNV;
    private javax.swing.JTextField txtnombreclientem;
    private javax.swing.JTextField txtnombreempleadoNR;
    private javax.swing.JTextField txtpapellidoC;
    private javax.swing.JTextField txtpnombreC;
    private javax.swing.JTextField txtprecioNR;
    private javax.swing.JTextField txtproveedorV;
    private javax.swing.JTextField txtsapellidoC;
    private javax.swing.JTextField txtsnombreC;
    private javax.swing.JTextField txttelefonoC;
    private javax.swing.JTextField txttelefonoNR;
    private javax.swing.JTextField txttelefonoNV;
    private javax.swing.JTextField txttipoV;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
    private void LimpiarCliente() {
        txtidcliente.setText("");
        txtpnombreC.setText("");
        txtsnombreC.setText("");
        txtpapellidoC.setText("");
        txtsapellidoC.setText("");
        txttelefonoC.setText("");
        txtcorreoC.setText("");
        txtdireccionC.setText("");
    }

    private void LimpiarVehiculo() {
        txtidvehiculoV.setText("");
        txtVINV.setText("");
        txtmarcaV.setText("");
        txtmodeloV.setText("");
        txtcolorV.setText("");
        txtañoV.setText("");
        txttipoV.setText("");
        txtcosto_ventaV.setText("");
        txtcosto_ventaV.setText("");
        txtcosto_rentaV.setText("");
        txtbodegaV.setText("");
        txtproveedorV.setText("");
        txtestadoV.setText("");
    }
    private void TotalPagar(){
        Totalpagar = 0.00;
        int numFila = TablaNV.getRowCount();
        for(int i = 0; i < numFila; i++){
            Double cal = Double.parseDouble(String.valueOf(TablaNV.getModel().getValueAt(i,1)));
            Totalpagar = Totalpagar + cal;
        }
        LabelTotal.setText(String.format("%.2f", Totalpagar));
    }
    private void LimpiarVenta(){
        txtidvehiculoNV.setText("");
        txtVINNV.setText("");
        //txtseguroNV.setText("");
        txtcosto_ventaNV.setText("");
        txtestadoNV.setText("");
        txtbodegaNV.setText("");
        txtfechaNuevaV.setText("");
    }

        private void RegistrarVenta(){
            int cliente = Integer.parseInt(txtIDclienteNV.getText());
            int empleado = Integer.parseInt(txtidempleadoNV.getText());
            double monto = Double.parseDouble(LabelTotal.getText());
            ve.setCliente(cliente);
            ve.setEmpleado(empleado);
            ve.setTotal(monto);
            veDAo.RegistrarVenta(ve); 
        }
}
