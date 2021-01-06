/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import civitas.TituloPropiedad;
/**
 *
 * @author Esther
 */
public class PropiedadPanel extends javax.swing.JPanel {
    
    TituloPropiedad titulo;
    
    void setPropiedad(TituloPropiedad t){
        titulo = t;
        tpropiedad.setText(titulo.getNombre());
        propietario.setText(titulo.getPropietario().getNombre());
        alquilerbase.setText(String.valueOf(titulo.getAlquilerBase()));
        hipotecabase.setText(String.valueOf(titulo.getHipotecaBase()));
        ncasas.setText(String.valueOf(titulo.getNumCasas()));
        nhoteles.setText(String.valueOf(titulo.getNumHoteles()));
        pcompra.setText(String.valueOf(titulo.getPrecioCompra()));
        pedificar.setText(String.valueOf(titulo.getPrecioEdificar()));
        
        if(titulo.getHipotecado())
            hipotecada.setText("Si");
        else
            hipotecada.setText("No");
        

    }

    /**
     * Creates new form PropiedadPanel
     */
    public PropiedadPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A1 = new javax.swing.JLabel();
        A7 = new javax.swing.JLabel();
        A8 = new javax.swing.JLabel();
        tpropiedad = new javax.swing.JTextField();
        A9 = new javax.swing.JLabel();
        ncasas = new javax.swing.JTextField();
        nhoteles = new javax.swing.JTextField();
        hipotecada = new javax.swing.JTextField();
        A2 = new javax.swing.JLabel();
        propietario = new javax.swing.JTextField();
        A4 = new javax.swing.JLabel();
        hipotecabase = new javax.swing.JTextField();
        A5 = new javax.swing.JLabel();
        pcompra = new javax.swing.JTextField();
        A3 = new javax.swing.JLabel();
        alquilerbase = new javax.swing.JTextField();
        A6 = new javax.swing.JLabel();
        pedificar = new javax.swing.JTextField();

        A1.setText("Titulo:");

        A7.setText("Numero de casas:");

        A8.setText("Numero de hoteles:");

        tpropiedad.setText("Título");
        tpropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpropiedadActionPerformed(evt);
            }
        });

        A9.setText("Hipotecada:");

        ncasas.setText("Número de casas");
        ncasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncasasActionPerformed(evt);
            }
        });

        nhoteles.setText("Número de hoteles");
        nhoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhotelesActionPerformed(evt);
            }
        });

        hipotecada.setText("Hipotecada");
        hipotecada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hipotecadaActionPerformed(evt);
            }
        });

        A2.setText("Propietario:");

        propietario.setText("Propietario");
        propietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propietarioActionPerformed(evt);
            }
        });

        A4.setText("Hipoteca base:");

        hipotecabase.setText("Hipoteca base");
        hipotecabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hipotecabaseActionPerformed(evt);
            }
        });

        A5.setText("Precio de compra:");

        pcompra.setText("Precio de compra");
        pcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcompraActionPerformed(evt);
            }
        });

        A3.setText("Alquiler base:");

        alquilerbase.setText("Alquiler base");

        A6.setText("Precio edificar:");

        pedificar.setText("Precio edificar");
        pedificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(A3)
                    .addComponent(A5)
                    .addComponent(A4)
                    .addComponent(A2)
                    .addComponent(A8)
                    .addComponent(A1)
                    .addComponent(A9)
                    .addComponent(A7)
                    .addComponent(A6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ncasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nhoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hipotecada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hipotecabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alquilerbase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(propietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A1)
                    .addComponent(tpropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A2)
                    .addComponent(propietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A3)
                    .addComponent(alquilerbase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A4)
                    .addComponent(hipotecabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A5)
                    .addComponent(pcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A6)
                    .addComponent(pedificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A7)
                    .addComponent(ncasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A8)
                    .addComponent(nhoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A9)
                    .addComponent(hipotecada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tpropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpropiedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpropiedadActionPerformed

    private void nhotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhotelesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhotelesActionPerformed

    private void hipotecadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hipotecadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hipotecadaActionPerformed

    private void ncasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncasasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ncasasActionPerformed

    private void propietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propietarioActionPerformed

    private void hipotecabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hipotecabaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hipotecabaseActionPerformed

    private void pcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcompraActionPerformed

    private void pedificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A1;
    private javax.swing.JLabel A2;
    private javax.swing.JLabel A3;
    private javax.swing.JLabel A4;
    private javax.swing.JLabel A5;
    private javax.swing.JLabel A6;
    private javax.swing.JLabel A7;
    private javax.swing.JLabel A8;
    private javax.swing.JLabel A9;
    private javax.swing.JTextField alquilerbase;
    private javax.swing.JTextField hipotecabase;
    private javax.swing.JTextField hipotecada;
    private javax.swing.JTextField ncasas;
    private javax.swing.JTextField nhoteles;
    private javax.swing.JTextField pcompra;
    private javax.swing.JTextField pedificar;
    private javax.swing.JTextField propietario;
    private javax.swing.JTextField tpropiedad;
    // End of variables declaration//GEN-END:variables
}
