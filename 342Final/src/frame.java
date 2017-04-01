import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JButton;

class frame extends JFrame{
	public frame(){
		this("Restaurant Portal");
	}

	public frame(String title) {
		this.setSize(500,400);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		JButton button1 = new JButton("Customer");
		JButton button2 = new JButton("Restaurnat Admin");
		JButton button3 = new JButton("New Customer");
		
		this.add(button1);
		this.add(button2);
		this.add(button3);
		
		this.setVisible(true);
	}

}

