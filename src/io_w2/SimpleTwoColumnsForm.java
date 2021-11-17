package io_w2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
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
import sun.applet.resources.MsgAppletViewer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public void initGui() {
		Display display = new Display ();
		final Shell shell = new Shell(display);
		GridLayout gl=new GridLayout(2, true);
		gl.horizontalSpacing=50;
		gl.marginLeft=30;
		gl.marginRight=30;
		shell.setLayout(gl);
		labelDaneOsobowe=new Label(shell, SWT.NONE);
		labelDaneOsobowe.setText("DANE OSOBOWE:");
		labelDaneOsobowe.setFont(new Font(Display.getDefault(), "Chiller", 20, 5));
		Label empty=new Label(shell, SWT.NONE);
		labelFirstName=new Label(shell, SWT.NONE);
		labelFirstName.setText("Podaj imię");
		labelFirstName.setForeground(new Color(null, 0,255,0));
		firstName=new Text(shell,SWT.BORDER);
		firstName.setBackground(new Color(null,220,220,220));
		GridData gd=new GridData();
		gd.grabExcessHorizontalSpace=true;
		gd.horizontalAlignment=SWT.FILL;
		firstName.setLayoutData(gd);
		labelLastName=new Label(shell, SWT.NONE);
		labelLastName.setText("Podaj nazwisko");
		labelLastName.setForeground(new Color(null, 0,240,0));
		lastName=new Text(shell,SWT.BORDER);
		lastName.setBackground(new Color(null,220,220,220));
		lastName.setLayoutData(gd);
		labelBirthDate=new Label(shell, SWT.NONE);
		labelBirthDate.setText("Podaj datę urodzenia");
		labelBirthDate.setForeground(new Color(null, 240,0,0));
		birthDate=new DateTime(shell, SWT.DROP_DOWN);
		birthDate.setLayoutData(gd);
		labelEmail=new Label(shell, SWT.NONE);
		labelEmail.setText("Podaj adres e-mail");
		labelEmail.setForeground(new Color(null, 0,240,0));
		textEmail=new Text(shell,SWT.BORDER);
		textEmail.setBackground(new Color(null,220,220,220));
		textEmail.setLayoutData(gd);
		labelSex=new Label(shell, SWT.NONE);
		labelSex.setText("Podaj Płeć");
		labelSex.setForeground(new Color(null, 240,0,0));
		comboSex=new Combo(shell, SWT.BORDER);
		comboSex.add("Kobieta");
		comboSex.add("Mężczyzna");
		comboSex.add("inna");
		comboSex.setLayoutData(gd);

		textEmail.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent modifyEvent) {
				String text=((Text)modifyEvent.widget).getText();
				if(text.length()>7 && !validate(text)){
					MessageBox mb=new MessageBox(shell,SWT.OK);
					mb.setText("wprowadzony nieprawidłowy adres email");
					mb.setMessage(text);
					mb.open();

				}
			}
		});

		shell.open ();
		shell.setSize(650,250);
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

	}
}