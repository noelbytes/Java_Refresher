import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			// You can also update the GUI using normal thread, but you need to make sure that you use SwingUtilities
			// invokeLater() actually runs stuff on the main swing GUI thread
			
			@Override
			public void run() {
				new MainFrame("SwingWorker Demo");
			}
		});
	}
}
