import javax.sound.midi.*;

public class MiniMiniMusicApp {
	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}

	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer(); // sequencer => cd player
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4); // Ignore the arguments

			Track track = seq.createTrack(); // ask the Sequence for a Track.
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, 102, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);								 // Tcack lives in the Sequence, MIDI data lives in the Track

			ShortMessage a = new ShortMessage();/// message says what to do
			a.setMessage(144, 1, 20, 120);// 144 -> notes on, 1 -> channel 1, 44 -> notes 44, 100 -> velocity
			MidiEvent noteOn = new MidiEvent(a, 1); // trigger message 'a' at the 1st beat , events says when to do
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 32);
			track.add(noteOff);

			player.setSequence(seq); // put the cd in the cd player

			player.start(); // play

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}