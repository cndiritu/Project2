/**
* Provides a variant of JFrame that includes a window listener.
* The window listener closes the window and exits the current application when
* the user selectes the close button.
*
* Adapted from code written by Stuart Reges. Detailed reference available upon request.
*
* @author Christine Reilly
*/

import javax.swing.*;
import java.awt.event.*;

public class CloseableFrame extends JFrame
{
	public CloseableFrame() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
