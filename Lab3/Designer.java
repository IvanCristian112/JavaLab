import java.time.LocalDate;

public class Designer extends Person {
    private SoftwareTool softwareTool;

    public Designer(String name, LocalDate birthDate, SoftwareTool softwareTool) {
        super(name, birthDate);
        this.softwareTool = softwareTool;
    }
}
