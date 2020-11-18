package io_w2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SimpleTwoColumnsForm {
	private Label labelFirstName;
	private Label labelLastName;
	private Label labelBirthDate;
	private Text firstName;
	private Text lastName;
	private DateTime birthDate;
	private Label labelDaneOsobowe;
	private Label labelEmail;
	private Text textEmail;
	private Label labelSex;
	private Combo comboSex;

	public void initGui() {
		Display display = new Display ();
		final Shell shell = new Shell(display);
		GridLayout gl=new GridLayout(2, true);
		gl.horizontalSpacing=50;
		shell.setLayout(gl);
		labelDaneOsobowe=new Label(shell, SWT.NONE);
		labelDaneOsobowe.setText("DANE OSOBOWE:");
		labelDaneOsobowe.setFont(new Font(Display.getDefault(), "Chiller", 20, 5));
		Label empty=new Label(shell, SWT.NONE);
		labelFirstName=new Label(shell, SWT.NONE);
		labelFirstName.setText("Podaj imię");
		labelFirstName.setForeground(new Color(null, 128,128,128));
		firstName=new Text(shell,SWT.BORDER);
		firstName.setBackground(new Color(null,220,220,220));
		labelLastName=new Label(shell, SWT.NONE);
		labelLastName.setText("Podaj nazwisko");
		labelLastName.setForeground(new Color(null, 0,240,0));
		lastName=new Text(shell,SWT.BORDER);
		lastName.setBackground(new Color(null,220,220,220));
		labelBirthDate=new Label(shell, SWT.NONE);
		labelBirthDate.setText("Podaj datę urodzenia");
		labelBirthDate.setForeground(new Color(null, 240,0,0));
		birthDate=new DateTime(shell, SWT.DROP_DOWN);
		labelEmail=new Label(shell, SWT.NONE);
		labelEmail.setText("Podaj e-mail");
		labelEmail.setForeground(new Color(null, 0,240,0));
		textEmail=new Text(shell,SWT.BORDER);
		textEmail.setBackground(new Color(null,220,220,220));
		labelSex=new Label(shell, SWT.NONE);
		labelSex.setText("Podaj Płeć");
		labelSex.setForeground(new Color(null, 240,0,0));
		comboSex=new Combo(shell, SWT.BORDER);
		comboSex.add("Kobieta");
		comboSex.add("Mężczyzna");
		
		shell.open ();
		shell.setSize(800,300);
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

	}
}