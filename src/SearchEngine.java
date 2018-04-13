import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SearchEngine {
	String searchKey;
	public static void main(String[] args) {
		SearchEngine browser = new SearchEngine();
		try {
			String url = JOptionPane.showInputDialog("PROGRAM SEARCH ENGINE");
			String searchKey = url.replaceAll(" ", "%20");
			if(searchKey.startsWith("www.")){
				url = url.replaceAll(" ", "");
				browser.search("http://"+url);
			}else {
				//String imageUrl = "&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjhytzq667aAhWDrI8KHW2KDAYQ_AUICigB&biw=1366&bih=594";
				browser.search("https://www.google.com/search?q="+searchKey/*+imageUrl*/);
			}
		}catch(Exception ex) {
			ex.getMessage();
			System.out.println("System Error: "+ex);
		}
	}
	
	private void search(String key) {
		try {
			Desktop.getDesktop().browse(URI.create(key));
		}catch(IOException ex) {
			ex.getMessage();
			System.out.println("System IO Error: "+ex);
		}
	}

}