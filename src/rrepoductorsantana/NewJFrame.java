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
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
                volumeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (clip != null) {
                    FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float volume = volumeSlider.getValue() / 100.0f; // Convertir a rango 0.0 - 1.0
                    float dB = (float) (Math.log(volume == 0.0 ? 0.0001 : volume) / Math.log(10.0) * 20.0);
                    volumeControl.setValue(dB);
                }
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
        Reproducir = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlbGif = new javax.swing.JLabel();
        lista = new javax.swing.JComboBox<>();
        pause = new javax.swing.JButton();
        prewiev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        volumeSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtR.setEditable(false);
        txtR.setBackground(new java.awt.Color(255, 255, 255));
        txtR.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        txtR.setForeground(new java.awt.Color(0, 0, 0));
        txtR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204), 3));
        txtR.setCaretColor(new java.awt.Color(255, 204, 204));
        getContentPane().add(txtR, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 300, 30));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Repro.png"))); // NOI18N
        play.setBorder(null);
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 120, 60));

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/detener (Custom).png"))); // NOI18N
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 70, 60));

        replay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/musica (Custom).png"))); // NOI18N
        replay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayActionPerformed(evt);
            }
        });
        getContentPane().add(replay, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 40, 40));

        Reproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Repro.png"))); // NOI18N
        Reproducir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReproducirMouseClicked(evt);
            }
        });
        getContentPane().add(Reproducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 140, 60));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        jlbGif.setBackground(new java.awt.Color(255, 255, 204));
        jlbGif.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), null, null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGif, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGif, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 300, 280));

        lista.setBackground(new java.awt.Color(204, 255, 204));
        lista.setForeground(new java.awt.Color(0, 0, 0));
        lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153), 2));
        getContentPane().add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 150, -1));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-de-pausa-de-video (Custom).png"))); // NOI18N
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        getContentPane().add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 70, 60));

        prewiev.setText("siguente");
        prewiev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prewievActionPerformed(evt);
            }
        });
        getContentPane().add(prewiev, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 70, 60));

        next.setText("next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 70, 60));
        getContentPane().add(volumeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 610));

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

    private void ReproducirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReproducirMouseClicked
         if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        txtR.setText((String) lista.getSelectedItem());
        clip.start();
    }//GEN-LAST:event_ReproducirMouseClicked

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
    private javax.swing.JLabel Reproducir;
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
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}
