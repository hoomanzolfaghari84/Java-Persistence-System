package Persistence.DataAccessors;

import Exceptions.FileManagerException;
import Models.User.Employee;
import Persistence.FileManager;
import Persistence.Mappers.EmployeeMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class EmployeesDataAccessor extends DataAccessor<Employee,Integer> {
    public EmployeesDataAccessor(File dataFilesDirectory) throws FileManagerException {
        super( dataFilesDirectory, "Employees");
    }

    @Override
    public void add(Employee employee) throws FileManagerException, IOException {
        File entryFile = new File(entriesDirectory + "/" + employee.id +".employee");
        if(!entryFile.exists()) {
            if(!entryFile.createNewFile()) throw new FileManagerException("could not create");
        }
        else throw new FileManagerException("already exists");

        try (FileWriter fileWriter = new FileWriter(entryFile)) {
            EmployeeMapper.map(employee,fileWriter);
            fileWriter.flush();
        }
    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public Employee load(Integer integer) throws FileNotFoundException {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public <T> boolean any(Predicate<T> predicate) {
        return false;
    }

    @Override
    public <T> List<Employee> where(Predicate<T> predicate) {
        return null;
    }
}
