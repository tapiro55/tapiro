import Exception.IllegalArgument;

public abstract class Video_Audio extends Product {

	protected int fileSize;
	protected boolean download;

	public Video_Audio(int year, double price, String pName,int fileSize,boolean download) throws IllegalArgument {
		super(year, price, pName);
		this.download = download;
	}

	public int getFileSize() {
		return fileSize;
	}

	public boolean getIsDownload() {
		return download;
	}

	public abstract void setFileSize(int fileSize) throws IllegalArgument;

	@Override
	public abstract void setYear(int year) throws IllegalArgument;

	@Override
	public abstract void setPrice(double price) throws IllegalArgument;

	@Override
	public boolean equals(Object other) {
		return (super.equals(other) && getIsDownload() == (((Video_Audio)other).getIsDownload()) &&
				getFileSize() == (((Video_Audio)other).getFileSize()));
	}

	@Override
	public String toString() {
		return (super.toString() + "The File Size is: "+ fileSize+"\nThe Product Enable to download: "+download+"\n");
	}

}
