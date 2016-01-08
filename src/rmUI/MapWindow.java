package rmUI;

import javafx.application.Platform;

/**
 *
 * @author James.MacIsaac
 */
public class MapWindow extends javax.swing.JFrame {
    
    public static final int MIN_FRAME_WIDTH = 1000;
    public static final int MIN_FRAME_HEIGHT = 600;
    
    public static final int MAX_FRAME_WIDTH = 1000;
    public static final int MAX_FRAME_HEIGHT = 600;
    
    public static final int MIN_MAP_WIDTH = 785;
    public static final int MIN_MAP_HEIGHT = 600;

    private javafx.embed.swing.JFXPanel infoPanel;
    private javafx.embed.swing.JFXPanel mapPanel;

    private javax.swing.JSeparator panelSeparator;

    private javafx.stage.Stage stage;
    private javafx.scene.web.WebView mapView;
    private javafx.scene.web.WebEngine mapViewEngine;
    
    public static final String MAP_PAGE_ADDRESS = "http://gamtech.ca";

    public MapWindow() {
        initComponents();
    }

    public void run() {
        setLookAndFeel();
        initWeb();
        java.awt.EventQueue.invokeLater(() -> {
            new MapWindow().setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        infoPanel = new javafx.embed.swing.JFXPanel();
        mapPanel = new javafx.embed.swing.JFXPanel();
        panelSeparator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Router Map");
        setMinimumSize(new java.awt.Dimension(MIN_FRAME_WIDTH, MIN_FRAME_HEIGHT));
        setPreferredSize(new java.awt.Dimension(MAX_FRAME_WIDTH, MAX_FRAME_HEIGHT));

        //Set  the window to be centered on the screen
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        infoPanel.setName("infoPanel");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 200, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );

        mapPanel.setMinimumSize(new java.awt.Dimension(MIN_MAP_WIDTH, MIN_MAP_HEIGHT));

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
                mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 785, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
                mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 600, Short.MAX_VALUE)
        );

        panelSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSeparator)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void initWeb() {
        Platform.runLater(() -> {
            MapWebView web = new MapWebView();
            web.start(stage);
        });
    }

    private void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MapWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
