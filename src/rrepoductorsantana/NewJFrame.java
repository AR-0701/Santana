package rrepoductorsantana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultComboBoxModel;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class NewJFrame extends javax.swing.JFrame {

    File archivo;
    Clip clip;
    HashMap<String, String> audioFilesMap;
    private HashMap<String, String> audioToGifMap;
    private HashMap<String, ImageIcon> gifMap;
    private int currentAudioIndex = 0;
    private String[] audioFiles;

    public NewJFrame() {
        initComponents();
        llenarComboBox();
        cargarMapaAudiosYGifs();
        lista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre del archivo de audio seleccionado
                String nombreArchivo = (String) lista.getSelectedItem();
                currentAudioIndex = lista.getSelectedIndex();
                playAudio(nombreArchivo);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtR = new javax.swing.JTextField();
        play = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        replay = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlbGif = new javax.swing.JLabel();
        lista = new javax.swing.JComboBox<>();
        pause = new javax.swing.JButton();
        prewiev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        txtR.setForeground(new java.awt.Color(0, 0, 0));
        txtR.setText("reproduciendo");
        getContentPane().add(txtR, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 170, -1));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-de-play (Custom).png"))); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 461, 126, -1));

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/detener (Custom).png"))); // NOI18N
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 118, -1));

        replay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/musica (Custom).png"))); // NOI18N
        replay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayActionPerformed(evt);
            }
        });
        getContentPane().add(replay, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 110, 110));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbGif, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 300, 280));

        lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 160, -1));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-de-pausa-de-video (Custom).png"))); // NOI18N
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        getContentPane().add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 110, 110));

        prewiev.setText("siguente");
        prewiev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prewievActionPerformed(evt);
            }
        });
        getContentPane().add(prewiev, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 110, 110));

        next.setText("next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 110, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        txtR.setText((String) lista.getSelectedItem());
        clip.start();
    }//GEN-LAST:event_playActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }//GEN-LAST:event_stopActionPerformed

    private void replayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replayActionPerformed
        clip.setFramePosition(0);
        clip.start();
    }//GEN-LAST:event_replayActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        if (clip != null) {
            clip.stop();
        }
    }//GEN-LAST:event_pauseActionPerformed

    private void prewievActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prewievActionPerformed
        clip.stop();
        if (audioFiles != null && audioFiles.length > 0) {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            currentAudioIndex = (currentAudioIndex - 1 + audioFiles.length) % audioFiles.length;
            playAudio(audioFiles[currentAudioIndex]);
            lista.setSelectedIndex(currentAudioIndex);
        }
    }//GEN-LAST:event_prewievActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        clip.stop();
        if (audioFiles != null && audioFiles.length > 0) {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            currentAudioIndex = (currentAudioIndex + 1) % audioFiles.length;
            playAudio(audioFiles[currentAudioIndex]);
            lista.setSelectedIndex(currentAudioIndex);
        }
    }//GEN-LAST:event_nextActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    public void cplay(File ruta) {
        try {
            // Cargar el archivo de audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(ruta);

            // Obtener un clip de audio
            clip = AudioSystem.getClip();

            // Abrir el clip con el audio
            clip.open(audioStream);

        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio.");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println("La línea de audio no está disponible.");
            e.printStackTrace();
        }
    }

    private void cargarMapaAudiosYGifs() {
        audioToGifMap = new HashMap<>();
        // Directorio donde se encuentran los archivos de audio y GIFs
        File dirAudios = new File("C:\\Users\\alex_\\Documents\\NetBeansProjects\\RrepoductorSantana\\src\\musica");
        File dirGifs = new File("C:\\Users\\alex_\\Documents\\NetBeansProjects\\RrepoductorSantana\\src\\gif");

        // Obtener los archivos de audio y GIFs
        File[] archivosAudios = dirAudios.listFiles((d, name) -> name.endsWith(".wav"));
        File[] archivosGifs = dirGifs.listFiles((d, name) -> name.endsWith(".gif"));

        if (archivosAudios != null && archivosGifs != null) {
            // Asociar cada audio con su GIF correspondiente
            for (File audio : archivosAudios) {
                String audioNombre = audio.getName();
                String gifNombre = audioNombre.replace(".wav", ".gif");
                for (File gif : archivosGifs) {
                    if (gif.getName().equals(gifNombre)) {
                        audioToGifMap.put(audioNombre, gif.getAbsolutePath());
                        break;
                    }
                }
            }

            audioFiles = new String[archivosAudios.length];
            for (int i = 0; i < archivosAudios.length; i++) {
                audioFiles[i] = archivosAudios[i].getName();
            }

            gifMap = new HashMap<>();
            for (String audio : audioToGifMap.keySet()) {
                String gifPath = audioToGifMap.get(audio);
                gifMap.put(audio, new ImageIcon(gifPath));
            }
        }
    }

    private void playAudio(String nombreArchivo) {
        String nombreAudio = "C:\\Users\\alex_\\Documents\\NetBeansProjects\\RrepoductorSantana\\src\\musica\\" + nombreArchivo;
        archivo = new File(nombreAudio);
        if (clip != null) {
            clip.stop();
            clip.close();
        }
        cplay(archivo);
        clip.start();
        mostrarGif(nombreArchivo); // Mostrar el GIF correspondiente a la canción seleccionada
        txtR.setText(nombreArchivo); // Actualizar el texto de reproducción
    }

    private void mostrarGif(String nombreArchivo) {
        ImageIcon gifIcon = gifMap.get(nombreArchivo);
        if (gifIcon != null) {
            jlbGif.setIcon(gifIcon);
        }
    }

    private void llenarComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        File dirAudios = new File("C:\\Users\\alex_\\Documents\\NetBeansProjects\\RrepoductorSantana\\src\\musica");
        File[] archivosAudios = dirAudios.listFiles((d, name) -> name.endsWith(".wav"));

        if (archivosAudios != null) {
            for (File audio : archivosAudios) {
                model.addElement(audio.getName());
            }
        }

        lista.setModel(model);
        audioFiles = new String[archivosAudios.length];
        for (int i = 0; i < archivosAudios.length; i++) {
            audioFiles[i] = archivosAudios[i].getName();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbGif;
    private javax.swing.JComboBox<String> lista;
    private javax.swing.JButton next;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JButton prewiev;
    private javax.swing.JButton replay;
    private javax.swing.JButton stop;
    private javax.swing.JTextField txtR;
    // End of variables declaration//GEN-END:variables
}
