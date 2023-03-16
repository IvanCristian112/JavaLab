import java.time.LocalDate;

public class Programmer extends Person{
    private ExperienceLevel experienceLevel;
    private Specialization specialization;

    public Programmer(String name, LocalDate birthDate, ExperienceLevel experienceLevel, Specialization specialization) {
        super(name, birthDate);
        this.experienceLevel = experienceLevel;
        this.specialization = specialization;
    }
}
