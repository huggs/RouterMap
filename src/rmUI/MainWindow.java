package rmUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainWindow {

	private JFrame frmRouterMap;
	private JFXPanel infoPanel;
	private JFXPanel mapPanel;
	private JSeparator separator;
	// Happy sucks
	private WebView mapView;
	private WebEngine mapViewEngine;

	private Scene mapScene;

	/**
	 * Launch the application.
	 */
	public void runWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					initBrowser();
					window.frmRouterMap.setVisible(true);
				} catch (Exception e) {
					System.err.println(e);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmRouterMap = new JFrame();
		frmRouterMap.setResizable(false);
		frmRouterMap.setTitle("Router Map");
		frmRouterMap.setBounds(100, 100, 1100, 700);
		frmRouterMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		infoPanel = new JFXPanel();
		separator = new JSeparator();
		mapPanel = new JFXPanel();

		GroupLayout gl_mapPanel = new GroupLayout(mapPanel);
		gl_mapPanel
				.setHorizontalGroup(gl_mapPanel.createParallelGroup(Alignment.LEADING).addGap(0, 860, Short.MAX_VALUE));
		gl_mapPanel
				.setVerticalGroup(gl_mapPanel.createParallelGroup(Alignment.LEADING).addGap(0, 672, Short.MAX_VALUE));
		mapPanel.setLayout(gl_mapPanel);
		separator.setForeground(new Color(0, 102, 255));
		separator.setOrientation(SwingConstants.VERTICAL);
		GroupLayout gl_frmRouterMap = new GroupLayout(frmRouterMap.getContentPane());
		gl_frmRouterMap
				.setHorizontalGroup(
						gl_frmRouterMap.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_frmRouterMap.createSequentialGroup().addGap(2)
										.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)
								.addGap(2)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(mapPanel, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)));
		gl_frmRouterMap.setVerticalGroup(gl_frmRouterMap.createParallelGroup(Alignment.LEADING).addGroup(gl_frmRouterMap
				.createSequentialGroup()
				.addGroup(gl_frmRouterMap.createParallelGroup(Alignment.TRAILING)
						.addComponent(mapPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE).addGroup(Alignment.LEADING,
								gl_frmRouterMap.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(separator, Alignment.LEADING).addComponent(infoPanel,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)))
				.addGap(226)));
		frmRouterMap.getContentPane().setLayout(gl_frmRouterMap);
	}

	private void initBrowser() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				mapView = new WebView();
				mapViewEngine = mapView.getEngine();
				mapViewEngine.load("http://www.google.ca");
				System.out.println(mapViewEngine.getTitle());
				mapScene = new Scene(mapView);
				mapPanel.setScene(mapScene);
			}
		});
	}
}
