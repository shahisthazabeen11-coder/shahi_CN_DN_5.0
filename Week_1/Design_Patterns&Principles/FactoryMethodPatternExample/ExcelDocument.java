// public class which implements the Document interface and provides the implementation for opening an Excel document
public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }
    
}
