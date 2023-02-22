package com.mikhalov.repository;

import com.mikhalov.model.Lecturer;

import java.util.List;

public interface LecturerRepository {

    List<Lecturer> getAllByNameOrLastname(String name);

}
