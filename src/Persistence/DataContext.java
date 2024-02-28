package Persistence;


import Exceptions.FileManagerException;
import Persistence.DataAccessors.DepartmentsDataAccessor;
import Persistence.DataAccessors.EmployeesDataAccessor;
import Persistence.DataAccessors.ProjectsDataAccessor;
import Settings.FileSettings;

import java.io.File;

public class DataContext {
    public static final File dataFilesDirectory = new File(FileSettings.baseDirectory + "/DataFiles");

    public DataContext() throws FileManagerException {

        if(!dataFilesDirectory.exists() && !dataFilesDirectory.mkdirs()) throw new FileManagerException("creating DataFiles directory was unsuccessful");
        projectsDataAccessor = new ProjectsDataAccessor(dataFilesDirectory);
        departmentsDataAccessor = new DepartmentsDataAccessor(dataFilesDirectory);
        employeesDataAccessor = new EmployeesDataAccessor(dataFilesDirectory);
    }

    private final ProjectsDataAccessor projectsDataAccessor;
    private final DepartmentsDataAccessor departmentsDataAccessor;
    private final EmployeesDataAccessor employeesDataAccessor;
    public ProjectsDataAccessor getProjectsDataAccessor() {
        return projectsDataAccessor;
    }

    public DepartmentsDataAccessor getDepartmentsDataAccessor() {
        return departmentsDataAccessor;
    }

    public EmployeesDataAccessor getEmployeesDataAccessor() {
        return employeesDataAccessor;
    }
}
