package checkers;


public class IntelliChecker {
    public static void main(String args[]) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                	// CheckerFrame() sets up the window
                    new CheckerFrame();
            	}
        });
    }
}
