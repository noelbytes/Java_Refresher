import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/* NOTE: In swings, you shouldn't have your user interface being updated from threads that you create yourself, 
 * your user interface should only be updated from the main kind of swing thread, and for that reason, the SwingWorker class 
 * has been introduced. 
*/
public class MainFrame extends JFrame {

	private JLabel countLabel1 = new JLabel("0");
	private JLabel statusLabel = new JLabel("Task not completed.");
	private JButton startButton = new JButton("Start");

	public MainFrame(String title) {
		super(title);

		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.fill = GridBagConstraints.NONE;

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		add(countLabel1, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		add(statusLabel, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		add(startButton, gridBagConstraints);

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				start();
			}
		});

		setSize(200, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void start() {
		// NOTE: SwingWorker is an abstract class
		// SwingWorker takes two template arguments
		// Void is more like the class version of void. Here, you can't use void as the
		// template argument, so you should use the class version
		// SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
		SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {

			// doInBackground() is more like the run() method of the Runnable interface /
			// Thread class
			@Override
			// protected Void doInBackground() throws InterruptedException {
			// The first template argument, i.e. Void is the return value for the
			// doInBackground function
			protected Boolean doInBackground() throws InterruptedException {
				// NOTE: Any sort of exception thrown from doInBackground() will be wrapped
				// within ExecutionException, which will be caught in the done() method
				for (int number = 0; number < 30; number++) {
					Thread.sleep(100);
					System.out.println("Hello : " + number);

					publish(number); // the value specified to publish should be of the type Integer, since it is the
										// type that has been specified in the second template arguments
				}

				// If you have Void as the return type, you must return null, otherwise you get
				// an error
				// return null;
				return false;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// TODO Auto-generated method stub
				// This method will receive the bunch of integers that are passed to publish,
				// although, that is not always guaranteed
				// If the loop in the doInBackground() method executes slowly, the process
				// method may be passed one integer at a time
				// super.process(chunks);
				Integer value = chunks.get(chunks.size() - 1);

				countLabel1.setText("Current value : " + value);
			}

			@Override
			protected void done() {
				// done() will be called when the thread finishes. In this method, you can
				// safely update the user interface / GUI
				// System.out.println("Done");
				try {
					Boolean status = get(); // get() will return the value of the first template argument, which in this
											// case is a Boolean. Since doInBackground is set to return false, it will
											// return the value false
					statusLabel.setText("Completed with status : " + status);
				} catch (InterruptedException exception) {
					// TODO Auto-generated catch block
					// This exception is caught if you call worker.cancel(). worker.cancel() won't
					// stop the existing code running in doInBackground()
					exception.printStackTrace();
				} catch (ExecutionException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}

		};

		worker.execute();
	}
}
