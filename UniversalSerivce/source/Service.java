import javax.swing.*;
import java.io.*;
@SuppressWarnings("unchecked")
// all universal services extends this interface
public interface Service extends Serializable { // extends Serializable 
	public JPanel getGuiPanel();
}