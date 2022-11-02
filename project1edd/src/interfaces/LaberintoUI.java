/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import static interfaces.Home.alto;
import static interfaces.Home.ancho;
import static interfaces.Home.metodo;
import static interfaces.Home.totalNodos;
import javax.swing.table.DefaultTableModel;
import project1edd.Grafo;
import project1edd.Nodo;

/**
 *
 * @author andres
 */
public class LaberintoUI extends javax.swing.JFrame {
    /**
     * Creates new form PreHome
     */
    public LaberintoUI() {
        //jTextField2.setText(metodo.toString());
        //System.out.println(metodo);
        initComponents();
        this.setLocationRelativeTo(null);
        
        Home datos = new Home();
        
        int alto = datos.alto;
        int ancho = datos.ancho;
        
        int totalNodos = alto*ancho;
        
        //Crea el grafo donde estaran los nodos
        Grafo grafoLista = new Grafo(totalNodos);

        //Te crea los nodos y asigna sus nombres/numeros
        for (int i = 1; i <= totalNodos; i++) {
            String nombre = Integer.toString(i);
            grafoLista.nuevoVertice(nombre);
        }

        //Crea las relaciones entre nodos 
        for (int i = 1; i <= grafoLista.tablAdc.length; i++) {
            if (i <= (totalNodos-ancho)) {
                String suma = Integer.toString(ancho+i);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, suma);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe");
                }
            }
            if (i > ancho) {
                String resta = Integer.toString(i-ancho);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, resta);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe");
                }
            }
            if (i%ancho != 0) {
                String suma = Integer.toString(i+1);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, suma);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe");
                }
            }
            if ((i-1)%3!=0) {
                String resta = Integer.toString(i-1);
                String numeroActual = Integer.toString(i);
                try {
                    grafoLista.nuevoArco(numeroActual, resta);
                } catch (Exception e) {
                    System.out.println("Este nodo no existe" + numeroActual + resta);
                }
            }
        }


        for (Nodo tablAdc : grafoLista.tablAdc) {
            System.out.println(tablAdc.toString());
            for (int j = 0; j < tablAdc.lad.size(); j++) {
                System.out.println(tablAdc.lad.get(j).toString());
            }
        }

        //Para determinar entrada y salida del laberinto mediante un numero aleatorio
        int altoMin = alto - 2;
        int aleatorioEntrada = (int) (Math.random()*(((alto-1)-2)+1))+1;
        
        int aleatorioSalida = (int) (Math.random()*(((alto-1)-2)+1))+1;
        System.out.println(aleatorioSalida);
        System.out.println(aleatorioEntrada);
        
        while(aleatorioSalida == aleatorioEntrada){
            System.out.println(aleatorioSalida);
            System.out.println(aleatorioEntrada);
            aleatorioSalida = (int) (Math.random()*(((alto-1)-2)+1))+1;
            System.out.println(aleatorioSalida);
        }
        //son los numeros de los nodos de la entrada y la salida.
        int numeroNodoEntrada = (alto * (aleatorioEntrada-1) ) +1;
        int numeroNodoSalida = (alto * (aleatorioSalida-1) ) +1;
        //Falta incluir en los nodos que tipo de nodo es entrada, salida, pared, camino

        // de lista a matriz
        int matriz[][] = new int[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (j== 0 && i == aleatorioEntrada) {
                    matriz[i][j] = 3;
                } else if (j== ancho-1 && i == aleatorioSalida){
                    matriz[i][j] = 5;
                }else if (i == 0 || i == (alto-1)) {
                    matriz[i][j] = 0;
                }else if (j == 0 || j == (ancho-1)) {
                    matriz[i][j] = 0;
                }else{
                    matriz[i][j] = 1;
                }

            }
        }

        for (int x=0; x < matriz.length; x++) {
            System.out.print("|");
            for (int y=0; y < matriz[x].length; y++) {
              System.out.print (matriz[x][y]);
              if (y!=matriz[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
        
        DefaultTableModel model = (DefaultTableModel) tblMatriz.getModel();
        model.setRowCount(alto);
        model.setColumnCount(ancho);
        for(int i=0; i<alto; i++) {
            for(int j=0; j<ancho; j++){
                tblMatriz.setValueAt(matriz[i][j], i, j);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMatriz = new eTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Tiempo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 30));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("Método:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 190, 30));
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMatriz.setRowHeight(80);
        jScrollPane3.setViewportView(tblMatriz);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, 970, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(LaberintoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaberintoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaberintoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaberintoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaberintoUI().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblMatriz;
    // End of variables declaration//GEN-END:variables
}
