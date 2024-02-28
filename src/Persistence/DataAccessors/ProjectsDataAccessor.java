package Persistence.DataAccessors;

import Exceptions.FileManagerException;
import Models.Project.Project;
import Persistence.FileManager;
import Persistence.Mappers.ProjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class ProjectsDataAccessor extends DataAccessor<Project,Integer> {


    public ProjectsDataAccessor(File dataFilesDirectory ) throws FileManagerException {
        super(dataFilesDirectory, "Projects");
    }

    @Override
    public void add(Project project) throws FileManagerException, IOException {
        File entryFile = new File(entriesDirectory + "/" + project.id +".project");
        if(!entryFile.exists()) {
            if(!entryFile.createNewFile()) throw new FileManagerException("could not create");
        }
        else throw new FileManagerException("already exists");

        try (FileWriter fileWriter = new FileWriter(entryFile)) {
            ProjectMapper.map(project,fileWriter);
            fileWriter.flush();
        }
    }

    @Override
    public void delete(Project project) {

    }

    @Override
    public Project load(Integer integer) {
        return null;
    }

    @Override
    public Project update(Project project) {
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
    public <T> List<Project> where(Predicate<T> predicate) {
        return null;
    }
}
