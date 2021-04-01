package moreInformation;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class moreInformationPanel extends JPanel {
	private JTextField id_TField;
	private JTextField title_TField;
	private JTextField author_TField;
	private JTextField pages_TField;
	private JTextField timesRead_TField;

	JComboBox status_CBox;
	JComboBox rating_CBox;
	/**
	 * Create the panel.
	 */
	public moreInformationPanel(String id, String title, String author, String pages, String rating, String timesRead, String status, String tags, String pictureLocation) {
		
		splitTagsUp(tags);
		
		setLayout(null);
		
		JLabel Id_lbl = new JLabel("id");
		Id_lbl.setBounds(22, 151, 46, 14);
		add(Id_lbl);
		
		JLabel title_lbl = new JLabel("title");
		title_lbl.setBounds(22, 221, 46, 14);
		add(title_lbl);
		
		JLabel author_lbl = new JLabel("author");
		author_lbl.setBounds(22, 291, 46, 14);
		add(author_lbl);
		
		JLabel pages_lbl = new JLabel("pages");
		pages_lbl.setBounds(22, 361, 46, 14);
		add(pages_lbl);
		
		JLabel rating_lbl = new JLabel("rating");
		rating_lbl.setBounds(22, 431, 46, 14);
		add(rating_lbl);
		
		JLabel timesRead_lbl = new JLabel("times read");
		timesRead_lbl.setBounds(22, 501, 82, 14);
		add(timesRead_lbl);
		
		JLabel status_lbl = new JLabel("status");
		status_lbl.setBounds(22, 571, 46, 14);
		add(status_lbl);
		
		JLabel titlePicture_lbl = new JLabel("title picture");
		titlePicture_lbl.setBounds(216, 11, 74, 14);
		add(titlePicture_lbl);
		
		JPanel panel = new JPanel();
		panel.setBounds(300, 11, 150, 212);
		add(panel);
		
		JLabel image_lbl = new JLabel("");
		image_lbl.setIcon(new ImageIcon(pictureLocation));
		panel.add(image_lbl);
		
		id_TField = new JTextField();
		id_TField.setBounds(22, 167, 86, 20);
		add(id_TField);
		id_TField.setColumns(10);
		
		title_TField = new JTextField();
		title_TField.setBounds(22, 237, 268, 20);
		add(title_TField);
		title_TField.setColumns(10);
		
		author_TField = new JTextField();
		author_TField.setBounds(22, 307, 140, 20);
		add(author_TField);
		author_TField.setColumns(10);
		
		pages_TField = new JTextField();
		pages_TField.setBounds(22, 377, 74, 20);
		add(pages_TField);
		pages_TField.setColumns(10);
		
		timesRead_TField = new JTextField();
		timesRead_TField.setBounds(22, 517, 46, 20);
		add(timesRead_TField);
		timesRead_TField.setColumns(10);

		id_TField.setText(id);
		
		title_TField.setText(title);
		
		author_TField.setText(author);
		
		pages_TField.setText(pages);
		
		timesRead_TField.setText(rating);
		
		JLabel tags_lbl = new JLabel("tags");
		tags_lbl.setBounds(22, 641, 46, 14);
		add(tags_lbl);
		
		String[] tagsArr = splitTagsUp(tags);
		JButton[] tagButtonArr = new JButton[tagsArr.length];
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout((tagsArr.length/3) + 1, 3));
		
		for(int i=0;i<tagsArr.length;i++) {
			tagButtonArr[i] = new JButton(tagsArr[i]);
			 
			panel_1.add(tagButtonArr[i]);
		}
		JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,0));
        container.add(panel_1);
        
        JScrollPane tagsBody_SPane = new JScrollPane(container, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tagsBody_SPane.setBounds(22, 667, 428, 80);
        add(tagsBody_SPane);
        
        rating_CBox = new JComboBox();
        rating_CBox.setModel(new DefaultComboBoxModel(new String[] {"N/A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        rating_CBox.setSelectedItem(rating);
        rating_CBox.setBounds(20, 447, 59, 24);
        add(rating_CBox);
        
        status_CBox = new JComboBox();
        status_CBox.setModel(new DefaultComboBoxModel(new String[] {"plan to read", "reading", "completed"}));
        status_CBox.setSelectedItem(status);
        status_CBox.setBounds(22, 587, 97, 24);
        add(status_CBox);
	}
	
	public String[] splitTagsUp(String tags) {
		char[] tagsChar = tags.toCharArray();
		int tagNumber = 0;
		for(int i=0;i<tagsChar.length;i++) {
			if(tagsChar[i] == ',') {
				tagNumber++;
			}
		}
		String[] tagsArr = new String[tagNumber];
		int currTag = 0;
		for(int i=0;i<tagsChar.length;i++) {
			if(tagsChar[i] == ',' && currTag+1<tagsArr.length)
				currTag++;
			else {
				if(tagsArr[currTag] == null)
					tagsArr[currTag] = "" + tagsChar[i];
				else
					tagsArr[currTag] = tagsArr[currTag] + tagsChar[i];				
			}
		}
		for(int i=1;i<tagsArr.length;i++) {
			String tmp = tagsArr[i];
			StringBuilder sb = new StringBuilder(tmp);
			sb.deleteCharAt(0);
			tmp = sb.toString();
			tagsArr[i] = tmp;
		}
		return tagsArr;
	}
	
	public String getRating() {
		return (String) rating_CBox.getSelectedItem();
	}
	
	public String getStatus() {
		return (String) status_CBox.getSelectedItem();
	}
}
