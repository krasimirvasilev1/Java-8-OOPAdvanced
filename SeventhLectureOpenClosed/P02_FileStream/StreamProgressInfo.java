package SeventhLectureOpenClosed.P02_FileStream;

public class StreamProgressInfo {
    private Stream differentKindOfStream;

    public StreamProgressInfo(Stream stream) {
        this.differentKindOfStream = stream;
    }

    private int calculateCurrentPercent() {
        return (this.differentKindOfStream.getBytesSent() * 100) / this.differentKindOfStream.getLength();
    }

    public static void main(String[] args) {
        StreamProgressInfo stream = new StreamProgressInfo(new Music("krasi","RockIt",10,3));
        StreamProgressInfo stream1 = new StreamProgressInfo (new File("newFile",5,3));

        System.out.println(stream.calculateCurrentPercent());
        System.out.println(stream1.calculateCurrentPercent());
    }
}
