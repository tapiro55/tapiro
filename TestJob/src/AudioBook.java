import Exception.IllegalArgument;

public class AudioBook extends Video_Audio implements Comparable<AudioBook> {

	protected String audioName;
	protected double recordingLength;

	public AudioBook(int year, double price, String pName,int fileSize,boolean download, String audioName, double recordingLength)
			throws IllegalArgument{
		super(year, price, pName, fileSize, download);
		setAudioName(audioName);
		setRecordingLength(recordingLength);
		this.download=download;
		this.fileSize=fileSize;
		this.year=year;
		this.price=price;
		this.pName=pName;
	}

	public String getAudioName() {
		return audioName;
	}

	public double getRecordingLength() {
		return recordingLength;
	}

	public void setAudioName(String audioName) throws IllegalArgument {
		if((audioName.length() > 2) && (CheckString(audioName.toCharArray())))
			this.audioName = audioName;
		else throw new IllegalArgument("Audio Name is illegal");
	}
	
	public boolean CheckString(char[] name) {
		for (char c : name) {
			if(!Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	public void setRecordingLength(double recordingLength) throws IllegalArgument {
		if(recordingLength >=0)
			this.recordingLength = recordingLength;
		else throw new IllegalArgument("Recording Lenngth is illegal");
	}

	@Override
	public void setFileSize(int fileSize) throws IllegalArgument {
		if(fileSize >= 1000 && fileSize <= 2000) //Exception
			this.fileSize=fileSize;
		else throw new IllegalArgument("File Size is illegal");
	}

	@Override
	public void setYear(int year) throws IllegalArgument {
		if(year > 2010) //Exception
			this.year=year;
		else throw new IllegalArgument("Year is illegal");
	}

	@Override
	public void setPrice(double price) throws IllegalArgument {
		if(price >= 50 && price <= 150) //Exception
			this.price=price;
		else throw new IllegalArgument("Price is illegal");
	}

	@Override
	public boolean equals(Object other) {
		return (super.equals(other) && getAudioName().equals((AudioBook)other) &&
				getRecordingLength() == ((AudioBook)other).recordingLength);
	}

	@Override
	public String toString() {
		return (super.toString()+ "The name of the recorder: "+audioName+"\n"+ "The length of the recording is: "+recordingLength+"\n");
	}

	@Override
	public int compareTo(AudioBook a) {
		double diff = (this.recordingLength - a.getRecordingLength());
		if(diff > 0)
			return 1;
		if(diff < 0)
			return -1;
		else
			return 0;

	}
}
