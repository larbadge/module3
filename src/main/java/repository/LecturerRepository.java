package repository;

import model.Lecturer;

import java.util.List;

public interface LecturerRepository {

    List<Lecturer> getAllByNameOrLastname(String name);

}
