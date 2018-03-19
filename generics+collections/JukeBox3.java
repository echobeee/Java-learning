import java.util.*;
import java.io.*;

public class JukeBox3 {
	ArrayList<Song> songList = new ArrayList<Song>();
	public static void main(String[] args) {
		new JukeBox3().go();
	}

	class ArtistCompare implements Comparator<Song> {
		public int compare(Song one, Song two) {
			return one.getArtist().compareTo(two.getArtist());
		}
	}// inner class

	public void go() {
		ArrayList<Song> ob = new ArrayList<Object>();
		getSongs();
		System.out.println(songList);

		//sort by artist
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);// overloaded sort

		// sort by title
		// Collections.sort(songList); // primary sort

		System.out.println(songList);
	}

	private void getSongs() {
		try {
			File file = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}