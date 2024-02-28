package Settings;

import java.io.File;

public class FileSettings {
    public static final File baseDirectory = new File("FilesDirectory");
    public static final File dataFilesDirectory = new File(FileSettings.baseDirectory + "/DataFiles");
    public static final File departmentsDirectory = new File("FilesDirectory");
    public static final File employeesDirectory = new File("FilesDirectory");
    public static final File projectsDirectory = new File("FilesDirectory");

}
