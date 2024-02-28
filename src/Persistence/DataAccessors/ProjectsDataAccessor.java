package Persistence.DataAccessors;

import Exceptions.FileManagerException;
import Models.Project.Project;
import Persistence.FileManager;
import Persistence.Mappers.ProjectMapper;
import Settings.FileSettings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ProjectsDataAccessor extends DataAccessor<Project,Integer> {

    public static File entriesDirectory = FileSettings.projectsDirectory;
    public ProjectsDataAccessor( ) throws FileManagerException {
        super();

        if(!entriesDirectory.exists() && !entriesDirectory.mkdirs()) throw new FileManagerException("creating model directory "+ entriesDirectory.getName() + " was unsuccessful");

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

    @Override
    public List<Integer> AllExistingKeys() {
        List<Integer> keys = new LinkedList<>();
        for (File entry : Objects.requireNonNull(entriesDirectory.listFiles(File::isFile))){
            keys.add(Integer.parseInt(entry.getName().split("\\.")[0]));
        }
        return keys;
    }
}
