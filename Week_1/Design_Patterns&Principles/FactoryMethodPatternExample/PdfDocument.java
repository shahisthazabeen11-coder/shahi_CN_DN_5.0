// public class which implements the Document interface and provides the implementation for opening a PDF document
public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }
}
