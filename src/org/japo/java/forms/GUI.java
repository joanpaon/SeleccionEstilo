/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.japo.java.components.BackgroundPanel;
import org.japo.java.events.AEM;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends JFrame {

    // Tamaño de la ventana
    public static final int VENTANA_ANC = 600;
    public static final int VENTANA_ALT = 300;

    // Componentes del IGU
    private JCheckBox cbxNegrita;
    private JCheckBox cbxCursiva;
    private JLabel lblPrueba;

    // Valores predeterminados de fuente
    private final String FNT_FAM = "Georgia";
    private final int FNT_TAM_LBL = 40;
    private final int FNT_TAM_CBX = 30;

    // Recurso con la imagen de forndo del panel
    private final String RES_PKG = "/img";
    private final String RES_IMG = "background.jpg";
    private final String RECURSO = RES_PKG + "/" + RES_IMG;

    // Texto de prueba
    private final String TEXTO = "Érase una vez Java";

    public GUI() {
        // Inicialización PREVIA
        beforeInit();

        // Creación del interfaz
        initComponents();

        // Inicialización POSTERIOR
        afterInit();
    }

    // Construcción del IGU
    private void initComponents() {
        // Tamaños de componentes
        Dimension dimBotones = new Dimension(200, 35);

        // Fuente de la etiqueta
        Font fntLabel = new Font(FNT_FAM, Font.PLAIN, FNT_TAM_LBL);
        Font fntBoton = new Font(FNT_FAM, Font.PLAIN, FNT_TAM_CBX);

        // Gestor de eventos de accion
        AEM aem = new AEM(this);

        // Etiqueta de prueba
        lblPrueba = new JLabel();
        lblPrueba.setFont(fntLabel);
        lblPrueba.setText(TEXTO);
        lblPrueba.setHorizontalAlignment(JLabel.CENTER);

        // Imagen de fondo
        URL urlImagen = getClass().getResource(RECURSO);
        Image i = new ImageIcon(urlImagen).getImage();

        // Panel de control
        JPanel pnlControl = new BackgroundPanel(i);
        pnlControl.setLayout(new GridLayout(2, 1));

        // Selector de negrita
        cbxNegrita = new JCheckBox("Negrita");
        cbxNegrita.addActionListener(aem);
        cbxNegrita.setPreferredSize(dimBotones);
        cbxNegrita.setOpaque(false);
        cbxNegrita.setFont(fntBoton);
        cbxNegrita.setHorizontalAlignment(JCheckBox.CENTER);
        pnlControl.add(cbxNegrita);

        // Selector de cursiva
        cbxCursiva = new JCheckBox("Cursiva");
        cbxCursiva.addActionListener(aem);
        cbxCursiva.setPreferredSize(dimBotones);
        cbxCursiva.setOpaque(false);
        cbxCursiva.setFont(fntBoton);
        cbxCursiva.setHorizontalAlignment(JCheckBox.CENTER);
        pnlControl.add(cbxCursiva);

        // Panel principal
        JPanel pnlPpal = new JPanel();
        pnlPpal.setLayout(new GridLayout(2, 1));
        pnlPpal.add(lblPrueba);
        pnlPpal.add(pnlControl);

        // Ventana principal
        setTitle("Respuesta Encuesta");
        setContentPane(pnlPpal);
        setResizable(false);
        setSize(VENTANA_ANC, VENTANA_ALT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Inicialización antes del IGU
    private void beforeInit() {

    }

    // Inicialización después del IGU
    private void afterInit() {

    }

    public void procesarEstilo(ActionEvent e) {
        // Valores actuales
        int negrita = cbxNegrita.isSelected() ? Font.BOLD : Font.PLAIN;
        int cursiva = cbxCursiva.isSelected() ? Font.ITALIC : Font.PLAIN;

        // Calcula estilo
        int estilo = negrita + cursiva;

        // Actualiza fuente
        Font fuente = new Font(FNT_FAM, estilo, FNT_TAM_LBL);

        // Aplica fuente
        lblPrueba.setFont(fuente);
    }

}
